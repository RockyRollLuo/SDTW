<%@ page contentType="text/html;charset=utf-8" %>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page language="java"%>
<%@ page session="true"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%@page import="com.xietong.software.sdtw.db.*"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.*"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.base.Power"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="jqueryui.jsp" flush="true"/>
<link rel="stylesheet" type="text/css" href="../css/common.css">
<link href="../css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="js/jquery.min.js"></script>

<!-- <script src="../js/jquery.min.js"></script> -->
<script src="../js/tablelist.js"></script>

<% UserInfo userInfo = Tool.getUserInfo(request); %>
<script language="javascript">

function showorhide_div(menu)
{
    $("#"+menu).toggle();
}
function showwinside1(id,title){
	//alert("2222222222222");
	<% if(userInfo .hasFunPower(Power.USERSTUDENTPOWER)){%>
	
parent.parent.showDialog("<%=HeadConst.apache_url%>/main/bulletin-detail.jsp?id="+id,600,600,title
			,{});
	<%}else{%>
	parent.showDialog("<%=HeadConst.apache_url%>/main/bulletin-detail.jsp?id="+id,600,600,title
			,{});
 <%	}%>
}
function zhuandao(){
	var yeshu=$("#gopage").val();
	window.location="bulletin-more.jsp?page="+yeshu;
}
</script>


</head>

<body>
<table class="location-table" width="97%">
<tr height="35">
  <td class="location-title" colspan="2">您的位置：个人消息管理>><span style="cursor:hand;" onclick="showorhide_div('helpdiv')">系统公告</span></td>
</tr>
</table>

<div id="helpdiv" style="display:none;">
<table class="banner-table" cellpadding="0" cellspacing="0" border="0">
<tr height="20">
  <td class="menuposword" width="97%" align="left">系统帮助：</td>
  <td width="5%" rowspan="2"> 
      <a href="#" onclick="showorhide_div('helpdiv')"><font face='Webdings' color='#FF0000' style='font- size:32pt'>r</font></a>
  <td>
</tr>
<tr height="20">
   <td class="bannerword"align="left">
        系统公告
   </td>
   <td>
</tr>
</table>
</div>

<table width="97%">
<tr height="25">
  <td align="right">
    <a href="sitemsg-list.jsp">返回</a>
  </td>
</tr>
</table>

<table class="content-table">



<tr >
    <th align="center"  width="20%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;序 号</th>
    <th align="center"  width="" >标题</th>
    <th align="center"  width="" >发布用户</th>
    <th align="center"  width="25%"> 发布时间</th>
