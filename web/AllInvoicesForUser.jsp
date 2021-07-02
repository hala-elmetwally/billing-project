<%-- 
    Document   : user_login
    Created on : Jun 26, 2021, 3:46:08 AM
    Author     : Aya
--%>

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
            int existFlag = 0;
            File folder = new File("F:\\mayada\\ITI\\Billing\\web\\BillingPortal\\web\\Invoices");
            for (final File fileEntry : folder.listFiles()) {
                if (fileEntry.isDirectory()) {
                    if (fileEntry.getName().equals(name.replaceAll("\\s+", "_").toLowerCase())) {
                        System.out.println(fileEntry.getName());
                        File customer_invoice = new File("F:\\mayada\\ITI\\Billing\\web\\BillingPortal\\web\\Invoices\\" + name.replaceAll("\\s+", "_").toLowerCase());
                        for (File fileEntry1 : customer_invoice.listFiles()) {
                            if (!(fileEntry1.isDirectory())) { 
                              existFlag = 1;  
                             String path = fileEntry1.getName();%>
                                <input type="button" value="<%=fileEntry1.getName()%>" style="background-color:  greenyellow; display: block; color: black; width: 300px; cursor:pointer; margin-left: 570px;  margin-bottom: 20px;  " onclick="location.href = 'DisplayInvoicePdf.jsp?id=<%=id%>&name=<%=name%>&path=<%=path%>'">
<%
                            }
                        }
                    }
                }
            }
if(existFlag == 0){
        %>
        <p style="background-color:  greenyellow; display: block; color: black; width: 100px; cursor:pointer; margin-left: 670px;  margin-bottom: 20px; text-align: center">No Invoices </p>  <%}%> 
    <footer >
        <p style="color: greenyellow ; font-size :25px; margin-top:340px; margin-left: 40px; font-family: ">Welcome 
            ${Name}  </p>
        
    </footer>
</body>
</html>      