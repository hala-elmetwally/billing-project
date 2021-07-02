/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package cdrparser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bn.CoderFactory;
import org.bn.IDecoder;

/**
 *
 * @author Mayada
 */
public class CDRParser {
    
    private static final String url = "jdbc:postgresql://batyr.db.elephantsql.com:5432/prkwfnoy";
    private static final String user = "prkwfnoy";
    private static final String password = "tsrl2sOlkZwBDmAX4xDVdo3v6VCyVio9";

    public static Connection connection = null;
    public static PreparedStatement preparedStatment = null;
    public static ResultSet result = null;
    public static PreparedStatement pstat;
    public static String sqlCommand;
    public static Statement state;
    public static String calling_no;
    public static String called_no;
    public static String cdr_date;
    public static String consumption;
    public static String start_time;
    public static String service_id; 
    public static String profile_id;
    public static String call_duration;

    public static void main(String[] args) {
        
        connect();
        final File folder = new File("D:\\biliingproj\\hala\\web\\CDR_uploads\\");
        listFilesForFolder(folder);
        while(true){
        File[] directoryListing = folder.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                System.out.println("Start Decoding.................");
                cdrDecoded(child.toString());
                insertCdr(calling_no,called_no,cdr_date,Integer.parseInt(consumption),
                        start_time,Integer.parseInt(service_id),Integer.parseInt(profile_id),Integer.parseInt(call_duration),0);
                changePathForFolder(child);
                System.out.println("---------------------------------------");
            }
        }
        
        }

    }
    
    
        public static void changePathForFolder(final File folder) {
            if (!folder.isDirectory()) {
                File destination = new File("D:\\biliingproj\\hala\\web\\CDR_archive\\" + folder.getName());
                //System.out.println(destination.exists());
                if (!destination.exists()) {
                    folder.renameTo(destination);
                }
            }
        
    }

    public static void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }
    
    public static void connect() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Postgres is made successfully");
        } catch (SQLException ex) {
            Logger.getLogger(CDRParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static void cdrDecoded(String  filePath) {
             
        try {  
            IDecoder decoder = CoderFactory.getInstance().newDecoder("BER");
            FileInputStream fis= new FileInputStream(filePath);
            com.iti.CDR CDRdecoded = decoder.decode(fis, com.iti.CDR.class);
            //System.out.print(CDRdecoded.getCdrId()+"\n");
            System.out.print("CallingNo: "+CDRdecoded.getCalledNo()+"\n");
            System.out.print("CalledNo: "+CDRdecoded.getCallingNo()+"\n");
            System.out.print("CallDuration: "+CDRdecoded.getCallDuration()+"\n");
            System.out.print("CdrDate: "+CDRdecoded.getCdrDate()+"\n");
            System.out.print("Consumption: "+CDRdecoded.getConsumption()+"\n");
            System.out.print("ProfileId: "+CDRdecoded.getProfileId()+"\n");
            System.out.print("ServiceId: "+CDRdecoded.getServiceId()+"\n");
            System.out.print("StartTime: "+CDRdecoded.getStartTime()+"\n");
            
            calling_no = CDRdecoded.getCallingNo();
            called_no = CDRdecoded.getCalledNo();
            cdr_date = CDRdecoded.getCdrDate();
            consumption = CDRdecoded.getConsumption();
            start_time = CDRdecoded.getStartTime();
            service_id = CDRdecoded.getServiceId();
            profile_id = CDRdecoded.getProfileId();
            call_duration = CDRdecoded.getCallDuration();
            fis.close();
            
        } catch (Exception ex) {
            Logger.getLogger(CDRParser.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
        
        static public int insertCdr(String calling_no,String called_no, String cdr_date,int consumption,String start_time,int service_id,int profile_id,int call_duration,int rateFlag) {
        int rows = 0;
        try {
            pstat = connection.prepareStatement("INSERT INTO cdr(calling_no,called_no,cdr_date,"
                    + "consumption,start_time,service_id,profile_id,call_duration,is_rated)VALUES (?,?,?,?,?,?,?,?,?)");
            pstat.setString(1, calling_no);
            pstat.setString(2, called_no);
            pstat.setString(3, cdr_date);
            pstat.setInt(4, consumption);
            pstat.setString(5, start_time);
            pstat.setInt(6, service_id);
            pstat.setInt(7, profile_id);
            pstat.setInt(8, call_duration);
            pstat.setInt(9, rateFlag);
            rows = pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CDRParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }

        

}

