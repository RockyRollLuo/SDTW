<%@page import="com.xietong.software.util.Cemail"%>

<%@page import="java.net.UnknownHostException"%>
<%@page import="java.net.InetAddress"%>
<%@ page language="java" %>
<%--网络会员信息--%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>

<%
String cmd = ParamUtils.getParameter(request, "cmd", "");

if(cmd.equals("chaxun")){
	
	
	System.out.println("wo jinlaile ");
	int id=ParamUtils.getIntParameter(request, "Id", -1);
	System.out.println(id);
	BaseUserCode stu= new BaseUserCode();
	stu=stu.getById(id);
	String xuehao=stu.getName();
    String deptid=stu.getDeptId()+"";
    String opid=stu.getOrgId()+"";
    String phone=stu.getPhone()+"";
    String email=stu.getEmail()+"";
    String nianji=stu.getGrade()+"";
    System.out.println("{\"msg\":\"ok\","+"\"name\":"+xuehao+",\"deptid\":"+deptid+",\"opid\":"+opid+",\"phone\":"+phone+",\"email\":"+email+",\"nianji\":"+nianji+"}");
    System.out.println("{\"msg\":\"ok\"}");
	/* out.print("{'msg':'ok'}"); */
       out.println("{\"msg\":\"ok\","+"\"name\":\""+xuehao+"\",\"deptid\":\""+deptid+"\",\"opid\":\""+opid+"\",\"phone\":\""+phone+"\",\"email\":\""+email+"\",\"nianji\":\""+nianji+"\"}");
      return;
}

%>

