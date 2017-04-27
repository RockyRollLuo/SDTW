<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.sdtw.club.ClubUtil"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--校园文化信息--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(CampusActivity.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	CampusActivity v = (CampusActivity)request.getAttribute("fromBean");
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
	List AcademyNameoptions = CEditConst.getAcademyNameOptions(userInfo,"");
List cdt = new ArrayList();
if(!"".equals(v.getAcademy().trim())){
cdt.add("id not in("+v.getAcademy()+")");
}
cdt.add("flag=1");	
List AcademyNameoptions2 = COptionConst.getAcademyNameOptions(userInfo,cdt);

cdt.clear();
if(!"".equals(v.getAcademy().trim())) {
	cdt.add("id  in("+v.getAcademy()+")");
	cdt.add("flag=1");
} else {
	cdt.add("1=-1");
}
List AcademyNameoptions3 = COptionConst.getAcademyNameOptions(userInfo,cdt);

List OrgNameoptions = CEditConst.getOrgCityNameOptions(userInfo);
List ActivitykindTypeoptions = CEditConst.getActivitykindTypeOptions(userInfo,"-1");
List TotalRoundsoptions = (List)request.getAttribute("TotalRoundsoptions");
List ActivityLeveloptions = (List)request.getAttribute("ActivityLeveloptions");
int ActivitykindType = ParamUtils.getIntParameter(request,"_ActivitykindType_",-1);
ClubUtil util = new ClubUtil();
cdt.clear();
//指导单位
if(userInfo.hasFunPower(Power.UserAdminPower)){
	cdt.add("deptid="+userInfo.getDeptId());
}
/* cdt.add("(roles=3)");
List UserCnNameOptions = util.getUserCnNameOptions(cdt); */

