<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.sdtw.club.ClubUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.xietong.software.sdtw.db.ClubActivityParticipate"%>
<%@page import="com.xietong.software.sdtw.db.ClubActivities"%>
<%@page import="com.xietong.software.sdtw.db.Grade"%>
<%@page import="java.util.Map"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="java.sql.*" %>
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(userInfo == null){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	return;
}
BaseUserCode user = new BaseUserCode();
user = userInfo.getUserCode();
/* Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo); */
Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);
Map GradeNameMap = CEditConst.getGradeNameMap(userInfo);
Map ClubNameMap = CEditConst.getClubNameMap(userInfo);
List YesNoOptions = CEditConst.getYesNoOptions(userInfo);
List TellwayOptions = ClubUtil.getTellwayOptions();


int clubname = ParamUtils.getIntParameter(request,"clubname",-1);
int activityid = ParamUtils.getIntParameter(request,"activityid",-1);
String cmd = ParamUtils.getParameter(request,"cmd","save");

ClubActivities ac = new ClubActivities();
if(activityid!=-1&&ac.getById(activityid)!=null){
	ac = ac.getById(activityid);
}

int capid = ParamUtils.getIntParameter(request,"id",-1);
ClubActivityParticipate cap = new ClubActivityParticipate();


if(capid!=-1&&cap.getById(capid)!=null){
	cap = cap.getById(capid);
}

Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);

String cssLink = "";
if(userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	cssLink="<link href='../css/common-student.css' rel='stylesheet' type='text/css'/>";
}else{
	cssLink="<link href='../css/common.css' rel='stylesheet' type='text/css'/>";
}
    String dis = "";
	String activityprocedure = "";
	String activitysecurity = "";
	String traffictool = "";
    if(cap.getId()!=-1&&cap.getById(capid)!=null){
    	dis = "display:none;";
    	activityprocedure = cap.getActivitysecurity();
    	activitysecurity = cap.getActivitysecurity();
    	traffictool = cap.getTraffictool();
}%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<%=cssLink%>
<script src="../js/jquery.min.js"></script>
<script src="../js/tablelist.js"></script>
<script src="../js/jquery.PrintArea.js" type="text/javascript" ></script>
<script type="text/javascript">
function form1submit(){   
	if (document.form1.traffictool.value==""){
  		alert("交通工具不能为空！");
  		document.form1.traffictool.focus();
    	return false;
 	}
	if (document.form1.activityprocedure.value==""){
  		alert("活动程序介绍不能为空！");
  		document.form1.activityprocedure.focus();
    	return false;
 	}
	if (document.form1.activitysecurity.value==""){
  		alert("安全保障措施不能为空！");
  		document.form1.activitysecurity.focus();
    	return false;
 	}
	
    //提交表单数据,包括disabled的输入域
    var len=document.form1.elements.length;
    var i;
    for (i=0;i<len;i++){
         document.form1.elements[i].disabled = false;
    } 
    document.form1.submit();
    return true;
}

function printthis(){
	if(confirm("确定要打印吗？")){
		$(".demo").printArea();
	}
}
</script>
</head>
<body>
<%
String strposition = "学生社团工作 >> 社团活动管理 >> ";
String strfunction = "校外活动安全监督书";
String strhelpwords = "校外活动安全监督书。";
%>
<%@ include file="pagetop-positionandhelp.jsp" %>

<table class="command-table">
<tr>
    <td>
    <%
    if(cap.getId()!=-1){%>
    	<a href="#" onclick="printthis()"><img src="../images/commandico/print.png"></a>
    <%}
    %>
    	<a href="#" onclick="history.go(-1)"><!-- <img src="../images/commandico/back.png"> -->返回</a>
    </td>
</tr>
</table>

<form name="form1" action="club-activity-save.jsp">
<input type="hidden" id="clubid" name="clubid" value="<%=ac.getClubId()%>"/>
<input type="hidden" id="clubname" name="clubname" value="<%=clubname%>"/>
<input type="hidden" id="activityid" name="activityid" value="<%=activityid%>"/>
<input type="hidden" id="activityname" name="activityname" value="<%=ac.getActivityName()%>"/>
<input type="hidden" id="sno" name="sno" value="<%=user.getName()%>"/>
<input type="hidden" id="sname" name="sname" value="<%=user.getId()%>"/>
<input type="hidden" id="id" name="id" value="<%=cap.getId()%>"/>
<input type="hidden" id="cmd" name="cmd" value="<%=cmd%>"/>
<div class="demo" style="width: 100%">
<table class="content-table" style="width: 100%;">
<tr>
	<td align="right" width="15%">&nbsp;姓名：</td>
    <td align="left" width="35%"><%=UserCnNameMap.get(user.getId()+"") %></td>
    <td  align="right">&nbsp;学院年级：</td>
     <td align="left"><%=AcademyNameMap.get(user.getDeptId()+"") %><%=GradeNameMap.get(user.getGrade()+"") %></td>
