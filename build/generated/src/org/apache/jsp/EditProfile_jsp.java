package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import web.billing.Profile_ServiceCRUD;
import java.util.ArrayList;
import web.billing.ProfileCRUD;
import web.billing.RatingCRUD;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import web.billing.ServiceCRUD;

public final class EditProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                  <img class=\"orange\" src=\"e4.jpg\"  width=\"120\" height=\"120\" alt=\"logo-etisalat\">\n");
      out.write("                \n");
      out.write("              \n");
      out.write("              \n");
      out.write("                 \n");
      out.write("                     \n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 3.2 Final//EN\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"main_menu.css\">\n");
      out.write("\n");
      out.write("        <title>Edit Profile</title>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");

            int count = 0;
            String profileID = request.getParameter("id");
            //String profileName = request.getParameter("profile");
            String onNet = request.getParameter("OnNet");
            String crossNet = request.getParameter("CrossNet");
            String feesInter = request.getParameter("FeesInter");
            String serviceID = request.getParameter("serID");
            String add_service_name = request.getParameter("addser_name");
            String add_service_fees = request.getParameter("addser_fees");
            
            if (add_service_name != null && add_service_fees != null){
                int serID = ServiceCRUD.insertService(add_service_name);
                Profile_ServiceCRUD.insertNewServiceToProfile(serID,Integer.parseInt(profileID));
                RatingCRUD.insertNewRating(serID, Integer.parseInt(profileID), Float.parseFloat(add_service_fees), 0, 0);
            }

            if (onNet != null && crossNet != null && feesInter != null && serviceID != null) {
                RatingCRUD.UpdateRating(Integer.parseInt(serviceID), Integer.parseInt(profileID), Float.parseFloat(onNet), Float.parseFloat(crossNet),
                        Float.parseFloat(feesInter));
            }

            ResultSet rs1 = ProfileCRUD.selectProfile(Integer.parseInt(profileID));
            ResultSet rs2 = RatingCRUD.selectServicesRatingForProfile(Integer.parseInt(profileID));
            ResultSet rs3 = ServiceCRUD.selectAllServices();
            String profile_name = "";
            Float FeesOnNet;
            Float FeesCrossNet;
            Float FeesInter;
            ArrayList<String> servicesName = new ArrayList<String>();
            rs1.next();
            profile_name = String.valueOf(rs1.getObject(2));
            while (rs3.next()) {
                servicesName.add(rs3.getString(2));
            }

        
      out.write("\n");
      out.write("\n");
      out.write("        <div>\n");
      out.write("\n");
      out.write("            <div>\n");
      out.write("                <h1 style=\"width: 900px;   text-align:center;  margin-left:230px; font-size: 45px;  margin-top: 70px; padding-bottom: 10px;  color:greenyellow; font-family:sans-serif; text-shadow: 0 2px white, 0 3px #777;\">Edit Profile Information</h1>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <span class=\"Edit_prof\" style=\" font-size: 40px; margin-left:580px; margin-top: -100px;\"> ");
      out.print(profile_name);
      out.write("</span>\n");
      out.write("<!--                <input style=\"width: 100px; text-align: center;\" id=\"\" type=\"text\"  name=\"profile\" value=\"");
      out.print(profile_name);
      out.write("\"/>-->\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");

                ResultSet rs = ServiceCRUD.selectAllServices();
                ResultSetMetaData rsmd = rs.getMetaData();
                int totalColumn = rsmd.getColumnCount();


            
      out.write("\n");
      out.write("            <div >\n");
      out.write("                <span style=\" font-size: 40px;\"> </span>\n");
      out.write("                <center>\n");
      out.write("                    <br>    \n");
      out.write("                    <table border='2' style=\"border-collapse:collapse; margin-left:-270px; font-size: 25px; font-family:sans-serif;  margin-bottom:10px; color:yellowgreen; margin-top:30px; text-align:center;\">\n");
      out.write("                        <tr>\n");
      out.write("                        <th style=\"padding-top:40px; padding-bottom: 30px; text-align: center;  width: 590px; \" >Service Name</th>\n");
      out.write("                        <th style=\"padding-top:40px; padding-bottom: 30px; text-align: center;  width: 590px; \" >On Net Fees</th>\n");
      out.write("                        <th style=\"padding-top:40px; padding-bottom: 30px;  text-align: center; \" >Cross Net Fees</th>\n");
      out.write("                        <th style=\"padding-top:40px; padding-bottom: 30px;   text-align: center; \" >International Fees</th>\n");
      out.write("                        <th style=\"padding-top:40px; padding-bottom: 30px;   text-align: center; \" >Apply</th>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
      while (rs2.next()) {
                                FeesOnNet = rs2.getFloat(3);
                                FeesCrossNet = rs2.getFloat(4);
                                FeesInter = rs2.getFloat(5);
      out.write("\n");
      out.write("                        <form>\n");
      out.write("                            <tr style=\"text-align:center;\">\n");
      out.write("                            <td>");
      out.print(servicesName.get(count));
      out.write(" </td>\n");
      out.write("                            <td><input style=\"width: 100px; text-align: center;\" id=\"\" type=\"text\"  name=\"OnNet\" value=\"");
      out.print(FeesOnNet);
      out.write("\"/>\n");
      out.write("                            </td>\n");
      out.write("                            <td><input style=\"width: 100px; text-align: center;\" id=\"\" type=\"text\"  name=\"CrossNet\" value=\"");
      out.print(FeesCrossNet);
      out.write("\"/>\n");
      out.write("                            </td>\n");
      out.write("                            <td><input style=\"width: 100px; text-align: center;\" id=\"\" type=\"text\"  name=\"FeesInter\" value=\"");
      out.print(FeesInter);
      out.write("\"/>\n");
      out.write("                            </td>\n");
      out.write("                            <td><input style=\"width: 100px; text-align: center;\" id=\"\" type=\"submit\" value=\"Apply\"/>\n");
      out.write("                            </td>\n");
      out.write("                            </tr>\n");
      out.write("\n");
      out.write("                            <input  type=\"hidden\" name=\"id\" value=\"");
      out.print(profileID);
      out.write("\">\n");
      out.write("                            <input type=\"hidden\" name=\"serID\" value=\"");
      out.print(rs2.getInt(1));
      out.write("\">\n");
      out.write("                        </form>\n");
      out.write("                        ");
count++;}
      out.write("\n");
      out.write("                    </table>\n");
      out.write("                    <div class=\"servicesfees\" >\n");
      out.write("                        <span style= \"\" >Add Service</span>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                    </div>\n");
      out.write("                    <form>\n");
      out.write("                        <div >\n");
      out.write("                            <span class=\"customer_name\" style=\"margin-left:-30px\" >Service Name</span>\n");
      out.write("                            <input class=\"call\" id=\"customerName\" type=\"text\" required min=\"0\"  name=\"addser_name\"/>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div>\n");
      out.write("                            <span  class=\"call_crossnet\">Service Fees</span>\n");
      out.write("                            <input class=\"call\" id=\"customerName\" type=\"number\" required min=\"0\" step=\"0.01\"value=\"0\" name=\"addser_fees\"/>\n");
      out.write("                        </div>\n");
      out.write("                        <div>\n");
      out.write("                            <input id=\"customerName\" type=\"submit\" required  value=\"Add\" />\n");
      out.write("                        </div>\n");
      out.write("                        <input  type=\"hidden\" name=\"id\" value=\"");
      out.print(profileID);
      out.write("\">\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>  \n");
      out.write("        </div> \n");
      out.write("\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <a href=\"Admin_Page.jsp\" style=\"color: greenyellow; \" >\n");
      out.write("        <img src=\"home.png\" width=\"100px\" height=\"100px\"/>\n");
      out.write("    </a>\n");
      out.write("<footer > <p style=\"color: greenyellow ; font-size :25px; margin-top: -100px; margin-left: 30px; font-family:  sans-serif;\" >Welcome ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("   </p>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
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
