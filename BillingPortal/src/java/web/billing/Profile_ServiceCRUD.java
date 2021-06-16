package web.billing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mayada
 */
public class Profile_ServiceCRUD {

    static public ResultSet selectAllServicesForProfile(int prof_id) {
        try {
            ConnectDataBase.state = ConnectDataBase.connection.createStatement();
            ConnectDataBase.sqlCommand = "SELECT * FROM prof_service WFERE profile_id="+prof_id;
            ConnectDataBase.result = ConnectDataBase.state.executeQuery(ConnectDataBase.sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(Profile_ServiceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ConnectDataBase.result;
    }

    static public int insertNewServiceToProfile(int service_id, int profile_id) {
        int rows = 0;
        try {
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("INSERT INTO prof_service(servic_id,profile_id)VALUES (?,?)");
            ConnectDataBase.pstat.setInt(1, service_id);
            ConnectDataBase.pstat.setInt(2, profile_id);
           
            rows = ConnectDataBase.pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Profile_ServiceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }

    static public int deleteServiceFromProfile(int service_id, int profile_id) {
        int rows = 0;
        try {
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("DELETE FROM prof_service WHERE servic_id=? AND profile_id=?;");
            ConnectDataBase.pstat.setInt(1, service_id);
            ConnectDataBase.pstat.setInt(2, profile_id);
            rows = ConnectDataBase.pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Profile_ServiceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }

}
