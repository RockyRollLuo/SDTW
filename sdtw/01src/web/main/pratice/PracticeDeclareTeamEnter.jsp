<%@page import="com.xietong.software.sdtw.db.Honor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="java.io.*,java.util.*"%>
<!-- 设置团体荣誉弹框 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(userInfo == null){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	return;
}
int Id = ParamUtils.getIntParameter(request,"Id",-1);//结题表id
int DeclareId = ParamUtils.getIntParameter(request,"DeclareId",-1);//Practice立项表id
Honor honor = new  Honor();
List cdt = new ArrayList();
List list = new ArrayList();
cdt.add("honortype=6");//集体荣誉
cdt.add("activityId="+DeclareId);
list = honor.query(cdt);
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script>
function check() {
	 var ids = new Array();
	$("input[name=Honor]").each(function() {  
        if ($(this).is(':checked' )) {
        	ids.push($(this).val());
        }
    }); 
	//ids.join(',');
	var url = "<%=HeadConst.apache_url%>/main/pratice/PracticeDeclareTeammemberAction.jsp?cmd=audithonorJt&Id=<%=Id%>&honorList="+ids.join(','); 
	$.ajax({
        type: "post",
        async:false,
        url: url,
        dataType: "json",
        cache: false,
        success: function(data){
                  if (data.msg=='no') {
                	  alert("请按照说明分配奖项");
                	  return;
                  } 
                  if (data.msg=="ok") {
                	  alert("分配奖项成功");
                	  parent.location.reload();
                	  $('#top_dialog').dialog( 'close');
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
<body >
<div id="errorDiv" style="color:red;font-weight:bold"></div>
<div  style="margin:0 auto 0 auto; padding-top:10px; width:auto;height:120px;border-radius: 3px;background-color: #E3E5E8">
<!-- <div style="margin:10px auto 0 auto;width:100%;color:#36486C;background-color: #FFFFFF"> -->
     <form id="" name="" action="" method="post">
     <input type="hidden" id="cmd" name="cmd" value="enter">
     <table cellpadding="8px" cellspacing="1px" bgcolor="#E3E5E8">
     <tr bgcolor="#E3E5E8">
     <td>
     <%
     for (int i=0;i<list.size();i++) {
     honor = (Honor)list.get(i);
     %>
		<input type="checkbox" name="Honor" value="<%=honor.getId()%>"/><%=honor.getHonorName() %><br/>
     <%}
     %>
	 </td>
     </tr>
     </table>
     </form>
     </div>
</body>
</html>