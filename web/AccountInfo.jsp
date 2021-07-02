<%-- 
    Document   : user_login
    Created on : Jun 26, 2021, 3:46:08 AM
    Author     : Aya
--%>

<%@page import="web.billing.CustomerCRUD"%>
<%@page import="web.billing.ServiceCRUD"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="web.billing.ProfileCRUD"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="web.billing.RatingCRUD"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">

<% String name = request.getParameter("name");
      String id = request.getParameter("id");%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
        <link rel="stylesheet" href="admin.css">
        <link rel="stylesheet" href="main_menu.css">

    </head>
    <body>


        <img  src="e4.jpg" onclick="javascript:location.href='user_login.jsp?id=<%= id %>&name=<%=name%>'" style="margin-top:15px; margin-left: 40px;" width="120" height="120"  alt="logo-etisalat">

        <h1 class="admin_page" style=" margin-top:-45px; margin-left: 270px">User Page</h1>

        <%
    String username = request.getParameter("name");
    int customerID = Integer.parseInt(request.getParameter("id"));
    ResultSet rs3 = CustomerCRUD.selectCustomer(customerID);
    rs3.next();
    int profileID = rs3.getInt(7);
    if (profileID != 0) {
        RatingCRUD.selectServicesRatingForProfile(profileID);
    }

    ResultSet rs = RatingCRUD.selectServicesRatingForProfile(profileID);

    ResultSetMetaData rsmd = rs.getMetaData();
    int totalColumn = rsmd.getColumnCount();

    ResultSet rs1 = ProfileCRUD.selectProfile(profileID);
    rs1.next();
    String profile_name = rs1.getString(2);

   %>
%>
<h1    style="width: 900px;   text-align:center;  font-size: 45px;  margin-top:-50px; margin-left:260px; margin-bottom:15px; color:greenyellow; font-family:sans-serif; text-shadow: 0 2px white, 0 3px #777; "   ><%=rs3.getString(3)%></h1>
<h1    style="width: 900px;   text-align:center;  font-size: 45px;  margin-top:10px; margin-left:260px; margin-bottom:15px; color:greenyellow; font-family:sans-serif; text-shadow: 0 2px white, 0 3px #777; "   >Profile: <%=profile_name%></h1>"
<table border="2"  width="100%"  style="  border-collapse:collapse;  margin-left:370px; width:50%; margin-bottom:10px; color:yellowgreen;  text-align:center; ">
    <% out.println("<tr style=\"text-align:center; width:100%\";>");
        out.println("<tr ><th style=\"padding:20px; width:400px; font-size:20px;font-family:sans-serif;white-space:nowrap; \";>User Name</th><th style=\"padding:20px; width:400px; font-size:20px;font-family:sans-serif; white-space:nowrap;\";>Password</th>"
                + "<th style=\"padding:20px;width:400px; font-size:20px;font-family:sans-serif; white-space:nowrap;\";>Bill Cycle Day</th>"
                + "<th style=\"padding:20px;width:400px; font-size:20px;font-family:sans-serif; white-space:nowrap;\";>Email</th>" + "</tr >");%>


<td style="width:100px; padding-left:20px;padding-bottom:20px;padding-right:20px; padding-top:20px;"><%=rs3.getString(8)%></td>
<td style="width:100px; padding-left:20px;padding-bottom:20px;padding-right:20px; padding-top:20px;"><%=rs3.getString(9)%></td>
<td style="width:100px; padding-left:20px;padding-bottom:20px;padding-right:20px; padding-top:20px;"><%=rs3.getString(11)%></td>
<td style="width:100px; padding-left:20px;padding-bottom:20px;padding-right:20px; padding-top:20px;"><%=rs3.getString(2)%></td>
</table>

<table border="2"  width="100%"  style="  border-collapse:collapse;  margin-left:340px; width:50%; margin-bottom:5px; color:yellowgreen; margin-top:30px; text-align:center; ">
    <% out.println("<tr style=\"text-align:center; width:100%\";>");
        out.println("<tr ><th style=\"padding:20px; width:400px; font-size:20px;font-family:sans-serif;white-space:nowrap; \";>Service Name</th><th style=\"padding:20px; width:400px; font-size:20px;font-family:sans-serif; white-space:nowrap;\";>Fees On Net</th>"
                + "<th style=\"padding:20px;width:400px; font-size:20px;font-family:sans-serif; white-space:nowrap;\";>Fees Cross Net</th>"
                + "<th style=\"padding:20px;width:400px; font-size:20px;font-family:sans-serif; white-space:nowrap;\";>Fees International</th>" + "</tr >");

        //    for(int i=1;i<=totalColumn;i++)
        //    {
        //        String columnName = rsmd.getColumnName(i);
        //        out.println("<th style=\"padding:10px;font-size:20px;font-family:sans-serif;\";>"+columnName+" </th>");
        //    } 
        //   out.println("<th style=\"font-size:20px;font-family:sans-serif;\";> Delete</th>");
        out.println("</tr>");

        while (rs.next()) {
            out.println("<tr style=\"text-align:center;\";>");
            for (int col = 1; col <= totalColumn; col++) {
                if (col != 2) {
                    if (col == 1) {
                        Object obj = rs.getObject(col);
                        String serviceName = ServiceCRUD.getServiceName(Integer.parseInt(String.valueOf(obj)));
                        out.println("<td style=\"width:100px; padding-left:20px;padding-bottom:20px;padding-right:20px; padding-top:20px;\">" + serviceName + "</td>");

                    } else {
                        Object obj = rs.getObject(col);
                        DecimalFormat df = new DecimalFormat("###.##");
                        out.println("<td style=\"width:100px; padding-left:20px;padding-bottom:20px;padding-right:20px; padding-top:20px;\">" + df.format(Float.parseFloat(String.valueOf(obj))) + "</td>");
                    }
                }
            }
            //            String id = String.valueOf(rs.getObject(1));        
            //            out.println("<td>");        
            //         
            //        
    %>
    <%
//                        out.println("</td>");  
            out.println("</tr>");
        }

        out.println("</table>");

    %>
        
        
        
          <footer >
        <p style="color: greenyellow ; font-size :25px; margin-top:340px; margin-left: 40px; font-family: ">Welcome 
            ${Name}  </p>
        
    </footer>
</body>
</html>      
