<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.sdtw.db.StudentUnion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xietong.software.sdtw.db.StudentUnionDept"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ page language="java"%>
<%@ page import="java.sql.*"%>
<%@page import="com.xietong.software.util.*"%>
<%@page import="com.xietong.software.common.*"%>
<%@page import="java.util.*"%>
<%@page import="com.xietong.software.base.Power"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../js/tablelist.js"></script>
<script src="../js/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$(".tabbtn a").click(function(){
		$(".tabbtn").removeClass("active");
		$(this).parent().addClass("active");
	});

});
</script>
<style type="text/css">
.active{
	background:#9c0c15!important;
}
.active a,.active a:link,.active a:active,.active a:visited{
	color:#FFF!important;
}
</style>
</head>
<% 
	//接受各种参数 从session或者其他对象中 
	String academy = (String)session.getAttribute("academy");
	String uniontype=ParamUtils.getParameter(request, "unionType", "");
System.out.println(uniontype+"cccccccccccccccc");

	String[] unionnamearry={"校学生会","校研究生会","院学生会","院研究生会"};
  
	String strfunction = "学生会介绍及部门列表";
	String strhelpwords = "对附学生会主席团的单位进行管理，点击部门名称的超链接可以查看每个部门的详细信息。";
%>
<body>

<table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置>><%=unionnamearry[Integer.parseInt(uniontype)-1] %>
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>

<table class="content-table" cellpadding="0" cellspacing="0" border="0" style="border:0;">
<tr>


<%  
	//定义数据库中读取字段的变量 
	String deptname="",principal="",namehref="",deptmembers="",deptprofile="",functionstr="",modifyhref="",delhref="";
	int deptid;
	UserInfo userinfo = Tool.getUserInfo(request);
	if(!userinfo.hasFunPower(Power.USERSTUDENTPOWER)){
		out.print(HtmlTool.msgBox(request, "请先登录"));
		if (userinfo != null) {
			userinfo.removeCookie(response);
		}
		session.removeAttribute("UserInfo");
		return ;
	}
	  BaseUserCode user=userinfo.getUserCode();
	  int  deptId=user.getDeptId();
	StudentUnionDept sud= new StudentUnionDept ();
	List cdt= new ArrayList();
	String unionid="";
	List list= new ArrayList();
	if(uniontype.equals("1")){
		unionid="1";
		cdt.add("unionid=1");
		cdt.add("order by listorder");
	}
	if(uniontype.equals("2")){
		unionid="2";
		cdt.add("unionid=2");
		cdt.add("order by listorder");
	}
	if(uniontype.equals("3")){
		StudentUnion stu= new StudentUnion ();
		List cdt1 =new ArrayList();
		List list1=new ArrayList();
		cdt1.add("academy="+deptId);
		cdt1.add("uniontype="+uniontype);
		list1=stu.query(cdt1);
		if(list1.size()>0){
			stu=(StudentUnion)list1.get(0);
			unionid=stu.getId()+"";
			cdt.add("unionid="+stu.getId());
			cdt.add("order by listorder");
		}else{
			return;
		}
		
	}
	if(uniontype.equals("4")){
		StudentUnion stu= new StudentUnion ();
		List cdt1 =new ArrayList();
		List list1=new ArrayList();
		cdt1.add("academy="+deptId);
		cdt1.add("uniontype="+uniontype);
		list1=stu.query(cdt1);
		if(list1.size()>0){
			stu=(StudentUnion)list1.get(0);
			unionid=stu.getId()+"";
			cdt.add("unionid="+stu.getId());
			cdt.add("order by listorder");
		}else{
			return;
		}
	}
%>
  	<th class="tabbtn" ><a id="dianji" href="stuorg-studentunion-intro.jsp?uniontype=<%=uniontype %>" target='contentinfo'><div style="width: 100%;height: 100%;">学生会介绍</div></a></th>
	<th class="tabbtn" ><a  href="stuorg-studentunion-leaderteam.jsp?&_type_=zhuxi&_UnionId_=<%=unionid%>" target='contentinfo'><div style="width: 100%;height: 100%;">主席团</div></a></th>
<% 
   list=sud.query(cdt);
   if(list.size()>0){
	   for(int i=0;i<list.size();i++){
		   sud=(StudentUnionDept)list.get(i);
		   namehref=sud.getDeptName();
		  %>
		
			<th class="tabbtn"><a  target='contentinfo' href='stuorg-studentunion-detail.jsp?Id=<%=sud.getId()%>'><div style="width: 100%;height: 100%;"><%=namehref%> </div></a></th>  
	<%   
	   }
   }
//        		deptmembers="<a  href='stuorg-studentunion-deptmembers.jsp?deptid="+deptid+"&uniontype="+uniontype+"&deptname="+deptname+"&unionid="+unionid+"' >查看</a>";          
%>


</tr>
<tr>
<td colspan="20">
	<iframe src="stuorg-studentunion-intro.jsp?uniontype=<%=uniontype %>" frameborder="0" border="0" scrolling="no" marginheight="0" marginwidth="0" name="contentinfo" style="width:100%;height:900px">
	
	</iframe>
</td>
</tr>
</table>

</body>
</html>