/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-25 02:26:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main.studentrzd;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.base.SdtwConst;
import com.xietong.software.sdtw.*;
import com.xietong.software.sdtw.db.*;
import com.xietong.software.util.*;
import com.xietong.software.common.*;
import com.xietong.software.sdtw.rzd.StudentRzdUtil;
import org.apache.commons.logging.*;
import java.io.*;
import java.util.*;
import com.xietong.software.common.UserInfo;
import com.xietong.software.common.HeadConst;
import com.xietong.software.util.Tool;

public final class StudentRzdStudent_002dchoose_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
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

//默认值定义
UserInfo userInfo = Tool.getUserInfo(request);
if(userInfo == null){
  	out.print(HtmlTool.msgBox(request, "请先登录"));
  	return;
}
int stuid=userInfo.getId();
String cmd = ParamUtils.getParameter(request, "cmd", "choose");

StudentRzdUtil srUtil=new StudentRzdUtil();
Map rzdTypeMap=srUtil.rzdTypeMap;
Map rzdByTypeMap=srUtil.getPrintRzdByType(stuid);

      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>");
      out.print(request.getAttribute("describe"));
      out.write("</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/common-student.css\"/>\r\n");
      out.write("\t<script src=\"../../js/tablelist.js\"></script> \r\n");
      out.write("\t<script src=\"../js/jquery.min.js\"></script> \r\n");
      out.write("<script>\r\n");
      out.write("function clickCheckbox(){\r\n");
      out.write("\tvar count=0;\r\n");
      out.write("\tvar a = document.getElementsByName(\"checkitem\");\r\n");
      out.write("\tfor(var i=0;i<a.length;i++) { \r\n");
      out.write(" \t\tif(a[i].checked){ \r\n");
      out.write("\t\t\tcount++;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tdocument.getElementById(\"info\").innerHTML=count;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function printFunc(){\r\n");
      out.write("\tvar a = document.getElementsByName(\"checkitem\");\r\n");
      out.write(" \tvar checkdata=new Array(); //存放申请数据\r\n");
      out.write(" \tvar count=0; //数组行数\r\n");
      out.write("\tfor(var i=0;i<a.length;i++) { \r\n");
      out.write(" \t\tif(a[i].checked){ \r\n");
      out.write("\t\t\tcheckdata[count]=a[i].value;\r\n");
      out.write("\t\t\tcount++;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tif(count==0){\r\n");
      out.write("\t\talert(\"请至少选择一条！\");\r\n");
      out.write("\t}else if(count>50){\r\n");
      out.write("\t\talert(\"最多选50条！\");\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\twindow.open(\"StudentRzdStudent-print.jsp?idlist=\"+checkdata,\"_blank\",\r\n");
      out.write("\t\t\t\t\t\"width=794px,height=1090px,left=\"+(screen.width-794)*0.5+\",top=-20,directories=no,location=0,menubar=no,resizable=no,status=no,titlebar=no,toolbar=no\");  \r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function selectAll(){\r\n");
      out.write("\tvar checklist = document.getElementsByName(\"checkitem\");\r\n");
      out.write("\tif(document.getElementById(\"checkall\").checked){\r\n");
      out.write("\t\tfor(var i=0;i<checklist.length;i++){\r\n");
      out.write("\t\t\tchecklist[i].checked = 1;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdocument.getElementById(\"info\").innerHTML=checklist.length; \r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tfor(var j=0;j<checklist.length;j++){\r\n");
      out.write("\t\t\tchecklist[j].checked = 0;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdocument.getElementById(\"info\").innerHTML=0;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

String strposition = "组织建设>>五四评比表彰>>";
String strfunction ="学生拓展培养计划认证单";
String strhelpwords = "申请表。";

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
      out.write("<table class=\"command-table\">\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t<a href=\"StudentRzdStudentList.jsp\">返回</a>\r\n");
      out.write("\t\t已选<span id=\"info\">0</span>项\r\n");
      out.write("\t\t<a href=\"#\" onclick=\"printFunc()\">打印预览</a>\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>    \r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<table class=\"content-table\" >\r\n");
      out.write("<tr>\r\n");
      out.write("\t<th width=\"10%\">全选/取消<input type=\"checkbox\" id=\"checkall\" onclick=\"selectAll()\"/></th>\r\n");
      out.write("\t<th>组织/活动名称</th>\r\n");
      out.write("\t<th width=\"20%\">主办/主管/接收单位</th>\r\n");
      out.write("\t<th width=\"14%\">起止时间</th>\r\n");
      out.write("\t<th width=\"14%\">成果/经历</th>\r\n");
      out.write("</tr>\r\n");
 
for(Iterator it=rzdTypeMap.keySet().iterator();it.hasNext();){
	int type=(Integer)it.next();
	List list=(List<StudentRzd>)rzdByTypeMap.get(type)==null?new ArrayList():(List<StudentRzd>)rzdByTypeMap.get(type);
	
	if(list.size()>0){

      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>");
      out.print(rzdTypeMap.get(type));
      out.write("</th>\r\n");
      out.write("\t\t<th colspan=\"4\"></th>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");

	for(int i=0;i<list.size();i++){
		StudentRzd v=(StudentRzd)list.get(i);
	
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td><input type=\"checkbox\" name=\"checkitem\" value=\"");
      out.print(v.getId());
      out.write("\" onclick=\"clickCheckbox()\"></td>\r\n");
      out.write("\t\t\t<td>");
      out.print(v.getValue1());
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(v.getValue2());
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(v.getValue3());
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(v.getValue4());
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t");
}
	}
}
rzdTypeMap.clear();
rzdByTypeMap.clear();

      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("\t<th colspan=\"6\" align=\"left\"></th>\r\n");
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
