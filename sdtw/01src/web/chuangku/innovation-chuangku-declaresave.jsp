<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="java.sql.*"%>
<%@ page import="pub.*" %>
<%@ include file="/session-confirm.jsp" %>

<%!
int retval;
%>
<%
String newsdate=mytime.getTime();
String academy=(String)session.getAttribute("academy");
String ckid=request.getParameter("ckid");

String cd1= gb2312.convert(request.getParameter("cd1"));
String cd2= gb2312.convert(request.getParameter("cd2"));
String cd3= gb2312.convert(request.getParameter("cd3"));
String cd4= gb2312.convert(request.getParameter("cd4"));
String cd5= gb2312.convert(request.getParameter("cd5"));
String cd6= gb2312.convert(request.getParameter("cd6"));
String cd7= gb2312.convert(request.getParameter("cd7"));
String cd8= gb2312.convert(request.getParameter("cd8"));
String cd9= gb2312.convert(request.getParameter("cd9"));
String cd10= gb2312.convert(request.getParameter("cd10"));
String cd11= gb2312.convert(request.getParameter("cd11"));
String cd12= gb2312.convert(request.getParameter("cd12"));
String cd13= gb2312.convert(request.getParameter("cd13"));
String cd14= gb2312.convert(request.getParameter("cd14"));

String cdp1= gb2312.convert(request.getParameter("cdp1"));
String cdp2= gb2312.convert(request.getParameter("cdp2"));
String cdp3= gb2312.convert(request.getParameter("cdp3"));
String cdp4= gb2312.convert(request.getParameter("cdp4"));
String cdteam= gb2312.convert(request.getParameter("cdteam"));

String addfilelist= gb2312.convert(request.getParameter("addfilelist"));
String foldercode= gb2312.convert(request.getParameter("foldercode"));


String userrole= (String)session.getAttribute("userrole");
int checkflag =  0;

String strSQL="INSERT INTO chuangku_declare(ckid,academy,addfilelist,foldercode,cd1,cd2,cd3,cd4,cd5,cd6,cd7,cd8,cd9,cd10,cd11,cd12,cd13,cd14,cdp1,cdp2,cdp3,cdp4,cdteam,addaccount,addtime) Values("      
       		 +  ckid
       		 + ",'" + academy
       		 + "','" + addfilelist
       		 + "','" + foldercode
       		 + "','" + cd1
       		 + "','" + cd2
       		 + "','" + cd3
       		+ "','" + cd4
       		+ "','" + cd5
       		+ "','" + cd6
       		+ "','" + cd7
       		+ "','" + cd8
       		+ "','" + cd9
       		+ "','" + cd10
       		+ "','" + cd11
       		+ "','" + cd12
       		+ "','" + cd13
       		+ "','" + cd14
       		
       		+ "','" + cdp1
       		+ "','" + cdp2
       		+ "','" + cdp3
       		+ "','" + cdp4
       		+ "','" + cdteam
       		
       	     + "','" + myuseraccount
             + "','" + newsdate
             + "')";

try{
	
	 tuanwei.executeUpdate("DELETE FROM chuangku_declare WHERE ckid="+ckid+" AND addaccount='"+myuseraccount+"'");
     retval=tuanwei.executeUpdate(strSQL);	  
}catch (Exception ex){
     System.out.print(ex.getMessage());      
}finally {
     tuanwei.disconnectToDB(); 
}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<% request.setCharacterEncoding("GBK"); %>
<link href="../pubcss/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../pubjs/tablelist.js"></script>
<script src="../pubjs/jquery.min.js"></script>
</head>

<%
String strposition = "创新创业>>山大创库>>";
String strfunction = "申请表";
String strhelpwords = "填写申请表。";
%>
<%@ include file="../pubpro/pagetop-positionandhelp.jsp" %>
<table class="frame-table" align="center">
   	<%if (retval==1) {%>
   		<tr height="35"><th>提交成功</th></tr>
   		<tr height="77"><td>申请表提交成功</td></tr>
	<%} else {%>
		<tr height="35"><th>提交失败</th></tr>
		<tr height="77"><td>请重新提交</td></tr>
	<%} %>
   	<tr height="35px"> 
     	<th><a href="innovation-chuangku-list.jsp">返回</a></th>
   	</tr>    
</table>
</html>
