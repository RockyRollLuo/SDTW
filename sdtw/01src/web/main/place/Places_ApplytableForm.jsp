<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--团委场地申请--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(Places_Applytable.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	Places_Applytable v = (Places_Applytable)request.getAttribute("fromBean");
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
	String[] labelclass = {"labeloff", "labeloff", "labeloff", "labeloff"};

List YesNooptions = (List)request.getAttribute("YesNooptions");
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");

List cdt3 = new ArrayList();
cdt3.add("roles=3");
List  UserNameoptions= COptionConst.getUserCnNameOptions(userInfo,"请选择", cdt3);
List ClassesNameoptions = (List)request.getAttribute("ClassesNameoptions");
List timeOptions=new ArrayList();
OptionBean ob= new OptionBean("","");
OptionBean ob1= new OptionBean("上午9:00-11:30","上午9:00-11:30");
OptionBean ob2= new OptionBean("上午14:00-17:30","上午14:00-17:30");
OptionBean ob3= new OptionBean("上午18:00-21:00","上午18:00-21:00");
timeOptions.add(ob);
timeOptions.add(ob1);
timeOptions.add(ob2);
timeOptions.add(ob3);
List placeoptions =new ArrayList();
Places  ica= new Places();
List cdt= new ArrayList();
List list1= new ArrayList();
list1=ica.query(cdt);
OptionBean ob4= new OptionBean("","");
placeoptions.add(ob4);
if(list1.size()>0){
	for(int i=0;i<list1.size();i++){
		ica=(Places )list1.get(i);
		ob4=new OptionBean(ica.getPlaceName(),ica.getPlaceName());
		placeoptions.add(ob4);
	}
}
List xueyuanoptions=CEditConst.getAcademyNameOptions(userInfo,"");
List auioptoions=CEditConst.getAuditOptions(userInfo);
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
			
		</script>
					<script language="JavaScript"
			src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
			<style>

.labelon {
	background:#e5f1f4;
	font-size:13px;
	cursor:hand; 
}
.labeloff {
	background:#3992d0; 
	font-size:12px;
	color:#fff;
	cursor:hand; 
}
</style>
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
				<div class="browsetitle001">团委场地申请</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("团委场地申请") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="Places_ApplytableAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" name="cmd" value="<%=cmd%>">
				<input type="hidden" name="page" value="<%=currpage%>">
				<%=Tool.join("\n", forms)%>
								<table class="tabs-table">
<tr>
      <td id = "base" class="labelon" width="60" align="center" onclick="infoshow(1)" >基本信息</td>
      
      <td id = "team" class="<%=labelclass[1]%>" width="60" align="center" onclick="infoshow(2)" >设备情况</td>

      <td id = "other" class="<%=labelclass[2]%>" width="60" align="center"  onclick="infoshow(3)">人员信息</td>
        

   
</tr> 
</table>
				
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
<input type="hidden" name="Id" value="<%=v.getId()%>">
													  				<tbody id="baseinfo"  >

                    												<tr style="display: none;">
                    													<td align="right" class="form_label">用户账号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="UserAccount" id="UserAccount" size="45" maxsize="45" value="<%=v.getUserAccount()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">申请场地</td>
														    			<td align="left"  bgcolor="#ffffff">
                    															<%=HtmlTool.renderSelect(placeoptions, v.getPlaceApplycode(), "PlaceApplycode", "")%>
                    													</td>
                    														<td align="right" class="form_label">申请时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                                                                     	<input value="<%=v.getApplyDate() %>" readonly class="date" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd ',minDate:'%y-%M-%d %H',onpicked:function(){}})"  name="ApplyDate" id="ApplyDate" size="0">
														    			
                    														
                    													</td>
                    														<td align="right" class="form_label">申请时间段</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<%=HtmlTool.renderSelect(timeOptions, v.getApplyTimeRange(), "ApplyTimeRange", "")%>
                    														
                    													</td>
                    													
													  				</tr>
<%-- <input type="hidden" name="ApplyDate" value="<%=v.getApplyDate()%>">
 --%>                    										
                    												<tr>
                    												<td align="right" class="form_label">使用单位</td>
														    			<td align="left"  bgcolor="#ffffff">
                    													
                    														<%=HtmlTool.renderSelect(xueyuanoptions, v.getApplicant(), "Applicant", "")%>
                    													</td>
                    													
                    													<td align="right" class="form_label">活动负责人</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ActivityPrincipal" id="ActivityPrincipal" size="25" maxsize="25" value="<%=v.getActivityPrincipal()%>">

                    													</td>
                    													<td align="right" class="form_label">活动负责人职务</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PrincipalDuty" id="PrincipalDuty" size="25" maxsize="25" value="<%=v.getPrincipalDuty()%>">
                    													</td>
                    												
													  				</tr>
                    											
                    												<tr>
                    													<td align="right" class="form_label">活动负责人联系电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PrincipalPhone" id="PrincipalPhone" size="25" maxsize="25" value="<%=v.getPrincipalPhone()%>">
                    													</td>
                    													<td align="right" class="form_label">布场时段</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="DistributionPeriod" id="DistributionPeriod" size="25" maxsize="25" value="<%=v.getDistributionPeriod()%>">
                    													</td>
                    													<td align="right" class="form_label">彩排时段</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="RehearsalPeriod" id="RehearsalPeriod" size="25" maxsize="25" value="<%=v.getRehearsalPeriod()%>">
                    													</td>
													  				</tr>
                    											
                    												<tr>
                    													<td align="right" class="form_label">活动内容</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ActivityContents" id="ActivityContents" size="25" maxsize="25" value="<%=v.getActivityContents()%>">
                    													</td>
                    													<td align="right" class="form_label">主讲人</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Speaker" id="Speaker" size="25" maxsize="25" value="<%=v.getSpeaker()%>">

                    													</td>
                    													<td align="right" class="form_label">会标内容</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="MeetingMarks" id="MeetingMarks" size="25" maxsize="25" value="<%=v.getMeetingMarks()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">背景内容</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="BackgroundContents" id="BackgroundContents" size="25" maxsize="25" value="<%=v.getBackgroundContents()%>">
                    													</td>
                    													<td align="right" class="form_label">商业赞助</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Aponsorship" id="Aponsorship" size="25" maxsize="25" value="<%=v.getAponsorship()%>">
                    													</td>
                    													<td align="right" class="form_label">宣传形式</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Propaganda" id="Propaganda" size="25" maxsize="25" value="<%=v.getPropaganda()%>">
                    													</td>
													  				</tr>
                    											
                    												<tr>
                    													<td align="right" class="form_label">基本程序简介</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
                    														<input name="BasicProcedures" id="BasicProcedures" style="height: 60px" size="130" maxsize="130" value="<%=v.getBasicProcedures()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													
													  				</tr>
                    											
                    												<tr>
                    													<td align="right" class="form_label">会场内其他宣传形式</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
                    														<input name="OtherPropaganda" id="OtherPropaganda" style="height: 60px" size="130" maxsize="130" value="<%=v.getOtherPropaganda()%>">
                    													</td>
													  				</tr>
													  					</tbody>
													  						<tbody id="teaminfo" style="display:none">
                    												<tr>
                    													<td align="right" class="form_label">桌子数量</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input size="30" name="TableNums" id="TableNums" value="<%=v.getTableNums()==-1?"":v.getTableNums()%>">
                    													</td>
                    													<td align="right" class="form_label">椅子数量</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<input size="30" name="ChairNums" id="ChairNums" value="<%=v.getChairNums()==-1?"":v.getChairNums()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">有线话筒</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getWiredmicroPhoneNums(), "WiredmicroPhoneNums", "-1")%>
                    													</td>
                    													<td align="right" class="form_label">无线话筒</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getWirelessmicroPhoneNums(), "WirelessmicroPhoneNums", "-1")%>
                    													</td>
                    														<td align="right" class="form_label">话筒电池</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getBatteryNums(), "BatteryNums", "-1")%>
                    													</td>
													  				</tr>
                    											
                    											
                    												<tr>
                    													<td align="right" class="form_label">使用发言台</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getUseFloor(), "UseFloor", "-1")%>
                    													</td>
                    														<td align="right" class="form_label">使用音响设备</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getUseAudio(), "UseAudio", "-1")%>
                    													</td>
                    													<td align="right" class="form_label">使用照明灯光</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getUseLighting(), "UseLighting", "-1")%>
                    													</td>
													  				</tr>
                    											
                    												<tr>
                    													<td align="right" class="form_label">使用舞台灯光</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getUseStageLight(), "UseStageLight", "-1")%>
                    													</td>
                    													<td align="right" class="form_label">使用电脑灯</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getUseComputerLight(), "UseComputerLight", "-1")%>
                    													</td>
                    													<td align="right" class="form_label">使用投影仪</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getUseProjector(), "UseProjector", "-1")%>
                    													</td>
													  				</tr>
                    											
                    												<tr>
                    													<td align="right" class="form_label">使用空调</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getUseAc(), "UseAc", "-1")%>
                    													</td>
                    													<td align="right" class="form_label">悬挂横幅</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getUseBanner(), "UseBanner", "-1")%>
                    													</td>
                    													<td align="right" class="form_label">横幅内容</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="BannerContent" id="BannerContent" size="30" maxsize="30" value="<%=v.getBannerContent()%>">
                    													</td>
													  				</tr>
                    											
                    												<tr>
                    													<td align="right" class="form_label">张贴海报或展板</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="UsePoster" id="UsePoster" size="30" maxsize="30" value="<%=v.getUsePoster()%>">
                    													</td>
                    														<td align="right" class="form_label">海报内容</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PosterContent" id="PosterContent" size="30" maxsize="30" value="<%=v.getPosterContent()%>">
                    													</td>
                    													<td align="right" class="form_label">参加人员车辆数量</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="VehicleNums" id="VehicleNums" size="30" maxsize="30" value="<%=v.getVehicleNums()%>">
                    													</td>
													  				</tr>
                    											</tbody>
                    																								  					
                    											<tbody id="otherinfo" style="display:none">
                    												<tr>
                    													<td align="right" class="form_label">承诺人</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserNameoptions, v.getPromiser(), "Promiser", "")%>
                    													</td>
                    													<td align="right" class="form_label">承诺人联系电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PromiserPhone" id="PromiserPhone" size="30" maxsize="30" value="<%=v.getPromiserPhone()%>">
                    													</td>
                    													<td align="right" class="form_label">承诺人学院</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getPromiserAcadeMy(), "PromiserAcadeMy", "")%>
                    													</td>
													  				</tr>
                    											
                    												
                    												<tr>
                    													<td align="right" class="form_label">承诺人班级</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ClassesNameoptions, v.getPromiserClass(), "PromiserClass", "")%>
                    													</td>
                    													<td align="right" class="form_label">指导老师</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserNameoptions, v.getTutor(), "Tutor", "")%>
                    													</td>
                    														<td align="right" class="form_label">指导老师职务</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TutorDuty" id="TutorDuty" size="25" maxsize="25" value="<%=v.getTutorDuty()%>">
                    													</td>
													  				</tr>
                    											
                    											
                    												<tr>
                    													<td align="right" class="form_label">指导老师联系方式</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TutorPhone" id="TutorPhone" size="30" maxsize="30" value="<%=v.getTutorPhone()%>">
                    													</td>
                    													<td align="right" class="form_label">指导老师意见</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<input name="TutorAgree" id="TutorAgree" size="60" maxsize="60" value="<%=v.getTutorAgree()%>">
                    													</td>
													  				</tr>
                    											
                    												<tr>
                    													<td align="right" class="form_label">备注</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
                    														<input name="Remarks" id="Remarks" style="height: 100px" size="120" maxsize="120" value="<%=v.getRemarks()%>">
                    													</td>
													  				</tr>
