/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.billing;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aya
 */
public class login extends HttpServlet {

  Connection c = null;
    PreparedStatement ps;
    String URL = "jdbc:postgresql://batyr.db.elephantsql.com:5432/prkwfnoy"; 
    String uname;
    String password;
    ResultSet result = null;
    HttpSession session=null;

@Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      uname = request.getParameter("Name");
      password = request.getParameter("password");
        try{
           Class.forName("org.postgresql.Driver");
            session=request.getSession(false);
            c = DriverManager.getConnection(URL,"prkwfnoy","tsrl2sOlkZwBDmAX4xDVdo3v6VCyVio9");
            
           ps = c.prepareStatement("select * from users  ",
                    ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, uname);
            ps.setString(2, password);
            result = ps.executeQuery();
            System.out.println("start");
            if(result.next())
            {
                if(result.getString("uname").equals(uname) && result.getString("password").equals(password))
                {            
                    session = request.getSession(true);
                    session.setAttribute("loginState", "true");
                    session.setAttribute("Name",uname);
                     System.out.println("yes");
                    response.sendRedirect("Admin_Page.jsp");
                }
            }
            else
            {
               /// session.setAttribute("loginState", "false");
                System.out.println("no");
                response.sendRedirect("display_customer.jsp");           
            }
                         
            ps.close();
            c.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("failed");
        }
    
    }

}
