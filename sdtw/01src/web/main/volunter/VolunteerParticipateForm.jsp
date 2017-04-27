<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.mysql.fabric.xmlrpc.base.Array"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--志愿活动报名表-学生素质拓展培养认证单-志愿活动--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>

<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(VolunteerParticipate.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	VolunteerParticipate v = (VolunteerParticipate)request.getAttribute("fromBean");
	if (v == null) {
    		out.print(HtmlTool.msgBox(request, "请先调用Action.jsp！"));
    		return;
	}
	log.debug(request.getAttribute("classname") + "Form");
	String[] dickeys = (String[])request.getAttribute("dickeys");
	String[][] dicvalues = (String[][])request.getAttribute("dicvalues");
	List diclist = new ArrayList();
	for (int i = 0; i < dickeys.length; i ++) {
    		diclist.add("\"" + dickeys[i] + "\": [\"" + Tool.join("\", \"", dicvalues[i]) + "\"]");
	}
	String projectid = ParamUtils.getParameter(request, "_ActivityId_", "");
	System.out.println(projectid);
	Map extMaps = (Map)request.getAttribute("Ext");
	List paras = HttpTool.getSavedUrlForm(request, "Ext");
	List urls = (List)paras.get(0);
	List forms = (List)paras.get(1);
	urls.addAll((List)paras.get(2));
	forms.addAll((List)paras.get(3));
	String url = Tool.join("&", urls);
	
	//默认值定义
	UserInfo userInfo = Tool.getUserInfo(request);
	if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
	}
	BaseUserCode user= userInfo.getUserCode();

	Honor honor= new Honor();
	List list1=new ArrayList();
	List cdt= new ArrayList();
	cdt.add("activityid="+projectid);
	list1=honor.query(cdt);
	List rongyulist = new ArrayList();
	List list2= new ArrayList();
	List cdt2= new ArrayList();
	if(list1.size()>0){
		OptionBean ob=new OptionBean("","");
		rongyulist .add(ob);
		for(int i=0;i<list1.size();i++){
		honor=(Honor)list1.get(i);
		int geshu=honor.getIsEnable();
		VolunteerParticipate vp= new VolunteerParticipate();
		cdt2.add("honourname='"+honor.getId()+"'");
		list2=vp.query(cdt2);
		if(list2.size()<honor.getIsEnable()){
		ob=new OptionBean(honor.getHonorName()+"(剩余"+(honor.getIsEnable()-list2.size()+")"),honor.getId()+"");
		rongyulist .add(ob);
		}else{
			if(v.getHonourName().equals(honor.getId()+"")){
				ob=new OptionBean(honor.getHonorName(),""+honor.getId());
				rongyulist .add(ob);
			}
		}
		
		cdt2.clear();
		}
	}
	
	
	
	
List VolunActivityNameoptions = (List)request.getAttribute("VolunActivityNameoptions");
List EvaluationTypeoptions = (List)request.getAttribute("EvaluationTypeoptions");

%>
<%!
public List getOptions(){
	List list = new ArrayList();
	OptionBean ob4=new OptionBean("优秀","优秀");

	OptionBean ob1=new OptionBean("良好","良好");
	OptionBean ob2=new OptionBean("一般","一般");
	list.add(ob4);
	list.add(ob1);
	list.add(ob2);
	
	
	return list;
}


%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
		<script>
			var url_para = "<%=url%>";
			var dic = {<%=Tool.join(", ", diclist)%>};
			var keyfield = "<%=(String)request.getAttribute("keyfield")%>";
			var allfields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("allfields"))%>"];
			var fields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("fields"))%>"];
			var options= {<%=HtmlTool.getJsOptions(request)%>};
			function init() {
    				prepareForm("<%=request.getAttribute("classname")%>", dic, "<%=userInfo.getPower()%>");
			}
		</script>
	</head>
	<body onload="init();">
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<div class="browsetitle">
			<div class="browsetitleleft">
			<%
			String biaoti="志愿活动报名表";
			int checkflag= ParamUtils.getIntParameter(request, "_CheckFlag_", -1);
			if(checkflag==1){
				biaoti="志愿活动考核荣誉分配";
			}
			
			%>
				<div class="browsetitle001"><%=biaoti %></div>
				
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						 <li> <a href="VolunteerActivityAction.jsp" >返回</a></li> 
						 	<%
						int  addacunt= ParamUtils.getIntParameter(request, "_addacunt_", -1);
						if( addacunt==user.getId ()){
						%>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) document.postForm.submit();">保存</a></li>
						<%} %>
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" name="cmd" value="<%=cmd%>">
				<input type="hidden" name="ActivityId" value="<%=projectid%>">
				<%=Tool.join("\n", forms)%>
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
<input type="hidden" name="Id" value="<%=v.getId()%>">
                                                                   <tr>
                                                                   <td align="right" class="form_label">志愿活动</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(VolunActivityNameoptions, "" + v.getActivityId(), "ActivityId", "-1",true)%>
                    													</td>
                                                                   
                                                                   
                                                                   </tr>
                    												<tr>
                    												
                    													<td align="right" class="form_label">学生学号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Sno" id="Sno" size="20" maxsize="20" value="<%=v.getSno()%>">
                    													</td>
                    													
													  				</tr>
                    											<%if(v.getCheckFlag()==1){ %>
                    												<tr>
                    													<td align="right" class="form_label">荣誉名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														
                    														<%=HtmlTool.renderSelect(rongyulist, v.getHonourName(), "HonourName", "-1")%>
                    														
                    													</td>
                    													请于志愿活动列表页，设置本活动的荣誉奖项后再进行荣誉分配
													  				</tr>
                    												<tr style="display: none;">
                    													<td    align="right" class="form_label">审核标志</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CheckFlag" id="CheckFlag" value="<%=v.getCheckFlag()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">评价等级</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(getOptions(), v.getEvaluation(), "Evaluation", "-1")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">服务时长</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Servicelenth" id="Servicelenth" value="<%=v.getServicelenth()%>">
                    													</td>
													  				</tr>
													  				<%} %>
<input type="hidden" name="Apptime" value="<%=v.getApptime()%>">
<input type="hidden" name="Addfilelist" value="<%=v.getAddfilelist()%>">
                    											</table>
			</form>
		</div>
	</body>
</html>
