/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-25 08:28:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main.place;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.*;
import com.xietong.software.sdtw.*;
import com.xietong.software.sdtw.db.*;
import com.xietong.software.util.*;
import com.xietong.software.common.*;
import org.apache.commons.logging.*;

public final class places_002dapplytable_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"../css/common.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<script src=\"../js/tablelist.js\"></script>                 \r\n");
      out.write("<script src=\"../js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function form1datacheck(){   \r\n");
      out.write("\tif (document.form1.Applicant.value==\"\")\r\n");
      out.write("\t{\r\n");
      out.write("    \talert(\"使用单位不能为空！\");\r\n");
      out.write("    \tdocument.form1.Applicant.focus();\r\n");
      out.write("    \treturn false;\r\n");
      out.write("  \t}\r\n");
      out.write("\tif (document.form1.ActivityPrincipal.value==\"\")\r\n");
      out.write("\t{\r\n");
      out.write("        alert(\"活动负责人不能为空！\");\r\n");
      out.write("        document.form1.ActivityPrincipal.focus();\r\n");
      out.write("    \treturn false;\r\n");
      out.write("  \t}\r\n");
      out.write("  \tif (document.form1.PrincipalPhone.value==\"\")\r\n");
      out.write("\t{\r\n");
      out.write("        alert(\"活动负责人联系电话不能为空！\");\r\n");
      out.write("        document.form1.PrincipalPhone.focus();\r\n");
      out.write("    \treturn false;\r\n");
      out.write("  \t}\r\n");
      out.write("  \tif (document.form1.ActivityTime.value==\"\")\r\n");
      out.write("\t{\r\n");
      out.write("        alert(\"活动时间不能为空！\");\r\n");
      out.write("        document.form1.ActivityTime.focus();\r\n");
      out.write("    \treturn false;\r\n");
      out.write("  \t}\r\n");
      out.write("  \tif (document.form1.DistributionPeriod.value==\"\")\r\n");
      out.write("\t{\r\n");
      out.write("        alert(\"布场时段不能为空！\");\r\n");
      out.write("        document.form1.DistributionPeriod.focus();\r\n");
      out.write("    \treturn false;\r\n");
      out.write("  \t}\r\n");
      out.write("  \tif (document.form1.RehearsalPeriod.value==\"\")\r\n");
      out.write("\t{\r\n");
      out.write("        alert(\"彩排时段不能为空！\");\r\n");
      out.write("        document.form1.RehearsalPeriod.focus();\r\n");
      out.write("    \treturn false;\r\n");
      out.write("  \t}\r\n");
      out.write("  \tif (document.form1.ActivityContents.value==\"\")\r\n");
      out.write("\t{\r\n");
      out.write("        alert(\"活动内容不能为空！\");\r\n");
      out.write("        document.form1.ActivityContents.focus();\r\n");
      out.write("    \treturn false;\r\n");
      out.write("  \t}\r\n");
      out.write("  \tif (document.form1.Promiser.value==\"\")\r\n");
      out.write("\t{\r\n");
      out.write("        alert(\"承诺人不能为空！\");\r\n");
      out.write("        document.form1.Promiser.focus();\r\n");
      out.write("    \treturn false;\r\n");
      out.write("  \t}\r\n");
      out.write("  \tif (document.form1.PromiserPhone.value==\"\")\r\n");
      out.write("\t{\r\n");
      out.write("        alert(\"承诺人联系电话不能为空！\");\r\n");
      out.write("        document.form1.PromiserPhone.focus();\r\n");
      out.write("    \treturn false;\r\n");
      out.write("  \t}\r\n");
      out.write("  \treturn true;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function form1submit()\r\n");
      out.write("{\r\n");
      out.write("\tif(!form1datacheck())\r\n");
      out.write("\t{ \r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\tdocument.form1.submit();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function form1cancel()\r\n");
      out.write("{\r\n");
      out.write("\tdocument.form1.reset();\r\n");
      out.write("\tdocument.getElementsByTagName('body')[0].scrollTop = 0; //页面滚回顶部\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
 

	
// 	System.out.println(count);
// 	System.out.println(applydatastr);
	


      out.write("\r\n");
      out.write("<body>\r\n");

String strposition = "场地管理>>场地申请>>";
String strfunction = "场地申请表";
String strhelpwords = "查看场地的分配情况";
String applydata= ParamUtils.getParameter(request, "applydata", "");
System.out.println(applydata);
UserInfo userinfo=Tool.getUserInfo(request);
String [] sapplydata=Tool.split(",,",applydata);
if(userinfo==null){
	return;
}
BaseUserCode stu= userinfo.getUserCode();


      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<table class=\"command-table\">\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t   <a href=\"places-application-list.jsp\"><img src=\"../images/commandico/back.png\"/></a> \r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<form name=\"form1\" method=\"post\" action=\"Places_ApplytableAction.jsp?cmd=save\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<input type=\"hidden\" name=\"applydatastr\" value=\"");
      out.print(applydata);
      out.write("\">\r\n");
      out.write("<input type=\"hidden\" name=\"UserAccount\" value=\"");
      out.print(stu.getId());
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("<table class=\"content-table\">\r\n");
      out.write("<tr>\r\n");
      out.write("\t<th colspan=\"5\" align=\"left\">场地申请使用表</th>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td width=\"15%\"><span style=\"color:red\">*</span>使用单位</td>\r\n");
      out.write("\t<td width=\"35%\" align=\"left\"><input type=\"text\" name=\"Applicant\" size=\"30\" value=\"\" placeholder=\"输入申请场地的单位\"></td>\r\n");
      out.write("\t<td width=\"15%\"><span style=\"color:red\">*</span>活动负责人</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"text\" name=\"ActivityPrincipal\" size=\"30\" value=\"\" placeholder=\"输入该活动的负责人\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>活动负责人职务</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"text\" name=\"PrincipalDuty\" size=\"30\" value=\"\"></td>\r\n");
      out.write("\t<td><span style=\"color:red\">*</span>活动负责人联系电话</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"text\" name=\"PrincipalPhone\" size=\"30\" value=\"\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>拟用场地</td>\r\n");
      out.write("\t<td align=\"left\">\r\n");

