/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-25 00:40:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.base.Power;
import com.xietong.software.base.SdtwConst;
import java.util.Map;
import com.xietong.software.common.CEditConst;
import com.xietong.software.sdtw.db.BaseUserCode;
import com.xietong.software.common.UserInfo;
import com.xietong.software.util.Tool;
import java.util.Date;
import com.xietong.software.sdtw.XtUtil;
import com.xietong.software.common.StrTool;
import com.xietong.software.util.ParamUtils;
import com.xietong.software.util.AESUtils;
import com.xietong.software.common.HeadConst;
import com.xietong.software.util.Cemail;
import java.util.Random;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=utf-8");
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
      out.write("   \r\n");
      out.write(" ");


String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
Random random = new Random();     
StringBuffer sb = new StringBuffer();     
for (int i = 0; i < 6; i++) {     
    int number = random.nextInt(base.length());     
    sb.append(base.charAt(number));     
}
String EmailCode = sb.toString();

      out.write("   \r\n");

response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
String cookUsername = "";
String coopds="";
boolean f1=false,f2=false;

Cookie cookies[] = request.getCookies();
if(cookies != null) {
    for(int i=0;i<cookies.length;i++) {
        if (cookies[i].getName().equals("SDFZUSERNAME_RE")) {
                cookUsername = cookies[i].getValue();
                f1=true;
        }
        
        if (cookies[i].getName().equals("SDFZEGOVPASWARDS")) {
        	coopds = AESUtils.decrypt("SDFZ_ZHXYabcde12", cookies[i].getValue());
            f2=true;
        }
       
        if(f1==true && f2 == true){
        	break;
        }
    }
}
String ipreq = ParamUtils.getParameter(request, "ip", "");
String ip = StrTool.getIpAddr(request); 
/*if(!ipreq.equals("5961") &&!ip.equals("127.0.0.1")&&!ip.equals("0:0:0:0:0:0:0:1")){
	String ips[] = ip.split("\\.");    
	if(ips.length>2){
		String ip2 =  ips[0] + "." + ips[1] + "." + ips[2] + ".*";
		List cdt = new ArrayList();
		cdt.add("ip='" + ip + "' or ip='" + ip2 + "'");
		cdt.add("enable=1");
		IpLimit  IpL = new IpLimit();
		if (IpL.getCount(cdt) < 1 ){
			out.println("Sorry, Your Ip can't visit the server! If you are our member, please mailing your information  to manager@sdxietong.com . Your Information include  name,department,email of company domain.");
			return;
		}
	}
	else{
		out.println("Sorry, Your Ip can't visit the server! If you are our member, please mailing your information  to manager@sdxietong.com . Your Information include  name,department,email of company domain.");
		return;
	}
}*/

