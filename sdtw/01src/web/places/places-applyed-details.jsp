<%@ page contentType="text/html;charset=utf-8" %>
<%@ page language="java"%>
<%@ page import="java.*"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@page import="com.xietong.software.base.Power"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/common-student.css" rel="stylesheet" type="text/css"/>
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
</script>
</head>
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
int  id=ParamUtils.getIntParameter(request, "Id", -1);
Places_Applytable pat= new Places_Applytable();
pat= pat.getById(id);
String placeapplycode=pat.getPlaceApplycode(); 
String placename=pat.getPlaceApplycode();
String applicant = pat.getApplicant();
String activityprincipal =pat.getActivityPrincipal();
String principalduty =pat.getPrincipalDuty();
String principalphone =pat.getPrincipalPhone();
String activitytime =Tool.stringOfDate(pat.getActivityTime());
String distributionperiod = pat.getDistributionPeriod();
String rehearsalperiod =pat.getRehearsalPeriod();
String activitycontents = pat.getActivityContents();
String speaker = pat.getSpeaker();

String basicprocedures = pat.getBasicProcedures();
String meetingmarks =pat.getMeetingMarks();
String backgroundcontents = pat.getBackgroundContents();
String sponsorship="";
String propaganda =pat.getPropaganda();
String otherpropaganda = pat.getOtherPropaganda();
int  tablenums =pat.getTableNums()==-1?0:pat.getTableNums();
int  chairnums =pat.getChairNums()==-1?0:pat.getChairNums();
int  wiredmicrophonenums =pat.getWiredmicroPhoneNums()==-1?0:pat.getWiredmicroPhoneNums();
int  wirelessmicrophonenums =pat.getWirelessmicroPhoneNums()==-1?0:pat.getWirelessmicroPhoneNums();

int  batterynums =pat.getBatteryNums()==-1?0:pat.getBatteryNums();
int usefloor =pat.getUseFloor()==-1?0:pat.getUseFloor();
int useaudio =pat.getUseAudio()==-1?0:pat.getUseAudio();
int uselighting =pat.getUseLighting()==-1?0:pat.getUseLighting();
int usestagelight =pat.getUseStageLight()==-1?0:pat.getUseStageLight();
int usecomputerlight =pat.getUseComputerLight()==-1?0:pat.getUseComputerLight();
int useprojector =pat.getUseProjector()==-1?0:pat.getUseProjector();
int useac =pat.getUseAc()==-1?0:pat.getUseAc();
int usebanner =pat.getUseBanner()==-1?0:pat.getUseBanner();
String bannercontent = pat.getBannerContent();

String  useposter =pat.getUsePoster();;
String postercontent = pat.getPosterContent();
String vehiclenums =pat.getVehicleNums();
String promiser = pat.getPromiser();
String promiserphone = pat.getPromiserPhone();
String promiseracademy = pat.getPromiserAcadeMy();
String promiserclass = pat.getPromiserClass();
String tutor = pat.getTutor();
String tutorduty = pat.getTutorDuty();
String tutorphone = pat.getTutorPhone();
// int tutoragree =rs.getInt("tutoragree");
// int guideunitagree =rs.getInt("guideunitagree");
// int tuanweiagree =rs.getInt("tuanweiagree");
String remarks = "";;



%>
<body >
<% 
String strposition = "场地管理 >> 申请状态查询>> ";
String strfunction = "申请场地活动详情";
String strhelpwords = "申请场地活动详情。";
%>
<table class="command-table">
<tr>
	<td>
	   <a href="#" onclick="history.go(-1);"><img src="../images/commandico/back.png"></a>
	</td>
</tr>
</table>

<form name="form1" method="post" action="Places_ApplytableAction.jsp?cmd=update">
<input type="hidden" name=placeapplycode value="<%=placeapplycode%>">
<input type="hidden" name="Id" value="<%=id%>">
<table class="content-table">
<tr>
	<th colspan="5" align="left">场地申请使用表</th>
</tr>
<tr>
	<td width="15%">使用单位</td>
	<td width="35%" align="left"><input type="text" name="Applicant" size="30" value="<%=applicant%>" readonly="readonly">此项不可修改</td>
	<td width="15%">活动负责人</td>
	<td align="left"><input type="text" name="ActivityPrincipal" size="30" value="<%=activityprincipal%>"></td>
</tr>
<tr>
	<td>活动负责人职务</td>
	<td align="left"><input type="text" name="PrincipalDuty" size="30" value="<%=principalduty%>"></td>
	<td>活动负责人联系电话</td>
	<td align="left"><input type="text" name="PrincipalPhone" size="30" value="<%=principalphone%>"></td>
