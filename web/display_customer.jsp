<%-- 
    Document   : display_customer
    Created on : Jun 16, 2021, 12:17:54 AM
    Author     : New
--%>
<%@page import="web.billing.ProfileCRUD"%>
<%@page import="web.billing.CustomerCRUD"%>


 <link rel="stylesheet" href="main_menu.css">

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@include file="header.html"%>

<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <title>Customer Edit</title>
        <link rel="stylesheet" href="admin.css">
    
    </head>
    <body>-->
<%
    String username = request.getParameter("Name");
    String customerID = request.getParameter("id");
    if(customerID != null){
        CustomerCRUD.deleteCustomer(Integer.parseInt(customerID));
    }

    ResultSet rs = CustomerCRUD.selectAllCustomers();

    ResultSetMetaData rsmd = rs.getMetaData();
    int  totalColumn = rsmd.getColumnCount();

 out.println("<h1    style=\"width: 900px;   text-align:center;  font-size: 45px;  margin-top:-50px; margin-left:200px; margin-bottom:100px; color:greenyellow; font-family:sans-serif; text-shadow: 0 2px white, 0 3px #777; \"  ; >Display Customer </h1>");%>
  <table border="2"   style="border-collapse:collapse;  margin-left:40px; width:10%; margin-bottom:10px; color:yellowgreen; margin-top:30px; text-align:center; ">
   <% out.println("<tr style=\"text-align:center;\";>");
     out.println("<tr ><th style=\"padding:15px;font-size:20px;font-family:sans-serif;\";>Email</th><th style=\"padding:80px;font-size:20px;font-family:sans-serif;\";>Name</th>"
            + "<th style=\"padding:30px;font-size:20px;font-family:sans-serif;\";>Msisdn</th>"
             + "<th style=\"padding:30px;font-size:20px;font-family:sans-serif;\";>Address</th><th style=\"padding:20px;  padding-left:15px; white-space:nowrap;  font-size:20px;font-family:sans-serif;\";> Profile Name</th>"
             + "<th style=\"font-size:20px;font-family:sans-serif;white-space:nowrap; padding:20px;\";> Renew Day</th><th style=\"font-size:20px;font-family:sans-serif; width:3px;\";>Edit Or Delete</th>"
            + "</tr >");

//    for(int i=1;i<=totalColumn;i++)
//    {
//        String columnName = rsmd.getColumnName(i);
//        out.println("<th style=\"padding:10px;font-size:20px;font-family:sans-serif;\";>"+columnName+" </th>");
//    } 
//   out.println("<th style=\"font-size:20px;font-family:sans-serif;\";> Delete</th>");
    out.println("</tr>");

    while(rs.next())
    {    
        out.println("<tr style=\"text-align:center;\";>");
        for(int col=1;col<=totalColumn;col++)
           
        { 
            if(col ==7){
         ResultSet rs1 = ProfileCRUD.selectProfile(Integer.parseInt(String.valueOf(rs.getObject(col))));
         rs1.next();
          String  profile_name = String.valueOf(rs1.getObject(2));
          out.println("<td style=\"width:100px;\">"+ profile_name +"</td>");
         }
           else if(col != 1 &&col != 5 && col != 9 && col !=8&& col !=10){
                
                
           
            
            Object obj= rs.getObject(col);                    
            out.println("<td style=\"width:100px;\">"+ String.valueOf(obj) +"</td>");
                    
         }   
        }
            String id = String.valueOf(rs.getObject(1));        
            out.println("<td>");        
         
        
         %>
         
     
         <input type="button" value="Delete" style="background-color:  greenyellow; color: black; width:200px; cursor:pointer; margin-left: 29px;  " onclick="location.href = 'display_customer.jsp?id=<%=id%>'">
         <input type="button" value="Edit" style="background-color:  greenyellow; color: black; width: 200px; cursor:pointer; margin-left: 29px;  "onclick="location.href = 'EditCustomer.jsp?id=<%=id%>'">

                    <% 
                        out.println("</td>");  
                        out.println("</tr>");
    }




    out.println("</table>");

%>


<footer > 
    <p style="color: greenyellow ; font-size :25px;   font-family:  sans-serif;" >Welcome ${Name}   </p>
</footer>

<!--
 </body>
</html>-->