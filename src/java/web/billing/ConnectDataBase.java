package web.billing;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application life cycle listener.
 *
 * @author Mayada
 */
public class ConnectDataBase implements ServletContextListener {

    private static final String url = "jdbc:postgresql://localhost:5432/billing";
    private static final String user = "postgres";
    private static final String password = "01118414865";
//    private static final String url = "jdbc:postgresql://batyr.db.elephantsql.com:5432/prkwfnoy";
//    private static final String user = "prkwfnoy";
//    private static final String password = "tsrl2sOlkZwBDmAX4xDVdo3v6VCyVio9";
    
    public static Connection connection = null;
    public static PreparedStatement preparedStatment = null;
    public static ResultSet result = null;
    public static PreparedStatement pstat;
    public static String sqlCommand;
    public static Statement state;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Postgres is made successfully");
//            ServiceCRUD.deleteService(5);
//            RatingCRUD.insertNewRating(4,1,"$0.14","$0.19",200,100,20,"$1.00");
//            ProfileCRUD.deleteProfile(2);
        } 
        catch (SQLException ex) {
            Logger.getLogger(ConnectDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            connection.close();
            System.out.println("Connection is closed successfully");
        } 
        catch (SQLException ex) {
            Logger.getLogger(ConnectDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
