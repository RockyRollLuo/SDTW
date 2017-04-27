<%@page import="com.xietong.software.util.Cemail"%>

<%@page import="java.net.UnknownHostException"%>
<%@page import="java.net.InetAddress"%>
<%@ page language="java" %>
<%--网络会员信息--%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="com.xietong.software.util.Cemail"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>

<%
String cmd1 = ParamUtils.getParameter(request, "cmd", "");
UserInfo userInfo = Tool.getUserInfo(request);
if("sendEmail".equals(cmd1)){
String email = ParamUtils.getParameter(request, "email", "");
//email="952417852@qq.com";
String subject="山大素质管理中心密码修改验证码";
String content = ParamUtils.getParameter(request, "EmailCode", "");
System.out.println("我进入和这个方法了111"+email+content);
Cemail.sendEmail(email, subject, content);
out.println("{\"msg\":\""+content+"\"}");
}
else if("modify".equals(cmd1)){
	System.out.println("我进来了");
	String NewPwd = ParamUtils.getParameter(request, "xinmima");
	String username = ParamUtils.getParameter(request, "user", "");
	BaseUserCode user = new BaseUserCode();
	List cdt = new ArrayList();
	List list = new ArrayList();
	cdt.add("name='"+username+"'");
	cdt.add("enable=1");
	list = user.query(cdt);
	if(list.size()>0){
		for(int i=0;i<list.size();i++){
			user = (BaseUserCode)list.get(i);
			user.setPwd(Tool.encrypt(NewPwd));
			int num = user.update();
			if(num>0){
				out.print("{\"msg\":\"ok\"}");
			}else{
				out.print("{\"msg\":\"no\"}");
			}
		}
	}else{
		out.print("{\"msg\":\"error\"}");
	}
	return;
}

%>













