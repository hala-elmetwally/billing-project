package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_005fprofile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Profile Area -->\n");
      out.write("  <div class=\"container-fluid fullAreaProfile\">\n");
      out.write("    <form class=\"firstPageProfile\">\n");
      out.write("      <div class=\"firstProfilePageTitle\">\n");
      out.write("        <span>Main Profile Info</span>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"firstProfilePageName\">\n");
      out.write("        <span>Profile Name</span>\n");
      out.write("        <input id=\"profileName\" type=\"text\" placeholder=\"Enter Profile Name\" required name=\"profileName\"/>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"firstProfilePageFees\">\n");
      out.write("        <span>Profile Fees</span>\n");
      out.write("        <input type=\"number\" required min=\"1\" value=\"0\" name=\"profileFees\"/>\n");
      out.write("        <label>LE</label>\n");
      out.write("      </div> \n");
      out.write("      <div class=\"firstProfilePageFees\">\n");
      out.write("        <span>Renew Duration</span>\n");
      out.write("        <input type=\"number\" required min=\"1\" value=\"0\" name=\"renewProfileDuration\"/>\n");
      out.write("        <label>days</label>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"addFirstPageProfileSubmit\">\n");
      out.write("        <input id=\"firstPageProfileSubmit\" class=\"sub\" type=\"submit\" value=\"Next Page\">      \n");
      out.write("      </div>  \n");
      out.write("    </form>\n");
      out.write("<!--/////////////////////////////////////////////////////////////////////////////////////////////-->\n");
      out.write("    <form class=\"secondPageProfile overflow-auto\" id=\"secondPageProfile\">\n");
      out.write("      <div class=\"secondProfilePageTitle\">\n");
      out.write("        <span id=\"secondProfilePageTitle\">Add Services to </span>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"secondProfilePageName\">\n");
      out.write("        <span>Add Service</span>\n");
      out.write("        \n");
      out.write("     \n");
      out.write("        \n");
      out.write("        <input type=\"button\" id=\"addServiceButton\" value=\"+\"/>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"allSelectedServices\" id=\"allSelectedServices\"></div>\n");
      out.write("      <div class=\"addSecondPageProfileSubmit\">\n");
      out.write("        <input type=\"hidden\" value=\"\" id=\"allServicesNames\" name=\"allServicesName\"/>\n");
      out.write("        <input type=\"hidden\" value=\"\" id=\"profileNameServices\" name=\"profileNameServices\"/>\n");
      out.write("        <input id=\"secondPageProfileSubmit\" class=\"sub\" type=\"submit\" value=\"Next Page\"/>  \n");
      out.write("      </div>  \n");
      out.write("    </form>\n");
      out.write("<!--/////////////////////////////////////////////////////////////////////////////////////////////-->\n");
      out.write("    <form class=\"thirdPageProfile overflow-auto\" id=\"thirdPageProfile\">\n");
      out.write("      <div class=\"thirdPageProfilePageTitle\">\n");
      out.write("        <span id=\"thirdPageProfilePageTitle\">Add Free Units to </span>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"thirdProfilePageFreeUnits\">\n");
      out.write("        <span>Free Unit Voice On Net</span>\n");
      out.write("        <input type=\"number\" required min=\"0\" value=\"0\" name=\"free_Unit_Voice_On_Net\"/>\n");
      out.write("        <label>Unit</label>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"thirdProfilePageFreeUnits\">\n");
      out.write("        <span>Free Unit Voice On Cross Net</span>\n");
      out.write("        <input type=\"number\" required min=\"0\" value=\"0\" name=\"free_Unit_Voice_On_Cross_Net\"/>\n");
      out.write("        <label>Unit</label>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"thirdProfilePageFreeUnits\">\n");
      out.write("        <span>Free Unit SMS On Net</span>\n");
      out.write("        <input type=\"number\" required min=\"0\" value=\"0\" name=\"free_Unit_SMS_On_Net\"/>\n");
      out.write("        <label>Unit</label>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"thirdProfilePageFreeUnits\">\n");
      out.write("        <span>Free Unit SMS On Cross Net</span>\n");
      out.write("        <input type=\"number\" required min=\"0\" value=\"0\" name=\"free_Unit_SMS_On_Cross_Net\"/>\n");
      out.write("        <label>Unit</label>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"thirdProfilePageFreeUnits\">\n");
      out.write("        <span>Free Unit for Internet</span>\n");
      out.write("        <input type=\"number\" required min=\"0\" value=\"0\" name=\"free_Unit_For_Internet\"/>\n");
      out.write("        <label>Unit</label>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"addthirdPageProfileSubmit\">\n");
      out.write("        <input id=\"thirdPageProfileSubmit\" class=\"sub\" type=\"submit\" value=\"Finish\">  \n");
      out.write("      </div>  \n");
      out.write("    </form>\n");
      out.write("</div>        \n");
      out.write("  \n");
      out.write("\n");
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