</tr>
<tr>
	<td>拟用场地</td>
	<td align="left"><%=placename%></td>
	<td>活动时间</td>
	<td align="left"><input type="text" name="ActivityTime" size="30" value="<%=activitytime%>"></td>
</tr>
<tr>
	<td>布场时段</td>
	<td align="left"><input type="text" name="DistributionPeriod" size="30" value="<%=distributionperiod%>"></td>
	<td>彩排时段</td>
	<td align="left"><input type="text" name="RehearsalPeriod" size="30" value="<%=rehearsalperiod%>"></td>
</tr>
<tr>
	<td>活动内容</td>
	<td align="left"><input type="text" name="ActivityContents" size="30" value="<%=activitycontents%>"></td>
	<td>主讲人</td>
	<td align="left" colspan="2"><input type="text" name="Speaker" size="30" value="<%=speaker%>"></td>
</tr>
<tr>
	<td>基本程序</td>
	<td align="left" colspan="3"><textarea name="BasicProcedures"  style="width:82%" rows="4" ><%=basicprocedures%></textarea></td>
</tr>
<tr>
	<td colspan="4">会场布置</td>
</tr>
<tr>
	<td>会标内容</td>
	<td align="left"><input type="text" name="MeetingMarks" size="30" value="<%=meetingmarks%>"></td>
	<td>背景内容</td>
	<td align="left"><input type="text" name="BackgroundContents" size="30" value="<%=backgroundcontents%>"></td>
</tr>
<tr>
	<td>商业赞助</td>
	<td align="left"><input type="text" name="Aponsorship" size="30" value="<%=sponsorship%>"></td>
	<td>宣传形式</td>
	<td align="left"><input type="text" name="Propaganda" size="30" value="<%=propaganda%>"></td>
</tr>
<tr>
	<td>会场内其他宣传形式</td>
	<td align="left" colspan="3"><textarea  name="OtherPropaganda" style="width:82%" rows="4" ><%=otherpropaganda %></textarea></td>
</tr>
<tr>
	<td colspan="4">会场设施使用说明</td>
</tr>
<tr>
	<td>桌子数量</td>
	<td align="left"><input type="number" name="TableNums" size="15" value="<%=tablenums%>">&nbsp;张</td>
	<td>椅子数量</td>
	<td align="left"><input type="number" name="ChairNums" size="15" value="<%=chairnums%>" >&nbsp;把</td>
</tr>
<tr>
	<td>有线话筒</td>
	<td align="left"><input type="number" name="WiredmicroPhoneNums" size="15" value="<%=wiredmicrophonenums%>" >&nbsp;只</td>
	<td>无线话筒</td>
	<td align="left"><input type="number" name="WirelessmicroPhoneNums" size="15" value="<%=wirelessmicrophonenums%>" >&nbsp;只</td>
</tr>
<tr>
	<td>话筒电池</td>
	<td align="left"><input type="number" name="BatteryNums" size="15" value="<%=batterynums%>" >&nbsp;块</td>
	<td>使用发言台</td>
	<td align="left">
	<%	
		if(usefloor==0){
	 %>
		<input type="radio" name="UseFloor" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseFloor" value="0"  checked ="checked"/>否
	<% 
		}else{
	%>      	
		<input type="radio" name="UseFloor" value="1"  checked ="checked"/>是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseFloor" value="0" />否
	<%
		}
	 %>
    </td>
</tr>
<tr>
	<td>使用音响设备</td>
	<td align="left">
	<%	
		if(useaudio==0){
	 %>
		<input type="radio" name="UseAudio" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseAudio" value="0"  checked ="checked"/>否
	<% 
		}else{
	%>      	
		<input type="radio" name="UseAudio" value="1"  checked ="checked"/>是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseAudio" value="0" />否
	<%
		}
	 %>
    </td>
    <td>使用照明灯光</td>
	<td align="left">
	<%	
		if(uselighting==0){
	 %>
		<input type="radio" name="UseLighting" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseLighting" value="0"  checked ="checked"/>否
	<% 
		}else{
	%>      	
		<input type="radio" name="UseLighting" value="1"  checked ="checked"/>是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseLighting" value="0" />否
	<%
		}
	 %>
    </td>
</tr>
<tr>
	<td>使用舞台灯光</td>
	<td align="left">
	<%	
		if(usestagelight==0){
	 %>
		<input type="radio" name="UseStageLight" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseStageLight" value="0"  checked ="checked"/>否
	<% 
		}else{
	%>      	
		<input type="radio" name="UseStageLight" value="1"  checked ="checked"/>是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseStageLight" value="0" />否
	<%
		}
	 %>
    </td>
    <td>使用电脑灯</td>
	<td align="left">
	<%	
		if(usecomputerlight==0){
	 %>
		<input type="radio" name="UseComputerLight" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseComputerLight" value="0"  checked ="checked"/>否
	<% 
		}else{
	%>      	
		<input type="radio" name="UseComputerLight" value="1"  checked ="checked"/>是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseComputerLight" value="0" />否
	<%
		}
	 %>
    </td>
