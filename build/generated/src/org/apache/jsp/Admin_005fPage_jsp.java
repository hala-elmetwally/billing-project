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
      out.write("<!DOCTYPE html>    \n");
      out.write("<a href=\"Admin_Page.jsp\"></a>\n");
      out.write("\n");
      out.write("\n");
      out.write("  ");
 String username = request.getParameter("Name"); 
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 3.2 Final//EN\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"admin.css\">\n");
      out.write("    \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("              <img  src=\"logo.jpg\" style=\"margin-bottom:70px; margin-left: -90px;\" width=\"120\" height=\"120\"  alt=\"logo-etisalat\">\n");
      out.write("\n");
      out.write("          <h1 class=\"admin_page\">Admin page</h1>\n");
      out.write("     \n");
      out.write("                \n");
      out.write("            <a href=\"add_customer.jsp\" >\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                Add Customer\n");
      out.write("            </a>\n");
      out.write("     \n");
      out.write("            <a href=\"add_profile.jsp\">\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                Add Profile\n");
      out.write("            </a>\n");
      out.write("<!--        <a href=\"EditCustomer.jsp\">\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                Edit Customer\n");
      out.write("            </a>\n");
      out.write("          \n");
      out.write("           <a href=\"EditProfile.jsp\">\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                Edit Profile\n");
      out.write("            </a>\n");
      out.write("          \n");
      out.write("          -->\n");
      out.write("          \n");
      out.write("          \n");
      out.write("          \n");
      out.write("            <a href=\"UploadCdr.jsp\">\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                Upload CDR\n");
      out.write("            </a>\n");
      out.write("       \n");
      out.write("            <a href=\"display_customer.jsp\">\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                Display All Customers\n");
      out.write("            </a>\n");
      out.write("       \n");
      out.write("            <a href=\"display_profiles.jsp\">\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                Display All Profiles\n");
      out.write("            </a>\n");
      out.write("      \n");
      out.write("            <a href=\"display_services.jsp\">\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                Display All Services\n");
      out.write("            </a>\n");
      out.write("   \n");
      out.write("            <a href=\"DisplayInvoices.jsp\">\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                <span></span>\n");
      out.write("                Display Invoice\n");
      out.write("            </a>\n");
      out.write("        <footer >\n");
      out.write("    <p style=\"color: greenyellow ; font-size :25px; margin-top: -45px; margin-left: 40px; font-family: \">Welcome   ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" </p>\n");
      out.write("  </footer>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
