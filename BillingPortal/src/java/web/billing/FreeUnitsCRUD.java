package web.billing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mayada
 */
public class FreeUnitsCRUD {
    
      static public ResultSet selectAllFreeUnits() {
        try {
            ConnectDataBase.state = ConnectDataBase.connection.createStatement();
            ConnectDataBase.sqlCommand = "SELECT * FROM free_units";
            ConnectDataBase.result = ConnectDataBase.state.executeQuery(ConnectDataBase.sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(FreeUnitsCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ConnectDataBase.result;
    }

    static public int insertFreeUnit(int call_units_onnet,int call_units_crossnet,int sms_onnet,int sms_crossnet,int data_units,int profil_id) {
        int rows = 0;
        try {
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("INSERT INTO free_units(call_units_onnet,call_units_crossnet,sms_onnet,sms_crossnet,data_units,profil_id)VALUES (?,?,?,?,?,?)");
            ConnectDataBase.pstat.setInt(1, call_units_onnet);
            ConnectDataBase.pstat.setInt(2, call_units_crossnet);
            ConnectDataBase.pstat.setInt(3, sms_onnet);
            ConnectDataBase.pstat.setInt(4, sms_crossnet);
            ConnectDataBase.pstat.setInt(5, data_units);
            ConnectDataBase.pstat.setInt(6, profil_id);
            rows = ConnectDataBase.pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FreeUnitsCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }
    
    static public int deleteFreeUnit(int id) {
        int rows = 0;
        try {
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("DELETE FROM free_units WHERE free_id=?;");
            ConnectDataBase.pstat.setInt(1, id);
            rows = ConnectDataBase.pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FreeUnitsCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }
    
//    static public int UpdateFreeUnit(int id) {
//        int rows = 0;
//        try {
//            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("UPDATE free_units SET e=? WHERE free_id=?;");
//            ConnectDataBase.pstat.setInt(1, id);
//            rows = ConnectDataBase.pstat.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(FreeUnitsCRUD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return rows;
//    }
}
