/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-07 09:01:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main.train;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.sdtw.*;
import com.xietong.software.sdtw.db.*;
import com.xietong.software.util.*;
import com.xietong.software.common.*;
import org.apache.commons.logging.*;
import java.io.*;
import java.util.*;
import com.xietong.software.common.UserInfo;
import com.xietong.software.common.HeadConst;
import com.xietong.software.util.Tool;

public final class TrainingParticipateForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/main/js/jsheader.jsp", Long.valueOf(1485156249000L));
  }

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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("var GBasePath = \"");
      out.print(HeadConst.root_url_path);
      out.write("\";\r\n");
      out.write("var GResPath = \"");
      out.print(HeadConst.apache_url);
      out.write("/main\";\r\n");
{
      out.write("var GImagePath = \"");
      out.print(HeadConst.apache_url);
      out.write("/main/images/skin/");
UserInfo ui = Tool.getUserInfo(request); if (ui == null) out.print("blue"); else out.print(ui.getSkinId());
      out.write('"');
      out.write(';');
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write('\r');
      out.write('\n');

	Log log = LogFactory.getLog(TrainingParticipate.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	TrainingParticipate v = (TrainingParticipate)request.getAttribute("fromBean");
	if (v == null) {
    		out.print(HtmlTool.msgBox(request, "请先调用Action.jsp！"));
    		return;
	}
	log.debug(request.getAttribute("classname") + "Form");
	String[] dickeys = (String[])request.getAttribute("dickeys");
	String[][] dicvalues = (String[][])request.getAttribute("dicvalues");
	List diclist = new ArrayList();
	for (int i = 0; i < dickeys.length; i ++) {
    		diclist.add("\"" + dickeys[i] + "\": [\"" + Tool.join("\", \"", dicvalues[i]) + "\"]");
	}
	Map extMaps = (Map)request.getAttribute("Ext");
	List paras = HttpTool.getSavedUrlForm(request, "Ext");
	List urls = (List)paras.get(0);
	List forms = (List)paras.get(1);
	urls.addAll((List)paras.get(2));
	forms.addAll((List)paras.get(3));
	String url = Tool.join("&", urls);
	//默认值定义
	UserInfo userInfo = Tool.getUserInfo(request);
	if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
	}
	List UserCnNameOptions = CEditConst.getUserCnNameOptions(userInfo);

      out.write("\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>");
      out.print(request.getAttribute("describe"));
      out.write("</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/images/skin/");
      out.print(userInfo.getSkinId());
      out.write("/css.css\">\r\n");
      out.write("\t\t<script language=\"JavaScript\" src=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/js/validation-framework.js\"></script>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\tValidationFramework.init(\"");
      out.print(request.getAttribute("classname"));
      out.write("_validation.xml\");\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t<script src=\"");
      out.print(userInfo.getRootUrl());
      out.write("/main/js/formfunction.js\"></script>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\tvar url_para = \"");
      out.print(url);
      out.write("\";\r\n");
      out.write("\t\t\tvar dic = {");
      out.print(Tool.join(", ", diclist));
      out.write("};\r\n");
      out.write("\t\t\tvar keyfield = \"");
      out.print((String)request.getAttribute("keyfield"));
      out.write("\";\r\n");
      out.write("\t\t\tvar allfields = [\"");
      out.print(Tool.join("\", \"", (String[])request.getAttribute("allfields")));
      out.write("\"];\r\n");
      out.write("\t\t\tvar fields = [\"");
      out.print(Tool.join("\", \"", (String[])request.getAttribute("fields")));
      out.write("\"];\r\n");
      out.write("\t\t\tvar options= {");
      out.print(HtmlTool.getJsOptions(request));
      out.write("};\r\n");
      out.write("\t\t\tfunction init() {\r\n");
      out.write("    \t\t\t\tprepareForm(\"");
      out.print(request.getAttribute("classname"));
      out.write("\", dic, \"");
      out.print(userInfo.getPower());
      out.write("\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body onload=\"init();\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/main/jqueryui.jsp", out, true);
      out.write("\r\n");
      out.write("\t\t<div class=\"browsetitle\">\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"browsetitleright\">\r\n");
      out.write("\t\t\t\t<div class=\"anniulist2\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"TrainingParticipateAction.jsp?cmd=list&page=");
      out.print(currpage);
      out.print(((url.length() == 0) ? "" : "&" + url));
      out.write("\" >返回</a></li>\r\n");
      out.write("\t\t\t\t\t\t<!-- <li><a href=\"javascript:void(0);\" onclick=\"javascript:if(doValidate('postForm')) document.postForm.submit();\">保存</a></li> -->\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"errorDiv\" style=\"color:red;font-weight:bold\"></div>\r\n");
      out.write("\t\t<div class=\"browsetable\" id=\"form\">\r\n");
      out.write("\t\t\t<form action=\"");
      out.print(request.getAttribute("classname"));
      out.write("Action.jsp\" method=\"post\" name=\"postForm\" id=\"postForm\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"cmd\" value=\"");
      out.print(cmd);
      out.write("\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"page\" value=\"");
      out.print(currpage);
      out.write("\">\r\n");
      out.write("\t\t\t\t");
      out.print(Tool.join("\n", forms));
      out.write("\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"4\" cellspacing=\"1\" >\r\n");
      out.write("<input type=\"hidden\" name=\"Id\" value=\"");
      out.print(v.getId());
      out.write("\">\r\n");
      out.write("<input type=\"hidden\" name=\"ProjectId\" id=\"ProjectId\" value=\"");
      out.print(v.getProjectId());
      out.write("\">\r\n");
      out.write("<input type=\"hidden\" name=\"WorkFileList\" id=\"WorkFileList\" value=\"");
      out.print(v.getWorkFileList());
      out.write("\"/>\r\n");
      out.write("<input type=\"hidden\" name=\"AddFileList\" id=\"AddFileList\" value=\"");
      out.print(v.getAddFileList());
      out.write("\"/>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"right\" class=\"form_label\">学号</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t\t<td align=\"left\"  bgcolor=\"#ffffff\">\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t\t<input id=\"Sno\" name=\"Sno\" value=\"");
      out.print(v.getSno());
      out.write("\"/>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"right\" class=\"form_label\">姓名</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t\t<td align=\"left\"  bgcolor=\"#ffffff\">\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t\t");
      out.print(HtmlTool.renderSelect(UserCnNameOptions,""+v.getSname(),"Sname","",true) );
      out.write("\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t</tr>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"right\" class=\"form_label\">考勤</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t\t<td align=\"left\"  bgcolor=\"#ffffff\" colspan=\"3\">\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t\t<input name=\"DateRate\" id=\"DateRate\" size=\"45\" maxsize=\"45\" value=\"");
      out.print(v.getDateRate());
      out.write("\">\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t</tr>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"right\" class=\"form_label\">作业</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t\t<td align=\"left\"  bgcolor=\"#ffffff\" colspan=\"3\" >\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t\t<textarea name=\"HomeWork\" id=\"HomeWork\" cols=\"40\" rows=\"2\" style=\"width: 80%;\">");
      out.print(v.getHomeWork());
      out.write("</textarea>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t</tr>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"right\" class=\"form_label\">作业附件</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t\t<td align=\"left\"  bgcolor=\"#ffffff\" colspan=\"3\" >\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t\t");

																			int caid = v.getId();
																			if (!"".equals(v.getWorkFileList().trim())) {
																				String caids[] = v.getWorkFileList().split(",");
																				for(int i=0;i<caids.length;i++){
																					caid = Tool.StrToInt(caids[i]);
																					ClientAttach ca = new ClientAttach();
																					if (caid!=-1&&ca.getById(caid)!=null) {
																						ca = ca.getById(caid);
																			
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t     <a href=\"");
      out.print(HeadConst.apache_url );
      out.write("/servlet/attach?type=otherattach&id=");
      out.print(ca.getId() );
      out.write("\" target=\"_blank\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t     ");
      out.print(ca.getUploadName() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t     </a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
}
																				}
																			}
																			
      out.write("\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t</tr>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"right\" class=\"form_label\">作业评价</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t\t<td align=\"left\"  bgcolor=\"#ffffff\" colspan=\"3\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t\t<textarea name=\"CheckFileEstimate\" id=\"CheckFileEstimate\" cols=\"40\" rows=\"2\" style=\"width: 80%;\">");
      out.print(v.getCheckFileEstimate());
      out.write("</textarea>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t</tr>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"right\" class=\"form_label\">结题报告</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t\t<td align=\"left\"  bgcolor=\"#ffffff\" colspan=\"3\" >\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t\t<textarea name=\"CheckReport\" id=\"CheckReport\" cols=\"40\" rows=\"2\" style=\"width: 80%;\">");
      out.print(v.getCheckReport());
      out.write("</textarea>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t</tr>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"right\" class=\"form_label\">结题附件</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t\t<td align=\"left\"  bgcolor=\"#ffffff\" colspan=\"3\">\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t\t");

																			if (!"".equals(v.getAddFileList().trim())) {
																				String caids[] = v.getAddFileList().split(",");
																				for(int i=0;i<caids.length;i++){
																					caid = Tool.StrToInt(caids[i]);
																					ClientAttach ca = new ClientAttach();
																					if (caid!=-1&&ca.getById(caid)!=null) {
																						ca = ca.getById(caid);
																			
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t     <a href=\"");
      out.print(HeadConst.apache_url );
      out.write("/servlet/attach?type=otherattach&id=");
      out.print(ca.getId() );
      out.write("\" target=\"_blank\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t     ");
      out.print(ca.getUploadName() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t     </a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
}
																				}
																			}
                    														
      out.write("\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t</tr>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"right\" class=\"form_label\">结题报告评价</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t\t<td align=\"left\"  bgcolor=\"#ffffff\" colspan=\"3\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t\t<textarea name=\"CheckReportEstimate\" id=\"CheckReportEstimate\" cols=\"40\" rows=\"2\" style=\"width: 80%;\">");
      out.print(v.getCheckReportEstimate());
      out.write("</textarea>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t</tr>\r\n");
      out.write("<input type=\"hidden\" name=\"CheckId\" value=\"");
      out.print(v.getCheckId());
      out.write("\">\r\n");
      out.write("<input type=\"hidden\" name=\"Audit\" value=\"");
      out.print(v.getAudit());
      out.write("\">\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");
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
