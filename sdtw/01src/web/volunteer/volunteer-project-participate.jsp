<%@page import="com.xietong.software.sdtw.db.VolunteerProjectParticipate"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.base.Power"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@page import="com.xietong.software.sdtw.db.*"%>
<%
UserInfo userinfo = Tool.getUserInfo(request);
if(!userinfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	if (userinfo != null) {
		userinfo.removeCookie(response);
	}
	session.removeAttribute("UserInfo");
	return ;
}
List cdt1 = new ArrayList();
List zhengzhi=CEditConst.getPoliticsNameOptions(userinfo,"");
List AssLeveloptions=CEditConst.getAssLevelOptions(userinfo);
BaseUserCode user=userinfo.getUserCode();
String sno=user.getName();
String projectId=ParamUtils.getParameter(request, "ProjectId", "");
String projectname="",teamcode="",teamname="",teamunit=user.getDeptId()+"",registerid="",setuptime="",zipcode="",contactaddress="",insepctionconclution="";
String asslevel="",starttime="",projectarea="",implearea="",award="",majorid="",guideteacherid="",teammemberslist="";
String majorvolslist="",content="",meanings="",disiredresults="",impleplace="",promotion="",specialist="",beneficaiaries="",checkcomments="";
String majorname="",majorsex="",majorbirth="",majorduty="",majorpolista="",majorphone="",majorphone2="",majoremail="";
String dutyfree="",guideteachername="",guideteachersex="",guideteacherbirth="",guideteacherduty="",guideteacherpolista="",guideteacherphone="",guideteacherphone2="",guideteacheremail="";
int participatenum=0,fulltimenum=0,majorkind=0,benenum=0,edittype=0;
String addfilelist = "";
String url="VolunteerProjectParticipateAction.jsp?cmd=save1";
String[] labelclass = {"labeloff", "labeloff", "labeloff", "labeloff"};
List list = new ArrayList();
List cdt = new ArrayList();
VolunteerProjectParticipate vpp= new VolunteerProjectParticipate();
cdt.add("projectid="+projectId);
cdt.add("sno='"+sno+"'");
list =vpp.query(cdt);

if(list.size()>0){
	url="VolunteerProjectParticipateAction.jsp?cmd=modify2";
	
	System.out.println("111111111111111111111111");
	vpp=(VolunteerProjectParticipate)list.get(0);
	zipcode=vpp.getZipCode();
	projectname=vpp.getProjectName();
	teamname=vpp.getTeamName();
	
	teamunit=vpp.getTeamUnit();
	registerid=vpp.getRegisterId();
	setuptime=Tool.stringOfDate(vpp.getSetupTime());
	contactaddress=vpp.getContactAddress();
	insepctionconclution=vpp.getInspectionConclution();
	projectarea=vpp.getProjectArea();award=vpp.getAward();guideteacherid=vpp.getGuideTeacherName();
	content=vpp.getContent();meanings=vpp.getMeanings();disiredresults=vpp.getDisiredResults();
	impleplace=vpp.getImplePlace();promotion=vpp.getPromotion();specialist=vpp.getSpecialist();beneficaiaries=vpp.getBeneFicaiaries();checkcomments=vpp.getCheckComments();
	majorname=vpp.getMajorName();majorsex=vpp.getMajorSex();majorphone=vpp.getMajorPhone();majoremail=vpp.getMajorEmail();
	dutyfree=vpp.getDutyFree();guideteachername=vpp.getGuideTeacherName();guideteacherphone=vpp.getGuideTeacherPhone();guideteacheremail=vpp.getGuiderTeacherEmail();
	participatenum=vpp.getParticipateNum();fulltimenum=vpp.getFulltimeNum();benenum=vpp.getBenenum();
	asslevel=vpp.getAssLevel();starttime=Tool.stringOfDate(vpp.getStartTime());implearea=vpp.getImpleArea();
	majorbirth=vpp.getMajorBirth();majorduty=vpp.getMajorDuty();majorpolista=vpp.getMajorPolista();majorphone2=vpp.getMajorPhone2();
	guideteachersex=vpp.getGuideTeacherSex();guideteacherbirth=vpp.getGuideTeacherBirth();guideteacherduty=vpp.getGuideTeacherDuty();guideteacherpolista=vpp.getGuideTeacherPolista();
	guideteacherphone2=vpp.getGuideTeacherPhone2();meanings=vpp.getMeanings();
}

%>
<%String cmd = ParamUtils.getParameter(request,"cmd",""); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include page="/main/jqueryui.jsp" flush="true"/>
<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/chosen/chosen.css" rel="stylesheet"/>
		<script language="javascript" src="<%=HeadConst.apache_url+"/main/" %>/js/chosen/chosen.jquery.js"></script>
