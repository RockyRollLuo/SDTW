/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-07 09:03:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main.train;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.common.HeadConst;
import com.xietong.software.util.ParamUtils;
import com.xietong.software.common.HtmlTool;
import com.xietong.software.util.Tool;
import com.xietong.software.common.UserInfo;

public final class zuoye_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");

UserInfo userInfo = Tool.getUserInfo(request);
if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
}
String idlist = ParamUtils.getParameter(request,"idlist","-1");

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/images/skin/");
      out.print(userInfo.getSkinId());
      out.write("/css.css\">\r\n");
      out.write("<script language=\"JavaScript\" src=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/js/ajaxfileupload.js\"></script>\r\n");
      out.write("<script language=\"JavaScript\" src=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/standardupgrade/js/addFileupload.js\"></script>\r\n");
      out.write("<script language=\"JavaScript\" src=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/js/common.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function submitthis() {\r\n");
      out.write("\tvar DateRate = $('#DateRate').val();\r\n");
      out.write("\tif(DateRate==\"\"){\r\n");
      out.write("\t\t$('#DateRate').focus();\r\n");
      out.write("\t\talert(\"请录入考勤情况！\");\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\tvar val=$('input:radio[name=Audit]:checked' ).val();\r\n");
      out.write("\tif(val== null){\r\n");
      out.write("\t\t$('#pass').css(\"border\",\"1px red solid\");\r\n");
      out.write("\t\talert(\"请选择审核结果\");\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\tvar CheckFileEstimate = $('#CheckFileEstimate').val();\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\tasync : false,\r\n");
      out.write("\t\t\turl : \"");
      out.print(HeadConst.apache_url);
      out.write("/main/train/TrainingParticipateAction.jsp\",\r\n");
      out.write("\t\t\tdata : {\r\n");
      out.write("\t\t\t\tcmd : 'zuoyelist',\r\n");
      out.write("\t\t\t\tAudit : val,\r\n");
      out.write("\t\t\t\tidlist : '");
      out.print(idlist);
      out.write("',\r\n");
      out.write("\t\t\t\tCheckFileEstimate : CheckFileEstimate,\r\n");
      out.write("\t\t\t\tDateRate : DateRate\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tdataType : \"json\",\r\n");
      out.write("\t\t\tcache : false,\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\tif (data.msg==\"ok\") {\r\n");
      out.write("\t\t\t\t\talert(\"操作成功!\");\r\n");
      out.write("\t\t\t\t\t$('#top_dialog').dialog( 'close');\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\talert(\"操作失败\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror : function() {\r\n");
      out.write("\t\t\t\t// view(\"异常！\"); \r\n");
      out.write("\t\t\t\talert(\"异常！\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title></title>\r\n");
      out.write("</head>\r\n");
      out.write("<body >\r\n");
      out.write("<div id=\"errorDiv\" style=\"color:red;font-weight:bold\"></div>\r\n");
      out.write("<div style=\"margin:10px auto 0 auto;width:100%;color:#36486C;background-color: #FFFFFF\">\r\n");
      out.write("     <form id=\"postForm\" name=\"postForm\" action=\"\" method=\"post\">\r\n");
      out.write("     <input type=\"hidden\" id=\"cmd\" name=\"cmd\" value=\"addFile\">\r\n");
      out.write("     <table cellpadding=\"8px\" cellspacing=\"1px\" bgcolor=\"#E3E5E8\">\r\n");
      out.write("     <tr>\r\n");
      out.write("     <td class=\"form_label\" >作业评价</td>\r\n");
      out.write("     <td  align=\"left\">\r\n");
      out.write("\t\t <div align=\"left\">\r\n");
      out.write("\t\t<textarea rows=\"4\" cols=\"100\" id=\"CheckFileEstimate\" name=\"CheckFileEstimate\" style=\"width: 100%\"></textarea>\r\n");
      out.write("\t     </div>\r\n");
      out.write("\t </td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("     <td class=\"form_label\">考勤</td>\r\n");
      out.write("     <td  align=\"left\">\r\n");
      out.write("\t\t <div align=\"left\">\r\n");
      out.write("\t\t\t<input name=\"DateRate\" id=\"DateRate\"/>\r\n");
      out.write("\t     </div>\r\n");
      out.write("\t </td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("     <td class=\"form_label\"></td>\r\n");
      out.write("     <td  align=\"left\" id=\"pass\">\r\n");
      out.write("\t\t <div align=\"left\">\r\n");
      out.write("\t\t\t<input name=\"Audit\" value=\"2\" type=\"radio\"/>通过\r\n");
      out.write("\t\t\t<input  name=\"Audit\" value=\"3\" type=\"radio\"/>不通过\r\n");
      out.write("\t     </div>\r\n");
      out.write("\t </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("     ");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("     </table>\r\n");
      out.write("     </form>\r\n");
      out.write("     </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}