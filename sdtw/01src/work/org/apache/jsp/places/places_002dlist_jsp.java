/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-25 08:11:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.places;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.util.OptionBean;
import com.xietong.software.sdtw.db.Places;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.xietong.software.sdtw.*;
import com.xietong.software.sdtw.db.*;
import com.xietong.software.util.*;
import com.xietong.software.common.*;
import org.apache.commons.logging.*;
import java.io.*;
import java.util.*;
import com.xietong.software.base.Power;

public final class places_002dlist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"../css/common-student.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<script src=\"../js/tablelist.js\"></script>\r\n");
      out.write("<script src=\"../js/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body >\r\n");
      out.write("\r\n");
      out.write(" <table class=\"location-table\">\r\n");
      out.write("<tr height=\"35\">\r\n");
      out.write("\t<td class=\"location-title\" >您的位置>>场地信息>>场地列表\r\n");
      out.write("\t\t<span style=\"cursor:pointer;\" onclick=\"showorhide_div('helpdiv')\"></span>\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<table class=\"command-table\">\r\n");
      out.write("<tr height=\"35px\">\r\n");
      out.write("\t<td>\r\n");
      out.write("<!-- \t   <a href=\"places-search.jsp\"><img src=\"../images/commandico/search.png\"></a> -->\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<table class=\"content-table\" id=\"table2\">\r\n");
      out.write("<tr>\r\n");
      out.write("\t<th width=\"5%\">序号</th>\r\n");
      out.write("\t<th width=\"10%\">所在校区</th>\r\n");
      out.write("\t<th width=\"25%\">场地名称</th>\r\n");
      out.write("\t<th width=\"15%\">场地设备情况</th>\r\n");
      out.write("\t<th width=\"10%\">容纳人数</th>\r\n");
      out.write("\t<th width=\"10%\">管理人员</th>\r\n");
      out.write("\t<th width=\"10%\">联系方式</th>\r\n");
      out.write("\t<th>场地使用情况</th>\r\n");
      out.write("</tr>\r\n");
  
UserInfo userinfo = Tool.getUserInfo(request);
if(!userinfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	if (userinfo != null) {
		userinfo.removeCookie(response);
	}
	session.removeAttribute("UserInfo");
	return ;
}
	String placecode="",area="",placename="",principal="",namehref="",modifyhref="",delhref="",apphref="",istr="",placeusestr="",instruments="",contact="";
	int id,order=0,peoplenums=0;
	ResultSet rs=null;
	List cdt1= new ArrayList();
	List list= new ArrayList();
	Places pla= new Places();
	list=pla.query(cdt1);
    if(list.size()>0){
    	for(int  i=0;i<list.size();i++){
    		pla=(Places)list.get(i);
    		area=pla.getArea();
    		namehref=pla.getPlaceName();
    		instruments=pla.getInstruments();
    		principal=pla.getPrincipal();
    		contact=pla.getContact();
    		placeusestr=
    		"<a href='places-application-list.jsp?_PlaceApplyId_="+pla.getId()+"'>点击查看</a>";
    		peoplenums=pla.getPeopleNums();
         

      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>");
      out.print(order+1);
      out.write("</td>\r\n");
      out.write("\t<td>");
      out.print(area);
      out.write("</td>\r\n");
      out.write("\t<td>");
      out.print(namehref);
      out.write("</td>\r\n");
      out.write("\t<td>");
      out.print(instruments);
      out.write("</td>\r\n");
      out.write("\t<td>");
      out.print(peoplenums );
      out.write("</td>\r\n");
      out.write("\t<td>");
      out.print(principal);
      out.write("</td>\r\n");
      out.write("\t<td>");
      out.print(contact);
      out.write("</td>\r\n");
      out.write("\t<td>");
      out.print(placeusestr);
      out.write("</td>\r\n");
      out.write("</tr>\r\n");

order++;
	}
}


      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("    <th colspan=\"9\" align=\"left\">说明：所有场地的列表</th>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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
