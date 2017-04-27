
<%@page import="java.util.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xietong.software.sdtw.db.*"%>
<%@ page pageEncoding="utf-8" %>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@page import="com.xietong.software.base.Power"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../js/tablelist.js"></script>
<script src="../js/jquery.min.js"></script>
</head>

<body>
<%
String myaccount=(String)session.getAttribute("useraccount");

String strposition = "创新创业>>山大创库>>";
String strfunction = "通知列表";
String strhelpwords = "显示已添加的山大创库通知列表。";
%>
<%@ include file="../student/pagetop-positionandhelp.jsp"%>
<!-- <table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置>>创新创业>>山大创库
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table> -->

<table class="content-table">
<tr>
	<th width="5%">序号</th> 
	<th >名称</th>  
	<th width="20%">日期</th>  
	<th width="20%" colspan="2">操作</th>
</tr>
<%
String[] checkstate={"未审核","通过","未通过","未申请"};
int pagenumstr=Integer.parseInt(ParamUtils.getParameter(request, "page", "1"));
UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	if (userInfo != null) {
		userInfo.removeCookie(response);
	}
	session.removeAttribute("UserInfo");
	return ;
}

BaseUserCode user= new BaseUserCode();

user=userInfo.getUserCode();
String chose="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
char display[]={'0','0','0','0','0','0'};
Map<String,ChuangkuDeclare> map= new HashMap<String,ChuangkuDeclare>();
List<String> yichanjia= new ArrayList<String> ();
List list1= new ArrayList();
List cdt1= new ArrayList();
ChuangkuDeclare vz= new ChuangkuDeclare ();

cdt1.add("addAccount='"+user.getId()+"'");
list1=vz.query(cdt1);
for(int i=0;i<list1.size();i++){
	vz=(ChuangkuDeclare )list1.get(i);

	map.put(vz.getCkId()+"", vz);
}
System.out.println("22222222222"+map);

String foldercode=String.valueOf(display);
String ck1="",ck2="",declarehref="",detailhref="",modihref="",deletehref="",submit="",namehref="";
int id=0,order=0,rowscount=0,declareid=0,checkflag=3;
     ChuangKu ck= new ChuangKu();
     List cdt= new  ArrayList();
     cdt.add("order by id desc");
     List list= new ArrayList();
     list =ck.query(cdt);
   
    
     int tiaoshu=list.size();
     int end=0;
     int start=0;
     if(list.size()>0){
    	 start=(pagenumstr-1)*8;
    		
    		end=list.size()>pagenumstr*8?pagenumstr*8:list.size();
    		System.out.println(list.size());
    	 for(int i=0;i<list.size();i++){
    		 ck=(ChuangKu)list.get(i);
    		 ck2=Tool.stringOfDate(ck.getCk2())+"~"+ck.getAddTime();
    		 namehref="<a href='innovation-chuangku-details.jsp?id="+ck.getId()+"'>"+ck.getCk1()+"</a>";
    		 modihref="<a href='innovation-competition-list1.jsp?Ckid="+ck.getId()+"'>查看我的作品</a>";
    		 if(map.containsKey(ck.getId()+"")){
    				checkflag=map.get(ck.getId()+"").getCheckFlag();
    				
    				deletehref="<a href='ChuangkuDeclareAction.jsp?cmd=delete&Id="+map.get(ck.getId()+"").getId()+"'>删除</a>";
    			}
    	
     
  
%>
<tr>
  <td><%=order+1%></td>
  <td><%=namehref%></td>
  <td><%=ck2%></td>
<%--   <td><a href="innovation-chuangku-declare.jsp?chuangkuid=<%=ck.getId()%>">填写申请表</a></td>
 --%>  <td colspan="2"><%=modihref%></td>

</tr>
<%
modihref="";deletehref="";checkflag=3;
    	 }  }else{
%>
<tr>
	<td colspan="8">系统中暂无信息！</td>
</tr>
<%} %>
<tr height=40>
	<th width="100%" colspan="15" align="center">
		共&nbsp<%=tiaoshu %>&nbsp条&nbsp;&nbsp;&nbsp;当前第<%=pagenumstr %>页&nbsp;&nbsp;&nbsp;
			<%
		
		int shangyiye=pagenumstr-1>0?pagenumstr-1:1;
		int xiayiye=pagenumstr*8<tiaoshu?pagenumstr+1:pagenumstr;
		%>
   		<a href="innovation-chuangku-list.jsp">首页</a>&nbsp;&nbsp;&nbsp;
		<a href="innovation-chuangku-list.jsp?page=<%=shangyiye %>" >上一页</a>  &nbsp;&nbsp;&nbsp;
		
		<a href="innovation-chuangku-list.jsp?page=<%=xiayiye%>" >下一页</a>&nbsp;&nbsp;&nbsp;
    
		
	</th>
</tr>
<tr>
	<th colspan="8"></th>
</tr>

</table>

</body>
</html>