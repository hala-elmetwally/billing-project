<%-- 
    Document   : display_customer
    Created on : Jun 16, 2021, 12:17:54 AM
    Author     : New
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%
try {
    String driver = "org.postgresql.Driver";
    String url = "jdbc:postgresql://batyr.db.elephantsql.com:5432/prkwfnoy";
    String username = "prkwfnoy";
    String password = "tsrl2sOlkZwBDmAX4xDVdo3v6VCyVio9";
    String myDataField = null;
    String myQuery = "select * from customer;";
    Connection myConnection = null;
    PreparedStatement myPreparedStatement = null;
    ResultSet myResultSet = null;
    Class.forName(driver).newInstance();
    myConnection = DriverManager.getConnection(url,username,password);
    System.out.println("Opened database successfully");
    myPreparedStatement = myConnection.prepareStatement(myQuery);
    ResultSet rs = myPreparedStatement.executeQuery();

    ResultSetMetaData rsmd = rs.getMetaData();
    int  totalColumn = rsmd.getColumnCount();


    out.println("<table border='1' style='border-collapse:collapse'>");
    out.println("<tr>");

    for(int i=1;i<=totalColumn;i++)
    {
        String columnName = rsmd.getColumnName(i);
        out.println("<th>"+columnName+"</th>");
    }
    out.println("</tr>");

    while(rs.next())
    {    
        out.println("<tr>");
        for(int col=1;col<=totalColumn;col++)
        {            
            Object obj= rs.getObject(col);                    
            out.println("<td>"+ String.valueOf(obj) +"</td>");
        } 
        out.println("</tr>");
    }
    out.println("</table>");

}
catch(ClassNotFoundException e){
    e.printStackTrace();
}
catch (SQLException ex) {
    out.print("SQLException: "+ex.getMessage());
    out.print("SQLState: " + ex.getSQLState());
    out.print("VendorError: " + ex.getErrorCode());
}
%>