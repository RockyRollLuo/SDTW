<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.sun.corba.se.impl.protocol.giopmsgheaders.Message"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%@page import="com.xietong.software.sdtw.db.*"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>

<jsp:include page="jqueryui.jsp" />
<%
  UserInfo userinfo=Tool.getUserInfo(request);
if(userinfo==null){
	return;
}
Map UserCnNameMap=  CEditConst.getUserCnNameMap(userinfo);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%
if(userinfo.hasFunPower(Power.USERSTUDENTPOWER)){
%>
<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/css/common-student.css">
<script src="js/jquery.min.js"></script>

<!-- <script src="../js/jquery.min.js"></script> -->
<script src="../js/tablelist.js"></script>
<style type="text/css">
#infoarea
{
   margin-top:15px;
   position:relative;
   width:100%;
   border:0pt solid #0008000;
   padding:0px;
   overflow:hidden;

}

.info-table
{
   background-color:#fff;
   margin-top:20px;
   border:1px solid #DCDCDC;
   width:800px;
}

.info-table a:link,.info-table a:hover,.info-tablel a:visited,.info-table a:active
{
    font-size:12px;
    color:#666;
    text-decoration:none;
}
.areatable a:link,.areatable a:hover,.areatable a:visited,.areatable a:active{
	font-size:12px;
    color:#666;
    text-decoration:none;
}

.titlerow
{
   border-bottom:1px solid #fff;
   padding-left:20px;
   padding-right:20px;

   margin-left:10px;
   background-color:#DCDCDC;

   font-size:14px;
   font-family:微软雅黑;
   color:#666;

   vertical-align:middle;
   line-height:150%;
}

.bottomrow
{
   border-top:1px solid #DCDCDC;
   padding-left:20px;
   padding-right:20px;

   background-color:#b3cfe4;

   font-size:15px;
   color:#333333;

   vertical-align:middle;
   line-height:150%;
}

.textrow
{
   padding-left:0px;
   padding-right:0px;

   background-color:#b3cfe4;

   font-size:12px;
   color:#333333;

   vertical-align:middle;
   line-height:150%;
}

.areatable
{
   width:650px;
   margin-top:15px;
}

.areatitle
{
    font-size:14px;
    font-weight:bold;
    color:#666;
}

.titlecell
{
    font-size:12px;
    color:#333333;
    vertical-align:middle;
}
</style>
<%
}else{ %>
<link rel="stylesheet" type="text/css" href="css/common.css">
<style type="text/css">
#infoarea
{
   margin-top:15px;
   position:relative;
   width:100%;
   border:0pt solid #0008000;
   padding:0px;
   overflow:hidden;

}

.info-table
{
   background-color:#fff;
   margin-top:20px;
   border:1px solid #3992d0;
   width:800px;
}

.info-table a:link,.info-table a:hover,.info-tablel a:visited,.info-table a:active
{
    font-size:12px;
    color:#3992d0;
    text-decoration:none;
}
.areatable a:link,.areatable a:hover,.areatable a:visited,.areatable a:active
{
	font-size:12px;
    color:#3992d0;
    text-decoration:none;
}

.titlerow
{
   border-bottom:1px solid #fff;
   padding-left:20px;
   padding-right:20px;

   margin-left:10px;
   background-color:#3992d0;

   font-size:14px;
   font-family:微软雅黑;
   color:#fff;

   vertical-align:middle;
   line-height:150%;
}

.bottomrow
{
   border-top:1px solid #0163A2;
   padding-left:20px;
   padding-right:20px;

   background-color:#b3cfe4;

   font-size:15px;
   color:#333333;

   vertical-align:middle;
   line-height:150%;
}

.textrow
{
   padding-left:0px;
   padding-right:0px;

   background-color:#b3cfe4;

   font-size:12px;
   color:#333333;

   vertical-align:middle;
   line-height:150%;
}

.areatable
{
   width:650px;
   margin-top:15px;
}

.areatitle
{
    font-size:14px;
    font-weight:bold;
    color:#0163A2;
}

.titlecell
{
    font-size:12px;
    color:#333333;
    vertical-align:middle;
}
</style>
<%} %>

<script type="text/javascript">

