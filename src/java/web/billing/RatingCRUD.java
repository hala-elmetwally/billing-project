package web.billing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
            ConnectDataBase.sqlCommand = "SELECT * FROM rating WHERE profile_id="+prof_id +"ORDER BY service_id";
            ConnectDataBase.result = ConnectDataBase.state.executeQuery(ConnectDataBase.sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(RatingCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ConnectDataBase.result;
    }

    //insert new rating means insert new service in profile (table prof_service)
    static public int insertNewRating(int service_id, int profile_id, float fees_on_net, float fees_cross_net, float fees_inter) {
        int rows = 0;
        try {
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("INSERT INTO rating(service_id,profile_id,fees_on_net,fees_cross_net,fees_inter)VALUES (?,?,?,?,?)");
            DecimalFormat df = new DecimalFormat("###.##");
            ConnectDataBase.pstat.setInt(1, service_id);
            ConnectDataBase.pstat.setInt(2, profile_id);
            ConnectDataBase.pstat.setFloat(3, fees_on_net);
            ConnectDataBase.pstat.setFloat(4, fees_cross_net);
            ConnectDataBase.pstat.setFloat(5, fees_inter);
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

    static public int UpdateRating(int ser_id , int prof_id ,float onNet,float crossNet,float inter ) {
        int rows = 0;
        try {
            ConnectDataBase.pstat = ConnectDataBase.connection.prepareStatement("UPDATE rating SET fees_on_net=?,fees_cross_net=?,fees_inter=? WHERE service_id=? AND profile_id=?;");
            ConnectDataBase.pstat.setFloat(1, onNet);
            ConnectDataBase.pstat.setFloat(2, crossNet);
            ConnectDataBase.pstat.setFloat(3, inter);
            ConnectDataBase.pstat.setInt(4, ser_id);
            ConnectDataBase.pstat.setInt(5, prof_id);
            rows = ConnectDataBase.pstat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RatingCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    } 
}
