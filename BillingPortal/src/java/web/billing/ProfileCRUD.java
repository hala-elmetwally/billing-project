package web.billing;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mayada
 */
public class ProfileCRUD {
      static public ResultSet selectAllProfiles() {
        try {
            ConnectDataBase.state = ConnectDataBase.connection.createStatement();
            ConnectDataBase.sqlCommand = "SELECT * FROM profile";
            ConnectDataBase.result = ConnectDataBase.state.executeQuery(ConnectDataBase.sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ConnectDataBase.result;
    }

    static public int insertProfile(String name,String renew_date) {
        int rows = 0;
        try {
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("INSERT INTO profile(name,renew_date)VALUES (?,?)");

            Date date = Date.valueOf(renew_date);
            ConnectDataBase.pstat.setString(1, name);
            ConnectDataBase.pstat.setDate(2,date);
            
            rows = ConnectDataBase.pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }
    // we must check all customers don't use this profile
    static public int deleteProfile(int id) {
        int rows = 0;
        try {
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("DELETE FROM profile WHERE prof_id=?;");
            ConnectDataBase.pstat.setInt(1, id);
            rows = ConnectDataBase.pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfileCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }
    
//    static public int UpdateProfile(int id, String ratePlan) {
//        int rows = 0;
//        try {
//            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("UPDATE profile SET =? WHERE prof_id=?;");
//            ConnectDataBase.pstat.setInt(1, id);
//            rows = ConnectDataBase.pstat.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(ProfileCRUD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return rows;
//    }
    
}