function showwinside(id,title){
//	alert("111111111111");
	<% if(userinfo.hasFunPower(Power.USERSTUDENTPOWER)){%>
	parent.parent.showDialog('<%=HeadConst.apache_url%>/main/ShortMessagecheck.jsp?id='+id,600,600,title
			,{});
	<%}else{%>
	parent.showDialog('<%=HeadConst.apache_url%>/main/ShortMessagecheck.jsp?id='+id,600,600,title
			,{});
	<%	}%>
	}
	

function showwinside1(id,title){
	//alert("2222222222222");
	<% if(userinfo.hasFunPower(Power.USERSTUDENTPOWER)){%>
	
parent.parent.showDialog("<%=HeadConst.apache_url%>/main/bulletin-detail.jsp?id="+id,600,600,title
			,{});
	<%}else{%>
	parent.showDialog("<%=HeadConst.apache_url%>/main/bulletin-detail.jsp?id="+id,600,600,title
			,{});
 <%	}%>
}

</script>
</head>

<body>
<div id="infoarea">
<center> <!-- 删掉center就没有警告了 -->

<table class="info-table" cellpadding="0" cellspacing="0">
<tr>
	<td class="titlerow" height="35">消息列表</td>
</tr>


	<!--系统公告区域-->
	<tr>
    	<td align="center">
    		<table class="areatable" cellpadding="0" cellspacing="0" border="0">
   				<tr height="10">
      				<td class="areatitle" colspan="2" width="10%" align="left">系统公告</td>
					<td class="areatitle" width="30%" align="center"></td>
					<td class="areatitle" align="right">
					<%