Map userMap = CEditConst.getUserCnNameMap(userInfo);
String name = (String)userMap.get(v.getActivityPrincipal()+"")==null?v.getActivityPrincipal():(String)userMap.get(v.getActivityPrincipal()+"");
int _ActivitykindType_ = ParamUtils.getIntParameter(request,"_ActivitykindType_",-1);
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<!-- 左右列表 -->
		<script type="text/javascript" src="js/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="js/bootstrap-3.3.7/dist/css/bootstrap.min.css" />
		<!-- <link rel="stylesheet" href="css/prettify.css" />
		<link rel="stylesheet" href="css/style.css" /> -->
		<script type="text/javascript" src="js/multiselect.js"></script>
		<script type="text/javascript" src="js/multiselect.min.js"></script>
		<!-- 左右列表 -->
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
		<script src="../../js/jquery.editable-1.0.1.js"></script>
		<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/themes/base/jquery-ui-1.8.4.custom.css" rel="stylesheet"/>
		<style>
		//#form td {padding: 0px;}
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
    				$('#multiselect').multiselect();
    				
    				$("#UserName").click(function(){
    					 $('#ActivityPrincipal').val("");
    				})
    				$("#UserName").autocomplete({
    					source: "../base/UserCodeAction.jsp?cmd=getUsers",
    					 select: function( event, ui ) {
    				          $('#UserName').val(ui.item.label);
    				          $('#ActivityPrincipal').val(ui.item.value);
    				          return false;
    				        }
    				});	
    				var rowspan = document.getElementById("teamtable").rows.length;
    				$('#Nums').val(rowspan-1);
			}
			function Jump(f){
				$('#commentFrame'+f).attr("src","CampusParticipateAction.jsp?_flag_="+f+"&_CampusActivityId_=<%=v.getId()%>") 
			}
			function checkForm(){
				$('#UserName').removeAttr("style");
				if($('#ActivityPrincipal').val() == '' && $('#UserName').val() == ""){
					$("#errorDiv").html("请填写用户！");
					$('#UserName').css("border"," 2px solid rgb(255, 204, 136)");
					$('#UserName').focus();
					return false;
				} else if($('#ActivityPrincipal').val() == '' &&  $('#UserName').val() != ""){
					$("#errorDiv").html("请选择正确的用户信息！");
					$('#UserName').css("border"," 2px solid rgb(255, 204, 136)");
					$('#UserName').focus();
					return false;
				} 
				return true;
			}
			
			function val(){
				var val = "";     
			     $("#multiselect_to option").each(function(){  //遍历所有option  
			          var txt = $(this).val();   //获取option值   
			          if(txt!=''){  
			               val+=txt+",";
			          }  
			     })  
			     if(val.length>0){
			    	 val = val.substring(0,val.length-1);
			     }
			     $('#Academy').val(val);
			}
			function join(flag) {
				if(flag==0){
					$('#Academy').val("");
					$('#xy').hide();
				}
				if(flag==1){
					$('#xy').show();
				}
			}
			$(function(){
				var xyOrAll = $('input[name="ApplicationRange"]').filter(':checked').val();
				 join(xyOrAll);
				 $('input[name="ApplicationRange"]').click(function(){
					 var xyOrAll = $(this).filter(':checked').val();
					 join(xyOrAll);
					});
			})
			
			function submitthis(){
				var ApplicationRange = $('input:radio[name="ApplicationRange"]:checked').val();
				
				var id_array=new Array();
				$('input[name="Campus"]:checked').each(function(){  
				    id_array.push($(this).val());//向数组中添加元素  
				});  
				val();
				var Academy = $('#Academy').val();
				if(ApplicationRange==""||ApplicationRange=="-1"){
					$('#errorDiv').html("请选择申请范围");
					$('#ApplicationRange').focus();
					return ;
				}
				if(id_array.length==0){
					$('#errorDiv').html("请选择参与城市");
					$('input:checkbox[name="Campus"]').focus();
					return ;
				}
				if(ApplicationRange==="1"){
					var Academy = $('#Academy').val();
					if(Academy==""||Academy=="-1"){
						$('#errorDiv').html("请选择学院");
						$('#multiselect').focus();
						return;
					}
				}
				var l = $('#teamtable input').length;
				if (l==0) {
					alert("请设置荣誉！");
					return;
				}
				if(!chekSname('teamtable')){
					alert("请将荣誉信息填写完整！");
					return;
				}
				$('#postForm').submit();
			}
			
			function chekSname(id) {
				var f = true;
				$("#"+id).find("input").each(function () {
			        if ($(this).val() == "") {
			        	//alert($(this).attr("id"))
			            $(this).focus();
			            f=false;
			        }else{
			        	
			        }
			    })
			    return f;
			}
		    function checkPersonNumber(flag){
		    	if(flag==1){
		    		var PersonNumber1 = $('#PersonNumber1').val();
		    		if(PersonNumber1>0){
		    			$('#PersonNumber2' ).attr("checked",false);
		    			$('#PersonNumber').val(PersonNumber1);
		    		}
		    	}
		    	if(flag==2){
		    		 $('#PersonNumber1').val("");
		    		 $('#PersonNumber').val("-1");
		    	}
		    }
		    function addItem(){
		    	var rowspan = document.getElementById("teamtable").rows.length;
		    	var bg = "bgcolor='#ffffff'";
		    	if(rowspan%2==0){
		    		bg = "bgcolor='#f7f9fc'";
		    	}
		    	var HonorName = $('#HonorName'+(rowspan-1)).val();
		    	var Num = $('#Num'+(rowspan-1)).val();
		    	if(HonorName==""){
		    		$('#HonorName'+(rowspan-1)).focus();
		    		alert("请填写完整！");
		    		return;
		    	}
		    	if(Num==""){
		    		$('#Num'+(rowspan-1)).focus();
		    		alert("请填写完整！");
		    		return;
		    	}
		    	$('#Nums').val(rowspan);
		    	$("#teamtable").append(
		    	"<tr "+bg+" onMouseOver=\"addClass(this,'data_bgcolor_over');\"  onMouseOut=\"removeClass(this,'data_bgcolor_over');\">"+
		    		"<td> <input  type='text' id='HonorName"+rowspan+"' size='15' name='HonorName"+rowspan+"' /></td>"+
		    		"<td><input  type='text' id='Num"+rowspan+"'size='15' name='Num"+rowspan+"' /></td>"+
		    		"<td></td>"+
		    		
		    	"</tr>"
		    	);
		    }
		    function addClass(element, className) { 
				if (!this.hasClass(element, className)) 
				{ 
					element.className += " "+className; 
				} 
			}
			function hasClass(element, className) { 
				var reg = new RegExp('(\\s|^)'+className+'(\\s|$)'); 
				return element.className.match(reg); 
			} 
			function removeClass(element, className) { 
				if (hasClass(element, className)) { 
					var reg = new RegExp('(\\s|^)'+className+'(\\s|$)'); 
					element.className = element.className.replace(reg,' '); 
				} 
			} 
			
		</script>
	</head>
	<body onload="init();">
		<div class="browsetitle">
			<div class="browsetitleleft">
			<%
			String describe = ParamUtils.getAttribute(request,"describe",""); 
			%>
				<div class="browsetitle001"><%=describe %></div>
				<div class="browsetitle002"><%=XtUtil.getSpell(describe) %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="CampusActivityAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						<%
						if ((userInfo.getId()+"").equals(v.getAddperson())||"save".equals(cmd)) {
						%>
						<li><a href="javascript:void(0);" onclick="javascript:if(checkForm()&&doValidate('postForm')) submitthis();">保存</a></li>
						<%} %>
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
		<div id="tabs">
			<ul>
				<li><a href="#tabs-1">基本信息</a></li>
				<li onclick="Jump(1)"><a href="#tabs-2">报名管理</a></li>
				<li onclick="Jump(2)"><a href="#tabs-3">成绩管理</a></li>
				<li onclick="Jump(3)"><a href="#tabs-4">荣誉管理</a></li>
			</ul>
		
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" name="cmd" value="<%=cmd%>">
				<input type="hidden" name="page" value="<%=currpage%>">
				<input type="hidden" name="Addtime" id="Addtime" size="0" value="<%=Tool.stringOfDateTime(v.getAddtime())%>">
				<input type="hidden" name="Addperson" id="Addperson" size="45" maxsize="45" value="<%=v.getAddperson()%>">
               	<input type="hidden" name="ModifyTime" id="ModifyTime" size="0" value="<%=Tool.stringOfDateTime(v.getModifyTime())%>">
               	<input type="hidden" name="ModifyPerson" id="ModifyPerson" size="45" maxsize="45" value="<%=v.getModifyPerson()%>">
               	<input type="hidden" name="Honor" id="Honor" value="<%=v.getHonor()%>"/>	
               	<input type="hidden" id="Academy" name="Academy" value="<%=v.getAcademy()%>"/>		
               	<input type="hidden" id="PersonNumber" name="PersonNumber" value="<%=v.getPersonNumber()%>"/>	
               	<input type="hidden" id="Nums" name="Nums"/><!-- 荣誉条数 -->			
               	<input type="hidden" id="_ActivitykindType_" name="_ActivitykindType_" value="<%=_ActivitykindType_%>"/>						
				<%-- <%=Tool.join("\n", forms)%> --%>
                    											<div id="tabs-1" style="border: 0px;padding: 0px;">
                    											<table style="background-color: #e3e5e8;border-spacing: 1px;border-collapse: separate;" width="100%" border="0" align="center" cellpadding="4" cellspacing="1">
