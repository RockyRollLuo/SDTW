<%@page import="com.xietong.software.base.Power"%>
<%@ page language="java" %>
<%--社团变更负责人--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(ClubModifySponsor.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "ClubId", "ClubName", "ClubType", "ClubAcademy", "ClubAcadeMyNew", "CommentXy", "CheckFlag", "ApplyDate", "AddPerson", "AddTime", "ModiPerson", "ModiTime"};
private String[] DicKeys = {"Id", "ClubId", "ClubName", "ClubType", "ClubAcademy", "ClubAcadeMyNew", "CommentXy", "CheckFlag", "ApplyDate", "AddPerson", "AddTime", "ModiPerson", "ModiTime"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "登录账号", "45", "hidden", ""}, {"string", "社团名称", "45", "hidden", ""}, {"string", "社团类别", "45", "ClubTypeName", ""}, {"string", "原社团负责人", "45", "AcademyName", ""}, {"string", "新社团负责人", "45", "AcademyName", ""}, {"string", "指导单位意见", "500", "hidden", ""}, {"string", "审核状态", "45", "hidden", ""}, {"date", "申请时间", "0", "hidden", ""}, {"string", "申请人", "50", "hidden", ""}, {"date", "添加时间", "0", "hidden", ""}, {"string", "修改人", "50", "hidden", ""}, {"date", "修改时间", "0", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "ClubId", "ClubName", "ClubType", "ClubAcademy", "ClubAcadeMyNew", "CommentXy", "CheckFlag", "ApplyDate", "AddPerson", "AddTime", "ModiPerson", "ModiTime"};
private String[] ListFields = {"ClubName","ClubId","ClubType", "ClubAcademy", "ClubAcadeMyNew", "CheckFlag"};
private String[] FormFields = {"ClubName", "ClubType", "ClubAcademy", "ClubAcadeMyNew", "CommentXy", "AddPerson", "ModiPerson", "ModiTime"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private ClubModifySponsor getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    ClubModifySponsor v = new ClubModifySponsor();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramClubId(request, "ClubId");
        v.paramClubName(request, "ClubName");
        v.paramClubType(request, "ClubType");
        v.paramClubAcademy(request, "ClubAcademy");
        v.paramClubAcadeMyNew(request, "ClubAcadeMyNew");
        v.paramCommentXy(request, "CommentXy");
        v.paramCheckFlag(request, "CheckFlag");
        v.paramApplyDate(request, "ApplyDate");
        v.paramAddPerson(request, "AddPerson");
        v.paramAddTime(request, "AddTime");
        v.paramModiPerson(request, "ModiPerson");
        v.paramModiTime(request, "ModiTime");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setClubId(ParamUtils.getParameter(request, "ClubId", ""));
        v.setClubName(ParamUtils.getParameter(request, "ClubName", ""));
        v.setClubType(ParamUtils.getParameter(request, "ClubType", ""));
        v.setClubAcademy(ParamUtils.getParameter(request, "ClubAcademy", ""));
        v.setClubAcadeMyNew(ParamUtils.getParameter(request, "ClubAcadeMyNew", ""));
        v.setCommentXy(ParamUtils.getParameter(request, "CommentXy", ""));
        v.setCheckFlag(ParamUtils.getParameter(request, "CheckFlag", ""));
        v.setApplyDate(ParamUtils.getDateTimeParameter(request, "ApplyDate", java.sql.Date.valueOf("0001-01-01")));
        v.setAddPerson(ParamUtils.getParameter(request, "AddPerson", ""));
        v.setAddTime(ParamUtils.getDateTimeParameter(request, "AddTime", java.sql.Date.valueOf("0001-01-01")));
        v.setModiPerson(ParamUtils.getParameter(request, "ModiPerson", ""));
        v.setModiTime(ParamUtils.getDateTimeParameter(request, "ModiTime", java.sql.Date.valueOf("0001-01-01")));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, ClubModifySponsor pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    Map ClubTypeNamemap = CEditConst.getClubTypeNameMap(userInfo);
    Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);
    Map ClubNameMap = CEditConst.getClubNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        ClubModifySponsor v = (ClubModifySponsor)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getClubId()));
        row.add((String)ClubNameMap.get(v.getClubName()));
        row.add((String)ClubTypeNamemap.get("" + v.getClubType()));
        if(v.getClubAcademy().length()>0){
	        String uids[] = v.getClubAcademy().split(",");
	        List uidList1 = new ArrayList();
	        for(int i=0;i<uids.length;i++){
	        	String text = "编辑社团负责人";
	            if(!"".equals(v.getCheckFlag())) {
	            	text = "查看社团负责人";
	            }
	        //	uidList1.add(UserCnNameMap.get(uids[i]));
	        	uidList1.add("<a title='查看原负责人信息' href='javascript:void(0);' onclick=showwinside("+uids[i]+","+v.getClubName()+",'1','"+text+"');>"+UserCnNameMap.get(uids[i])+"</a>");
	        }
        	row.add(Tool.join(",",uidList1));
        }else{
        	row.add("");
        }
        String text = "编辑社团负责人";
        if(!"".equals(v.getCheckFlag())) {
        	text = "查看社团负责人";
        }
        if(v.getClubAcadeMyNew().length()>0){
        	String uids[] = v.getClubAcadeMyNew().split(",");
	        List uidList1 = new ArrayList();
	        for(int i=0;i<uids.length;i++){
	        	uidList1.add("<a title='查看新负责人信息' href='javascript:void(0);' onclick=showwinside("+uids[i]+","+v.getClubName()+",\'"+v.getCheckFlag()+"\','"+text+"');>"+UserCnNameMap.get(uids[i])+"</a>");
	        }
        	row.add(Tool.join(",",uidList1));
        }else{
        	row.add("");
        }
        //row.add((String)AcademyNamemap.get("" + v.getClubAcademy()));
        //row.add((String)AcademyNamemap.get("" + v.getClubAcadeMyNew()));
        row.add(Tool.jsSpecialChars(v.getCommentXy()));
        String flag = v.getCheckFlag();
        if ("1".equals(v.getCheckFlag())) {
        	flag = "审核通过,变更成功";
        } else if ("2".equals(v.getCheckFlag())) {
        	flag = "审核未通过";
        } else if ("0".equals(v.getCheckFlag())) {
        	flag = "提交";
        } else {
        	flag = "";
        }
        row.add(flag);
       // row.add(Tool.jsSpecialChars(v.getCheckFlag()));
        row.add(Tool.stringOfDate(v.getApplyDate()));
        row.add(Tool.jsSpecialChars(v.getAddPerson()));
        row.add(Tool.stringOfDate(v.getAddTime()));
        row.add(Tool.jsSpecialChars(v.getModiPerson()));
        row.add(Tool.stringOfDate(v.getModiTime()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, ClubModifySponsor pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, ClubModifySponsor pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
   	if (userInfo.hasFunPower(Power.STUSER)){
   		cdt.add("ClubId='"+userInfo.getName()+"'");
   	}
   	if (userInfo.hasFunPower(Power.UserAdminPower)) {
   		cdt.add("ClubId in( select clubid from club where academy="+userInfo.getUserCode().getDeptId()+")");
	   	cdt.add("checkflag!=''");
   	}
   	if (userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.XSST)) {
   		cdt.add("checkflag!=''");
   	}
    if (!isAll) {
        int currpage = ParamUtils.getIntParameter(request, "page", 1);
        com.xietong.software.common.PageControl pc = new com.xietong.software.common.PageControl(pv.getCount(cdt), currpage, shownum);
        cdt.add("limit " + pc.getOffset() + "," + pc.getShownum());
        request.setAttribute("PageControl", pc);
    }
    String cname = pv.getFieldByProperty(orderfield);
    if (cname.length() != 0) {
        cdt.add("order by " + cname + " " + ordertype);
        log.debug("order by " + cname + " " + ordertype);
    }
    request.setAttribute("queryfields", QueryFields);
    request.setAttribute("queryvalues", QueryValues);
    return cdt;
}
private void setList(javax.servlet.http.HttpServletRequest request)
{
    setList(request, false);
request.setAttribute("hidefields", HideFields);}
private void setList(javax.servlet.http.HttpServletRequest request, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    ClubModifySponsor pv = new ClubModifySponsor();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "ClubModifySponsor");
    request.setAttribute("describe", "社团变更负责人");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    ClubModifySponsor pv = new ClubModifySponsor();
    try {
        WorkbookSettings ws = new WorkbookSettings();
        ws.setLocale(new Locale("zh", "CN"));
        WritableWorkbook workbook = Workbook.createWorkbook(new File(filename), ws);
        WritableSheet s1 = workbook.createSheet("Sheet1", 0);
        for (int k = 0; k < DicValues.length; k ++) {
            Label lr = new Label(k, 0, DicValues[k][1]);
            s1.addCell(lr);
        }
        int i = 1;
        List condition = getListCondition(request, pv, true);
        int num = pv.getCount(condition);
        for (int pos = 0; pos < num; pos += 100) {
            List cdt = new ArrayList(condition);
            for (Iterator it = condition.iterator(); it.hasNext();) {
                cdt.add(new String((String)it.next()));
            }
            cdt.add("limit " + pos + ",100");
            for (Iterator rit = getListRows(request, pv, cdt).iterator(); rit.hasNext(); i ++) {
                List row = (List)rit.next();
                int j = 0;
                for (Iterator cit = row.iterator(); cit.hasNext(); j ++) {
                    Label lr = new Label(j, i, (String)cit.next());
                    s1.addCell(lr);
                }
            }
        }
        workbook.write();
        workbook.close();
    }
    catch (IOException e) {
    }
    catch (WriteException e) {
    }
}
private void setForm(javax.servlet.http.HttpServletRequest request, ClubModifySponsor form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("UserNameoptions", CEditConst.getUserNameOptions(userInfo, ""));
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("ClubNameoptions", CEditConst.getClubNameOptions(userInfo, ""));
    request.setAttribute("ClubTypeNameoptions", CEditConst.getClubTypeNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "ClubModifySponsor");
    request.setAttribute("describe", "社团变更负责人");
}
private List mkRtn(String cmd, String forward, ClubModifySponsor form)
{
    List rtn = new ArrayList();
    rtn.add(cmd);
    rtn.add(forward);
    rtn.add(form);
    return rtn;
}
public List main(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    log.debug("cmd=" + cmd);
    ClubModifySponsor form = getByParameterDb(request);
    if (cmd.equals("list"))
    {
        setList(request);
        return mkRtn("list", "success", form);
    }
    if (cmd.equals("listall"))
    {
        setList(request, true);
        return mkRtn(cmd, "success", form);
    }
    if (cmd.equals("excel"))
    {
        String filename = HeadConst.root_file_path + "/upload/temp/" + userInfo.getName() + ".xls";
        writeExcel(request, filename);
        return mkRtn(cmd, "excel", form);
    }
    if (cmd.equals("create"))
    {
        setForm(request, form);
        return mkRtn("save", "input", form);
    }
    if (cmd.equals("modify"))
    {
        form = form.getById(form.getId());
        setForm(request, form);
        return mkRtn("update", "input", form);
    }
    if (cmd.equals("delete"))
    {
        form.delete(form.getId());
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("deletelist"))
    {
        String idlist = ParamUtils.getParameter(request, "idlist", "-1");
        List cdt = new ArrayList();
        cdt.add("id in (" + idlist + ")");
        form.deleteByCondition(cdt);
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("save"))
    {
    	String checkFlag = ParamUtils.getParameter(request,"CheckFlag","");
    	if("0".equals(checkFlag)){
    		form.setApplyDate(new Date());
    	}
    	form.setAddTime(new Date());
    	form.setAddPerson(userInfo.getId()+"");
        form.insert();
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("update"))
    {
        form.update();
    	String checkFlag = ParamUtils.getParameter(request,"CheckFlag","");
    	if("1".equals(checkFlag)){
    		String ClubAcademy = ParamUtils.getParameter(request,"ClubAcademy","-1");//原负责人
    		String ClubAcadeMyNew = ParamUtils.getParameter(request,"ClubAcadeMyNew","-1");//新社团负责人
    		String ClubName = ParamUtils.getParameter(request,"ClubName","-1");
    		ClubMembers m = new ClubMembers();
    		List cdt = new ArrayList();
    		cdt.add("MemberClubname="+ClubName);
    		cdt.add("MemberName in("+ClubAcademy+")");
    		cdt.add("Identity!=1");
    		List list = new ArrayList();
    		list = m.query(cdt);
    		if (list.size()>0) {
    			m = (ClubMembers)list.get(0);
    			m.setIsManager("0");
    			m.update();
    		}
    		cdt.clear();
    		list.clear();
    		m = new ClubMembers();
    		cdt.clear();
    		cdt.add("MemberClubname="+ClubName);
    		cdt.add("MemberName in("+ClubAcadeMyNew+")");
    		list = m.query(cdt);
    		if (list.size()>0) {
    			m = (ClubMembers)list.get(0);
    			m.setIsManager("1");
    			m.update();
    		}
    		m.updateByCondition(cdt);
    	}
        return mkRtn("list", "list", form);
    }
    request.setAttribute("msg", "未规定的cmd:" + cmd);
    return mkRtn("list", "failure", form);
}
%>
<%
response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
log.debug("ClubModifySponsorAction");
int currpage = ParamUtils.getIntParameter(request, "page", 1);
List rtn = null;
UserInfo userInfo = Tool.getUserInfo(request);
if (userInfo==null) {
    rtn = mkRtn("login", "login", null);
}
else {
    rtn = main(request);
}
String cmd = (String)rtn.get(0);
String forwardKey = (String)rtn.get(1);
request.setAttribute("fromBean", rtn.get(2));
Map forwardMap = new HashMap();
forwardMap.put("login", "logon.jsp");
forwardMap.put("list", "ClubModifySponsorAction.jsp");
forwardMap.put("failure", "ClubModifySponsorForm.jsp");
forwardMap.put("success", "ClubModifySponsorList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "ClubModifySponsorForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='ClubModifySponsorAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