<link rel="stylesheet" type="text/css" href="../css/common-student.css">
<script src="../main/js/common.js"></script>
<script src="../js/tablelist.js"></script>
<link rel="stylesheet" href="../css/jqueryUI/jquery-ui.css">

<script language="JavaScript" src="../main/js/ajaxfileupload.js"></script>
<script language="JavaScript"
			src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
<script type="text/javascript">
 function f(){
	this.start = function(){
		var tables = document.getElementsByTagName("tbody");
		for (var i=0;i<tables.length;i++){			
			rows(tables[i]);
		};
	};
	
	this.rows = function(table){
		var css = "";
		var tr = table.getElementsByTagName("tr");
		for (var i=0;i<tr.length;i++){
			css = (css == "odd") ? "even" : "odd";
			tr[i].className = css;	
		};
	};
	
	start();
	
};


window.onload=function(){ 
	
	f();
	$("#baseinfo").attr("style","display:block");
	$("#teaminfo").attr("style","display:none");
	$("#otherinfo").attr("style","display:none");
	$("#fileinfo").attr("style","display:none");
	$("#base").attr("class","labelon");
	$("#team").attr("class","labeloff");
	$("#other").attr("class","labeloff");
	$("#file").attr("class","labeloff");	
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
            url:'VolunteerProjectParticipateAction.jsp?cmd=otherattach',
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
                        	var addfile=document.form1.AddFileList.value;
                        
                         	if(addfile==""){
                         		document.form1.AddFileList.value=data.ids;
                         	
                         	}else{
                         		document.form1.AddFileList.value= data.ids+","+addfile;
                         	}
                         	
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
function getInfo(){
	//获取团队成员信息


	return true;
}
function addItem(){

openWindow("BaseUserCodeAction.jsp?values="+$("#SId").val(),"703,400");


}
function setRole(pName,pId){
	$("#teamtable").append(pName);
	$("#SId").val(pId);
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
        				
        				var files = document.form1.AddFileList.value;
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
        					document.form1.AddFileList.value = files;
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
	var files = document.form1.SId.value;
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
		document.form1.SId.value = files;
	}
}
</script>
<style type="text/css" media="screen">

.oneitem {
	width:350px;
	padding:2px 6px 2px 6px;
	background:#FFF;
}
.oneitem_out {
	width:350px;
	background-color:#FFFFFF;
	padding:2px 6px 2px 6px;
}
.oneitem_over {
	width:350px;
	background-color:#E8F2FE;
	padding:2px 6px 2px 6px;
}
</style>
</head>
<body>
<form name="form1" method="post" action="<%= url%>">
<%
List zhuguanoptions=CEditConst.getAcademyNameOptions(userinfo,"");
List shifouoptions=CEditConst.getYesNoOptions(userinfo);
String strposition = "志愿服务工作>>竞赛项目管理>>";
String strfunction = "竞赛项目申请信息";
String strhelpwords = "负责志愿竞赛项目的添加、修改、删除以及审核工作，点击竞赛项目名称的超链接可以进入相应的竞赛项目审核管理的界面。";
%>
 <table class="location-table">
<tr height="35">
<%
VolunteerProject  vp= new VolunteerProject();
vp= vp.getById(Integer.parseInt(projectId));
%>
	<td class="location-title" >您的位置>>志愿服务>>志愿竞赛>><%=vp.getProjectName() %>申请
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>
<table class="command-table">
<tr>
      <td><a href="volunteer-project-list.jsp" >返回</a></td>
</tr>
</table>

<table class="tabs-table">
<tr>
      <td id = "base"  class="<%=labelclass[0]%>"width="60" align="center" onclick="infoshow(1)" >基本信息</td>
      <td id = "team" class="<%=labelclass[1]%>" width="60" align="center" onclick="infoshow(2)" >人员信息</td>
      <td id = "other" class="<%=labelclass[2]%>" width="60" align="center" onclick="infoshow(3)" >其他信息</td>
      <td id = "file"class="<%=labelclass[3]%>" width="60" align="center" onclick="infoshow(4)" >文件上传</td>
</tr>
</table>



<table class="content-table">
<tr>
	<th colspan="5" align="left">竞赛项目申请信息</th>
</tr>
<tbody id="baseinfo" style="display:block">
<tr>
   		<td width="15%" align="right">&nbsp;<font color="red">*&nbsp;</font>项目名称：</td>
   		<td width="50%" align="left"><input type="text" name="ProjectName"  maxlength="20" size="50" value="<%=projectname%>"></td>
   		<td align="left">请输入项目全称。</td>
</tr>
<tr>
   		<td align="right">&nbsp;<font color="red">*&nbsp;</font>团队名称：</td>
   		<td align="left"><input type="text" name="TeamName"  maxlength="20" size="50" value="<%=teamname%>"></td>
   		<td align="left">请填写组织全称，已登记注册的以注册名称为准</td>
