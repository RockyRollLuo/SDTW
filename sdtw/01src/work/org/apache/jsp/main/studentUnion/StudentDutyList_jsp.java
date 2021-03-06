/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-24 08:56:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main.studentUnion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.base.Power;
import com.xietong.software.sdtw.club.CurrentSemester;
import com.xietong.software.sdtw.studentUnion.StudentUnionUtil;
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

public final class StudentDutyList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	StudentUnionUtil util = new StudentUnionUtil();
	List YearOption = util.getYearOption(2016);
	String schoolyear = ParamUtils.getParameter(request,"_schoolyear_",CurrentSemester.getSchoolYear(new Date()));
	String classname = ParamUtils.getParameter(request,"_classname_","");
	String academy = ParamUtils.getParameter(request,"_academy_","-1");
	
	
	List cdt = new ArrayList();
	cdt.add("id="+academy);
	cdt.add("flag=1");
	List AcademyNameOptions = COptionConst.getAcademyNameOptions(userInfo,"",cdt);
	cdt.clear();
	cdt.add("academy="+academy);
	List ClassesNameOptions = util.getClassesNameOptions(cdt);
	
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/main/jqueryui.jsp", out, true);
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/images/skin/");
      out.print(userInfo.getSkinId());
      out.write("/css.css\">\r\n");
      out.write("<script src=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/js/listfunction_win8.js\"></script>\r\n");
      out.write("<link type=\"text/css\" href=\"");
      out.print(HeadConst.apache_url+"/main/" );
      out.write("js/chosen/chosen.css\" rel=\"stylesheet\"/>\r\n");
      out.write("<script language=\"javascript\" src=\"");
      out.print(HeadConst.apache_url+"/main/" );
      out.write("/js/chosen/chosen.jquery.js\"></script>\r\n");
      out.write("<title> ");
      out.print(request.getAttribute("describe"));
      out.write(" </title>\r\n");
      out.write("<script>\r\n");
      out.write("function add(page,cmd) {\r\n");
      out.write("\tvar schoolyear = $('#_schoolyear_').val();\r\n");
      out.write("\tlocation = \"StudentDutyFrom.jsp?page=\"+page+\"&_academy_=");
      out.print(academy);
      out.write("&_schoolyear_=\"+schoolyear+\"&cmd=\"+cmd;\r\n");
      out.write("}\r\n");
      out.write("function init() {\r\n");
      out.write("\t$(\"#_schoolyear_\").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:\"没有找到\"});\r\n");
      out.write("\t$(\"#_classname_\").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:\"没有找到\"});\r\n");
      out.write("} \r\n");
      out.write("function resetthis(id) {\r\n");
      out.write("\t$('#'+id).val(\"\");\r\n");
      out.write("\t$(\"#\"+id).trigger(\"chosen:updated\");\r\n");
      out.write("}\r\n");
      out.write("function modifyClass(cmd,schoolyear,classname,academy,page) {\r\n");
      out.write("\tvar url= \"StudentDutyFrom.jsp?cmd=\"+cmd+\"&_academy_=\"+academy+\"&_schoolyear_=\"+schoolyear+\"&_classname_=\"+classname+\"&page=\"+page;\r\n");
      out.write("\tlocation = url;\r\n");
      out.write("}\r\n");
      out.write("function showmsg(id,title) {//学生id\r\n");
      out.write("\tvar url = \"");
      out.print(HeadConst.apache_url);
      out.write("/main/studentUnion/ShowStudentMsg.jsp?id=\"+id;\r\n");
      out.write("\tparent.showDialog (url,500,267,title\r\n");
      out.write("            /* ,{ '确定': function(){\r\n");
      out.write("                 // parent.checkDate();\r\n");
      out.write("            }\r\n");
      out.write("  } */);\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("function submitthis() {\r\n");
      out.write("\t$('#postForm').submit();\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<title></title>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"init()\">\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
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
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t          <div class=\"browsetitle001\">班级列表</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t          <div class=\"browsetitle002\">");
      out.print(XtUtil.getSpell("班级列表"));
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t          </div> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t          <div class=\"browsetitleright\" style=\"width: 200px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t              <div class=\"anniulist2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t           <ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t           ");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t           ");

														           if (userInfo.hasFunPower(Power.UserAdminPower)) {//学院用户
														           
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t            <li><a href=\"javascript:add(");
      out.print(currpage);
      out.write(",'insert');\">增加</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t            ");
}
														           if (userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.SHGZ)) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t        \t   <li><a href=\"AcademyList1.jsp\" >返回</a></li> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t           ");
}
														           
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t            \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t            <li><a href=\"javascript:submitthis();\">查询</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t            </ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t              </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t           </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t            </div>\t                                   </td>\r\n");
      out.write("                                </tr>    \t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("    \t\t\t\t\t\t\t\t<form action=\"StudentDutyList.jsp\" name=\"query\" id=\"postForm\" method=\"post\">\r\n");
      out.write("    \t\t\t\t\t\t\t\t<input id=\"_academy_\" name=\"_academy_\" value=\"");
      out.print(academy);
      out.write("\" type=\"hidden\"/>\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t<table border=0 cellspacing=3 cellpadding=5 width=\"100%\">\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t<td><div align=\"right\">学年</div></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      out.print(HtmlTool.renderSelect(YearOption, schoolyear, "_schoolyear_", ""));
      out.write("<a href=\"javascript:resetthis('_schoolyear_');\">重置</a></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><div align=\"right\">班级</div></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>");
      out.print(HtmlTool.renderSelect(ClassesNameOptions, classname, "_classname_", ""));
      out.write("<a href=\"javascript:resetthis('_classname_');\">重置</a></td>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t</table>\r\n");
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
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td onclick=\"javascript:setOrderBy('StandardUpGradeName', '')\" nowrap=\"\" bgcolor=\"#3992d0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"browsetable004\">编辑</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td onclick=\"javascript:setOrderBy('StandardUpGradeName', '')\" nowrap=\"\" bgcolor=\"#3992d0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"browsetable004\">学年</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td onclick=\"javascript:setOrderBy('StandardUpGradeName', '')\" nowrap=\"\" bgcolor=\"#3992d0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"browsetable004\">班级</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td onclick=\"javascript:setOrderBy('Principal', '')\" nowrap=\"\" bgcolor=\"#3992d0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"browsetable004\">班长</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td onclick=\"javascript:setOrderBy('Principal', '')\" nowrap=\"\" bgcolor=\"#3992d0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"browsetable004\">团支书</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td onclick=\"javascript:setOrderBy('Principal', '')\" nowrap=\"\" bgcolor=\"#3992d0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"browsetable004\">其他班委</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");

																Map<String,List<StudentClassDuty>>map = new HashMap<String,List<StudentClassDuty>>();
																map = util.getStudentDutyMap(academy,schoolyear,classname);
																if (map.size()>0) {
																	String d = "odd";
																	int num = 0;
																 for (Iterator it = map.keySet().iterator();it.hasNext();) {
																	 if (num%2==0) {
																			d = "even";
																		}else{
																			d = "odd";
																		}
																	String key = (String)it.next();
																	List valList = map.get(key);
																	List snoList = new ArrayList();
																	List list0 = new ArrayList();
																	List list1 = new ArrayList();
																	List list2 = new ArrayList();
																	if (valList.size()>0) {
																		for (int i=0;i<valList.size();i++) {
																			StudentClassDuty v = new StudentClassDuty();
																			v = (StudentClassDuty)valList.get(i);
																			snoList.add(v.getSno());
																			
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
}
																		BaseUserCode user = new BaseUserCode();
																		Map<String,BaseUserCode>usermap = new HashMap<String,BaseUserCode>();
																		List cdt1 = new ArrayList();
																		List userlist = new ArrayList();
																		cdt1.add("name in("+XtUtil.getIdsStr(Tool.join(",",snoList))+")");
																		userlist = user.query(cdt1);
																		if (userlist.size()>0) {
																			for (int i=0;i<userlist.size();i++) {
																				user = (BaseUserCode)userlist.get(i);
																				usermap.put(user.getName(),user);
																			}
																		}
																		for (int i=0;i<valList.size();i++) {
																			StudentClassDuty v = new StudentClassDuty();
																			v = (StudentClassDuty)valList.get(i);
																			BaseUserCode u = new BaseUserCode();
																			u = usermap.get(v.getSno())==null?new BaseUserCode():usermap.get(v.getSno());
																			if ("0".equals(v.getDuty())) {//班长
																				list0.add("<a href='javascript:showmsg("+u.getId()+",\"班长信息\")'>"+u.getCnName()+"</a>");
																			}
																			if ("1".equals(v.getDuty())) {//团支书
																				list1.add("<a href='javascript:showmsg("+u.getId()+",\"团支书信息\")'>"+u.getCnName()+"</a>");
																			}
																			if ("2".equals(v.getDuty())) {//其他班委
																				list2.add("<a href='javascript:showmsg("+u.getId()+",\"其他班委信息\")'>"+u.getCnName()+"</a>");
																			}
																		}
																	}
																	
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr onmouseover=\"addClass(this,'data_bgcolor_over');\" onmouseout=\"removeClass(this,'data_bgcolor_over');\"class=\"data_bgcolor_");
      out.print(d );
      out.write("\" style=\"cursor: pointer;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
String clas =  (String)(key.split("_")[0]);
																	String year =  (String)(key.split("_")[1]);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"xxybgx2\" onclick=\"javascript:modifyClass('modify','");
      out.print(year );
      out.write('\'');
      out.write(',');
      out.print(clas );
      out.write(',');
      out.print(academy );
      out.write(',');
      out.print(currpage);
      out.write(")\">&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"browsetable005\" align=\"center\">");
      out.print(year );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"browsetable005\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
      out.print(HtmlTool.renderSelect(ClassesNameOptions, clas , "classname", clas,true));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"browsetable005\" align=\"center\">");
      out.print(Tool.join(",",list0) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"browsetable005\" align=\"center\">");
      out.print(Tool.join(",",list1) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"browsetable005\" align=\"center\">");
      out.print(Tool.join(",",list2) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");

																num++;
																 }
																} else {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr onmouseover=\"addClass(this,'data_bgcolor_over');\" onmouseout=\"removeClass(this,'data_bgcolor_over');\"class=\"data_bgcolor_odd\" style=\"cursor: pointer;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"browsetable005\" align=\"center\" colspan=\"7\">没有记录!</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
}
																
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
