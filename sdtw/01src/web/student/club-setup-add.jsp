<%@page import="com.xietong.software.sdtw.club.ClubUtil"%>
<%@page import="com.xietong.software.sdtw.db.ClubMembers"%>
<%@page import="com.xietong.software.common.COptionConst"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.sdtw.db.ClientAttach"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.sdtw.db.Students"%>
<%@page import="com.xietong.software.sdtw.db.Club"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%//社团申请页面 %>
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}
List OrgCityNameOptions = CEditConst.getOrgCityNameOptions(userInfo,"");
List ClubTypeNameOptions = CEditConst.getClubTypeNameOptions(userInfo,"");
List cdt1 = new ArrayList();
cdt1.add("flag=1");
List AcademyNameOptions = COptionConst.getAcademyAliasNameOptions(userInfo,"",cdt1);
	//CEditConst.getAcademyNameOptions(userInfo,"");
int id = ParamUtils.getIntParameter(request,"id",-1);
Club club = new Club();
if(id!=-1&&club.getById(id)!=null){
	club = club.getById(id);
}
String cmd = ParamUtils.getParameter(request,"cmd","");
String backurl = ParamUtils.getParameter(request,"backurl","");
String active = ParamUtils.getParameter(request,"active","0");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../js/jquery.min.js"></script>
<script src="../js/tablelist.js"></script>
<!-- <link rel="stylesheet" type="text/css" href="../css/autosearch.css"> -->
<script src="../js/autosearch.js"></script>
<script src="../main/js/common.js"></script>
<script language="JavaScript" src="../main/js/ajaxfileupload.js"></script>
<%-- <link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/chosen/chosen.css" rel="stylesheet"/> --%>
	<%-- <script language="javascript" src="<%=HeadConst.apache_url+"/main/" %>/js/chosen/chosen.jquery.js"></script> --%>