for(int m=0;m<sapplydata.length;m++){


      out.write("\r\n");
      out.write("\t <span>");
      out.print(sapplydata[m].replace(',', ' ') );
      out.write("</span><br/>\r\n");
} 
      out.write("\r\n");
      out.write("\t</td>\r\n");
      out.write("\t<td><span style=\"color:red\">*</span>活动时间</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"text\" name=\"ActivityTime\" size=\"30\" value=\"\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td><span style=\"color:red\">*</span>布场时段</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"text\" name=\"DistributionPeriod\" size=\"30\" value=\"\"></td>\r\n");
      out.write("\t<td><span style=\"color:red\">*</span>彩排时段</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"text\" name=\"RehearsalPeriod\" size=\"30\" value=\"\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td><span style=\"color:red\">*</span>活动内容</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"text\" name=\"ActivityContents\" size=\"30\" value=\"\"></td>\r\n");
      out.write("\t<td>主讲人</td>\r\n");
      out.write("\t<td align=\"left\" colspan=\"2\"><input type=\"text\" name=\"Speaker\" size=\"30\" value=\"\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>基本程序</td>\r\n");
      out.write("\t<td align=\"left\" colspan=\"3\"><textarea name=\"BasicProcedures\"  style=\"width:82%\" rows=\"4\" ></textarea></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td colspan=\"4\">会场布置</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>会标内容</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"text\" name=\"MeetingMarks\" size=\"30\" value=\"\"></td>\r\n");
      out.write("\t<td>背景内容</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"text\" name=\"BackgroundContents\" size=\"30\" value=\"\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>商业赞助</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"text\" name=\"Aponsorship\" size=\"30\" value=\"\"></td>\r\n");
      out.write("\t<td>宣传形式</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"text\" name=\"Propaganda\" size=\"30\" value=\"\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>会场内其他宣传形式</td>\r\n");
      out.write("\t<td align=\"left\" colspan=\"3\"><textarea  name=\"OtherPropaganda\" style=\"width:82%\" rows=\"4\" ></textarea></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td colspan=\"4\">会场设施使用说明</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>桌子数量</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"number\" name=\"TableNums\" size=\"15\" value=\"\" placeholder=\"0\">&nbsp;张</td>\r\n");
      out.write("\t<td>椅子数量</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"number\" name=\"ChairNums\" size=\"15\" value=\"\" placeholder=\"0\">&nbsp;把</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>有线话筒</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"number\" name=\"WiredmicroPhoneNums\" size=\"15\" value=\"\" placeholder=\"0\">&nbsp;只</td>\r\n");
      out.write("\t<td>无线话筒</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"number\" name=\"WirelessmicroPhoneNums\" size=\"15\" value=\"\" placeholder=\"0\">&nbsp;只</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>话筒电池</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"number\" name=\"BatteryNums\" size=\"15\" value=\"\" placeholder=\"0\">&nbsp;块</td>\r\n");
      out.write("\t<td>使用发言台</td>\r\n");
      out.write("\t<td align=\"left\">\r\n");
      out.write("\t\t<input type=\"radio\" name=\"UseFloor\" value=\"1\" />是&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("      \t<input type=\"radio\" name=\"UseFloor\" value=\"0\"  checked =\"checked\"/>否\r\n");
      out.write("    </td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>使用音响设备</td>\r\n");
      out.write("\t<td align=\"left\">\r\n");
      out.write("\t\t<input type=\"radio\" name=\"UseAudio\" value=\"1\" />是&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("      \t<input type=\"radio\" name=\"UseAudio\" value=\"0\" checked =\"checked\"/>否\r\n");
      out.write("    </td>\r\n");
      out.write("    <td>使用照明灯光</td>\r\n");
      out.write("\t<td align=\"left\">\r\n");
      out.write("\t\t<input type=\"radio\" name=\"UseLighting\" value=\"1\" />是&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("      \t<input type=\"radio\" name=\"UseLighting\" value=\"0\" checked =\"checked\"/>否\r\n");
      out.write("    </td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>使用舞台灯光</td>\r\n");
      out.write("\t<td align=\"left\">\r\n");
      out.write("\t\t<input type=\"radio\" name=\"UseStageLight\" value=\"1\" />是&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("      \t<input type=\"radio\" name=\"UseStageLight\" value=\"0\" checked =\"checked\"/>否\r\n");
      out.write("    </td>\r\n");
      out.write("    <td>使用电脑灯</td>\r\n");
      out.write("\t<td align=\"left\">\r\n");
      out.write("\t\t<input type=\"radio\" name=\"UseComputerLight\" value=\"1\" />是&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("      \t<input type=\"radio\" name=\"UseComputerLight\" value=\"0\" checked =\"checked\"/>否\r\n");
      out.write("    </td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>使用投影仪</td>\r\n");
      out.write("\t<td align=\"left\">\r\n");
      out.write("\t\t<input type=\"radio\" name=\"UseProjector\" value=\"1\" />是&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("      \t<input type=\"radio\" name=\"UseProjector\" value=\"0\" checked =\"checked\"/>否\r\n");
      out.write("    </td>\r\n");
      out.write("    <td>使用空调</td>\r\n");
      out.write("\t<td align=\"left\">\r\n");
      out.write("\t\t<input type=\"radio\" name=\"UseAc\" value=\"1\" />是&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("      \t<input type=\"radio\" name=\"UseAc\" value=\"0\" checked =\"checked\"/>否\r\n");
      out.write("    </td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td colspan=\"4\">会场外布置</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>悬挂横幅</td>\r\n");
      out.write("\t<td align=\"left\">\r\n");
      out.write("\t\t<input type=\"radio\" name=\"UseBanner\" value=\"1\" />是&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("      \t<input type=\"radio\" name=\"UseBanner\" value=\"0\" checked =\"checked\"/>否\r\n");
      out.write("    </td>\r\n");
      out.write("    <td>横幅内容</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"text\" name=\"BannerContent\"\" size=\"30\" value=\"\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>张贴海报或展板</td>\r\n");
      out.write("\t<td align=\"left\">\r\n");
      out.write("\t\t<input type=\"radio\" name=\"UsePoster\" value=\"1\" />是&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("      \t<input type=\"radio\" name=\"UsePoster\" value=\"0\" checked =\"checked\"/>否\r\n");
      out.write("    </td>\r\n");
      out.write("    <td>参加人员车辆数量</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"number\" name=\"VehicleNums\" size=\"15\" value=\"\" placeholder=\"0\">&nbsp;辆</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>海报内容</td>\r\n");
      out.write("\t<td align=\"left\" colspan=\"3\"><textarea  name=\"PosterContent\"  style=\"width:82%\" rows=\"4\"></textarea></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>承办活动的负责人承诺</td>\r\n");
      out.write("\t<td align=\"left\" colspan=\"3\">\r\n");
      out.write("\t\t<p>\r\n");
      out.write("\t\t\t1.严格遵循场馆使用的相关说明，爱护场馆物品、设备等；<br/><br/>\r\n");
      out.write("\t\t\t2.如遇校团委活动冲突，服从校团委统一调度；<br/><br/>\r\n");
      out.write("\t\t\t3.活动时间、地点均可按照校团委要求临时调度；<br/><br/>\r\n");
      out.write("\t\t\t4.如有任何违规内容，承担相关责任，同意接受相关处罚。<br/><br/>\r\n");
      out.write("\t\t</p>\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\t\r\n");
      out.write("\t<td><span style=\"color:red\">*</span>承诺人</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"text\" name=\"Promiser\" size=\"30\" value=\"\"></td>\r\n");
      out.write("\t<td><span style=\"color:red\">*</span>联系电话</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"text\" name=\"PromiserPhone\" size=\"30\" value=\"\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\t\r\n");
      out.write("\t<td>学院</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"text\" name=\"PromiserAcadeMy\" size=\"30\" value=\"\"></td>\r\n");
      out.write("\t<td>班级</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"text\" name=\"PromiserClass\" size=\"30\" value=\"\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\t\r\n");
      out.write("\t<td>指导老师</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"text\" name=\"Tutor\" size=\"30\" value=\"\"></td>\r\n");
      out.write("\t<td>指导老师职务</td>\r\n");
      out.write("\t<td align=\"left\"><input type=\"text\" name=\"TutorDuty\" size=\"30\" value=\"\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\t\r\n");
      out.write("\t<td>指导老师联系方式</td>\r\n");
      out.write("\t<td align=\"left\" colspan=\"3\"><input type=\"text\" name=\"TutorPhone\" size=\"30\" value=\"\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\t\r\n");
      out.write("\t<td>备注</td>\r\n");
      out.write("\t<td align=\"left\" colspan=\"3\"><input type=\"text\" name=\"Remarks\" size=\"30\" value=\"\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<input type=\"hidden\" name=\"Status\" value=\"0\"/>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write(" \t<th colspan=\"4\">\r\n");
      out.write("\t\t<input type=\"button\" class=\"button\" value=\"提交\" name=\"btn1\" onclick=\"form1submit()\">&nbsp;&nbsp;&nbsp;\r\n");
      out.write("    \t<input type=\"button\" class=\"button\" value=\"取消\" name=\"btn2\" onclick=\"form1cancel()\">\r\n");
      out.write("\t</th>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
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
