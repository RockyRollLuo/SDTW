/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-25 05:38:26 UTC
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

public final class StudentRzdStudentForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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

String cmd = ParamUtils.getParameter(request, "cmd", "create");
int id = ParamUtils.getIntParameter(request, "id", -1);
int tabActive=ParamUtils.getIntParameter(request, "tabActive", -1);
StudentRzdUtil srUtil=new StudentRzdUtil();

StudentRzd v=new StudentRzd();
if("update".equals(cmd)||"view".equals(cmd)){//修改
	v=v.getById(id);
}

//rzd类型
List StudentRzdTypeNameoptions=CEditConst.getStudentRzdTypeNameOptions(userInfo);
Map checkMap=srUtil.getCheckMap();


      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>");
      out.print(request.getAttribute("describe"));
      out.write("</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/common-student.css\"/>\r\n");
      out.write("\t<script src=\"../../js/tablelist.js\"></script> \r\n");
      out.write("\t<script src=\"../js/jquery.min.js\"></script> \r\n");
      out.write("\t<script language=\"JavaScript\" src=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/js/datepicker/WdatePicker.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\tfunction ShowMessage(){ \r\n");
      out.write("\t\tvar cmdStr='");
      out.print(cmd);
      out.write("'; \r\n");
      out.write("\t\tif(cmdStr=='view'){\r\n");
      out.write("\t\t\tvar controls = document.getElementsByTagName(\"input\");\r\n");
      out.write("  \t\t\tfor(var i=0; i<controls.length; i++){\r\n");
      out.write("   \t\t\t\tcontrols[i].setAttribute('disabled','disabled');\r\n");
      out.write("   \t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t} \r\n");
      out.write("\twindow.load=ShowMessage(); \r\n");
      out.write("\t\r\n");
      out.write("\tfunction doValidate(){\r\n");
      out.write("\t\tvar alltime=\"\";\r\n");
      out.write("\t\tvar starttime= $(\"#Starttime\").val();\r\n");
      out.write("\t\tvar endtime=$(\"#Endtime\").val();\r\n");
      out.write("\t\tif(starttime!=null&&endtime!=null)\r\n");
      out.write("\t\t\talltime=starttime+\"-\"+endtime;\r\n");
      out.write("\t\tif(starttime!=null&&(endtime==null||endtime==\"\"))\t\r\n");
      out.write("\t\t\talltime=starttime;\r\n");
      out.write("\t\tdocument.postForm.Value3.value=alltime;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar value1=$(\"#Value1\").val();\r\n");
      out.write("\t\tvar value2=$(\"#Value2\").val();\r\n");
      out.write("\t\tvar value3=$(\"#Value3\").val();\r\n");
      out.write("\t\tvar value4=$(\"#Value4\").val();\r\n");
      out.write("\t\tif(value1==\"\"){\r\n");
      out.write("\t\t\t$(\"#Value1\").focus();\r\n");
      out.write("\t\t\talert(\"请输入活动名称!\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(value1!=\"\"){\r\n");
      out.write("\t\t\tif(value1.length>22){\r\n");
      out.write("\t\t\t\t$(\"#Value1\").focus();\r\n");
      out.write("\t\t\t\talert(\"不能超过22个字！\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(value3!=\"\"){\r\n");
      out.write("\t\t\tvar reg=/^(^\\d{4}\\.\\d{2}$)|(^\\d{4}\\.\\d{2}\\-\\d{4}\\.\\d{2}$)$/;\r\n");
      out.write("\t\t\tif(!reg.test(value3)){\r\n");
      out.write("\t\t\t\t$(\"#Value3\").focus();\r\n");
      out.write("\t\t\t\talert(\"日期格式:yyyy.mm或yyyy.mm-yyyy.mm\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$(\"#postForm\").submit(); \r\n");
      out.write("\t}\r\n");
      out.write("\t</script>\r\n");
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
      out.write("\t<td><a href=\"StudentRzdStudentList.jsp?tabActive=");
      out.print(tabActive);
      out.write("\">返回</a></td>\r\n");
      out.write("</tr>    \r\n");
      out.write("</table>\r\n");
      out.write("<form action=\"StudentRzdStudentAction.jsp\" method=\"post\" name=\"postForm\" id=\"postForm\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"cmd\" value=\"");
      out.print(cmd);
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"Id\" value=\"");
      out.print(v.getId());
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"Deptid\" value=\"");
      out.print(v.getDeptid());
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"ActivityId\" value=\"");
      out.print(v.getActivityId());
      out.write("\"/>\r\n");
      out.write("\t");
