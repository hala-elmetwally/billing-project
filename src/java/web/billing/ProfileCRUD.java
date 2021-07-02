package web.billing;

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
  static public ResultSet selectProfile(int id) {
        try {
            ConnectDataBase.state = ConnectDataBase.connection.createStatement();
            ConnectDataBase.sqlCommand = "SELECT * FROM profile WHERE prof_id=" + id;
            ConnectDataBase.result = ConnectDataBase.state.executeQuery(ConnectDataBase.sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ConnectDataBase.result;
    }

    static public String insertProfile(String name) {
        int rows = 0;
        String profID = "";
        try {
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("INSERT INTO profile(name)VALUES (?)");
            ConnectDataBase.pstat.setString(1, name);
            rows = ConnectDataBase.pstat.executeUpdate();
            
            ConnectDataBase.state = ConnectDataBase.connection.createStatement();
            ConnectDataBase.sqlCommand ="SELECT * FROM profile ORDER BY prof_id DESC LIMIT 1";
            ConnectDataBase.result = ConnectDataBase.state.executeQuery(ConnectDataBase.sqlCommand);
                while (ConnectDataBase.result.next()) {
                      profID = ConnectDataBase.result.getString(1);
                    }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return profID;
    }
    // we must check all customers don't use this profile
    static public String deleteProfile(int id) {
        String checkCustomerProfile = "";
        try {
            ConnectDataBase.state = ConnectDataBase.connection.createStatement();
            ConnectDataBase.sqlCommand = "SELECT * FROM customer WHERE profile_id="+id;
            ConnectDataBase.result = ConnectDataBase.state.executeQuery(ConnectDataBase.sqlCommand);
            if (ConnectDataBase.result.next()){
                checkCustomerProfile = "Failed";
            }
            else{
            
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("DELETE FROM prof_service WHERE profile_id=?;");
            ConnectDataBase.pstat.setInt(1, id);
            ConnectDataBase.pstat.executeUpdate();
            
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("DELETE FROM prof_service WHERE profile_id=?;");
            ConnectDataBase.pstat.setInt(1, id);
            ConnectDataBase.pstat.executeUpdate();
            
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("DELETE FROM rating WHERE profile_id=?;");
            ConnectDataBase.pstat.setInt(1, id);
            ConnectDataBase.pstat.executeUpdate();
            
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("DELETE FROM profile WHERE prof_id=?;");
            ConnectDataBase.pstat.setInt(1, id);
            ConnectDataBase.pstat.executeUpdate();
            checkCustomerProfile = "done";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(checkCustomerProfile);
        return checkCustomerProfile;
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
