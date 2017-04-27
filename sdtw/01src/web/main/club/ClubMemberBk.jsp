<%@page import="com.xietong.software.sdtw.club.ClubUtil"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xietong.software.common.COptionConst"%>
<%@page import="java.util.List"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(userInfo == null){
		out.print(HtmlTool.msgBox(request, "请先登录"));
		return;
}
int Identity = ParamUtils.getIntParameter(request,"Identity",0);
//List ClubNameOptions = CEditConst.getClubNameOptions(userInfo,"-1");
List cdt = new ArrayList();
if (userInfo.hasFunPower(Power.STUSER)) {
	cdt.add("clubid = '"+userInfo.getUserCode().getName()+"'");
}
List ClubNameOptions = COptionConst.getClubNameOptions(userInfo,cdt);
ClubUtil util = new ClubUtil();
List MemberDutyOptions = util.getMemberDutyOptions();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/WdatePicker.js"></script>
<script src="<%=HeadConst.apache_url%>/main/js/common.js"></script>
<script>
function tjbw() {//添加
	var Classname = $('#classname').val();
	if (Classname==""||Classname=="-1"){
		alert("请先选择班级！");
		$('#classname').focus();
		return;
	} else {
		addSponsor(Classname)
	}
	
}
function addSponsor(Classname){
	openWindow("<%=HeadConst.apache_url%>/main/club/BaseUserCodeAction.jsp?values="+$("#SId").val(),"703,430");
}
function setRole(pName,pId){
	$("#SName").html(pName);
	$("#SId").val(pId);
}
function deleteSponsor(trid,id){
	$('#'+trid).remove();
	var files = document.postForm.SId.value;
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
		document.postForm.SId.value = files;
	}
}
function submitthis() {
	var MemberDuty = $('#MemberDuty').val();
	if (MemberDuty==""||MemberDuty=="-1") {
		alert("请选择职责");
		$('#MemberDuty').focus();
		return;
	}
	var myreg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
	var MemberPhone = $('#MemberPhone').val();
	if(!myreg.test(MemberPhone)){
    	alert("手机格式不正确！");
    	$('#MemberPhone').focus();
    	return false;
    } 
	var myreg2 = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	var MemberEmail = $('#MemberEmail').val();
	if(!myreg2.test(MemberEmail)){
    	alert("邮箱格式不正确！");
    	$('#MemberEmail').focus();
    	return false;
    } 
	$.ajax({
        type: "post",
        url: "<%=HeadConst.apache_url%>/main/club/ClubMembersAction.jsp",
       data:$('#postForm').serialize(),
        dataType: "json",
        cache: false,
        async:false,
        success: function(data){
                   if (data.msg=="ok") {
                	   alert("添加成功");
                	   parent.mainFrame.location.reload();
                	   $( '#top_dialog').dialog( 'close');
                   }else if(data.msg=="no"){
                	   alert("保存失败");
                	   return;
                   } else{
                	   alert("请选择添加人");
                	   return;
                   }
                 },
                 error : function() { 
                             // view("异常！"); 
                             alert( "异常！"); 
}
    });

}
</script>
</head>
<body>
<div class="browsetable" id="form">
<form action="" method="post" name="postForm" id="postForm">
<input id="SId" name="SId" type="hidden"/>
<input id="cmd" name="cmd" value="add" type="hidden"/>
<input id="Identity" name="Identity" value="<%=Identity%>" type="hidden"/>
	<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
		<tr>
			<td align="right" class="form_label">
	        <button onclick="tjbw()" type="button">选择</button>
	        </td>
			<td align="left"  bgcolor="#ffffff" colspan="5">
			<table id="SName"></table>
			</td>
		</tr>
		<tr>
			<td align="right" class="form_label">社团名称</td>
			<td align="left"  bgcolor="#ffffff">
			<%=HtmlTool.renderSelect(ClubNameOptions,"","MemberClubname","") %>
			</td>
			<td align="right" class="form_label">职责</td>
			<td align="left"  bgcolor="#ffffff">
			<%=HtmlTool.renderSelect(MemberDutyOptions,"","MemberDuty","") %>
			</td>
		</tr>
		<tr>
		<td align="right" class="form_label">生日</td>
		<td align="left"  bgcolor="#ffffff">
		<input readonly="readonly" class= "date" name ="MemberBrith" id= "MemberBrith" onfocus="WdatePicker({el:'MemberBrith',dateFmt:'yyyy-MM-dd',startDate: '%y-%M-%d'})"  size= "0" value="<%//= v.getMemberBrith()%>"/>
		</td>
		
		<td align="right" class="form_label">籍贯</td>
		<td align="left"  bgcolor="#ffffff"><input id="MemberBirthplace" name="MemberBirthplace"/></td>
		
		<td align="right" class="form_label">邮箱</td>
		<td align="left"  bgcolor="#ffffff"><input id="MemberEmail" name="MemberEmail"/></td>
		</tr>
		<tr>
		<td align="right" class="form_label">手机</td>
		<td align="left"  bgcolor="#ffffff"><input id="MemberPhone" name="MemberPhone"/></td>
		
		<td align="right" class="form_label">QQ</td>
		<td align="left"  bgcolor="#ffffff"><input id="Memberqq" name="Memberqq"/></td>
		
		<td align="right" class="form_label">微信</td>
		<td align="left"  bgcolor="#ffffff"><input id="Memberwx" name="Memberwx"/></td>
		</tr>
		<tr>
		<td align="right" class="form_label">个人简介</td>
		<td align="left"  bgcolor="#ffffff" colspan="5">
			<textarea rows="3" cols="100" id="MProfile" name="MProfile" style="width: 100%"></textarea>
		</td>
		</tr>
		<tr>
		<td align="right" class="form_label">社团工作经历</td>
		<td align="left"  bgcolor="#ffffff" colspan="5">
		<textarea rows="3" cols="100" id="MExperience" name="MExperience" style="width: 100%"></textarea>
		</td>
		</tr>
		<tr>
		<td align="right" class="form_label">备注</td>
		<td align="left"  bgcolor="#ffffff" colspan="5">
		<textarea rows="3" cols="100" id="Remark" name="Remark" style="width: 100%"></textarea>
		</td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>