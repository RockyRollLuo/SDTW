<%@page import="com.xietong.software.common.COptionConst"%>
<%@page import="com.xietong.software.common.PageControl"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.sdtw.db.Honor"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.NEW"%>
<%@page import="com.xietong.software.sdtw.db.CampusParticipate"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="java.util.Map"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.sdtw.db.CampusActivity"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xietong.software.sdtw.campus.CampusUtil"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page pageEncoding="utf-8" %>
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
String ActivitykindType = ParamUtils.getParameter(request,"ActivitykindType","-1");
String Academy = ParamUtils.getParameter(request,"Academy","-1");
BaseUserCode user = new BaseUserCode();
user = userInfo.getUserCode();
CampusUtil util = new CampusUtil();
List list = new ArrayList();
list = util.getCampusActivity(user,ActivitykindType,request);
Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);
Map TotalRoundsMap = CEditConst.getTotalRoundsMap(userInfo);
List cdt = new ArrayList();
String flag = ParamUtils.getParameter(request,"flag","-1");
//whhd文化活动
if ("whhd".equals(flag)){
cdt.add("id<=4");
}
List ActivitykindTypeOptions = COptionConst.getActivitykindTypeOptions(userInfo,"-1",cdt);
if ("cxkj".equals(flag)) {
	cdt.add("id=5");
	ActivitykindTypeOptions = COptionConst.getActivitykindTypeOptions(userInfo,cdt);	
}
if ("cyjy".equals(flag)) {
	cdt.add("id=6");
	ActivitykindTypeOptions = COptionConst.getActivitykindTypeOptions(userInfo,cdt);	
}
int selectType = ParamUtils.getIntParameter(request,"selectType",0);
cdt.clear();
cdt.add("flag=1");
List  AcademyNameOptions = COptionConst.getAcademyNameOptions(userInfo,"-1",cdt);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" type="text/css" href="../css/common-student.css">
<script src="../js/jquery.min.js"></script> 
<script src="../js/tablelist.js"></script>
<script>
function changeActivityKindType() {
	var ActivitykindType = $('#ActivitykindType').val();
	var selectType = $('#selectType').val();
	var Academy = $('#Academy').val();
	location = "campus-activity-list.jsp?ActivitykindType="+ActivitykindType+"&flag=<%=flag%>&selectType="+selectType+"&Academy="+Academy;
}
function changeorder(){
	//document.formselect.selectedType.value=$("#selectType").find("option:selected").val();
	$('#selectType').val($("#selectType").find("option:selected").val());
	//document.formselect.submit();
	var selectType = $('#selectType').val();
	var ActivitykindType = $('#ActivitykindType').val();
	var Academy = $('#Academy').val();
	location = "campus-activity-list.jsp?ActivitykindType="+ActivitykindType+"&flag=<%=flag%>&selectType="+selectType+"&Academy="+Academy;
}
function changeAcademy() {
	var selectType = $('#selectType').val();
	var ActivitykindType = $('#ActivitykindType').val();
	var Academy = $('#Academy').val();
	location = "campus-activity-list.jsp?ActivitykindType="+ActivitykindType+"&flag=<%=flag%>&selectType="+selectType+"&Academy="+Academy;
}
</script>
</head>

<body>
<%
String strposition = "文化活动>>活动管理>>";
String strfunction = "活动列表";
String strhelpwords = "显示已添加的活动列表。";
%>
<%@ include file="../student/pagetop-positionandhelp.jsp" %>

<table class="content-table">
<tr>
<td>活动类型</td>
<td  align="left">
<%=HtmlTool.renderSelect(ActivitykindTypeOptions,""+ActivitykindType,"ActivitykindType","","onchange=changeActivityKindType()") %>
</td>
<td>选择</td>
<td align="left">
 		<select name="selectType" id="selectType" onchange="changeorder();">
	  		<option value="0">所有</option>
	  		<option value="1">已参加</option>
	  		<option value="2">未参加</option>
  		</select>
  	<script type="text/javascript">$("select[name='selectType']").val("<%=selectType%>");</script>
	</td>
