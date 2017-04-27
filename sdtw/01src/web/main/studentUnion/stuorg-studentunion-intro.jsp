<%@ page contentType="text/html;charset=utf-8" %>
<%@ page language="java"%>
<%@ page session="true"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.*"%>


<html >
<head>
<link href="../css/common.css" rel="stylesheet" type="text/css"/>
<!-- <script type="text/javascript" src="../ckeditor/ckeditor.js"></script> -->
<style type="text/css">
.text{
	font-family:楷体
	font-size: 19px;
	width:100%;
}
.text th{
	padding:.5em;
	border:1px solid #fff;
	color:#fff;                                 
	background:#3992d0;
}
.text td{
	background:#fff;
}
p{
	text-indent:2em;  /*首行缩进2个当前字符*/
}
</style>
<script type="text/javascript">
function form1submit(){
	document.form1.myunionprofile.value =CKEDITOR.instances.unionprofile.getData();
	document.form1.submit();
}

function form1modify(){
	document.getElementById("editorarea1").style.display="none";
	document.getElementById("editorarea2").style.display="block";
	
	document.getElementById("picture1").style.display="none";
	document.getElementById("picture2").style.display="none";
}
</script>
</head>
<% 
//接受各种参数 从session或者其他对象中 
String academy=(String)session.getAttribute("academy");


String unionid=request.getParameter("unionid");

String[] unionnamearry={"校学生会","校研究生会","院学生会","院研究生会"};
ResultSet rs=null;
String unionprofile="",unionprofilestr="";



	
	
    String strposition = "学生组织建设 >> 组织信息管理 >>";
	String strfunction = unionnamearry[1]+"简介";
	String strhelpwords = "学生会介绍。";
%>
<body>
<%-- <%@ include file="../pubpro/pagetop-positionandhelp.jsp" %> --%>
<table class="command-table">

<tr>
	<td>
	   <a href="#" onclick="history.go(-1)"><img src="../images/commandico/back.png"></a>
	</td>
</tr>
</table>

<table class="text" >
<tr>
<th><%=strfunction%></th>
</tr>
<tr id="picture1">
	<td><p><b>【组织构架】</b></td>
</tr>
<tr id="picture2">
	<td align="center"><img src="images/image001.png"></td>
</tr>	

<tr id="editorarea1">
<td>
	<%=unionprofile%>
<%
if(unionprofile==""){
%>
	<textarea name="unionprofile"></textarea>
	<script type="text/javascript">CKEDITOR.replace("unionprofile",
	{toolbar:[
		['Styles','Format','Font','FontSize'], 
		['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],  
		['Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'HiddenField'], 
	]
	});
	</script>
<%
}
%>
</td>
</tr>

<tr id="editorarea2" style="display:none;">
<td>
	<textarea name="unionprofile"><%=unionprofile%></textarea>
	<script type="text/javascript">CKEDITOR.replace("unionprofile",
	{toolbar:[
		['Styles','Format','Font','FontSize'], 
		['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],  
		['Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField'], 
	]
	});
	</script>
</td>
</tr>
<tr>
  <th colspan="6" align="center">
    <input type="submit" class="button" value="保存" onclick="form1submit()">&nbsp;&nbsp;&nbsp;
    <input type="reset" class="button" value="修改" onclick="form1modify()">&nbsp;&nbsp;&nbsp;
  </th>	
</tr>
</table>


<form name="form1" method="post" action="stuorg-studentunion-intro-save.jsp">
<input type="hidden" name="myunionprofile" value=""/>
<input type="hidden" name="uniontype" value="<%=1%>">
<input type="hidden" name="unionid" value="<%=unionid%>">
</form>
	
</body>

</html>