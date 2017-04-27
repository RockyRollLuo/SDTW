<%@page import="com.xietong.software.sdtw.db.TrainingParticipate"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.sdtw.db.ClientAttach"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%
String[] labelclass = {"labeloff", "labeloff"};
UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}
int Id = ParamUtils.getIntParameter(request,"Id",-1);
TrainingParticipate v = new TrainingParticipate();
String currpage = ParamUtils.getParameter(request,"page","1");
if (Id!=-1&&v.getById(Id)!=null) {
	v = v.getById(Id);
}

String read = "readonly=\"readonly\"";
String file = "type=hidden";
String desc = "style=\"display: none\"";
String button = "type=hidden";
String read2 = "readonly=\"readonly\"";
String file2 = "type=hidden";
String desc2 = "style=\"display: none\"";
String button2 = "type=hidden";
String submitbtn = "type=hidden";

if (v.getAudit()==0) {
	read = "";
	file = "type=file";
	desc = "";
	button = "type=button";
}
if (v.getAudit()==2) {
	read2 = "";
	file2 = "type=file";
	desc2 = "";
	button2 = "type=button";
}
if (v.getAudit()==0||v.getAudit()==2) {
	submitbtn = "type=button";
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/common-student.css">
<script src="../js/tablelist.js"></script>
<script src="../js/jquery.min.js"></script>
<script language="JavaScript" src="../main/js/ajaxfileupload.js"></script>
<script language="JavaScript" src="js/upload.js"></script>
<script type="text/javascript">
function infoshow(val)
{
	switch(val)
	{
		case 1:
			$("#baseinfo").attr("style","display:block");
			$("#teaminfo").attr("style","display:none");
			$("#base").attr("class","labelon");
			$("#team").attr("class","labeloff");
			break;
		case 2:
			$("#baseinfo").attr("style","display:none");
			$("#teaminfo").attr("style","display:block");
			$("#base").attr("class","labeloff");
			$("#team").attr("class","labelon");
			break;
		default:
			$("#baseinfo").attr("style","display:none");
			$("#teaminfo").attr("style","display:none");
			$("#base").attr("class","labeloff");
			$("#team").attr("class","labeloff");
			
	}
}

function cancelthis(page){
	location = "training_arrangement-list.jsp?page="+page;
}
function submitthis(){
	$('#postForm').submit();
}
</script>
</head>
<body>
<%
String strposition = "团校培训管理>>";
String strfunction = "上传作业和结题报告";
String strhelpwords = "上传作业。";
%>
<%@ include file="../student/pagetop-positionandhelp.jsp" %>
<table class="tabs-table">
<tr>
      <td id = "base"  class="<%=labelclass[0]%>"width="60" align="center" onclick="infoshow(1)" >作业</td>
      <td id = "team" class="<%=labelclass[1]%>" width="60" align="center" onclick="infoshow(2)" <%=desc2 %>>结题</td>
<%--       <td id = "other" class="<%=labelclass[2]%>" width="60" align="center" onclick="infoshow(3)" >其他信息</td>
      <td id = "file"class="<%=labelclass[3]%>" width="60" align="center" onclick="infoshow(4)" >文件上传</td> --%>
</tr>
</table>
<form name="postForm" id="postForm" method="post" action="training_arrangement-save.jsp">
<input type="hidden" id="cmd" name="cmd" value="uploadFile"/>
<input type="hidden"  id="ProjectId" name="ProjectId" value="<%=v.getProjectId()%>"/>
<input type="hidden"  id="Id" name="Id" value="<%=v.getId()%>"/>
<table class="content-table">
	<tbody id="baseinfo" style="display:block">
	<tr>
	<td>作业</td>
	<td>
	<textarea rows="5" cols="140" style="width: 100%" id="HomeWork" name="HomeWork" <%=read %>><%=v.getHomeWork() %></textarea>
	</td>
	</tr>
	
	<tr id="ClientAttach">
  		<td align="right" class="form_label">附件</td>
  		<td bgcolor="#ffffff" align="left" colspan="3">
  		<input type="hidden" id="WorkFileList" name="WorkFileList" value="<%=v.getWorkFileList()%>"/>
		<table width="100%" border="0" cellspacing="0" id="ShowFilesWorkFileList">
				<%
				int caid = v.getId();
				if (!"".equals(v.getWorkFileList().trim())) {
					String caids[] = v.getWorkFileList().split(",");
					for(int i=0;i<caids.length;i++){
						caid = Tool.StrToInt(caids[i]);
						ClientAttach ca = new ClientAttach();
						if (caid!=-1&&ca.getById(caid)!=null) {
							ca = ca.getById(caid);
				%>
			     <tr id="<%=ca.getId() %>"><td><a href="<%=HeadConst.apache_url %>/servlet/attach?type=otherattach&id=<%=ca.getId() %>" target="_blank">
				<img src='<%=HeadConst.apache_url%>/main/images/file1.gif' border="0"/> <%=ca.getUploadName() %></a>&nbsp;&nbsp;&nbsp;&nbsp;
				<img <%=desc %> src='<%=HeadConst.apache_url%>/main/images/delete.gif' alt='删除' title='删除' border="0" onclick="javascript:deleteUpdateFile('<%=ca.getUploadName()%>','<%=ca.getId() %>')" style="cursor:point;"/></td>
				</tr>
					<%}
					}
				}
				%>
			</table>
				<%
				//if(v.getCheckFlag()!=1){%>
				<input <%=file %> name="OtherAttachWorkFileList" id="OtherAttachWorkFileList" size="40"/> 
				<input <%=button %>  value="上传" id="btn_up"  onclick="checkFileType(9,'Training_Participate','WorkFileList');" class="formbtn" style="color:black;background-color: #e3e5e8;"/>
				<img style="display:none" id="load1WorkFileList" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
				<%//}
				%>
			    <div style="color:red">说明：请上传格式为:doc、docx格式文件，文件最大5M</div>
			</td>
  		</tr>
	
	</tbody>
	<tbody id="teaminfo" style="display:none">
	<tr <%=desc2 %>>
	<td>结题</td>
	<td>
	<textarea rows="5" cols="140" id="CheckReport" name="CheckReport" <%=read2 %>><%=v.getCheckReport() %></textarea>
	</td>
	</tr>
	
	<tr id="ClientAttach" <%=desc2 %>>
  		<td align="right" class="form_label">附件</td>
  		<td bgcolor="#ffffff" align="left" colspan="3">
  		<input type="hidden" id="AddFileList" name="AddFileList" value="<%=v.getAddFileList()%>"/>
		<table width="100%" border="0" cellspacing="0" id="ShowFilesAddFileList">
				<%
				//int caid = -1;
				if (!"".equals(v.getAddFileList().trim())) {
					String caids[] = v.getAddFileList().split(",");
					for(int i=0;i<caids.length;i++){
						caid = Tool.StrToInt(caids[i]);
						ClientAttach ca = new ClientAttach();
						if (caid!=-1&&ca.getById(caid)!=null) {
							ca = ca.getById(caid);
				%>
			     <tr id="<%=ca.getId() %>"><td><a href="<%=HeadConst.apache_url %>/servlet/attach?type=otherattach&id=<%=ca.getId() %>" target="_blank">
				<img src='<%=HeadConst.apache_url%>/main/images/file1.gif' border="0"/> <%=ca.getUploadName() %></a>&nbsp;&nbsp;&nbsp;&nbsp;
				<img <%=desc2 %> src='<%=HeadConst.apache_url%>/main/images/delete.gif' alt='删除' title='删除' border="0" onclick="javascript:deleteUpdateFile('<%=ca.getUploadName()%>','<%=ca.getId() %>')" style="cursor:point;"/></td>
				</tr>
					<%}
					}
				}
				%>
			</table>
				<%
				//if(v.getCheckFlag()!=1){%>
				<input <%=file2 %>  name="OtherAttachAddFileList" id="OtherAttachAddFileList" size="40"/> 
				<input <%=button2 %>  value="上传" id="btn_up"  onclick="checkFileType(9,'Training_Participate','AddFileList');" class="formbtn" style="color:black;background-color: #e3e5e8;"/>
				<img style="display:none" id="load1AddFileList" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
				<%//}
				%>
			    <div style="color:red">说明：请上传格式为:doc、docx格式文件，文件最大5M</div>
			</td>
  		</tr>
	
	</tbody>
	<tr>
	  <th  colspan="2">
	    <input <%=submitbtn %> value="保存修改" name="btn1" onclick="submitthis()" class="button">&nbsp;&nbsp;&nbsp;
	    <input type="button" value="放弃修改" name="btn2" onclick="cancelthis(<%=currpage %>)" class="button">&nbsp;&nbsp;&nbsp;
	  </th>
	</tr>
</table>
</form>
</body>
</html>
