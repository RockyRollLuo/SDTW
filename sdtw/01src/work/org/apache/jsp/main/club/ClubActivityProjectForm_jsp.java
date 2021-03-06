/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-19 01:26:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main.club;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.base.SdtwConst;
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

public final class ClubActivityProjectForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
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

	Log log = LogFactory.getLog(ClubActivityProject.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	ClubActivityProject v = (ClubActivityProject)request.getAttribute("fromBean");
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
	List cdt = new ArrayList();
	cdt.add("roles="+SdtwConst.USER_TYPE_STU);
	//List UserNameoptions = COptionConst.getUserCnNameOptions(userInfo,"",cdt);
	List RoleNameOptions = CEditConst.getRoleNameOptions(userInfo,"-1");
	//(List)request.getAttribute("UserNameoptions");

      out.write("\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>");
      out.print(request.getAttribute("describe"));
      out.write("</title>\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/main/jqueryui.jsp", out, true);
      out.write("\r\n");
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
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\t<script language=\"JavaScript\" src=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/js/datepicker/WdatePicker.js\"></script>\r\n");
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
      out.write("\t\t\t/* $(function(){\r\n");
      out.write("\t\t\t\t$(\"#ProjectLeader\").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:\"没有找到\"});\r\n");
      out.write("\t\t\t\t/* $(\"#Fbzr\").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:\"没有找到\"}); */\r\n");
      out.write("\t\t\t}); */\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body onload=\"init();\">\r\n");
      out.write("\t\t<div class=\"browsetitle\">\r\n");
      out.write("\t\t\t<div class=\"browsetitleleft\">\r\n");
      out.write("\t\t\t\t<div class=\"browsetitle001\">社团活动立项</div>\r\n");
      out.write("\t\t\t\t<div class=\"browsetitle002\">");
      out.print(XtUtil.getSpell("社团活动立项") );
      out.write("</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"browsetitleright\">\r\n");
      out.write("\t\t\t\t<div class=\"anniulist2\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"ClubActivityProjectAction.jsp?cmd=list&page=");
      out.print(currpage);
      out.print(((url.length() == 0) ? "" : "&" + url));
      out.write("\" >返回</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"javascript:void(0);\" onclick=\"javascript:if(doValidate('postForm')) document.postForm.submit();\">保存</a></li>\r\n");
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
      out.write("<input type=\"hidden\" id=\"AddPerson\" name=\"AddPerson\" value=\"");
      out.print(v.getAddPerson().equals("")?userInfo.getId():v.getAddPerson());
      out.write("\"/>\r\n");
      out.write("<input type=\"hidden\" name=\"AddTime\" id=\"AddTime\" size=\"0\" value=\"");
      out.print(Tool.stringOfDateTime(v.getAddTime()).equals("0001-01-01 00:00:00")?Tool.stringOfDateTime(new Date()):Tool.stringOfDateTime(v.getAddTime()));
      out.write("\">\r\n");
      out.write("<input type=\"hidden\" name=\"ModiTime\" id=\"ModiTime\" size=\"0\" value=\"");
      out.print(Tool.stringOfDateTime(v.getModiTime()));
      out.write("\">\r\n");
      out.write("<input type=\"hidden\" id=\"ModiPerson\" name=\"ModiPerson\" value=\"");
      out.print(v.getModiPerson());
      out.write("\"/>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"right\" class=\"form_label\">项目名称</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t\t<td align=\"left\"  bgcolor=\"#ffffff\">\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t\t<input name=\"ProjectName\" id=\"ProjectName\" size=\"45\" maxsize=\"45\" value=\"");
      out.print(v.getProjectName());
      out.write("\">\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"right\" class=\"form_label\">发布单位</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t\t<td align=\"left\"  bgcolor=\"#ffffff\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t\t");
      out.print(HtmlTool.renderSelect(RoleNameOptions, v.getProjectUnit(), "ProjectUnit", ""+userInfo.getUserCode().getRoles(),true));
      out.write("\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t<tr>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"right\" class=\"form_label\">负责人</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t\t<td align=\"left\"  bgcolor=\"#ffffff\">\r\n");
//=HtmlTool.renderSelect(UserNameoptions, v.getProjectLeader(), "ProjectLeader", "")
      out.write("\r\n");
      out.write("<input id=\"ProjectLeader\" name=\"ProjectLeader\" value=\"");
      out.print(v.getProjectLeader());
      out.write("\"/>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"right\" class=\"form_label\">联系方式</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t\t<td align=\"left\"  bgcolor=\"#ffffff\">\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t\t<input name=\"ProjectId\" id=\"ProjectId\" size=\"45\" maxsize=\"45\" value=\"");
      out.print(v.getProjectId());
      out.write("\">\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t<tr>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"right\" class=\"form_label\">开始时间</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t\t<td align=\"left\"  bgcolor=\"#ffffff\">\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t\t<input class=\"date\" readonly=\"readonly\"\tonfocus=\"WdatePicker({el:'TimeStart',dateFmt:'yyyy-MM-dd'})\"name=\"TimeStart\" id=\"TimeStart\" value=\"");
      out.print(Tool.stringOfDate(Tool.stringToDate(v.getTimeStart())));
      out.write("\"/>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"right\" class=\"form_label\">结束时间</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t\t<td align=\"left\"  bgcolor=\"#ffffff\">\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t\t<input class=\"date\" readonly=\"readonly\"\tonfocus=\"WdatePicker({el:'TimeEnd',dateFmt:'yyyy-MM-dd'})\"name=\"TimeEnd\" id=\"TimeEnd\" value=\"");
      out.print(Tool.stringOfDate(Tool.stringToDate(v.getTimeEnd())));
      out.write("\"/>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"right\" class=\"form_label\">项目详情</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t\t<td align=\"left\"  bgcolor=\"#ffffff\" colspan=\"3\">\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t\t<textarea name=\"ProjectDetail\" id=\"ProjectDetail\" cols=\"40\" rows=\"2\" style=\"width: 90%;\">");
      out.print(v.getProjectDetail());
      out.write("</textarea>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t</tr>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"right\" class=\"form_label\">备注</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t\t<td align=\"left\"  bgcolor=\"#ffffff\" colspan=\"3\">\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t\t<textarea name=\"Remark\" id=\"Remark\" cols=\"40\" rows=\"2\" style=\"width: 90%;\">");
      out.print(v.getRemark());
      out.write("</textarea>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t</tr>\r\n");
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
