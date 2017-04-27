<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="java.io.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
UserInfo userInfo = Tool.getUserInfo(request);
String idlist = ParamUtils.getParameter(request,"idlist","");
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
<%-- <script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/jquery-1.8.3.min.js"></script>
<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script> --%>
<script type="text/javascript">
function checkDate(){
	test_time('<%=HeadConst.apache_url%>/main/club/Club');
	return true;
}

function test_time(className){
	var RecruitmentStart = $('#RecruitmentStart').val();
	var RecruitmentStop = $('#RecruitmentStop').val();
	var idlist='<%=idlist%>';
	if(RecruitmentStart==''){
		alert("请设置开始时间！");
		$('#RecruitmentStart').focus();
		return false;
	}
	if(RecruitmentStop==''){
		alert("请设置结束时间！");
		$('#RecruitmentStop').focus();
		return false;
	}

	 $.post(className+"Action.jsp",{cmd:'setNxTime',idlist:idlist,RecruitmentStart:RecruitmentStart,RecruitmentStop:RecruitmentStop},
            function(data){
            if(data.msg != ''&&typeof(data.msg) != "undefined")
	  	          {                    
	  	          if(data.msg=="ok"){
	  	        	$('#top_dialog').dialog('close');
	  	        	alert("设置纳新时间成功!");
		  	          parent.mainFrame.location="<%=HeadConst.apache_url%>/main/club/ClubAction.jsp?cmd=nxgl&_flag_=nx";  
	  	          }else{
	  	        	  alert("设置纳新时间失败!");
	  	          }
	  	            			  	           
	  	          }
    		  },
    		    "json"); 
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>设置离任时间</title>
</head>
<body >
<div id="errorDiv" style="color:red;font-weight:bold"></div>
<div  style="margin:0 auto 0 auto; padding-top:10px; width:auto;height:120px;border-radius: 3px;background-color: #E3E5E8">
<div style="margin:10px auto 0 auto;width:308px;color:#36486C;background-color: #FFFFFF">
     <form id="" name="" action="" method="post">
     <input type="hidden" id="cmd" name="cmd" value="enter">
     <table cellpadding="8px" cellspacing="1px" bgcolor="#E3E5E8">
     <tr bgcolor="#E3E5E8">
     <td class="form_label" style="width: 60%">开始时间</td>
     <td>
		 <div align="right">
			<input  readonly class="date" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"  name="RecruitmentStart" id="RecruitmentStart" size="0">
	     </div>
	 </td>
     </tr>
     <tr bgcolor="#E3E5E8">
     <td class="form_label" style="width: 60%">结束时间</td>
     <td>
		 <div align="right">
			<input  readonly class="date" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'RecruitmentStart\')}',onpicked:function(){}})"  name="RecruitmentStop" id="RecruitmentStop" size="0">
	     </div>
	 </td>
     </tr>
    
     </table>
     </form>
     </div>
     </div>
</body>
</html>