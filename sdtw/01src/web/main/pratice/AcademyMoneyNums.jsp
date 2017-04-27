`<%@page import="com.xietong.software.sdtw.db.Practice"%>
<%@page import="com.xietong.software.sdtw.db.AcademyMoneyNums"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.sdtw.pratice.PracticeUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.xietong.software.sdtw.db.Academy_Money_Nums"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@page import="com.xietong.software.sdtw.db.Academy"%>
<%@page import="java.util.Map"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.sdtw.StandardupGradeUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.sdtw.XtUtil"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
Log log = LogFactory.getLog(Academy_Money_Nums.class);
log.debug("List");
String msg = (String)request.getAttribute("msg");
if ((msg != null)) {
		out.print(HtmlTool.msgBox(request, msg));
		return;
}
String cmd = ParamUtils.getParameter(request, "cmd", "list");
int currpage = ParamUtils.getIntParameter(request, "page", 1);
UserInfo userInfo = Tool.getUserInfo(request);
if(userInfo == null){
		out.print(HtmlTool.msgBox(request, "请先登录"));
		return;
}
String remark = ParamUtils.getParameter(request,"_Remark_","-1");//立项表id
Practice p = new Practice();
if (Tool.StrToInt(remark)!=-1&&p.getById(Tool.StrToInt(remark))!=null) {
	p = p.getById(Tool.StrToInt(remark));
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<jsp:include page="/main/jqueryui.jsp" flush="true"/>
<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
<script src="<%=HeadConst.apache_url%>/main/js/listfunction_win8.js"></script>
<script src="<%=HeadConst.apache_url%>/main/js/common.js"></script>
<style>
input, select {height: 15px;line-height: 15px;width: 60%;} 
form tr td {padding: 0px;}
</style>
<script>
function submitthis() {
	$('#postForm').submit();
}
function checkisDouble(obj) {
	if (!isDouble(obj.val())) {
		alert("请录入正确数值！")
		obj.val("")
		return;
	}
}
function checkisInteger(obj) {
	if (!isInteger(obj.val())) {
		alert("请录入正确数值！")
		obj.val("")
		return;
	}
}
function returnList(currpage) {
	window.location = "PracticeAction.jsp?page=" + currpage;
}
</script>
</head>
<body>
<!-- <input type="button"  value="保存" style="height: 20px;line-height: 15px;width: 10%;margin: 5px;float: right;" onclick="submitthis();"/> -->
<form action="AcademyMoneyNumsAction.jsp" method="post" name="postForm" id="postForm">
<input id="cmd" name="cmd" value="saveAcademyMoneyNums" type="hidden"/>
<input id="Remark" name="Remark" value="<%=remark%>" type="hidden"/>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" style="background-color: #e3e5e8;">
			<tr> 
				<td valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
    									<td valign="top">
      										<table width="100%" border="0" align="center" cellpadding="2" cellspacing="0">
      										
      										<tr>
    									<td height="26">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
                               <tr>
                                   <td>
											            <div class="browsetitle title_css">
												            <div class="browsetitleleft">
													          <div class="browsetitle001"><%=p.getPracticeSubject() %>经费</div>
													          <div class="browsetitle002"><%=XtUtil.getSpell(p.getPracticeSubject()+"经费")%></div>
												          </div>
												          <div class="browsetitleright">
												              <div class="anniulist2">
													           <ul>
														            <%-- <li class="browsetitle_lang"><a href="javascript:javascript:document.query.cmd.value = 'excel'; document.query.submit();">导出Excel</a></li>
														            <li><a href="javascript:deleteList('<%=request.getAttribute("classname")%>', url_para);">删除</a></li>
														            <li><a href="javascript:addNew('<%=request.getAttribute("classname")%>', url_para);">增加</a></li>
														            <li><a href="javascript:document.query.submit();">查询</a></li> --%>
														            <li ><a href="javascript:returnList(<%=currpage%>);">返回</a></li>
														            <%
																	if (userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.SHSJ)) {
																	%>
														            <li><a href="javascript:submitthis();">保存</a></li>
														            <%} %>
														            <%-- <li class="browsetitle_lang"><a href="javascript:setHonor('<%=request.getAttribute("classname")%>',url_para');">分配荣誉</a></li>
														            <li><a href="javascript:checkPassOrNo('<%=request.getAttribute("classname")%>',2,url_para,'XyCheckFlag=2');">审核不通过</a></li>
														            <li><a href="javascript:checkPassOrNo('<%=request.getAttribute("classname")%>',1,url_para,'XyCheckFlag=1');">审核通过</a></li> --%>
													            </ul>
												              </div>
												           </div>
											            </div>	                                   </td>
                                	</tr>    										
                                	</table>
										</td>
  									</tr>
      										
        										<tr>
          											<td>
														<div id="list" class="browsetable">
														<table cellspacing="0" cellpadding="2" border="0"
															width="100%" align="center">
															<tbody>
																<tr>
																<td style="width: 2%" onclick="javascript:setOrderBy('StandardUpGradeName', '')" nowrap="" bgcolor="#3992d0">
																		<div class="browsetable004">序号</div>
																	</td>
																	<td onclick="javascript:setOrderBy('StandardUpGradeName', '')" nowrap="" bgcolor="#3992d0">
																		<div class="browsetable004">学院</div>
																	</td>
																	<td style="width: 7%" onclick="javascript:setOrderBy('Principal', '')" nowrap="" bgcolor="#3992d0">
																	<div class="browsetable004">名额/(个)</div>
																	</td>
																	<td style="width: 7%" onclick="javascript:setOrderBy('Principal', '')" nowrap="" bgcolor="#3992d0">
																	<div class="browsetable004">经费/(元)</div>
																	</td>
																	
																	<td style="width: 2%" onclick="javascript:setOrderBy('StandardUpGradeName', '')" nowrap="" bgcolor="#3992d0">
																		<div class="browsetable004">序号</div>
																	</td>
																	<td onclick="javascript:setOrderBy('StandardUpGradeName', '')" nowrap="" bgcolor="#3992d0">
																		<div class="browsetable004">学院</div>
																	</td>
																	<td style="width: 7%" onclick="javascript:setOrderBy('Principal', '')" nowrap="" bgcolor="#3992d0">
																	<div class="browsetable004">名额/(个)</div>
																	</td>
																	<td style="width: 7%" onclick="javascript:setOrderBy('Principal', '')" nowrap="" bgcolor="#3992d0">
																	<div class="browsetable004">经费/(元)</div>
																	</td>
																	
																	
																</tr>
																<tr>
																<td colspan="4" valign="top" style="padding: 0px;">
																<table cellspacing="1" cellpadding="0" border="0"width="100%" align="center">
																<tbody>
																	<%
																StandardupGradeUtil util = new StandardupGradeUtil();
																PracticeUtil putil = new PracticeUtil();
																List list = new ArrayList();
																list = util.getAcademyListFlag(-1);
																Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);
																Map map = new HashMap();
																map = putil.getAcademyMoneyNumsMap(remark);
																if(list.size()>0){
																	String d = "odd";
																	int num = list.size()%2==0?list.size()/2:list.size()/2+1;
																	for (int i=0;i<num;i++) {
																		if (i%2==0) {
																			d = "even";
																		}else{
																			d = "odd";
																		}
																		Academy v = new Academy();
																		AcademyMoneyNums amn = new AcademyMoneyNums();
																		v = (Academy)list.get(i);
																		if (map.get(v.getId()+"")!=null) {
																			amn = (AcademyMoneyNums)map.get(v.getId()+"");
																		}
																		%>
																
																<tr onmouseover="addClass(this,'data_bgcolor_over');" onmouseout="removeClass(this,'data_bgcolor_over');"class="data_bgcolor_<%=d %>" style="cursor: pointer;" >
																	
																	<td class="browsetable005" align="center" style="width: 2%"><%=i+1 %></td>
																	<td class="browsetable005" align="center"><%=AcademyNameMap.get(v.getId()+"") %><input id="Sno<%=i %>" name="Sno<%=i %>" type="hidden" value="<%=v.getId()%>"/></td>
																	<td class="browsetable005" align="center" style="width: 15%"><input onkeyup="checkisInteger($('#Type<%=i %>'))" id="Type<%=i %>" name="Type<%=i%>" value="<%=(amn.getType()==-1||amn.getType()==0)?"":amn.getType()%>"/> </td>
																	<td class="browsetable005" align="center" style="width: 15%"><input onkeyup="checkisDouble($('#Money<%=i%>'))" id="Money<%=i%>" name="Money<%=i%>" value="<%=amn.getMoney()==0.0?"":amn.getMoney()%>"/> </td>
																</tr>
																	<%}
																%>
																<%}
																%>
																</tbody>
																</table>
																</td>
																<td colspan="4" valign="top" style="padding: 0px;">
																<table cellspacing="1" cellpadding="0" border="0"width="100%" align="center">
																<tbody>
																	<%
																if(list.size()>0){
																	String d = "even";
																	int num = list.size()%2==0?list.size()/2:list.size()/2+1;
																	for (int i=num;i<list.size();i++) {
																		if (i%2==0) {
																			d = "odd";
																		}else{
																			d = "even";
																		}
																		Academy v = new Academy();
																		v = (Academy)list.get(i);
																		Academy_Money_Nums amn = new Academy_Money_Nums();
																		v = (Academy)list.get(i);
																		if (map.get(v.getId()+"")!=null) {
																			amn = (Academy_Money_Nums)map.get(v.getId()+"");
																		}
																		%>
																
																<tr onmouseover="addClass(this,'data_bgcolor_over');" onmouseout="removeClass(this,'data_bgcolor_over');"class="data_bgcolor_<%=d %>" style="cursor: pointer;" >
																	
																	<td class="browsetable005" align="center" style="width: 2%"><%=i+1 %></td>
																	<td class="browsetable005" align="center"><%=AcademyNameMap.get(v.getId()+"") %><input id="Sno<%=i %>" name="Sno<%=i%>" type="hidden" value="<%=v.getId()%>"/></td>
																	<td class="browsetable005" align="center" style="width: 15%"><input onkeyup="checkisInteger($('#Type<%=i %>'))" id="Type<%=i %>" name="Type<%=i %>" value="<%=(amn.getType()==-1||amn.getType()==0)?"":amn.getType()%>"/> </td>
																	<td class="browsetable005" align="center" style="width: 15%"><input onkeyup="checkisDouble($('#Money<%=i%>'))" id="Money<%=i%>" name="Money<%=i%>" value="<%=amn.getMoney()==0.0?"":amn.getMoney()%>"/> </td>
																</tr>
																	<%}
																%>
																<%}
																%>
																</tbody>
																</table>
																</td>
																</tr>
															</tbody>
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
		</form>
</body>
</html>