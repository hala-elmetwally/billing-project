package web.billing;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mayada
 */
public class CustomerCRUD {

    static public ResultSet selectAllCustomers() {
        try {
            ConnectDataBase.state = ConnectDataBase.connection.createStatement();
            ConnectDataBase.sqlCommand = "SELECT * FROM customer";
            ConnectDataBase.result = ConnectDataBase.state.executeQuery(ConnectDataBase.sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ConnectDataBase.result;
    }

    static public int insertCustomer(String email , String name, long msisdn, long imsi, String address, int profile_id) {
        int rows = 0;
        try {
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("INSERT INTO customer(email,name,msisdn,imsi,address,profile_id)VALUES (?,?,?,?,?,?)");
            //ConnectDataBase.pstat.setString(1, "DEFAULT");
            ConnectDataBase.pstat.setString(1, email);
            ConnectDataBase.pstat.setString(2, name);
            ConnectDataBase.pstat.setLong(3, msisdn);
            ConnectDataBase.pstat.setLong(4, imsi);
            ConnectDataBase.pstat.setString(5, address);
            ConnectDataBase.pstat.setInt(6, profile_id);
            rows = ConnectDataBase.pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }
    
    static public int deleteCustomer(int id) {
        int rows = 0;
        try {
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("DELETE FROM customer WHERE cust_id=?;");
            ConnectDataBase.pstat.setInt(1, id);
            rows = ConnectDataBase.pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }
    
//    static public int UpdateCustomer(int id, String ratePlan) {
//        int rows = 0;
//        try {
//            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("UPDATE customer SET =? WHERE cust_id=?;");
//            ConnectDataBase.pstat.setInt(1, id);
//            rows = ConnectDataBase.pstat.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(CustomerCRUD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return rows;
//    }
}
