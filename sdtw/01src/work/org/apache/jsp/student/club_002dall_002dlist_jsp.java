/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-26 01:17:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.sdtw.db.ClubTeacher;
import java.util.HashMap;
import com.xietong.software.common.PageControl;
import com.xietong.software.common.HeadConst;
import java.util.Date;
import com.xietong.software.util.ParamUtils;
import com.xietong.software.base.SdtwConst;
import com.xietong.software.sdtw.db.ClubMembers;
import com.xietong.software.sdtw.db.Students;
import java.util.Map;
import com.xietong.software.sdtw.db.Club;
import com.xietong.software.sdtw.club.ClubUtil;
import java.util.List;
import java.util.ArrayList;
import com.xietong.software.common.COptionConst;
import com.xietong.software.base.Power;
import com.xietong.software.util.Tool;
import com.xietong.software.common.UserInfo;
import com.xietong.software.common.CEditConst;
import com.xietong.software.common.HtmlTool;
import java.sql.*;
import com.xietong.software.common.UserInfo;
import com.xietong.software.common.HeadConst;
import com.xietong.software.util.Tool;

public final class club_002dall_002dlist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 

int rowscount,i;
int numsperpage=10,pagecount,pagenum,gopage;

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/main/js/jsheader.jsp", Long.valueOf(1485156249000L));
    _jspx_dependants.put("/student/pagetop-positionandhelp.jsp", Long.valueOf(1493084791070L));
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

UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	//out.print(HtmlTool.msgBox(request, "请先登录"));
	return ;
}
List cdt = cdt = new ArrayList();
cdt.add("RecruitmentCheckflag=1");
List ClubNameOptions = COptionConst.getClubNameOptions(userInfo,"-1",cdt);
Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);
int selectType = ParamUtils.getIntParameter(request,"selectType",0);
String cmd = ParamUtils.getParameter(request,"cmd","list");
String ClubName = ParamUtils.getParameter(request,"ClubName","");

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/common-student.css\">\r\n");
      out.write("<script src=\"../js/tablelist.js\"></script> \r\n");
      out.write("<script src=\"../js/jquery.min.js\"></script> \r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/jqueryUI/jquery-ui.css\">\r\n");
      out.write("<script src=\"../js/jqueryUI/jquery-ui.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/js/listfunction_win8.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$(\"#selectType\").selectable();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function changeorder(){\r\n");
      out.write("\tdocument.formselect.selectedType.value=$(\"#selectType\").find(\"option:selected\").val();\r\n");
      out.write("\tdocument.formselect.submit();\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");

String strposition = "学生社团工作>>学生社团信息>>";
String strfunction = "学生社团列表";
String strhelpwords = "社团列表。";

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table class=\"location-table\" >\r\n");
      out.write("<tr height=\"35\">\r\n");
      out.write("\t<td class=\"location-title\" >您的位置：");
      out.print(strposition );
      out.write("\r\n");
      out.write("\t\t<span style=\"cursor:pointer;\" onclick=\"showorhide_div('helpdiv')\">");
      out.print(strfunction );
      out.write("</span>\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<div id=\"helpdiv\" style=\"display:none;width:89%;margin:0 auto;\">\r\n");
      out.write("<table \tclass=\"location-help\"  cellpadding=\"0\" cellspacing=\"0\" >\r\n");
      out.write("<tr height=\"20\">\r\n");
      out.write("\t<td align=\"left\">系统帮助：</td>\r\n");
      out.write("   \t<td width=\"30\"> \r\n");
      out.write("\t\t<a align=\"right\" href=\"#\" onclick=\"showorhide_div('helpdiv')\"><font face='Webdings' color='#FF0000' style='font- size:32pt'>×</font></a>\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr height=\"20\">\r\n");
      out.write("\t<td align=\"left\">");
      out.print(strhelpwords );
      out.write("</td>\r\n");
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
      out.write("<table class=\"content-table\" id=\"table2\">\r\n");
      out.write("<tr>\r\n");
      out.write("<form name=\"formselect\" method=\"post\" action=\"club-all-list.jsp\">\r\n");
      out.write("<input type=\"hidden\" id=\"cmd\" name=\"cmd\" value=\"");
      out.print(ParamUtils.getParameter(request,"cmd",""));
      out.write("\"/>\r\n");
      out.write("\t<td colspan=\"13\"  align=\"left\">\r\n");
      out.write("\t社团名称：<input name=\"ClubName\" type=\"text\" value=\"");
      out.print(ClubName );
      out.write("\" size=\"20\" onchange=\"changeorder();\">&nbsp;\r\n");
      out.write("\t\t选择：<input name=\"selectedType\" type=\"hidden\" value=\"\" >\r\n");
      out.write(" \t\t<select name=\"selectType\" id=\"selectType\" onchange=\"changeorder();\">\r\n");
      out.write("\t  \t\t<option value=\"0\">所有社团</option>\r\n");
      out.write("\t  \t\t<option value=\"1\">我加入的</option>\r\n");
      out.write("\t  \t\t<option value=\"2\">正在纳新</option>\r\n");
      out.write("  \t\t</select>\r\n");
      out.write("  \t<script type=\"text/javascript\">$(\"select[name='selectType']\").val(\"");
      out.print(selectType);
      out.write("\");</script>\r\n");
      out.write("\t</td>\r\n");
      out.write("</form>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("  <th width=\"5%\">序号</th>\r\n");
      out.write("  <th width=\"18%\">社团名称</th>\r\n");
      out.write("  <th width=\"18%\">纳新时段</th>\r\n");
      out.write("  <th width=\"8%\">申请书</th>\r\n");
      out.write("  <th width=\"10%\">负责人情况</th>\r\n");
      out.write("  <th width=\"8%\">指导教师情况</th>\r\n");
      out.write("  <!-- <th width=\"8%\">财务公开</th> -->\r\n");
      out.write("  <th width=\"6%\">会员人数</th>\r\n");
      out.write("  <th width=\"6%\">申请人数</th>\r\n");
      out.write("  <!-- <th width=\"8%\">审核情况</th> -->\r\n");
      out.write("  <th>操作</th>\r\n");
      out.write("</tr>\r\n");

