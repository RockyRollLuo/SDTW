/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-20 02:50:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main.volunter;

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
import com.xietong.software.base.Power;
import com.xietong.software.common.UserInfo;
import com.xietong.software.common.HeadConst;
import com.xietong.software.util.Tool;

public final class VolunteerParticipateList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	private static Log log = LogFactory.getLog(com.xietong.software.common.PageControl.class);

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
      out.write('\r');
      out.write('\n');

	log.debug("List");
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "list");
	StringBuffer str = new StringBuffer();
	List rows = (List)request.getAttribute("List");
	if (rows == null) {
    		out.print(HtmlTool.msgBox(request, "请先调用Action.jsp！"));
    		return;
	}
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	Map extMaps = (Map)request.getAttribute("Ext");
	List paras = HttpTool.getSavedUrlForm(request, "Ext");
	List urls = (List)paras.get(0);
	List forms = (List)paras.get(1);
	urls.addAll((List)paras.get(2));
	String url = Tool.join("&", urls);
	//url="ActivityId="+ParamUtils.getIntParameter(request, "ActivityId", 1);
	System.out.println("当前网址"+url );
	PageControl pagecontrol = (PageControl)request.getAttribute("PageControl");
	if (pagecontrol == null) {
    		pagecontrol = new PageControl(0, 1, 1);
	}
	String[] dickeys = (String[])request.getAttribute("dickeys");
	String[][] dicvalues = (String[][])request.getAttribute("dicvalues");
	List diclist = new ArrayList();
	for (int i = 0; i < dickeys.length; i ++) {
    		diclist.add("\"" + dickeys[i] + "\": [\"" + Tool.join("\", \"", dicvalues[i]) + "\"]");
	}
	//默认值定义
	UserInfo userInfo = Tool.getUserInfo(request);
	if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
	}
	BaseUserCode user= userInfo.getUserCode();
	int  projectid = ParamUtils.getIntParameter(request, "_ActivityId_", -1);
	System.out.println(projectid );
	VolunteerActivity va= new VolunteerActivity();
	va= va.getById(projectid);
	String check=ParamUtils.getParameter(request, "CheckFlag", "");
	System.out.println( check);


      out.write("\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/images/skin/");
      out.print(userInfo.getSkinId());
      out.write("/css.css\">\r\n");
      out.write("\t\t<title> ");
      out.print(request.getAttribute("describe"));
      out.write(" </title>\r\n");
      out.write("\t\t<script src=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/js/listfunction_win8.js\"></script>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\tvar curr_orderby = [\"");
      out.print(HttpTool.getString(extMaps, "orderfield", ""));
      out.write("\", \"");
      out.print(HttpTool.getString(extMaps, "ordertype", ""));
      out.write("\"];\r\n");
      out.write("\t\t\tvar url_para = \"");
      out.print(url);
      out.write("\";\r\n");
      out.write("\t\t//\talert( url_para);\r\n");
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
      out.write("\t\t\tvar queryfields = [\"");
      out.print(Tool.join("\", \"", (String[])request.getAttribute("queryfields")));
      out.write("\"];\r\n");
      out.write("\t\t\tvar queryvalues = [\"");
      out.print(Tool.join("\", \"", (List)request.getAttribute("queryvalues")));
      out.write("\"];\r\n");
      out.write("\t\t\tvar rows = [");
      out.print(Tool.join(", ", rows));
      out.write("];\r\n");
      out.write("\t\t\tvar hidefields = [\"");
      out.print(Tool.join("\", \"", (String[])request.getAttribute("hidefields")));
      out.write("\"];\r\n");
      out.write("\t\t\tfunction init() {\r\n");
      out.write("    \t\t\t\tshowList(\"");
      out.print(request.getAttribute("classname"));
      out.write('"');
      out.write(',');
      out.write(' ');
      out.print(pagecontrol.getCurrPage());
      out.write(", url_para);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfunction modifyList(className, url_para){\r\n");
      out.write("\t\t\t\tmodifyList1(className, url_para, 1);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfunction modifyList1(className, url_para, page)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t    var chks = document.getElementsByName(\"chk1\");\r\n");
      out.write("\t\t\t    if (!url_para)\r\n");
      out.write("\t\t\t        url_para = \"\";\r\n");
      out.write("\t\t\t    var chkeds = new Array();\r\n");
      out.write("\t\t\t    for (var i = 0; i < chks.length; i ++) {  //当前页面上有多条记录时\r\n");
      out.write("\t\t\t        if (chks[i].checked == true) {\r\n");
      out.write("\t\t\t            chkeds.push(chks[i].value);\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t    if (chkeds.length > 0) {\r\n");
      out.write("\t\t\t        if (confirm(\"确实要通过这些学生的审核吗?\")) {\r\n");
      out.write("\t\t\t        \t\r\n");
      out.write("\t\t\t            location = className + \"Action.jsp?cmd=modifylist&_ActivityId_=");
      out.print(projectid);
      out.write("&idlist=\" + chkeds.join(',') + \"&page=\" + page + ((url_para.length == 0) ? \"\" : \"&\" + url_para);\r\n");
      out.write("\t\t\t          \r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t    } else {\r\n");
      out.write("\t\t\t        alert(\"未选择记录！\");\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfunction modify1List(className, url_para){\r\n");
      out.write("\t\t\t\tmodify1List1(className, url_para, 1);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfunction modify1List1(className, url_para, page)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\t//alert( url_para);\r\n");
      out.write("\t\t\t    var chks = document.getElementsByName(\"chk1\");\r\n");
      out.write("\t\t\t    var chks3= document.getElementsByName(\"chk3\");\r\n");
      out.write("\t\t\t    \r\n");
      out.write("\t\t\t    if (!url_para)\r\n");
      out.write("\t\t\t        url_para = \"\";\r\n");
      out.write("\t\t\t    var chkeds2= new Array();\r\n");
      out.write("\t\t\t    var chkeds = new Array();\r\n");
      out.write("\t\t\t    for (var i = 0; i < chks.length; i ++) {  //当前页面上有多条记录时\r\n");
      out.write("\t\t\t        if (chks[i].checked == true) {\r\n");
      out.write("\t\t\t            chkeds.push(chks[i].value);\r\n");
      out.write("\t\t\t           \r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t   \r\n");
      out.write("\t\t\t    if (chkeds.length > 0) {\r\n");
      out.write("\t\t\t        if (confirm(\"确实要拒绝通过这些学生的审核吗?\")) {\r\n");
      out.write("\t\t\t        \t//alert(className + \"Action.jsp?cmd=modifylist1&idlist=\" + chkeds.join(',') + \"&page=\" + page + ((url_para.length == 0) ? \"\" : \"&\" + url_para));\r\n");
      out.write("\t\t\t            location = className + \"Action.jsp?cmd=modifylist1&_ActivityId_=");
      out.print(projectid);
      out.write("&idlist=\" + chkeds.join(',') + \"&page=\" + page + ((url_para.length == 0) ? \"\" : \"&\" + url_para);\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t    } else {\r\n");
      out.write("\t\t\t        alert(\"未选择记录！\");\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body onload=\"init();\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/main/jqueryui.jsp", out, true);
      out.write("\r\n");
      out.write("\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t<tr> \r\n");
      out.write("\t\t\t\t<td valign=\"top\">\r\n");
      out.write("\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td valign=\"top\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t<td height=\"26\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("                               <tr>\r\n");
      out.write("                                   <td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t            <div class=\"browsetitle title_css\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t            <div class=\"browsetitleleft\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t            ");

												            String biaoti="志愿活动报名表";
												            int checkfalg=ParamUtils.getIntParameter(request, "_CheckFlag_", -1);
												            if(checkfalg==1){
												            	biaoti="志愿活动分配荣誉";
												            }
												            
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t          <div class=\"browsetitle001\">");
      out.print(biaoti );
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t       \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t          </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t          <div class=\"browsetitleright\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t           \t              <div class=\"anniulist2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t           <ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t             \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t           \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t      \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t           \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t              <li> <a href=\"VolunteerActivityAction.jsp\" >返回</a></li> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t              ");
if(va.getAddAccount().equals(user.getId()+"")&&checkfalg!=1){ 
      out.write("   \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t            <li><a href=\"javascript:modifyList('");
      out.print(request.getAttribute("classname"));
      out.write("', url_para);\">通过</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t          \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t             <li><a href=\"javascript:modify1List('");
      out.print(request.getAttribute("classname"));
      out.write("', url_para);\">不通过</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t             ");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t            </ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t            \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t              </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t           </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t            </div>\t                                   </td>\r\n");
      out.write("                                </tr>    \t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("    \t\t\t\t\t\t\t\t<form action=\"");
      out.print(request.getAttribute("classname"));
      out.write("Action.jsp\" name=\"query\" id=\"postForm\" method=\"post\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("                               <div class=\"browsetable2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"cmd\" value=\"list\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\"   name=\"_ActivityId_\" value=\"");
      out.print(projectid);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");
      out.print(Tool.join("\n", forms));
      out.write("\r\n");
      out.write("                               </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t<td valign=\"top\">\r\n");
      out.write("      \t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"2\" cellspacing=\"0\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("          \t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"list\" class=\"browsetable\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
      out.print((("listall".equals(cmd)))? "": pagecontrol.getControl_win8((String)request.getAttribute("classname") + "Action.jsp?cmd=list" + ((url.length() == 0) ? "" : "&" + url),  HeadConst.apache_url+"/main/images/skin/"+userInfo.getSkinId()));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("      \t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t                \t\t\t</td>\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
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