</tr>
<tr>
   		<td align="right" >&nbsp;<font color="red">*&nbsp;</font>团队主管单位：</td>
   		<td align="left"><%=HtmlTool.renderSelect(zhuguanoptions, "" + teamunit, "TeamUnit", "-1")%></td></td>
   		<td align="left">学院团委或者校级学生组织</td>
</tr>
<tr>
   		<td align="right">&nbsp;<font color="red">*&nbsp;</font>登记证号：</td>
   		<td align="left"><input type="text" name="RegisterId"  maxlength="20" size="5" value="<%=registerid%>">
   		&nbsp;成立时间：
   		
   		<input readonly class="date" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd ',minDate:'',onpicked:function(){}})"  name="SetupTime" id="SetupTime" size="0" value="<%=setuptime%>">
   		&nbsp;邮政编码：
   		<input type="text" name="ZipCode"  maxlength="20" size="10" value="<%=zipcode%>">
   		</td>
   		<td align="left">登记证号如没有可填“无”</td>
</tr>
<tr>
   		<td align="right">&nbsp;<font color="red">*&nbsp;</font>通讯地址：</td>
   		<td align="left"><input type="text" name="ContactAddress"  maxlength="20" size="50" value="<%=contactaddress%>"></td>
   		<td align="left">通讯地址</td>
</tr>
<tr>
   		<td align="right" >&nbsp;<font color="red">*&nbsp;</font>年度年检结论：</td>
   		<td align="left"><input type="text" name="InspectionConclution"  maxlength="20" size="18" value="<%=insepctionconclution%>">
   		&nbsp;&nbsp;评估等级：
   	
   		<%=HtmlTool.renderSelect(AssLeveloptions, asslevel, "AssLevel", "")%>
   		</td>
   		<td align="left">年检结论如没有，请填“无”，评估等级格式：xxxx年-评估等级（ABCD）</td>
</tr>
<tr>
   		<td align="right" >&nbsp;<font color="red">*&nbsp;</font>有无免税资格：</td>
   		<td align="left"><%=HtmlTool.renderSelect(shifouoptions, "" +dutyfree, "DutyFree", "-1")%>
   		&nbsp;&nbsp;&nbsp;项目实施时间：
   		
   		<input readonly class="date" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd ',onpicked:function(){}})"  name="StartTime" id="StartTime" size="0" value="<%=starttime%>">
   		</td>
   		<td align="left">免税资格填写：有/无</td>
</tr>
<tr>
   		<td align="right" >&nbsp;<font color="red">*&nbsp;</font>项目领域：</td>
   		<td align="left"><input type="text" name="ProjectArea" maxlength="20" size="18" value="<%=projectarea%>">
   			
   		
<!-- 							<input type="radio" name="projectarea" value="阳光助残">阳光助残&nbsp;&nbsp;&nbsp;<br> -->
<!-- 			                 <input type="radio" name="projectarea" value="关爱农民工子女">关爱农民工子女&nbsp;&nbsp;&nbsp;<br> -->
<!-- 			                 <input type="radio" name="projectarea" value="邻里守望与为老服务">邻里守望与为老服务&nbsp;&nbsp;&nbsp;<br> -->
<!-- 			                 <input type="radio" name="projectarea" value="环境保护与节水护水">环境保护与节水护水&nbsp;&nbsp;&nbsp;<br> -->
<!-- 			                 <input type="radio" name="projectarea" value="扶贫开发与应急救援">扶贫开发与应急救援&nbsp;&nbsp;&nbsp;<br> -->
<!-- 			                 <input type="radio" name="projectarea" value="文化宣传与网络文明">文化宣传与网络文明&nbsp;&nbsp;&nbsp;<br> -->
<!-- 			                 <input type="radio" name="projectarea" value="禁毒教育与法律服务">禁毒教育与法律服务&nbsp;&nbsp;&nbsp;<br> -->
<!-- 			                 <input type="radio" name="projectarea" value="理论研究与基础建设">理论研究与基础建设&nbsp;&nbsp;&nbsp;<br> -->
<!-- 			                 <input type="radio" name="projectarea" value="其它领域">其它领域 -->
   		<td align="left">请填写项目明确参赛类别</td>
</tr>
<tr>
   		<td align="right" >&nbsp;<font color="red">*&nbsp;</font>实施地域：</td>
   		<td align="left"><input type="text" name="ImpleArea"  maxlength="20" size="50" value="<%=implearea%>"></td>
   		<td align="left">具体到XX省XX市XX区</td>
</tr>
<tr>
   		<td align="right" >&nbsp;<font color="red">*&nbsp;</font>参与项目运作人数：</td>
   		<td align="left">
   			<input type="number" name="ParticipateNum"  maxlength="20" size="20" value="<%=participatenum%>">
   			&nbsp;&nbsp;&nbsp;专职人员人数：
   			<input type="number" name="FulltimeNum"  maxlength="10" size="13" value="<%=fulltimenum%>">
   		</td>
   		<td align="left">请填写项目运作人数和专职人员人数</td>
