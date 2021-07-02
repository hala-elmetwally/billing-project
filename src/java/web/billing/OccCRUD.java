package web.billing;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OccCRUD {
     static public int insertOCC(int customer_id, String service_name, int cost , int  month) {
        int cust_id = 0;
        try {
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("INSERT INTO occ(customer_id,service_name,cost,month_no)VALUES (?,?,?,?)");
            ConnectDataBase.pstat.setInt(1, customer_id);
            ConnectDataBase.pstat.setString(2, service_name);
            ConnectDataBase.pstat.setInt(3, cost);
            ConnectDataBase.pstat.setInt(4, month);
            ConnectDataBase.pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cust_id;
    }
}
