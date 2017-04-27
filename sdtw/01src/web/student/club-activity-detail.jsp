<%@page import="com.xietong.software.sdtw.db.ClubActivityParticipate"%>
<%@page import="com.xietong.software.sdtw.db.ClubMembers"%>
<%@page import="com.xietong.software.sdtw.db.Academy"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.sdtw.db.ClubActivities"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ page session="true"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*" %> 
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	return ;
}
int id = ParamUtils.getIntParameter(request,"id",-1);
int active = ParamUtils.getIntParameter(request,"active",0);
int page1 = ParamUtils.getIntParameter(request,"page",1);
ClubActivities v = new ClubActivities();
if(id!=-1&&v.getById(id)!=null){
	v = v.getById(id);
}else{
	out.print(HtmlTool.msgBox(request, "访问页面不存在"));
	return ;
}
Map ClubNameMap = CEditConst.getClubNameMap(userInfo);
Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);
Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);
Map YesNoMap = CEditConst.getYesNoMap(userInfo);
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- <link rel="stylesheet" type="text/css" href="../css/linestable.css"> -->
<link rel="stylesheet" type="text/css" href="../css/common-student.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/tablelist.js"></script>
</head>

<body>
<%
String strposition = "社团基本信息";
String strfunction = "社团活动详细信息";
String strhelpwords = "该页面列出了所选社团活动的详细信息。";
%>
<%@ include file="pagetop-positionandhelp.jsp" %>

<table class="command-table">
<tr>
    <td><a href="club-activity-mylist.jsp?active=<%=active %>&page=<%=page1 %>" ><!-- <img src="../images/commandico/back.png"> -->返回</a></td>
</tr>
</table> 

<table class="content-table">
<tr>
<td colspan="4" align="left" class="checkstate">  

    指导单位审核状态：通过
  
  </td>
</tr>
<tr>
	<td align="right" width="18%">&nbsp;社团名称：</td>
	<td align="left" width="32%"><%=ClubNameMap.get(v.getClubName()) %></td>
	<td align="right" width="18%">&nbsp;社团编号：</td>
	<td align="left"><%=v.getClubId() %></td>
</tr>
<tr>
	<td align="right">&nbsp;活动主题：</td>
	<td align="left" colspan="3"><%=v.getActivityName() %></td>	
</tr>
<tr>
<td align="right">&nbsp;组织单位：</td>
	<td align="left"><%=AcademyNameMap.get(v.getOrgacadeMy()) %></td>
	<td align="right">&nbsp;组织者：</td>
	<td align="left" >
	<%String[] uids = Tool.split(",",v.getOrganizer());  
	if(uids.length>0)
		for(int i=0;i<uids.length;i++){%>
			<%=UserCnNameMap.get(uids[i]) %>
		<%}
	%>
	</td>
</tr>
<tr>
	<td align="right" >&nbsp;活动时间：</td>
	<td  colspan="3" align="left"><%=v.getTimeStart() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=v.getTimeEnd() %></td>
</tr>
<tr>
	<td align="right">&nbsp;活动地点：</td>
    <td align="left"><%=v.getActivityPlace() %></td>
	<td align="right">&nbsp;预计参加人数：</td>
	<td align="left"><%=v.getPredictNumber() %></td>
</tr>
<tr>
	<td align="right" >&nbsp;第一负责人：</td>
	<td align="left"><%=UserCnNameMap.get(v.getContacts()) %></td>
	<td align="right">&nbsp;联系电话：</td>
	<td align="left"><%=v.getContactsPhone() %></td>
</tr>
<tr>
	<td align="right">&nbsp;是否校内活动：</td>
	<td align="left"><%=YesNoMap.get(v.getIsatSchool()) %></td>
	<td align="right">&nbsp;是否有赞助：</td>
	<td align="left">
	<%if ("club".equals(v.getModule())) {//社团创建活动%>
	<%=YesNoMap.get(v.getIsSupported())==null?"":YesNoMap.get(v.getIsSupported()) %>
	<%}else{//立项活动%>
		<%=YesNoMap.get(v.getConclusionIsSupport())==null?"":YesNoMap.get(v.getConclusionIsSupport()) %>
	<%} %>
	</td>
</tr>
<tr>
	<td align="right">&nbsp;活动具体内容及<BR/>活动经费使用情况：</td>
    <td align="left" colspan="3"><%=v.getContant() %></td>
</tr>
<tr>
	<td align="right">&nbsp;活动预告：</td>
    <td align="left" colspan="3"><%=v.getForecast() %></td>
</tr>
<tr>
	<td align="right">&nbsp;参加人员名单：</td>
    <td align="left" colspan="3">
    <%
    ClubActivityParticipate cy = new ClubActivityParticipate();
    List cdt = new ArrayList();
    List list = new ArrayList();
    cdt.add("activityid="+id);
    cdt.add("checkflag=1");
    list = cy.query(cdt);
    if(list.size()>0)
    	for(int i=0;i<list.size();i++){
    		cy = (ClubActivityParticipate)list.get(0);
    	%>
    		<%=UserCnNameMap.get(cy.getSname()) %>
    	<%}
    %>
    </td>
</tr>
<tr>
	<td align="right">&nbsp;指导教师意见：</td>
    <td align="left" colspan="3"><%=v.getCommentTeacher() %></td>
</tr>
<tr>
    <td align="right">&nbsp;备注：</td>
    <td align="left" colspan="3"><%=v.getRemark() %></td>
</tr>

<tr><th colspan="4">    <a href="club-activity-mylist.jsp?active=<%=active %>&page=<%=page1 %>" >返回</a></th></tr> 

</table>

</body>
</html>
