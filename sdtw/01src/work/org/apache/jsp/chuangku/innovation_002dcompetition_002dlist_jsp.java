/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-25 06:14:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.chuangku;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.sdtw.db.InnovationCompetitionProject;
import com.xietong.software.sdtw.db.InnovationCompetition;
import com.xietong.software.sdtw.db.InnovationCompetitionMembers;
import com.xietong.software.sdtw.db.BaseUserCode;
import com.xietong.software.common.UserInfo;
import com.xietong.software.common.UserInfo;
import com.xietong.software.common.CEditConst;
import com.xietong.software.util.Tool;
import java.sql.*;
import java.util.*;
import com.xietong.software.util.*;
import com.xietong.software.common.*;
import com.xietong.software.base.Power;
import java.sql.*;

public final class innovation_002dcompetition_002dlist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


ResultSet rs=null;
int rowscount;
int numsperpage=10,pagecount,pagenum,gopage,i,j;

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/common-student.css\">\r\n");
      out.write("<script src=\"../js/tablelist.js\"></script> \r\n");
      out.write("<script src=\"../js/jquery.min.js\"></script> \r\n");
      out.write("<script src=\"../js/personlistorder.js\"></script> \r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");

String strposition = "创新创业管理>>竞赛管理";
String strfunction = "竞赛管理列表";
String strhelpwords = "创新创业管理之竞赛管理，申请者（队长）可以进行修改，其他团队成员只能进行查看。";
UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	if (userInfo != null) {
		userInfo.removeCookie(response);
	}
	session.removeAttribute("UserInfo");
	return ;
}
BaseUserCode stu= userInfo.getUserCode();
int sno=stu.getId();
InnovationCompetitionMembers icm= new InnovationCompetitionMembers ();
int proid=ParamUtils.getIntParameter(request, "proid",-1);
List cdt= new ArrayList();
List list= new ArrayList();
cdt.add("sno="+sno);
list=icm.query(cdt);
String sid ="(";
if(list.size()>0){
	for(int i=0;i<list.size();i++){
		icm=(InnovationCompetitionMembers)list.get(i);
		if(i==0){
			sid+=icm.getProductionId();
		}else{
			sid+=","+icm.getProductionId();
		}
	}
	sid+=")";
}
System.out.println(sid);
InnovationCompetitionProject  icp= new InnovationCompetitionProject();
if(proid!=-1){
	   icp=icp.getById(proid);}


      out.write("\r\n");
      out.write("<table class=\"location-table\">\r\n");
      out.write("<tr height=\"35\">\r\n");
      out.write("\t<td class=\"location-title\" >您的位置>>创新创业>>>创业竞赛>>");
      out.print(icp.getProjectName());
      out.write("申请列表\r\n");
      out.write("\t\t<span style=\"cursor:pointer;\" onclick=\"showorhide_div('helpdiv')\"></span>\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<table class=\"command-table\">\r\n");
      out.write("<tr >\r\n");
      out.write("  <td  height=\"35px\" align=\"right\">\r\n");
      out.write("   ");

   
  String timeend= icp.getTimeEnd();
  java.util. Date time=Tool.stringToDate(timeend);
  java.util. Date now =new java.util. Date();
  if((time.getTime()+86400000)<=now.getTime()){
	  
      out.write("  \r\n");
      out.write("\t <font color=\"red\"> 活动日期:");
      out.print(icp.getTimeStart()+"~" +timeend);
      out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>\r\n");
      out.write("\t    <a href=\"#\"  >报名截止</a>\r\n");
      out.write("\t");
 
  }else{
   
      out.write("\r\n");
      out.write("         <a href=\"innovation-chuangku-declare.jsp?chuangkuid=");
      out.print(proid);
      out.write("\">添加</a>\r\n");
      out.write("         ");
} 
      out.write("\r\n");
      out.write("         \r\n");
      out.write("        <a href=\"innovation-competition-project-list.jsp\"  >返回</a>\r\n");
      out.write("    \r\n");
      out.write("  </td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<table class=\"content-table\">\r\n");
      out.write("\r\n");
      out.write("<tr height=\"35\">\r\n");
      out.write("  <th width=\"5%\">序号</th>\r\n");
      out.write("   <th width=\"20%\">竞赛项目名称</th>\r\n");
      out.write("  <th width=\"20%\">作品名称</th>\r\n");
      out.write("  <th width=\"10%\">学院</th>\r\n");
      out.write("  <th width=\"13%\">申报者</th>\r\n");
      out.write("  <th width=\"10%\">作品类别</th>\r\n");
      out.write("  <th width=\"8%\">学院审核</th>\r\n");
      out.write("  <th width=\"8%\">学校审核</th>\r\n");
      out.write("  <th colspan=\"3\">操作</th>\r\n");
      out.write("</tr>\r\n");





