<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--志愿竞赛报名表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>

<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(VolunteerProjectParticipate.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	VolunteerProjectParticipate v = (VolunteerProjectParticipate)request.getAttribute("fromBean");
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
	List zhuguanoptions=CEditConst.getAcademyNameOptions(userInfo);
	List shifouoptions=CEditConst.getYesNoOptions(userInfo);
List UserNameoptions = (List)request.getAttribute("UserNameoptions");
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
List VolunProjectNameoptions = (List)request.getAttribute("VolunProjectNameoptions");
List AssLeveloptions = (List)request.getAttribute("AssLeveloptions");
List PoliticsNameoptions = (List)request.getAttribute("PoliticsNameoptions");
Map zhengzhimap=CEditConst.getPoliticsNameMap(userInfo);

String projectcode="",projectname=v.getProjectName(),teamcode="",teamname=v.getTeamName(),teamunit=(String)CEditConst.getAcademyNameMap(userInfo).get(v.getTeamUnit()+""),registerid=v.getRegisterId(),setuptime=Tool.stringOfDate(v.getSetupTime()),zipcode=v.getZipCode(),contactaddress=v.getContactAddress(),insepctionconclution=v.getInspectionConclution();
String asslevel=v.getAssLevel(),starttime=Tool.stringOfDate(v.getStartTime()),projectarea=v.getProjectArea(),implearea=v.getImpleArea(),award=v.getAward(),majorid=v.getMajorName(),guideteacherid=v.getGuideTeacherName(),teammemberslist=v.getTableName();
String majorvolslist="",content=v.getContent(),meanings=v.getMeanings(),disiredresults=v.getDisiredResults(),impleplace=v.getImplePlace(),promotion=v.getPromotion(),specialist=v.getSpecialist(),beneficaiaries=v.getBeneFicaiaries(),checkcomments=v.getCheckComments();
String majorname=v.getMajorName(),majorsex=v.getMajorSex(),majorbirth=v.getMajorBirth(),majorduty=v.getMajorDuty(),majorpolista=v.getMajorPolista(),majorphone=v.getMajorPhone(),majorphone2=v.getMajorPhone2(),majoremail=v.getMajorEmail();
String dutyfree=v.getDutyFree(),guideteachername=v.getGuideTeacherName(),guideteachersex=v.getGuideTeacherSex(),guideteacherbirth=v.getGuideTeacherBirth(),guideteacherduty=v.getGuideTeacherDuty(),guideteacherpolista=v.getGuideTeacherPolista(),guideteacherphone=v.getGuideTeacherPhone(),guideteacherphone2=v.getGuideTeacherPhone2(),guideteacheremail=v.getGuiderTeacherEmail();
int participatenum=0,fulltimenum=0,majorkind=0,benenum=0,edittype=0;
String ids = v.getAddFileList();
String[] labelclass = {"labeloff", "labeloff", "labeloff", "labeloff"};
Honor honor= new Honor();
List list1=new ArrayList();
List cdt= new ArrayList();
cdt.add("honorType=4");
cdt.add("activityid="+v.getProjectId());
list1=honor.query(cdt);
List rongyulist = new ArrayList();

OptionBean ob= new OptionBean("","");
rongyulist.add(ob);
	if(list1.size()>0){
		for(int i=0;i<list1.size();i++){
			honor=( Honor)list1.get(i);
			ob=new OptionBean(honor.getHonorName(),honor.getId()+"");
			rongyulist.add(ob);
		}
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
		<link rel="stylesheet" type="text/css" href="../css/common.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/tablelist.js"></script>
		<script>
			var url_para = "<%=url%>";
			var dic = {<%=Tool.join(", ", diclist)%>};
			var keyfield = "<%=(String)request.getAttribute("keyfield")%>";
			var allfields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("allfields"))%>"];
			var fields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("fields"))%>"];
			var options= {<%=HtmlTool.getJsOptions(request)%>};
			function init() {
    				prepareForm("<%=request.getAttribute("classname")%>", dic, "<%=userInfo.getPower()%>");
    				$("#baseinfo").attr("style","display:block");
    				$("#teaminfo").attr("style","display:none");
    				$("#otherinfo").attr("style","display:none");
    				$("#fileinfo").attr("style","display:none");
    				$("#base").attr("class","labelon");
    				$("#team").attr("class","labeloff");
    				$("#other").attr("class","labeloff");
    				$("#file").attr("class","labeloff");
			}
		</script>
	</head>
	<body onload="init();">
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">志愿竞赛报名表</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("志愿竞赛报名表") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
					 <li> <a href="#" onclick="history.go(-1);">返回</a></li> 
					 						<li><a href="javascript:void(0);" onclick="javascript:if(true) document.postForm.submit();">保存</a></li>
					 
					
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" name="cmd" value="update">
				<input type="hidden" name="Id" value="<%=v.getId()%>">
				<input type="hidden" name="ProjectId" value="<%=v.getProjectId()%>">
				<input type="hidden" name="page" value="<%=currpage%>">
				<%=Tool.join("\n", forms)%>
                    											
