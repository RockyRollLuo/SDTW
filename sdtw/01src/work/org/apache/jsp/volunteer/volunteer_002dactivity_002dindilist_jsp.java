/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-20 03:44:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.volunteer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.common.CEditConst;
import com.xietong.software.util.Tool;
import com.xietong.software.sdtw.db.*;
import java.sql.*;
import java.util.*;
import com.xietong.software.common.UserInfo;
import com.xietong.software.common.HtmlTool;

public final class volunteer_002dactivity_002dindilist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/volunteer/pagetop-positionandhelp.jsp", Long.valueOf(1489367536655L));
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
      response.setContentType("text/html;charset=utf-8");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

String sno=(String)session.getAttribute("useraccount");



      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"../main/css/common-student.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<script src=\"../main/js/tablelist.js\"></script>\r\n");
      out.write("<script src=\"../main/js/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");

UserInfo userinfo=Tool.getUserInfo(request);
if(userinfo==null){
	return;
}
BaseUserCode user= new BaseUserCode();

user=userinfo.getUserCode();
user=user.getById(user.getId());
if(user.getVolunteerfFag().equals("1")){

      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<table class=\"location-table\">\r\n");
      out.write("<tr height=\"35\">\r\n");
      out.write("\t<td class=\"location-title\" >您的位置：志愿服务：志愿履历浏览\r\n");
      out.write("\t\t<span style=\"cursor:pointer;\" onclick=\"showorhide_div('helpdiv')\"></span>\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");

String strposition = "志愿服务工作  >> 志愿服务履历 >> ";
String strfunction = "参与志愿活动列表";
String strhelpwords= "该列表列出了详细信息。";

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table class=\"command-table\">\r\n");
      out.write("<tr>\r\n");
      out.write("    <td>\r\n");
      out.write("       <a href=\"#\" onclick=\"history.go(-1)\">返回</a> \r\n");
      out.write("    </td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<table class=\"content-table\">\r\n");
      out.write("\r\n");
      out.write("<tr >\r\n");
      out.write("\t<th width=\"5%\">序号</th>\r\n");
      out.write("\t<th width=\"20%\">&nbsp;活动名称</th>\r\n");
      out.write("\t<th width=\"20%\">&nbsp;活动级别</th>\r\n");
      out.write("\t<th width=\"20%\">&nbsp;活动类别</th>\r\n");
      out.write("\t<th width=\"20%\">&nbsp;服务时长</th>\r\n");
      out.write("\t<th align=\"center\">&nbsp;所获荣誉</th>\r\n");
      out.write("</tr>\r\n");


Map activityNamemap= CEditConst.getVolunActivityNameMap(userinfo);

