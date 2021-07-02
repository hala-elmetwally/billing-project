<%-- 
    Document   : display_services
    Created on : Jun 16, 2021, 12:32:15 AM
    Author     : New
--%>

<%@page import="web.billing.ServiceCRUD"%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@include file="header.html"%>
<link rel="stylesheet" href="main_menu.css">

 
<%
    String username = request.getParameter("Name");
    String profileID = request.getParameter("id");
    if (profileID != null) {
        String check = ServiceCRUD.deleteService(Integer.parseInt(profileID));
        if (!(check.equals("done"))) {
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('There are Profiles which use this service,\\nPlease edit profile first.\\nPress Ok to continue');");
            out.println("</script>");
        }
    }

    ResultSet rs = ServiceCRUD.selectAllServices();

    ResultSetMetaData rsmd = rs.getMetaData();
    int totalColumn = rsmd.getColumnCount();

   out.println("<h1    style=\"width: 900px;   text-align:center;  font-size: 45px;  margin-top:-70px; margin-left:200px; margin-bottom:70px; color:greenyellow; font-family:sans-serif; text-shadow: 0 2px white, 0 3px #777; \"  ; >Display Services </h1>");
    
    
    out.println("<table border=\"2\" style=\"border-collapse:collapse; padding:80px; color:yellowgreen; margin-left:330px; margin-bottom:90px; margin-top:120px; width:50% \"; >");
 
    out.println("<tr style=\"text-align:center;\";>");
        out.println("<tr ><th style=\"padding:40px; font-size:20px;font-family:sans-serif; white-space: nowrap;\";>Service ID</th><th style=\"padding:40px;font-size:20px;font-family:sans-serif; white-space: nowrap;\";>Service Name</th><th style=\"padding:20px; font-size:20px;font-family:sans-serif;\";>Delete</th>"
           
             
             
            + "</tr >");

//    for (int i = 1; i <= totalColumn; i++) {
//        String columnName = rsmd.getColumnName(i);
//        out.println("<th>" + columnName + "</th>");
//    }
  

    while (rs.next()) {
        out.println("<tr style=\"text-align:center; font-size:20px;\";>");
        for (int col = 1; col <= totalColumn; col++) {
            Object obj = rs.getObject(col);
            out.println("<td>" + String.valueOf(obj) + "</td>");
        }
        String id = String.valueOf(rs.getObject(1));
        out.println("<td>");
%>
 <input type="button" value="Delete"  style="background-color:  greenyellow; color: black; width: 200px; cursor:pointer; margin-left: 25px;  " onclick="location.href = 'display_services.jsp?id=<%=id%>'">
<%
            out.println("</td>");
            out.println("</tr>");
        }
        out.println("</table>");


%>
<!--<a href="Admin_Page.jsp" style="color: greenyellow; " >
    <img src="home.png" width="100px" height="100px"/>
            </a>-->
<footer >
 <p style="color: greenyellow ; font-size :25px; margin-top: -10px;  font-family:  sans-serif;" >Welcome ${Name}  </p>

 </footer>