if(userinfo.hasFunPower(Power.USERSTUDENTPOWER)){
%>
					<a href="bulletin-more.jsp?page=1">更多>></a>
					<% }else{%>
					<a href="information/InformationAction.jsp?cmd=list">更多>></a>
					<%} %>
					&nbsp;</td>
				</tr>
        		<tr>
       				<td class="separatorline" colspan="5"></td>
				</tr>
   		
				<%
				
			
				 List list2= new ArrayList();
			       List cdt2=new ArrayList();
			       Information ifo= new Information();
			       BaseUserCode user = new BaseUserCode();
			       Map yonghu=CEditConst.getRoleNameMap(userinfo);
			       Map yonghu2=CEditConst.getUserCnNameMap(userinfo);
			       Map xy=CEditConst.getAcademyNameMap(userinfo);
			       Map inclubs=       CEditConst.getClubNameMap(userinfo);
			  	 user=userinfo.getUserCode();
			      String userDept=user.getRoles()+"";
			      System.out.println(userDept+"ddddddddddddd");
			      String slist4="";
			      List list4= new ArrayList();
			      //判断是否是团委用户，不是团委用户只能查看团委和本学院的公告
			      if(userinfo.hasFunPower(Power.USERSTUDENTPOWER)){
			    	  String sno=user.getName();
			    	  ClubMembers cbm=new ClubMembers();
			    	  List list3= new ArrayList();
			    	
				       List cdt3=new ArrayList();
				       cdt3.add("memberSno ='"+sno+"'");
				       list3 =cbm.query( cdt3);
				       
				       //根据学号查学生所参加的社团账号
				       if(list3.size()>0){
				    	   for(int i=0;i<list3.size();i++){
				    		   cbm=(ClubMembers)list3.get(i);
				    		   //根据社团ID再去查询社团账号
				    		  list4.add("'"+cbm.getMemberClubname()+"'");
				    	   }
				    	   //根据社团id查社团账号
					    	  System.out.println(list4);
					    slist4  =Tool.join(",", list4);
					    	System.out.println(slist4); 
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
				   
			      if(userinfo.hasFunPower(Power.STUSER)||userinfo.hasFunPower(Power.UserAdminPower)){
			    	  
			    	  cdt2.add("dept in (1,"+user.getDeptId()+")");
			  
			      }
			     
			       cdt2.add("order by newdate desc ");
			       
			     list2=  ifo.query(cdt2);
			     System.out.println(list2.size()+"1111111111111111111111111111111111");
			     //如果登录用户是社团，过滤掉和自己是同一指导单位的其他社团信息
			    if(userinfo.hasFunPower(Power.STUSER)){
			     if(list2.size()>0){
			    	 for(int i = list2.size()-1;i>=0;i--){
			    		 ifo=(Information)list2.get(i);
			    String fabuyonghudanwei=(String)yonghu.get(ifo.getUserId()+"");
			    String fabuyonghu=(String)yonghu2.get(ifo.getUserId()+"");
			    System.out.println(yonghu.get(ifo.getUserId()+""));
			    System.out.println(yonghu);
			    BaseUserCode gonggaouser= new BaseUserCode();
				 gonggaouser=gonggaouser.getById(ifo.getUserId());
				 if(gonggaouser!=null){
			    System.out.println(gonggaouser.getRoles()+"kaishi");
			    System.out.println(ifo.getUserId());
			    System.out.println(userinfo.getId()+"jieshu");
				if(gonggaouser.getRoles().equals("4")&&ifo.getUserId()!=user.getId()){
					System.out.println("删除");
					list2.remove(i);
					
				}
			    	 }
			     }
			    	 
			     }
			    }
			    //	    //如果用户是学生，过滤掉 指导单位与学生是同一部门，但学生并没有参加的社团公告
			    if(userinfo.hasFunPower(Power.USERSTUDENTPOWER)){
				     if(list2.size()>0){
				    	 for(int i = list2.size()-1;i>=0;i--){
				    		 ifo=(Information)list2.get(i);
				    String fabuyonghudanwei=(String)yonghu.get(ifo.getUserId()+"");
				    String fabuyonghu=(String)yonghu2.get(ifo.getUserId()+"");
				    System.out.println(yonghu.get(ifo.getUserId()+"")+"AAAAAAAAAAAAAAAAAAAAAA");
				    System.out.println(ifo.getUserId()+"BBBBBBBBBBBBBBBBBBBBBB");
				    BaseUserCode gonggaouser= new BaseUserCode();
				 gonggaouser=gonggaouser.getById(ifo.getUserId());
				 if(gonggaouser!=null){
				    System.out.println(gonggaouser.getRoles()+"kaishi");
				    System.out.println(ifo.getUserId());
				    System.out.println(userinfo.getId()+"jieshu");
					if(gonggaouser.getRoles().equals("4")&&!list4.contains("'"+ifo.getUserId()+"'")){
						System.out.println("删除");
						list2.remove(i);
						
					}
				    	 }
				     }
				    	 
				     }
			    
			    }
			    
			    	 System.out.println(list2.size()+"1111111111111111111111111111111111");
			    	 //shuchu
			       	 for(int i=0;i<(list2.size()>=3?3:list2.size());i++){
			    		 ifo=(Information)list2.get(i);
			    String fabuyonghudanwei=(String)yonghu.get(ifo.getUserId()+"");
			    String fabuyonghu=(String)yonghu2.get(ifo.getUserId()+"");
			    //System.out.println(yonghu.get(ifo.getUserId()+""));
				%>
				 <tr height="25">
        			<td class="titlecell" width="5%">&nbsp;&nbsp;[<%=i+1%>]</td>
        			
        			<td   width="30%"  style="text-align:left"  class="titlecell"  >
              			<a title="<%=ifo.getSubject() %>" href="#" onclick="showwinside1(<%=ifo.getId()%>,'<%=ifo.getSubject()%>')" >&nbsp;<%=ifo.getSubject().length()>15?ifo.getSubject().substring(0, 15)+"..":ifo.getSubject() %></a>
        			</td>
        			
        			<td  width="30%"class="titlecell" align="center"><%=fabuyonghu %></td>
        			<td  width="20%"  class="titlecell" align="right" style="padding-right:7px;"><%=Tool.stringOfCnDate(ifo.getNewDate())%></td>
        			
  				</tr> 
				<% 
					 }
			     %>
			<tr height="25"></tr>
			</table>
		</td>
	</tr>

<!------------------------------------------用户留言区域（收件箱）----------------------------------------------->
					<%
if(true){
%>
<tr>
    <td align="center">
    <table class="areatable" cellpadding="0" cellspacing="0" border="0" id="table1">
	 <tr height="10">
	    <td class="areatitle" width="25%" align="left">已收信息</td>
	    <td class="areatitle" width="15%" align="center"><a href="#">发件人</a></td>
	    <td class="areatitle" width="15%" align="center"><a href="#">日期</a></td>
<td class="areatitle" width="15%" align="center"><a href="#">状态</a></td>
	    <td class="areatitle" width="15%" align="center"><a href="#">管理</a></td>

	    
	  
	 </tr>
        <tr>
	      <td class="separatorline" colspan="5"></td>
	 </tr>
	 <tr height="5">
	   <td  colspan="5"></td>
	 </tr>
     <%
      String subject;
     String personfrom;
     String sendDate;
     String zhuangtai;
     int id;
     ShortMessage smess=new ShortMessage();
       List list= new ArrayList();
       List cdt=new ArrayList();
       
       
       
       if(userinfo == null){
       		out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
       		return;
       }else{
       	user = userinfo.getUserCode();
       }
    
     //System.out.println(UserCnNameMap);
       
       //获得收件人编码
       String code=user.getId()+"";
       //System.out.println(code);
     cdt.add("receiveids="+code);
      cdt.add("smsstyle=1") ;
      cdt.add("order by senddate  DESC");
      cdt.add("limit 0,3");
       list=smess.query(cdt);
      // System.out.println(list.size());
       if(list.size()>0){
    	   for(int i=0;i<list.size();i++){
    		   
    		   smess=(ShortMessage)list.get(i);
    		   id=smess.getId();
    		   System.out.println("ID="+id);
    		   subject=smess.getSubject();
    		   System.out.println(smess.getSendId()+"...............................");
    		   personfrom=(String)UserCnNameMap.get(smess.getSendId()+"");
    		   sendDate=Tool.stringOfCnDate(smess.getSendDate());
    		   zhuangtai=smess.getIfSee()==0?"已读":"未读";
    		%>   
    		
    			<tr height="30">
	       <td width="25%"  class="titlecell" ">&nbsp;&nbsp;<a href="javascript:void(0)" onclick="showwinside(<%=id %>,'<%=subject %>')"><%=subject %></a></td>
		<td width="15%" class="titlecell" align="center"><a href="javascript:void(0)" onclick="showwinside(<%=id %>,'<%=subject %>')"><%=personfrom%><a></a></td>
	       <td width="15%" class="titlecell" align="center"><a href="javascript:void(0)" onclick="showwinside(<%=id %>,'<%=subject %>')"><%=sendDate%><a></a></td>
	       <td  width="15%" class="titlecell" align="center"><font color="red">new</font></td>
	    <td class="titlecell" align="center"><a href="ShortMessageAction.jsp?cmd=delete1&idlist=<%=id %> " ><font color="red">删除</font></a></td>
	      
	 
    		
    		<% 
    	   }
       }else{
    	  %>
    	 <td colspan='3' class='titlecell'>系统当前没有发给您的消息！</td>
 </tr>
    	  <% 
       }
   
     %>
	  <tr height="30">
	       <td class="titlecell" ></td>
		<td class="titlecell" align="center" ></td>
	       <td class="titlecell" align="center" ></td>
	       <td class="titlecell" align="center"></td>
	       <td class="titlecell" align="center"></td>
	  </tr> 


     </table>
     </td>
</tr>
<%} %>
<!------------------------------------------用户留言区域（发件箱）----------------------------------------------->

					<%
if(false){
%>
<tr>
    <td align="center">
    <table class="areatable" cellpadding="0" cellspacing="0" border="0" id="table2">
	 <tr height="30">
	    <td class="areatitle" width="25%" align="left">已发信息</td>
	    <td class="areatitle" width="15%" align="center"><a href="#">收件人</a></td>
	    <td class="areatitle" width="15%" align="center"><a href="#">日期</a></td>
	     <td class="areatitle" width="15%" align="center"><a href="#">状态</a></td>
	    <td class="areatitle" width="15%" align="center"><a href="#">管理</a></td>

	    
	   
	 </tr>
        <tr>
	      <td class="separatorline" colspan="5"></td>
	 </tr>
	 <tr height="5">
	   <td  colspan="5"></td>
	 </tr>
       <%
      String subject1;
     String personfrom1;
     String sendDate1;
     String zhuangtai1;
     int id1;
     ShortMessage smess1=new ShortMessage();
       List list1= new ArrayList();
       List cdt1=new ArrayList();
    
       //获得发件人ID
       String name1=user.getCode();
       System.out.println(name1);
       cdt1.add("sendid="+name1);
       cdt1.add("smsstyle=1") ;
       cdt1.add("order by senddate  DESC");
       cdt1.add("limit 0,3");
       list1=smess1.query(cdt1);
       System.out.println(list1.size());
       if(list1.size()>0){
    	   for(int i=0;i<list1.size();i++){
    		   smess1=(ShortMessage)list1.get(i);
    		   id1=smess1.getId();
    		   subject1=smess1.getSubject();
    		   personfrom1=(String)UserCnNameMap.get(smess1.getSendId()+"");
    		   sendDate1=Tool.stringOfCnDate(smess1.getSendDate());
    		   zhuangtai1=smess1.getIfSee()==0?"已读":"未读";
    		%>   
    		<tr height="30">
	       <td class="titlecell" ">&nbsp;&nbsp;<a href="javascript:void(0)" onclick="showwinside(<%=id1 %>,'<%=subject1 %>')"><%=subject1 %></a></td>
		<td class="titlecell" align="center"><a href="javascript:void(0)" onclick="showwinside(<%=id1 %>,'<%=subject1 %>')"><%=personfrom1%><a></a></td>
	       <td class="titlecell" align="center"><a href="javascript:void(0)" onclick="showwinside(<%=id1 %>,'<%=subject1 %>')"><%=sendDate1%><a></a></td>
	       <td  width="15%" class="titlecell" align="center"><font color="red">new</font></td>
	       <td class="titlecell" align="center"><a href="ShortMessageAction.jsp?cmd=delete1&idlist=<%=id1 %> "  " ><font color="red">删除</font></a></td>
	 
    		
    		<% 
    	   }
       }else{
    	  %>
    	 <td colspan='3' class='titlecell'>当前您没有发出任何信息！</td>
 </tr>
    	  <% 
       }
    	   
     %>
     <%} %>

	<%--  <tr height="30">
	       <td class="titlecell" msgid="<%=id%>" msgcontent="<%=msgcontent%>">&nbsp;&nbsp;[<%=(i+1)%>] <%=href1%></td>
		<td class="titlecell" align="center"><%=persontoname%></td>
	       <td class="titlecell" align="center"><%=rs.getString("msgtime").substring(0,10)%></td>
	       <td class="titlecell" align="center"><%=readflag%></td>
	       <td class="titlecell" align="center"><%=delehref%></td>
	  </tr>
 --%>

     </table>
     </td>
</tr>

<!------------------------------------------系统公告区域----------------------------------------------->

<!-- <!-- <tr>

    <td align="center">
    <table class="areatable" cellpadding="0" cellspacing="0" border="0">
   
	 <tr height="30">
	    <td class="areatitle" colspan="2" width="20%" align="left">系统公告</td>
	   
	    <td class="areatitle" width="50%" align="center"></td>
	     
	    <td class="areatitle" align="right">更多>>&nbsp;</td>
	 </tr>
	
     <tr>
	      <td class="separatorline" colspan="5"></td>
	 </tr>
	  
	 <tr height="5">
	   <td  colspan="5"></td>
	 </tr>
	  


       <tr height="15">
           <td  colspan="5"></td>
       </tr>

     </table>
     </td> -->
</tr> 

<!------------------------------------------团员证补办区域----------------------------------------------->


</center>
</div>

<!----------------------------------------- （1）收件箱图层 ------------------------------------------------------>
<div id="msgdiv1" style="position:absolute;width:400px; height:250px;display:none;">
<table width="400" height="250"  border="0" align="center" cellpadding="-2" cellspacing="-2">
<tr>
<td align="center">
<form name="form_msg1" method="post" action="#">
      <table width="100%" height="100%" bgcolor="#cccccc" border="0" align="center" cellpadding="-2" cellspacing="-2" style="border: #9CA6C6 1px solid" id="table_msg1">
          <tr height="25" align="center" valign="middle">
            <td colspan="2" background="Images/bg_login.gif"><font color="#505875">=== 留言 ===</font></td>
          </tr>
          
          <tr height="50" style="font-size: 10pt;line-height:150%;">
            <td width="17%" align="right" valign="middle">发信人：</td>
            <td align="left" valign="middle"><input name="personfrom" type="text" size="41"已收消息
             maxlength="50" disabled></td>
          </tr>
          
          <tr height="27" >
            <td style="font-size: 10pt;line-height:150%;" align="right" valign="middle">主 &nbsp;题：</td>
            <td align="left" valign="middle"><input name="msgtitle" type="text" size="41" maxlength="50"></td>
          </tr>
          <tr>
             <td style="font-size: 10pt;" align="right" valign="top"><br>内 &nbsp;容：</td>
  			 <td align="left"><textarea rows="6" name="msgcontent" cols="40"></textarea></td>
		  </tr>
          <tr align="center" valign="top">
            <td  colspan="2">
               <input type="button" name="B2" value="回复" onClick="torecallmsg()">&nbsp;
               <input type="button" name="B2" value="返回" onClick="toupdatemsg()">&nbsp;
               <!--
               <input type="button" name="B1" value="删除" onClick="todelmsg()" onKeyDown="if(event.keyCode==13) todelmsg()">&nbsp;
               -->
            </td>
          </tr>
      </table>
<%-- <input type="hidden" name="personto" value="<%=useraccount%>"> 
<input type="hidden" name="promptarea" value=""> 
<input type="hidden" name="irow" value="">
<input type="hidden" name="eduplanid" value="">  --%>
</form>
</td>
</tr>
</table>
</div>

<!----------------------------------------- （2）发件箱图层 ------------------------------------------------------>
<div id="msgdiv2" style="position:absolute;width:400px; height:250px;display:none;">
<table width="400" height="250"  border="0" align="center" cellpadding="-2" cellspacing="-2">
<tr>
<td align="center">
<form name="form_msg2" method="post" action="#">
      <table width="100%" height="100%" bgcolor="#cccccc" border="0" align="center" cellpadding="-2" cellspacing="-2" style="border: #9CA6C6 1px solid">
          <tr height="25" align="center" valign="middle">
            <td colspan="2" background="Images/bg_login.gif"><font color="#505875">=== 留言 ===</font></td>
          </tr>
          
          <tr height="50" style="font-size: 10pt;line-height:150%;">
            <td width="17%" align="right" valign="middle">收信人：</td>
            <td align="left" valign="middle"><input name="personto" type="text" size="41" maxlength="50" disabled></td>
          </tr>
          
          <tr height="27" >
            <td style="font-size: 10pt;line-height:150%;" align="right" valign="middle">主 &nbsp;题：</td>
            <td align="left" valign="middle"><input name="msgtitle" type="text" size="41" maxlength="50"></td>
          </tr>
          <tr>
             <td style="font-size: 10pt;" align="right" valign="top"><br>内 &nbsp;容：</td>
  			 <td align="left"><textarea rows="6" name="msgcontent" cols="40"></textarea></td>
		  </tr>
          <tr align="center" valign="top">
            <td  colspan="2">
               <input type="button" name="B2" value="返回" onClick="javascript:msgdiv2.style.display='none';">
               <input type="button" name="B1" value="删除" onClick="todelmsg()" onKeyDown="if(event.keyCode==13) todelmsg()">&nbsp;
            </td>
          </tr>
      </table>
<%-- <input type="hidden" name="personfrom" value="<%=useraccount%>"> 
<input type="hidden" name="promptarea" value=""> 
<input type="hidden" name="irow" value="">
<input type="hidden" name="eduplanid" value="">  --%>
</form>
</td>
</tr>
</table>
</div>
<form name="form_save" action="mytips-msgrecallsave.jsp" method="post" >
      <input type="hidden" name="personfrom" value="()">
      <input type="hidden" name="personto" value="">
      <input type="hidden" name="msgtitle" value="">
      <input type="hidden" name="msgcontent" value="">
      <input type="hidden" name="id" value="">
</form>

<form name="form_delete" action="mytips-delete.jsp" method="post" >
      <input type="hidden" name="id" value="">
</form>

<form name="form_update" action="mytips-update.jsp" method="post" >
      <input type="hidden" name="id" value="">
      <input type="hidden" name="msgtime" value="">
      <input type="hidden" name="msgstate" value="">
</form>


</body>
</html>