ResultSet rs=null,rs2 = null;
String  activityname="",activitykind="",activitylevel="",honourname="",servicelength ="";
List list= new ArrayList();
List cdt= new ArrayList();
VolunteerActivity va=new VolunteerActivity();
cdt.add("checkflag=1");
Map<String,VolunteerActivity> map= new HashMap<String,VolunteerActivity>();
list=va.query(cdt);
if(list.size()>0){
	for(int i=0;i<list.size();i++){
		va=(VolunteerActivity )list.get(i);
		map.put(va.getId()+"", va);
	}
}
System.out.println(map);
List list1= new ArrayList();
List cdt1= new ArrayList();
VolunteerParticipate vp= new VolunteerParticipate();
cdt1.add("sno='"+user.getName()+"'");
cdt1.add("checkflag=1");
list1=vp.query(cdt1);
if(list1.size()>0){
	for(int i=0;i<list1.size();i++){
		vp=(VolunteerParticipate)list1.get(i);	
		activityname="<a href='volunteer-activity-details.jsp?id="+va.getId()+"'>"+(String)activityNamemap.get(vp.getActivityId()+"")+"</a>";
		servicelength =vp.getServicelenth()+"";
		honourname=vp.getHonourName();
		if(map.containsKey(vp.getActivityId()+"")){
			va=map.get(vp.getActivityId()+"");
			activitylevel=va.getActivityLevel();
			activitykind=va.getActivityKind();
		}
 
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>");
      out.print(i+1);
      out.write("&nbsp;</td>\r\n");
      out.write("\t<td>");
      out.print(activityname);
      out.write("&nbsp;</td>\r\n");
      out.write("\t<td>");
      out.print(activitylevel);
      out.write("&nbsp;</td>\r\n");
      out.write("\t<td>");
      out.print(activitykind);
      out.write("&nbsp;</td>\r\n");
      out.write("\t<td>");
      out.print(servicelength );
      out.write("&nbsp;</td>\r\n");
      out.write("\t<td>");
      out.print(honourname);
      out.write("&nbsp;</td>\r\n");
      out.write(" </tr>\r\n");
}} else{
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td colspan=\"6\" >未参与过志愿活动!</td>\r\n");
      out.write("</tr>\t\r\n");
} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>    \r\n");
      out.write("\t<th  colspan=\"6\" align=\"left\">参加所有活动服务总时长\t\r\n");
      out.write("\t</th>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
}else{
	
      out.write("\r\n");
      out.write("\t<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

String strposition = "志愿服务信息  >> ";
String strfunction = "志愿者申请";
String strhelpwords= "申请成为志愿者。";
UserInfo userInfo = Tool.getUserInfo(request);

if(userInfo == null){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}else{
user = userInfo.getUserCode();
}
System.out.println(user.getName()+".............2222222222222...............");

      out.write('\r');
      out.write('\n');
      out.write(' ');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table class=\"location-table\">\r\n");
      out.write("<tr height=\"35\">\r\n");
      out.write("\t<td class=\"location-title\" >您的位置：\r\n");
      out.write("\t\t<span style=\"cursor:pointer;\" onclick=\"showorhide_div('helpdiv')\"></span>\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<div id=\"helpdiv\" style=\"display:none;\">\r\n");
      out.write("<table \tclass=\"location-help\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" >\r\n");
      out.write("<tr height=\"20\">\r\n");
      out.write("\t<td align=\"left\">系统帮助：</td>\r\n");
      out.write("   \t<td width=\"30\"> \r\n");
      out.write("\t\t<a align=\"right\" href=\"#\" onclick=\"showorhide_div('helpdiv')\"><font face='Webdings' color='#FF0000' style='font- size:32pt'>r</font></a>\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr height=\"20\">\r\n");
      out.write("\t<td align=\"left\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function showorhide_div(menu){\r\n");
      out.write("    $(\"#\"+menu).toggle();\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"table1\" style=\"display:none;\">\r\n");
      out.write("<table class=\"frame-table\" align=\"center\">\r\n");
      out.write("  <tr height=\"50px\"><th>系统提示</th></tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>欢迎您加入山东大学青年志愿者协会，您可以：<br><br>\r\n");
      out.write("    <a href=\"volunteer-activity-list.jsp\" target=\"_self\">浏览志愿活动</a><br>\r\n");
      out.write("\t  <a href=\"volunteer-project-list.jsp\" target=\"_self\">参加志愿竞赛项目</a><br>\r\n");
      out.write("\t  <a href=\"volunteer-search.jsp\" target=\"_self\">进行志愿信息查询</a>\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr height=\"50px\">\r\n");
      out.write("\t<th>\r\n");
      out.write("\t  \r\n");
      out.write("\t</th>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"table2\" >\r\n");
      out.write("<table class=\"frame-table\" align=\"center\">\r\n");
      out.write("  <tr height=\"50px\"><th>系统提示</th></tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>您尚未加入山东大学青年志愿者协会，是否申请成为志愿者？</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr height=\"50px\">\r\n");
      out.write("\t<th>\r\n");
      out.write("\t\r\n");
      out.write("\t  <a href=\"../main/volunter/BaseUserCodeAction.jsp?cmd=gaiziyuan&Id=");
      out.print(user.getId());
      out.write("\" target=\"_self\">是</a> | \r\n");
      out.write("\t  <a href=\"#\">否</a>  \r\n");
      out.write("\t</th>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("\t\r\n");
} 
      out.write("\r\n");
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
