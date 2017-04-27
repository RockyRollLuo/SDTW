<%@page import="com.xietong.software.sdtw.db.AcademyMoneyNums"%>
<%@page import="com.xietong.software.sdtw.pratice.PracticeUtil"%>
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
UserInfo userInfo = Tool.getUserInfo(request);
if(userInfo == null){
		out.print(HtmlTool.msgBox(request, "请先登录"));
		return;
}
String remark = ParamUtils.getParameter(request,"Remark","-1");//立项表id
if (cmd.equals("saveAcademyMoneyNums"))
{
	StandardupGradeUtil util = new StandardupGradeUtil();
	PracticeUtil pUtil = new PracticeUtil();
	Map map = pUtil.getAcademyMoneyNumsMap(remark);
	List list = new ArrayList();
	list = util.getAcademyList(-1);
	if (list.size()>0) {
		for (int i=0;i<list.size();i++) {
			AcademyMoneyNums v = new AcademyMoneyNums();
			double Money = ParamUtils.getDoubleParameter(request,"Money"+i,0.0);//经费
			int Type = ParamUtils.getIntParameter(request,"Type"+i,0);//个数
			String Sno = ParamUtils.getParameter(request,"Sno"+i,"-1");//学院
			if (Money>0.0&&Type>0&&!"".equals(Sno)) {
				if (map.get(Sno)!=null) {
					v = (AcademyMoneyNums)map.get(Sno);
				}
				v.setSno(Sno);
				v.setMoney(Money);
				v.setType(Type);
				v.setRemark(remark);
				if (map.get(Sno)==null) {
					v.insert();
				} else {
					v.update();
				}
			}
		}
	}
	map.clear();
	response.sendRedirect(HeadConst.apache_url+"/main/pratice/AcademyMoneyNums.jsp?_Remark_="+remark);
	return;
}
%>