</tr>
<tr>
	<td  align="right">&nbsp;学号：</td>
	<td align="left"><%=user.getName() %></td>
	<td align="right" width="15%">&nbsp;所在社团：</td>
    <td align="left"><%=ClubNameMap.get(clubname+"") %></td>
</tr>
<tr>
	<td align="right">&nbsp;活动名称：</td>
    <td align="left"><%=ac.getActivityName() %></td>
    <td  align="right">&nbsp;活动地点：</td>
     <td align="left"><%=ac.getActivityPlace() %></td>
</tr>
<tr>
	<td align="right">&nbsp;活动时间：</td>
    <td align="left"><%=ac.getTimeStart() %>&nbsp;至&nbsp;<%=ac.getTimeEnd() %></td>
	<td align="right">&nbsp;<font color="red">*&nbsp;</font>交通工具：</td>
    <td align="left">
    <%=traffictool %>
    <input type="text" id="traffictool" name="traffictool" size="26" value="<%=cap.getTraffictool()%>" style="<%=dis%>"/></td>
</tr>
<tr>
	<td align="right">&nbsp;联系方式：</td>
    <td align="left"><%=user.getPhone() %></td>
	<td align="right">&nbsp;电子邮箱：</td>
    <td align="left"><%=user.getEmail() %></td>
</tr>
<tr>
	<td align="right">&nbsp;<font color="red">*&nbsp;</font>活动程序介绍：</td>
    <td align="left" colspan="3">
    <%=activityprocedure %>
    <textarea  name="activityprocedure" id="activityprocedure" style="width: 80%;<%=dis %>" rows="3" maxlength="300"><%=cap.getActivityprocedure() %></textarea></td>
</tr>
<tr>
	<td align="right">&nbsp;<font color="red">*&nbsp;</font>安全保障措施：</td>
    <td align="left" colspan="3">
   <%=activitysecurity %>
    <textarea  name="activitysecurity" id="activitysecurity" style="width: 80%;<%=dis %>" rows="3" maxlength="300"><%=cap.getActivitysecurity() %></textarea></td>
</tr>
<tr>
    <td align="right">&nbsp;学生本人意见：</td>
    <td align="left" colspan="3">
    	&nbsp;1、我确认我已经详细了解了本次活动的全部内容，我自愿参加这次由社团自发组织的活动；<br/>
		&nbsp;2、我完全同意本次活动制定的安全保障措施，我一定会严格执行有关安全保障的规定；<br/>
		&nbsp;3、我清楚在活动过程中存在一定的危险性；<br/>
		&nbsp;4、我已经按时参加了所在社团组织的安全教育培训；<br/>
		&nbsp;5、我一定会增强安全防范意识，尽可能的避免一切不必要的损失；<br/>
		&nbsp;6、如万一在活动中发生任何意外情况，我同意责任自负。<br/>
		<span style="margin-left: 50%">学生本人签字：<%=UserCnNameMap.get(cap.getSname()) %></span>
		<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=Tool.stringOfCnDate(cap.getApplytime()) %></span>
    </td>
</tr>
<tr>
    <td align="right" rowspan="7">&nbsp;<font color="red">*&nbsp;</font>告知父母情况：</td>
    <td align="left" colspan="3">
    	&nbsp;1、是否将本次活动的详细情况告知了父母&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<%=HtmlTool.renderRadio(YesNoOptions, cap.getIstell(), "istell", "1")%>
    </td>
</tr>
<tr>
    <td align="left" colspan="3">
    	&nbsp;2、和父母商议是否购买保险&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<%=HtmlTool.renderRadio(YesNoOptions, cap.getIsbuy(), "isbuy", "1")%>
    </td>
</tr>
<tr>
    <td align="left" colspan="3">
    	&nbsp;3、告知父母的方式&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<!-- input type="radio" name="tellway" value="面谈" checked/>面谈&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name="tellway"  value="电话"/>电话&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name="tellway"  value="信件"/>信件 -->
		<%=HtmlTool.renderRadio(TellwayOptions, cap.getTellway(), "tellway", "1")%>
    </td>
</tr>
<tr>
    <td align="left" colspan="3">
    	&nbsp;4、父母是否知道这次活动是自愿参加&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<%=HtmlTool.renderRadio(YesNoOptions, cap.getIswilling(), "iswilling", "1")%>
    </td>
