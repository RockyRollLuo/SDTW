/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-08 02:29:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.volunteer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;
import com.xietong.software.sdtw.db.*;
import com.xietong.software.util.Tool;
import com.xietong.software.common.HeadConst;

public final class volunteer_002dactivity_002ddetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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

ResultSet rs = null;
String id=request.getParameter("id");

String addfilelist="",foldercode="";
String activityname="",activitykind="",activitylevel="",addtime="",activityexplain="";
String starttime="",endtime="",deadline="",activityprincipal="",contact="",guideteacher="",applicationrange="",activitystatus="";
String addperson="",checkaccount="",launchacademy="",checktime="",checkstatus="";
String explainnew="",placetimestr="",activityplace="";
String ids="";
int personnumber=0,checkflag=0,placeflag=0;
List list= new ArrayList();
List cdt= new ArrayList();
cdt.add("id="+id);
VolunteerActivity va=new VolunteerActivity();
list=va.query( cdt);
if(list.size()>0){
	va=(VolunteerActivity)list.get(0);
	activityname=va.getActivityname();
	activitykind=va.getActivityKind();
	activitylevel=va.getActivityLevel().equals(0)?"院级":"院级";
	 starttime=Tool.stringOfDate(va.getStarttime());
     endtime=Tool.stringOfDate(va.getEndtime());
     deadline=Tool.stringOfDate(va.getDeadline());
     activityplace=va.getActivityPlace();
     personnumber=va.getPersonNumber();
     activityprincipal=va.getActivityPrincipal();
     contact=va.getContact();
     guideteacher=va.getGuideTeacher();
     activityexplain=va.getActivityExplain();
     applicationrange=va.getApplicationRange();
     ids=va.getAddFilelist();
}


      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />\r\n");
      out.write("<link href=\"../css/common-student.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<script src=\"../js/tablelist.js\"></script>\r\n");
      out.write("<script src=\"../js/jquery.min.js\"></script></head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");

String strposition = "志愿服务 >>志愿活动浏览>> ";
String strfunction = "活动详细信息";
String strhelpwords= "志愿活动的详细信息。";

      out.write('\r');
      out.write('\n');
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
      out.write("<table class=\"command-table\">\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>\r\n");
      out.write(" \t   <a href=\"volunteer-activity-list.jsp\">返回</a>\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<table class=\"content-table\">\r\n");
      out.write("<tr>\r\n");
      out.write("\t<th colspan=\"2\" align=\"left\">活动详细信息</th>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t <td width=\"30%\" align=\"right\">活动名称：</td>\r\n");
      out.write("\t <td align=\"left\" >");
      out.print(activityname);
      out.write("&nbsp; </td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("\t <td align=\"right\">&nbsp;活动类别：</td>\r\n");
      out.write("\t <td align=\"left\">");
      out.print(activitykind);
      out.write("&nbsp;\r\n");
      out.write("\t </td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t <td align=\"right\">&nbsp;活动级别：</td>\r\n");
      out.write("\t <td align=\"left\">");
      out.print(activitylevel);
      out.write("&nbsp;\r\n");
      out.write("\t </td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t <td  align=\"right\">&nbsp;活动日期：</td>\r\n");
      out.write("\t <td align=\"left\">");
      out.print(starttime);
      out.write('~');
      out.print(endtime);
      out.write("&nbsp;\r\n");
      out.write("\t </td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t <td  align=\"right\">&nbsp;活动地点：</td>\r\n");
      out.write("\t <td align=\"left\">");
      out.print(activityplace);
      out.write("&nbsp;\r\n");
      out.write("\t </td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t <td  align=\"right\">&nbsp;活动报名截止时间：</td>\r\n");
      out.write("\t <td align=\"left\">");
      out.print(deadline);
      out.write("&nbsp;\r\n");
      out.write("\t </td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("\t <td  align=\"right\">&nbsp;所需人数：</td>\r\n");
      out.write("\t <td align=\"left\">");
      out.print(personnumber);
      out.write("人&nbsp;\r\n");
      out.write("\t </td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t <td  align=\"right\">&nbsp;负责人：</td>\r\n");
      out.write("\t <td align=\"left\">");
      out.print(activityprincipal);
      out.write("&nbsp;\r\n");
      out.write("\t </td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t <td  align=\"right\">&nbsp;联系方式：</td>\r\n");
      out.write("\t <td align=\"left\">");
      out.print(contact);
      out.write("&nbsp;\r\n");
      out.write("\t </td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t <td  align=\"right\">&nbsp;指导教师：</td>\r\n");
      out.write("\t <td align=\"left\">");
      out.print(guideteacher);
      out.write("&nbsp;\r\n");
      out.write("\t </td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t <td  align=\"right\">&nbsp;详细介绍：</td>\r\n");
      out.write("\t <td  align=\"left\">");
      out.print(activityexplain);
      out.write("&nbsp;\r\n");
      out.write("\t </td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t <td  align=\"right\">&nbsp;申请范围：</td>\r\n");
      out.write("\t <td align=\"left\">");
      out.print(applicationrange);
      out.write("&nbsp;\r\n");
      out.write("\t </td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"right\">附件：</td>\r\n");
      out.write("\t<td align=\"left\">\r\n");
      out.write(" ");

 ClientAttach ca1=new ClientAttach();
 ClientAttach ca = new ClientAttach();

 if(ids!=null&&ids.trim().length()>0){
 	String[] idArray = Tool.split(",",ids);
 	System.out.println(idArray);
 	for(int i=0;i<idArray.length;i++){
 	ca1= ca.getById(Tool.StrToInt(idArray[i]));
 	 
      out.write("\r\n");
      out.write(" \t <a href=\"");
      out.print(HeadConst.apache_url );
      out.write("/servlet/attach?type=clientattach&id=");
      out.print(ca1.getId() );
      out.write("\" target=\"_blank\"><img src='");
      out.print(HeadConst.apache_url );
      out.write("/main/images/file1.gif' border=\"0\"/>下载文件");
      out.print(ca1.getUploadName() );
      out.write("\r\n");
      out.write(" \t</a> \r\n");
      out.write(" \t");

 	}
 }



      out.write("  \r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("\t <td  align=\"right\">&nbsp;活动荣誉信息：</td>\r\n");
      out.write("\t <td align=\"left\">\r\n");
      out.write("\r\n");
      out.write("\t </td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("\t<th colspan=\"2\"></th>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
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