<table class="tabs-table">
<tr>
      <td id = "base" class="<%=labelclass[0]%>" width="60" align="center" onclick="infoshow(1)" >基本信息</td>
      <td id = "team" class="<%=labelclass[1]%>" width="60" align="center" onclick="infoshow(2)" >人员信息</td>
      <td id = "other" class="<%=labelclass[2]%>" width="60" align="center"  onclick="infoshow(3)">其他信息</td>
      <td id = "file" class="<%=labelclass[3]%>" width="60" align="center" onclick="infoshow(4)" >附件资料</td>
      <%if(v.getCheckFlag()==1) {%>
         <td id = "rongyu" class="labeloff "width="60" align="center" onclick="infoshow(5)" >荣誉分配</td> 
         <%} %>
</tr>
</table>



<table class="content-table">
<tr>
	<th colspan="3" align="left">竞赛项目申请信息</th>
</tr>
<tbody id="baseinfo" style="display:block">
<tr>
   		<td   width="15%" align="right">&nbsp;<font color="red">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp*&nbsp;</font>项目名称：     &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp                     </td>
   		<td  align="left"><%=projectname%></td>
   		
</tr>
<tr>
   		<td align="right">&nbsp;<font color="red">*&nbsp;</font>团队名称：                   </td>
   		<td align="left"><%=teamname%></td>
</tr>
<tr>
   		<td align="right" >&nbsp;<font color="red">*&nbsp;</font>团队主管单位：                                    </td>
   		<td align="left"><%=teamunit%></td>
</tr>
<tr>
   		<td align="right">&nbsp;<font color="red">*&nbsp;</font>登记证号：                              </td>
   		<td align="left"><%=registerid%>
   		&nbsp;成立时间:<%=setuptime%>
   		&nbsp;邮政编码：<%=zipcode%>
   		</td>
</tr>
<tr>
   		<td align="right">&nbsp;<font color="red">*&nbsp;</font>通讯地址：                            </td>
   		<td align="left"><%=contactaddress%></td>
</tr>
<tr>
   		<td align="right" >&nbsp;<font color="red">*&nbsp;</font>年度年检结论：</td>
   		<td align="left"><%=insepctionconclution%>
   		&nbsp;&nbsp;评估等级：<%=asslevel%>
   		</td>
</tr>
<tr>
   		<td align="right" >&nbsp;<font color="red">*&nbsp;</font>有无免税资格：</td>
   		<td align="left"><%=HtmlTool.renderSelect(shifouoptions, "" +dutyfree, "DutyFree", "-1",true)%>
   		&nbsp;&nbsp;&nbsp;项目实施时间:<%=starttime%>
   		</td>
</tr>
<tr>
   		<td align="right" >&nbsp;<font color="red">*&nbsp;</font>项目领域：</td>
   		<td align="left"><%=projectarea %></td>
</tr>
<tr>
   		<td align="right" >&nbsp;<font color="red">*&nbsp;</font>实施地域：</td>
   		<td align="left"><%=implearea%></td>
</tr>
<tr>
   		<td align="right" >&nbsp;<font color="red">*&nbsp;</font>参与项目运作人数：</td>
   		<td align="left">
   			<%=participatenum%>&nbsp;&nbsp;&nbsp;
   			专职人员人数：<%=fulltimenum%>
   		</td>
</tr>
<tr>
   		<td align="right" >&nbsp;<font color="red">*&nbsp;</font>曾获何种奖励：</td>
   		<td align="left"><%=award%></td>
</tr>
</tbody>

<tbody id="teaminfo" style="display:none">
<tr>
   		<td width="15%" align="right" >&nbsp;<font color="red">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp*&nbsp;</font>项目负责人：</td>
   		<td align="left">
   			<p>姓名：<%=majorname%></p>
   		
   		    <p>工作单位及职务:<%=majorduty%></p>
   		    <p>政治面貌：<%=zhengzhimap.get(majorpolista)==null?"":zhengzhimap.get(majorpolista)%></p>
   			<p>办公电话：<%=majorphone%></p>
 			<p>手机：<%=majorphone2%></p>
   			<p>电子邮箱：<%=majoremail%></p>
   		</td>