<style type="text/css">
.blocktitle{
	font-size:large;
	font-weight:bold;
}
</style>
<script type="text/javascript">
checkSubmitFlg = false; 
function formsubmit(){
	var City = $('#City').val();
	var ClubName = $('#ClubName').val();
	var ClubType = $('#ClubType').val();
	var Chairman = $('#Chairman').val();
	var Academy = $('#Academy').val();
	//var Teacher = $('#Teacher').val();
	var Clubqq = $('#Clubqq').val();
	var ClubeMail = $('#ClubeMail').val();
	var ClubPubAccount = $('#ClubPubAccount').val();
	var Tenet = $('#Tenet').val();
	var ClubProfile = $('#ClubProfile').val();
	var Sponsor = $('#SId').val();
	if(City==""||City=="-1"){
		$('#City').focus();
		alert("请选择所在校区城市！");
		return;
	}
 	if(ClubName==""){
		$('#ClubName').focus();
		alert("请录入社团名称！")
		return;
	}
 	var pattern = new RegExp("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]") 
 	if(pattern.test(ClubName)){
    	$('#ClubName').focus();
    	alert("社团名称中请勿录入特殊字符！");
    	return;
	 }
 	 if(ClubType==""||ClubType=="-1"){
		$('#ClubType').focus();
		alert("请选择社团类别！");
		return;
	}
 	if(Chairman==""){
		$('#Chairman').focus();
		alert("请录入拟任负责人！");
		return;
	}
 	if(Academy==""||Academy=="-1"){
		$('#Academy').focus();
		alert("请选择指导单位！");
		return;
	}
	/* if(Teacher==""){
		$('#Teacher').focus();
		alert("请录入指导老师");
		return;
	} */
	if(Clubqq==""){
		$('#Clubqq').focus();
		alert("请录入QQ！");
		return;
	}
	if(ClubeMail==""){
		$('#ClubeMail').focus();
		alert("请录入邮箱！");
		return;
	}
	var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    if(!myreg.test(ClubeMail)){
    	$('#ClubeMail').focus();
    	alert("邮箱格式不正确！");
    	return;
	 }
    if(ClubPubAccount==""){
    	$('#ClubPubAccount').focus();
    	alert("请录入公众号！");
    	return;
    }
    if(Tenet==""){
    	$("#Tenet").focus();
    	alert("请录入社团宗旨！");
    	return;
    }
    if(ClubProfile==""){
    	$('#ClubProfile').focus();
    	alert("请录入社团简介！");
    	return;
    }
    /* if(Sponsor==""){
    	alert("请添加发起人情况!");
    	return;
    } */
    var SId = $('#SId').val();
	var Nums = $('#Nums').val();
	if (SId==""&&Nums=="") {
		alert("设置 发起人情况信息");
		return;
	}

	if(chekSname('SName')||chekSname('teamtable')){
		if(checkSubmitFlg ==true){
			alert("请勿重复提交!");
			return; //当表单被提交过一次后checkSubmitFlg将变为true,根据判断将无法进行提交。 
		} 
		checkSubmitFlg = true; 
		$('#postForm').submit();
	} else {
		alert(" 发起人情况信息不能为空！");
		return;
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
function formcancel(backurl){
	location.href=backurl;
}
function addSponsor(){
	openWindow("BaseUserCodeAction.jsp?values="+$("#SId").val(),"703,400");
}
function addSponsorN(){
	openWindow("BaseUserCodeAction.jsp?cmd=nfzr&values="+$("#Chairman").val(),"703,400");
}
function setRole(pName,pId){
	$("#SName").append(pName);
	$("#SId").val(pId);
}
function setRoleN(pName,pId){
	//alert(pName+"   "+pId)
	$("#ChairmanName").val(pName);
	$("#Chairman").val(pId);
}

function uploadOtherAttatch(){//上传其他附件
	//debugger;
	var name=document.getElementById('OtherAttach').value;
    $("#load1")
    .ajaxStart(function(){
        $(this).show();
    })
    .ajaxComplete(function(){
        $(this).hide();
    });
    $.ajaxFileUpload
    (
        {
            url:'club-setup-addsave.jsp?cmd=otherattach',
            secureuri:false,
            fileElementId:'OtherAttach',
            type:'post',	
            dataType: 'json',
            success: function (data, status)
            {
                if(typeof(data.error) != 'undefined')
                {
                    if(data.error != '')
                    {                    
                        alert(data.error);
                    }else
                    {
                    	// if(document.postForm.AddFileList.value==""){
                         	var be = data.url.indexOf("=");
                         	var en = data.url.lastIndexOf("/");
                         	document.postForm.AddFileList.value = data.ids;
                        /*  }else{
                         	var be = data.url.indexOf("=");
                         	var en = data.url.lastIndexOf("/");
                         	document.postForm.AddFileList.value += ","+data.ids;
                         }  */
                        var table = document.getElementById('ShowFiles');
                        var num = table.rows.length;
                        var row = table.insertRow(num);
                        var filename = data.url.replace(/.*(\/|\\)/, "");
                        filename = data.name;
                        var cell = row.insertCell(0);
                        <%
                        	if(cmd.equals("update")){
                        %>
		                        row.id = data.ids;//修改时以防和之前重名
		                        cell.innerHTML =  '<img src=\'<%=HeadConst.apache_url %>/main/images/file1.gif\'/> '+filename+'&nbsp;&nbsp;&nbsp;&nbsp;<img src=\'<%=HeadConst.apache_url %>/main/images/delete.gif\' alt=\'删除\' title=\'删除\' onclick=\'deleteUpdateFile("'+filename+'",'+data.ids+');\' style="cursor:point;"/>';
                        <%
                        	}else{
                        %>
		                        row.id = data.ids;//修改时以防和之前重名
		                        cell.innerHTML =  '<img src=\'<%=HeadConst.apache_url %>/main/images/file1.gif\'/> '+filename+'&nbsp;&nbsp;&nbsp;&nbsp;<img src=\'<%=HeadConst.apache_url %>/main/images/delete.gif\' alt=\'删除\' title=\'删除\' onclick=\'deleteUpdateFile("'+filename+'",'+data.ids+');\' style="cursor:point;"/>';
                        <%
                        	}
                        %>
                    }
                }
            },
            error: function (data, status, e)
            {
                alert("上传文件失败，请重新上传！");
            }
        }
    )
}

/*
上传文档格式过滤
*/
function checkFileType(){//上传文档格式过滤
	var file=document.getElementById('OtherAttach').value;
	if(file){
		var allowType = {"doc":"", "xls":"", "docx":"", "xlsx":""};
		var filename=file.replace(/.*(\/|\\)/, "");//jquery获得文件名
		var fileExt=(/[.]/.exec(filename)) ? /[^.]+$/.exec(filename.toLowerCase()) : '';//jquery获得后缀名
		if((fileExt+"").toLowerCase() in allowType){
			uploadOtherAttatch();
		}
		else{
			alert("上传文件格式不符合要求，请重新选择！");
		}
	}
	return false;
}
function deleteUpdateFile(name,id){//删除修改时上传附件
	if(confirm('是否确定删除？')){
		$.ajax({
			type:"post",			
			url:"club-setup-addsave.jsp?cmd=delAttach&did="+id,
			dataType:"json",
			beforeSend:function(){
				$("#load1").show();
			},
			success:function(data, status, e){
	        	if(typeof(data.error) != 'undefined'){
                    if(data.error != '')
                    {
                        alert(data.error);
                    }else
                    {
                    	$("#load1").hide();
        				var row = document.getElementById(id);
        				for(var i=0;i<row.cells.length;i++){
        					row.deleteCell(i);
        				}
        				var files = document.postForm.AddFileList.value;
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
        					document.postForm.AddFileList.value = files;
        				}
                    }
                }
             },
            error: function (data, status, e){
            	$("#load1").hide();
                alert("删除文件失败!");
            }
		});
	}
	return false;
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
/* $(function(){
	$("#Chairman").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到"});
	//$("#Teacher").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到"});
	$("#Academy").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到"});
}) */
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
        url: "club-setup-addsave.jsp",
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
//研究生添加
function addItem(){
	var AcademyOptions = getoptions("AcademyOptions");
	var GradeOptions = getoptions("GradeOptions");
	var sexOptions = "<option value=-1></option><option value=0>男</option><option value=1>女</option>";
	var dutyOptions = "<option value=-1></option><option value=1>团支书</option><option value=2>财务负责人</option><option value=3>其他</option>";
	var rowspan = document.getElementById("teamtable").rows.length;
	if (rowspan==1) {
		$('#Nums').val(rowspan);
	} else {
		$('#Nums').val($('#Nums').val()+","+rowspan);
	}
	$("#teamtable").append(
/* 	"<tr id=del"+rowspan+" class=odd>"+
		"<td style='width:10%;'> <input id='MemberSno_t"+rowspan+"' size='15' name='MemberSno_t"+rowspan+"' style='width: 80%'/></td>"+
		"<td style='width:10%;'><input  id='MemberName_t"+rowspan+"'size='15' name='MemberName_t"+rowspan+"' style='width: 80%'/></td>"+
		"<td style='width:10%;'><select id='MemberSex_t"+rowspan+"' name='MemberSex_t"+rowspan+"'>"+sexOptions+"</select></td>"+
		"<td style='width:10%;'><select style='width:100%;' id='MemberAcademy_t"+rowspan+"' name='MemberAcademy_t"+rowspan+"'>"+AcademyOptions+"</select></td>"+
		"<td style='width:10%;'><input  id='Identity_t"+rowspan+"'size='15' name='Identity_t"+rowspan+"' style='width: 80%' value='1' type='hidden'/>研究生</td>"+
		"<td style='width:10%;'><select id='MemberGrade_t"+rowspan+"' name='MemberGrade_t"+rowspan+"'>"+GradeOptions+"</select></td>"+
		"<td style='width:10%;'><input  id='MemberPhone_t"+rowspan+"'size='15' name='MemberPhone_t"+rowspan+"' style='width: 80%'/></td>"+
		"<td style='width:10%;'><select id='MemberDuty_t"+rowspan+"' name='MemberDuty_t"+rowspan+"'>"+dutyOptions+"</select></td>"+	
		"<td style='width:10%;'><img  style='cursor:point;' src='../main/images/delete.gif' onclick=javascript:deleteSponsor2('del"+rowspan+"',"+rowspan+") alt=删除  title=删除  border=0></td>"+	
	"</tr>"
	 */
		"<tr id=del"+rowspan+" class=odd>"+
		"<td style='width:10%;'> <input type='text' id='Sno_t"+rowspan+"' size='15' name='Sno_t"+rowspan+"' style='width: 100%'/></td>"+
		"<td style='width:10%;'><input type='text' id='SName_t"+rowspan+"'size='15' name='SName_t"+rowspan+"' style='width: 100%'/></td>"+
		"<td style='width:10%;'><select style='width: 100%' id='Sex_t"+rowspan+"' name='Sex_t"+rowspan+"'>"+sexOptions+"</select></td>"+
		"<td style='width:10%;'><select style='width:100%;' id='Academy_t"+rowspan+"' name='Academy_t"+rowspan+"'>"+AcademyOptions+"</select></td>"+
		"<td style='width:10%;'><input  id='Identity_t"+rowspan+"'size='15' name='Identity_t"+rowspan+"' style='width: 100%' value='1' type='hidden'/>研究生</td>"+
		"<td style='width:10%;'><select style='width: 100%' id='Grade_t"+rowspan+"' name='Grade_t"+rowspan+"'>"+GradeOptions+"</select></td>"+
		"<td style='width:10%;'><input type='text' id='Phone_t"+rowspan+"'size='15' name='Phone_t"+rowspan+"' style='width: 100%'/></td>"+
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
</script>
</head>

<body>
<%
String strposition = "学生社团工作 >> 社团成立申请 >> ";
String strfunction = "添加社团成立申请";
String strhelpwords = "提交社团成立申请。";
if("view".equals(cmd)||"viewlist".equals(cmd)){
	strfunction = "查看社团成立申请";
	strhelpwords = "查看社团成立申请。";
}
%>
<%@ include file="pagetop-positionandhelp.jsp" %>

<table class="command-table">
<tr>
    <td>
    <%-- <%
    if("viewlist".equals(cmd)){%>
    	<a href="club-all-list.jsp" >
    <%}else{%>
    	<a href="club-setup-list.jsp" >
    <%}
    %> --%>
    <a href="#" onclick="formcancel('<%=backurl+"?active="+active%>')" >
    <!-- <img src="../images/commandico/back.png"> -->返回</a></td>
</tr>
</table>
<form name="postForm" id="postForm" action="club-setup-addsave.jsp" method="post">
<table class="content-table">
<input id="cmd" name="cmd" value="<%=club.getId()==-1?"save":"update"%>" type="hidden"/>
<tr height="35"><td colspan="8" class="blocktitle">基本事项</td></tr>
<tr>
	<td align="right" width="15%">&nbsp;<font color="red">*&nbsp;</font>所在校区城市：</td>
    <td align="left" >
		<%=HtmlTool.renderSelect(OrgCityNameOptions, ""+club.getCity(), "City", ""+userInfo.getOrgId())%>
	</td>
	<td align="right">&nbsp;<font color="red">*&nbsp;</font>指导单位：</td>
    <td align="left" colspan="3">
       	<%=HtmlTool.renderSelect(AcademyNameOptions, ""+club.getAcademy(), "Academy", ""+userInfo.getDeptId())%>	
    </td>
</tr>
<tr>
	<td align="right" width="15%">&nbsp;<font color="red">*&nbsp;</font>社团名称：</td>
    <td align="left" width="35%"><input type="text" id="ClubName"name="ClubName"  maxlength="45" size="30" value="<%=club.getClubName()%>"></td>
    <td  align="right">&nbsp;社团代码（活动许可代码）：</td>
     <td align="left">
     <%if(SdtwConst.CHECKFLAG_XXTG.equals(club.getCheckFlag())){%>
    	 <%=club.getClubId() %>
     <%}else{%>
    	社团申请通过后生成 
     <%}
     %></td>
</tr>
<tr>
	<td  align="right">&nbsp;<font color="red">*&nbsp;</font>社团类别：</td>
	<td align="left">
		<!-- <select name="clubtype" style="width:280px;">
			<option value='理论学习' selected>理论学习</option>
			<option value='公益服务'>公益服务</option>
			<option value='应用实践'>应用实践</option>
			<option value='体育锻炼'>体育锻炼</option>
			<option value='文艺娱乐'>文艺娱乐</option>
			<option value='职业发展'>职业发展</option>
			<option value='其他'>其他</option>
		</select> -->
		<%=HtmlTool.renderSelect(ClubTypeNameOptions, ""+club.getClubType(), "ClubType", "-1")%>
	</td>
	<td align="right">&nbsp;<font color="red">*&nbsp;</font>拟任负责人：</td>
    <td align="left">
    <%
    String name = "";
    if(!"".equals(club.getChairman())) {
    	BaseUserCode u = new BaseUserCode();
   		List cdt = new ArrayList();
   		List list = new ArrayList();
   		cdt.add("id ="+club.getChairman());
   		list = u.query(cdt);
   		if(list.size()>0)
   		u = (BaseUserCode)list.get(0);
   		name = u.getCnName();
    }
    %>
    <%//=HtmlTool.renderSelect(UserCnNameOptions,""+club.getChairman(), "Chairman", "-1")%>
    <input id="Chairman" name="Chairman" value="<%=club.getChairman()%>" type="hidden"/>
    <%
    %>
    <input id="ChairmanName" name="ChairmanName" value="<%=name%>" readonly="readonly"/>
    <a href="#" class='add_btn' onclick="addSponsorN();">添加</a>
   <%--  <input type="text" name="Chairman" id="Chairman"  maxlength="45" size="40" value="<%=club.getChairman()%>"> --%>
   
    </td>
</tr>
<tr>
	<td align="right">&nbsp;成立时间：</td>
    <td align="left">
    <%if(SdtwConst.CHECKFLAG_XXTG.equals(club.getCheckFlag())){%>
    	<%=club.getClubTimeSetup() %>
    <%}else{%>
    	申请审批通过后设置
    <%} %>
    </td>
    <td  align="right">&nbsp;<font color="red">*&nbsp;</font>QQ：</td>
     <td align="left"><input type="text" name="Clubqq" id="Clubqq" maxlength="45" size="40" value="<%=club.getClubqq()%>"></td>
</tr>
<tr>
    <td  align="right">&nbsp;<font color="red">*&nbsp;</font>Email：</td>
     <td align="left"><input type="text" name="ClubeMail" id="ClubeMail"  maxlength="45" size="40" value="<%=club.getClubeMail()%>"></td>
    <td  align="right">&nbsp;<font color="red">*&nbsp;</font>公众号：</td>
     <td align="left"><input type="text" name="ClubPubAccount" id="ClubPubAccount" maxlength="45" size="40" value="<%=club.getClubPubAccount()%>"></td>
</tr>
<tr>
	<td align="right">&nbsp;<font color="red">*&nbsp;</font>社团宗旨：</td>
    <td align="left" colspan="3"><input type="text" name="Tenet" id="Tenet"  maxlength="50" size="80" value="<%=club.getTenet()%>"></td>
</tr>
<tr>
	<td align="right">&nbsp;<font color="red">*&nbsp;</font>社团简介：</td>
    <td align="left" colspan="3"><textarea name="ClubProfile" id="ClubProfile" cols="80%" rows="5" maxlength="2000"><%=club.getClubProfile() %></textarea></td>
</tr>
<tr height="35"><td colspan="4" align="center" colspan="8" class="blocktitle">相关情况</td></tr>
<tr height="35"><td colspan="4" align="center" colspan="8" style="color: red;">发起人不少于10人</td></tr>
<tr>
	<td align="right">发起人情况
	</td>
    <td align="left" colspan="3">
    <table    style="border-collapse: separate;border-spacing: 1px;width:100%;font-size:12px;text-align:center;" cellpadding="1px;" cellspacing="1px;">
    <%
    ClubUtil util = new ClubUtil();
    List TeamList = util.getTeamList(club.getId(),"1");
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
		List IdentityOptions = CEditConst.getIdentityOptions(userInfo);
		List GradeNameOptions = CEditConst.getGradeNameOptions(userInfo);
		List DutyOPtions = util.getMemberDutyOptions();
		List tids = new ArrayList();
		if (TeamList.size()>0) {
			for(int i=0;i<TeamList.size();i++) {
				ClubMembers m = new ClubMembers();
				m = (ClubMembers)TeamList.get(i);
				tids.add((i+1)+"");
				%>
				<tr id=del<%=i+1 %> class=odd>
				<td style="width: 10%">
				<input style="width: 100%" id="Id_t<%=i+1%>" name="Id_t<%=i+1%>" value="<%=m.getId()%>" type="hidden"/>
				<input style="width: 100%" id="Sno_t<%=i+1%>" name="Sno_t<%=i+1%>" value="<%=m.getMemberSno()%>"/>
				</td>
				<td style="width: 10%">
				<input style="width: 100%" id="SName_t<%=i+1%>" name="SName_t<%=i+1%>" value="<%=m.getMemberName()%>"/>
				</td>
				<td style="width: 10%">
				<select id="Sex_t<%=i+1%>" name="Sex_t<%=i+1%>" style="width: 100%">
				<%=HtmlTool.renderMulSelectOption(sexOptions,""+m.getMemberSex(),"Sex_t"+(i+1)) %>
				</select>
				<%-- <input style="width: 100%" id="Sex_t<%=m.getId()%>" name="Sex_t<%=m.getId()%>" value="<%=m.getSex()%>"/> --%>
				</td>
				<td style="width: 10%">
				<select id="Academy_t<%=i+1%>" name="Academy_t<%=i+1%>" style="width: 100%">
				<%=HtmlTool.renderMulSelectOption(AcademyNameOptions,""+m.getMemberAcademy(),"Academy_t"+(i+1)) %>
				</select>
				</td>
				<td style="width: 10%">
				<select id="Identity_t<%=m.getId()%>" name="Identity_t<%=m.getId()%>" style="width: 100%">
				<%=HtmlTool.renderMulSelectOption(IdentityOptions,""+m.getIdentity(),"Identity_t"+(i+1)) %>
				</select>
				</td>
				<td style="width: 10%">
				<select id="Grade_t<%=m.getId()%>" name="Grade_t<%=m.getId()%>"  style="width: 100%">
				<%=HtmlTool.renderMulSelectOption(GradeNameOptions,""+m.getMemberGrade(),"Grade_t"+(i+1)) %>
				</select>
				</td>
				<td style="width: 10%">
				<input style="width: 100%" id="Phone_t<%=i+1%>" name="Phone_t<%=(i+1)%>" value="<%=m.getMemberPhone() %>"/>
				</td>
				<td style="width: 10%">
				<select id="Duty_t<%=i+1%>" name="Duty_t<%=i+1%>"  style="width: 100%">
				<%=HtmlTool.renderMulSelectOption(DutyOPtions,""+m.getMemberDuty(),"Duty_t"+(i+1)) %>
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
	Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);
	Map sexMap = CEditConst.getsexMap(userInfo);
	Map GradeNameMap = CEditConst.getGradeNameMap(userInfo);
	Map AcademyNameMap= CEditConst.getAcademyNameMap(userInfo);
	List sidsList = new ArrayList();
	if (club.getId()!=-1) {
		ClubMembers member = new ClubMembers();		
		List list = new ArrayList();
		list = util.getTeamList(club.getId(),"0");
		if (list.size()>0) {
			for (int i=0;i<list.size();i++) {
				//}
				member = (ClubMembers)list.get(i);
				sidsList.add(member.getMemberName()+"");
				%>
				<tr id="deleteSponsor_<%=member.getMemberName()%>">
				<input id="SName<%=member.getMemberName()%>" name="SName<%=member.getMemberName()%>" value="<%=member.getMemberName()%>" type="hidden"/>
				<td style="width: 10%"><%=member.getMemberSno()%></td>
				<td style="width: 10%"><%=UserCnNameMap.get(member.getMemberName())==null?"":UserCnNameMap.get(member.getMemberName()) %></td>
				<td style="width: 10%"><%=sexMap.get(member.getMemberSex())==null?"":sexMap.get(member.getMemberSex()) %></td>
				<td style="width: 10%"><%=AcademyNameMap.get(member.getMemberAcademy())==null?"":AcademyNameMap.get(member.getMemberAcademy()) %></td>
				<td style="width: 10%"><input type="hidden" id="Identity<%=member.getMemberName()%>" name="Identity<%=member.getMemberName()%>" value="1"/>本科</td>
				<td style="width: 10%"><%=GradeNameMap.get(member.getMemberGrade())==null?"":GradeNameMap.get(member.getMemberGrade()) %></td>
				<td style="width: 10%"><input style="width: 100%" id="Phone<%=member.getMemberName()%>" name="Phone<%=member.getMemberName()%>" value="<%=member.getMemberPhone() %>"/></td>
				<td style="width: 10%">
				<select id="Duty<%=member.getMemberName()%>" name="Duty<%=member.getMemberName()%>" style="width: 100%">
				<%=HtmlTool.renderMulSelectOption(DutyOPtions,""+member.getMemberDuty(),"Duty"+member.getMemberName()) %>
				</select>
				</td>
				<td style="width: 10%">
				<img style="cursor:point;" src='<%=HeadConst.apache_url%>/main/images/delete.gif' onclick="javascript:deleteSponsor('deleteSponsor_<%=member.getMemberName() %>','<%=member.getMemberName() %>')" alt='删除' title='删除' border=0 />
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
<tr height="35"><td colspan="4" class="blocktitle">成立社团的可行性、必要性论证</td></tr>
	<tr>
	     <td  colspan="4" align="center"><textarea name="Feasibility"  maxlength="1000" cols="150" rows="10"><%=club.getFeasibility() %></textarea></td>
	</tr>
<tr height="35"><td colspan="4" class="blocktitle">附件上传</td></tr>
<input type="hidden" name="AddFileList" id="AddFileList" value="<%=club.getAddFileList()%>"/>
<input type="hidden" name="Id" id="Id"value="<%=club.getId()%>"/>
<tr id="postFormBookedBooths">
	<td class="form_label"  width="14%" >
	<div align="right">相关附件：</div>
	</td>
		<td bgcolor="#FFFFFF" colspan="3" align="left">
		<table width="100%" border="0" cellspacing="0" id="ShowFiles">
			<%
				if(club.getId()!=-1){
					ClientAttach ca = new ClientAttach();
					//ca.setDataBase("sdtw");
					String ids = club.getAddFileList();
					if(ids!=null&&ids.trim().length()>0){
						String[] idArray = Tool.split(",",ids);
						for(int i=0;i<idArray.length;i++){
							ClientAttach ca1 = ca.getById(Tool.StrToInt(idArray[i]));
							if(ca1!=null){
								%>
								<tr id="<%=ca1.getId() %>"><td><a href="<%=HeadConst.apache_url %>/servlet/attach?type=otherattach&id=<%=ca1.getId() %>" target="_blank">
								<img src='<%=HeadConst.apache_url%>/main/images/file1.gif' border="0"/> <%=ca1.getUploadName() %></a>&nbsp;&nbsp;&nbsp;&nbsp;
								<img src='<%=HeadConst.apache_url%>/main/images/delete.gif' alt='删除' title='删除' border="0" onclick="javascript:deleteUpdateFile('<%=ca1.getUploadName()%>','<%=ca1.getId() %>')" style="cursor:point;"/></td></tr>
								<%	}
								}
							}
						}
					%>
		</table>
		<%if(club.getId()==-1||"update".equals(cmd)){%>
		<input type="file" name="OtherAttach" id="OtherAttach" size="40"/> 
		<input type="button" value="上传" id="btn_up"  onclick="checkFileType();" class="formbtn" style="color:black;background-color: #e3e5e8;"/>
		<%} %>
		<img style="display:none" id="load1" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
	    <div style="color:red">请上传doc、docx、xlsx或xls格式文件，文件最大5M</div>
	</td>
</tr>
<!-- <tr>
	<td align="right" >&nbsp;指导老师情况：</td>
    <td align="left" colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  align="right">&nbsp;拟任会长：</td>
    <td align="left" colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  align="right">&nbsp;拟任团支书：</td>
    <td align="left" colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  align="right">&nbsp;拟任财务负责人：</td>
    <td align="left" colspan="3">&nbsp;</td>
</tr> -->

	<tr height="35"><td colspan="4" class="blocktitle">审查意见</td></tr>
	<tr>
	     <td  align="right">&nbsp;<font color="red">*&nbsp;</font>指导教师意见：</td>
	     <td  colspan="3" align="left"><textarea name="CommentTea"  maxlength="200" cols="130" rows="4"><%=club.getCommentTea() %></textarea></td>
	</tr> 
	<%
if(SdtwConst.CHECKFLAG_XYTG.equals(club.getCheckFlag())||SdtwConst.CHECKFLAG_XYWTG.equals(club.getCheckFlag())||SdtwConst.CHECKFLAG_XXTG.equals(club.getCheckFlag())||SdtwConst.CHECKFLAG_XXWTG.equals(club.getCheckFlag())){%> 
<tr height="35"><td colspan="4" class="blocktitle">学院审核意见</td></tr>
<tr>
	     <td  align="right">&nbsp;学院意见：</td>
	     <td  colspan="3" align="left"><%=club.getCommentAcademy() %></td>
</tr> 
<%} %>
<%
if(SdtwConst.CHECKFLAG_XXTG.equals(club.getCheckFlag())||SdtwConst.CHECKFLAG_XXWTG.equals(club.getCheckFlag())){
%>
<tr height="35"><td colspan="4" class="blocktitle">团委审核意见</td></tr>
<tr>
	     <td  align="right">&nbsp;团委意见：</td>
	     <td  colspan="3" align="left"><%=club.getCommenttw() %></td>
</tr> 
<%}
%>
<tr>
    <th  colspan="4" align="center">
    <%
    if("view".equals(cmd)||"viewlist".equals(cmd)){%>
    	<a href="#" onclick="formcancel('<%=backurl+"?active="+active%>')" >返回</a>
    <%}else{%>
        <input type="button" class="button" value="确定" name="btn1" onclick="formsubmit()">&nbsp;&nbsp;&nbsp;
        <input type="button" class="button" value="取消" name="btn2" onclick=" formcancel('<%=backurl+"?active="+active%>')">&nbsp;&nbsp;&nbsp;
    <%}
    %>
    </th>
</tr> 
</table>
</form>
<!-- <script src="../js/jquery.editable-1.0.1.js"></script> -->
</body>
</html>