ClubUtil util = new ClubUtil();
List list = new ArrayList();
list = util.getClubList(selectType,userInfo.getId(),ClubName,request);
List clubList = new ArrayList();
if(list.size()>0){
	List sidsList = new ArrayList();
	for(int i=0;i<list.size();i++){
		Club club = new Club();
		club = (Club)list.get(i);
		String sids = club.getId()+"";
		sidsList.add(sids);
	}
	//判断社团是否注册
	Map<String,Boolean> checkregMap = new HashMap<String,Boolean>();
	checkregMap =util.getCheckClubRegistTime(Tool.join(",",sidsList));
	//Map<String,List<ClubMembers>> ClubMemberMap = new HashMap<String,List<ClubMembers>>();
	Map <String,List<String>> ClubSponsorMap = new HashMap();
	Map <String,List<String>> ClubTeacherMap = new HashMap();
	Map <String,Integer>ClubMemberNumsMap = util.getClubMemberNumsMap();
	Map CheckFlagMap = util.getCheckFlagMap();
	Map CheckJoinClubMap = util.getCheckJoinClub(Tool.join(",",sidsList));
	for(int i=0;i<list.size();i++){
		Club club = new Club();
		club = (Club)list.get(i);
		//members.getId()+"_"+members.getMemberClubname()
		clubList.add(club.getId()+"");
	}
	ClubSponsorMap = util.getCheckClubSponsor(Tool.join(",",clubList));
	ClubTeacherMap = util.getCheckClubTeacher(Tool.join(",",clubList));
	//ClubMemberMap = util.getClubMemberMap(Tool.join(",",clubList));
	for(int i=0;i<list.size();i++){
		Club club = new Club();
		club = (Club)list.get(i);
		//String sids[] = club.getChairman().split(",");
		if(checkregMap.get(club.getId()+"")!=null){
			boolean chekregist = checkregMap.get(club.getId()+"");
			if(chekregist){
	
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<td>");
      out.print(i+1 );
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(club.getClubName() );
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(Tool.stringOfDate(club.getRecruitmentStart()) );
      out.write(" 到  ");
      out.print(Tool.stringOfDate(club.getRecruitmentStop()) );
      out.write("</td>\r\n");
      out.write("\t\t<td><a href=\"club-setup-add.jsp?cmd=viewlist&id=");
      out.print(club.getId());
      out.write("&backurl=");
      out.print(request.getRequestURI());
      out.write("\">申请书查看</a></td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");

	  List<String>mlist = new ArrayList<String>();
	  if(ClubSponsorMap.get(club.getId()+"")!=null){
		  mlist = ClubSponsorMap.get(club.getId()+"");
		  for(int j=0;j<mlist.size();j++){
			//  if(!SdtwConst.CHECKFLAG_XXTG.equals(club.getCheckFlag())){
				//  if((userInfo.getId()+"").equals(club.getAddPerson())){
      out.write("\r\n");
      out.write("\t\t\t\t<a href='club-setup-manager-modify.jsp?cmd=viewlist&MemberName=");
      out.print(mlist.get(j) );
      out.write("&MemberClubname=");
      out.print(club.getId());
      out.write("&state=");
      out.print(club.getCheckFlag());
      out.write('\'');
      out.write('>');
      out.print(UserCnNameMap.get(mlist.get(j)) );
      out.write("</a>&nbsp;&nbsp;  \r\n");
      out.write("\t\t\t\t  ");
//}
			 // }
		  
      out.write("\r\n");
      out.write("\t\t  ");
} 
	  }
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t");
ClubTeacher teacher = new ClubTeacher();
	  List<String>tList = new ArrayList<String>();
	  if(ClubTeacherMap.get(club.getId()+"")!=null){
		  tList = ClubTeacherMap.get(club.getId()+"");
		  for(int j=0;j<tList.size();j++){
      out.write("\r\n");
      out.write("\t\t\t  <a href='club-setup-teacher-modify.jsp?cmd=viewlist&ClubName=");
      out.print(club.getId() );
      out.write("&TeaName=");
      out.print(tList.get(j));
      out.write("&state=");
      out.print(club.getCheckFlag());
      out.write('\'');
      out.write('>');
      out.print(tList.get(j) );
      out.write("</a>&nbsp;&nbsp;  \r\n");
      out.write("\t\t  ");
}
	  }
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td>");
      out.print(ClubMemberNumsMap.get(club.getId()+"_1")==null?"0":ClubMemberNumsMap.get(club.getId()+"_1"));
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t");
      out.print(ClubMemberNumsMap.get(club.getId()+"")==null?"0":ClubMemberNumsMap.get(club.getId()+""));
      out.write("\r\n");
      out.write("\t\t</td> \r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t");

		if(CheckJoinClubMap.get(club.getId()+"_"+userInfo.getId()+"_Cy")!=null){
			ClubMembers members = new ClubMembers();
			members = (ClubMembers)CheckJoinClubMap.get(club.getId()+"_"+userInfo.getId()+"_Cy");
		
      out.write("\r\n");
      out.write("\t\t<a href=\"club-recruitment-add.jsp?cmd=viewlist&id=");
      out.print(club.getId());
      out.write("&MemId=");
      out.print(members.getId());
      out.write("\">您是该社团成员</a>\r\n");
      out.write("\t\t");
}else{
      out.write("\r\n");
      out.write("\t\t\t");

		if(CheckJoinClubMap.get(club.getId()+"_"+userInfo.getId())==null){
			if(club.getRecruitmentCheckflag()==1){
			if(club.getRecruitmentStart().getTime()<=new Date().getTime()&&club.getRecruitmentStop().getTime()>=new Date().getTime()){
      out.write("\r\n");
      out.write("\t\t\t\t<a href=\"club-recruitment-add.jsp?id=");
      out.print(club.getId());
      out.write("\">申请加入</a>\r\n");
      out.write("\t\t\t");
}else{
      out.write("\r\n");
      out.write("\t\t\t\t停止纳新\r\n");
      out.write("\t\t\t");
}
			
      out.write("\r\n");
      out.write("\t\t\t");
}else{
      out.write("\r\n");
      out.write("\t\t\t\t未开启纳新\r\n");
      out.write("\t\t\t");
}
		
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t");
}else{
		ClubMembers members = new ClubMembers();
		members = (ClubMembers)CheckJoinClubMap.get(club.getId()+"_"+userInfo.getId());
		
      out.write("\r\n");
      out.write("\t\t<a href=\"club-recruitment-add.jsp?cmd=viewlist&id=");
      out.print(club.getId());
      out.write("&MemId=");
      out.print(members.getId());
      out.write("\">已申请</a>\r\n");
      out.write("\t\t");
}
      out.write("\r\n");
      out.write("\t\t");
}
		
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
} 
		}
		
      out.write('\r');
      out.write('\n');
      out.write('	');
}
	checkregMap.clear();
	ClubMemberNumsMap.clear();
	ClubSponsorMap.clear();
	ClubTeacherMap.clear();
	CheckFlagMap.clear();
	CheckJoinClubMap.clear();
}else{
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td colspan=\"10\">没有信息</td>\r\n");
      out.write("</tr>\r\n");
}

      out.write("\r\n");
      out.write("</table>\r\n");

	PageControl pagecontrol = (PageControl)request.getAttribute("PageControl");
	
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.print(pagecontrol.getControl_win8_("club-all-list.jsp?cmd=list&selectType="+selectType+"&ClubName="+ClubName,  HeadConst.apache_url+"/main/images/skin/"+userInfo.getSkinId()));
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