</tr>
<tr>
    <td align="left" colspan="3">
    	&nbsp;5、父母是否知道这次活动是由学生社团自发组织&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<%=HtmlTool.renderRadio(YesNoOptions, cap.getIsvoluntary(), "isvoluntary", "1")%>
    </td>
</tr>
<tr>
    <td align="left" colspan="3">
    	&nbsp;6、如万一在活动中发生任何意外情况，父母是否同意责任自负&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<%=HtmlTool.renderRadio(YesNoOptions, cap.getIsresponsible(), "isresponsible", "1")%>
    </td>
</tr>
<tr>
    <td align="left" colspan="3">
    	&nbsp;我郑重承诺，我已将以上内容详细告知了我的父母并征得了他们的同意。<br/>
  		<span style="margin-left: 50%;">学生本人签字：<%=UserCnNameMap.get(cap.getSname()) %></span>
		<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=Tool.stringOfCnDate(cap.getApplytime()) %></span>
    </td>
</tr>
<tr>
    <td align="right" rowspan="3">&nbsp;购买保险情况：</td>
    <td align="left" colspan="3">
    	&nbsp;我将于&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日之前购买保险。如不能按时购买保险，如在活动中发生任何意外情况，我同意责任自负。<br/>
  		<span style="margin-left: 50%;">学生本人签字：<%=UserCnNameMap.get(cap.getSname()) %></span>
		<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=Tool.stringOfCnDate(cap.getApplytime()) %></span>
    </td>
</tr>
<tr>
    <td align="left" colspan="3">
    	&nbsp;如不购买保险请说明原因：  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </td>
</tr>
<tr>
    <td align="left" colspan="3">
    	&nbsp;我郑重承诺，我和我的父母商议不购买保险。如在活动中发生任何意外情况，责任自负。[注：如不购买保险，请签署本承诺]<br/>
  		<span style="margin-left: 50%;">学生本人签字：</span>
		<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=Tool.stringOfCnDate(cap.getApplytime()) %></span>
    </td>
</tr>
<tr>
    <td align="left" colspan="4">
我确认&nbsp;<%=user.getCnName() %>&nbsp;同学是在我协会正式注册的社团成员，我确认该同学的签字是其亲笔签字，学号、学院、年级、是否购买保险等第一页需填写的各项内容核实无误。如有失实，我愿意承担全部责任。<br/>
  		<span style="margin-left: 50%;">学生社团负责人签字：</span>
		<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日</span>
    </td>
</tr>
<tr>
    <td align="left" colspan="4">
我确认&nbsp;&nbsp;&nbsp;社团负责人&nbsp;&nbsp;&nbsp;同学的签字是其亲笔签字。如有错误，我愿意承担全部责任。<br/>
  		<span style="margin-left: 55%;">学生社团联合会主席签字：</span>
		<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日</span>
    </td>
</tr>
<tr height="70px">
    <td align="right">&nbsp;指导教师意见：</td>
    <td align="left" colspan="3">&nbsp;
    	<br/><br/><br/>
  		<span style="margin-left: 50%;">签字/盖章：</span>
		<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日</span>
    </td>
</tr>
<tr height="70px">
    <td align="right">&nbsp;辅导员意见：</td>
    <td align="left" colspan="3">&nbsp;
    	<br/><br/><br/>
  		<span style="margin-left: 50%;">签字/盖章：</span>
		<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日</span>
    </td>
</tr>
<tr height="70px">
    <td align="right">&nbsp;指导单位意见：</td>
    <td align="left" colspan="3">&nbsp;
    	<br/><br/><br/>
  		<span style="margin-left: 50%;">签字/盖章：</span>
		<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日</span>
    </td>
</tr>
<tr height="70px">
    <td align="right">&nbsp;社团部意见：</td>
    <td align="left" colspan="3">&nbsp;
    	<br/><br/><br/>
  		<span style="margin-left: 50%;">签字/盖章：</span>
		<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日</span>
    </td>
</tr>
<%
if(capid==-1&&"save".equals(cmd)){%>
<tr>   
	 <th colspan="4">
        <input type="button" value="确定提交（不可修改）" name="btn1" onclick="form1submit()" class="button">&nbsp;&nbsp;&nbsp;
        <input type="button" value="取消提交" name="btn2" onclick="history.go(-1)" class="button">&nbsp;&nbsp;&nbsp;
    </th>
</tr>
<%}
%>
</table>
</div>
</form>
</body>
</html>
