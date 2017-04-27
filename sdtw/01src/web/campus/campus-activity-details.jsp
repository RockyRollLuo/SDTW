<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.mysql.jdbc.Util"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xietong.software.sdtw.db.Honor"%>
<%@page import="com.xietong.software.sdtw.campus.CampusUtil"%>
<%@page import="java.util.Map"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.sdtw.db.CampusActivity"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page contentType="text/html;charset=utf-8" %>
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
int id = ParamUtils.getIntParameter(request,"id",-1);
String flag = ParamUtils.getParameter(request,"flag","whhd");
CampusActivity ca = new CampusActivity();
if(id!=-1&&ca.getById(id)!=null){
	ca = ca.getById(id);
}
Map ActivitykindTypeMap = CEditConst.getActivitykindTypeMap(userInfo);
Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);
Map ActivityLevelMap = CEditConst.getActivityLevelMap(userInfo);
Map TotalRoundsMap = CEditConst.getTotalRoundsMap(userInfo);
Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);
Map OrgNameMap = CEditConst.getOrgCityNameMap(userInfo);
CampusUtil util = new CampusUtil();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="../js/tablelist.js"></script>
<script src="../js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/common-student.css">
<script type="text/javascript">
function submitthis(){

	$.ajax({
			type : "post",
			///sdfz/01src/web
			url : "campus-activity-save.jsp",
			data : {
				cmd : 'baomingForm',
				CampusActivityId : <%=id%>
			},
			dataType : "json",
			cache : false,
			success : function(data) {
				if(data.msg=="ok") {
					$('#btn1').hide();
					alert("报名成功！");
				}
				if(data.msg=="exist"){
					$('#btn1').hide();
					alert("已报名，请勿重复提交！");
				}
				if(data.msg=="error") {
					alert("报名失败，请重试！");
				}
				return;
			},
			error : function() {
				// view("异常！"); 
				alert("异常！");
			}
		});

	}
	function fanhui() {
		location = "campus-activity-list.jsp?flag=<%=flag%>";
	}
</script>
</head>
<body>
<%
String strposition = "校园文化活动  >> 活动项目管理 >> ";
String strfunction = "活动详细信息";
String strhelpwords= "该列表列出了活动的详细信息。";
%>
<%@ include file="../student/pagetop-positionandhelp.jsp" %>

<table class="command-table">
<tr>
    <td>
       <a href="#" onclick="fanhui()"><!-- <img src="../images/commandico/back.png"/> -->返回</a> 
    </td>
</tr>
</table>

<table class="content-table">
<tr>
	<th colspan="4" align="left">校园文化活动详细信息</th>
</tr>
<tr>
   	<td width="15%" align="right">&nbsp;活动名称：</td>
   	<td width="35%" align="left"><%=ca.getActivityName()%></td>
   	<td width="15%" align="right">&nbsp;活动类别：</td>
   	<td width="35%" align="left"><%=ActivitykindTypeMap.get(ca.getActivitykindType())%></td>
</tr>
<tr>
   	<td align="right">活动组织单位：</td>
   	<td align="left">
   	<%
   	if ("-1".equals(ca.getOrgacadeMy())) {%>
   		山东大学团委
   	<%} else {%>
   		<%=AcademyNameMap.get(ca.getOrgacadeMy())%>
   	<%}
   	%>
   	</td>
	<td align="right">活动级别：</td>
   	<td align="left"><%=ActivityLevelMap.get(ca.getActivityLevel())%></td>
</tr>
<tr>
	<td align="right">活动轮次</td>
   	<td align="left" colspan="3"><%=TotalRoundsMap.get(ca.getTotalRounds())%>轮</td>
</tr>
<tr>
 	<td align="right">第一轮活动日期：</td>
   	<td align="left"><%=ca.getActivityDate1()%></td>
   	<td align="right">第一轮活动地点：</td>
   	<td align="left"><%=ca.getActivityPlace1()%></td>
</tr>
<tr>
 	<td align="right">第二轮活动日期：</td>
   	<td align="left"><%=ca.getActivityDate2()%></td>
   	<td align="right">第二轮活动地点：</td>
   	<td align="left"><%=ca.getActivityPlace2()%></td>
</tr>
<tr>
 	<td align="right">第三轮活动日期：</td>
   	<td align="left"><%=ca.getActivityDate3()%></td>
   	<td align="right">第三轮活动地点：</td>
   	<td align="left"><%=ca.getActivityPlace3()%></td>
</tr>
<tr>
   	<td align="right">报名截止日期：</td>
   	<td align="left"><%=ca.getDeadline()%></td>
   	<td align="right">所需人数：</td>
   	<td align="left"><%="-1".equals(ca.getPersonNumber())?"不限":ca.getPersonNumber()%></td>
</tr>
<tr>
   	<td align="right">负责人：</td>
   	<td align="left"><%=UserCnNameMap.get(ca.getActivityPrincipal())==null?ca.getActivityPrincipal():UserCnNameMap.get(ca.getActivityPrincipal())%></td>
   	<td align="right">联系方式：</td>
   	<td align="left"><%=ca.getContact()%></td>
</tr>
<tr>
   	<td align="right">荣誉设置：</td>
   	<td colspan="3" align="left">
	<%
	List honorlist = util.getHonorList(SdtwConst.HonorType_XYWH,id);
	if(honorlist.size()>0){
		for(int i=0;i<honorlist.size();i++) {
			Honor h = new Honor();
			h = (Honor)honorlist.get(i);%>
			名称：<%=h.getHonorName() %>
			数量：<%=h.getIsEnable() %>
			<br/>
		<%}
	}
	%>
   	</td>
</tr>
<tr>
   	<td align="right">&nbsp;<font color="red">&nbsp;</font>详细介绍：</td>
   	<td colspan="3" align="left"><%=ca.getActivityExplain()%></td>
</tr>
<tr>
	<td align="right">&nbsp;参与城市：</td>
   	<td align="left" colspan="3">
   	<%
   	String campus[] = ca.getCampus().split(",");
   	for(int i=0;i<campus.length;i++){%>
   		<%=OrgNameMap.get(campus[i]) %>&nbsp;&nbsp;
   	<%}
   	%>
   	
   	</td>
</tr>
<tr>
   	<td align="right">&nbsp;申请范围：</td>
   	<td align="left" colspan="3">
   	<%
   	String ApplicationRange = ca.getApplicationRange();
   	if("1".equals(ApplicationRange)) {
   		String Academy[] = ca.getAcademy().split(",");
   		for(int i=0;i<Academy.length;i++){%>
   			<%=AcademyNameMap.get(Academy[i]) %>&nbsp;&nbsp;
   		<%}
   	%>
   	<%}else{%>
   		所有人
   	<%}
   	%>
	</td>
</tr>
<tr>
	<th colspan="6" align="center">
		<%
		
		int num = util.checkBm(id,userInfo.getId());
		if(num==0){%>
			<input class="button" type="button" value="报名" id="btn1" name="btn1" onclick="submitthis();">&nbsp;&nbsp;&nbsp;
		<%}else{%>
			已申请
		<%}
		%>
		<input class="button" type="button" value="返回列表" name="btn2" onclick="fanhui()">&nbsp;&nbsp;&nbsp;
	</th>
</tr>
</table>

</body>
</html>
