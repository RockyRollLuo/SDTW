<%@ page pageEncoding="utf-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@page import="java.util.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xietong.software.sdtw.db.*"%>
<%@page import="com.xietong.software.base.Power"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
  <link rel="stylesheet" type="text/css" href="../css/common-student.css">
  <script src="../js/tablelist.js"></script>
  <script src="../js/jquery.min.js"></script> 
</head>



<body>
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	if (userInfo != null) {
		userInfo.removeCookie(response);
	}
	session.removeAttribute("UserInfo");
	return ;
}
String strposition = "创新创业列表>>创业项目管理";
String strfunction = "创业项目列表";
String strhelpwords = "创业项目列表。";
%>
<table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置>>创新创业>>创业竞赛列表
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>

<table width="97%">
<tr height="25">
  <td align="right">
<!--     <a href="innovation-competition-project-xyexport.jsp" >导出</a> 
 -->  </td>
</tr>    
</table>

<table class="content-table">

<tr height="35">
  <th width="5%">序号</th>
  <th width="20%">项目名称</th>  
   
  <th width="12%">负责人</th>
  <th width="15%">起始时间</th>
  <th width="15%">截止时间</th>
  <th colspan="3">操作</th>
</tr>
<%
int pagenumstr=Integer.parseInt(ParamUtils.getParameter(request, "page", "1"));
String istr="", id,projectname="",projectid="",projectleader="",timestart="",timeend="",detailhref="",activitylhref="";
InnovationCompetitionProject icp= new InnovationCompetitionProject();
List cdt= new  ArrayList();
List list= new ArrayList();
cdt.add("order by id desc");
list =icp.query(cdt);
int xuhao=0;
int tiaoshu=list.size();
if(list.size()>0){
	for(int i=0;i<list.size();i++){
		icp=(InnovationCompetitionProject )list.get(i);
xuhao++;
 detailhref="<a href='innovation-competition-project-detail.jsp?id="+icp.getId()+"'>"+icp.getProjectName()+"</a>";
 projectleader=icp.getProjectLeader();
 timestart=icp.getTimeStart() ;
 timeend=icp.getTimeEnd();
%>

<tr height="27">
  	<td  align="center"><%=xuhao%>&nbsp;</td>
  	<td  align="left"><%=detailhref%>&nbsp;</td>          
  	 
  	<td  align="center"><%=projectleader%>&nbsp;</td>          
  	<td  align="center"><%=timestart %>&nbsp;</td>   
  	<td  align="center"><%=timeend%>&nbsp;</td>
  	<td colspan="3" align="center"><a href='innovation-competition-list.jsp?proid=<%=icp.getId()%>'>查看我的作品</a></td>
  	
</tr>
<%

}}%>
<tr height=40>
	<th width="100%" colspan="15" align="center">
		共&nbsp<%=tiaoshu %>&nbsp条&nbsp;&nbsp;&nbsp;当前第<%=pagenumstr %>页&nbsp;&nbsp;&nbsp;
			<%
		
		int shangyiye=pagenumstr-1>0?pagenumstr-1:1;
		int xiayiye=pagenumstr*8<tiaoshu?pagenumstr+1:pagenumstr;
		%>
   		<a href="innovation-competition-project-list.jsp">首页</a>&nbsp;&nbsp;&nbsp;
		<a href="innovation-competition-project-list.jsp?page=<%=shangyiye %>" >上一页</a>  &nbsp;&nbsp;&nbsp;
		
		<a href="innovation-competition-project-list.jsp?page=<%=xiayiye%>" >下一页</a>&nbsp;&nbsp;&nbsp;
    
		
	</th>
</tr>
</table>

</body>
</html>