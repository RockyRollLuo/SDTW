<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="com.xietong.software.sdtw.youthhonour.YouthhonourUtil"%>
<%@ page import="com.xietong.software.sdtw.db.YouthHonour"%>
<%@ page import="com.xietong.software.sdtw.db.Academy"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="com.xietong.software.base.Power"%>
<%@ page import="com.xietong.software.base.SdtwConst"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>

<%
	//默认值定义
	UserInfo userInfo = Tool.getUserInfo(request);
	if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
	}
	Date mydate=new Date();
	YouthhonourUtil yhUtil=new YouthhonourUtil();
	
	//noticeid
	int noticeid=ParamUtils.getIntParameter(request, "noticeid",-1);
	Youthhonour_notice yhNotice=new Youthhonour_notice();
	yhNotice=yhNotice.getById(noticeid);
	
	//academyNameMap,youthhonorNameMap,youthHonorMap<type,Map<academyid,List<YouthHonor>>>
	Map academyMap=CEditConst.getAcademyNameMap(userInfo);
	Map youthHonorMap=yhUtil.getYouthhonourByXyByType(noticeid, userInfo);
	Map<Integer,String> youthhonorNameMap=(Map<Integer,String>)yhUtil.youthhonourName;	
	
	//academyid
	int academyid=0;
	if(userInfo.hasFunPower(Power.UserAdminPower)){
		academyid=userInfo.getDeptId();
	}
	String myAcademyidStr=""+academyid;
%>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css"/>
		<title> <%=request.getAttribute("describe")%> </title>
		<script src="<%=HeadConst.apache_url%>/main/js/listfunction_win8.js"></script>
		<script src="../js/common.js"></script>
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
		
		function showwinside(){
			var url='Youthhonour-print.jsp?noticeid=<%=noticeid%>';       
// 			openWindow(url,"720,600");
			window.open(url,"_blank","width=794px,height=1090px,left="+(screen.width-794)*0.5+",top=-20,directories=no,location=0,menubar=no,resizable=no,status=no,titlebar=no,toolbar=no"); 
		}
		</script>
	</head>
	<body onload="init();">
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
													          <div class="browsetitle001">五四评比表彰申请表汇总表</div>
													          <div class="browsetitle002"></div>
												          </div>
												          <div class="browsetitleright">
												              <div class="anniulist2">
															  <ul>
																	<%if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.ZZJS)){
																		if(yhNotice.getTwReport()==SdtwConst.TWREPORT_WGB){%>
																			<li><a href="#" onclick="javascript:Reportfunc('gongbu');">结果公示</a></li>
																		<%}else if(yhNotice.getTwReport()==SdtwConst.TWREPORT_YGB){%>
																			<li class="browsetitle_lang"><a href="#" onclick="javascript:showwinside();">打印公示文件</a></li>
																			<li><a href="#" onclick="javascript:Reportfunc('bugongbu');">撤销公示</a></li>
																		<%}%>
																	<%}else if(userInfo.hasFunPower(Power.UserAdminPower)){
																		if(yhUtil.getOneXyReportFlag(noticeid,academyid)==SdtwConst.XYREPORT_WSB){%>
<!-- 																			<li class="browsetitle_lang"><a href="#" onclick="javascript:Reportfunc('resetstu');">重置学生上报</a></li> -->
																			<li><a href="#" onclick="javascript:Reportfunc('shangbaotw');">上报团委</a></li>
																		<%}else{%>
																			<li><a href="#">已上报团委</a></li>
																		<%}
																	}%>
																	<li><a href="Youthhonour_noticeAction.jsp?cmd=list">返回</a></li>
													            </ul>
												              </div>
												           </div>
											            </div>	                                   </td>
                                </tr>    										</table>
										</td>
  									</tr>
    								<form action="Youthhonour-summary.jsp" name="query" id="postForm" method="post">
  									<tr>
    									<td>
		                            	<div class="browsetable2">
											<input type="hidden" name="cmd" value="list">
											<table>
												<tr>
													<td><%=yhNotice.getNotice()%></td>
												</tr>
											</table>
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
	<td bgcolor="#3992d0" width="5%"><div class="browsetable004">序号</div></td>
	<td bgcolor="#3992d0" width="30%"><div class="browsetable004">申报项目</div></td>
	<td bgcolor="#3992d0"><div class="browsetable004">申报名单</div></td>
</tr>
<%
// for(Iterator it=youthhonorNameMap.entrySet().iterator();it.hasNext();){
 	for (Map.Entry<Integer, String> entry : youthhonorNameMap.entrySet()) {
// 	int type=Integer.parseInt(String.valueOf(it.next()));
	int type=entry.getKey(); 
	Map<String,List<YouthHonour>> map=(Map<String,List<YouthHonour>>)youthHonorMap.get(type)==null?new HashMap():(Map)youthHonorMap.get(type);//Map<academyid,List<YouthHonor>>
%>
<tr onmouseover="addClass(this,'data_bgcolor_over');" onmouseout="removeClass(this,'data_bgcolor_over');"<%if(type%2==0){%>class="data_bgcolor_odd" <%}else{%>class="data_bgcolor_even"<%}%>>
	<td class="browsetable005"><%=type%></td>
	<td class="browsetable005"><%=youthhonorNameMap.get(type)%></td>
	<td class="browsetable005" >
	<% 
	//--------------------------学院-----------------------
	if(userInfo.hasFunPower(Power.UserAdminPower)){
		List<YouthHonour> list1=(List<YouthHonour>)map.get(myAcademyidStr);
		if(list1!=null){
			for(int k=0;k<list1.size();k++){
				YouthHonour yh=(YouthHonour)list1.get(k);
				int id=yh.getId();
				String val1=yh.getVal1();
				if(k!=list1.size()-1){
					%><a href="YouthHonourAction.jsp?noticeid=<%=noticeid%>&type=<%=type%>"><%=val1%></a>,<%
				}else{
					%><a href="YouthHonourAction.jsp?noticeid=<%=noticeid%>&type=<%=type%>"><%=val1%></a><%
				}
			}//end for(list1)
		}
	}
	//--------------------------团委-----------------------
	if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.ZZJS)){
		for(Iterator it2=map.keySet().iterator();it2.hasNext();){
			String xyid=(String)it2.next();
			List mlist=(List)map.get(xyid);
			
			%><%=academyMap.get(xyid)%>(<%
			
			for(int k=0;k<mlist.size();k++){
				YouthHonour yh=(YouthHonour)mlist.get(k);
				int id=yh.getId();
				String val1=yh.getVal1();
				if(k!=mlist.size()-1){
					%><a href="YouthHonourAction.jsp?noticeid=<%=noticeid%>&type=<%=type%>"><%=val1%></a>,<%
				}else{
					%><a href="YouthHonourAction.jsp?noticeid=<%=noticeid%>&type=<%=type%>"><%=val1%></a><%
				}
			}
			%>)<br/><%
		}
	}
	map.clear();
	%>
	</td>
</tr>
<%}//end for(1~24)
youthHonorMap.clear();
youthhonorNameMap.clear();
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
