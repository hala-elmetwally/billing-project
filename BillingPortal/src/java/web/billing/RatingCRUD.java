package web.billing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mayada
 */
public class RatingCRUD {

    static public ResultSet selectAllRatings() {
        try {
            ConnectDataBase.state = ConnectDataBase.connection.createStatement();
            ConnectDataBase.sqlCommand = "SELECT * FROM rating";
            ConnectDataBase.result = ConnectDataBase.state.executeQuery(ConnectDataBase.sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(RatingCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ConnectDataBase.result;
    }
    
    static public ResultSet selectServicesRatingForProfile(int prof_id) {
        try {
            ConnectDataBase.state = ConnectDataBase.connection.createStatement();
            ConnectDataBase.sqlCommand = "SELECT * FROM rating WHERE profile_id="+prof_id;
            ConnectDataBase.result = ConnectDataBase.state.executeQuery(ConnectDataBase.sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(RatingCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ConnectDataBase.result;
    }

    //insert new rating means insert new service in profile (table prof_service)
    static public int insertNewRating(int service_id, int profile_id, String fees_on_net, String fees_cross_net, int quota_same_op, int quota_diff_op, int quota_inter, String fees_inter) {
        int rows = 0;
        try {
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("INSERT INTO rating(service_id,profile_id,fees_on_net,fees_cross_net,quota_same_op,quota_diff_op,quota_inter,fees_inter)VALUES (?,?,?,?,?,?,?,?)");
            
            ConnectDataBase.pstat.setInt(1, service_id);
            ConnectDataBase.pstat.setInt(2, profile_id);
            ConnectDataBase.pstat.setString(3, fees_on_net);
            ConnectDataBase.pstat.setString(4, fees_cross_net);
            ConnectDataBase.pstat.setInt(5, quota_same_op);
            ConnectDataBase.pstat.setInt(6, quota_diff_op);
            ConnectDataBase.pstat.setInt(7, quota_inter);
            ConnectDataBase.pstat.setString(8, fees_inter);
            rows = ConnectDataBase.pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RatingCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }

    static public int deleteRating(int serv_id, int prof_id) {
        int rows = 0;
        try {
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("DELETE FROM rating WHERE serv_id=? AND prof_id=?;");
            ConnectDataBase.pstat.setInt(1, serv_id);
            ConnectDataBase.pstat.setInt(2, prof_id);
            rows = ConnectDataBase.pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RatingCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }

//    static public int UpdateRating(int id) {
//        int rows = 0;
//        try {
//            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("UPDATE rating SET =? WHERE =?;");
//            ConnectDataBase.pstat.setInt(1, id);
//            rows = ConnectDataBase.pstat.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(RatingCRUD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return rows;
//    } 
}