</tr>
<tr>
   		<td align="right" >&nbsp;<font color="red">*&nbsp;</font>曾获何种奖励：</td>
   		<td align="left"><textarea name="Award" rows="8" cols="100" ><%=award%></textarea></td>
   		<td align="left">填写校级以上荣誉</td>
</tr>
</tbody>

<tbody id="teaminfo" style="display:none">
<tr>
   		<td  width="25%"align="right" >&nbsp;<font color="red">*&nbsp;</font>项目负责人：</td>
   		<td align="left">
   			<p>姓名：<input type="text" name="MajorName"  value="<%=majorname%>"></p>
   		
   		    <p>工作单位及职务：<input  type="text" name="MajorDuty"  value="<%=majorduty%>"></p>
   		    <p>政治面貌： <%=HtmlTool.renderSelect(zhengzhi,majorpolista, "MajorPolista", "")%></p>
   			<p>办公电话：<input type="text" name="MajorPhone"   value="<%=majorphone%>"></p>
 			<p>手机：<input type="text" name="MajorPhone2"   value="<%=majorphone2%>"></p>
   			<p>电子邮箱：<input size="45" type="text" name="MajorEmail"  value="<%=majoremail%>"></p>
   		</td>
   		<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学生的工作单位及职务填写学院、年级、专业，办公电话为：区号+号码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
</tr>
<tr>
   		<td align="right" >&nbsp;<font color="red">*&nbsp;</font>项目指导教师：</td>
   		<td align="left">
   			<p>姓名：<input type="text" name="GuideTeacherName" value="<%=guideteachername%>"></p>
   			
   			<p>工作单位及职务：<input type="text" name="GuideTeacherDuty"  value="<%=guideteacherduty%>"></p>
   			<p>政治面貌： <%=HtmlTool.renderSelect(zhengzhi,guideteacherpolista, "GuideTeacherPolista", "")%></p>
   			<p>办公电话：<input type="text" name="GuideTeacherPhone"  value="<%=guideteacherphone%>"></p>
   			<p>手机：<input type="text" name="GuideTeacherPhone2"  value="<%=guideteacherphone2%>"></p>
   			<p>电子邮箱：<input size="45" type="text" name="GuiderTeacherEmail"  value="<%=guideteacheremail%>"></p>
   		</td>
   		<td align="left">办公电话为：区号+号码</td>
</tr>


<%-- <tr>
   		<td align="right">&nbsp;<font color="red">&nbsp;</font>项目主要人员：</td>
   		<td align="left"><p id="teammembersshow"></p>
   		                 <a id="teammembersadd" href="#" onclick="teammembersadd();return false;" style="display:block">添加</a>
   		                 <a id="teammemberscancel" href="#" onclick="teammemberscancel();return false;" style="display:none">取消</a>
   		                 </td>
   		<td align="left">请添加该学习项目的参与人员。</td>
</tr>
<tr id="teammemberslist" style="display:none">
<td  align="right">按学号查询：</td>
   <td width="40%" align="left">
     
      <%=HtmlTool.renderSelect(UserCnNameoptions, "", "search", "")%>
                 团队职务：
      <input type="text" name="teamduty" id="teamduty" maxlength="20" size="10" value="暂无">
      <a href="#" onclick="searchadd();return false;">添加</a>
    <br>
	<div id="searchdiv" style="z-index:99;"></div>
    </td>
   <td align="left">请输入学号然后点击添加按钮添加对应学生信息。</td>
</tr>




<tr>
   		<td align="right">&nbsp;<font color="red">&nbsp;</font>项目主要志愿者：</td>
   		<td align="left"><p id="majorvolsshow"></p>
   		                 <a id="majorvolsadd" href="#" onclick="majorvolsadd();return false;" style="display:block">添加</a>
   		                 <a id="majorvolscancel" href="#" onclick="majorvolscancel();return false;" style="display:none">取消</a>
   		                 </td>
   		<td align="left">请添加该志愿项目的志愿者。</td>
