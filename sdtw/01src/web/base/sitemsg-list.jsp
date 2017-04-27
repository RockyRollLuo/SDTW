<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="java.sql.*" %>
<%
UserInfo userInfo = Tool.getUserInfo(request);
BaseUserCode user = new BaseUserCode();
if(userInfo == null){
		out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
		return;
}else{
	user = userInfo.getUserCode();
}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%
if(userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
%>
<link rel="stylesheet" type="text/css" href="../css/common-student.css">
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
.areatable a:link,.areatable a:hover,.areatable a:visited,.areatable a:active{
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
////////////////////////////////////////////////////////////////////////////////////////////////////////
// （1）显示收件箱信息
//
function displaymsg1(irow)
{ 
   rownum=parseInt(irow)+2;

   str=document.all.table1.rows(rownum).cells(1).personfrom;
   // 用于回复消息，发信人变为收信人
   document.form_save.personto.value = str;
   document.form_save.id.value = document.all.table1.rows(rownum).cells(0).msgid;

   pos=str.indexOf("(");
   if (pos>=0)
   {
      // 发信人信息，名字和账户
      personname=str.substring(0,pos);
      personaccount = str.substring(pos,str.length-1);
      document.form_msg1.personfrom.value = personname;
   }
   else
      document.form_msg1.personfrom.value=str;

   document.form_msg1.msgtitle.value = trimblank(document.all.table1.rows(rownum).cells(0).innerText);
   document.form_msg1.msgcontent.value = document.all.table1.rows(rownum).cells(0).msgcontent;

   document.form_delete.id.value = document.all.table1.rows(rownum).cells(0).msgid;
   document.form_update.id.value = document.all.table1.rows(rownum).cells(0).msgid;
   document.form_update.msgtime.value = document.all.table1.rows(rownum).cells(2).msgtime;
   document.form_update.msgstate.value = document.all.table1.rows(rownum).cells(3).innerText;

    //根据传递的参数确定显示的层
    msgdiv1.style.display='block';
    msgdiv1.style.left=130;
    msgdiv1.style.top=70;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////
// （1）回复收件人信息
//
function torecallmsg()
{
    document.all.table_msg1.rows(1).cells(0).innerText="收信人：";
    document.form_msg1.msgtitle.value = "Re:" + document.form_msg1.msgtitle.value;
    document.form_msg1.msgcontent.value ="";

    str ="<input type='button' name='B2' value='发送' onClick='tosaverecallmsg()'>&nbsp;";
    str +="<input type='button' name='B2' value='取消' onClick=\"msgdiv1.style.display='none'\">";

    document.all.table_msg1.rows(4).cells(0).innerHTML=str;

}
/////////////////////////////////////////////////////////////////////////////////////////
// 保存回复的消息
function tosaverecallmsg()
{
   msgdiv1.style.display='none';
   document.form_save.msgtitle.value = document.form_msg1.msgtitle.value;
   document.form_save.msgcontent.value = document.form_msg1.msgcontent.value;

   form_save.submit();
}

////////////////////////////////////////////////////////////////////////////////////////////////////////
// （2）显示发件箱信息
//
function displaymsg2(irow)
{ 
   rownum=parseInt(irow)+2;
   //document.form_msg2.personfrom.value = useraccount;
   document.form_msg2.personto.value = document.all.table2.rows(rownum).cells(1).innerText;
   document.form_msg2.msgtitle.value = trimblank(document.all.table2.rows(rownum).cells(0).innerText);
   document.form_msg2.msgcontent.value = document.all.table2.rows(rownum).cells(0).msgcontent;

   document.form_delete.id.value = document.all.table2.rows(rownum).cells(0).msgid;
   document.form_update.id.value = document.all.table1.rows(rownum).cells(0).msgid;


    //根据传递的参数确定显示的层
	msgdiv2.style.display='block';
	//divID.style.left=(document.body.clientWidth-240)/2;
	//divID.style.top=(document.body.clientHeight-139)/2;
       //divID.style.top=document.body.clientTop+100;

	msgdiv2.style.left=130;
	msgdiv2.style.top=70;

	//divID.style.left=(window.screen.availWidth-400)/2;
	//divID.style.top=(window.screen.availHeight-250)/2;
}
/////////////////////////////////////////////////////////////////////////////////////////
//删除消息
function todelmsg()
{
   form_delete.submit();
}

/////////////////////////////////////////////////////////////////////////////////////////
//  阅读信息后，修改消息readflag标记次数
// 收件箱
function toupdatemsg()
{
   form_update.submit();
   msgdiv1.style.display='none';
}

/////////////////////////////////////////////////////////////////////////////////////////
// 去除字符串中的空格
//
function trimblank(str)
{
   if (str!="")
   {
       //去除首尾空格
       //re = /(^\s*)|(\s*$)/g;
	//str=str.replace(re,"");

       //去除尾部空格
       //re = /(\s*$)/g;
	//str=str.replace(re,"");

       // 去除全部空格
	str=str.replace(/\s/g,"");
   }
   return str;
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
   				<tr height="30">
      				<td class="areatitle" colspan="2" width="10%" align="left">系统公告</td>
					<td class="areatitle" width="70%" align="center"></td>
					<td class="areatitle" align="right"><a href="bulletin-more.jsp">更多>></a>&nbsp;</td>
				</tr>
        		<tr>
       				<td class="separatorline" colspan="5"></td>
				</tr>
   				<tr height="5">
     				<td  colspan="5"></td>
				</tr>
				
				<%-- <tr height="25">
        			<td class="titlecell" width="5%">&nbsp;&nbsp;[<%=i%>]</td>
        			<td class="titlecell" colspan="2" style="text-align:left">
              			<a href="../bulletin-detail.jsp?id=<%=id%>" >&nbsp;<%=msgtitle%></a>
        			</td>
        			<td class="titlecell" align="right" style="padding-right:7px;"><%=rs.getString("MsgTime").substring(0,16)%></td>
  				</tr> --%>
				
				<tr height="15">
           			<td  colspan="5"></td>
       			</tr>
			</table>
		</td>
	</tr>

<!------------------------------------------用户留言区域（收件箱）----------------------------------------------->
<tr>
    <td align="center">
    <table class="areatable" cellpadding="0" cellspacing="0" border="0" id="table1">
	 <tr height="30">
	    <td class="areatitle" width="35%" align="left">用户留言（收件箱）</td>
	    <td class="areatitle" width="25%" align="center"><a href="#">发件人</a></td>
	    <td class="areatitle" width="15%" align="center"><a href="#">日期</a></td>

	    <td class="areatitle" width="15%" align="center"><a href="#">状态</a></td>
	    <td class="areatitle" width="10%" align="center"><a href="#">管理</a></td>
	 </tr>
        <tr>
	      <td class="separatorline" colspan="5"></td>
	 </tr>
	 <tr height="5">
	   <td  colspan="5"></td>
	 </tr>

	<%--  <tr height="30">
	       <td class="titlecell" msgid="<%=id %>" msgcontent="<%=msgcontent %>">&nbsp;&nbsp;[<%=(i+1)%>] <%=href1 %></td>
		<td class="titlecell" align="center" personfrom="<%=personfrom %>"><%=personfromname %></td>
	       <td class="titlecell" align="center" msgtime="<%=msgtime %>"><%=msgtime.substring(0,10) %></td>
	       <td class="titlecell" align="center"><%=readflag %></td>
	       <td class="titlecell" align="center"><%=delehref %></td>
	  </tr> --%>


     </table>
     </td>
</tr>

<!------------------------------------------用户留言区域（发件箱）----------------------------------------------->
<tr>
    <td align="center">
    <table class="areatable" cellpadding="0" cellspacing="0" border="0" id="table2">
	 <tr height="30">
	    <td class="areatitle" width="35%" align="left">用户留言（发件箱）</td>
	    <td class="areatitle" width="25%" align="center"><a href="#">收件人</a></td>
	    <td class="areatitle" width="15%" align="center"><a href="#">日期</a></td>

	    <td class="areatitle" width="15%" align="center"><a href="#">状态</a></td>
	    <td class="areatitle" width="10%" align="center"><a href="#">管理</a></td>
	 </tr>
        <tr>
	      <td class="separatorline" colspan="5"></td>
	 </tr>
	 <tr height="5">
	   <td  colspan="5"></td>
	 </tr>


	<%--  <tr height="30">
	       <td class="titlecell" msgid="<%=id%>" msgcontent="<%=msgcontent%>">&nbsp;&nbsp;[<%=(i+1)%>] <%=href1%></td>
		<td class="titlecell" align="center"><%=persontoname%></td>
	       <td class="titlecell" align="center"><%=rs.getString("msgtime").substring(0,10)%></td>
	       <td class="titlecell" align="center"><%=readflag%></td>
	       <td class="titlecell" align="center"><%=delehref%></td>
	  </tr> --%>


     </table>
     </td>
</tr>

<!------------------------------------------系统公告区域----------------------------------------------->

<tr>

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
     </td>
</tr>
<!------------------------------------------团员证补办区域----------------------------------------------->
<tr>
<table class="areatable" cellpadding="0" cellspacing="0" border="0">
<tr>
<td class="areatitle" colspan="2" width="20%" align="right"><a  href='bubanapply.jsp' > 团员证申请提示</a></td>
	 
	 </tr>
	 </table>
	 </tr>
</table>

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
            <td align="left" valign="middle"><input name="personfrom" type="text" size="41" maxlength="50" disabled></td>
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
<input type="hidden" name="personto" value="<%=user.getName()%>"> 
<input type="hidden" name="promptarea" value=""> 
<input type="hidden" name="irow" value="">
<input type="hidden" name="eduplanid" value=""> 
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
<input type="hidden" name="personfrom" value="<%=user.getName()%>"> 
<input type="hidden" name="promptarea" value=""> 
<input type="hidden" name="irow" value="">
<input type="hidden" name="eduplanid" value=""> 
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
