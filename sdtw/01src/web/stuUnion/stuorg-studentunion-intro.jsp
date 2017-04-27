<%@ page contentType="text/html;charset=utf-8" %>
<%@ page language="java"%>
<%@ page session="true"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.*"%>
<%@page import="com.xietong.software.util.*"%>
<%@page import="com.xietong.software.common.*"%>
<%@page import="com.xietong.software.sdtw.db.*"%>
<%@page import="java.util.*"%>
<html >
<head>
<link href="../css/common-student.css" rel="stylesheet" type="text/css"/>

<style type="text/css">
.text{
	font-family:楷体;
	font-size: 19px;
	width:89%;
	margin:0 auto;
}
h3{
	align:center;
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
}
</script>
</head>
<% 
//接受各种参数 从session或者其他对象中 




String[] unionnamearry={"校学生会","校研究生会","院学生会","院研究生会"};
ResultSet rs=null;
String unionprofile="",unionprofilestr="";

String uniontype=ParamUtils.getParameter(request, "uniontype", "1");

UserInfo userinfo=Tool.getUserInfo(request);
if(userinfo==null){
	return;
}
BaseUserCode user=userinfo.getUserCode();
int  deptId=user.getDeptId();
StudentUnion sud= new StudentUnion ();
List cdt= new ArrayList();
String unionid="";
List list= new ArrayList();
if(uniontype.equals("1")){
	unionid="1";
	cdt.add("id=1");
	
}
if(uniontype.equals("2")){
	unionid="2";
	cdt.add("id=2");
	
}
if(uniontype.equals("3")){
	
	cdt.add("academy="+deptId);
	cdt.add("uniontype="+uniontype);

	
}
if(uniontype.equals("4")){


	cdt.add("academy="+deptId);
	cdt.add("uniontype="+uniontype);
	
}
list=sud.query(cdt);
if(list.size()>0){
	sud=(StudentUnion)list.get(0);
	unionprofile=sud.getUnionprofile();
}
	System.out.println("bbbbbbbbbbbbbbbbbbbbbb"+uniontype);
	
//    String strposition = "学生组织建设 >> 组织信息管理 >>";
	
// 	String strhelpwords = "学生会介绍。";
%>
<body>

<table class="text" style="width:100%">

<tr>
	<td>
		<%=unionprofile%>
	</td>
</tr>

<tr height="30px">
  <th colspan="6" align="center">
  </th>	
</tr>
</table>

</body>

</html>