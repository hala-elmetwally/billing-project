package web.billing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mayada
 */
public class ServiceCRUD {
      static public ResultSet selectAllServices() {
        try {
            ConnectDataBase.state = ConnectDataBase.connection.createStatement();
            ConnectDataBase.sqlCommand = "SELECT * FROM service";
            ConnectDataBase.result = ConnectDataBase.state.executeQuery(ConnectDataBase.sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ConnectDataBase.result;
    }

    static public int insertService(String name) {
        int rows = 0;
        try {
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("INSERT INTO service(name)VALUES (?)");
            ConnectDataBase.pstat.setString(1, name);
            
            rows = ConnectDataBase.pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }
    
    static public int deleteService(int id) {
        int rows = 0;
        try {
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("DELETE FROM service WHERE serv_id=?;");
            ConnectDataBase.pstat.setInt(1, id);
            rows = ConnectDataBase.pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }
    
    // we must check all customers don't use this service
//    static public int UpdateCustomer(int id, String ratePlan) {
//        int rows = 0;
//        try {
//            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("UPDATE customer SET =? WHERE serv_id=?;");
//            ConnectDataBase.pstat.setInt(1, id);
//            rows = ConnectDataBase.pstat.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(CustomerCRUD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return rows;
//    }
}
