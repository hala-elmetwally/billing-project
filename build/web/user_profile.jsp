<%-- 
    Document   : display_services
    Created on : Jun 16, 2021, 12:32:15 AM
    Author     : New
--%>


<%@page import="web.billing.ConnectDataBase"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%--<%@include file="header.html"%>--%>
               
              
<link rel="stylesheet" href="main_menu.css">
  <% String uName = request.getParameter("Name"); %>
<%
try {
    String customer_id=request.getParameter("id");
//    String driver = "org.postgresql.Driver";
//    String url = "jdbc:postgresql://batyr.db.elephantsql.com:5432/prkwfnoy";
//    String username = "prkwfnoy";
//    String password = "tsrl2sOlkZwBDmAX4xDVdo3v6VCyVio9";
//    String myDataField = null;
    String myQuery = "select * from invoice where customer_id="+customer_id;
//    Connection myConnection = null;
    PreparedStatement myPreparedStatement = null;
//    ResultSet myResultSet = null;
//    Class.forName(driver).newInstance();
//    myConnection = DriverManager.getConnection(url,username,password);
    System.out.println("Opened database successfully");
    myPreparedStatement = ConnectDataBase.connection.prepareStatement(myQuery);
    ResultSet rs = myPreparedStatement.executeQuery();

    ResultSetMetaData rsmd = rs.getMetaData();
    int  totalColumn = rsmd.getColumnCount();


   // out.println(" <table border='2'    style='border-collapse:collapse;  width='70%'  text-align: 'center' margin:'25px 100px 200px 100px'>");
   // out.println("<tr  style=\"text-align:center;\";>");

//    for(int i=1;i<=totalColumn;i++)
//    {
//        String columnName = rsmd.getColumnName(i);
//        out.println("<th>"+columnName+"</th>");
//    }
%>
<img class="orange" src="e4.jpg" onclick="javascript:location.href='user_login.jsp?id=<%= customer_id %>'" width="120" height="120" alt="logo-etisalat">
 <%
 out.println("<h1    style=\"width: 900px;   text-align:center;  font-size: 45px;  margin-top:-30px; margin-left:200px; margin-bottom:100px; color:greenyellow; font-family:sans-serif; text-shadow: 0 2px white, 0 3px #777; \"  ; >Customer Invoice </h1>");
    
    
    out.println("<table border=\"2\" style=\"border-collapse:collapse; width=50%; text-align:center; padding:80px; "
            + "color:yellowgreen; margin-left:5px; margin-top:30px;  \"; >");
 
 
        out.println("<tr ><th style=\"padding:20px; padding-left:-5px; font-size:20px;font-family:sans-serif;\";>Name</th><th style=\"padding:40px;font-size:20px;font-family:sans-serif;\";>Voice Unit</th>"
                + "<th style=\" padding:20px; font-size:20px;font-family:sans-serif;\";>SMS Unit</th><th style=\" padding:20px; font-size:20px;font-family:sans-serif;\";>Data Unit</th>"
                + "<th style=\" padding:20px; font-size:20px;font-family:sans-serif;\";>Total Cost</th><th style=\" padding:20px; font-size:20px;font-family:sans-serif;\";>Bill Day Generation</th><th style=\" padding:5px; font-size:20px;font-family:sans-serif;\";>Download</th> " 
           
             
             
            + "</tr >");


    out.println("</tr>");

    while(rs.next())
    {    
        out.println("<tr  style=\"text-align:center; font-size:20px;\";>");
        for(int col=1;col<=totalColumn;col++)
        {  if(col==8){
        %>
        <td><input type="button" value="Download Invoice" style="background-color:  greenyellow; color: black; width: 200px; cursor:pointer; margin-left: 45px;  "   ></td></tr>
<%
        }
           else if(col != 1 ){
            Object obj= rs.getObject(col);                    
            out.println("<td  style=\"padding:50px;\";>"+ String.valueOf(obj) +"</td>");
        } 
        }
        out.println("</tr >");
    }
    out.println("</table>");

}
//catch(ClassNotFoundException e){
//    e.printStackTrace();
//}
catch (SQLException ex) {
    out.print("SQLException: "+ex.getMessage());
    out.print("SQLState: " + ex.getSQLState());
    out.print("VendorError: " + ex.getErrorCode());
}
%>
<footer >
    <p style="color: greenyellow ; font-size :25px; margin-top: 120px; margin-left: 20px; font-family: ">Welcome ${Name}   </p>
</footer>