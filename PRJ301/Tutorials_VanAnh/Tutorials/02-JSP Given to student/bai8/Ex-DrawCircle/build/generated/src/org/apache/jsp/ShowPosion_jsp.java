package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ShowPosion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Possion mouse Page</title>\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                margin: 0 0;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body data-rsssl=1>\n");
      out.write("    <canvas id=\"myCanvas\" width=\"500\" height=\"300\" style=\"border:1px solid #d3d3d3;\"></canvas>\n");
      out.write("    <script>\n");
      out.write("      function writeMessage(canvas, message,x,y) {\n");
      out.write("        var context = canvas.getContext('2d');\n");
      out.write("        context.clearRect(0, 0, canvas.width, canvas.height);\n");
      out.write("        context.font = '18pt Calibri';\n");
      out.write("        context.fillStyle = 'black';\n");
      out.write("        context.fillText(message, x, y);\n");
      out.write("      }\n");
      out.write("      function getMousePos(canvas, evt) {\n");
      out.write("        var rect = canvas.getBoundingClientRect();\n");
      out.write("        return {\n");
      out.write("          x: evt.clientX - rect.left,\n");
      out.write("          y: evt.clientY - rect.top\n");
      out.write("        };\n");
      out.write("      }\n");
      out.write("      var canvas = document.getElementById('myCanvas');\n");
      out.write("      var context = canvas.getContext('2d');\n");
      out.write("\n");
      out.write("      canvas.addEventListener('mousemove', function(evt) {\n");
      out.write("        var mousePos = getMousePos(canvas, evt);\n");
      out.write("        var message = mousePos.x + ',' + mousePos.y;\n");
      out.write("        writeMessage(canvas, message,mousePos.x,mousePos.y);\n");
      out.write("      }, false);\n");
      out.write("    </script>\n");
      out.write("  </body>\n");
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
