<%@ page contentType="text/html;charset=utf-8" %>

<%@ page session="true"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@page import="com.xietong.software.sdtw.db.*"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.HeadConst"%>

<%! 
int honournum1,honournum2,honournum3,honournum4,honournum5;
%>
<%

String id=request.getParameter("id");


String projectname="",addtime="",projectexplain="",starttime="",deadline="",addfilelist="",endtime="";
String honourname1="",honourname2="",honourname3="",honourname4="",honourname5="";
List list= new ArrayList();
List cdt= new ArrayList();
cdt.add("id="+id);
VolunteerProject va=new VolunteerProject();
list=va.query( cdt);
String ids="";
if(list.size()>0){
	va=(VolunteerProject)list.get(0);
	projectname=va.getProjectName();
	 starttime=Tool.stringOfDate(va.getStartTime());
     endtime=Tool.stringOfDate(va.getEndTime());
     deadline=Tool.stringOfDate(va.getDeadline());
     projectexplain=va.getText();
     ids=va.getAddFileList();
}
%>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<script src="../js/tablelist.js"></script>
<script src="../js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/common-student.css">
</head>
<body>
 <table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置>>志愿服务>>志愿竞赛>><%=projectname %>详情
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>

<table class="command-table">
<tr>
	<td>
 	   <a href="#" onclick="history.go(-1);">返回</a>
	</td>
</tr>
</table>

<table class="content-table">
<tr>
	<th colspan="2" align="left">项目详细信息</th>
</tr>
<tr>
	 <td width="25%" align="right">&nbsp;项目名称：</td>
	 <td align="left"><%=projectname%>&nbsp; </td>
</tr>
<tr>
	 <td align="right">&nbsp;项目日期：</td>
	 <td align="left"><%=starttime%>~<%=endtime%>&nbsp; </td>
</tr>
<tr>
	 <td align="right">&nbsp;报名截止日期：</td>
	 <td align="left"><%=deadline%>&nbsp; </td>
</tr>
<tr>
	 <td align="right">&nbsp;详细介绍：</td>
	 <td align="left"><%=projectexplain%>&nbsp; </td>
</tr>
<tr>
	 <td align="right">&nbsp;荣誉设置：</td>
	 <td align="left">

	 </td>
</tr>
<tr>
	 <td align="right">&nbsp;项目附件：</td>
	 <td align="left">
<%
ClientAttach ca1=new ClientAttach();
ClientAttach ca = new ClientAttach();

if(ids!=null&&ids.trim().length()>0){
	String[] idArray = Tool.split(",",ids);
	System.out.println(idArray);
	for(int i=0;i<idArray.length;i++){
	ca1= ca.getById(Tool.StrToInt(idArray[i]));
	 %>
	 <a href="<%=HeadConst.apache_url %>/servlet/attach?type=clientattach&id=<%=ca1.getId() %>" target="_blank"><img src='<%=HeadConst.apache_url %>/main/images/file1.gif' border="0"/>下载文件<%=ca1.getUploadName() %>
	</a> 
	<%
	}
}



%>   
	 	</td>
</tr>
<tr>
	<th colspan="2"></th>
</tr>

</table>
</body>
</html>
