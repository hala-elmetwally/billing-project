package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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
      out.write("<style type=\"text/css\"> \n");
      out.write("    body {\n");
      out.write("       text-align: center;\n");
      out.write("        color: blue;\n");
      out.write("        margin: 0px;\n");
      out.write("    padding: 0px;\n");
      out.write("    height: 100vh;\n");
      out.write("       font-size: 90px;\n");
      out.write("      background-image: url('background2.jpg');\n");
      out.write("      background-position: center;\n");
      out.write("      background-repeat: no-repeat;\n");
      out.write("      background-size: cover;\n");
      out.write("      background-color: black;\n");
      out.write("    color: white;\n");
      out.write("    width: 100px;\n");
      out.write("    text-align: center;\n");
      out.write("    }\n");
      out.write("</style>\n");
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
      out.write("\n");

    
    
    
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


    out.println("<table border='1' style='border-collapse:collapse font-size=600px' >");
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
        
         
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"edit\" /> \n");
      out.write("                    <input type=\"submit\" value=\"delete\" />\n");
      out.write("                    ");

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

      out.write('\n');
      out.write('\n');
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
