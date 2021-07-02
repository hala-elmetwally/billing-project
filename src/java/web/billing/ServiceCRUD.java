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
            ConnectDataBase.sqlCommand = "SELECT * FROM service ORDER BY serv_id";
            ConnectDataBase.result = ConnectDataBase.state.executeQuery(ConnectDataBase.sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ConnectDataBase.result;
    }

  
    static public int insertService(String name) {
        int ser_id = 0;
        try {
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("INSERT INTO service(name)VALUES (?)");
            ConnectDataBase.pstat.setString(1, name);
            ConnectDataBase.pstat.executeUpdate();
            
            ConnectDataBase.state = ConnectDataBase.connection.createStatement();
            ConnectDataBase.sqlCommand = "SELECT * FROM service ORDER BY serv_id DESC LIMIT 1";
            ConnectDataBase.result = ConnectDataBase.state.executeQuery(ConnectDataBase.sqlCommand);
            while (ConnectDataBase.result.next()) {
                ser_id = ConnectDataBase.result.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ser_id;
    }

    static public String deleteService(int id) {
        String checkProfileService = "";
        try {
            ConnectDataBase.state = ConnectDataBase.connection.createStatement();
            ConnectDataBase.sqlCommand = "SELECT * FROM prof_service WHERE servic_id=" + id;
            ConnectDataBase.result = ConnectDataBase.state.executeQuery(ConnectDataBase.sqlCommand);
            if (ConnectDataBase.result.next()) {
                checkProfileService = "Failed";
            } else {
                ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("DELETE FROM service WHERE serv_id=?;");
                ConnectDataBase.pstat.setInt(1, id);
                ConnectDataBase.pstat.executeUpdate();
                checkProfileService = "done";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return checkProfileService;
    }
    
     static public String getServiceName(int id) {
        String name = "";
        try {
            ConnectDataBase.state = ConnectDataBase.connection.createStatement();
            ConnectDataBase.sqlCommand = "SELECT * FROM service WHERE serv_id =" + id;
            ConnectDataBase.result = ConnectDataBase.state.executeQuery(ConnectDataBase.sqlCommand);
            while (ConnectDataBase.result.next()) {
                name = ConnectDataBase.result.getString(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
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
