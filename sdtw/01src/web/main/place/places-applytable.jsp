<%@ page contentType="text/html;charset=utf-8" %>
<%@ page language="java"%>
<%@ page import="java.*"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/common.css" rel="stylesheet" type="text/css"/>
<script src="../js/tablelist.js"></script>                 
<script src="../js/jquery.min.js"></script>
<script type="text/javascript">
function form1datacheck(){   
	if (document.form1.Applicant.value=="")
	{
    	alert("使用单位不能为空！");
    	document.form1.Applicant.focus();
    	return false;
  	}
	if (document.form1.ActivityPrincipal.value=="")
	{
        alert("活动负责人不能为空！");
        document.form1.ActivityPrincipal.focus();
    	return false;
  	}
  	if (document.form1.PrincipalPhone.value=="")
	{
        alert("活动负责人联系电话不能为空！");
        document.form1.PrincipalPhone.focus();
    	return false;
  	}
  	if (document.form1.ActivityTime.value=="")
	{
        alert("活动时间不能为空！");
        document.form1.ActivityTime.focus();
    	return false;
  	}
  	if (document.form1.DistributionPeriod.value=="")
	{
        alert("布场时段不能为空！");
        document.form1.DistributionPeriod.focus();
    	return false;
  	}
  	if (document.form1.RehearsalPeriod.value=="")
	{
        alert("彩排时段不能为空！");
        document.form1.RehearsalPeriod.focus();
    	return false;
  	}
  	if (document.form1.ActivityContents.value=="")
	{
        alert("活动内容不能为空！");
        document.form1.ActivityContents.focus();
    	return false;
  	}
  	if (document.form1.Promiser.value=="")
	{
        alert("承诺人不能为空！");
        document.form1.Promiser.focus();
    	return false;
  	}
  	if (document.form1.PromiserPhone.value=="")
	{
        alert("承诺人联系电话不能为空！");
        document.form1.PromiserPhone.focus();
    	return false;
  	}
  	return true;
}

function form1submit()
{
	if(!form1datacheck())
	{ 
		return false;
	}
	document.form1.submit();
}

function form1cancel()
{
	document.form1.reset();
	document.getElementsByTagName('body')[0].scrollTop = 0; //页面滚回顶部
}
</script>
</head>
<% 

	
// 	System.out.println(count);
// 	System.out.println(applydatastr);
	

%>
<body>
<%
String strposition = "场地管理>>场地申请>>";
String strfunction = "场地申请表";
String strhelpwords = "查看场地的分配情况";
String applydata= ParamUtils.getParameter(request, "applydata", "");
System.out.println(applydata);
UserInfo userinfo=Tool.getUserInfo(request);
String [] sapplydata=Tool.split(",,",applydata);
if(userinfo==null){
	return;
}
BaseUserCode stu= userinfo.getUserCode();

%>
<%-- <%@ include file="../pubpro/pagetop-positionandhelp.jsp" %>
 --%>
<table class="command-table">
<tr>
	<td>
	   <a href="places-application-list.jsp"><img src="../images/commandico/back.png"/></a> 
	</td>
</tr>
</table>

<form name="form1" method="post" action="Places_ApplytableAction.jsp?cmd=save">


<input type="hidden" name="applydatastr" value="<%=applydata%>">
<input type="hidden" name="UserAccount" value="<%=stu.getId()%>">

<table class="content-table">
<tr>
	<th colspan="5" align="left">场地申请使用表</th>
</tr>
<tr>
	<td width="15%"><span style="color:red">*</span>使用单位</td>
	<td width="35%" align="left"><input type="text" name="Applicant" size="30" value="" placeholder="输入申请场地的单位"></td>
	<td width="15%"><span style="color:red">*</span>活动负责人</td>
	<td align="left"><input type="text" name="ActivityPrincipal" size="30" value="" placeholder="输入该活动的负责人"></td>
</tr>
<tr>
	<td>活动负责人职务</td>
	<td align="left"><input type="text" name="PrincipalDuty" size="30" value=""></td>
	<td><span style="color:red">*</span>活动负责人联系电话</td>
	<td align="left"><input type="text" name="PrincipalPhone" size="30" value=""></td>
</tr>
<tr>
	<td>拟用场地</td>
	<td align="left">
<%
for(int m=0;m<sapplydata.length;m++){

%>
	 <span><%=sapplydata[m].replace(',', ' ') %></span><br/>
<%} %>
	</td>
	<td><span style="color:red">*</span>活动时间</td>
	<td align="left"><input type="text" name="ActivityTime" size="30" value=""></td>
</tr>
<tr>
	<td><span style="color:red">*</span>布场时段</td>
	<td align="left"><input type="text" name="DistributionPeriod" size="30" value=""></td>
	<td><span style="color:red">*</span>彩排时段</td>
	<td align="left"><input type="text" name="RehearsalPeriod" size="30" value=""></td>
</tr>
<tr>
	<td><span style="color:red">*</span>活动内容</td>
	<td align="left"><input type="text" name="ActivityContents" size="30" value=""></td>
	<td>主讲人</td>
	<td align="left" colspan="2"><input type="text" name="Speaker" size="30" value=""></td>
</tr>
<tr>
	<td>基本程序</td>
	<td align="left" colspan="3"><textarea name="BasicProcedures"  style="width:82%" rows="4" ></textarea></td>
</tr>
<tr>
	<td colspan="4">会场布置</td>
</tr>
<tr>
	<td>会标内容</td>
	<td align="left"><input type="text" name="MeetingMarks" size="30" value=""></td>
	<td>背景内容</td>
	<td align="left"><input type="text" name="BackgroundContents" size="30" value=""></td>
