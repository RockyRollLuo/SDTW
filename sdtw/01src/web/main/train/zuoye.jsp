<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
}
String idlist = ParamUtils.getParameter(request,"idlist","-1");
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/ajaxfileupload.js"></script>
<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/standardupgrade/js/addFileupload.js"></script>
<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/common.js"></script>
<script type="text/javascript">
function submitthis() {
	var DateRate = $('#DateRate').val();
	if(DateRate==""){
		$('#DateRate').focus();
		alert("请录入考勤情况！");
		return;
	}
	var val=$('input:radio[name=Audit]:checked' ).val();
	if(val== null){
		$('#pass').css("border","1px red solid");
		alert("请选择审核结果");
		return;
	}
	var CheckFileEstimate = $('#CheckFileEstimate').val();
	$.ajax({
			type : "post",
			async : false,
			url : "<%=HeadConst.apache_url%>/main/train/TrainingParticipateAction.jsp",
			data : {
				cmd : 'zuoyelist',
				Audit : val,
				idlist : '<%=idlist%>',
				CheckFileEstimate : CheckFileEstimate,
				DateRate : DateRate
			},
			dataType : "json",
			cache : false,
			success : function(data) {
				if (data.msg=="ok") {
					alert("操作成功!");
					$('#top_dialog').dialog( 'close');
				} else {
					alert("操作失败");
				}
				
			},
			error : function() {
				// view("异常！"); 
				alert("异常！");
			}
		});

	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body >
<div id="errorDiv" style="color:red;font-weight:bold"></div>
<div style="margin:10px auto 0 auto;width:100%;color:#36486C;background-color: #FFFFFF">
     <form id="postForm" name="postForm" action="" method="post">
     <input type="hidden" id="cmd" name="cmd" value="addFile">
     <table cellpadding="8px" cellspacing="1px" bgcolor="#E3E5E8">
     <tr>
     <td class="form_label" >作业评价</td>
     <td  align="left">
		 <div align="left">
		<textarea rows="4" cols="100" id="CheckFileEstimate" name="CheckFileEstimate" style="width: 100%"></textarea>
	     </div>
	 </td>
     </tr>
     <tr>
     <td class="form_label">考勤</td>
     <td  align="left">
		 <div align="left">
			<input name="DateRate" id="DateRate"/>
	     </div>
	 </td>
     </tr>
     <tr>
     <td class="form_label"></td>
     <td  align="left" id="pass">
		 <div align="left">
			<input name="Audit" value="2" type="radio"/>通过
			<input  name="Audit" value="3" type="radio"/>不通过
	     </div>
	 </td>
    </tr>
     <%-- <tr id="ClientAttach">
  		<td align="left" class="form_label">附件</td>
  		<td bgcolor="#ffffff" align="left" colspan="3">
			<table width="100%" border="0" cellspacing="0" id="ShowFiles">
				<%
				int caid = -1;
				if (!"".equals(v.getAddFileList().trim())) {
					String caids[] = v.getAddFileList().split(",");
					for(int i=0;i<caids.length;i++){
						caid = Tool.StrToInt(caids[i]);
						ClientAttach ca = new ClientAttach();
						//社团校外活动会长（带队队长）承诺书
						if (caid!=-1&&ca.getById(caid)!=null) {
							ca = ca.getById(caid);
				%>
			     <tr id="<%=ca.getId() %>"><td><a href="<%=HeadConst.apache_url %>/servlet/attach?type=otherattach&id=<%=ca.getId() %>" target="_blank">
				<img src='<%=HeadConst.apache_url%>/main/images/file1.gif' border="0"/> <%=ca.getUploadName() %></a>&nbsp;&nbsp;&nbsp;&nbsp;
				<img src='<%=HeadConst.apache_url%>/main/images/delete.gif' alt='删除' title='删除' border="0" onclick="javascript:deleteUpdateFile('<%=ca.getUploadName()%>','<%=ca.getId() %>')" style="cursor:point;"/></td>
				</tr>
					<%}
					}
				}
				%>
				</table>
				<%
				//if(v.getCheckFlag()!=1){%>
				<input type="file" name="OtherAttach" id="OtherAttach" size="40"/> 
				<input type="button" value="上传" id="btn_up"  onclick="checkFileType(7,'StandardupGrade_File');" class="formbtn" style="color:black;background-color: #e3e5e8;"/>
				<img style="display:none" id="load1" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
				<%//}
				%>
			    <div style="color:red">说明：请上传格式为:doc、docx格式文件，文件最大5M</div>
		</td>
  	</tr> --%>
    
     </table>
     </form>
     </div>
</body>
</html>