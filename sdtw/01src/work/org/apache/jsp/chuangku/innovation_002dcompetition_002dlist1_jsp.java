/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-25 07:07:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.chuangku;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.sdtw.db.ChuangKu;
import com.xietong.software.sdtw.db.ChuangkuDeclare;
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

public final class innovation_002dcompetition_002dlist1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
int proid=ParamUtils.getIntParameter(request, "Ckid",-1);
ChuangKu  ck= new ChuangKu ();
if(proid!=-1){

ck=ck.getById(proid);
}

      out.write("\r\n");
      out.write("<table class=\"location-table\">\r\n");
      out.write("<tr height=\"35\">\r\n");
      out.write("\t<td class=\"location-title\" >您的位置>>创新创业>>山大创库>>");
      out.print(ck.getCk1() );
      out.write("申请列表\r\n");
      out.write("\t\t<span style=\"cursor:pointer;\" onclick=\"showorhide_div('helpdiv')\"></span>\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<table class=\"command-table\">\r\n");
      out.write("<tr >\r\n");
      out.write("\r\n");
      out.write("  <td  height=\"35px\" align=\"right\">\r\n");
      out.write("     ");

   
  String timeend= ck.getAddTime();
  java.util. Date time=Tool.stringToDate(timeend);
  java.util. Date now =new java.util. Date();
  if((time.getTime()+86400000)<=now.getTime()){
	  
      out.write("  \r\n");
      out.write("\t <font color=\"red\"> 活动日期:");
      out.print(Tool.stringOfDate(ck.getCk2())+"~" +timeend);
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
      out.write("        <a href=\"innovation-chuangku-list.jsp\"  >返回</a> \r\n");
      out.write("   \r\n");
      out.write("  </td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<table class=\"content-table\">\r\n");
      out.write("\r\n");
      out.write("<tr height=\"35\">\r\n");
      out.write("  <th width=\"5%\">序号</th>\r\n");
      out.write("   <th width=\"20%\">创库名称</th>\r\n");
      out.write("  <th width=\"20%\">作品名称</th>\r\n");
      out.write(" \r\n");
      out.write("  <th width=\"17%\">项目分类</th>\r\n");
      out.write("  <th width=\"17%\">项目分组</th>\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  <th width=\"8%\">学校审核</th>\r\n");
      out.write("  <th colspan=\"3\">操作</th>\r\n");
      out.write("</tr>\r\n");





Map xynamemaps=CEditConst.getAcademyNameMap(userInfo);

Map zhongleiOptions=CEditConst.getCkProjectTypeMap(userInfo);
Map chuangyefenzuOptions=CEditConst.getCkProjectGroupMap(userInfo);
Map checkmaps=CEditConst.getAuditMap(userInfo);
System.out.println(checkmaps);
String istr="",production_name="",academy="",cd2="",cd3="",detailhref="",cd4="",cd5="",chuangku="";
int biaohao=1;
String namehref="";
ChuangkuDeclare ic= new ChuangkuDeclare();
List cdt1= new ArrayList();
List list1= new ArrayList();
if(proid>-1){
	cdt1.add("ckid ="+proid);
}

cdt1.add("addaccount ="+sno);
cdt1.add("order by id desc");
list1=ic.query(cdt1);
if(list1.size()>0){
	for(int i=0;i<list1.size();i++){
		
		ic=(ChuangkuDeclare)list1.get(i);
		if(ck!=null){
			chuangku=ck.getCk1();
		}
		 namehref="<a href='innovation-chuangku-details.jsp?id="+ck.getId()+"'>"+ck.getCk1()+"</a>";
		biaohao+=i;
		detailhref="<a href='innovation-chuangku-declaredetail.jsp?Id="+ic.getId()+"'>"+ic.getCd1()+"</a>";
		if(ic.getAcademy()!=""){
			academy=(String)xynamemaps.get(ic.getAcademy());
		
		}
		if(ic.getCd2()!=""){
			cd2=(String)zhongleiOptions.get(ic.getCd2());
			}
			if(ic.getCd3()!=""){
			cd3=(String)chuangyefenzuOptions.get(ic.getCd3()+"");
			}
		cd4=(String)checkmaps.get(ic.getCheckFlag()+"");
		
		cd5="<a href='ChuangkuDeclareAction.jsp?cmd=delete&&Id="+ic.getId()+"'>删除"+"</a>";
		if(ic.getCheckFlag()==1){
			cd5=""	;
		}
		

      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("  <td >");
      out.print(biaohao);
      out.write("&nbsp;</td>\r\n");
      out.write("  <td>");
      out.print(namehref);
      out.write("</td>\r\n");
      out.write("  <td >");
      out.print(detailhref);
      out.write("</td>   \r\n");
      out.write(" <td >");
      out.print(cd2);
      out.write("</td>\r\n");
      out.write(" <td >");
      out.print(cd3);
      out.write("</td>\r\n");
      out.write(" <td >");
      out.print(cd4);
      out.write("</td>\r\n");
      out.write("  <td colspan=\"2\" >");
      out.print(cd5);
      out.write("</td>\r\n");
      out.write("  \r\n");
      out.write("  <td >&nbsp;</td>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</tr>\r\n");
}} 
      out.write("\r\n");
      out.write("<tr height=\"50\">\r\n");
      out.write("  <td  style=\"background-color:#F7FBFF\" width=\"100%\" colspan=\"12\" align=\"left\">\r\n");
      out.write("    【说明】列表中列出您作为负责人参与的山大创库作品列表，已经通过审核的，不允许删除。\r\n");
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
