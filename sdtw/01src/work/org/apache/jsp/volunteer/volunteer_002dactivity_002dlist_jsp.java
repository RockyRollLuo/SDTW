/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-25 02:56:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.volunteer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.util.ParamUtils;
import com.xietong.software.sdtw.db.VolunteerParticipate;
import com.xietong.software.sdtw.db.VolunteerActivity;
import java.util.ArrayList;
import java.sql.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import jxl.*;
import jxl.write.*;
import java.math.BigDecimal;
import com.xietong.software.common.UserInfo;
import com.xietong.software.common.HeadConst;
import com.xietong.software.base.Power;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.xietong.software.common.CEditConst;
import com.xietong.software.util.Tool;
import com.xietong.software.sdtw.db.*;
import com.xietong.software.util.*;
import com.xietong.software.common.*;

public final class volunteer_002dactivity_002dlist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

String academy = (String)session.getAttribute("academy");
String myaccount = (String)session.getAttribute("useraccount");
int pagenumstr=Integer.parseInt(ParamUtils.getParameter(request, "page", "1"));

System.out.println(pagenumstr);
int start=0;


      out.write("\r\n");
      out.write(" \r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<link href=\"../css/common-student.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<script src=\"../main/js/tablelist.js\"></script>\r\n");
      out.write("<script src=\"../main/js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write(" function submit1(){\r\n");
      out.write("\t $(\"#postForm\").submit();\r\n");
      out.write("\t alert(\"111111111111\")\r\n");
      out.write("\t \r\n");
      out.write(" }\r\n");
      out.write(" \r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");

UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	if (userInfo != null) {
		userInfo.removeCookie(response);
	}
	session.removeAttribute("UserInfo");
	return ;
}
BaseUserCode user= new BaseUserCode();

user=userInfo.getUserCode();
user=user.getById(user.getId());
Map OrgNameMap=CEditConst.getOrgNameMap(userInfo);
Map detpnameMap=CEditConst.getAcademyNameMap(userInfo);
List cdt= new ArrayList();
cdt.add("flag =1");
List academyOptions=COptionConst.getAcademyNameOptions(userInfo,"", cdt);
 String xiaoqu=user.getOrgId()+"";
 String xueyuan=user.getDeptId()+"";
 System.out.println(OrgNameMap);
 System.out.println(xueyuan+xiaoqu);
 System.out.println(xiaoqu+xueyuan);
if(user.getVolunteerfFag().equals("1")){
	
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<table class=\"location-table\">\r\n");
      out.write("<tr height=\"35\">\r\n");
      out.write("\t<td class=\"location-title\" >您的位置>>志愿服务>>志愿活动浏览\r\n");
      out.write("\t\t<span style=\"cursor:pointer;\" onclick=\"showorhide_div('helpdiv')\"></span>\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");

String strposition = "志愿服务>>志愿活动浏览>>";
String strfunction = "志愿活动列表";
String strhelpwords = "志愿活动的申请。";

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<form name=\"query\" method=\"post\" action=\"volunteer-activity-list.jsp\">\r\n");
      out.write("<table class=\"command-table\">\r\n");
      out.write("        <tr>\r\n");
      out.write("      <td>\r\n");
      out.write("\r\n");
      out.write("   \t\t");
      out.print(HtmlTool.renderSelect(academyOptions, "" + ParamUtils.getParameter(request, "_acdemy_", ""), "_acdemy_", "-1"));
      out.write("\r\n");
      out.write("      </td>\r\n");
      out.write("     \r\n");
      out.write("      <td >\r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("        \r\n");
      out.write(" \r\n");
      out.write("        活动名称<input name=\"_huodong_\" value=\"");
      out.print(ParamUtils.getParameter(request, "_huodong_", "") );
      out.write("\" type=\"text\" size=\"20\"/>\r\n");
      out.write("        \r\n");
      out.write("        </td>\r\n");
      out.write("          <td ><a href=\"#\" onclick=\"javascript:document.query.submit();\">查询</a></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<table class=\"content-table\" id=\"table2\">\r\n");
      out.write("<tr>\r\n");
      out.write("    <th width=\"4%\">序号</th>\r\n");
      out.write("\t<th width=\"15%\">名称</th>\r\n");
      out.write("\t<th width=\"10%\">发起单位</th>\r\n");
      out.write("\t\r\n");
      out.write("\t<th width=\"12%\">活动类别</th>\r\n");
      out.write("\t<th width=\"15%\">活动日期</th>\r\n");
      out.write("\t<th width=\"10%\">报名截止日期</th>\r\n");
      out.write("\t<th width=\"10%\">是否参与</th>\r\n");
      out.write("\t<th width=\"10%\">审核状态</th>\r\n");
      out.write("\t<th width=\"10%\">报名活动</th>\r\n");
      out.write("\t\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");

int tiaoshu=0;
Map<String,VolunteerParticipate> map= new HashMap<String,VolunteerParticipate>();
List<String> yichanjia= new ArrayList<String> ();
List list1= new ArrayList();
List cdt1= new ArrayList();
VolunteerParticipate vp= new VolunteerParticipate();
cdt1.add("sno='"+user.getName()+"'");
list1=vp.query(cdt1);

for(int i=0;i<list1.size();i++){
	vp=(VolunteerParticipate)list1.get(i);

	map.put(vp.getActivityId()+"", vp);
}
System.out.println("22222222222"+map);
System.out.println(yichanjia);
String strSQL2="",strSQL3="";
String activitycode="",activityname="",activitykind="",namehref="",honourlist="",evaluationlist="",placetimehref="";
String istr="",activitystatus="",checkstatus="",honourhref="",participatehref="",evaluationhref="",launchacademy="",applicationrange="",honourname="",evaluation="";
String starttime="",endtime="",deadline="",activityplace="",Activityname="",checktype="";
int id,order=0,checkflag=0,scheckflag=0,serivcelength=0,activityid;
String canjia="报名";
Map xynamenmap=CEditConst.getAcademyNameMap(userInfo);
List list= new ArrayList();
List cdt3= new ArrayList();
java.util.Date now = new java.util.Date();
VolunteerActivity va=new VolunteerActivity();
Map checkmap=CEditConst.getCheckTypeMap(userInfo);
String academy1=ParamUtils.getParameter(request, "_acdemy_", "-1");
if(academy1.length()>0&&academy1!="-1"){
	cdt3.add("launchacademy ="+academy1);
}
String huodong=ParamUtils.getParameter(request, "_huodong_", "-1");
if(huodong.length()>0&&huodong!="-1"){
    cdt3.add("activityname like '%" + huodong + "%'");

}
cdt3.add("checkflag=2");
cdt3.add("order by id desc ");

list=va.query(cdt3);
int end=0;

//过滤掉
List list2= new ArrayList();
for(int i=0;i<list.size();i++){
	 va=(VolunteerActivity)list.get(i);
	
  	 String sxueyuan=va.getApplicationRangeType();
  	 String sxiaoqu=va.getApplicationRange();
  	 System.out.println(sxiaoqu+"AAAAAAAAAAAA");
  	System.out.println(xiaoqu);
  	 if("".equals(sxueyuan)){
  		 list2.add(va); 
  	 }else{
  	  List xueyuanlist=Arrays.asList(sxueyuan.split(","));

  	   System.out.println(xueyuanlist);
     System.out.println(sxiaoqu.indexOf(xiaoqu));
	 
		  if(xueyuanlist.contains(xueyuan)&&sxiaoqu.indexOf(xiaoqu)>=0){
		  		 list2.add(va);
		  	   }
	  
	
}
}
if(list2.size()>0){
	tiaoshu=list2.size();
	start=(pagenumstr-1)*8;
    
	end=list2.size()>pagenumstr*8?pagenumstr*8:list2.size();
for(int i=start;i<end;i++)	{
	 va=(VolunteerActivity)list2.get(i);
       order=i;
       Activityname=va.getActivityname().length()>15?va.getActivityname().substring(0, 13)+"..":va.getActivityname();
       namehref="<a title='"+va.getActivityname()+"' href='volunteer-activity-details.jsp?id="+va.getId()+"'>"+va.getActivityname()+"</a>";
       launchacademy=(String)xynamenmap.get(va.getLaunchAcademy()+"")==null?"团委":(String)xynamenmap.get(va.getLaunchAcademy()+"");
       activitykind=va.getActivityKind();
       starttime=Tool.stringOfDate(va.getStarttime());
       endtime=Tool.stringOfDate(va.getEndtime());
       deadline=Tool.stringOfDate(va.getDeadline());
      

       if(map.containsKey(va.getId()+"")){
    	   canjia=""  ;
       checkstatus="已参加";
       checktype=map.get(va.getId()+"").getCheckFlag()+"";
       
       checktype=checktype.equals("-1")?"未审核":(checktype.equals("1")?"审核通过":"<font color='red'>审核未通过 <font>");
       }
       else{
    	   checkstatus=  "<font color='red'>未参加 <font>";
       }
    

      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("  <td>");
      out.print(order+1);
      out.write("</td>\r\n");
      out.write("  <td>");
      out.print(namehref);
      out.write("</td>  \r\n");
      out.write("  <td>");
      out.print(launchacademy);
      out.write("</td>\r\n");
      out.write("  \r\n");
      out.write("  <td>");
      out.print(activitykind);
      out.write("</td>\r\n");
      out.write("  <td>");
      out.print(starttime);
      out.write('~');
      out.print(endtime);
      out.write("</td>\r\n");
      out.write("  <td>");
      out.print(deadline);
      out.write("</td>\r\n");
      out.write("   <td>");
      out.print(checkstatus );
      out.write("</td>\r\n");
      out.write("    <td>");
      out.print(checktype );
      out.write("</td>\r\n");
      out.write("   ");
 
   
   if((va.getDeadline().getTime()+86400000)<=now.getTime()){ 
      out.write("\r\n");
      out.write("    <td><font color='red'>报名截止 <font></td>\r\n");
      out.write("   ");

   checktype="";
   } else{ 
	   
	   
	   
	   checktype="";
      out.write("\r\n");
      out.write("   \r\n");
      out.write("  <td><a href=\"volunteer-activity-apply.jsp?cmd=save&&page=");
      out.print(pagenumstr );
      out.write("&&Sno=");
      out.print(user.getName() );
      out.write("&&ActivityId=");
      out.print(va.getId() );
      out.write("\" \">");
      out.print(canjia );
      out.write("</a>\r\n");
      out.write("  \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  </td>\r\n");
      out.write(" \r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");

canjia="报名";
   
   }}} 
      out.write("\r\n");
      out.write("<tr height=40>\r\n");
      out.write("\t<th width=\"100%\" colspan=\"15\" align=\"center\">\r\n");
      out.write("\t\t共&nbsp");
      out.print(tiaoshu );
      out.write("&nbsp条&nbsp;&nbsp;&nbsp;当前第");
      out.print(pagenumstr );
      out.write("页&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t");

		int shangyiye=pagenumstr-1>0?pagenumstr-1:1;
		int xiayiye=pagenumstr*8<tiaoshu?pagenumstr+1:pagenumstr;
		
      out.write("\r\n");
      out.write("   \t\t<a href=\"volunteer-activity-list.jsp?\">首页</a>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t<a href=\"volunteer-activity-list.jsp?page=");
      out.print(shangyiye );
      out.write("\" >上一页</a>  &nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<a href=\"volunteer-activity-list.jsp?page=");
      out.print(xiayiye );
      out.write("\" >下一页</a>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("    \r\n");
      out.write("\t\t\r\n");
      out.write("\t</th>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
}else{ 
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

String strposition = "志愿服务信息  >> ";
String strfunction = "志愿者申请";
String strhelpwords= "申请成为志愿者。";


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
} 
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
