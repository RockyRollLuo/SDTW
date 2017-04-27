<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--山大志库--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>

<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(VolunteerZhikuDeclare.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	VolunteerZhikuDeclare v = (VolunteerZhikuDeclare)request.getAttribute("fromBean");
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
List ZkProjectTypeoptions = (List)request.getAttribute("ZkProjectTypeoptions");
List NoticeNameoptions = (List)request.getAttribute("NoticeNameoptions");
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
Map zkmaps=CEditConst.getZkProjectTypeMap(userInfo);
String cd1=v.getName(),cd2=v.getTeamname(),cd3=v.getAcademy(),cd4=(String)zkmaps.get(v.getType()),cd5=v.getIntention(),cd6=v.getProcess(),cd7=v.getArrange(),cd8=v.getExpectresults(),cd9=v.getResults(),cd10=v.getCost1(),cd11=v.getCost2(),cd12=v.getCost3(),cd13=v.getCost4(),cd14=v.getCost5(),cd15=v.getCost6(),cd16=v.getTotalcost();
String cdteam="",addfilelist="";
String ids=v.getAddfilelist();
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<link href="../css/common.css" rel="stylesheet" type="text/css"/>
<script src="../js/tablelist.js"></script>
<script src="../js/jquery.min.js"></script>
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
				<div class="browsetitle001">山大志库</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("山大志库") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
					 <li> <a href="#" onclick="history.go(-1);">返回</a></li> 
						
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
                    											
<table class="content-table">
<tr>
	<th colspan="3" align="left">“山大志库”申请表</th> 
</tr>
<tr>
	<td width="27%" align="right">项目名称</td>
	<td align="left" colspan="2"><%=cd1%></td>
</tr>
<tr>
	<td align="right">团队名称</td>
	<td align="left" colspan="2"><%=cd2%></td>
</tr>
<tr>
	<td align="right">所属单位</td>
	<td align="left" colspan="2"><%=HtmlTool.renderSelect(zhuguanoptions, "" + cd3, "Academy", "-1",true)%></td>
</tr>
<tr>
	<td align="right">项目分组</td>
	<td align="left" colspan="2"><%=cd4%></td>
</tr>
<tr>
	<td align="right">活动背景及目的</td>
	<td align="left" colspan="2"><%=cd5%></td>
</tr>
<tr>
	<td align="right">活动时间安排</td>
	<td align="left" colspan="2"><%=cd6%></td>
</tr>
<tr>
	<td align="right">活动流程</td>
	<td align="left" colspan="2"><%=cd7%></td>
</tr>
<tr>
	<td align="right">预期成果</td>
	<td align="left" colspan="2"><%=cd8%></td>
</tr>
<tr>
	<td align="right">已取得成果（选填）</td>
	<td align="left" colspan="2"><%=cd9%></td>
</tr>

<tr>
	<td align="right"><p>团队组成情况<p/></td>
	<td align="left" colspan="2">
		<table id="teamtable" style="width:100%;font-size:12px;text-align:center;">
			<tr>
				<td>学号</td><td>姓名</td><td>学院</td><td>联系方式</td><td>团队分工</td>
			</tr>
			<%
		String snoids="";
		if(v.getId()!=-1){
			VolunteerZhikuTeammember vpt= new VolunteerZhikuTeammember();
			List list2= new ArrayList();
			List cdt2= new ArrayList();
			List snoidlist= new ArrayList();
			List dutylist=new ArrayList();
			String vppid= v.getId()+"";
			cdt2.add("zhikudeclareid="+vppid);
			cdt2.add("order by id ");
			list2= vpt.query(cdt2);
			BaseUserCode stu= new BaseUserCode();
			String xueyuan="";
			Map xueyuanmap =CEditConst.getAcademyNameMap(userInfo);
			if(list2.size()>0){
				for(int i=0;i<list2.size();i++){
					vpt=(VolunteerZhikuTeammember)list2.get(i);
					stu=stu.getById(Integer.parseInt(vpt.getName()));
					if(stu.getDeptId()!=-1){
					xueyuan=(String)xueyuanmap .get(stu.getDeptId()+"");
					}
				%>
				<tr id='deleteSponsor_<%=stu.getId()%>'><td><%=stu.getName() %></td><td><%=stu.getCnName() %></td><td><%=xueyuan %></td><td><%=vpt.getPhone() %></td><td><%=vpt.getDuty() %></td></tr>
				<% 
				}
			
		}
		}
		%>	
			
		</table>
	</td>
</tr>
<tr>
	<td align="right">项目情况</td>
	<td align="left" colspan="2">
		<p><span class="itemname">交通费  </span><%=cd10%></p>
		<p><span class="itemname">住宿费  </span><%=cd11%></p>
		<p><span class="itemname">其它（请说明）  </span><%=cd12%></p>
		<p><span class="itemname">其它（请说明）  </span><%=cd13%></p>
		<p><span class="itemname">其它（请说明）  </span><%=cd14%></p>
		
		<p><span class="itemname">共计  </span><%=cd16%></p>
	</td>
</tr>
<tr>
	<td align="right">附件</td>
	<td align="left">
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

<tr>
	<th colspan="2">
	</th>
</tr>
</table>
                    											
			</form>
		</div>
	</body>
</html>
