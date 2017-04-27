<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="com.xietong.software.sdtw.db.ClientAttach"%>
<%@page import="com.xietong.software.sdtw.db.PracticeDeclareTeam"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.sdtw.db.PracticeDeclareTeammember"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.sdtw.db.PracticeReport"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.sdtw.pratice.PracticeUtil"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*"%>
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
PracticeUtil util = new PracticeUtil();
Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);
List TermTypeOptions = util.getTermTypeOptions();
List PracticeThemeOptions1 = util.getPracticeThemeOptions1();
List PracticeThemeOptions2 = util.getPracticeThemeOptions2();
List getReport6Options = util.getReport6Options();
List YesNoOptions = CEditConst.getYesNoOptions(userInfo,"-1");
Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);
Map sexMap = CEditConst.getsexMap(userInfo);
Map GradeNameMap = CEditConst.getGradeNameMap(userInfo);
PracticeReport v = new PracticeReport();
int id = ParamUtils.getIntParameter(request,"id",-1);
int DeclareId = ParamUtils.getIntParameter(request,"DeclareId",-1);
if (id!=-1&&v.getById(id)!=null) {
	v = v.getById(id);
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/common-student.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/tablelist.js"></script>
<script src="../js/personlistorder.js"></script>
<script src="../main/js/common.js"></script>
<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
<script language="JavaScript" src="../main/js/ajaxfileupload.js"></script>
<script language="JavaScript" src="js/upload.js"></script>
<script type="text/javascript">
function changeTheme() {
	var Report5 = $('#Report5').val();
	if(Report5=="1") {
		$('#PracticeThemespan1').show();
		$('#PracticeThemespan2').hide();
		$('#PracticeTheme2').val("");
		$('#Report5').val("");
	} else {
		$('#PracticeThemespan2').show();
		$('#PracticeThemespan1').hide();
		$('#PracticeTheme1').val("");
		$('#Report5').val("");
	}
}
function addMember(){
	openWindow("BaseUserCodeAction.jsp?values="+$("#SId").val(),"703,400");
}
function setRole(pName,pId){
	$("#SName").append(pName);
	$("#SId").val(pId);
}
function getoptions(cmd){
	var options = "";
	$.ajax({
        type: "post",
        url: "pratice-project-addsave.jsp",
        async:false,
       data: {cmd:cmd},
        dataType: "html",
        cache: false,
        success: function(data){
        	options = data;
                 },
                 error : function() { 
                             // view("异常！"); 
                             alert( "异常！"); 
				}
    });
	return options;
}
function addItem(){
	var AcademyOptions = getoptions("AcademyOptions");
	var GradeOptions = getoptions("GradeOptions");
	var sexOptions = "<option value=-1></option><option value=0>男</option><option value=1>女</option>";
	var dutyOptions = "<option value=-1></option><option value=0>队长</option><option value=1>成员</option>";
	var rowspan = document.getElementById("teamtable").rows.length;
	if (rowspan==1) {
		$('#Nums').val(rowspan);
	} else {
		$('#Nums').val($('#Nums').val()+","+rowspan);
	}
	$("#teamtable").append(
	"<tr id=del"+rowspan+" class=odd>"+
		"<td style='width:10%;'> <input type='text' id='Sno_t"+rowspan+"' size='15' name='Sno_t"+rowspan+"' style='width: 80%'/></td>"+
		"<td style='width:10%;'><input type='text' id='SName_t"+rowspan+"'size='15' name='SName_t"+rowspan+"' style='width: 80%'/></td>"+
		"<td style='width:10%;'><select id='Sex_t"+rowspan+"' name='Sex_t"+rowspan+"'>"+sexOptions+"</select></td>"+
		"<td style='width:10%;'><select style='width:100%;' id='Academy_t"+rowspan+"' name='Academy_t"+rowspan+"'>"+AcademyOptions+"</select></td>"+
		"<td style='width:10%;'><input  id='Identity_t"+rowspan+"'size='15' name='Identity_t"+rowspan+"' style='width: 80%' value='1' type='hidden'/>研究生</td>"+
		"<td style='width:10%;'><select id='Grade_t"+rowspan+"' name='Grade_t"+rowspan+"'>"+GradeOptions+"</select></td>"+
		"<td style='width:10%;'><input type='text' id='Phone_t"+rowspan+"'size='15' name='Phone_t"+rowspan+"' style='width: 80%'/></td>"+
		"<td style='width:10%;'><select id='Duty_t"+rowspan+"' name='Duty_t"+rowspan+"'>"+dutyOptions+"</select></td>"+	
		"<td style='width:10%;'><img  style='cursor:point;' src='../main/images/delete.gif' onclick=javascript:deleteSponsor2('del"+rowspan+"',"+rowspan+") alt=删除  title=删除  border=0></td>"+	
	"</tr>"
	);
}
function deleteSponsor2(trid,id){
	$('#'+trid).remove();
	var files = $('#Nums').val();
	//alert(files+" "+id+" "+files.indexOf(id))
	if(files.indexOf(id)!=-1){
		//替换删掉的附件id
		files = ","+files+",";
		files = files.replace(","+id+",",',');
		//没有附件的情况
		if(files.indexOf(",")==files.lastIndexOf(","))
			files = "";
		else{
			files = files.substring(1,files.length-1);
		}
		//document.postForm.SId.value = files;
		$('#Nums').val(files);
	}
}
function deleteSponsor(trid,id){
	$('#'+trid).remove();
	var files = $('#SId').val();
	//alert(files+" "+id+" "+files.indexOf(id))
	if(files.indexOf(id)!=-1){
		//替换删掉的附件id
		files = ","+files+",";
		files = files.replace(","+id+",",',');
		//没有附件的情况
		if(files.indexOf(",")==files.lastIndexOf(","))
			files = "";
		else{
			files = files.substring(1,files.length-1);
		}
		//document.postForm.SId.value = files;
		$('#SId').val(files);
	}
}
checkSubmitFlg = false; 
function submitthis(Submitflag) {
	if(!chekNull('Report1Name')) {
		alert("请填写团队名称!");
		return;
	}
	if(!chekNull('Report3')) {
		alert("请填写课题名称");
		return;
	}
	
	checkType();
	
	/* var Report5 = $('#Report5').val();
	if (Report5=="-1") {
		alert("请选择实践主题");
		$('#Report5').focus();
		$('#Report5').css("background","yellow");
		return;
	} */
	var Report6 = $('#Report6').val();
	if (Report6=="-1") {
		alert("请选择立项类别");
		$('#Report6').focus();
		$('#Report6').css("background","yellow");
		return;
	}
	if(!chekNull('Report12')) {
		alert("请填写活动地点、路线");
		return;
	}
	if(!chekNull('Report13')) {
		alert("请填写本科学生,没有请填0");
		return;
	}
	if(!chekNull('Report14')) {
		alert("请填写硕士研究生，没有请填0");
		return;
	}
	if(!chekNull('Report15')) {
		alert("请填写博士研究生，没有请填0");
		return;
	}
	if(!chekNull('StartTime')) {
		alert("请填写开始时间");
		return;
	}
	if(!chekNull('EndTime')) {
		alert("请填写结束时间");
	}
	if(!chekNull('Report17')) {
		alert("请填写活动天数");
		return;
	}
	if(!chekNull('Report18')) {
		alert("请填写接收单位对团队活动的评价");
		return;
	}
	if(!chekNull('Report19')) {
		alert("请填写回访联系人");
		return;
	}
	if(!chekNull('Report20')) {
		alert("请填写回访电话");
		return;
	}
	if(!chekNull('Report21')) {
		alert("请填写团队活动小结");
		return;
	}
	if(!chekNull('Report22')) {
		alert("请填写团队主要成绩成果");
		return;
	}
	if(!chekNull('Report23')) {
		alert("请填写报告题目");
		return;
	}
	if(!chekNull('Report24')) {
		alert("请填写报告类别");
		return;
	}
	if(!chekNull('Report25')) {
		alert("请填写报告字数");
		return;
	}
	if(!chekNull('Report26')) {
		alert("请填写报告情况");
		return;
	}
	if(!chekNull('Report27')) {
		alert("请填写指导教师工作总结");
		return;
	}
	if(!chekNull('Report28')) {
		alert("请填写主要宣传报道情况");
		return;
	}
	if(!chekNull('Report29')) {
		alert("请填写宣传报道数量");
		return;
	}
	if(!chekNull('Report30')) {
		alert("请填写安全工作落实情况总结");
		return;
	}
	
	
	
	var SId = $('#SId').val();
	var Nums = $('#Nums').val();
	if (SId==""&&Nums=="") {
		alert("设置成员信息");
		return;
	}
	$('#SubmitFlag').val(Submitflag);
	//alert(chekSname('SName')+"  "+chekSname('teamtable'))
	if(chekSname('SName')||chekSname('teamtable')){
		if(checkSubmitFlg ==true){
			alert("请勿重复提交!");
			return; //当表单被提交过一次后checkSubmitFlg将变为true,根据判断将无法进行提交。 
		} 
		checkSubmitFlg = true; 
		$('#postForm').submit();
	} else {
		alert("成员信息不能为空！");
		return;
	}
}

function chekNull(id) {
	var Report1Name = $('#'+id).val();
	if (Report1Name=="") {
		$('#'+id).focus();
		$('#'+id).css("background","yellow");
		return false;
	} else {
		$('#'+id).css("background","");
		return true;
	}
}
function chekSname(id) {
	var f = true;
	$("#"+id).find("input").each(function () {
        if ($(this).val() == "") {
        	//alert($(this).attr("id"))
            $(this).focus();
            f=false;
        }else{
        	
        }
    })
    return f;
}
function cancelthis() {
	location="pratice-activity-list.jsp";
}
$(function(){
	checkType();
})
function checkType(){
	var Report4 = $('#Report4').val();
	if (Report4=="1") {
		var PracticeTheme1 = $('#PracticeTheme1').val();
		if(PracticeTheme1=="-1") {
			$('#PracticeTheme1').focus();
			return;
		} else {
			$('#Report5').val(PracticeTheme1);
		} 
	} else {
		var PracticeTheme2 = $('#PracticeTheme2').val();
		if(PracticeTheme2=="-1") {
			$('#PracticeTheme2').focus();
			return;
		} else {
			$('#Report5').val(PracticeTheme2);
		}
	}
}
</script>
</head>
<body>
<%
String strposition = "社会实践  >>社会实践项目>> ";
String strfunction = "社会实践结题书-集体申请";
String strhelpwords= "1.各级各类实践立项申报团队均需填写此表，其中团队成员总数一般在10人以内;<br/>"
					+"2.两个以上学院合作组织的团队，需两个学院协商配套经费、共同签署意见;<br/>"
					+"3.若对申请书填写有不清楚的地方，请咨询0531-88369964。";
%>
<%@ include file="../student/pagetop-positionandhelp.jsp" %>

<table class="command-table">
<tr>
	<td>
 	   <a href="pratice-activity-list.jsp"><!-- <img src="../images/commandico/back.png"> -->返回</a>
	</td>
</tr>
</table>

<form name="postForm" id="postForm" action="pratice-project-addsave.jsp" method="post">
<input id="Type" name="Type" value="1" type="hidden"/>
<input id="cmd" name="cmd" value="<%=v.getId()==-1?"save":"update"%>" type="hidden"/>
<input id="SubmitFlag" name="SubmitFlag" value="<%=v.getSubmitFlag()%>" type="hidden"/>
<input id="DeclareId" name="DeclareId" value="<%=DeclareId%>" type="hidden"/>
<input id="Id" name="Id" value="<%=v.getId()%>" type="hidden"/>
<table class="content-table">
<tr>
	<th colspan="2" align="left">社会实践立项资助结题书</th>
</tr>
<tr>
	<td width="20%" align="right">团队名称：</td>
	<%
	PracticeDeclareTeam team = new PracticeDeclareTeam();
	team = util.getTeamDetail(v.getId());
	%>
    <td align="left">
    <input  name="Report1" id="Report1" size="50" value="<%=team.getId()%>" type="hidden"/>
     <input type="text" name="Report1Name" id="Report1Name" size="50"  placeholder="团队名称开头应为“山东大学<%=AcademyNameMap.get(userInfo.getDeptId()+"")%>”" value="<%=team.getTeamName()%>"/>
    </td>
</tr>

<tr>
	<td width="20%" align="right">所属学院：</td>
    <td align="left">
    <input id="Report2" name="Report2" value="<%=userInfo.getDeptId()%>" type="hidden"/>
    <%=AcademyNameMap.get(userInfo.getDeptId()+"")%>
    </td>
</tr>
<tr>
    <td width="20%" align="right">课题名称：</td>
    <td align="left"><input type="text" name="Report3" id="Report3" size="50" placeholder="专题调研、社会调查、科研攻关或科技开发课题名称" value="<%=v.getReport3()%>"/></td>
</tr>
<tr>
    <td width="20%" align="right">团队类别：</td>
    <td align="left">
		<!-- <input type="radio" name="Report4" value="项目化团队" onclick="showdiv(1)"/>项目化团队&nbsp;&nbsp;
    	<input type="radio" name="Report4" value="体验式团队" onclick="showdiv(2)"/>体验式团队&nbsp;&nbsp;
      	<input type="radio" name="Report4" value="综合型团队" onclick="showdiv(3)"/>综合型团队&nbsp;&nbsp; -->
      	<%=HtmlTool.renderSelect(TermTypeOptions,""+team.getPracticeReportTeamType(),"Report4","1","onchange=changeTheme()") %>
    </td>
</tr>
<tr>
    <td width="20%" align="right">实践主题：</td>
    <td align="left">
		<div id="div1" >
    	<span id="PracticeThemespan1">
    	<%=HtmlTool.renderSelect(PracticeThemeOptions1,""+v.getReport5(),"PracticeTheme1","1") %>
    	</span>
    	<span id="PracticeThemespan2" style="display: none">
    	<%=HtmlTool.renderSelect(PracticeThemeOptions2,"","PracticeTheme2","1") %>
    	</span>
		</div>
			<input name="Report5" id="Report5" size="35" value="<%=v.getReport5()%>" type="hidden"/>   
    </td>
</tr>
<tr>
    <td width="20%" align="right" >立项类别：</td>
    <td align="left">
    	<!-- <input type="radio" name="Report6" value="重点立项"/>重点立项&nbsp;&nbsp;
    	<input type="radio" name="Report6" value="一般立项"/>一般立项&nbsp;&nbsp;
    	<input type="radio" name="Report6" value="自筹经费立项"/>自筹经费立项&nbsp;&nbsp;  -->
    	<%=HtmlTool.renderSelect(getReport6Options,""+v.getReport6(),"Report6","1") %>
    </td>
</tr>
<tr>
	<td align="right">成员信息
	</td>
    <td align="left">
    <table    style="border-collapse: separate;border-spacing: 1px;width:100%;font-size:12px;text-align:center;" cellpadding="1px;" cellspacing="1px;">
    <%
    List TeamList = util.getTeamList(v.getId(),"1",1);
    %>
		<tr style="background-color:#f7f9fc;">
			<td ><a href="#" onclick="addItem();return false;" style="color: red;">研究生添加</a></td>
			<td colspan="8"><a href="#" class='add_btn' onclick="addMember();">本科生添加</a></td>
		</tr> 

	</table>
	<!-- 研究生添加 -->
    <table id="teamtable" style="border-collapse: separate;border-spacing: 1px;width:100%;font-size:12px;text-align:center;" cellpadding="1px;" cellspacing="1px;">
		<tr style="background-color:#f7f9fc;">
			<td style="width: 10%">学号</td><td style="width: 10%">姓名</td><td style="width: 10%">性别</td>
			<td style="width: 10%">院系</td><td style="width: 10%">学历</td><td style="width: 10%">年级</td>
			<td style="width: 10%">联系方式</td><td style="width: 10%">承担工作</td><td style="width: 10%">操作</td>
		</tr> 
		<%
		List sexOptions = CEditConst.getsexOptions(userInfo);
		List AcademyNameOptions = CEditConst.getAcademyNameOptions(userInfo);
		List IdentityOptions = CEditConst.getIdentityOptions(userInfo);
		List GradeNameOptions = CEditConst.getGradeNameOptions(userInfo);
		List DutyOPtions = util.getDutyOPtions();
		List tids = new ArrayList();
		if (TeamList.size()>0) {
			for(int i=0;i<TeamList.size();i++) {
				PracticeDeclareTeammember m = new PracticeDeclareTeammember();
				m = (PracticeDeclareTeammember)TeamList.get(i);
				tids.add((i+1)+"");
				%>
				<tr id=del<%=i+1 %> class=odd>
				<td style="width: 10%">
				<input style="width: 100%" id="Id_t<%=i+1%>" name="Id_t<%=i+1%>" value="<%=m.getId()%>" type="hidden"/>
				<input style="width: 100%" id="Sno_t<%=i+1%>" name="Sno_t<%=i+1%>" value="<%=m.getSno()%>"/>
				</td>
				<td style="width: 10%">
				<input style="width: 100%" id="SName_t<%=i+1%>" name="SName_t<%=i+1%>" value="<%=m.getSName()%>"/>
				</td>
				<td style="width: 10%">
				<select id="Sex_t<%=i+1%>" name="Sex_t<%=i+1%>" style="width: 100%">
				<%=HtmlTool.renderMulSelectOption(sexOptions,""+m.getSex(),"Sex_t"+(i+1)) %>
				</select>
				<%-- <input style="width: 100%" id="Sex_t<%=m.getId()%>" name="Sex_t<%=m.getId()%>" value="<%=m.getSex()%>"/> --%>
				</td>
				<td style="width: 10%">
				<select id="Academy_t<%=i+1%>" name="Academy_t<%=i+1%>" style="width: 100%">
				<%=HtmlTool.renderMulSelectOption(AcademyNameOptions,""+m.getAcademy(),"Academy_t"+(i+1)) %>
				</select>
				</td>
				<td style="width: 10%">
				<select id="Identity_t<%=m.getId()%>" name="Identity_t<%=m.getId()%>" style="width: 100%">
				<%=HtmlTool.renderMulSelectOption(IdentityOptions,""+m.getIdentity(),"Identity_t"+(i+1)) %>
				</select>
				</td>
				<td style="width: 10%">
				<select id="Grade_t<%=m.getId()%>" name="Grade_t<%=m.getId()%>"  style="width: 100%">
				<%=HtmlTool.renderMulSelectOption(GradeNameOptions,""+m.getGrade(),"Grade_t"+(i+1)) %>
				</select>
				</td>
				<td style="width: 10%">
				<input style="width: 100%" id="Phone_t<%=i+1%>" name="Phone_t<%=(i+1)%>" value="<%=m.getPhone() %>"/>
				</td>
				<td style="width: 10%">
				<select id="Duty_t<%=i+1%>" name="Duty_t<%=i+1%>"  style="width: 100%">
				<%=HtmlTool.renderMulSelectOption(DutyOPtions,""+m.getDuty(),"Duty_t"+(i+1)) %>
				</select>
				</td>
				<td style='width:10%;'><img  style='cursor:point;' src='../main/images/delete.gif' onclick=javascript:deleteSponsor2('del<%=i+1 %>',<%=i+1 %>) alt=删除  title=删除  border=0></td>
				</tr>
			<%}
		}
		%>
 <input type="hidden" id="Nums" name="Nums" value="<%=tids.size()>0?Tool.join(",",tids):"" %>"/>
	</table>
    <table  id="SName" style="border-collapse: separate;border-spacing: 1px;width:100%;font-size:12px;text-align:center;" cellpadding="1px;" cellspacing="1px;">
	<!-- <tr>
	<td>学号</td><td>姓名</td><td>性别</td><td>院系</td><td>学历</td><td>年级</td><td>联系方式</td><td>承担工作</td><td><a href="#" class='add_btn' onclick="addMember();">本科生添加</a></td>
	</tr> -->
	<%
	List sidsList = new ArrayList();
	if (v.getId()!=-1) {
		PracticeDeclareTeammember member = new PracticeDeclareTeammember();		
		List list = new ArrayList();
		list = util.getTeamList(v.getId(),"1",0);
		if (list.size()>0) {
			for (int i=0;i<list.size();i++) {
				//}
				member = (PracticeDeclareTeammember)list.get(i);
				sidsList.add(member.getSName()+"");
				%>
				<tr id="deleteSponsor_<%=member.getSName()%>">
				<input id="SName<%=member.getSName()%>" name="SName<%=member.getSName()%>" value="<%=member.getSName()%>" type="hidden"/>
				<td style="width: 10%"><%=member.getSno()%></td>
				<td style="width: 10%"><%=UserCnNameMap.get(member.getSName())==null?"":UserCnNameMap.get(member.getSName()) %></td>
				<td style="width: 10%"><%=sexMap.get(member.getSex())==null?"":sexMap.get(member.getSex()) %></td>
				<td style="width: 10%"><%=AcademyNameMap.get(member.getAcademy())==null?"":AcademyNameMap.get(member.getAcademy()) %></td>
				<td style="width: 10%"><input type="hidden" id="Identity<%=member.getId()%>" name="Identity<%=member.getSName()%>" value="1"/>本科</td>
				<td style="width: 10%"><%=GradeNameMap.get(member.getGrade())==null?"":GradeNameMap.get(member.getGrade()) %></td>
				<td style="width: 10%"><input style="width: 100%" id="Phone<%=member.getSName()%>" name="Phone<%=member.getSName()%>" value="<%=member.getPhone() %>"/></td>
				<td style="width: 10%">
				<select id="Duty<%=member.getSName()%>" name="Duty<%=member.getSName()%>" style="width: 100%">
				<%=HtmlTool.renderMulSelectOption(DutyOPtions,""+member.getDuty(),"Duty"+member.getSName()) %>
				</select>
				</td>
				<td style="width: 10%">
				<img style="cursor:point;" src='<%=HeadConst.apache_url%>/main/images/delete.gif' onclick="javascript:deleteSponsor('deleteSponsor_<%=member.getSName() %>','<%=member.getSName() %>')" alt='删除' title='删除' border=0 />
				</td>
				</tr>
			<%}
		}
	}
	%>
	<input id="SId" name="SId" value="<%=Tool.join(",",sidsList)%>" type="hidden"/>
	</table>
    </td>
</tr>
<tr>
	<td align="right" rowspan="3">组队情况</td>
    <td align="left">
    	<p>活动地点、路线：<input type="text" name="Report12" id="Report12" size="40" value="<%=v.getReport12()%>"/></p>
    </td>
</tr>
<tr>
	<td align="left">
		<p>本科学生：<input type="number" name="Report13" id="Report13" value="<%=v.getReport13()%>"/>人</p>
		<p>硕士研究生：<input type="number" name="Report14" id="Report14" value="<%=v.getReport14()%>"/>人</p>
		<p>博士研究生：<input type="number" name="Report15" id="Report15" value="<%=v.getReport15()%>"/>人</p>
	</td>
</tr>
<tr>
	<td align="left">
		<p>活动起止日期：
		<input onclick="WdatePicker({el:'StartTime',dateFmt:'yyyy-MM-dd'})" name="StartTime" readonly id="StartTime" size="0" value="<%=v.getStartTime()%>">
		<input name="EndTime"  id="EndTime" size="0" value="<%=v.getEndTime()%>" readonly onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'StartTime\')}',onpicked:function(){}})" >
		&nbsp;&nbsp;&nbsp;&nbsp;活动天数：<input type="number" name="Report17" id="Report17" value="<%=v.getReport17()%>"/>天</p>
	</td>
