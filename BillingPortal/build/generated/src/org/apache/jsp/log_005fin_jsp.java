package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class log_005fin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>billing portal</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"main_menu.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("  <div class=\"container\">\n");
      out.write("    <form id=\"login\" class=\"login\" action=\"Admin_Page.jsp\">\n");
      out.write("      <span class=\"loginTitle\">Login</span>\n");
      out.write("      <div class=\"userName\">\n");
      out.write("        <span>User Name</span>\n");
      out.write("        <input type=\"text\"  placeholder=\"UserName\" name=\"Name\" required/>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"password\">\n");
      out.write("        <span>Password</span>\n");
      out.write("        <input type=\"password\"  placeholder=\"Password\" name=\"password\" required/>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"submit\">\n");
      out.write("        <input id=\"su\" class=\"sub\" type=\"submit\" value=\"Log In\"/>\n");
      out.write("      </div>            \n");
      out.write("    </form>\n");
      out.write("  </div>\n");
      out.write("<!-- Login Check -->\n");
      out.write("\n");
      out.write("\n");
      out.write("   \n");
      out.write("</body>\n");
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