<td>指导单位</td>
<td colspan="6"  align="left">
<%=HtmlTool.renderSelect(AcademyNameOptions,""+Academy,"Academy","","onchange=changeAcademy()") %>
</td>
</tr>
<tr>
	<!-- <th width="5%">序号</th>  -->
	<th width="10%">组织单位</th>  
	<th width="15%">活动名称</th>
	<th>活动类型</th>  
	<th width="9%">报名截止时间</th> 
	<th width="9%">第一轮活动时间</th>
	<th width="12%">第一轮活动地点</th>
	<th width="7%">申请人数</th>
  	<th width="8%">审核通过人数</th>
	<th width="10%">成绩（轮次）</th>
  	<th width="10%">荣誉</th>
  	<th>操作</th>
</tr>
<%
if(list.size()>0){
	Map<String,Object>map = new HashMap<String,Object>();
	map = util.getCampusParticipate(userInfo.getId());
	for(int i=0;i<list.size();i++){
		CampusActivity ca = new CampusActivity();
		ca = (CampusActivity)list.get(i);
		CampusParticipate cp = new CampusParticipate();
		cp = (CampusParticipate)map.get(ca.getId()+"_Sname_"+userInfo.getId())==null?new CampusParticipate():(CampusParticipate)map.get(ca.getId()+"_Sname_"+userInfo.getId());
		%>
		<tr>
		<td>
		<%
		if ("-1".equals(ca.getOrgacadeMy())) {%>
			山东大学团委
		<%} else {%>
			<%=AcademyNameMap.get(ca.getOrgacadeMy()+"") %>
		<%}
		%>
		</td>
		<td><a href='<%=HeadConst.apache_url %>/campus/campus-activity-details.jsp?id=<%=ca.getId()%>&flag=<%=flag%>'><%=ca.getActivityName() %></a></td>
		<td><%=HtmlTool.renderSelect(ActivitykindTypeOptions,""+ca.getActivitykindType(),"","",true) %></td>
		<td><%="".equals(ca.getDeadline())?"":ca.getDeadline() %></td>
		<td><%=ca.getActivityDate1() %></td>
		<td><%=ca.getActivityPlace1() %></td>
		<td><%=map.get(ca.getId()+"_-1")==null?0:map.get(ca.getId()+"_-1") %></td>
		<td><%=map.get(ca.getId()+"_1")==null?0:map.get(ca.getId()+"_1") %></td>
		<td>
		<%
		if(cp.getCheckFlag()>=1){%>
			晋级到第<%=TotalRoundsMap.get(cp.getFinalRounds()+"") %>轮
		<%}
		%>
		</td>
		<td>
		<%
		if(!"".equals(cp.getHonor())){
			Honor h = new Honor();
			h = h.getById(Tool.StrToInt(cp.getHonor()));%>
			<%=h.getHonorName() %>
		<%}
		%>
		</td>
		<td><a href='<%=HeadConst.apache_url %>/campus/campus-activity-details.jsp?id=<%=ca.getId()%>&flag=<%=flag%>'>
		<%
		if(cp.getId()!=-1){%>
			已申请
		<%}else{%>
			申请参加
		<%}
		%>
		</a> </td>
		</tr>
	<%}
	map.clear();
}else{%>
	<tr>
	<td colspan="11">没有记录</td>
	</tr>
<%}
%>
</table>
<%
	PageControl pagecontrol = (PageControl)request.getAttribute("PageControl");
	%>
	<%=pagecontrol.getControl_win8_("campus-activity-list.jsp?cmd=list&ActivitykindType="+ActivitykindType,  HeadConst.apache_url+"/main/images/skin/"+userInfo.getSkinId())%>

</body>
</html>