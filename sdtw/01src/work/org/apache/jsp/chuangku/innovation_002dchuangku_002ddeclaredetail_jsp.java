/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-25 07:12:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.chuangku;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.sdtw.db.ChuangkuDeclare;
import java.sql.*;
import com.xietong.software.sdtw.*;
import com.xietong.software.sdtw.db.*;
import com.xietong.software.util.*;
import com.xietong.software.common.*;
import com.xietong.software.util.Tool;
import java.sql.*;
import java.util.*;

public final class innovation_002dchuangku_002ddeclaredetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<link href=\"../css/common-student.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<script src=\"../js/tablelist.js\"></script>\r\n");
      out.write("<script src=\"../js/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");

UserInfo userInfo=Tool.getUserInfo(request);
if(userInfo==null){
	return;
}
int declareid=ParamUtils.getIntParameter(request, "Id", -1);
Map zhongleiOptions=CEditConst.getCkProjectTypeMap(userInfo);
Map chuangyefenzuOptions=CEditConst.getCkProjectGroupMap(userInfo);
System.out.println(chuangyefenzuOptions);
Map xiangmujieduan=CEditConst.getCkProjectStageMap(userInfo);

String cd1="",cd2="",cd3="",cd4="",cd5="",cd6="",cd7="",cd8="",cd9="",cd10="",cd11="",cd12="",cd13="",cd14="";
String cdp1="",cdp2="",cdp3="",cdp4="",cdp5="",cdteam="",addfilelist="";
ChuangkuDeclare cd= new  ChuangkuDeclare ();
cd=cd.getById(declareid);

cd1=cd.getCd1();
if(cd.getCd2()!=""){
cd2=(String)zhongleiOptions.get(cd.getCd2());
}
if(cd.getCd3()!=""){
cd3=(String)chuangyefenzuOptions.get(cd.getCd3()+"");
}
cd4=cd.getCd4();
cd5=cd.getCd5();
cd6=cd.getCd6();

if(cd.getCd7()!=""){
cd7=(String)xiangmujieduan.get(cd.getCd7()+"  ");
}
cd8=cd.getCd8();
cd9=cd.getCd9();
cd10=cd.getCd10();
cd11=cd.getCd11();
cd12=cd.getCd12();
cd13=cd.getCd13();
cd14=cd.getCd14();

      out.write("\r\n");
      out.write("<body>\r\n");

String strposition = "创新创业>>山大创库>>";
String strfunction = "申请表详细";
String strhelpwords = "已填的申请表。";

      out.write("\r\n");
      out.write("<table class=\"location-table\">\r\n");
      out.write("<tr height=\"35\">\r\n");
      out.write("\t<td class=\"location-title\" >您的位置>>创新创业>>山大创库>>");
      out.print(cd.getCd1() );
      out.write("\r\n");
      out.write("\t\t<span style=\"cursor:pointer;\" onclick=\"showorhide_div('helpdiv')\"></span>\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<table class=\"command-table\">\r\n");
      out.write("<tr height=\"35px\">\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t<a href=\"innovation-chuangku-list.jsp\" >返回</a>\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>    \r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<form name=\"form1\" method=\"post\" action=\"innovation-chuangku-declaresave.jsp\">\r\n");
      out.write("<input type=\"hidden\" name=\"cdteam\" value=\"\"/>\r\n");
      out.write("<table class=\"content-table\">\r\n");
      out.write("<tr>\r\n");
      out.write("\t<th colspan=\"8\" align=\"left\">“山大创库”项目入库申请表</th> \r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td width=\"27%\" align=\"right\">项目名称</td>\r\n");
      out.write("\t<td align=\"left\">");
      out.print(cd1);
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"right\">项目分类</td>\r\n");
      out.write("\t<td align=\"left\">");
      out.print(cd2);
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"right\">项目分组</td>\r\n");
      out.write("\t<td align=\"left\">");
      out.print(cd3);
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"right\">创业团队</td>\r\n");
      out.write("\t<td align=\"left\">\r\n");
      out.write("\t\t<table class=\"content-table\" id=\"teamtable\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>姓名</td><td>学院</td><td>学号</td><td>联系方式</td><td>职责</td>\r\n");
      out.write("\t\t\t\t");

				BaseUserCode stu= new BaseUserCode();
				Map xynamemap=CEditConst.getAcademyNameMap(userInfo);
				ChuangkuDeclareMembers vpm= new ChuangkuDeclareMembers();
				List cdt1= new ArrayList();
				List list1= new ArrayList();
				cdt1.add("chuangkudeclareid ="+cd.getId());
				list1=vpm.query(cdt1);
				if(list1.size()>0){
					for(int i=0;i<list1.size();i++){
					vpm=(ChuangkuDeclareMembers)list1.get(i);
					stu=stu.getById(Integer.parseInt(vpm.getName()));
					cdp1=stu.getCnName();
					cdp2="";
					if(stu.getDeptId()!=-1){
					cdp2=(String)xynamemap.get(stu.getDeptId()+"");
					}
					cdp3= stu.getName();
					cdp4=vpm.getTel();
					cdp5=vpm.getDuty();
				 
				
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<td>");
      out.print(cdp1);
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(cdp2);
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(cdp3);
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(cdp4);
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(cdp5);
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");
 
					}
				}
			
			
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"right\">技术可行性分析</td>\r\n");
      out.write("\t<td align=\"left\">");
      out.print(cd4);
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"right\">市场可行性分析</td>\r\n");
      out.write("\t<td align=\"left\">");
      out.print(cd5);
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"right\">项目推进时间分析</td>\r\n");
      out.write("\t<td align=\"left\">");
      out.print(cd6);
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"right\">项目阶段</td>\r\n");
      out.write("\t<td align=\"left\">");
      out.print(cd7);
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"right\">项目情况</td>\r\n");
      out.write("\t<td align=\"left\">\r\n");
      out.write("\t\t<p>是否有社会资金注入：");
      out.print(cd8);
      out.write("（请注明注资额度为");
      out.print(cd9);
      out.write(" 万）</p>\r\n");
      out.write("\t\t<p>计划注册资本金为：");
      out.print(cd10);
      out.write("万，其中创业团队自有资金");
      out.print(cd11);
      out.write(" 万</p>\r\n");
      out.write("\t\t<p>团队已经经营该项目时间：");
      out.print(cd12);
      out.write("个月，盈利情况：");
      out.print(cd13);
      out.write(" 万</p>\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"right\">备注</td>\r\n");
      out.write("\t<td align=\"left\">");
      out.print(cd14);
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"right\">附件</td>\r\n");
      out.write("\t<td align=\"left\">\r\n");
      out.write(" ");

 String ids="";
 ids=cd.getAddFilelist();
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



      out.write(" \r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("\t<th colspan=\"2\">\r\n");
      out.write("\t</th>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
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
