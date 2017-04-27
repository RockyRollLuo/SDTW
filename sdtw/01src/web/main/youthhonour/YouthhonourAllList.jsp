<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.SdtwConst"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="com.xietong.software.sdtw.youthhonour.YouthhonourUtil"%>
<%@ page import="com.xietong.software.sdtw.club.CurrentSemester"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@page import="com.xietong.software.base.Power"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%!
	private static Log log = LogFactory.getLog(com.xietong.software.common.PageControl.class);
%>
<%
//默认值定义
UserInfo userInfo = Tool.getUserInfo(request);
if(userInfo == null){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	return;
}
int academyid=0;
if(userInfo.hasFunPower(Power.UserAdminPower)) academyid=userInfo.getDeptId();

YouthhonourUtil yhUtil = new YouthhonourUtil();

int noticeid=ParamUtils.getIntParameter(request, "noticeid",-1);

//Youthhonour_notice
Youthhonour_notice yhNotice=new Youthhonour_notice();
if(noticeid!=-1){
	yhNotice=yhNotice.getById(noticeid);
}


%>
<head>
	<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css"/>
	<title> <%=request.getAttribute("describe")%> </title>
	<script src="<%=HeadConst.apache_url%>/main/js/listfunction_win8.js"></script>
	<script>
	function Reportfunc(cmd){
		var str="";
		if(cmd=="shangbaotw"){
			str="确定上报数据吗？上报后不可修改！";
		}else if(cmd=="gongbu"){
			str="确定公布结果吗？";
		}else if(cmd=="bugongbu"){
			str="确认撤销公示后，所有学院需重新上报！";
		}else if(cmd=="resetstu"){
			str="本学院学生需重新上报填写信息，学生已填写数据不会删除";
		}
		if(confirm(str)){
			window.location.href="Youthhonour_noticeAction.jsp?cmd="+cmd+"&noticeid=<%=noticeid%>";
		}
	}
	</script>
</head>
<body>
<jsp:include page="/main/jqueryui.jsp" flush="true"/>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr> 
	<td valign="top">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
 							<td height="26">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
                            		<tr>
                                		<td>
							            <div class="browsetitle title_css">
								            <div class="browsetitleleft">
									        	<div class="browsetitle001">五四评比表彰</div>
									        	<div class="browsetitle002"><%=XtUtil.getSpell("五四评比表彰")%></div>
							            	</div>
											<div class="browsetitleright">
											<div class="anniulist2">
												<ul>
												<%if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.ZZJS)){
													if(yhNotice.getTwReport()==SdtwConst.TWREPORT_WGB){%>
														<li><a href="#" onclick="javascript:Reportfunc('gongbu');">结果公示</a></li>
													<%}else if(yhNotice.getTwReport()==SdtwConst.TWREPORT_YGB){%>
														<li><a href="#" onclick="javascript:Reportfunc('bugongbu');">撤销公示</a></li>
													<%}%>
												<%}else if(userInfo.hasFunPower(Power.UserAdminPower)){
													if(yhUtil.getOneXyReportFlag(noticeid,academyid)==SdtwConst.XYREPORT_WSB){%>
<!-- 														<li class="browsetitle_lang"><a href="#" onclick="javascript:Reportfunc('resetstu');">重置学生上报</a></li> -->
<!-- 														<li class="browsetitle_lang"><a href="YouthhonourAppymodifyList.jsp">申请修改列表</a></li> -->
														<li><a href="#" onclick="javascript:Reportfunc('shangbaotw');">上报团委</a></li>
													<%}else{%>
														<li><a href="#">已上报团委</a></li>
													<%}
												}%>
													<li><a href="Youthhonour_noticeAction.jsp?cmd=list">返回</a></li>
												</ul>
											</div>
											</div>
										</div>	                                   
										</td>
                                	</tr>   
                                </table>
							</td>
  						</tr>
    					<form action="YouthhonourAllList.jsp" name="query" id="postForm" method="post">
  						<tr>
    						<td>
                            	<div class="browsetable2">
                            		<%=yhNotice.getNotice()%>
									<input type="hidden" name="noticeid" value="<%=noticeid%>">
									<input type="hidden" name="cmd" value="list">
                               	</div>
							</td>
						</tr>
						</form>
						<tr>
    						<td valign="top">
<table width="100%" border="0" align="center" cellpadding="2" cellspacing="0">
	<tr>
		<td>
		<div id="list" class="browsetable">
		
<table align="center" border="0" cellpadding="2" cellspacing="1" width="100%">
	<tr>
		<td bgcolor="#3992d0"><div class="browsetable004">序号</div></td>
		<td bgcolor="#3992d0"><div class="browsetable004">评比表彰内容</div></td>
		<td bgcolor="#3992d0"><div class="browsetable004">申请数</div></td>
		<td bgcolor="#3992d0"><div class="browsetable004">学院通过数</div></td>
		<td bgcolor="#3992d0"><div class="browsetable004">团委通过数</div></td>
		<td bgcolor="#3992d0"><div class="browsetable004">申请表</div></td>
	</tr>
	<%
	Map<Integer,String> yhNameMap=yhUtil.youthhonourName;
	Map map=yhUtil.getAllCountByType(noticeid, academyid);
	for(int i=1;i<yhNameMap.size()+1;i++){
		int[] num=(int[])map.get(i);
	%>
	<tr onmouseover="addClass(this,'data_bgcolor_over');" onmouseout="removeClass(this,'data_bgcolor_over');"<%if(i%2==0){%>class="data_bgcolor_odd" <%}else{%>class="data_bgcolor_even"<%}%>>
		<td class="browsetable005" align="center"><%=i%></td>
		<td class="browsetable005"><%=yhNameMap.get(i)%></td>
		<td class="browsetable005" align="center"><%=num[0]%></td>
		<td class="browsetable005" align="center"><%=num[1]%></td>
		<td class="browsetable005" align="center"><%=num[2]%></td>
		<td class="browsetable005" align="center"><a href="YouthHonourAction.jsp?cmd=list&noticeid=<%=noticeid%>&type=<%=i%>">查看</a></td>
	</tr>
	<%
	}
	yhNameMap.clear();
	map.clear();
%>
<tr height="20px">
	<td bgcolor="#3992d0" colspan="6"></td>
</tr>
</table>
		</div>
		</td>
	</tr>
</table>
			                </td>
  						</tr>
					</table>
				</td>
			</tr>
		</table>
	</td>
</tr>
</table>
</body>
</html>