</tr>
	<%
				
				
				 List list2= new ArrayList();
			       List cdt2=new ArrayList();
			       Information ifo= new Information();
			       BaseUserCode user = new BaseUserCode();
			       int currpage = ParamUtils.getIntParameter(request, "page", 1);
			       currpage=currpage>0?currpage:currpage+1;
			       int start=(currpage-1)*5;
			       Map xy=CEditConst.getAcademyNameMap(userInfo);
			       Map juese=CEditConst.getRoleNameMap(userInfo);
			  	 user=userInfo.getUserCode();
			      String userDept=user.getDeptId()+"";
			    
			      String slist4="";
			      List list4= new ArrayList();
			      Map yonghu=CEditConst.getUserCnNameMap(userInfo);
			     //  Map yonghu2=CEditConst.getUserNameMap(userInfo);
			      //判断是否是团委用户，不是团委用户只能查看团委和本学院的公告
			      if(userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
			    	  String sno=user.getName();
			    	  ClubMembers cbm=new ClubMembers();
			    	  List list3= new ArrayList();
			    	  
				       List cdt3=new ArrayList();
				       cdt3.add("memberSno ='"+sno+"'");
				       list3 =cbm.query( cdt3);
				       
				       //根据学号查学生所参加的社团账号
				       //根据学号查学生所参加的社团账号
				       if(list3.size()>0){
				    	   for(int i=0;i<list3.size();i++){
				    		   cbm=(ClubMembers)list3.get(i);
				    		   //根据社团ID再去查询社团账号
				    		  list4.add("'"+cbm.getMemberClubname()+"'");
				    	   }
				    	   //根据社团id查社团账号
					    	 
					    slist4  =Tool.join(",", list4);
					   
					    	Club club= new Club();
					  	  List list5= new ArrayList();
					    	
					       List cdt5=new ArrayList();
					       List shetuanzhanghao= new ArrayList();
					       cdt5.add("id in ("+slist4+")");
					       list5=club.query(cdt5);
					       if(list5.size()>0){
					    	   for(int i=0;i<list5.size();i++){
					    		   club= (Club)list5.get(i);
					    		   shetuanzhanghao.add("'"+club.getClubId()+"'");
					    	   }
					       }
					       //根据社团账号查社团账号在base表中的id
					       String sshetuanzhanghao=Tool.join(",", shetuanzhanghao);
					       List list6= new ArrayList();
					       List shetuanid= new ArrayList();
					       List cdt6=new ArrayList();
					       cdt6.add("name in ("+sshetuanzhanghao+")");
					       BaseUserCode shetuan= new   BaseUserCode ();
					       list6= shetuan.query(cdt6);
					       if(list6.size()>0){
					    	   for(int i=0;i<list6.size();i++){
					    		  shetuan=(BaseUserCode)list6.get(i) ;
					    		  shetuanid.add(shetuan.getId()+"");
					    	   }
					       }
					    	String sshetuanid=Tool.join(",", shetuanid);
					    	 cdt2.add("UserId in ("+sshetuanid+" )or dept in (1,"+user.getDeptId()+")");
					    	  
					      };
				       }else{
				    	   cdt2.add("dept in (1,"+user.getDeptId()+")");
				       }
			      
			     list2=  ifo.query(cdt2);
			    //如果用户是学生，过滤掉 指导单位与学生是同一部门，但学生并没有参加的社团公告
			    
			     if(userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
				     if(list2.size()>0){
				    	 for(int i = list2.size()-1;i>=0;i--){
				    		 ifo=(Information)list2.get(i);
				    String fabuyonghudanwei=(String)yonghu.get(ifo.getUserId()+"");
				  
			
			
				    BaseUserCode gonggaouser=userInfo.getUserCode(ifo.getUserId());
				   
					if(gonggaouser.getRoles().equals("4")&&!list4.contains("'"+ifo.getUserId()+"'")){
						
						list2.remove(i);
						
					}
				    	 }
				     }
				    	 
				     }
			     int tiaoshu=list2.size();
			     currpage=(currpage-1)*5>tiaoshu?currpage-1:currpage;
			     int end=currpage*5>tiaoshu?tiaoshu:currpage*5;
			     if(list2.size()>0){
			    	 for(int i= start;i<end;i++){
			    		 ifo=(Information)list2.get(i);
			    
			    		
			    		 String fabuyonghuming=(String)yonghu.get(ifo.getUserId()+"");
						    
				
				%>
				 <tr >
        			<td >&nbsp;&nbsp;<%=i+1%></td>
        			<td  align="left"  >
              			<a  title="<%=ifo.getSubject() %>" href="" onclick="showwinside1(<%=ifo.getId()%>,'<%=ifo.getSubject() %>')" >&nbsp;<%=ifo.getSubject().length()>30?ifo.getSubject().substring(0, 30)+"..":ifo.getSubject() %></a>
        			</td>
        			<td      ><%=fabuyonghuming %></td>
        			<td      ><%=Tool.stringOfCnDate(ifo.getNewDate())%></td>
        			
  				</tr> 
				<% 
					 }
			     }%>



<tr height=40>
    <form name="mygo" method="post" action="bulletin-more.jsp?" target="_self" >
    <td  width="100%" colspan="11" align="center">一共<font color="red"><%=tiaoshu %></font>条，每页显示5条
当前第<font color="red"><%=currpage %></font>页&nbsp;&nbsp;&nbsp;&nbsp;

        
           <a href="bulletin-more.jsp?page=<%=currpage-1 %>">上一页</a>  &nbsp;&nbsp;



           
        <a href="bulletin-more.jsp?page=<%=currpage+1 %>">下一页</a>&nbsp;&nbsp;


           <input type="text" name="gopage" id="gopage" value="0" style="height:17px;width:20px;">
           <input type="button" onclick="zhuandao();" value="转到" >
    </td>
    </form>
</tr>

</table>



</body>
</html>

