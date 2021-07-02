package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import web.billing.SignInCheck;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!--<style type=\"text/css\"> \n");
      out.write("    body {\n");
      out.write("     \n");
      out.write("        color: blue;\n");
      out.write("        margin: 0px;\n");
      out.write("    padding: 0px;\n");
      out.write("    height: 100vh;\n");
      out.write("       font-size: 50px;\n");
      out.write("      background-image: url('background2.jpg');\n");
      out.write("      background-position: center;\n");
      out.write("      background-repeat: no-repeat;\n");
      out.write("      background-size: cover;\n");
      out.write("      background-color: black;\n");
      out.write("    color: white;\n");
      out.write("    \n");
      out.write(" \n");
      out.write("    }\n");
      out.write("</style>-->\n");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 3.2 Final//EN\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>billing portal</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"main_menu.css\">\n");
      out.write("    <script src=\"jscript.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write(" ");

        String message ="";
        String username = request.getParameter("Name");
        String passwrd = request.getParameter("password");
        String submit = request.getParameter("submit");
 
       
        if(username != null && passwrd != null && submit != null &&
           !(username.equals("")) && !(passwrd.equals("")) && !(submit.equals(""))){
          
               String flag = SignInCheck.checkSiginIn(username, passwrd);
        if (flag.equals("admin")){    session.setAttribute("Name", username); response.sendRedirect("Admin_Page.jsp");    }
        else if (flag.equals("user")){   session.setAttribute("Name", username);  response.sendRedirect("user_login.jsp");}
        else {message = "UserName or Password is wrong";}
        }
        else if (submit != null && (username == null || passwrd == null ||username.equals("") || passwrd.equals(""))){
        message = "Please insert all fields";
        
    }
      
        
        
      out.write("\n");
      out.write("     \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <form action=\"\">\n");
      out.write("        <h2><span class=\"entypo-login\"><i class=\"fa fa-sign-in\"></i></span> Login</h2>\n");
      out.write("        <button class=\"submit\"><span class=\"entypo-lock\"><i class=\"fa fa-lock\"></i></span></button>\n");
      out.write("        <span class=\"entypo-user inputUserIcon\">\n");
      out.write("            <i class=\"fa fa-user\"></i>\n");
      out.write("        </span>\n");
      out.write("        <input type=\"text\" class=\"user\" name=\"Name\"  placeholder=\"ursername\"/>\n");
      out.write("        <span class=\"entypo-key inputPassIcon\">\n");
      out.write("            <i class=\"fa fa-key\"></i>\n");
      out.write("        </span>\n");
      out.write("        <input type=\"password\"  name=\"password\"  class=\"pass\"placeholder=\"password\"/>\n");
      out.write("        <center><span style=\"color: greenyellow;font-size: 17px;  margin-left:-40px;\" >");
      out.print(message);
      out.write("</span></center>\n");
      out.write("         <input type=\"hidden\" name=\"submit\" value=\"yes\"> \n");
      out.write("    </form>\n");
      out.write("\n");
      out.write(" <footer >\n");
      out.write("    <p class=\"footer\">Welcome to  Billing Portal </ps>\n");
      out.write("  </footer>\n");
      out.write("\n");
      out.write("</body>\n");
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