</tr>
<tr>
	<td>使用投影仪</td>
	<td align="left">
	<%	
		if(useprojector==0){
	 %>
		<input type="radio" name="UseProjector" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseProjector" value="0"  checked ="checked"/>否
	<% 
		}else{
	%>      	
		<input type="radio" name="UseProjector" value="1"  checked ="checked"/>是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseProjector" value="0" />否
	<%
		}
	 %>
    </td>
    <td>使用空调</td>
	<td align="left">
	<%	
		if(useac==0){
	 %>
		<input type="radio" name="UseAc" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseAc" value="0"  checked ="checked"/>否
	<% 
		}else{
	%>      	
		<input type="radio" name="UseAc" value="1"  checked ="checked"/>是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseAc" value="0" />否
	<%
		}
	 %>
    </td>
</tr>
<tr>
	<td colspan="4">会场外布置</td>
</tr>
<tr>
	<td>悬挂横幅</td>
	<td align="left">
	<%	
		if(usebanner==0){
	 %>
		<input type="radio" name="UseBanner" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseBanner" value="0"  checked ="checked"/>否
	<% 
		}else{
	%>      	
		<input type="radio" name="UseBanner" value="1"  checked ="checked"/>是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UseBanner" value="0" />否
	<%
		}
	 %>
    </td>
    <td>横幅内容</td>
	<td align="left"><input type="text" name="BannerContent" size="30" value="<%=bannercontent%>"></td>
</tr>
<tr>
	<td>张贴海报或展板</td>
	<td align="left">
	<%	
		if(useposter.equals("0")){
	 %>
		<input type="radio" name="UsePoster" value="1" />是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UsePoster" value="0"  checked ="checked"/>否
	<% 
		}else{
	%>      	
		<input type="radio" name="UsePoster" value="1"  checked ="checked"/>是&nbsp;&nbsp;&nbsp;&nbsp;
      	<input type="radio" name="UsePoster" value="0" />否
	<%
		}
	 %>
    </td>
    <td>参加人员车辆数量</td>
	<td align="left"><input type="number" name="VehicleNums" size="15" value="<%=vehiclenums%>" placeholder="0">&nbsp;辆</td>
</tr>
<tr>
	<td>海报内容</td>
	<td align="left" colspan="3"><textarea  name="PosterContent"  style="width:82%" rows="4"><%=postercontent%></textarea></td>
</tr>

<tr>
	<td>承办活动的社团负责人承诺（注：此项须在社联办公室当场填写，否则不予受理）</td>
	<td align="left" colspan="3">
		<p>
			1.严格遵循场馆使用的相关说明，爱护场馆物品、设备等；<br/><br/>
			2.如遇校团委活动冲突，服从校团委统一调度；<br/><br/>
			3.活动时间、地点均可按照校团委要求临时调度；<br/><br/>
			4.社团活动内容均符合学校社团管理的相关规定；<br/><br/>
			5.如有任何违规内容，我本人以及我所负责的社团资源承担相关责任，同意接受相关处罚。<br/><br/>
		</p>
	</td>
</tr>
<tr>	
	<td>承诺人</td>
	<td align="left"><input type="text" name="Promiser" size="30" value="<%=promiser%>" readonly="readonly">此项不可修改</td>
	<td>联系电话</td>
	<td align="left"><input type="text" name="PromiserPhone" size="30" value="<%=promiserphone%>"></td>
</tr>
<tr>	
	<td>学院</td>
	<td align="left"><input type="text" name="PromiserAcadeMy" size="30" value="<%=promiseracademy%>" readonly="readonly">此项不可修改</td>
	<td>班级</td>
	<td align="left"><input type="text" name="PromiserClass" size="30" value="<%=promiserclass%>"></td>
</tr>
<tr>	
	<td>指导老师</td>
	<td align="left"><input type="text" name="Tutor" size="30" value="<%=tutor%>"></td>
	<td>指导老师职务</td>
	<td align="left"><input type="text" name="TutorDuty" size="30" value="<%=tutorduty%>"></td>
</tr>
<tr>	
	<td>指导老师联系方式</td>
	<td align="left" colspan="3"><input type="text" name="TutorPhone" size="30" value="<%=tutorphone%>"></td>
</tr>
<tr>	
	<td>备注</td>
	<td align="left" colspan="3"><input type="text" name="Remarks" size="30" value="<%=remarks%>"></td>
</tr>


</table>


</body>
</html>