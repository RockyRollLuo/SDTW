/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-25 02:52:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.sdtw.db.ClubTeacher;
import com.xietong.software.sdtw.db.ClubMembers;
import java.util.ArrayList;
import com.xietong.software.util.ParamUtils;
import com.xietong.software.common.CEditConst;
import java.util.Map;
import java.util.HashMap;
import com.xietong.software.base.Power;
import com.xietong.software.base.SdtwConst;
import com.xietong.software.common.HeadConst;
import com.xietong.software.sdtw.db.Club;
import com.xietong.software.common.UserInfo;
import com.xietong.software.util.Tool;
import com.xietong.software.common.HtmlTool;
import java.util.List;
import com.xietong.software.sdtw.db.BaseUserCode;
import com.xietong.software.sdtw.club.ClubUtil;

public final class club_002dsetup_002dlist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
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

UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/common-student.css\">\r\n");
      out.write("<script src=\"../js/tablelist.js\"></script> \r\n");
      out.write("<script src=\"../js/jquery.min.js\"></script> \r\n");
      out.write("<script>\r\n");
      out.write("function deleteList(id){\r\n");
      out.write("\tif (confirm(\"确实要删除吗?\")) {\r\n");
      out.write("\tlocation = 'club-setup-addsave.jsp?cmd=del&id='+id;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function shangbao(id){\r\n");
      out.write("\t\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("        type: \"post\",\r\n");
      out.write("        ///sdfz/01src/web\r\n");
      out.write("        url: \"club-setup-addsave.jsp\",\r\n");
      out.write("        data: {id:id,cmd:\"checkSave\"},\r\n");
      out.write("        dataType: \"json\",\r\n");
      out.write("        cache: false,\r\n");
      out.write("        success: function(data){\r\n");
      out.write("                   if (data.msg==\"ok\") {\r\n");
      out.write("                \t\tif (confirm(\"确实要提交吗?\")) {\r\n");
      out.write("                \t\tlocation = 'club-setup-addsave.jsp?id='+id+'&cmd=shangbao';\r\n");
      out.write("                \t\t}\r\n");
      out.write("                   }\r\n");
      out.write("                   if (data.msg==\"fzrno\") {\r\n");
      out.write("                \t   alert(\"请添加社团负责人!\");\r\n");
      out.write("                \t   return;\r\n");
      out.write("                   }\r\n");
      out.write("                   if (data.msg==\"jsno\") {\r\n");
      out.write("                \t   alert(\"请添加指导教师!\");\r\n");
      out.write("                \t   return;\r\n");
      out.write("                   }\r\n");
      out.write("                 },\r\n");
      out.write("                 error : function() { \r\n");
      out.write("                             // view(\"异常！\"); \r\n");
      out.write("                             alert( \"异常！\"); \r\n");
      out.write("\t}\r\n");
      out.write("    });\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");

BaseUserCode user = new BaseUserCode();
if(userInfo == null){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}
if(userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	user = userInfo.getUserCode();
}
String strposition = "学生社团工作>>社团成立申请>>";
String strfunction = "申请列表";
String strhelpwords = "社团成立申请列表。";
ClubUtil util = new ClubUtil();
List list = util.getClubListByUser(user.getId());
Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);

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
      out.write('\r');
      out.write('\n');