</tr> --%>
<tr>
	<td align="right"><p>项目主要人员<p/><a href="#" onclick="addItem();return false;">添加</a></td>
	<td align="left" colspan="2">
	     <table class="content-table" width="100%" border="0" cellspacing="0" id="teamtable">
        	<tr><td>学号</td><td>姓名</td><td>院系</td><td>联系电话</td><td>职务</td><td></td></tr>
		<%
		String snoids="";
		if(vpp.getId()!=-1){
			VolunteerProjectTeammember vpt= new VolunteerProjectTeammember();
			List list2= new ArrayList();
			List cdt2= new ArrayList();
			List snoidlist= new ArrayList();
			List dutylist=new ArrayList();
			List phonelist=new ArrayList();
			String vppid= vpp.getId()+"";
			cdt2.add("projectparticipateid="+vppid);
			cdt2.add("order by id ");
			list2= vpt.query(cdt2);
			
			if(list2.size()>0){
				for(int i=0;i<list2.size();i++){
					vpt=(VolunteerProjectTeammember)list2.get(i);
					snoidlist.add(vpt.getSno());
					 dutylist.add(vpt.getDuty());
					 phonelist.add(vpt.getName());
				}
			}
		snoids=Tool.join(",", snoidlist);
		System.out.println(snoids+"sssssssssssssssssss");
			BaseUserCode stu= new BaseUserCode();
			List list3= new ArrayList();
			List cdt3= new ArrayList();
			cdt3.add("id in ("+snoids+")");
			String xueyuan="";
			String duty="";
			list3=stu.query(cdt3);
			if(list3.size()>0){
				for(int i=0;i<list3.size();i++){
				stu = (BaseUserCode)list3.get(i)	;
				 xueyuan=(String)CEditConst.getAcademyNameMap(userinfo).get(stu.getDeptId()+"");
				 duty=((String)dutylist.get(i)).equals("-1")?"":(String)dutylist.get(i);
				%>
				<tr id='deleteSponsor_<%=stu.getId()%>'><td><%=stu.getName() %></td><td><%=stu.getCnName() %></td><td><%=xueyuan %></td><td><input size='10' name='phone<%=i %>' value="<%=(String)phonelist.get(i) %>" /></td><td><input size='10' name='zhiwu<%=i %>' value="<%=duty %>" /></td><td><img style="cursor:point;" src='<%=HeadConst.apache_url%>/main/images/delete.gif' onclick="javascript:deleteSponsor('deleteSponsor_<%=stu.getId() %>','<%=stu.getId() %>')" alt='删除' title='删除' border=0 /></td></tr>
				<% 
				}
			}
		}
		
		%>	
		

		</table>
           <input type="hidden"  name="SId" id="SId" value="<%=snoids%>"/>
		<input type="hidden"  name="GuideTeacherBirth" value="<%=guideteacherbirth%>"/>
	</td>
</tr>

<%
//SELECT strSearchField FROM strSearchTable WHERE strSearchWhere AND 模糊匹配条件
String strSearchTable = "students";
//在strSearchField的多个字段同时实现对input的输入进行模糊查询，可有一个或多个查询条件
String strSearchField = "sno,sname,ssex";
//没有条件时写默认1=1，如果要查询的数据需要一定的限制时，在此写限制条件，该条件与输入框中的条件模糊查询
String strSearchWhere = "1=1"; 
//查询结果的展示，必须是strSearchField的子集构成
String strShow = "r.sno + '|'+ r.sname + '|'+ r.ssex";
%>
</tbody>
<tbody id="otherinfo" style="display:none">
<tr>
   		<td width="15%" align="right">&nbsp;<font color="red">&nbsp;</font>项目内容：</td>
   		<td width="50%" align="left"><textarea name="Content" cols="100" rows="4"><%=content%></textarea></td>
   		<td align="left">100字以内。</td>
</tr>
<tr>
   		<td align="right">&nbsp;<font color="red">&nbsp;</font>项目背景意义：</td>
   		<td align="left"><textarea name="Meanings" cols="100" rows="4"><%=meanings%></textarea></td>
   		<td align="left">100字以内。</td>
</tr>
<tr>
   		<td align="right">&nbsp;<font color="red">&nbsp;</font>预计效果：</td>
   		<td align="left"><textarea name="DisiredResults" cols="100" rows="4"><%=disiredresults%></textarea></td>
   		<td align="left">受益群体、范围、人数，产生的社会效益等，100字以内。</td>
</tr>
<tr>
   		<td align="right">&nbsp;<font color="red">&nbsp;</font>项目实施地点：</td>
   		<td align="left"><textarea name="ImplePlace" cols="100" rows="4"><%=impleplace%></textarea></td>
   		<td align="left">精确到具体单位，100字以内。</td>
</tr>
<tr>
   		<td align="right">&nbsp;<font color="red">&nbsp;</font>项目宣传方案：</td>
   		<td align="left"><textarea name="Promotion" cols="100" rows="4"><%=promotion%></textarea></td>
   		<td align="left">创新性、示范性、可推广性，100字以内。</td>
</tr>
<tr>
   		<td align="right">&nbsp;<font color="red">&nbsp;</font>项目特色：</td>
   		<td align="left"><textarea name="Specialist" cols="100" rows="4"><%=specialist%></textarea></td>
   		<td align="left">100字以内。</td>