if("create".equals(cmd)){
      out.write("\r\n");
      out.write("\t \t<input type=\"hidden\" name=\"Modifyflag\" id=\"Modifyflag\" value=\"");
      out.print(SdtwConst.RZDMODIFY_WTJ);
      out.write("\"/>\r\n");
      out.write("\t");
}else{
      out.write("\r\n");
      out.write("\t \t<input type=\"hidden\" name=\"Modifyflag\" id=\"Modifyflag\" value=\"");
      out.print(v.getModifyflag());
      out.write("\"/>\r\n");
      out.write("\t");
}
      out.write("\r\n");
      out.write(" \t\r\n");
      out.write("\t<table class=\"content-table\" >\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th colspan=\"2\"></th>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"right\">类别</td>\r\n");
      out.write("\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t");
      out.print(HtmlTool.renderSelect(StudentRzdTypeNameoptions, "" + v.getType(), "Type", "-1"));
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");
if(!"create".equals(cmd)){//只要不是添加，都有
      out.write("\r\n");
      out.write(" \t<tr>\r\n");
      out.write(" \t\t<td align=\"right\">审核标志</td>\r\n");
      out.write("\t\t<td align=\"left\">\r\n");
      out.write(" \t\t\t<input type=\"hidden\" name=\"Checkflag\" id=\"Checkflag\" value=\"");
      out.print(v.getCheckflag());
      out.write("\" />\r\n");
      out.write(" \t\t\t");
      out.print(checkMap.get(v.getCheckflag()));
      out.write("\r\n");
      out.write(" \t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write(" \t<tr>\r\n");
      out.write(" \t\t<td align=\"right\">审核原因</td>\r\n");
      out.write("\t\t<td align=\"left\">\r\n");
      out.write(" \t\t\t<textarea name=\"Checkreason\" id=\"Checkreason\" cols=\"60\" rows=\"2\">");
      out.print(v.getCheckreason());
      out.write("</textarea>\r\n");
      out.write(" \t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");
}
      out.write("\r\n");
      out.write(" \t<tr>\r\n");
      out.write(" \t\t<td align=\"right\">组织/活动名称</td>\r\n");
      out.write("\t\t<td align=\"left\">\r\n");
      out.write(" \t\t\t<input name=\"Value1\" id=\"Value1\" size=\"45\" maxsize=\"45\" value=\"");
      out.print(v.getValue1());
      out.write("\"/>\r\n");
      out.write(" \t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write(" \t<tr>\r\n");
      out.write("\t\t<td align=\"right\">主办/主管/接收单位</td>\r\n");
      out.write("\t\t<td align=\"left\">\r\n");
      out.write(" \t\t<input name=\"Value2\" id=\"Value2\" size=\"45\" maxsize=\"45\" value=\"");
      out.print(v.getValue2());
      out.write("\" list=\"type_list\"/>\r\n");
      out.write(" \t\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write(" \t<tr>\r\n");
      out.write(" \t\t<td align=\"right\">起止时间</td>\r\n");
      out.write("\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"Value3\" id=\"Value3\" value=\"");
      out.print(v.getValue3());
      out.write("\"/>\r\n");
      out.write("\t\t\t");

			String alltime=v.getValue3();
			String starttime="",endtime="";
			if(alltime.length()>0) starttime=alltime.substring(0,7);
			if(alltime.length()>7) endtime=alltime.substring(8);
 			
      out.write("\r\n");
      out.write(" \t\t\t<input class=\"date\" name=\"Starttime\" id=\"Starttime\" size=\"0\" value=\"");
      out.print(starttime);
      out.write("\" readonly onclick=\"WdatePicker({el:'Starttime',dateFmt:'yyyy.MM',startDate: '%y.%M',onpicked:function(){}})\" >-\r\n");
      out.write(" \t\t\t<input class=\"date\" name=\"Endtime\"  id=\"Endtime\" size=\"0\" value=\"");
      out.print(endtime);
      out.write("\" readonly onclick=\"WdatePicker({dateFmt:'yyyy.MM',minDate:'#F{$dp.$D(\\'Starttime\\')',onpicked:function(){}})\" />\r\n");
      out.write(" \t\t\t格式：yyyy.mm或yyyy.mm-yyyy.mm\r\n");
      out.write(" \t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write(" \t<tr>\r\n");
      out.write(" \t\t<td align=\"right\">成果/经历</td>\r\n");
      out.write("\t\t<td align=\"left\">\r\n");
      out.write(" \t\t\t<input name=\"Value4\" id=\"Value4\" size=\"45\" maxsize=\"45\" value=\"");
      out.print(v.getValue4());
      out.write("\" list=\"type_list2\"/>\r\n");
      out.write(" \t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th colspan=\"2\">\r\n");
      out.write("\t\t");
if("create".equals(cmd)||"update".equals(cmd)){
      out.write("\r\n");
      out.write("\t        <input type=\"button\" class=\"button\" value=\"保存\" name=\"btn1\" onclick=\"javascript:doValidate();\"/>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t    ");
}else{
      out.write("\r\n");
      out.write("\t    \t<a href=\"#\" onclick=\"history.go(-1)\" >返回</a>\r\n");
      out.write("\t    ");
}
      out.write("\r\n");
      out.write("\t\t</th>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write(" \t</table>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<datalist id=\"type_list2\">\r\n");
      out.write("<option label=\"特等奖\" value=\"特等奖\"/>\r\n");
      out.write("<option label=\"一等奖\" value=\"一等奖\"/>\r\n");
      out.write("<option label=\"二等奖\" value=\"二等奖\"/>\r\n");
      out.write("<option label=\"三等奖\" value=\"三等奖\"/>\r\n");
      out.write("<option label=\"金奖\" value=\"金奖\"/>\r\n");
      out.write("<option label=\"银奖\" value=\"银奖\"/>\r\n");
      out.write("<option label=\"铜奖\" value=\"铜奖\"/>\r\n");
      out.write("<option label=\"优秀奖\" value=\"优秀奖\"/>\r\n");
      out.write("<option label=\"参与\" value=\"参与\"/>\r\n");
      out.write("<option label=\"发明专利\" value=\"发明专利\"/>\r\n");
      out.write("<option label=\"实用新型专利\" value=\"实用新型专利\"/>\r\n");
      out.write("<option label=\"外观设计专利\" value=\"外观设计专利\"/>\r\n");
      out.write("<option label=\"志愿者\" value=\"志愿者\"/>\r\n");
      out.write("<option label=\"负责人\" value=\"负责人\"/>\r\n");
      out.write("<option label=\"校级优秀团队(队长)\" value=\"校级优秀团队(队长)\"/>\r\n");
      out.write("<option label=\"校级优秀团队(队员)\" value=\"校级优秀团队(队员)\"/>\r\n");
      out.write("</datalist>\r\n");
      out.write("<datalist id=\"type_list\">\r\n");
      out.write("<option label=\"校团委\" value=\"校团委\"/>\r\n");
      out.write("<option label=\"学工部\" value=\"学工部\"/>\r\n");
      out.write("<option label=\"研工部\" value=\"研工部\"/>\r\n");
      out.write("<option label=\"本科生院\" value=\"本科生院\"/>\r\n");
      out.write("<option label=\"研究生院\" value=\"研究生院\"/>\r\n");
      out.write("<option label=\"就业指导中心\" value=\"就业指导中心\"/>\r\n");
      out.write("<option label=\"宣传部\" value=\"宣传部\"/>\r\n");
      out.write("<option label=\"学院\" value=\"学院名称\"/>\r\n");
      out.write("</datalist>\r\n");
      out.write("\t</body>\r\n");
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