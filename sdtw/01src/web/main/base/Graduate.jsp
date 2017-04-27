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
String idlist = ParamUtils.getParameter(request,"idlist","");
List cdt = new ArrayList();
cdt.add("flag=1");
List DeptNameoptions = COptionConst.getAcademyNameOptions(userInfo,"-1",cdt);//(List)request.getAttribute("DeptNameoptions");
List MajorNameOptions = new ArrayList();//CEditConst.getMajorNameOptions(userInfo,"-1");
List GradeNameOptions = CEditConst.getGradeNameOptions(userInfo,"-1");
List ClassesNameOptions = CEditConst.getClassesNameOptions(userInfo,"-1");
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
<%-- <script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/jquery-1.8.3.min.js"></script>
<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script> --%>
<script type="text/javascript">
function check(){
	debugger;
	var academy = $('#_DeptId_').val();
	var major = $('#_Major_').val();
	var grade = $('#_Grade_').val();
	if(academy=='-1'){
		alert("请设置学院！");
		$('#_DeptId_').focus();
		return;
	}
	if(major=='-1'){
		alert("请设置专业！");
		$('#_Major_').focus();
		return;
	}
	if(grade=='-1'){
		alert("请设置年级！");
		$('#_Grade_').focus();
		return;
	}
	$.ajax({
        type: "post",
        url: "<%=HeadConst.apache_url%>/main/base/UserCodeAction.jsp",
     /*    data: {academy:$('#_DeptId_').val(),cmd:'getmajor'}, */
        data: {cmd:'setGraduate',academy:academy,major:major,grade:grade},
        dataType: "json",
        cache: false,
        async:false,
        success: function(data){
        	 if(data.msg=="ok"){
	  	        	$('#top_dialog').dialog('close');
	  	        	alert("设置成功!");
		  	          parent.mainFrame.location="<%=HeadConst.apache_url%>/main/base/UserCodeAction.jsp?_DeptId_="+academy+"&_Grade_="+grade+"&_Major_="+major;  
	  	          }else{
	  	        	  alert("设置失败!");
	  	          }
                 },
                 error : function() { 
                             // view("异常！"); 
                             alert( "异常！"); 
				}
	});
}
	function getmajor() {
		$.ajax({
            type: "post",
            url: "<%=HeadConst.apache_url%>/main/base/UserCodeAction.jsp",
            data: {academy:$('#_DeptId_').val(),cmd:'getmajor'},
            dataType: "html",
            cache: false,
            async:false,
            success: function(data){
                       $( '#_Major_').html(data);
                     },
                     error : function() { 
                                 // view("异常！"); 
                                 alert( "异常！"); 
					}
		});
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>设置离任时间</title>
</head>
<body >
<div id="errorDiv" style="color:red;font-weight:bold"></div>
<div  style="margin:0 auto 0 auto; padding-top:10px; width:auto;height:auto;border-radius: 3px;background-color: #E3E5E8">
<div style="margin:10px auto 0 auto;width:auto;color:#36486C;background-color: #FFFFFF">
     <form id="" name="" action="" method="post">
     <input type="hidden" id="cmd" name="cmd" value="enter">
     <table cellpadding="8px" cellspacing="1px" bgcolor="#E3E5E8" style="width: 100%;">
      <tr bgcolor="#E3E5E8">
     <td class="form_label" >年级</td>
     <td>
		 <div align="right">
			<%=HtmlTool.renderSelect(GradeNameOptions, ParamUtils.getParameter(request,"_Grade_",""), "_Grade_", "")%>
	     </div>
	 </td>
     </tr>
     <tr bgcolor="#E3E5E8">
     <td class="form_label" >学院</td>
     <td>
		 <div align="right">
			<%=HtmlTool.renderSelect(DeptNameoptions, ParamUtils.getParameter(request,"_DeptId_",""), "_DeptId_", "-1","onchange=getmajor()")%>
	     </div>
	 </td>
	 </tr>
      <tr bgcolor="#E3E5E8">
     <td class="form_label" >专业</td>
     <td>
		 <div align="right">
			<%=HtmlTool.renderSelect(MajorNameOptions, ParamUtils.getParameter(request,"_Major_",""), "_Major_", "")%>
	     </div>
	 </td>
     </tr>
     </table>
     </form>
     </div>
     </div>
</body>
</html>