</tr>
<tr>
   		<td align="right" >&nbsp;<font color="red">*&nbsp;</font>受益对象：</td>
   		<td align="left"><input type="text" name="BeneFicaiaries"  maxlength="20" size="50" value="<%=beneficaiaries%>">
   		&nbsp;&nbsp;&nbsp;预计直接受益人数：
   		<input type="number" name="Benenum"  maxlength="10" size="5" value="<%=benenum%>">人
   		</td>
   		<td align="left">请填写项目运作人数和专职人员人数</td>
</tr>
<tr>
   		<td align="right">&nbsp;<font color="red">&nbsp;</font>学院团委、校级学生组织审批意见：</td>
   		<td align="left" ><%=checkcomments%></td>
   		<td></td>
</tr>
</tbody>
<%if(vpp.getProjectName()!=""){ %>

<input type="hidden" name="Id" value="<%=vpp.getId()%>">
<%} %>
<input type="hidden" name="CheckFlag" value="">
  <input type="hidden" name="CheckFlag" value="">
    <input type="hidden" name="Academy" value="<%= user.getDeptId()%>">
  <input type="hidden" name="Sno" value="<%=sno%>">
   <input type="hidden" name="ProjectId" value="<%=projectId%>">
  <input type="hidden" name="page" value="">
  <input type="hidden" name="teamcode" value="<%=teamcode%>">
  <input type="hidden"  name="AddFileList" >
  <input type="hidden" name="edittype" value="<%=edittype%>">
  <input type="hidden" name="teammemberslist" value="">
  <input type="hidden" name="majorvolslist" value="">
</form>
<tbody id="fileinfo" style="display:none">
<%
String filepath = "/datafile/volunteer_project/";
String filenamecode = "";
String moduleapp = "../role-tuanwei/volunteer-project-list.jsp";
String mytip="";
%>

			