</tr>
<tr>
   		<td align="right" >&nbsp;<font color="red">*&nbsp;</font>项目指导教师：</td>
   		<td align="left">
   			<p>姓名：<%=guideteachername%></p>
   			
   			<p>工作单位及职务：<%=guideteacherduty%></p>
   			<p>政治面貌：<%=zhengzhimap.get(guideteacherpolista)==null?"":zhengzhimap.get(guideteacherpolista)%></p>
   			<p>办公电话：<%=guideteacherphone%></p>
   			<p>手机：<%=guideteacherphone2%></p>
   			<p>电子邮箱：<%=guideteacheremail%></p>
   		</td>
</tr>
<tr>
   		<td align="right">&nbsp;<font color="red">&nbsp;</font>项目主要人员：</td>
   		<td align="left">
   		  <table class="content-table" width="100%" border="0" cellspacing="0" id="teamtable">
        	<tr><td align="left">学号</td><td align="left">姓名</td><td align="left">院系</td><td align="left">联系电话</td><td align="left">职务</td><td></td></tr>
  				<%
		String snoids="";
		if(v.getId()!=-1){
			VolunteerProjectTeammember vpt= new VolunteerProjectTeammember();
			List list2= new ArrayList();
			List cdt2= new ArrayList();
			List snoidlist= new ArrayList();
			List dutylist=new ArrayList();
			List phonelist=new ArrayList();
			String vppid= v.getId()+"";
			cdt2.add("projectparticipateid="+vppid);
			cdt2.add("order by id ");
			list2= vpt.query(cdt2);
			
			if(list2.size()>0){
				for(int i=0;i<list2.size();i++){
					vpt=(VolunteerProjectTeammember)list2.get(i);
					snoidlist.add(vpt.getSno());
					 dutylist.add(vpt.getDuty());
					 phonelist.add(vpt.getName());
				}
			}
		snoids=Tool.join(",", snoidlist);
		System.out.println(snoids+"sssssssssssssssssss");
			BaseUserCode stu= new BaseUserCode();
			List list3= new ArrayList();
			List cdt3= new ArrayList();
			cdt3.add("id in ("+snoids+")");
			String xueyuan="";
			String duty="";
			list3=stu.query(cdt3);
			if(list3.size()>0){
				for(int i=0;i<list3.size();i++){
				stu = (BaseUserCode)list3.get(i)	;
				 xueyuan=(String)CEditConst.getAcademyNameMap(userInfo).get(stu.getDeptId()+"");
				 duty=((String)dutylist.get(i)).equals("-1")?"":(String)dutylist.get(i);
				%>
				<tr id='deleteSponsor_<%=stu.getId()%>'><td align="left"><%=stu.getName() %></td><td align="left"><%=stu.getCnName() %></td><td align="left"><%=xueyuan %></td><td align="left"><%=phonelist.get(i) %></td><td align="left"><%=duty %></td></tr>
				<% 
				}
			}
		}
		
		%>	
		</table>
   		</td>
</tr>


</tbody>

<tbody id="otherinfo" style="display:none">
<tr >
   		<td width="20%" align="right">&nbsp;<font color="red">&nbsp;</font>项目内容：</td>
   		<td align="left"><%=content%></td>
</tr>
<tr>
   		<td align="right">&nbsp;<font color="red">&nbsp;</font>项目背景意义：</td>
   		<td align="left"><%=meanings%></td>
</tr>
<tr>
   		<td align="right">&nbsp;<font color="red">&nbsp;</font>预计效果：</td>
   		<td align="left"><%=disiredresults%></td>
</tr>
<tr>
   		<td align="right">&nbsp;<font color="red">&nbsp;</font>项目实施地点：</td>
   		<td align="left"><%=impleplace%></td>
</tr>
<tr>
   		<td align="right">&nbsp;<font color="red">&nbsp;</font>项目宣传方案：</td>
   		<td align="left"><%=promotion%></td>
</tr>
<tr>
   		<td align="right">&nbsp;<font color="red">&nbsp;</font>项目特色：</td>
   		<td align="left"><%=specialist%></td>