<input type="hidden" name="Id" value="<%=v.getId()%>">
                    												<tr>
                    													<td align="right" class="form_label">活动名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input id="ActivityName" name="ActivityName" value="<%=v.getActivityName()%>"/>
                    													</td>
													  				
                    													<td align="right" class="form_label">活动类别</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ActivitykindTypeoptions, v.getActivitykindType(), "ActivitykindType", ""+ActivitykindType,true)%>
                    													</td>
													  				
                    													<td align="right" class="form_label">活动组织单位</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%
														    			if(userInfo.hasFunPower(Power.UserAdminPower)){
														    			%>
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getOrgacadeMy().equals("")?userInfo.getDeptId()+"":v.getOrgacadeMy(), "OrgacadeMy", "",true)%>
																		<%} %>
																		<%
																		if(userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.WHHD)){%>
																			山东大学团委<input type="hidden" id="OrgacadeMy" name="OrgacadeMy" value="-1"/>
																		<%}
																		%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动级别</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ActivityLeveloptions, v.getActivityLevel(), "ActivityLevel", "")%>
                    													</td>
                    													<td align="right" class="form_label">负责人</td>
														    			<td align="left"  bgcolor="#ffffff">
												                        <input name="UserName" id="UserName" value="<%=(name == null ?"":name)%>" ><%-- <%=cmd.equals("update")?"readonly":"" %> --%>
																			<input type="hidden" name="ActivityPrincipal" id="ActivityPrincipal" value="<%=v.getActivityPrincipal()%>" >
																			<br/><font color='red'>录入姓氏或学号，请在下拉中选择</font>
                    													</td>
													  				
                    													<td align="right" class="form_label">联系方式</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Contact" id="Contact" value="<%=v.getContact()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动轮次</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(TotalRoundsoptions, v.getTotalRounds(), "TotalRounds", "")%>
                    													</td>
                    													<td align="right" class="form_label">报名截止日期</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Deadline"  id="Deadline" size="0" value="<%=Tool.stringOfDate(Tool.stringToDate(v.getDeadline()))%>" readonly onclick="WdatePicker({dateFmt:'yyyy-MM-dd',onpicked:function(){}})" >
                    													</td>
													  				
                    													<td align="right" class="form_label" >所需人数</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PersonNumber1" id="PersonNumber1"  value="<%=Tool.StrToInt(v.getPersonNumber())>0?v.getPersonNumber():""%>" onblur="checkPersonNumber(1)">
                    														<input id="PersonNumber2" name="PersonNumber2" value="-1" type="checkbox" onblur="checkPersonNumber(2)" <%=v.getPersonNumber().equals("-1")?"checked=\"checked\"":"" %> />不限
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">第一轮日期</td>
														    			<td align="left"  bgcolor="#ffffff" >
                    														<input onclick="WdatePicker({el:'ActivityDate1',dateFmt:'yyyy-MM-dd'})" name="ActivityDate1" readonly id="ActivityDate1" size="0" value="<%=v.getActivityDate1()%>">
                    													</td>
													  				
                    													<td align="right" class="form_label">第一轮地点</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<input id="ActivityPlace1" name="ActivityPlace1" size="50" value="<%=v.getActivityPlace1()%>" />
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">第二轮日期</td>
														    			<td align="left"  bgcolor="#ffffff" >
                    														<input name="ActivityDate2"  id="ActivityDate2"  value="<%=v.getActivityDate2()%>" readonly onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'ActivityDate1\')}',onpicked:function(){}})" >
                    													</td>
													  				
                    													<td align="right" class="form_label">第二轮地点</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3">
                    														<input id="ActivityPlace2" name="ActivityPlace2" size="50" value="<%=v.getActivityPlace2()%>" />
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">第三轮日期</td>
														    			<td align="left"  bgcolor="#ffffff" >
                    														<input name="ActivityDate3"  id="ActivityDate3"  value="<%=v.getActivityDate3()%>" readonly onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'ActivityDate2\')}',onpicked:function(){}})" >
                    													</td>
													  				
                    													<td align="right" class="form_label">第三轮地点</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="3" >
                    														<input id="ActivityPlace3" name="ActivityPlace3" size="50" value="<%=v.getActivityPlace3()%>" />
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label"><font color="red">*</font>荣誉设置：</td>
                    													<td align="left"  bgcolor="#ffffff" colspan="5" >
															   	    	<table id="teamtable"   style="border-collapse: separate;border-spacing: 1px;width:100%;font-size:12px;text-align:center;" cellpadding="1px;" cellspacing="1px;">
																			<tr style="background-color:#f7f9fc;">
																				<td >荣誉类型</td><td>人数</td><td><a href="#" onclick="addItem();return false;" style="color: red;">添加</a></td>
																			</tr>
																		<%
																		cdt = new ArrayList();
																		if (v.getId()!=-1) {
																		cdt.add("ActivityId = "+v.getId());
																		Honor h  = new Honor();
																		List list = new ArrayList();
																		list = h.query(cdt);
																		if(list.size()>0){
																			for(int i=0;i<list.size();i++){
																				h = (Honor)list.get(i);
																				String bgcolor="bgcolor=#ffffff";
																				if(i%2==0){
																					bgcolor="bgcolor=#f7f9fc";
																				}
																				%>
																				<input type="hidden" id="honorId<%=i+1 %>" name="honorId<%=i+1 %>" value="<%=h.getId()%>"/>
																				<tr <%=bgcolor %> onMouseOver="addClass(this,'data_bgcolor_over');"  onMouseOut="removeClass(this,'data_bgcolor_over');">
																				<td > <input  type="text" name="HonorName<%=i+1 %>" size="15" id="HonorName<%=i+1%>" value="<%=h.getHonorName()%>"></td>
																				<td ><input type="text" name="Num<%=i+1 %>" size="15" id="Num<%=i+1 %>" value="<%=h.getIsEnable()==0?1:h.getIsEnable()%>"></td>
																				<td></td>
																			</tr>
																			<%}
																		}
																		}
																		%>
																			
																
																		</table>
															   	</td>
                    												</tr>
                    												<tr>
                    													<td align="right" class="form_label">详细介绍</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
                    														<textarea style="width: 90%;" name="ActivityExplain" id="ActivityExplain" cols="40" rows="2"><%=v.getActivityExplain()%></textarea>
                    													</td>
													  				</tr>
													  				<tr>
                    													<td align="right" class="form_label">参与城市</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