<input type="hidden" name="Id" id="Id"value="<%=vpp.getId()%>"/>
<tr id="postFormBookedBooths" >
<td  class="blocktitle">附件上传</td>
	<td class="form_label"  width="10%" >
	<div style="width: 150px" align="right">相关附件：</div>
	</td>
		<td  bgcolor="#FFFFFF"   align="left">
		<table width="100%"  border="0" cellspacing="0" id="ShowFiles">
			<%
				if(vpp.getId()!=-1){
					ClientAttach ca = new ClientAttach();
					//ca.setDataBase("sdtw");
					String ids = vpp.getAddFileList();
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
		
		<input type="file" name="OtherAttach" id="OtherAttach" size="40"/> 
		<input type="button" value="上传" id="btn_up"  onclick="checkFileType();" class="formbtn" style="color:black;background-color: #e3e5e8;"/>
	
		<img style="display:none" id="load1" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
	    <div style="color:red">请上传doc、docx、xlsx或xls格式文件，文件最大5M</div>
	</td>
</tr>
</tbody>
<tr>
  <th colspan="6" align="center">
    <input type="button" value="保存" name="btn1" onclick="form1submit()" class="button">&nbsp;&nbsp;&nbsp;
    <input type="button" value="取消" name="btn2" onclick="history.go(-1)" class="button">&nbsp;&nbsp;&nbsp;
  </th>
</tr>
</table>

<script type="text/javascript">

function infoshow(val)
{
	switch(val)
	{
		case 1:
			$("#baseinfo").attr("style","display:block");
			$("#teaminfo").attr("style","display:none");
			$("#otherinfo").attr("style","display:none");
			$("#fileinfo").attr("style","display:none");
			$("#base").attr("class","labelon");
			$("#team").attr("class","labeloff");
			$("#other").attr("class","labeloff");
			$("#file").attr("class","labeloff");
			break;
		case 2:
			$("#baseinfo").attr("style","display:none");
			$("#teaminfo").attr("style","display:block");
			$("#otherinfo").attr("style","display:none");
			$("#fileinfo").attr("style","display:none");
			$("#base").attr("class","labeloff");
			$("#team").attr("class","labelon");
			$("#other").attr("class","labeloff");
			$("#file").attr("class","labeloff");
			break;
		case 3:
			$("#baseinfo").attr("style","display:none");
			$("#teaminfo").attr("style","display:none");
			$("#otherinfo").attr("style","display:block");
			$("#fileinfo").attr("style","display:none");
			$("#base").attr("class","labeloff");
			$("#team").attr("class","labeloff");
			$("#other").attr("class","labelon");
			$("#file").attr("class","labeloff");
			break;
		default:
			$("#baseinfo").attr("style","display:none");
			$("#teaminfo").attr("style","display:none");
			$("#otherinfo").attr("style","display:none");
			$("#fileinfo").attr("style","display:block");
			$("#base").attr("class","labeloff");
			$("#team").attr("class","labeloff");
			$("#other").attr("class","labeloff");
			$("#file").attr("class","labelon");
			
	}
}
/////////////////////////////////////////////////////////////////////////////////////////////
///////////////////以下代码是添加项目主要人员和添加项目志愿者的公共函数和代码

$(function(){
	$("#datepicker").datepicker();
	$("#datepicker2").datepicker();
	showinfo();
});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
function form1submit()
{
  // 取form1表单数据,到form99隐藏框
/*   if(!form1datacheck())
  {
    return false;
  } */
<%--   // 取form2表单数据，即iframe中的文件列表,存储已有的附件信息
  var iframestr = document.filelistbox.document.body.innerText;
  if (iframestr.length>0)
  {  
     iframestr = iframestr.substring(0,iframestr.indexOf("#"));
  }
  addfileok(iframestr, "<%=addfilelist%>");
  document.form1.addfilelistnew.value = iframestr;
  // 提交form99数据
  var len=document.form1.elements.length;
  var i;
  for (i=0;i<len;i++)
  {
    document.form1.elements[i].disabled = false;
  }  --%>
  var check=<%=vpp.getXycheckFalg()%>;
 var twcheck=<%=vpp.getCheckFlag()%>
  if(check==1&&twcheck==1){
	  alert("正在审核中，无法修改")
	  return;
  }
 if( form1datacheck()){
  document.form1.submit();
 }
}

function form1datacheck()
{   
	getInfo();
	if (document.form1.ProjectName.value==""){
		alert("项目名称不能为空！");
		document.form1.ProjectName.focus();
		return false;
	}
	if (document.form1.TeamName.value==""){
		alert("团队名称不能为空！");
		document.form1.TeamName.focus();
		return false;
	}
	if (document.form1.TeamUnit.value==""){
		alert("团队主管单位不能为空！");
		document.form1.TeamUnit.focus();
		return false;
	}
	if (document.form1.RegisterId.value==""){
		alert("登记证号不能为空！");
		document.form1.RegisterId.focus();
		return false;
	}
	if (document.form1.SetupTime.value==""){
		alert("成立时间不能为空！");
		document.form1.SetupTime.focus();
		return false;
	}
	if (document.form1.ZipCode.value==""){
		alert("邮政编码不能为空！");
		document.form1.ZipCode.focus();
		return false;
	}
	if (document.form1.ContactAddress.value==""){
		alert("通讯地址不能为空！");
		document.form1.ContactAddress.focus();
		return false;
	}
	if (document.form1.InspectionConclution.value==""){
		alert("年度年检结论不能为空！");
		document.form1.InspectionConclution.focus();
		return false;
	}
	if (document.form1.AssLevel.value==""){
		alert("评估等级不能为空！");
		document.form1.AssLevel.focus();
		return false;
	}
	if (document.form1.DutyFree.value==""){
		alert("有无免税资格不能为空！");
		document.form1.DutyFree.focus();
		return false;
	}
	if (document.form1.StartTime.value==""){
		alert("项目实施时间不能为空！");
		document.form1.StartTime.focus();
		return false;
	}
	if (document.form1.ProjectArea.value==""){
		alert("项目领域不能为空！");
		document.form1.ProjectArea.focus();
		return false;
	}
	if (document.form1.ImpleArea.value==""){
		alert("实施地域不能为空！");
		document.form1.ImpleArea.focus();
		return false;
	}
	if (document.form1.ParticipateNum.value==""){
		alert("参与项目运作人数不能为空！");
		document.form1.ParticipateNum.focus();
		return false;
	}
	if (document.form1.MajorNamevalue==""){
		alert("项目负责人姓名不能为空！");
		document.form1.MajorName.focus();
		return false;
	}

	if (document.form1.MajorDuty.value==""){
		alert("项目负责人职务不能为空！");
		document.form1.MajorDuty.focus();
		return false;
	}
	var myreg3=/^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$)/;
	var myreg1 = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
	var myreg2 = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if (document.form1.MajorPhone2.value==""){
		
		alert("项目负责人手机不能为空！");
		document.form1.MajorPhone2.focus();
		return false;
	}
	if (document.form1.MajorPhone.value==""){
		
		alert("项目负责人办公电话不能为空！");
		document.form1.MajorPhone.focus();
		return false;
	}
if (!myreg3.test(document.form1.MajorPhone.value)){
		
		alert("项目负责人办公电话不合法");
		document.form1.MajorPhone.focus();
		return false;
	}
if (!myreg1.test(document.form1.MajorPhone2.value)){
		
		alert("项目负责人手机号不合法");
		document.form1.MajorPhone2.focus();
		return false;
	}
	if (document.form1.MajorEmail.value==""){
	
		alert("项目负责人邮箱不能为空！");
		document.form1.MajorEmail.focus();
		return false;
	}
	if (!myreg2.test(document.form1.MajorEmail.value)){
		
		alert("项目负责人邮箱不合法！");
		document.form1.MajorEmail.focus();
		return false;
	}
	if (document.form1.GuideTeacherName.value==""){
		alert("项目指导教师姓名不能为空！");
		document.form1.GuideTeacherName.focus();
		return false;
	}

	if (document.form1.GuideTeacherDuty.value==""){
		alert("项目指导教师职务不能为空！");
		document.form1.GuideTeacherDuty.focus();
		return false;
	}

	if (document.form1.GuideTeacherPhone2.value==""){
		alert("项目指导教师手机不能为空！");
		document.form1.GuideTeacherPhone2.focus();
		return false;
	}
	if (document.form1.GuideTeacherPhone.value==""){
		alert("项目指导教师办公电话不能为空！");
		document.form1.GuideTeacherPhone.focus();
		return false;
	}
if (!myreg1.test(document.form1.GuideTeacherPhone2.value)){
		
		alert("项目指导教师手机号不合法");
		document.form1.GuideTeacherPhone2.focus();
		return false;
	}
if (!myreg3.test(document.form1.GuideTeacherPhone.value)){
	
	alert("项目指导教师办公电话不合法");
	document.form1.GuideTeacherPhone.focus();
	return false;
}
	if (document.form1.GuiderTeacherEmail.value==""){
		alert("项目指导教师邮箱不能为空！");
		document.form1.GuiderTeacherEmail.focus();
		return false;
	}
if (!myreg2.test(document.form1.GuiderTeacherEmail.value)){
		
		alert("项目指导教师邮箱不合法！");
		document.form1.GuiderTeacherEmail.focus();
		return false;
	}
	if (document.form1.Content.value==""){
		alert("项目内容不能为空！");
		document.form1.Content.focus();
		return false;
	}
	if (document.form1.Meanings.value==""){
		alert("项目背景意义不能为空！");
		document.form1.Manings.focus();
		return false;
	}
	if (document.form1.DisiredResults.value==""){
		alert("预计效果不能为空！");
		document.form1.DisiredResults.focus();
		return false;
	}
	if (document.form1.ImplePlace.value==""){
		alert("项目实施地点不能为空！");
		document.form1.ImplePlace.focus();
		return false;
	}
	if (document.form1.Promotion.value==""){
		alert("项目宣传方案不能为空！");
		document.form1.Promotion.focus();
		return false;
	}
	if (document.form1.Specialist.value==""){
		alert("项目特色不能为空！");
		document.form1.Specialist.focus();
		return false;
	}
	if (document.form1.BeneFicaiaries.value==""){
		alert("受益对象不能为空！");
		document.form1.BeneFicaiaries.focus();
		return false;
	}
	if (document.form1.Benenum.value==""){
		alert("预计直接收益人数不能为空！");
		document.form1.Benenum.focus();
		return false;
	}
    return true;
}