</tr>
<tr>
	<td align="right">接收单位对团队活动的评价</td>
	<td align="left">
		<p><textarea name="Report18" cols="80" rows="6" id="Report18"><%=v.getReport18() %></textarea></p>
		<p>回访联系人：<input  name="Report19" id="Report19" value="<%=v.getReport19()%>"/>
		&nbsp;&nbsp;&nbsp;&nbsp;回访电话：<input type="number" id="Report20"name="Report20" value="<%=v.getReport20()%>"/></p>
	</td>
</tr>
<tr>
	<td align="right">团队活动小结</td>
	<td align="left">
		<textarea name="Report21" cols="80" rows="6" id="Report21" ><%=team.getReport21() %></textarea>
	</td>
</tr>
<tr>
	<td align="right">团队主要成绩成果</td>
	<td align="left">
		<textarea name="Report22" cols="80" rows="6" id="Report22"><%=team.getReport22() %></textarea>
	</td>
</tr>
<tr>
	<td align="right">专题调研、社会调查、科研攻关及科技开发报告情况</td>
	<td align="left">
		<p>报告题目：<input type="text" name="Report23" size="40" id="Report23" value="<%=v.getReport23()%>"/></p>
		<p>报告类别：<input type="text" name="Report24" id="Report24" value="<%=v.getReport24()%>"/>
		&nbsp;&nbsp;&nbsp;&nbsp;报告字数：<input type="number" name="Report25" id="Report25" value="<%=v.getReport25()%>"/></p>
		<p>对地方经济、社会和文化发展或企业成长的实际作用:</p>
		<textarea name="Report26" cols="80" rows="6" id="Report26" ><%=v.getReport26() %></textarea>
	</td>
