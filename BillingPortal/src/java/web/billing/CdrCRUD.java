package web.billing;

import java.sql.Date;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mayada
 */
public class CdrCRUD {

    static public ResultSet selectAllCDRs() {
        try {
            ConnectDataBase.state = ConnectDataBase.connection.createStatement();
            ConnectDataBase.sqlCommand = "SELECT * FROM cdr";
            ConnectDataBase.result = ConnectDataBase.state.executeQuery(ConnectDataBase.sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(CdrCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ConnectDataBase.result;
    }

    static public int insertCdr(int calling_no,int called_no, String cdr_date,int consumption,String start_time,int service_id,int profile_id,int call_duration) {
        int rows = 0;
        try {
            Time time = Time.valueOf(start_time);
            Date date = Date.valueOf(cdr_date);
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("INSERT INTO cdr(calling_no,called_no,cdr_date,consumption,start_time,service_id,profile_id,call_duration)VALUES (?,?,?,?,?,?,?,?)");
            //ConnectDataBase.pstat.setString(1, "DEFAULT");
            ConnectDataBase.pstat.setInt(1, calling_no);
            ConnectDataBase.pstat.setInt(2, called_no);
            ConnectDataBase.pstat.setDate(3, date);
            ConnectDataBase.pstat.setInt(4, consumption);
            ConnectDataBase.pstat.setTime(5, time);
            ConnectDataBase.pstat.setInt(6, service_id);
            ConnectDataBase.pstat.setInt(7, profile_id);
            ConnectDataBase.pstat.setInt(8, call_duration);
            rows = ConnectDataBase.pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CdrCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }

    static public int deleteCdr(int id) {
        int rows = 0;
        try {
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("DELETE FROM cdr WHERE cdr_id=?;");
            ConnectDataBase.pstat.setInt(1, id);
            rows = ConnectDataBase.pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CdrCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }

}