function showinfo()
{
	var teammemberslist = "<%=teammemberslist%>";
	var majorvolslist = "<%=majorvolslist%>";
	document.form1.teammemberslist.value = teammemberslist;
	document.form1.majorvolslist.value = majorvolslist;
	var radiolen = $("[name='projectarea']").length;

	if(teammemberslist!="")
	{
		var team_array = teammemberslist.split("\20");
		$("#teammemberslist").attr("style","display:block");
		$("#teammembersadd").attr("style","display:none");
		$("#teammemberscancel").attr("style","display:block");
		var showstr = $("#teammembersshow").html();
		for(var i=0;i<team_array.length-1;i++)
		{
			var teaminfo_array = team_array[i].split("\10");
			showstr += teaminfo_array[1] + "  " + teaminfo_array[2] + "  " + teaminfo_array[3] + "  " + teaminfo_array[4] + "  " + teaminfo_array[5] + "  " + teaminfo_array[6] + "&nbsp;&nbsp;<a href='#' onclick='teammembersdel(\""+teaminfo_array[0]+"\")'>删除</a><br>";
		}
		$("#teammembersshow").html(showstr);
	}
	if(majorvolslist!="")
	{
		var vol_array = majorvolslist.split("\20");
		$("#majorvolslist").attr("style","display:block");
		$("#majorvolsadd").attr("style","display:none");
		$("#majorvolscancel").attr("style","display:block");
		var showstr = $("#majorvolsshow").html();
		for(var i=0;i<vol_array.length-1;i++)
		{
			var volinfo_array = vol_array[i].split("\10");
			showstr += volinfo_array[0] + "  " + volinfo_array[1] + "&nbsp;&nbsp;<a href='#' onclick='majorvolsdel(\""+volinfo_array[0]+"\")'>删除</a>&nbsp;&nbsp;&nbsp;";
		}
		$("#majorvolsshow").html(showstr);
	}
}

</script>
</form>
</body>
</html>
