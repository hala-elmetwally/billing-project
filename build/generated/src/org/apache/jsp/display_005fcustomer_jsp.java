package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import web.billing.CustomerCRUD;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.io.*;

public final class display_005fcustomer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/header.html");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" <link rel=\"stylesheet\" href=\"main_menu.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Billing Portal</title>\n");
      out.write("   \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<!-- Header -->    \n");
      out.write("  <header class=\"sticky-top\" >\n");
      out.write("     \n");
      out.write("             \n");
      out.write("                  <img class=\"orange\" src=\"e4.jpg\" onclick=\"javascript:location.href='Admin_Page.jsp'\" width=\"120\" height=\"120\" alt=\"logo-etisalat\">\n");
      out.write("                \n");
      out.write("              \n");
      out.write("              \n");
      out.write("                 \n");
      out.write("                     \n");
      out.write("\n");
      out.write("\n");
      out.write("<!--<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("           <title>Customer Edit</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"admin.css\">\n");
      out.write("    \n");
      out.write("    </head>\n");
      out.write("    <body>-->\n");

    String username = request.getParameter("Name");
    String customerID = request.getParameter("id");
    if(customerID != null){
        CustomerCRUD.deleteCustomer(Integer.parseInt(customerID));
    }

    ResultSet rs = CustomerCRUD.selectAllCustomers();

    ResultSetMetaData rsmd = rs.getMetaData();
    int  totalColumn = rsmd.getColumnCount();

 out.println("<h1    style=\"width: 900px;   text-align:center;  font-size: 45px;  margin-top:-50px; margin-left:200px; margin-bottom:100px; color:greenyellow; font-family:sans-serif; text-shadow: 0 2px white, 0 3px #777; \"  ; >Display Customer </h1>");
      out.write("\n");
      out.write("  <table border=\"2\"   style=\"border-collapse:collapse;  margin-left:35px; width:10%; margin-bottom:10px; color:yellowgreen; margin-top:30px; text-align:center; \">\n");
      out.write("   ");
 out.println("<tr style=\"text-align:center;\";>");
     out.println("<tr ><th style=\"padding:4px; font-size:20px;font-family:sans-serif; \";>Customer ID</th><th style=\"padding:15px;font-size:20px;font-family:sans-serif;\";>Email</th><th style=\"padding:80px;font-size:20px;font-family:sans-serif;\";>Name</th>"
            + "<th style=\"padding:30px;font-size:20px;font-family:sans-serif;\";>Msisdn</th>"
             + "<th style=\"padding:30px;font-size:20px;font-family:sans-serif;\";>Address</th><th style=\"padding:20px;font-size:20px;font-family:sans-serif;\";> Profile ID</th>"
             + "<th style=\"font-size:20px;font-family:sans-serif; padding:20px;\";> Renew Day</th><th style=\"font-size:20px;font-family:sans-serif; width:3px;\";>Edit Or Delete</th>"
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
            if(col != 1 &&col != 5 && col != 9 && col !=7 && col !=8){
                
                
           
            
            Object obj= rs.getObject(col);                    
            out.println("<td style=\"width:100px;\">"+ String.valueOf(obj) +"</td>");
                    
         }  
        }
            String id = String.valueOf(rs.getObject(1));        
            out.println("<td>");        
         
        
         
      out.write("\n");
      out.write("         \n");
      out.write("     \n");
      out.write("         <input type=\"button\" value=\"Delete\" style=\"background-color:  greenyellow; color: black; width:200px; cursor:pointer; margin-left: 29px;  \" onclick=\"location.href = 'display_customer.jsp?id=");
      out.print(id);
      out.write("'\">\n");
      out.write("         <input type=\"button\" value=\"Edit\" style=\"background-color:  greenyellow; color: black; width: 200px; cursor:pointer; margin-left: 29px;  \"onclick=\"location.href = 'EditCustomer.jsp?id=");
      out.print(id);
      out.write("'\">\n");
      out.write("\n");
      out.write("                    ");
 
                        out.println("</td>");  
                        out.println("</tr>");
    }




    out.println("</table>");


      out.write("\n");
      out.write("\n");
      out.write("<a href=\"Admin_Page.jsp\" style=\"color: greenyellow; \" >\n");
      out.write("    <img src=\"home.png\" width=\"100px\" height=\"100px\"/>\n");
      out.write("            </a>\n");
      out.write("<footer > \n");
      out.write("    <p style=\"color: greenyellow ; font-size :25px;   font-family:  sans-serif;\" >Welcome ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("   </p>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("<!--\n");
      out.write(" </body>\n");
      out.write("</html>-->");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
