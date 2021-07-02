/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.billing;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mayada
 */
public class SignInCheck {
    
     static public String checkSiginIn(String name, String password) {
        String checkFlag = "";
            try {
                ConnectDataBase.state = ConnectDataBase.connection.createStatement();
                ConnectDataBase.sqlCommand = "SELECT * from customer";
                ConnectDataBase.result = ConnectDataBase.state.executeQuery(ConnectDataBase.sqlCommand);
                while (ConnectDataBase.result.next()) {
                    if (ConnectDataBase.result.getString(8).equals(name) && ConnectDataBase.result.getString(9).equals(password)){
                    if (ConnectDataBase.result.getInt(10)==1) {
                        checkFlag = "admin";
                    }
                    else if ( ConnectDataBase.result.getInt(10)==0) {
                        checkFlag = "user";
                        
                    }
                    else
                        checkFlag = "false";
                }   }
            } catch (SQLException ex) {
                Logger.getLogger(SignInCheck.class.getName()).log(Level.SEVERE, null, ex);
            }
           System.out.println(checkFlag);
           System.out.println(name);
           System.out.println(password);
        return checkFlag;
    }
   
      static public int getCustomerID(String name, String password) {
        int id = 0;
            try {
                ConnectDataBase.state = ConnectDataBase.connection.createStatement();
                ConnectDataBase.sqlCommand = "SELECT * from customer";
                ConnectDataBase.result = ConnectDataBase.state.executeQuery(ConnectDataBase.sqlCommand);
                while (ConnectDataBase.result.next()) {
                    if (ConnectDataBase.result.getString(8).equals(name) && ConnectDataBase.result.getString(9).equals(password)){
                   
                     if ( ConnectDataBase.result.getInt(10)==0) {
                        id = ConnectDataBase.result.getInt(1);
                        
                    }
                   
                }   }
            } catch (SQLException ex) {
                Logger.getLogger(SignInCheck.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        return id;
    }
      static public String getCustomerName(String name, String password) {
        String comp_name = "";
            try {
                ConnectDataBase.state = ConnectDataBase.connection.createStatement();
                ConnectDataBase.sqlCommand = "SELECT * from customer";
                ConnectDataBase.result = ConnectDataBase.state.executeQuery(ConnectDataBase.sqlCommand);
                while (ConnectDataBase.result.next()) {
                    if (ConnectDataBase.result.getString(8).equals(name) && ConnectDataBase.result.getString(9).equals(password)){
                   
                     if ( ConnectDataBase.result.getInt(10)==0) {
                        comp_name = ConnectDataBase.result.getString(3);
                        
                    }
                   
                }   }
            } catch (SQLException ex) {
                Logger.getLogger(SignInCheck.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        return comp_name;
    }
}
