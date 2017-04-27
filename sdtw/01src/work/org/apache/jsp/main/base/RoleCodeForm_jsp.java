/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-03-31 07:36:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main.base;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.sdtw.db.BaseRoleCode;
import com.xietong.software.util.*;
import com.xietong.software.common.*;
import org.apache.commons.logging.*;
import java.io.*;
import java.util.*;
import com.xietong.software.common.UserInfo;
import com.xietong.software.common.HeadConst;
import com.xietong.software.util.Tool;

public final class RoleCodeForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	Log log = LogFactory.getLog(BaseRoleCode.class);
	String msg = (String) request.getAttribute("msg");
	if ((msg != null)) {
		out.print(HtmlTool.msgBox(request, msg));
		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	BaseRoleCode v = (BaseRoleCode) request.getAttribute("fromBean");
	if (v == null) {
		out.print(HtmlTool.msgBox(request, "请先调用Action.jsp！"));
		return;
	}
	log.debug(request.getAttribute("classname") + "Form");
	String[] dickeys = (String[]) request.getAttribute("dickeys");
	String[][] dicvalues = (String[][]) request
			.getAttribute("dicvalues");
	List diclist = new ArrayList();
	for (int i = 0; i < dickeys.length; i++) {
		diclist.add("\"" + dickeys[i] + "\": [\""
				+ Tool.join("\", \"", dicvalues[i]) + "\"]");
	}
	Map extMaps = (Map) request.getAttribute("Ext");
	List paras = HttpTool.getSavedUrlForm(request, "Ext");
	List urls = (List) paras.get(0);
	List forms = (List) paras.get(1);
	urls.addAll((List) paras.get(2));
	forms.addAll((List) paras.get(3));
	String url = Tool.join("&", urls);
	//默认值定义
	UserInfo userInfo = Tool.getUserInfo(request);
	if (userInfo == null) {
		out.print(HtmlTool.msgBox(request, "请先登录"));
		return;
	}
	List YesNooptions = (List) request.getAttribute("YesNooptions");
	String names = (String) request.getAttribute("names");
	String funNames = (String) request.getAttribute("funNames");

      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<title>");
      out.print(request.getAttribute("describe"));
      out.write("</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/images/skin/");
      out.print(userInfo.getSkinId());
      out.write("/css_blue.css\">\r\n");
      out.write("\t<script language=\"JavaScript\"\r\n");
      out.write("\t\tsrc=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/js/validation-framework.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t\tValidationFramework.init(\"");
      out.print(request.getAttribute("classname"));
      out.write("_validation.xml\");\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t<script src=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/js/formfunction.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/js/common.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t\tvar url_para = \"");
      out.print(url);
      out.write("\";\r\n");
      out.write("\t\t\tvar dic = {");
      out.print(Tool.join(", ", diclist));
      out.write("};\r\n");
      out.write("\t\t\tvar keyfield = \"");
      out.print((String) request.getAttribute("keyfield"));
      out.write("\";\r\n");
      out.write("\t\t\tvar allfields = [\"");
      out.print(Tool.join("\", \"",
					(String[]) request.getAttribute("allfields")));
      out.write("\"];\r\n");
      out.write("\t\t\tvar fields = [\"");
      out.print(Tool.join("\", \"",
					(String[]) request.getAttribute("fields")));
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
      out.write("\t\t\tfunction choiceMoudlePower(flag){\r\n");
      out.write("\t\t\t\t//alert(\"a\");\r\n");
      out.write("\t\t\t\tif(flag==0){\r\n");
      out.write("\t\t\t\t\topenWindow(\"MoudleAction.jsp?cmd=treeSelect&flag=\"+flag+\"&ids=");
      out.print(v.getMoudleIds());
      out.write("\",\"350,350\");\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\topenWindow(\"MoudleAction.jsp?cmd=treeSelect&flag=\"+flag+\"&ids=");
      out.print(v.getFunIds());
      out.write("\",\"350,350\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"init();\">\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td valign=\"top\">\r\n");
      out.write("\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"1\" cellpadding=\"0\"\r\n");
      out.write("\t\t\t\t\tbgcolor=\"#33577B\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td bgcolor=\"#FFFFFF\" valign=\"top\">\r\n");
      out.write("\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td height=\"26\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tbackground=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/images/skin/");
      out.print(userInfo.getSkinId());
      out.write("/xxdhbj.png\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"26\"><div align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsrc=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/images/skin/");
      out.print(userInfo.getSkinId());
      out.write("/xxdhbjanl.gif\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"100\"><b class=\"bt\">[角色表]</b></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"24\"><div align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsrc=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/images/skin/");
      out.print(userInfo.getSkinId());
      out.write("/xxdhbjanr5.png\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"55\" class=\"bt\"><a\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"javascript:if (doValidate('postForm')) document.postForm.submit();\"\">保存</a></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"24\"><div align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsrc=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/images/skin/");
      out.print(userInfo.getSkinId());
      out.write("/xxdhbjanr4.png\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"55\" class=\"bt\"><a\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"RoleCodeAction.jsp?cmd=list&page=");
      out.print(currpage);
      out.print(((url.length() == 0) ? "" : "&" + url));
      out.write("\">返回</a></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td valign=\"top\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"errorDiv\" style=\"color: red; font-weight: bold\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"form\" style=\"overflow: auto; height: auto\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<form\taction=\"");
      out.print(request.getAttribute("classname"));
      out.write("Action.jsp\" method=\"post\" name=\"postForm\" id=\"postForm\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"cmd\" value=\"");
      out.print(cmd);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"page\" value=\"");
      out.print(currpage);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"Id\" value=\"");
      out.print(v.getId());
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"OrderNum\" value=\"");
      out.print(v.getOrderNum());
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"OpLog\" value=\"");
      out.print(v.getOpLog());
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
      out.print(Tool.join("\n", forms));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td height=\"2\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" width=\"100%\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr id=\"postFormName\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div align=\"right\">角色名</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td><input type=\"text\" name=\"Name\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
      out.print(v.getName());
      out.write("\" /><font color=\"red\"><b>*</b></font>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr id=\"postFormCode\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div align=\"right\">角色代码</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td><input type=\"text\" name=\"Code\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
      out.print(v.getCode());
      out.write("\" /><font color=\"red\"><b>*</b></font>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr id=\"postFormMoudleIds\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div align=\"right\">模块权限</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<textarea name=\"MoudleNames\" cols=\"50\" rows=\"4\">");
      out.print(names.equals("null") ? "" : names);
      out.write("</textarea>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <button style=\"height:25px;width:110px;\" type=\"button\" onclick=\"javascript:choiceMoudlePower(0);\" >模块权限定义</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <input type=\"hidden\" name=\"MoudleIds\" value=\"");
      out.print(v.getMoudleIds());
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr id=\"postFormMoudleCode\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div align=\"right\">模块权限代码</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td><textarea name=\"MoudleCode\" cols=\"50\" rows=\"4\">");
      out.print(v.getMoudleCode());
      out.write("</textarea>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr id=\"postFormFunIds\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div align=\"right\">功能点权限</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td><textarea name=\"FunNames\" cols=\"50\" rows=\"4\">");
      out.print(funNames.equals("null") ? "" : funNames);
      out.write("</textarea>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<button style=\"height:25px;width:120px;\" type=\"button\" onclick=\"javascript:choiceMoudlePower(1);\">功能点权限定义</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"FunIds\" value=\"");
      out.print(v.getFunIds());
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr id=\"postFormFunCodes\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div align=\"right\">功能点权限代码</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td><textarea name=\"FunCodes\" cols=\"50\" rows=\"4\">");
      out.print(v.getFunCodes());
      out.write("</textarea>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr id=\"postFormIsEnable\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div align=\"right\">有效标志</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>");
      out.print(HtmlTool.renderSelect(YesNooptions, "" + v.getIsEnable(), "IsEnable", "-1"));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</body>\r\n");
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
