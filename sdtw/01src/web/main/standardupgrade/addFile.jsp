<%@page import="com.xietong.software.sdtw.studentUnion.StudentUnionUtil"%>
<%@page import="com.xietong.software.sdtw.db.StandardupGrade_File"%>
<%@page import="com.xietong.software.sdtw.db.ClientAttach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="java.io.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
}
int aid = ParamUtils.getIntParameter(request,"aid",-1);
int sid = ParamUtils.getIntParameter(request,"sid",-1);
int id = ParamUtils.getIntParameter(request,"id",-1);
StandardupGrade_File v = new StandardupGrade_File();
if (id!=-1&&v.getById(id)!=null) {
	v = v.getById(id);
}
List ApplyLevelTypeOptions = CEditConst.getApplyLevelTypeOptions(userInfo,"-1");
List cdt = new ArrayList();
cdt.add("academy="+userInfo.getDeptId());
StudentUnionUtil stuutil = new StudentUnionUtil();
List ClassesNameOptions = stuutil.getClassesNameOptions(cdt);
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/ajaxfileupload.js"></script>
<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/standardupgrade/js/addFileupload.js"></script>
<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/common.js"></script>
<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/chosen/chosen.css" rel="stylesheet"/>
<script language="javascript" src="<%=HeadConst.apache_url+"/main/" %>/js/chosen/chosen.jquery.js"></script>
<style>

.chosen-container .chosen-results {
    max-height: 120px;
}
</style>
<script type="text/javascript">
$(function(){
	$("#ZBName").chosen({width:'200px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到",search_contains: true});
})
function init() {
	$("#ZBName").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到"});
} 
function addFile(){
	var ZBName = $('#ZBName').val();
	if (ZBName==""||ZBName=="-1") {
		alert("请录入支部名称！");
		$('#ZBName').focus();
		return;
	}
	var ZBNums = $('#ZBNums').val();
	if (ZBNums=="") {
		alert("请录入支部人数！");
		$('#ZBNums').focus();
		return;
	}
	if (!isInteger(ZBNums)) {
		alert("请填写数字！");
		$('#ZBNums').focus();
		return;
	}
	var ApplyLevelType = $('#ApplyLevelType').val();
	if (ApplyLevelType=="-1") {
		alert("请选择申报等级！");
		$('#ApplyLevelType').focus();
		return;
	}
	/* var Addfilelist = $('#Addfilelist').val();
	if (Addfilelist=="") {
		alert("请上传附件！");
		return;
	} */
	$.ajax({
			type : "post",
			///sdfz/01src/web
			url : "<%=HeadConst.apache_url%>/main/standardupgrade/StandardupGrade_FileAction.jsp?"+$('form').serialize(),
			dataType : "json",
			cache : false,
			success : function(data) {
				if (data.msg=="ok") {
					parent.mainFrame.location.reload();
					 $( '#top_dialog').dialog( 'close');
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
<title>设置离任时间</title>
</head>
<body >
<div id="errorDiv" style="color:red;font-weight:bold"></div>
<div style="margin:10px auto 0 auto;width:100%;color:#36486C;background-color: #FFFFFF">
     <form id="postForm" name="postForm" action="" method="post">
     <input type="hidden" id="cmd" name="cmd" value="addFile">
     <table cellpadding="8px" cellspacing="1px" bgcolor="#E3E5E8">
     <input type="hidden" id="StandardUpGradeName" name="StandardUpGradeName" value="<%=sid%>"/>
     <input type="hidden"  id="Academy" name="Academy" value="<%=aid%>"/>
     <%-- <input type="hidden" id="Addfilelist" name="Addfilelist" value="<%=v.getAddFileList()%>"/> --%>
     <input type="hidden" id="Id" name="Id" value="<%=v.getId()%>"/>
     <tr>
     <td class="form_label">支部名称</td>
     <td  align="left">
		 <div align="left">
			<%=HtmlTool.renderSelect(ClassesNameOptions,""+v.getZBName(),"ZBName",""+v.getZBName()) %>
	     </div>
	 </td>
    </tr>
    <tr>
     <td class="form_label" >支部人数</td>
     <td  align="left">
		 <div align="left">
		 <input id="ZBNums" name="ZBNums" value="<%=v.getZBNums()==-1?"":v.getZBNums()%>"/>
	     </div>
	 </td>
     </tr>
     <tr>
     <td class="form_label" >申报等级</td>
     <td  align="left">
		 <div align="left">
		 <%=HtmlTool.renderSelect(ApplyLevelTypeOptions,""+v.getApplyLevelType(),"ApplyLevelType","") %>
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