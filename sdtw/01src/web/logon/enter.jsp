<%@page import="java.util.Date"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.util.AESUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<link rel="stylesheet" type="text/css" href="../js/errormsg.css" />
<%
	/*用户帐号可能不唯一，故进行判断*/
	//设置页面不缓存
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	Log log = LogFactory.getLog(BaseUserCode.class);
	String scsrf = (String) session.getAttribute("csrftoken");
	String tcsrf = ParamUtils.getParameter(request, "csrftoken", "");
	if (scsrf == null || !scsrf.equals(tcsrf)) {
		response.sendRedirect(HeadConst.apache_url+"/404.jsp");
		return;
	}
	String userName = ParamUtils
			.getParameter(request, "Username", "-1").trim();
	if (userName.equals("-1")) {
		userName = ParamUtils.getParameter(request, "username", "-1")
				.trim();
	}
	String passWord = ParamUtils.getParameter(request, "pd", "-1");
	if (passWord.equals("-1")) {
		passWord = ParamUtils.getParameter(request, "code", "-1");
	}
	//String checkcode=ParamUtils.getParameter(request,"checkcode","-1");
	String skinId = ParamUtils.getParameter(request, "skinId", "blue");
	//if(!checkcode.equalsIgnoreCase(session.getAttribute("checkcode")+"")){
	//	 out.print(HtmlTool.msgBox(request, "请输入正 的验证码!", "logon.jsp", ""));
	//	 session.removeAttribute("checkcode");
	//	 return;
	//}
	//String flag=ParamUtils.getParameter(request,"flag","");
	//	int type=ParamUtils.getIntParameter(request,"type",1);
	int num = Tool.StrToInt((String) session.getAttribute("logonnum"));
	if (num > 5) {//超过五次无效登录
		Cookie[] cookies = request.getCookies();
		boolean cookieflag = false;
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if (cookie.getName().equals("MAINLOGONLIMIT")) {
				cookieflag = true;
				long start = Long.valueOf(cookie.getValue());
				long now = System.currentTimeMillis();
				if ((now - start) < 1000 * 60 * 10) {
					out.println(HtmlTool.msgBox(request, "登录错误次数过多，请"
							+ (10 - (now - start) / (1000 * 60))
							+ "分钟之后再登录", "../index.jsp", ""));
					return;
				} else {
					num = 0;
					Cookie tmp = new Cookie("MAINLOGONLIMIT", null);
					tmp.setMaxAge(0);
					response.addCookie(tmp);
					session.setAttribute("logonnum", "0");
				}
			}
		}
		if (!cookieflag) {
			Cookie cookie = new Cookie("MAINLOGONLIMIT",
					System.currentTimeMillis() + "");
			cookie.setMaxAge(1000 * 60 * 60);
			response.addCookie(cookie);
			out.println(HtmlTool.msgBox(request,
					"登录错误次数过多，请10分钟之后再登录！", "../index.jsp", ""));
			return;
		}
	}
	List cdt = new ArrayList();
	cdt.add("(name='" + userName + "' or code='" + userName
			+ "' or mobilephone='" + userName + "' )");
	cdt.add("enable=1");
	//登录的时候排除关联用户,避免重复
	//cdt.add("rid<=0");
	BaseUserCode[] uc = (new BaseUserCode()).queryByCondition(cdt);
	log.debug("uc.length=" + uc.length);
	if (uc.length < 1) {
		out.print(HtmlTool.msgBox(request, "请输入正确的用户帐号、代码或手机号码!",
				"../index.jsp", ""));
		return;
	} else if (uc.length > 1) {
		out.print(HtmlTool.msgBox(request,
				"您的账号不唯一。请通知您公司管理员，可先用员工编号登录！", "../index.jsp", ""));
		return;
	}
	int index = -1;
	//System.out.println(uc[0].getPwd()+"  "+Tool.encrypt(passWord)+"  "+uc[0].getId() + "  "+uc.length);
	for (int i = 0; i < uc.length; i++) {
		if (uc[i].getPwd().equals(Tool.encrypt(passWord))) {
			//	System.out.println(passWord);
			index = i;
			break;
		}
	}
	if (index == -1) {
		out.print(HtmlTool.msgBox(request, "请输入正确的密码!", "../index.jsp",
				""));
		num++;
		session.setAttribute("logonnum", num + "");
		return;
	}
	int re = ParamUtils.getIntParameter(request, "reuser", -1);
	if (re == 1) {
		Cookie cookie_un = new Cookie("SDFZUSERNAME_RE", userName);
		Cookie cookie_pwd = new Cookie("SDFZEGOVPASWARDS",
				AESUtils.encrypt("SDFZ_ZHXYabcde12", passWord));

		cookie_un.setMaxAge(365 * 24 * 60 * 60);
		cookie_pwd.setMaxAge(365 * 24 * 60 * 60);
		response.addCookie(cookie_un);
		response.addCookie(cookie_pwd);
	} else {
		Cookie cookie = new Cookie("SDFZUSERNAME_RE", "");
		Cookie cookie_pwd = new Cookie("SDFZEGOVPASWARDS", "");
		cookie.setMaxAge(0);
		cookie_pwd.setMaxAge(0);
		response.addCookie(cookie);
		response.addCookie(cookie_pwd);
	}
	/*
	String rems="";
	if(request.getParameterValues("IsRemember") !=null){
		String[] str=request.getParameterValues("IsRemember");
			
			for(int i=0;i<str.length;i++){
				rems+=","+str[i];
			}
			rems+=",";
			//majors=majors.substring(1,majors.length());
	}	
	request.setAttribute("rember",rems);

	log.debug("pwwwd:"+rems);
	
	if(",1,".equals(rems)){
		Cookie cookie_pwd = new Cookie("EGOVPASWARDS",Tool.encrypt(passWord));
		cookie_pwd.setMaxAge(1*12*60*60);
		response.addCookie(cookie_pwd);
	}else{
		Cookie cookie=new Cookie("EGOVPASWARDS",null);
		cookie.setValue(null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	 */
	//response.addCookie(cookie_pwd);
	//设置登录时选择皮肤
	if (!uc[index].getSkinId().equals(skinId)) {
		uc[index].setSkinId(skinId);
		//uc[index].update();
	}
	UserInfo ui1 = Tool.getUserInfo(request);
	if (ui1 != null) {
		ui1.removeCookie(response);
	}
	session.removeAttribute("UserInfo");
	UserInfo ui = new UserInfo(uc[index]);
	if (HeadConst.UserInfoInSession) {
		ui.setSkinId(skinId);
		session.setAttribute("userType", "jzg");
		session.setAttribute("UserInfo", ui);
	}
	ui.addCookie(response);
	BaseUserCode user = ui.getUserCode();
	String ip = getIpAddress(request);
	int type = ui.getUserCode().getDeptId();
	int LogonNum = user.getLogonNum()==-1?0:user.getLogonNum();
	if (ui.hasFunPower(Power.USERSTUDENTPOWER)) {//学生用户
		user.setLastTime(new Date());
		user.setIp(ip);
		user.setLogonNum(LogonNum+1);
		user.update();
		response.sendRedirect("../index.jsp");
	} else {//教师用户
		user.setLastTime(new Date());
		user.setIp(ip);
		user.setLogonNum(LogonNum+1);
		user.update();
		response.sendRedirect("../main/default.jsp?code=_");
	}
%>
<%!public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}%>

