/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-07 08:48:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main.standardupgrade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.math.BigDecimal;
import com.xietong.software.base.Power;
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

public final class shangbaoList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
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
      out.write('\r');
      out.write('\n');

	log.debug("List");
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "list");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	//默认值定义
	UserInfo userInfo = Tool.getUserInfo(request);
	if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
	}
	StandardupGradeUtil util = new StandardupGradeUtil();
	//aid学院id sid团委通知id
	int aid = ParamUtils.getIntParameter(request,"aid",-1);
	int sid = ParamUtils.getIntParameter(request,"sid",-1);
	Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);

      out.write("\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/images/skin/");
      out.print(userInfo.getSkinId());
      out.write("/css.css\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/main/jqueryui.jsp", out, true);
      out.write("\r\n");
      out.write("\t\t<script src=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/js/listfunction_win8.js\"></script>\r\n");
      out.write("\t\t<title> ");
      out.print(request.getAttribute("describe"));
      out.write(" </title>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\tfunction addItem(id){\r\n");
      out.write("\t\t\tparent.showDialog('");
      out.print(HeadConst.apache_url);
      out.write("/main/standardupgrade/addFile.jsp?aid=");
      out.print(userInfo.getUserCode().getDeptId());
      out.write("&sid=");
      out.print(sid);
      out.write("&id='+id,400,300,\"添加\"\r\n");
      out.write("\t\t\t\t\t,{\"确定\":function(){\r\n");
      out.write("\t\t\t\t\t\tparent.addFile();\r\n");
      out.write("\t\t\t\t\t}});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction delFile(id) {\r\n");
      out.write("\t\t\tif (confirm(\"确实要删除这些记录吗?\")) {\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\t\t\t///sdfz/01src/web\r\n");
      out.write("\t\t\t\t\turl : \"");
      out.print(HeadConst.apache_url);
      out.write("/main/standardupgrade/StandardupGrade_FileAction.jsp?cmd=delFile&Id=\"+id,\r\n");
      out.write("\t\t\t\t\tdataType : \"json\",\r\n");
      out.write("\t\t\t\t\tcache : false,\r\n");
      out.write("\t\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\t\tif (data.msg==\"ok\") {\r\n");
      out.write("\t\t\t\t\t\t\twindow.location.reload();\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\terror : function() {\r\n");
      out.write("\t\t\t\t\t\t// view(\"异常！\"); \r\n");
      out.write("\t\t\t\t\t\talert(\"异常！\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction summitItem(flag){\r\n");
      out.write("\t\t\tvar aid = ");
      out.print(aid);
      out.write(";\r\n");
      out.write("\t\t\tvar sid = ");
      out.print(sid);
      out.write(";\r\n");
      out.write("\t\t\tvar str = \"\";\r\n");
      out.write("\t\t\tif (flag==0) {\r\n");
      out.write("\t\t\t\tstr = \"提交\"\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (flag==1) {\r\n");
      out.write("\t\t\t\tstr = \"审核\"\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (confirm(\"确实要\"+str+\"这些记录吗?\")) {\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\t\t\t///sdfz/01src/web\r\n");
      out.write("\t\t\t\t\turl : \"");
      out.print(HeadConst.apache_url);
      out.write("/main/standardupgrade/StandardupGrade_FileAction.jsp?cmd=submitFile&aid=\"+aid+\"&sid=\"+sid+\"&ChackFlag=\"+flag,\r\n");
      out.write("\t\t\t\t\tdataType : \"json\",\r\n");
      out.write("\t\t\t\t\tcache : false,\r\n");
      out.write("\t\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\t\tif (data.msg==\"ok\") {\r\n");
      out.write("\t\t\t\t\t\t\talert(\"操作成功！\");\r\n");
      out.write("\t\t\t\t\t\t\twindow.location.reload();\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\tif (data.msg==\"no\") {\r\n");
      out.write("\t\t\t\t\t\t\talert(\"请勿重复审核！\");\r\n");
      out.write("\t\t\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\terror : function() {\r\n");
      out.write("\t\t\t\t\t\t// view(\"异常！\"); \r\n");
      out.write("\t\t\t\t\t\talert(\"异常！\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
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
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t             <div class=\"browsetitleleft\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t          <div class=\"browsetitle001\">");
      out.print(AcademyNameMap.get(aid+"") );
      out.write("课题资料上报情况</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t          <div class=\"browsetitle002\">");
      out.print(XtUtil.getSpell((String)AcademyNameMap.get(aid+"")));
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t          </div> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t          <div class=\"browsetitleright\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t              <div class=\"anniulist2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t           <ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t            ");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t            ");

														            if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.ZZJS)) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t            <li><a href=\"AcademyList.jsp?aid=");
      out.print(aid );
      out.write("&sid=");
      out.print(sid );
      out.write("\" >返回</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t            <li><a href=\"javascript:summitItem(1);\">审核</a></li> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t            ");
}
														            if(userInfo.hasFunPower(Power.UserAdminPower)) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t            \t<li><a href=\"StandardupGradeAction.jsp?cmd=list&page=");
      out.print(currpage);
      out.write("&sid=");
      out.print(sid );
      out.write("\" >返回</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t            <li><a href=\"javascript:summitItem(0);\">提交</a></li> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t            <li><a href=\"javascript:addItem();\">添加</a></li> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t            ");
}
														            
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t            </ul>\r\n");
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
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"list\" class=\"browsetable\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table cellspacing=\"1\" cellpadding=\"2\" border=\"0\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"100%\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  nowrap=\"\" bgcolor=\"#3992d0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"browsetable004\">团支部名称</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  nowrap=\"\" bgcolor=\"#3992d0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"browsetable004\">团支部人数</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  nowrap=\"\" bgcolor=\"#3992d0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"browsetable004\">申报等级</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  nowrap=\"\" bgcolor=\"#3992d0\" style=\"width: 8%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"browsetable004\">操作</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  nowrap=\"\" bgcolor=\"#3992d0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"browsetable004\">占比 </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");

																Map ApplyLevelTypeMap = CEditConst.getApplyLevelTypeMap(userInfo);
																Map<String,Object> map = new HashMap<String,Object>();
																map = util.getShangbaoListMap(aid,sid,userInfo);
																if (map.size()>0) {
																for (int i=0;i<4;i++) {
																if (map.get(""+i)!=null) {
																	List<StandardupGrade_File> list0 = new ArrayList<StandardupGrade_File> ();
																	list0 = (List)map.get(""+i);
																	System.out.println(list0.size());
																	if (list0.size()>0) {
																		int nums = 0;
																		String d = "odd";
																		for (int j=0;j<list0.size();j++) {
																			StandardupGrade_File v = new StandardupGrade_File();
																			v = list0.get(j);
																			nums+=v.getZBNums();
																		}
																		for (int j=0;j<list0.size();j++) {
																			StandardupGrade_File v = new StandardupGrade_File();
																			v = list0.get(j);
																			if (i%2==0) {
																				d = "even";
																			}else{
																				d = "odd";
																			}
																			
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr onmouseover=\"addClass(this,'data_bgcolor_over');\" onmouseout=\"removeClass(this,'data_bgcolor_over');\"class=\"data_bgcolor_");
      out.print(d );
      out.write("\" style=\"cursor: pointer;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  nowrap=\"\"  align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"browsetable005\">");
      out.print(v.getZBName() );
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  nowrap=\"\"  align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"browsetable005\">");
      out.print(v.getZBNums() );
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  nowrap=\"\"  align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"browsetable005\">");
      out.print(ApplyLevelTypeMap.get(v.getApplyLevelType()) );
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");

																	if("".equals(v.getChackFlag())) {
																	
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  nowrap=\"\"  align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"browsetable005\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:addItem(");
      out.print(v.getId());
      out.write(");\">编辑</a>&nbsp;&nbsp;<a href=\"javascript:delFile(");
      out.print(v.getId());
      out.write(");\">删除</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
} else {
																		String flag = "";
																		if("0".equals(v.getChackFlag())) {
																			flag = "已提交";
																		}
																		if ("1".equals(v.getChackFlag())) {
																			flag = "审核通过";
																		}
																	
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>");
      out.print(flag );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
} 
																	
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");

																	if (j==0) {
																	
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  rowspan=\"");
      out.print(j==0?list0.size():1 );
      out.write("\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"browsetable005\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");

																	double per = (nums*1.0/(Integer)map.get("nums")*100);
																	BigDecimal   b   =   new   BigDecimal(per);  
																	double   percent   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
																	
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
      out.print(percent );
      out.write("%</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");

																		}
																	}
																}
																}
																} else {
																	
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td bgcolor=\"#ffffff\" colspan=\"5\" align=\"center\">没有上传</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
}
																map.clear();
																
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div> \r\n");
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