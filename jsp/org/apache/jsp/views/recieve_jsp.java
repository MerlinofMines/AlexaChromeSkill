package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class recieve_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Echo Chamber</title>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h2>Receive</h2>\r\n");
      out.write("\r\n");
      out.write("<div>\r\n");
      out.write("    <input type=\"text\" id=\"messageinput\"/>\r\n");
      out.write("</div>\r\n");
      out.write("<div>\r\n");
      out.write("    <button type=\"button\" onclick=\"openSocket();\" >Open</button>\r\n");
      out.write("    <button type=\"button\" onclick=\"send();\" >Send</button>\r\n");
      out.write("    <button type=\"button\" onclick=\"closeSocket();\" >Close</button>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- ChromeExtension responses get written here -->\r\n");
      out.write("<div id=\"messages\"></div>\r\n");
      out.write("\r\n");
      out.write("<!-- Script to utilise the WebSocket -->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("            var webSocket;\r\n");
      out.write("            var messages = document.getElementById(\"messages\");\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            function openSocket(){\r\n");
      out.write("                // Ensures only one connection is open at a time\r\n");
      out.write("                if(webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED){\r\n");
      out.write("                   writeResponse(\"WebSocket is already opened.\");\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                // Create a new instance of the websocket\r\n");
      out.write("                webSocket = new WebSocket(\"ws://localhost:8080/alexa\");\r\n");
      out.write("\r\n");
      out.write("                /**\r\n");
      out.write("                 * Binds functions to the listeners for the websocket.\r\n");
      out.write("                 */\r\n");
      out.write("                webSocket.onopen = function(event){\r\n");
      out.write("                    // For reasons I can't determine, onopen gets called twice\r\n");
      out.write("                    // and the first time event.data is undefined.\r\n");
      out.write("                    // Leave a comment if you know the answer.\r\n");
      out.write("                    if(event.data === undefined)\r\n");
      out.write("                        return;\r\n");
      out.write("\r\n");
      out.write("                    writeResponse(event.data);\r\n");
      out.write("                };\r\n");
      out.write("\r\n");
      out.write("                webSocket.onmessage = function(event){\r\n");
      out.write("                    writeResponse(event.data);\r\n");
      out.write("                };\r\n");
      out.write("\r\n");
      out.write("                webSocket.onclose = function(event){\r\n");
      out.write("                    writeResponse(\"Connection closed\");\r\n");
      out.write("                };\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            /**\r\n");
      out.write("             * Sends the value of the text input to the server\r\n");
      out.write("             */\r\n");
      out.write("            function send(){\r\n");
      out.write("                var text = document.getElementById(\"messageinput\").value;\r\n");
      out.write("                webSocket.send(text);\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            function closeSocket(){\r\n");
      out.write("                webSocket.close();\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            function writeResponse(text){\r\n");
      out.write("                messages.innerHTML += \"<br/>\" + text;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
