<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.sdtw.club.ClubUtil"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--社团变更负责人--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(ClubModifySponsor.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	ClubModifySponsor v = (ClubModifySponsor)request.getAttribute("fromBean");
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
List UserNameoptions = (List)request.getAttribute("UserNameoptions");
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
List ClubNameoptions = (List)request.getAttribute("ClubNameoptions");
List ClubTypeNameoptions = (List)request.getAttribute("ClubTypeNameoptions");
Club club = new Club();
if("".equals(v.getClubName())){
	List list = new ArrayList();
	List cdt = new ArrayList();
	cdt.add("ClubId='"+userInfo.getName()+"'");
	list = club.query(cdt);
	if(list.size()>0){
		club = (Club)list.get(0);
	}else{
		return;
	}
}else{
	club = club.getById(Tool.StrToInt(v.getClubName()));
}
		System.out.println(v.getClubName());
ClubUtil util = new ClubUtil();	
Map<String,Object>numMap = new HashMap<String,Object>();
numMap = util.getClubmimbers(club.getId());	
List allList = new ArrayList();
List sponsorList = new ArrayList();
List caiwuList = new ArrayList();
allList = (List)numMap.get("All_");
sponsorList = (List)numMap.get("IsManager_")==null?new ArrayList():(List)numMap.get("IsManager_");
numMap.clear();
List sponserids = new ArrayList();
List cdt1 = new ArrayList();
cdt1.add("id in("+Tool.join(",",allList)+")");
List UserCnNameOptions = COptionConst.getUserCnNameOptions(userInfo,"-1",cdt1);
String ClubId = "";
String flag = "text";
if (!userInfo.hasFunPower(Power.STUSER)) {
	flag = "hidden";
	ClubId = v.getClubId();
}
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
		 <script type="text/javascript" src="<%=HeadConst.apache_url%>/main/js/jquery.multiselect.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/js/jquery.multiselect.css">
		<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/themes/base/jquery-ui-1.8.4.custom.css" rel="stylesheet"/>
		<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/chosen/chosen.css" rel="stylesheet"/>
		<script language="javascript" src="<%=HeadConst.apache_url+"/main/" %>/js/chosen/chosen.jquery.js"></script>
		<script>
			var url_para = "<%=url%>";
			var dic = {<%=Tool.join(", ", diclist)%>};
			var keyfield = "<%=(String)request.getAttribute("keyfield")%>";
			var allfields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("allfields"))%>"];
			var fields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("fields"))%>"];
			var options= {<%=HtmlTool.getJsOptions(request)%>};
			$(function(){
				$("#ClubAcadeMyNew").chosen({width:'150px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到"});
			})
			function init() {
    				prepareForm("<%=request.getAttribute("classname")%>", dic, "<%=userInfo.getPower()%>");
    				$("#example").multiselect({
    				    header: false,
    				    height: 200,
    				    minWidth: 200,
    					selectedList: 10,//预设值最多显示10被选中项
    					noneSelectedText: '请选择',
    				    close: function(){
    				      var values= $("#example").val();
    					 $("#ClubAcademy").val(values);
    					}
    			 });
    				/* $("#example2").multiselect({
    				    header: false,
    				    height: 200,
    				    minWidth: 200,
    					selectedList: 10,//预设值最多显示10被选中项
    					noneSelectedText: '请选择',
    				    close: function(){
    				      var values= $("#example2").val();
    					 $("#ClubAcadeMyNew").val(values);
    					}
    			 }); */
			}
			function submitthis(flag){
				$('#CheckFlag').val(flag);
				document.postForm.submit();
			}
			
			function showmsg(uid,cid,checkflag) {//学生id
				if(uid==""||uid=="-1") {
					alert("请选择");
					return;
				}
			//	var checkflag = 1;
				var title = "查看学生信息";
				var clienth = 600;
				var clientw = 1366;
				parent.showDialog('<%=HeadConst.apache_url%>/main/club/EditClubModifySponsor.jsp?uid='+uid+'&cid='+cid+'&checkflag='+checkflag,clientw,clienth,title
						,{
					'确定':function(){
						parent.formsubmit();
					}
					
				});
			}
		</script>
	</head>
	<body onload="init();">
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">社团变更负责人</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("社团变更负责人") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="ClubModifySponsorAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						<%if(userInfo.hasFunPower(Power.STUSER)&&v.getCheckFlag().equals("")){ %>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) submitthis(0)">提交</a></li>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) submitthis('')">保存</a></li>
						<%} %>
						<%if(userInfo.hasFunPower(Power.UserAdminPower)&&v.getCheckFlag().equals("0")){ %>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) submitthis(2)">审核未通过</a></li>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) submitthis(1)">审核通过</a></li>
						<%} %>
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
		<div id="tabs">
					<ul>
							<li><a href="#tabs-1">社团变更负责人基本信息</a></li>
							<%
							if (!"".equals(v.getCheckFlag())) {%>
								<li><a href="#tabs-2">指导单位审核</a></li>
							<%}
							%>
					</ul>
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" name="cmd" value="<%=cmd%>">
				<input type="hidden" name="page" value="<%=currpage%>">
				<input type="hidden" name="Id" value="<%=v.getId()%>">
				<%=Tool.join("\n", forms)%>
				<div id="tabs-1" style="border: 0px;">
                    											<table bgcolor="#e3e5e8 " width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
                    												<tr>
                    													<td align="right" class="form_label">社团名称</td>
														    			<td align="left"  bgcolor="#ffffff">
																		<%=HtmlTool.renderSelect(ClubNameoptions, v.getClubName(), "ClubName", ""+club.getId(),true)%>
                    													</td>
                    													<td align="right" class="form_label">社团代码</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%=ClubId %>
																		<input type="<%=flag %>"  name="ClubId" value="<%=v.getClubId().equals("")?club.getClubId():v.getClubId()%>">
                    													</td>
													  				</tr>
													  				<tr>
													  				<td align="right" class="form_label">社团类别</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
																	<%=HtmlTool.renderSelect(ClubTypeNameoptions, v.getClubType(), "ClubType", ""+club.getClubType(),true)%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">原社团负责人</td>
														    			<td align="left"  bgcolor="#ffffff">