</tr>
<tr>
   		<td align="right" >&nbsp;<font color="red">*&nbsp;</font>受益对象：</td>
   		<td align="left">
   			<%=beneficaiaries%>&nbsp;&nbsp;&nbsp;&nbsp;
   			预计直接受益人数：<%=benenum%>人
   		</td>
</tr>
<tr>
   		<td align="right">&nbsp;<font color="red">&nbsp;</font>学院团委、校级学生组织审批意见：</td>
   		<td align="left" ><%=checkcomments%></td>
</tr>
</tbody>

<tbody id="fileinfo" style="display:none">
<tr>
   		<td width="20%" align="right">&nbsp;<font color="red">&nbsp;</font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp附件：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
   		<td align="left" >
 <%
 ClientAttach ca1=new ClientAttach();
 ClientAttach ca = new ClientAttach();

 if(ids!=null&&ids.trim().length()>0){
 	String[] idArray = Tool.split(",",ids);
 	System.out.println(idArray);
 	for(int i=0;i<idArray.length;i++){
 	ca1= ca.getById(Tool.StrToInt(idArray[i]));
 	 %>
 	 <a href="<%=HeadConst.apache_url %>/servlet/attach?type=clientattach&id=<%=ca1.getId() %>" target="_blank"><img src='<%=HeadConst.apache_url %>/main/images/file1.gif' border="0"/>下载文件<%=ca1.getUploadName() %>
 	</a> 
 	<%
 	}
 }


%> 
		</td>
</tr>
</tbody>
<tbody id="rongyuinfo" style="display:none">
<tr>
   		<td width="15%" align="right">&nbsp;<font color="red">&nbsp;</font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp荣誉分配：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
   		<td align="left" >
                     														<%=HtmlTool.renderSelect(rongyulist, v.getHonour(), "Honour", "")%>
 
		</td>
</tr>
</tbody>

<tr>
  <th colspan="3">
  </th>
</tr>
</table>
</form>
<script type="text/javascript">
//实现标签切换的4个函数
function infoshow(val)
{
	switch(val)
	{
		case 1:
			$("#baseinfo").attr("style","display:block");
			$("#teaminfo").attr("style","display:none");
			$("#otherinfo").attr("style","display:none");
			$("#fileinfo").attr("style","display:none");
			$("#rongyuinfo").attr("style","display:none");
			$("#base").attr("class","labelon");
			$("#team").attr("class","labeloff");
			$("#other").attr("class","labeloff");
			$("#file").attr("class","labeloff");
			$("#rongyu").attr("class","labeloff");
			break;
		case 2:
			$("#baseinfo").attr("style","display:none");
			$("#teaminfo").attr("style","display:block");
			$("#otherinfo").attr("style","display:none");
			$("#fileinfo").attr("style","display:none");
			$("#rongyuinfo").attr("style","display:none");
			$("#base").attr("class","labeloff");
			$("#team").attr("class","labelon");
			$("#other").attr("class","labeloff");
			$("#file").attr("class","labeloff");
			$("#rongyu").attr("class","labeloff");
			break;
		case 3:
			$("#baseinfo").attr("style","display:none");
			$("#teaminfo").attr("style","display:none");
			$("#otherinfo").attr("style","display:block");
			$("#fileinfo").attr("style","display:none");
			$("#rongyuinfo").attr("style","display:none");
			$("#base").attr("class","labeloff");
			$("#team").attr("class","labeloff");
			$("#other").attr("class","labelon");
			$("#file").attr("class","labeloff");
			$("#rongyu").attr("class","labeloff");
			break;
		case 4:
			$("#baseinfo").attr("style","display:none");
			$("#teaminfo").attr("style","display:none");
			$("#otherinfo").attr("style","display:none");
			$("#fileinfo").attr("style","display:block");
			$("#rongyuinfo").attr("style","display:none");
			$("#base").attr("class","labeloff");
			$("#team").attr("class","labeloff");
			$("#other").attr("class","labeloff");
			$("#file").attr("class","labelon");
			$("#rongyu").attr("class","labeloff");
			break;
		case 5:
			$("#baseinfo").attr("style","display:none");
			$("#teaminfo").attr("style","display:none");
			$("#otherinfo").attr("style","display:none");
			$("#fileinfo").attr("style","display:none");
			$("#rongyuinfo").attr("style","display:block");
			$("#base").attr("class","labeloff");
			$("#team").attr("class","labeloff");
			$("#other").attr("class","labeloff");
			$("#file").attr("class","labeloff");
			$("#rongyu").attr("class","labelon");
			break;
			
	}
}
</script>
	</body>
</html>