<input type="hidden" name="AddTime" value="<%=v.getAddTime()%>">
	</tbody>
		                    																								  					<tbody id="fileinfo" style="display:none;">

                    												<tr>
                    													<td align="right" class="form_label">团委审核</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<%=HtmlTool.renderSelect(auioptoions, v.getStatus(), "Status", "")%>
                    														
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院审核</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%=HtmlTool.renderSelect(auioptoions, v.getGuideUnitAgree(), "GuideUnitAgree", "")%>
                    													</td>
													  				</tr>
													  			</tbody>			
                    											</table>
			</form>
		</div>
		
		<script type="text/javascript">
	function infoshow(val)
	{
		switch(val)
		{
			case 1:
				$("#baseinfo").attr("style","display:block");
				$("#teaminfo").attr("style","display:none");
				$("#otherinfo").attr("style","display:none");
				$("#fileinfo").attr("style","display:none");
				$("#base").attr("class","labelon");
				$("#team").attr("class","labeloff");
				$("#other").attr("class","labeloff");
				$("#file").attr("class","labeloff");
				break;
			case 2:
				$("#baseinfo").attr("style","display:none");
				$("#teaminfo").attr("style","display:block");
				$("#otherinfo").attr("style","display:none");
				$("#fileinfo").attr("style","display:none");
				$("#base").attr("class","labeloff");
				$("#team").attr("class","labelon");
				$("#other").attr("class","labeloff");
				$("#file").attr("class","labeloff");
				break;
			case 3:
				$("#baseinfo").attr("style","display:none");
				$("#teaminfo").attr("style","display:none");
				$("#otherinfo").attr("style","display:block");
				$("#fileinfo").attr("style","display:none");
				$("#base").attr("class","labeloff");
				$("#team").attr("class","labeloff");
				$("#other").attr("class","labelon");
				$("#file").attr("class","labeloff");
				break;
			case 4:
				$("#baseinfo").attr("style","display:none");
				$("#teaminfo").attr("style","display:none");
				$("#otherinfo").attr("style","display:none");
				$("#fileinfo").attr("style","display:block");
				$("#base").attr("class","labeloff");
				$("#team").attr("class","labeloff");
				$("#other").attr("class","labeloff");
				$("#file").attr("class","labelon");
				
		}
	}
</script>
	</body>
</html>