</tr>
<tr>
	<td align="right">指导教师工作总结</td>
	<td align="left">
		<textarea name="Report27" cols="80" rows="6" id="Report27"><%=v.getReport27() %></textarea>
	</td>
</tr>
<tr>
	<td align="right">主要宣传报道情况</td>
	<td align="left">
		<textarea name="Report28" cols="80" rows="6" placeholder="媒体名称、媒体级别、宣传报道题目" id="Report28"><%=v.getReport28() %></textarea>
		<p>宣传报道数量：<input type="number" name="Report29" id="Report29" value="<%=v.getReport29() %>"/></p>
	</td>
</tr>
<tr>
	<td align="right">安全工作落实情况总结</td>
	<td align="left">
		<textarea name="Report30" id="Report30" cols="80" rows="6"><%=v.getReport30() %></textarea>
	</td>
</tr>
<tr id="ClientAttach">
  		<td align="right" class="form_label">附件</td>
  		<td bgcolor="#ffffff" align="left" colspan="3">
  		<input type="hidden" id="AddFilelist" name="AddFilelist" value="<%=v.getAddFilelist()%>"/>
		<table width="100%" border="0" cellspacing="0" id="ShowFilesAddFilelist">
				<%
				int caid = v.getId();
				if (!"".equals(v.getAddFilelist().trim())) {
					String caids[] = v.getAddFilelist().split(",");
					for(int i=0;i<caids.length;i++){
						caid = Tool.StrToInt(caids[i]);
						ClientAttach ca = new ClientAttach();
						if (caid!=-1&&ca.getById(caid)!=null) {
							ca = ca.getById(caid);
				%>
			     <tr id="<%=ca.getId() %>"><td><a href="<%=HeadConst.apache_url %>/servlet/attach?type=otherattach&id=<%=ca.getId() %>" target="_blank">
				<img src='<%=HeadConst.apache_url%>/main/images/file1.gif' border="0"/> <%=ca.getUploadName() %></a>&nbsp;&nbsp;&nbsp;&nbsp;
				<img  src='<%=HeadConst.apache_url%>/main/images/delete.gif' alt='删除' title='删除' border="0" onclick="javascript:deleteUpdateFile('<%=ca.getUploadName()%>','<%=ca.getId() %>')" style="cursor:point;"/></td>
				</tr>
					<%}
					}
				}
				%>
			</table>
				<%
				//if(v.getCheckFlag()!=1){%>
				<input  type="file" name="OtherAttachAddFilelist" id="OtherAttachAddFilelist" size="40"/> 
				<input type="button" value="上传" id="btn_up"  onclick="checkFileType(13,'Practice_Report','AddFilelist');" class="formbtn" style="color:black;background-color: #e3e5e8;"/>
				<img style="display:none" id="load1AddFilelist" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
				<%//}
				%>
			    <div style="color:red">说明：请上传格式为:doc、docx格式文件，文件最大5M</div>
			</td>
  		</tr>
</table>
</form>
<table class="content-table" style="margin-top:-15px">
<tr>
  <th  colspan="3" >
  <%
  if (v.getSubmitFlag()==-1) {%>
	  <input class="button" type="button" value="保存" name="btn1" onclick="submitthis(-1)">&nbsp;&nbsp;&nbsp;
    <input class="button" type="button" value="提交" name="btn1" onclick="submitthis(1)">&nbsp;&nbsp;&nbsp;
  <%}
  %>
    <input class="button" type="button" value="取消" name="btn2" onclick="cancelthis()">&nbsp;&nbsp;&nbsp;
  </th>
</tr>
</table>
</body>
</html>