if(list.size()<1){
      out.write("\r\n");
      out.write("\t<div id=\"table4\">\r\n");
      out.write("<table class=\"frame-table\" align=\"center\">\r\n");
      out.write("  <tr height=\"40px\"><th>系统提示</th></tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>您尚未申请成立社团！</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr height=\"40px\">\r\n");
      out.write("  <th>\r\n");
      out.write("    <a href=\"club-setup-add.jsp?&backurl=");
      out.print(request.getRequestURI());
      out.write("\" target=\"_self\">申请成立社团</a>\r\n");
      out.write("  </th>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
}else{
      out.write("\r\n");
      out.write("\t<table class=\"command-table\" id=\"table1\">\r\n");
      out.write("<tr class=\"odd\">\r\n");
      out.write("  <td>\r\n");
      out.write("    <a href=\"club-setup-add.jsp?backurl=");
      out.print(request.getRequestURI());
      out.write("\" >申请成立</a>\r\n");
      out.write("  </td>\r\n");
      out.write("</tr>    \r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<table class=\"content-table\" id=\"table2\" border=\"1px;\">\r\n");
      out.write("<tr>\r\n");
      out.write("  <th width=\"5%\">序号</th>\r\n");
      out.write("  <th width=\"18%\">社团名称</th>\r\n");
      out.write("  <th width=\"9%\">社团编号</th>\r\n");
      out.write("  <th width=\"8%\">申请书</th>\r\n");
      out.write("  <th width=\"8%\">审核</th>\r\n");
      out.write("  <th width=\"15%\">负责人</th>\r\n");
      out.write("  <th width=\"8%\">指导教师</th>\r\n");
      out.write("  <th width=\"21%\">操作</th>\r\n");
      out.write("</tr>\r\n");

Map checkFlagMap = new HashMap<String,String>();
checkFlagMap = util.getCheckFlagMap();
Map <String,List<String>> ClubSponsorMap = new HashMap();
Map <String,List<String>> ClubTeacherMap = new HashMap();
List cids = new ArrayList();
for(int i=0;i<list.size();i++){
	Club club = new Club();
	club = (Club)list.get(i);
	cids.add(club.getId()+"");
}
ClubSponsorMap = util.getCheckClubSponsor(Tool.join(",",cids));
ClubTeacherMap = util.getCheckClubTeacher(Tool.join(",",cids));
for(int i=0;i<list.size();i++){
	Club club = new Club();
	club = (Club)list.get(i);
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t  <td>");
      out.print(i+1 );
      out.write("</td>\r\n");
      out.write("\t  <td>");
      out.print(club.getClubName() );
      out.write("</td>\r\n");
      out.write("\t  <td>");
      out.print(club.getClubId() );
      out.write("</td>\r\n");
      out.write("\t  <td><a href=\"club-setup-add.jsp?cmd=view&id=");
      out.print(club.getId());
      out.write("&backurl=");
      out.print(request.getRequestURI());
      out.write("\">点击查看</a></td>\r\n");
      out.write("\t  <td>");
      out.print((String)checkFlagMap.get(club.getCheckFlag()) );
      out.write("</td>\r\n");
      out.write("\t  <td>");

	  ClubMembers members = new ClubMembers();
	  List<String>mlist = new ArrayList<String>();
	  if(ClubSponsorMap.get(club.getId()+"")!=null){
		  mlist = ClubSponsorMap.get(club.getId()+"");
		  for(int j=0;j<mlist.size();j++){
			  if(!SdtwConst.CHECKFLAG_XXTG.equals(club.getCheckFlag())){
				  if((userInfo.getId()+"").equals(club.getAddPerson())){
      out.write("\r\n");
      out.write("\t\t\t\t<a href='club-setup-manager-modify.jsp?cmd=saveOrUpdate&MemberName=");
      out.print(mlist.get(j) );
      out.write("&MemberClubname=");
      out.print(club.getId());
      out.write("&state=");
      out.print(club.getCheckFlag());
      out.write('\'');
      out.write('>');
      out.print(UserCnNameMap.get(mlist.get(j))==null?mlist.get(j):UserCnNameMap.get(mlist.get(j)) );
      out.write("</a>&nbsp;&nbsp;  \r\n");
      out.write("\t\t\t\t  ");
}
			  }else{
      out.write("\r\n");
      out.write("\t\t\t\t  <a href='club-setup-manager-modify.jsp?cmd=saveOrUpdate&MemberName=");
      out.print(mlist.get(j) );
      out.write("&MemberClubname=");
      out.print(club.getId());
      out.write("&state=");
      out.print(club.getCheckFlag());
      out.write('\'');
      out.write('>');
      out.print(UserCnNameMap.get(mlist.get(j))==null?mlist.get(j):UserCnNameMap.get(mlist.get(j)) );
      out.write("</a>&nbsp;&nbsp;\r\n");
      out.write("\t\t\t  ");
}
		  
      out.write("\r\n");
      out.write("\t\t  ");
} 
	  } else {
      out.write("\r\n");
      out.write("\t\t ");
 if(SdtwConst.CHECKFLAG_WSB.equals(club.getCheckFlag())&&(userInfo.getId()+"").equals(club.getAddPerson())){
      out.write("\r\n");
      out.write("\t\t\t   <a href='club-setup-manager-modify.jsp?cmd=saveOrUpdate&MemberClubname=");
      out.print(club.getId());
      out.write("'>添加负责人</a>\r\n");
      out.write("\t\t  ");
	}
		  
	  }
      out.write("\r\n");
      out.write("\t </td>\r\n");
      out.write("\t  <td>\r\n");
      out.write("\t  ");

	  ClubTeacher teacher = new ClubTeacher();
	  List<String>tList = new ArrayList<String>();
	  if(ClubTeacherMap.get(club.getId()+"")!=null){
		  tList = ClubTeacherMap.get(club.getId()+"");
		  for(int j=0;j<tList.size();j++){
      out.write("\r\n");
      out.write("\t\t\t  <a href='club-setup-teacher-modify.jsp?cmd=saveOrUpdate&ClubName=");
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
	  }else{
      out.write("\r\n");
      out.write("\t  <a href='club-setup-teacher-modify.jsp?cmd=saveOrUpdate&ClubName=");
      out.print(club.getId() );
      out.write("'>添加指导教师</a>\r\n");
      out.write("\t  ");
} 
      out.write("\r\n");
      out.write("\t  </td>\r\n");
      out.write("\t  <td>\r\n");
      out.write("\t  ");

	  if(SdtwConst.CHECKFLAG_WSB.equals(club.getCheckFlag())){
      out.write("\r\n");
      out.write("\t\t  <a href=\"club-setup-add.jsp?id=");
      out.print(club.getId());
      out.write("&cmd=update&backurl=");
      out.print(request.getRequestURI());
      out.write("\">修改</a>&nbsp;&nbsp;\r\n");
      out.write("\t\t  <a href=\"javascript:deleteList(");
      out.print(club.getId());
      out.write(")\">删除</a>&nbsp;&nbsp;\r\n");
      out.write("\t\t  <a href=\"javascript:shangbao(");
      out.print(club.getId());
      out.write(")\">上报</a>\r\n");
      out.write("\t ");
}
	  
      out.write("\r\n");
      out.write("\t   ");

	  if(SdtwConst.CHECKFLAG_XYWTG.equals(club.getCheckFlag())){
      out.write("\r\n");
      out.write("\t\t  <a href=\"club-setup-add.jsp?id=");
      out.print(club.getId());
      out.write("&cmd=update&backurl=");
      out.print(request.getRequestURI());
      out.write("\">修改</a>&nbsp;&nbsp;\r\n");
      out.write("\t\t  <a href=\"javascript:shangbao(");
      out.print(club.getId());
      out.write(")\">上报</a>\r\n");
      out.write("\t ");
}
	  
      out.write("\r\n");
      out.write("\t  ");

	  if(SdtwConst.CHECKFLAG_XXWTG.equals(club.getCheckFlag())){
      out.write("\r\n");
      out.write("\t\t  <a href=\"club-setup-add.jsp?id=");
      out.print(club.getId());
      out.write("&cmd=update&backurl=");
      out.print(request.getRequestURI());
      out.write("\">修改</a>&nbsp;&nbsp;\r\n");
      out.write("\t\t  <a href=\"javascript:shangbao(");
      out.print(club.getId());
      out.write(")\">上报</a>\r\n");
      out.write("\t ");
}
	  
      out.write("\r\n");
      out.write("\t  ");

	  if(SdtwConst.CHECKFLAG_SB.equals(club.getCheckFlag())){
      out.write("\r\n");
      out.write("\t\t 已上报,不允许修改\r\n");
      out.write("\t ");
}
	  
      out.write("\r\n");
      out.write("\t  </td>\r\n");
      out.write("\t</tr>\r\n");
}
ClubSponsorMap.clear();
ClubTeacherMap.clear();

      out.write("\r\n");
      out.write("<tr><th colspan=\"11\" align=\"left\">\r\n");
      out.write("&nbsp;说明：1.学生社团负责人和指导教师信息都填写完整后才可以上报数据。<br/>\r\n");
      out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("2.学校审核通过之后，可以用社团编号作为账号登陆社团官方账号，初始密码为111111。\r\n");
      out.write("\r\n");
      out.write("</th></tr>\r\n");
      out.write("</table>\r\n");
}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("/*   document.getElementById(\"table1\").style.display=\"block\";\r\n");
      out.write("  document.getElementById(\"table2\").style.display=\"block\"; */\r\n");
      out.write(" // document.getElementById(\"table4\").style.display=\"none\";\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write(" </body>\r\n");
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