<%=HtmlTool.renderCheckBox(OrgNameoptions, v.getCampus(), "Campus", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">申请范围</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
                    														<%-- <textarea name="ApplicationRange" id="ApplicationRange" cols="40" rows="2"><%=v.getApplicationRange()%></textarea> --%>
                    														<%
                    														List ApplicationRangeOptions = util.getApplicationRangeOptions();
                    														%>
                    														<%=HtmlTool.renderRadio(ApplicationRangeOptions, v.getApplicationRange(), "ApplicationRange","0")%>
                    													</td>
													  				</tr>
                    												<tr id="xy" style="display: none;">
                    													<td align="right" class="form_label">学院</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
		    <div class="row" style="width: 100%;">
    	<div class="col-xs-5">
    		<select name="from" id="multiselect" class="form-control" size="15" multiple="multiple">
    			<%=HtmlTool.renderSelectOption(AcademyNameoptions2, v.getAcademy(), "")%>
    		</select>
    	</div>
    	
    	<div class="col-xs-2">
    		<button type="button" id="multiselect_rightAll" class="btn btn-block"><i class="glyphicon glyphicon-forward"></i></button>
    		<button type="button" id="multiselect_rightSelected" class="btn btn-block"><i class="glyphicon glyphicon-chevron-right"></i></button>
    		<button type="button" id="multiselect_leftSelected" class="btn btn-block"><i class="glyphicon glyphicon-chevron-left"></i></button>
    		<button type="button" id="multiselect_leftAll" class="btn btn-block"><i class="glyphicon glyphicon-backward"></i></button>
    	</div>
    	
    	<div class="col-xs-5">
    		<select name="to" id="multiselect_to" class="form-control" size="15" multiple="multiple">
    		<%=HtmlTool.renderSelectOption(AcademyNameoptions3, v.getAcademy(), "")%>
    		</select>
    	</div>
    </div>													</td>
													  				</tr>
                    											</table>
                    											</div>
                    											<div id="tabs-2" style="border: 0px; padding: 0px;">
                    											<iframe  class="commentFrame1" name="commentFrame1" id="commentFrame1"  frameborder='0' marginheight="0" marginwidth="0" width="100%" scrolling="auto" height="500px"></iframe>
                    											</div>
                    											<div id="tabs-3" style="border: 0px; padding: 0px;">
                    											<iframe  class="commentFrame2" name="commentFrame2" id="commentFrame2"  frameborder='0' marginheight="0" marginwidth="0" width="100%" scrolling="auto" height="500px"></iframe>
                    											</div>
                    											<div id="tabs-4" style="border: 0px; padding: 0px;">
                    											<iframe  class="commentFrame3" name="commentFrame3" id="commentFrame3"  frameborder='0' marginheight="0" marginwidth="0" width="100%" scrolling="auto" height="500px"></iframe>
                    											</div>
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
