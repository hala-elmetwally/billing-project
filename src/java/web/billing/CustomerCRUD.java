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

    static public ResultSet selectCustomer(int id) {
        try {
            ConnectDataBase.state = ConnectDataBase.connection.createStatement();
            ConnectDataBase.sqlCommand = "SELECT * FROM customer WHERE cust_id=" + id;
            ConnectDataBase.result = ConnectDataBase.state.executeQuery(ConnectDataBase.sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ConnectDataBase.result;
    }

    static public int insertCustomer(String email, String name, String msisdn, String imsi, String address, int profile_id, String username, String passwrd, int flag, int renew) {
        int cust_id = 0;
        try {
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("INSERT INTO customer(email,password,msisdn,imsi,address,profile_id,name,username,adminFlag,renewday)VALUES (?,?,?,?,?,?,?,?,?,?)");
//           ConnectDataBase.pstat.setString(1, "DEFAULT");
            ConnectDataBase.pstat.setString(1, email);
            ConnectDataBase.pstat.setString(2, name);
            ConnectDataBase.pstat.setString(3, msisdn);
            ConnectDataBase.pstat.setString(4, imsi);
            ConnectDataBase.pstat.setString(5, address);
            ConnectDataBase.pstat.setInt(6, profile_id);
            ConnectDataBase.pstat.setString(7, username);
            ConnectDataBase.pstat.setString(8, passwrd);
            ConnectDataBase.pstat.setInt(9, flag);
            ConnectDataBase.pstat.setInt(10, renew);
            ConnectDataBase.pstat.executeUpdate();

            ConnectDataBase.state = ConnectDataBase.connection.createStatement();
            ConnectDataBase.sqlCommand = "SELECT * FROM customer ORDER BY cust_id DESC LIMIT 1";
            ConnectDataBase.result = ConnectDataBase.state.executeQuery(ConnectDataBase.sqlCommand);
            while (ConnectDataBase.result.next()) {
                cust_id = ConnectDataBase.result.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cust_id;
    }

    static public int deleteCustomer(int id) {
        int rows = 0;
        try {
            // delete from free_units at first ..
            ConnectDataBase.pstat= ConnectDataBase.connection.prepareStatement("DELETE FROM free_units WHERE customer_id=?;");
            ConnectDataBase.pstat.setInt(1, id);
             rows = ConnectDataBase.pstat.executeUpdate();
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("DELETE FROM customer WHERE cust_id=?;");
            ConnectDataBase.pstat.setInt(1, id);
            rows = ConnectDataBase.pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }

    static public int UpdateCustomer(int id, String email, String name, String msisdn, String imsi, String address, int profile_id, String username, String passwrd, int flag, int renew) {
        int rows = 0;
        int cust_id = 0;
        try {
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("UPDATE customer SET email=?,password=?,msisdn=?,imsi=?,address=?,profile_id=?,name=?,username=?,adminFlag=?,renewday=? WHERE cust_id=?;");
            ConnectDataBase.pstat.setString(1, email);
            ConnectDataBase.pstat.setString(2, passwrd);
            ConnectDataBase.pstat.setString(3, msisdn);
            ConnectDataBase.pstat.setString(4, imsi);
            ConnectDataBase.pstat.setString(5, address);
            ConnectDataBase.pstat.setInt(6, profile_id);
            ConnectDataBase.pstat.setString(7, name);
            ConnectDataBase.pstat.setString(8,username);
            ConnectDataBase.pstat.setInt(9, flag);
            ConnectDataBase.pstat.setInt(10, renew);
            ConnectDataBase.pstat.setInt(11, id);
            rows = ConnectDataBase.pstat.executeUpdate();

            ConnectDataBase.state = ConnectDataBase.connection.createStatement();
            ConnectDataBase.sqlCommand = "SELECT * FROM customer ORDER BY cust_id DESC LIMIT 1";
            ConnectDataBase.result = ConnectDataBase.state.executeQuery(ConnectDataBase.sqlCommand);
            while (ConnectDataBase.result.next()) {
                cust_id = ConnectDataBase.result.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cust_id;
    }
}
