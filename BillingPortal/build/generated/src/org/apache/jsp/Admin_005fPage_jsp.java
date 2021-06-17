package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Admin_005fPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 3.2 Final//EN\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin Page</title>\n");
      out.write("        <style type=\"text/css\"> \n");
      out.write("    body {\n");
      out.write("       text-align: center;\n");
      out.write("       \n");
      out.write("        margin: 0px;\n");
      out.write("    padding: 0px;\n");
      out.write("    height: 100vh;\n");
      out.write("       font-size: 20px;\n");
      out.write("      background-image: url('background2.jpg');\n");
      out.write("      background-position: center;\n");
      out.write("      background-repeat: no-repeat;\n");
      out.write("      background-size: cover;\n");
      out.write("      background-color: white;\n");
      out.write("    color: white;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("/*    form{\n");
      out.write("        text-align: center;\n");
      out.write("        margin: 0px;\n");
      out.write("        padding: 0px;\n");
      out.write("    }*/\n");
      out.write(" #add{\n");
      out.write("    font-size: 27px;\n");
      out.write("    background-color: white;\n");
      out.write("    color: blueviolet;\n");
      out.write("    border: none;\n");
      out.write("    /* cursor: pointer; */\n");
      out.write("    width: 300px;\n");
      out.write("    height: 40px;\n");
      out.write("    border-radius: 70px;\n");
      out.write("    /* text-align: center; */\n");
      out.write("    text-align: center;\n");
      out.write("    font-family: cursive;\n");
      out.write("    border: none;\n");
      out.write("    \n");
      out.write("}\n");
      out.write("\n");
      out.write("    \n");
      out.write("</style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 >Hello Admin!</h1>\n");
      out.write("        <form action=\"add_customer.jsp\">\n");
      out.write("        <input id=\"add\" type=\"submit\" value=\"Add Customer\" /><br><br></form>\n");
      out.write("        <form action=\"add_profile.jsp\">\n");
      out.write("            <input id=\"add\" type=\"submit\" value=\"Add Profile\"/><br><br></form>\n");
      out.write("        <form action=\"upload_cdr.jsp\">\n");
      out.write("            <input id=\"add\" type=\"submit\" value=\"Upload CDR\"/><br><br></form>\n");
      out.write("        <form action=\"display_customer.jsp\">\n");
      out.write("            <input id=\"add\" type=\"submit\" value=\"Display All Customers\"/><br><br></form>\n");
      out.write("        <form action=\"display_profiles.jsp\">\n");
      out.write("            <input id=\"add\" type=\"submit\" value=\"Display All Profiles\"/><br><br></form>\n");
      out.write("        <form action=\"display_services.jsp\">\n");
      out.write("            <input id=\"add\" type=\"submit\" value=\"Display All Services\"/><br><br></form>\n");
      out.write("        <form action=\"display_invoices.jsp\">\n");
      out.write("            <input id=\"add\" type=\"submit\" value=\"Display Invoices\"/><br><br></form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