</tr>
<tr>
	<td>商业赞助</td>
	<td align="left"><input type="text" name="Aponsorship" size="30" value=""></td>
	<td>宣传形式</td>
	<td align="left"><input type="text" name="Propaganda" size="30" value=""></td>
</tr>
<tr>
	<td>会场内其他宣传形式</td>
	<td align="left" colspan="3"><textarea  name="OtherPropaganda" style="width:82%" rows="4" ></textarea></td>
</tr>
<tr>
	<td colspan="4">会场设施使用说明</td>
</tr>
<tr>
	<td>桌子数量</td>
	<td align="left"><input type="number" name="TableNums" size="15" value="" placeholder="0">&nbsp;张</td>
	<td>椅子数量</td>
	<td align="left"><input type="number" name="ChairNums" size="15" value="" placeholder="0">&nbsp;把</td>
</tr>
<tr>
	<td>有线话筒</td>
	<td align="left"><input type="number" name="WiredmicroPhoneNums" size="15" value="" placeholder="0">&nbsp;只</td>
	<td>无线话筒</td>
	<td align="left"><input type="number" name="WirelessmicroPhoneNums" size="15" value="" placeholder="0">&nbsp;只</td>
</tr>
<tr>
	<td>话筒电池</td>
	<td align="left"><input type="number" name="BatteryNums" size="15" value="" placeholder="0">&nbsp;块</td>
	<td>使用发言台</td>
	<td align="left">
		<input type="radio" name="UseFloor" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseFloor" value="0"  checked ="checked"/>否
    </td>
</tr>
<tr>
	<td>使用音响设备</td>
	<td align="left">
		<input type="radio" name="UseAudio" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseAudio" value="0" checked ="checked"/>否
    </td>
    <td>使用照明灯光</td>
	<td align="left">
		<input type="radio" name="UseLighting" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseLighting" value="0" checked ="checked"/>否
    </td>
</tr>
<tr>
	<td>使用舞台灯光</td>
	<td align="left">
		<input type="radio" name="UseStageLight" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseStageLight" value="0" checked ="checked"/>否
    </td>
    <td>使用电脑灯</td>
	<td align="left">
		<input type="radio" name="UseComputerLight" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseComputerLight" value="0" checked ="checked"/>否
    </td>
</tr>
<tr>
	<td>使用投影仪</td>
	<td align="left">
		<input type="radio" name="UseProjector" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseProjector" value="0" checked ="checked"/>否
    </td>
    <td>使用空调</td>
	<td align="left">
		<input type="radio" name="UseAc" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseAc" value="0" checked ="checked"/>否
    </td>
</tr>
<tr>
	<td colspan="4">会场外布置</td>
</tr>
<tr>
	<td>悬挂横幅</td>
	<td align="left">
		<input type="radio" name="UseBanner" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseBanner" value="0" checked ="checked"/>否
    </td>
    <td>横幅内容</td>
	<td align="left"><input type="text" name="BannerContent"" size="30" value=""></td>
</tr>
<tr>
	<td>张贴海报或展板</td>
	<td align="left">
		<input type="radio" name="UsePoster" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UsePoster" value="0" checked ="checked"/>否
    </td>
    <td>参加人员车辆数量</td>
	<td align="left"><input type="number" name="VehicleNums" size="15" value="" placeholder="0">&nbsp;辆</td>
</tr>
<tr>
	<td>海报内容</td>
	<td align="left" colspan="3"><textarea  name="PosterContent"  style="width:82%" rows="4"></textarea></td>
</tr>

<tr>
	<td>承办活动的负责人承诺</td>
	<td align="left" colspan="3">
		<p>
			1.严格遵循场馆使用的相关说明，爱护场馆物品、设备等；<br/><br/>
			2.如遇校团委活动冲突，服从校团委统一调度；<br/><br/>
			3.活动时间、地点均可按照校团委要求临时调度；<br/><br/>
			4.如有任何违规内容，承担相关责任，同意接受相关处罚。<br/><br/>
		</p>
	</td>
</tr>
<tr>	
	<td><span style="color:red">*</span>承诺人</td>
	<td align="left"><input type="text" name="Promiser" size="30" value=""></td>
	<td><span style="color:red">*</span>联系电话</td>
	<td align="left"><input type="text" name="PromiserPhone" size="30" value=""></td>
</tr>
<tr>	
	<td>学院</td>
	<td align="left"><input type="text" name="PromiserAcadeMy" size="30" value=""></td>
	<td>班级</td>
	<td align="left"><input type="text" name="PromiserClass" size="30" value=""></td>
</tr>
<tr>	
	<td>指导老师</td>
	<td align="left"><input type="text" name="Tutor" size="30" value=""></td>
	<td>指导老师职务</td>
	<td align="left"><input type="text" name="TutorDuty" size="30" value=""></td>
</tr>
<tr>	
	<td>指导老师联系方式</td>
	<td align="left" colspan="3"><input type="text" name="TutorPhone" size="30" value=""></td>
</tr>
<tr>	
	<td>备注</td>
	<td align="left" colspan="3"><input type="text" name="Remarks" size="30" value=""></td>
</tr>
<input type="hidden" name="Status" value="0"/>

<tr>
 	<th colspan="4">
		<input type="button" class="button" value="提交" name="btn1" onclick="form1submit()">&nbsp;&nbsp;&nbsp;
    	<input type="button" class="button" value="取消" name="btn2" onclick="form1cancel()">
	</th>
</tr>
</table>
</form>
</body>
</html>