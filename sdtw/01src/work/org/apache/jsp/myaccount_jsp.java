/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-26 01:13:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;
import com.xietong.software.util.Tool;
import com.xietong.software.sdtw.db.BaseUserCode;
import com.xietong.software.common.UserInfo;
import com.xietong.software.common.HtmlTool;

public final class myaccount_jsp extends org.apache.jasper.runtime.HttpJspBase
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

String password,question1,answer1,truename,sexstr,nickname,birthday,email,mobiltel,homeaddress,hometel,workunit,officetel,fax,officeaddress,school,academy,major,classname;
String userrole,regtime,usergrouplist,accountstate;
ResultSet rs = null;

String[] questions=new String[7];
questions[0]="我最喜欢的运动";
questions[1]="我最难忘的日子";
questions[2]="我最喜欢的人";
questions[3]="我母亲的生日";
questions[4]="我父亲的生日";
questions[5]="我最喜欢的动物";
questions[6]="我最喜欢的水果";

String[] selectedstr=new String[7];
for (int i=0;i<7;i++)
    selectedstr[i]="";

UserInfo userInfo = Tool.getUserInfo(request);
BaseUserCode user = new BaseUserCode();
if(userInfo == null){
		out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
		return;
}else{
	user = userInfo.getUserCode();
	user=user.getById(user.getId());
}
String myaccount=user.getName();
String Password=Tool.decrypt(user.getPwd());
String cssLink="";
if(user.getId()==3){
	cssLink="<link href='css/common-student.css' rel='stylesheet' type='text/css'/>";
}else{
	cssLink="<link href='css/common.css' rel='stylesheet' type='text/css'/>";
}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("\r\n");
      out.print(cssLink);
      out.write("\r\n");
      out.write("<script src=\"js/tablelist.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-ui-1.10.2/jquery-1.9.1.js\"></script>\r\n");
      out.write("<script src=\"js/jquery.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"js/nice-validator/dist/jquery.validator.css\" type=\"text/css\"/>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("span{\r\n");
      out.write("\tcolor:red;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("// 验证数据的合法性，提交表单数据\r\n");
      out.write("function mysubmit(){\r\n");
      out.write("\tvar password=document.form1.yuanpassword.value;\r\n");
      out.write("\tvar newpassword1=document.form1.newpassword1.value;\r\n");
      out.write("\tvar newpassword2=document.form1.newpassword2.value;\r\n");
      out.write("\tvar mypassword=document.form1.mypassword.value;\r\n");
      out.write("\tvar account=document.form1.myaccount.value;\r\n");
      out.write("\tvar ok=true;\r\n");
      out.write("\t\r\n");
      out.write("\tif(password!=mypassword){\r\n");
      out.write("\t\tok=false;\r\n");
      out.write("\t\talert(\"原密码错误\");\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\tif(!newpassword1){\r\n");
      out.write("\t\tok=false;\r\n");
      out.write("\t\talert(\"新密码不能为空\")\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\tif(newpassword1!=newpassword2){\r\n");
      out.write("\t\tok=false;\r\n");
      out.write("\t\talert(\"新密码不一致\")\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\tif(ok){\r\n");
      out.write("\t\t $.ajax({\r\n");
      out.write("\t\t\t\turl:\"emailCheck.jsp?cmd=modify&user=\"+account+\"&xinmima=\"+newpassword1,\r\n");
      out.write("\t\t\t\ttype: \"post\",\r\n");
      out.write("\t\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\t\tasync:false,\r\n");
      out.write("\t\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\t\tif(data.msg==\"error\"){\r\n");
      out.write("\t\t\t\t\t\talert(\"账户不存在\");\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tif(data.msg==\"ok\"){\r\n");
      out.write("\t\t\t\t\t\talert(\"修改成功，请使用新密码重新登录\");\r\n");
      out.write("\t\t\t\t\t     \r\n");
      out.write("\t\t\t\t\ttop.location.href='main/logoff.jsp'\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tif(data.msg==\"no\"){\r\n");
      out.write("\t\t\t\t\t\talert(\"修改失败\")\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror: function (error) {\r\n");
      out.write("\t\t            alert(\"信息出错！\");\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(\"form\").validator({\r\n");
      out.write("    timely:2,\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");

String strposition = "基本信息  >> 修改密码";
String strfunction = "";
String strhelpwords= "我的账户信息。";

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
      out.write("<form  name=\"form1\" action=\"myaccountsave.jsp\" method=\"post\" data-validator-option=\"{timely:2, theme:'yellow_right_effect'}\">\r\n");
      out.write("<input type=\"hidden\" name=\"myaccount\" value=\"");
      out.print(myaccount);
      out.write("\">\r\n");
      out.write("<input type=\"hidden\" name=\"mypassword\" value=\"");
      out.print(Password);
      out.write("\">\r\n");
      out.write("<table class=\"content-table\">\r\n");
      out.write("<tr>\r\n");
      out.write("\t<th colspan=\"2\" align=\"left\">修改密码</th>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td width=\"45%\" align=\"right\"><span>*</span> 输入原密码：</td>\r\n");
      out.write("\t<td align=\"left\"><input class=\"text220\" type=\"password\" name=\"yuanpassword\" value=\"\" data-rule=\"password\"/></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td width=\"45%\" align=\"right\"><span>*</span> 输入新密码：</td>\r\n");
      out.write("\t<td align=\"left\"><input class=\"text220\" type=\"password\" name=\"newpassword1\" value=\"\" data-rule=\"password\" /></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("    \r\n");
      out.write("\t<td width=\"45%\" align=\"right\"><span>*</span> 重复新密码：</td>\r\n");
      out.write("\t<td align=\"left\"><input class=\"text220\" type=\"password\" name=\"newpassword2\" value=\"\" data-rule=\"password\" /></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr  height=\"5px\">\r\n");
      out.write("\t<td  colspan=\"2\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("   <th colspan=\"2\">\r\n");
      out.write("\t<input class=\"button\" type=\"button\" value=\"保存\" onclick=\"mysubmit()\">&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t<input class=\"button\" type=\"reset\" value=\"放弃 \"  onclick=\"mycancel()\">\r\n");
      out.write("   </th>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
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
