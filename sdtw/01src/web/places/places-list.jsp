<%@ page contentType="text/html;charset=utf-8" %>
<%@page import="com.xietong.software.util.OptionBean"%>
<%@page import="com.xietong.software.sdtw.db.Places"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ page language="java"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@page import="com.xietong.software.base.Power"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../js/tablelist.js"></script>
<script src="../js/jquery.min.js"></script>

</head>
<body >

 <table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置>>场地信息>>场地列表
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>
<table class="command-table">
<tr height="35px">
	<td>
<!-- 	   <a href="places-search.jsp"><img src="../images/commandico/search.png"></a> -->
	</td>
</tr>
</table>

<table class="content-table" id="table2">
<tr>
	<th width="5%">序号</th>
	<th width="10%">所在校区</th>
	<th width="25%">场地名称</th>
	<th width="15%">场地设备情况</th>
	<th width="10%">容纳人数</th>
	<th width="10%">管理人员</th>
	<th width="10%">联系方式</th>
	<th>场地使用情况</th>
</tr>
<%  
UserInfo userinfo = Tool.getUserInfo(request);
if(!userinfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	if (userinfo != null) {
		userinfo.removeCookie(response);
	}
	session.removeAttribute("UserInfo");
	return ;
}
	String placecode="",area="",placename="",principal="",namehref="",modifyhref="",delhref="",apphref="",istr="",placeusestr="",instruments="",contact="";
	int id,order=0,peoplenums=0;
	ResultSet rs=null;
	List cdt1= new ArrayList();
	List list= new ArrayList();
	Places pla= new Places();
	list=pla.query(cdt1);
    if(list.size()>0){
    	for(int  i=0;i<list.size();i++){
    		pla=(Places)list.get(i);
    		area=pla.getArea();
    		namehref=pla.getPlaceName();
    		instruments=pla.getInstruments();
    		principal=pla.getPrincipal();
    		contact=pla.getContact();
    		placeusestr=
    		"<a href='places-application-list.jsp?_PlaceApplyId_="+pla.getId()+"'>点击查看</a>";
    		peoplenums=pla.getPeopleNums();
         
%>
<tr>
	<td><%=order+1%></td>
	<td><%=area%></td>
	<td><%=namehref%></td>
	<td><%=instruments%></td>
	<td><%=peoplenums %></td>
	<td><%=principal%></td>
	<td><%=contact%></td>
	<td><%=placeusestr%></td>
</tr>
<%
order++;
	}
}

%>
<tr>
    <th colspan="9" align="left">说明：所有场地的列表</th>
</tr>
</table>




</body>

</html>