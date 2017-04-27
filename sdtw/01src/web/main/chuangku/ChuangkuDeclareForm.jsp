<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--参加山大创库作品表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(ChuangkuDeclare.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	ChuangkuDeclare v = (ChuangkuDeclare)request.getAttribute("fromBean");
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
List CkProjectGroupoptions = (List)request.getAttribute("CkProjectGroupoptions");
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
List CkProjectTypeoptions = (List)request.getAttribute("CkProjectTypeoptions");
List Auditoptions = (List)request.getAttribute("Auditoptions");
List CkProjectStageoptions = (List)request.getAttribute("CkProjectStageoptions");
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
<%

int declareid=ParamUtils.getIntParameter(request, "Id", -1);
Map zhongleiOptions=CEditConst.getCkProjectTypeMap(userInfo);
Map chuangyefenzuOptions=CEditConst.getCkProjectGroupMap(userInfo);
System.out.println(chuangyefenzuOptions);
Map xiangmujieduan=CEditConst.getCkProjectStageMap(userInfo);
System.out.println(xiangmujieduan);

String cd1="",cd2="",cd3="",cd4="",cd5="",cd6="",cd7="",cd8="",cd9="",cd10="",cd11="",cd12="",cd13="",cd14="";
String cdp1="",cdp2="",cdp3="",cdp4="",cdteam="",addfilelist="";
ChuangkuDeclare cd= new  ChuangkuDeclare ();
cd=cd.getById(declareid);

cd1=v.getCd1();
if(v.getCd2()!=""){
cd2=(String)zhongleiOptions.get(v.getCd2());
}
if(v.getCd3()!=""){
cd3=(String)chuangyefenzuOptions.get(v.getCd3()+"");
}
cd4=v.getCd4();
cd5=v.getCd5();
cd6=v.getCd6();
if(v.getCd7()!=""){
cd7=(String)xiangmujieduan.get(v.getCd7()+"   ")==null?"":(String)xiangmujieduan.get(v.getCd7()+"   ");
}
cd8=v.getCd8();
cd9=v.getCd9();
cd10=v.getCd10();
cd11=v.getCd11();
cd12=v.getCd12();
cd13=v.getCd13();
cd14=v.getCd14();
%>
<body>
<%
String strposition = "创新创业>>山大创库>>";
String strfunction = "申请表详细";
String strhelpwords = "已填的申请表。";
%>
<%-- <%@ include file="../pubpro/pagetop-positionandhelp.jsp" %> --%>

	<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="ChuangkuDeclareAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						
					</ul>
				</div>
			</div>

<form name="form1" method="post" action="innovation-chuangku-declaresave.jsp">
<input type="hidden" name="cdteam" value=""/>
<table class="content-table">
<tr>
	<th colspan="8" align="left">“山大创库”项目入库申请表</th> 
</tr>

<tr>
	<td width="27%" align="right">项目名称</td>
	<td align="left"><%=cd1%></td>
</tr>
<tr>
	<td align="right">项目分类</td>
	<td align="left"><%=cd2%></td>
</tr>
<tr>
	<td align="right">项目分组</td>
	<td align="left"><%=cd3%></td>
</tr>
<tr>
	<td align="right">创业团队</td>
	<td align="left">
		<table class="content-table" id="teamtable">
			<tr>
				<td>姓名</td><td>学院</td><td>学号</td><td>联系方式</td><td>职责</td>
				<%
				BaseUserCode stu= new BaseUserCode();
				Map xynamemap=CEditConst.getAcademyNameMap(userInfo);
				ChuangkuDeclareMembers vpm= new ChuangkuDeclareMembers();
				List cdt1= new ArrayList();
				List list1= new ArrayList();
				cdt1.add("chuangkudeclareid ="+cd.getId());
				list1=vpm.query(cdt1);
				if(list1.size()>0){
					for(int i=0;i<list1.size();i++){
					vpm=(ChuangkuDeclareMembers)list1.get(i);
					stu=stu.getById(Integer.parseInt(vpm.getName()));
					cdp1=stu.getCnName();
					cdp2="";
					if(stu.getDeptId()!=-1){
					cdp2=(String)xynamemap.get(stu.getDeptId()+"");
					}
					cdp3= stu.getName();
					cdp4=vpm.getTel();
				
				%>
			</tr>
			<tr>
				
				<td><%=cdp1%></td>
				<td><%=cdp2%></td>
				<td><%=cdp3%></td>
				<td><%=cdp4%></td>
					<td><%=vpm.getDuty()%></td>
			</tr>
			<% 
					}
				}
			
			%>
	
		</table>
	</td>
</tr>
<tr>
	<td align="right">技术可行性分析</td>
	<td align="left"><%=cd4%></td>
</tr>
<tr>
	<td align="right">市场可行性分析</td>
	<td align="left"><%=cd5%></td>
</tr>
<tr>
	<td align="right">项目推进时间分析</td>
	<td align="left"><%=cd6%></td>
</tr>
<tr>
	<td align="right">项目阶段</td>
	<td align="left"><%=cd7%></td>
</tr>
<tr>
	<td align="right">项目情况</td>
	<td align="left">
		<p>是否有社会资金注入：<%=cd8%>（请注明注资额度为<%=cd9%> 万）</p>
		<p>计划注册资本金为：<%=cd10%>万，其中创业团队自有资金<%=cd11%> 万</p>
		<p>团队已经经营该项目时间：<%=cd12%>个月，盈利情况：<%=cd13%> 万</p>
	</td>
</tr>
<tr>
	<td align="right">备注</td>
	<td align="left"><%=cd14%></td>
</tr>
<tr>
	<td align="right">附件</td>
	<td align="left">
 <%
 String ids="";
 ids=cd.getAddFilelist();
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

</body>
</html>