<%-- <%=HtmlTool.renderSelect(UserCnNameOptions, v.getClubAcademy(), "ClubAcademy", "")%> --%>
																	
																	<%
																	String yids = v.getClubAcademy();;
																	List bkIdsList = new ArrayList();
																	if (v.getId()==-1) {
																	if(sponsorList.size()>0){
																		for(int i=0;i<sponsorList.size();i++){
																			ClubMembers c = new ClubMembers();
																			c = (ClubMembers)sponsorList.get(i);
																			if (!"1".equals(c.getIdentity()))//本科
																			sponserids.add(c.getMemberName()+"");
																		}
																	}
																	yids = Tool.join(",",sponserids);
																	} 
																	%>
																	<%Map<String,BaseUserCode>userMap = new HashMap<String,BaseUserCode>();
																	userMap = util.getUserMap(yids);
																	if (yids.length()>0) {
																		String yidsArr[] = yids.split(",");
																		for (int i=0;i<yidsArr.length;i++) {
																			BaseUserCode user = userMap.get((String)yidsArr[i]);%>
																			<a style="color: red;" title="查看原社团负责人信息" href="javascript:showmsg(<%=user.getId()%>,<%=club.getId()%>,'1');"><%=user.getCnName() %> </a>
																		<%}
																	}
																	userMap.clear();
																	%>
																	<input type="hidden" id="ClubAcademy" name="ClubAcademy" value="<%=v.getClubAcademy().equals("")?yids:v.getClubAcademy()%>"/>
 																	<%-- <select id="example" name="example" multiple="multiple" style="width:400px">
																		<%=HtmlTool.renderMulSelectOption(UserCnNameOptions,v.getClubAcademy(),""+Tool.join(",",sponserids)) %>
																	</select> --%>
                    													</td>
													  				
                    													<td align="right" class="form_label">新社团负责人</td>
														    			<td align="left"  bgcolor="#ffffff">
														    				<select class=" chosen-select"id="ClubAcadeMyNew"  name="ClubAcadeMyNew"  style="width:400px"><!-- multiple="multiple" -->
																			<%=HtmlTool.renderMulSelectOption(UserCnNameOptions, v.getClubAcadeMyNew(), "")%>
																			</select>
																			<%
																			if("".equals(v.getCheckFlag())){//未提交%>
																				<a style="color: red;"  href="javascript:showmsg($('#ClubAcadeMyNew').val(),<%=club.getId()%>,'');">编辑</a>
																			<%} else {%>
																				<a style="color: red;"  href="javascript:showmsg($('#ClubAcadeMyNew').val(),<%=club.getId()%>,'1');">查看</a>
																			<%}
																			%>
																			
                    													</td>
													  				</tr>
<input type="hidden" id="CheckFlag"name="CheckFlag" value="<%=v.getCheckFlag()%>">
<input type="hidden" name="ApplyDate" value="<%=v.getApplyDate()%>">
<input type="hidden" name="AddTime" value="<%=Tool.stringOfDateTime(v.getAddTime())%>">
<input type="hidden" name="AddPerson" id="AddPerson" value="<%=("".equals(v.getAddPerson()))?userInfo.getId()+"":v.getAddPerson()%>"/>
<input type="hidden" name="ModiPerson" value="<%=v.getModiPerson()%>">  
<input type="hidden" name="ModiTime" id="ModiTime" size="0" value="<%=Tool.stringOfDateTime(v.getModiTime())%>">      												
                    											</table>
                    											</div>
                    											<%
                    											if((userInfo.hasFunPower(Power.STUSER)&&!"".equals(v.getCheckFlag()))||userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST)||userInfo.hasFunPower(Power.UserAdminPower)){
                    											%>
                    											<div id="tabs-2" style="border: 0px;">
                    											<table bgcolor="#e3e5e8 " width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
                    											<tr>
                    													<td align="right" class="form_label">指导单位意见</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea style="width: 100%;" name="CommentXy" id="CommentXy" cols="40" rows="4"><%=v.getCommentXy()%></textarea>
                    													</td>
													  				</tr>
                    											</table>
                    											</div>
                    											
                    											<%}else {%>
                    												<input type="hidden" id="CommentXy" name="CommentXy" value="<%=v.getCommentXy()%>"/>
                    											<%} %>
			</form>
			</div>
		</div>
		<script>
	$(function() {
		$( "#tabs" ).tabs();
		$("#tabs").tabs('option','active', 0); 
	});
	</script>
	</body>
</html>
