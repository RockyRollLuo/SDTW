<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.SdtwConst"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="com.xietong.software.sdtw.rzd.StudentRzdUtil"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%!
	private static Log log = LogFactory.getLog(com.xietong.software.common.PageControl.class);
%>
<%
String cmd = ParamUtils.getParameter(request, "cmd", "list");
int currpage = ParamUtils.getIntParameter(request, "page", 1);

//默认值定义
UserInfo userInfo = Tool.getUserInfo(request);
if(userInfo == null){
   		out.print(HtmlTool.msgBox(request, "请先登录"));
   		return;
}

StudentRzdUtil srUtil=new StudentRzdUtil();
int stuid=userInfo.getId();

//更新StudentRzd表,提取各个表信息存入StudentRzd
int num=srUtil.updateStudentRzd(userInfo);

//认证单类型map,rzdMap
// Map rzdTypeMap=CEditConst.getStudentRzdTypeNameMap(userInfo);
Map rzdTypeMap=srUtil.rzdTypeMap;
Map rzdMap=srUtil.getAllRzdByType(stuid);//StudentRzd表中

Map checkMap=srUtil.getCheckMap();
Map modifyMap=srUtil.getModifyMap();
%>
<head>
	<title>学生拓展培养计划认证单</title>
	<jsp:include page="/main/jqueryui.jsp" flush="true" />
	<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/themes/base/jquery-ui-1.8.4.custom.css" rel="stylesheet"/>
	<link rel="stylesheet" type="text/css" href="../css/common-student.css"/>
	<script src="../js/tablelist.js"></script>
	<script>
	function actionFunc(id,cmd,obj){
		var str=false;
		if(cmd=="delete") str="确定删除此条信息吗？";
		if(cmd=="submit") str="提交后不可修改，确定提交吗？";
		if(confirm(str)){
			$.ajax({
				type:"post",			
				url:"StudentRzdStudentAction.jsp?cmd="+cmd+"&id="+id,
				dataType:"json",
				success:function(data){
					//alert(data.msg);
					//将此行删除
					if(cmd=="delete")
						obj.parentNode.parentNode.parentNode.removeChild(obj.parentNode.parentNode);
					if(cmd=="submit"){
						var tdObj=obj.parentNode;
						var aObjs=obj.parentNode.getElementsByTagName("a");
						tdObj.removeChild(aObjs[0]);
						tdObj.removeChild(aObjs[0]);
					}
				},
				error:function(data){
					alert("操作失败");	
				}
			});
		}
	}
	</script>
</head>
<body>
<%
String strposition = "组织建设>>五四评比表彰>>";
String strfunction ="学生拓展培养计划认证单";
String strhelpwords = "申请表。";
%>
<%@ include file="/student/pagetop-positionandhelp.jsp" %>

<table class="command-table">
<tr>
	<td>
		<a href="StudentRzdStudentForm.jsp?cmd=create">添加</a>
		<a href="StudentRzdStudent-choose.jsp">打印</a>
		<a href="StudentRzdStudent-state.jsp">打印记录</a>
	</td>
</tr>    
</table>

<div id="tabs" style="font-size:14px;font-family:Microsoft Yahei;width:89%;margin:10px auto;">
	<ul>
	<%for(Iterator it=rzdTypeMap.keySet().iterator();it.hasNext();){
		int type=(Integer)it.next();
		String typename=(String)rzdTypeMap.get(type);%>
		<li><a href="#tabs-<%=type%>"><%=typename%></a></li>
	<%}%>
	</ul>	

	<%for(Iterator it=rzdTypeMap.keySet().iterator();it.hasNext();){
		int type=(Integer)it.next();
		String typename=(String)rzdTypeMap.get(type);
	%>
	<div id="tabs-<%=type%>" style="border:0px;padding:0px; width: 100%">
	<table class="content-table" style="width: 100%">
		<tr>
			<th width="8%">序号</th>
			<th width="26%">组织/活动名称</th>
			<th width="18%">主办/主管/接受单位</th>
			<th width="12%">起止时间</th>
			<th width="12%">成果/经历</th>
			<th width="10%">审核结果</th>
			<th>操作</th>
		</tr>
	<%	//
			List mlist=(List<StudentRzd>)rzdMap.get(type)==null?new ArrayList():(List<StudentRzd>)rzdMap.get(type);
			if(mlist.size()>0){
			for(int i=0;i<mlist.size();i++){
				StudentRzd oneRzd=(StudentRzd)mlist.get(i);
				int id=oneRzd.getId();		
	%>
				<tr>
					<td><%=i+1%></td>
					<td><%=oneRzd.getValue1()%></td>
					<td><%=oneRzd.getValue2()%></td>
					<td><%=oneRzd.getValue3()%></td>
					<td><%=oneRzd.getValue4()%></td>
					<td><%=checkMap.get(oneRzd.getCheckflag())%></td>
					<td>
					<%if(oneRzd.getModifyflag()==SdtwConst.RZDMODIFY_YCZ){//系统中抽取的%>
					<%}else{
						if(oneRzd.getModifyflag()==SdtwConst.RZDMODIFY_WTJ){//未提交%>
							<a href="#" onclick="javascript:actionFunc('<%=id%>','submit',this);return false;">提交</a>
							<a href="StudentRzdStudentForm.jsp?cmd=update&tabActive=<%=type-1%>&id=<%=id%>">修改</a>
							<a href="#" onclick="javascript:actionFunc('<%=id%>','delete',this);return false;">删除</a>
						<%}else if(oneRzd.getModifyflag()==SdtwConst.RZDMODIFY_YTJ&&oneRzd.getCheckflag()==SdtwConst.RZDCHECK_WTG){//已提交且审核未通过%>
							<a href="StudentRzdStudentForm.jsp?cmd=update&tabActive=<%=type-1%>&id=<%=id%>">修改</a>
							<a href="#" onclick="javascript:actionFunc('<%=id%>','delete',this);return false;">删除</a>
						<%}%>
<%-- 						<a href="#" onclick="javascript:actionFunc('<%=id%>','delete',this);return false;">删除</a> --%>
					<%}%>
						<a href="StudentRzdStudentForm.jsp?cmd=view&tabActive=<%=type-1%>&id=<%=id%>">查看</a>
					</td>
				</tr>
			<%}%>
				<tr>
					<th colspan="8"></th>
				</tr>
		<%}else{%>
			<tr>
				<td colspan="7">无信息！</td>
			</tr>
		<%}%>
		</table>
			</div>
		<%}//end for
		rzdTypeMap.clear();
		rzdMap.clear();
		checkMap.clear();
		modifyMap.clear();
		
%>	
	
</div>
<%
int tabActive=ParamUtils.getIntParameter(request, "tabActive", 0);
%>
<script>
$(function() {
	$("#tabs").tabs();
	$("#tabs").tabs('option','active',<%=tabActive%>); 
});
</script>	
	
</body>
</html>