String csrftoken = XtUtil.getRandomString(8);
session.setAttribute("csrftoken",csrftoken);
System.out.println(csrftoken);
String curDate = Tool.stringOfCnDateTime(new Date());
UserInfo userInfo = Tool.getUserInfo(request);
BaseUserCode user = new BaseUserCode();
if(userInfo!=null){
	System.out.println(userInfo.hasFunPower(Power.USERSTUDENTPOWER)+"  ");
	if(userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
		user = userInfo.getUserCode();
	}
}
Map RoleNameMap = CEditConst.getRoleNameMap(userInfo);
Map DeptNameMap = CEditConst.getAcademyNameMap(userInfo);
Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<title>山东大学拓展培养计划综合管理系统</title>\r\n");
      out.write("<link href=\"css/index.css\" rel=\"stylesheet\"/>\r\n");
      out.write("<!-- <script type=\"text/javascript\" src=\"js/jquery-ui-1.10.2/jquery-1.9.1.js\"></script> -->\r\n");
      out.write("\r\n");
      out.write("<title>山东大学拓展培养计划综合管理系统</title>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/main/jqueryui.jsp", out, false);
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery.jplaceholder.js\"></script>\r\n");
      out.write(" <script src=\"main/js/index.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("var EmailCode = '");
      out.print(EmailCode);
      out.write("';\r\n");
      out.write("var ok=true;\r\n");
      out.write("\r\n");
      out.write("function checkEmailCode(){\r\n");
      out.write("\t var flag = false;\r\n");
      out.write("\t \r\n");
      out.write("\t var EmailCode2 = $(\"#emailCode1\").val();\r\n");
      out.write("\r\n");
      out.write("\t if(EmailCode==EmailCode2){\r\n");
      out.write("\t\t flag = true;\r\n");
      out.write("\t }\r\n");
      out.write("\t if(flag==false){\r\n");
      out.write("\t\t ok=false;\r\n");
      out.write("\t\t $(\".xinmima\").hide();\r\n");
      out.write("\t\t$(\".cuowu\").show();\r\n");
      out.write("\t }\r\n");
      out.write("\t if(flag!=false){\r\n");
      out.write("\t\t ok=true;\r\n");
      out.write("\t\t $(\".cuowu\").hide();\r\n");
      out.write("\t\t$(\".xinmima\").show();\r\n");
      out.write("\t }\r\n");
      out.write("\t \r\n");
      out.write("\t return flag;\r\n");
      out.write("}\r\n");
      out.write("function send(){\r\n");
      out.write("\tvar email=document.getElementById(\"Email\").value;\r\n");
      out.write("\t var filter  = /^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$/;\r\n");
      out.write("\t//alert(EmailCode);\r\n");
      out.write("\tif(filter.test(email)){\r\n");
      out.write("\t $.ajax({\r\n");
      out.write("\t\t\turl:\"emailCheck.jsp?cmd=sendEmail&email=\"+email+\"&EmailCode=\"+EmailCode,\r\n");
      out.write("\t\t\ttype: \"post\",\r\n");
      out.write("\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\tasync:false,\r\n");
      out.write("\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror: function (error) {\r\n");
      out.write("\t            alert(\"信息出错！\");\r\n");
      out.write("\t        }\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("}else{\r\n");
      out.write("\talert(\"邮箱格式不对\")\r\n");
      out.write("}\r\n");
      out.write("\t//alert(\"2222\")\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("function xiugaimima(){\r\n");
      out.write("\tok=true;\r\n");
      out.write("\tvar mima1=$(\"#mima1\").val();\r\n");
      out.write("\tvar mima2=$(\"#mima2\").val();\r\n");
      out.write("\tif(!mima1){\r\n");
      out.write("\t\talert(\"密码不能为空\")\r\n");
      out.write("\t\tok=false;\r\n");
      out.write("\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\tif(mima1==mima2){\r\n");
      out.write("\t\tok=true;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\t\tok=false;\r\n");
      out.write("\t\talert(\"两次密码输出不一致请重新输入\")\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tif(ok){\r\n");
      out.write("\tvar xinmima=$(\"#mima1\").val();\r\n");
      out.write("\tvar user=$(\"#useraccount2\").val()\r\n");
      out.write("\t//alert(xinmima);\r\n");
      out.write("\t//alert(user);\r\n");
      out.write("\t $.ajax({\r\n");
      out.write("\t\t\turl:\"emailCheck.jsp?cmd=modify&user=\"+user+\"&xinmima=\"+xinmima,\r\n");
      out.write("\t\t\ttype: \"post\",\r\n");
      out.write("\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\tasync:false,\r\n");
      out.write("\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\tif(data.msg==\"error\"){\r\n");
      out.write("\t\t\t\t\talert(\"账户不存在\");\r\n");
      out.write("\t\t\t\t\t$('#useraccount2').focus();\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif(data.msg==\"ok\"){\r\n");
      out.write("\t\t\t\t\talert(\"修改成功\")\r\n");
      out.write("\t\t\t\t\t$('.loginBoxMask').fadeOut(100);\r\n");
      out.write("\t\t\t\t\t$('.pwRetrieveBox').slideUp(200);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif(data.msg==\"no\"){\r\n");
      out.write("\t\t\t\t\talert(\"修改失败\")\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror: function (error) {\r\n");
      out.write("\t            alert(\"信息出错！\");\r\n");
      out.write("\t        }\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//动态显示时间\r\n");
      out.write("var currentDate = new Date();   \r\n");
      out.write("function run(){       \r\n");
      out.write("\tcurrentDate.setSeconds(currentDate.getSeconds() + 1);\r\n");
      out.write("\t$('#currentTime').html(currentDate.toLocaleString()+\"\");\r\n");
      out.write("}     \r\n");
      out.write("window.setInterval(\"run();\", 1000); \r\n");



      out.write("\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$('#LoginBoxBtn').click(function(){//登录按钮\r\n");
      out.write("\t\t$('.loginBoxMask').fadeIn(100);\r\n");
      out.write("\t\t$('.loginBox').slideDown(200);\r\n");
      out.write("\t});\r\n");
      out.write("\t$('.loginBoxTop .closeBtn').click(function(){//关闭登录框\r\n");
      out.write("\t\t$('.loginBoxMask').fadeOut(100);\r\n");
      out.write("\t\t$('.loginBox').slideUp(200);\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$('#showPwRetrieveBox').click(function(){\r\n");
      out.write("\t\t$('.loginBoxMask').fadeIn(100);\r\n");
      out.write("\t\t$('.pwRetrieveBox').slideDown(200);\r\n");
      out.write("\t});\r\n");
      out.write("\t$('.pwRetrieveBoxTop .closeBtn').click(function(){\r\n");
      out.write("\t\t$('.loginBoxMask').fadeOut(100);\r\n");
      out.write("\t\t$('.pwRetrieveBox').slideUp(200);\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tif(\"");
      out.print(cookUsername );
      out.write("\".length>0){\r\n");
      out.write("\t\tdocument.logon.Username.value=\"");
      out.print(cookUsername);
      out.write("\";\r\n");
      out.write("\t\tdocument.logon.pd.value=\"");
      out.print(coopds);
      out.write("\";\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\t\tdocument.logon.Username.focus();\r\n");
      out.write("\t}\r\n");
      out.write("\tif(!placeholderSupport()){\r\n");
      out.write("\t\t$(\"input[placeholder]\").placeholder({isUseSpan:true});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("//////////////////////////////////////////////////////////////////////////////\r\n");
      out.write("\t//页面加载函数，没有函数名\r\n");
      out.write("\t//打开与关闭找回密码框\r\n");
      out.write("\t//LoginBoxBtn:登录按钮id\r\n");
      out.write("\t//loginBoxMask:\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#dlpic\").bind(\"click\",function(){\r\n");
      out.write("\t\tcheckuser();\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\"#czpic\").bind(\"click\",function(){\r\n");
      out.write("\t\tdocument.logon.reset();\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("function placeholderSupport() {\r\n");
      out.write("    return 'placeholder' in document.createElement('input');\r\n");
      out.write("}\r\n");
      out.write("if(document.addEventListener){//Firefox\r\n");
      out.write("\tdocument.addEventListener(\"keypress\",fireFoxHandler, true);\r\n");
      out.write("}else{//IE\r\n");
      out.write("\tdocument.attachEvent(\"onkeypress\",ieHandler);\r\n");
      out.write("}\r\n");
      out.write("function ieHandler(){\r\n");
      out.write("\t//仅对于IE有效\r\n");
      out.write("    ie = (document.all)? true:false\r\n");
      out.write("    if (ie){\r\n");
      out.write("        if(window.event.keyCode==13){\r\n");
      out.write("            checkuser();\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("function fireFoxHandler(evt){//firefox\r\n");
      out.write("\tif(evt.keyCode==13){\r\n");
      out.write("\t\t checkuser();\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function setFocus()\r\n");
      out.write("{\r\n");
      out.write("    if(document.logon.Username.value != \"\"){\r\n");
      out.write("        document.logon.pd.focus();\r\n");
      out.write("    }\r\n");
      out.write("    else{\r\n");
      out.write("        document.logon.Username.focus();\r\n");
      out.write("    }\r\n");
      out.write("    return;\r\n");
      out.write("}\r\n");
      out.write("//检查用户输入，无误后提交\r\n");
      out.write("function checkuser(type)\r\n");
      out.write("{\r\n");
      out.write("\t \r\n");
      out.write("    if(document.logon.Username.value==\"\" || $(\"#Username\").val() == $(\"#Username\").attr('placeholder')){\r\n");
      out.write("        alert(\"请输入用户名字！\");\r\n");
      out.write("        document.logon.Username.focus();\r\n");
      out.write("        return;\r\n");
      out.write("        //return false;\r\n");
      out.write("    }\r\n");
      out.write("    \t\t    \r\n");
      out.write("    if(document.logon.pd.value==\"\" || $(\"#pd\").val() == $(\"#pd\").attr('placeholder')){\r\n");
      out.write("        alert(\"请输入用户密码！\");\r\n");
      out.write("        document.logon.pd.focus();\r\n");
      out.write("        return;\r\n");
      out.write("        //return false;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("  \r\n");
      out.write("    document.logon.method=\"post\";\r\n");
      out.write("    if (type == undefined) {\r\n");
      out.write("        type = 0;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    document.logon.action=\"logon/enter.jsp?type=\" + type;\r\n");
      out.write("    document.logon.submit();\r\n");
      out.write("}\r\n");
      out.write("\r\n");

String url = "student-menudata.jsp";
if(user.getId()==-1){
url="index-studentmenu.jsp";
}
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("html,body{\r\n");
      out.write("\tborder:0;\r\n");
      out.write("\tmargin:0;\r\n");
      out.write("\tpadding:0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".topbanner{\r\n");
      out.write("\tmargin:0;\r\n");
      out.write("\twidth:100%;\r\n");
      out.write("/* \tmin-width:1400px; */\r\n");
      out.write("\theight:28px;\r\n");
      out.write("\tbackground:#630a10;\r\n");
      out.write("\tcolor:#fff;\r\n");
      out.write("\tfont:12px Microsoft YaHei;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".toptitle{\r\n");
      out.write("\tmargin:0;\r\n");
      out.write("\twidth:100%;\r\n");
      out.write("/* \tmin-width:1400px; */\r\n");
      out.write("\theight:120px;\r\n");
      out.write("\tbackground:#9c0c15;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".topbanner #currentTime{\r\n");
      out.write("\tfloat:left;\r\n");
      out.write("\tmargin-left:80px;\r\n");
      out.write("\tline-height:28px;\r\n");
      out.write("}\r\n");
      out.write(".topbanner .loginLine{\r\n");
      out.write("\tfloat:right;\r\n");
      out.write("\tmargin-right:80px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".menuandcontent{\r\n");
      out.write("\tposition:fixed;\r\n");
      out.write("\tbottom:30px;\r\n");
      out.write("\ttop:148px;\r\n");
      out.write("\tmargin:0;\r\n");
      out.write("\theight:90%;\r\n");
      out.write("\twidth:100%;\r\n");
      out.write("/* \tmin-width:1400px; */\r\n");
      out.write("}\r\n");
      out.write(".contentframe{\r\n");
      out.write("\tpadding:0;\r\n");
      out.write("\tmargin:0;\r\n");
      out.write("\theight:100%;\r\n");
      out.write("\twidth:100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".footer{\r\n");
      out.write("\tposition:fixed;\r\n");
      out.write("\tbottom:0;\r\n");
      out.write("\tmargin:0;\r\n");
      out.write("\twidth:100%;\r\n");
      out.write("/* \tmin-width:1400px; */\r\n");
      out.write("\theight:30px;\r\n");
      out.write("}\r\n");
      out.write(".footerframe{\r\n");
      out.write("\tmargin:0;\r\n");
      out.write("\tpadding:0;\r\n");
      out.write("\twidth:100%;\r\n");
      out.write("\theight:30px;\r\n");
      out.write("}\r\n");
      out.write(".ipt {\r\n");
      out.write("\tborder: solid 1px #d2d2d2;\r\n");
      out.write("\tborder-radius: 2px;\r\n");
      out.write("\tpadding: 4px 6px;\r\n");
      out.write("\theight: 21px;\r\n");
      out.write("\tline-height: 21px;\r\n");
      out.write("\tcolor: #555;\r\n");
      out.write("\twidth: 180px;\r\n");
      out.write("\tvertical-align: middle;\r\n");
      out.write("}\r\n");
      out.write(".ipt:focus {\r\n");
      out.write("\tborder-color: #95C8F1;\r\n");
      out.write("\tbox-shadow: 0 0 4px #95C8F1;\r\n");
      out.write("}\r\n");
      out.write("/* loginBtn 按钮 */\r\n");
      out.write(".loginBtn {\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("\theight: 26px;\r\n");
      out.write("\tline-height: 26px;\r\n");
      out.write("\twidth:60px;\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\tvertical-align: middle;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tfont-weight:bold;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tborder-radius: 4px;\r\n");
      out.write("\tborder: 1px solid #630a10;\r\n");
      out.write("\tcolor: #ffffff;\r\n");
      out.write("\tbackground-color:#630a10;\r\n");
      out.write("\tvertical-align:middle;\r\n");
      out.write("}\r\n");
      out.write(".loginBtn:hover {\r\n");
      out.write("\tcolor:#ffffff;\r\n");
      out.write("\tborder: 1px solid #9c0c15;\r\n");
      out.write("\tbackground-color:#9c0c15;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* *--------------------登录框的半透明背景------------------------* */\r\n");
      out.write(".loginBoxMask {\r\n");
      out.write("\tz-index: 9998;\r\n");
      out.write("\tposition:fixed;\r\n");
      out.write("\ttop:0;\r\n");
      out.write("\tleft:0;\r\n");
      out.write("\twidth:100%;\r\n");
      out.write("\theight:100%;\r\n");
      out.write("\tbackground:#000;\r\n");
      out.write("\topacity:0.4;\r\n");
      out.write("\tfilter:alpha(opacity=40);\r\n");
      out.write("\tdisplay:none\r\n");
      out.write("}\r\n");
      out.write("/* *--------------------loginBox------------------------* */\r\n");
      out.write(".loginBox,.pwRetrieveBox{\r\n");
      out.write("\tz-index:9999;\r\n");
      out.write("\tposition:fixed;\r\n");
      out.write("\ttop:50%;\r\n");
      out.write("\tleft:50%;\r\n");
      out.write("\twidth:600px;\r\n");
      out.write("\theight:350px;\r\n");
      out.write("\tmargin:-150px 0 0 -300px;   /*整个背景是个div*/\r\n");
      out.write("\tborder-radius:5px;\r\n");
      out.write("\tborder:solid 2px #666;\r\n");
      out.write("\tbackground-color:#fff;\r\n");
      out.write("\tdisplay:none;\r\n");
      out.write("\tbox-shadow: 0 0 10px #666;\r\n");
      out.write("}\r\n");
      out.write("/* *--------------------loginBoxTop------------------------* */\r\n");
      out.write(".loginBoxTop,.pwRetrieveBoxTop{\r\n");
      out.write("\tborder-bottom:1px solid #ddd;\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\theight:20px;\r\n");
      out.write("\tpadding:12px;\r\n");
      out.write("\tfont:15px Microsoft YaHei;\r\n");
      out.write("\tcolor:#444;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* *--登录框关闭红叉--* */\r\n");
      out.write(".closeBtn{\r\n");
      out.write("\tfont-size:20px;\r\n");
      out.write("\tmargin-top:-5px;\r\n");
      out.write("\tfloat:right;\r\n");
      out.write("\tcolor:#444;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write(".closeBtn:hover{\r\n");
      out.write("\tcolor:#9c0c15;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("/* *--------------------loginBoxContent------------------------* */\r\n");
      out.write(".loginBoxContent,.pwRetrieveBoxContent{\r\n");
      out.write("\tmargin-top:40px;  \r\n");
      out.write("\tmargin-left:150px;  \r\n");
      out.write("\tcolor:#444;\r\n");
      out.write("\theight:250px;\r\n");
      out.write("\tfont:14px Microsoft YaHei;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".loginFrom {\r\n");
      out.write("\ttext-align:left;\r\n");
      out.write("}\r\n");
      out.write("/* *--------------------loginBoxBottom------------------------* */\r\n");
      out.write(".loginBoxBottom,.pwRetrieveBoxBottom{\r\n");
      out.write("\twidth:100%;\r\n");
      out.write("\theight:41px;\r\n");
      out.write("\tbackground:#DDD;\r\n");
      out.write("\tfont:13px Microsoft YaHei;\r\n");
      out.write("\tcolor:#444;\r\n");
      out.write("}\r\n");
      out.write(".loginBoxBottom p,.pwRetrieveBoxBottom p{\r\n");
      out.write("\tline-height:41px; /*与上面的height保持一致*/\r\n");
      out.write("\tpadding-left:20px;\r\n");
      out.write("}\r\n");
      out.write(".leftline{\r\n");
      out.write("\tline-height:28px;\r\n");
      out.write("\tfloat:left;\r\n");
      out.write("\tdisplay:inline;   /*不占一行 */\r\n");
      out.write("\tpadding-left:5em;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<link type=\"text/css\" href=\"main/js/jquery-ui-1.10.2/themes/bootstrap/css/custom-theme/jquery-ui-1.10.0.custom.css\" rel=\"stylesheet\" />\r\n");
      out.write("<style>\r\n");
      out.write(".ui-dialog .ui-dialog-titlebar-close span{margin: -10px;}\r\n");
      out.write(".ui-dialog .ui-dialog-title{font-size: 14px;}\r\n");
      out.write(".ui-button-text-only .ui-button-text{font-size: 12px;}\r\n");
      out.write(".ui-dialog .ui-dialog-titlebar-close span{text-indent:-1e+7px;}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"topbanner\">\r\n");
      out.write("\t<div id=\"currentTime\"></div>\r\n");
      out.write("\t");

	if(user.getId()!=-1){
      out.write("\r\n");
      out.write("\t<div class=\"leftline\">\r\n");
      out.write("\t    <span class=\"label\">用户账户：</span>");
      out.print(user.getName());
      out.write("&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t    <span class=\"label\">角色：</span>");
      out.print(RoleNameMap.get(user.getRoles()+""));
      out.write('(');
      out.print(DeptNameMap.get(user.getDeptId()+""));
      out.write(")&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"loginLine\">\r\n");
      out.write("\t\t<a class=\"loginBtn\" href=\"myaccount.jsp\" target=\"contentFrame1\" >我的账户</a>|\r\n");
      out.write("\t\t<a class=\"loginBtn\" href=\"main/sitemsg-list.jsp\" target=\"contentFrame1\" >消息中心</a>\r\n");
      out.write("\t\t<a class=\"loginBtn\" href=\"javascript:;\" onclick=\"{if(confirm('确定要退出系统吗?')){window.location.href='main/logoff.jsp'}}\"; id=\"showPwRetrieveBox\">退出</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
}else{
      out.write("\r\n");
      out.write("\t<div class=\"loginLine\">\r\n");
      out.write("\t\t<a class=\"loginBtn\" href=\"javascript:;\" id=\"LoginBoxBtn\">登&nbsp;&nbsp;录</a>|\r\n");
      out.write("\t\t<a class=\"loginBtn\" href=\"javascript:;\" id=\"showPwRetrieveBox\">找回密码</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
}
	
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"toptitle\">\r\n");
      out.write("   <a href=\"index.jsp\">\r\n");
      out.write("\t<div style=\"padding-left:40px\"><img src=\"images/toptitle.jpg\"></div>\r\n");
      out.write("\t</a>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"menuandcontent\">\r\n");
      out.write("<iframe class=\"contentframe\" name=\"contentFrame\" id=\"contentframe\" frameborder=\"0\" scrolling=auto src=\"");
      out.print(url);
      out.write("\" ></iframe>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"loginBox\">\r\n");
      out.write("\t<div class=\"loginBoxTop\">\r\n");
      out.write("\t\t<strong>山东大学学生素质拓展培养综合管理系统</strong>\r\n");
      out.write("\t\t<a href=\"javascript:;\" title=\"关闭\" class=\"closeBtn\">×</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"loginBoxContent\">\r\n");
      out.write("\t\t<form class=\"loginFrom\" name=\"logon\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"csrftoken\" value=\"");
      out.print(csrftoken);
      out.write("\"/>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t<strong>账&nbsp;&nbsp;户：</strong>\r\n");
      out.write("\t\t\t\t<!-- <input type=\"text\" name=\"useraccount\" id=\"useraccount\"  onblur=\"LoginBoxCheck(1);return false;\" placeholder=\"输入账户名\" autocomplete=\"off\" size=\"20\" class=\"ipt\"/> -->\r\n");
      out.write("\t\t\t\t<input name=\"Username\" id=\"Username\" type=\"text\" value=\"\" class=\"logininput001\" placeholder=\"请输入用户名\" autocomplete=\"off\"/>\r\n");
      out.write("\t\t\t\t<span id=\"logininfo1\"></span>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t<strong>密&nbsp;&nbsp;码：</strong>\r\n");
      out.write("\t\t\t\t<!-- <input type=\"password\" name=\"userpassword\" id=\"password\"  onchange=\"LoginBoxCheck(2);return false;\" placeholder=\"输入密码\" autocomplete=\"off\" size=\"20\"  class=\"ipt\"/> -->\r\n");
      out.write("\t\t\t\t<input name=\"pd\" id=\"pd\" type=\"password\" value=\"\" class=\"logininput002\" placeholder=\"请输入密码\"/>\r\n");
      out.write("\t\t\t\t<span id=\"logininfo2\"></span>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p style=\"padding-left:48px;\">\r\n");
      out.write("\t\t\t\t<input type=\"button\" id=\"dlpic\" value=\"登&nbsp;&nbsp;录 \" class=\"loginBtn\" />\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"loginBoxBottom\">\r\n");
      out.write("\t\t<p>学生用户首次登录默认密码为身份证号后6位，首次登录后请修改密码。</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"loginBoxMask\"></div>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"pwRetrieveBox\">\r\n");
      out.write("\t<div class=\"pwRetrieveBoxTop\">\r\n");
      out.write("\t\t<strong>找回密码</strong>\r\n");
      out.write("\t\t<a href=\"javascript:;\" title=\"关闭\" class=\"closeBtn\">×</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"pwRetrieveBoxContent\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t<strong>账&nbsp;&nbsp;&nbsp;户：</strong>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"useraccount\"  id=\"useraccount2\" onchange=\"LoginBoxCheck(3);return false;\"  placeholder=\"输入账户名\" autocomplete=\"off\" size=\"20\" class=\"ipt\"/>\r\n");
      out.write("\t\t\t\t<span id=\"logininfo3\"></span>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t<strong>邮&nbsp;&nbsp;&nbsp;箱：</strong>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"Email\" id=\"Email\" placeholder=\"输入邮箱\" autocomplete=\"off\" size=\"20\" class=\"ipt\" />\r\n");
      out.write("\t\t\t\t<span id=\"logininfo4\"></span><input type=\"button\" value=\"发送\" onclick=\"send()\" class=\"loginBtn\">\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t<strong>验证码：</strong>\r\n");
      out.write("\t\t\t\t<input onchange=\"checkEmailCode()\" type=\"text\" name=\"Answer1\" id=\"emailCode1\" placeholder=\"输入邮箱验证码\" autocomplete=\"off\" size=\"20\" class=\"ipt\" />\r\n");
      out.write("\t\t\t\t<span id=\"EmailCode\"></span>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p class=\"cuowu\" style=\"display:none;\">\r\n");
      out.write("\t\t\t    <font color=\"red\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;验证码错误</font>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p class=\"xinmima\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t<strong>新密码：</strong>\r\n");
      out.write("\t\t\t\t<input type=\"password\" name=\"Answer1\" id=\"mima1\" placeholder=\"输入新密码\" autocomplete=\"off\" size=\"20\" class=\"ipt\" />\r\n");
      out.write("\t\t\t\t<span id=\"EmailCode\"></span>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p class=\"xinmima\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t<strong>新密码：</strong>\r\n");
      out.write("\t\t\t\t<input  type=\"password\" name=\"Answer1\" id=\"mima2\" placeholder=\"确认新密码\" autocomplete=\"off\" size=\"20\" class=\"ipt\" />\r\n");
      out.write("\t\t\t\t<span id=\"EmailCode\"></span>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p style=\"padding-left:48px;\">\r\n");
      out.write("\t\t\t\t<input type=\"button\" id=\"pwRetrieveBtn\" value=\"确&nbsp;&nbsp;定 \" onclick=\"xiugaimima()\" class=\"loginBtn\"/>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"pwRetrieveBoxBottom\">\r\n");
      out.write("\t\t<p id=\"RetrivePW\"></p>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"footer\">\r\n");
      out.write("\t<iframe class=\"footerframe\" frameborder=\"0\" scrolling=\"auto\" src=\"index-footer.jsp\"></iframe>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"top_dialog\"></div>\r\n");
      out.write("<script>\r\n");
      out.write("$(\"#top_dialog\").dialog({\r\n");
      out.write("\tmodal: true,\r\n");
      out.write("\tautoOpen:false,\r\n");
      out.write("\theight:0\r\n");
      out.write("});\r\n");
      out.write("var tmpW = 900 , tmpH = 600;\r\n");
      out.write("$('.ui-dialog-title').dblclick(function(){\r\n");
      out.write("\tvar d_h1 = parent.document.documentElement.scrollHeight;\r\n");
      out.write("\tvar d_h2 = parent.document.body.scrollHeight;\r\n");
      out.write("\tvar d_h = Math.max(d_h1, d_h2);\r\n");
      out.write("\tif($(\"#top_dialog\").dialog('option','width') != $('body').width()){\r\n");
      out.write("\t\t$(\"#top_dialog\").dialog('option','width',$('body').width());\r\n");
      out.write("\t\t$(\"#top_dialog\").dialog('option','height',d_h);\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\t$(\"#top_dialog\").dialog('option','width',tmpW);\r\n");
      out.write("\t\t$(\"#top_dialog\").dialog('option','height',tmpH);\r\n");
      out.write("\t}\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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