Map xynamemaps=CEditConst.getAcademyNameMap(userInfo);
Map usercnmamemaps=CEditConst.getUserCnNameMap(userInfo);
Map production_typemaps=CEditConst.getProductionTypeMap(userInfo);
Map checkmaps=CEditConst.getAuditMap(userInfo);
System.out.println(checkmaps);
String jingsai="";
String istr="",production_name="",academy="",declarer="",production_type="",leaderid="",detailhref="",modihref="",delehref="",applyedit="",submithref="", xystate="", twstate="";
int id, checkflag,studentstate;
int biaohao=1;
InnovationCompetition ic= new InnovationCompetition();
List cdt1= new ArrayList();
List list1= new ArrayList();

if(proid>-1){
	cdt1.add("projectname ="+proid);
}
cdt1.add(" addperson="+stu.getId());
cdt1.add("order by id desc");
list1=ic.query(cdt1);
if(list1.size()>0){
	for(int i=0;i<list1.size();i++){
		jingsai="<a href='innovation-competition-project-detail.jsp?id="+icp.getId()+"'>"+icp.getProjectName()+"</a>";

		delehref="";modihref="";delehref="";
		ic=(InnovationCompetition)list1.get(i);
		biaohao+=i;
		detailhref="<a href='innovation-competition-detail.jsp?Id="+ic.getId()+"'>"+ic.getProductionName()+"</a>";
		if(ic.getAcademy()!=""){
			academy=(String)xynamemaps.get(ic.getAcademy());
		
		}
		
		declarer=(String)usercnmamemaps.get(ic.getLeaderId());
		production_type=(String)production_typemaps.get(ic.getProductionType());
		xystate=(String)checkmaps.get(ic.getCheckFlagXy()+"");
		twstate=(String)checkmaps.get(ic.getCheckFlagTw()+"");
		if(ic.getLeaderId().equals(stu.getId()+"")){
			modihref="";
			delehref="<a href='InnovationCompetitionAction.jsp?cmd=delete&Id="+ic.getId()+"'>"+"删除</a>";
		submithref="";
		}
		if(ic.getCheckFlagTw()==1||ic.getCheckFlagXy()==1){
			modihref="";
			delehref="";
			submithref="";
		}

      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("  <td th>");
      out.print(biaohao);
      out.write("&nbsp;</td>\r\n");
      out.write("  <td >");
      out.print(jingsai);
      out.write("</td>   \r\n");
      out.write("  <td >");
      out.print(detailhref);
      out.write("</td>   \r\n");
      out.write("  <td  align=\"left\">");
      out.print(academy);
      out.write("</td>\r\n");
      out.write("  <td th>");
      out.print(declarer);
      out.write("&nbsp;</td> \r\n");
      out.write("  <td th>");
      out.print(production_type);
      out.write("&nbsp;</td> \r\n");
      out.write("  <td th>");
      out.print(xystate );
      out.write("&nbsp;</td>\r\n");
      out.write("  <td th>");
      out.print(twstate );
      out.write("&nbsp;</td>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <td th>");
      out.print(modihref );
      out.write("&nbsp;</td>\r\n");
      out.write("  <td th>");
      out.print(delehref );
      out.write("&nbsp;</td> \r\n");
      out.write("  <td th>");
      out.print(submithref);
      out.write("</td> \r\n");
      out.write("\r\n");
      out.write("</tr>\r\n");
}} 
      out.write("\r\n");
      out.write("<tr height=\"50\">\r\n");
      out.write("  <td  style=\"background-color:#F7FBFF\" width=\"100%\" colspan=\"12\" align=\"left\">\r\n");
      out.write("    【说明】列表中列出您作为负责人或者团队成员参与的创新创业竞赛，作为负责人的竞赛，您应负责对竞赛进行维护。对于未审核的竞赛，可以进行修改、删除操作；其他情况为审核中，不允许操作。\r\n");
      out.write("  </td>\r\n");
      out.write("</tr>\r\n");
      out.write("<form name=\"mygo\" method=\"post\" action=\"innovation-competition-list.jsp\" target=\"_self\">\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
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
