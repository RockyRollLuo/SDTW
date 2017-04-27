<%@page import="net.sf.json.JSONArray"%>
<%@page import="net.sf.json.JSON"%>
<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="sun.swing.UIAction"%>
<%@page import="com.xietong.software.sdtw.campus.CampusUtil"%>
<%@ page language="java" %>
<%--校园文化活动报名-学生素质拓展培养认证单--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(CampusParticipate.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "CampusActivityId", "StudentNo", "StudentAcademy", "StudentName", "ApplyTime", "CheckFlag", "FinalRounds", "Honor"};
private String[] DicKeys = {"Id", "CampusActivityId", "StudentNo", "StudentAcademy", "StudentName", "ApplyTime", "CheckFlag", "FinalRounds", "Honor"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "活动名称", "10", "text", ""}, {"string", "学号", "40", "text", ""}, {"string", "学院", "50", "AcademyName", ""}, {"string", "姓名", "50", "text", ""}, {"date", "申请时间", "0", "hidden", ""}, {"int", "审核", "0", "text", ""}, {"int", "晋级轮次", "0", "text", ""}, {"string", "荣誉", "45", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "CampusActivityId", "StudentNo", "StudentAcademy", "StudentName", "ApplyTime", "CheckFlag", "FinalRounds", "Honor"};
private String[] ListFields1 = {"CampusActivityId","ApplyTime","StudentAcademy", "StudentNo", "StudentName", "CheckFlag"};
private String[] ListFields2 = {"CampusActivityId","ApplyTime","StudentAcademy", "StudentNo", "StudentName","FinalRounds"};
private String[] ListFields3 = {"CampusActivityId","ApplyTime","StudentAcademy", "StudentNo", "StudentName","Honor"};
private String[] ListFieldsPrint = {"CampusActivityId","ApplyTime","StudentAcademy", "StudentNo", "StudentName","FinalRounds","CheckFlag"};
private String[] FormFields = {"CampusActivityId", "StudentNo", "StudentAcademy", "StudentName", "ApplyTime", "CheckFlag", "FinalRounds", "Honor"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private CampusParticipate getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    CampusParticipate v = new CampusParticipate();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramCampusActivityId(request, "CampusActivityId");
        v.paramStudentNo(request, "StudentNo");
        v.paramStudentAcademy(request, "StudentAcademy");
        v.paramStudentName(request, "StudentName");
        v.paramApplyTime(request, "ApplyTime");
        v.paramCheckFlag(request, "CheckFlag");
        v.paramFinalRounds(request, "FinalRounds");
        v.paramHonor(request, "Honor");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setCampusActivityId(ParamUtils.getParameter(request, "CampusActivityId", ""));
        v.setStudentNo(ParamUtils.getParameter(request, "StudentNo", ""));
        v.setStudentAcademy(ParamUtils.getParameter(request, "StudentAcademy", ""));
        v.setStudentName(ParamUtils.getParameter(request, "StudentName", ""));
        v.setApplyTime(ParamUtils.getDateTimeParameter(request, "ApplyTime", java.sql.Date.valueOf("0001-01-01")));
        v.setCheckFlag(ParamUtils.getIntParameter(request, "CheckFlag", 0));
        v.setFinalRounds(ParamUtils.getIntParameter(request, "FinalRounds", 1));
        v.setHonor(ParamUtils.getParameter(request, "Honor", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, CampusParticipate pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);
    Map TotalRoundsMap = CEditConst.getTotalRoundsMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    Map map = new HashMap();
    Map userNameMap = new HashMap();
	String ids = XtUtil.getColValusByList(vs,"CampusActivityId" ,CampusParticipate.class);
	if (ids.length()>0) {
		List cdt1 = new ArrayList();
		cdt1.add("id in("+ids+")");
		map = XtUtil. getColValuMapByCdt(cdt1, "ActivityName",CampusActivity.class);
	}
	String uids = XtUtil.getColValusByList(vs,"StudentName" ,CampusParticipate.class);
	if (uids.length()>0) {
		List cdt1 = new ArrayList();
		cdt1.add("id in("+uids+")");
		userNameMap = XtUtil. getColValuMapByCdt(cdt1, "CnName",BaseUserCode.class);
	}
    for (Iterator it = vs.iterator(); it.hasNext();) {
        CampusParticipate v = (CampusParticipate)it.next();
        List row = new ArrayList();
        
        row.add("" + v.getId());
        row.add((String)map.get(v.getCampusActivityId()));
        row.add(Tool.jsSpecialChars(v.getStudentNo()));
        row.add((String)AcademyNamemap.get("" + v.getStudentAcademy()));
        row.add((String)userNameMap.get(v.getStudentName()));
        row.add(Tool.stringOfDate(v.getApplyTime()));
        if(v.getCheckFlag()==-1){
        	row.add("未审核");
        }
        if(v.getCheckFlag()==1){
        	row.add("审核通过");
        }
        if(v.getCheckFlag()==0){
        	row.add("审核不通过");
        }
        if (v.getFinalRounds()<2) {
	        row.add("第"+(String)TotalRoundsMap.get("" + v.getFinalRounds())+"轮");
        } else {
        	row.add("最后一轮");
        }
        row.add(v.getHonor());
        rows.add(row);
    }
    map.clear();
	userNameMap.clear();
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, CampusParticipate pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, CampusParticipate pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    qval = ParamUtils.getParameter(request,"_flag_","");
    if(!"".equals(qval.trim())){
    	int CampusActivityId = ParamUtils.getIntParameter(request,"_CampusActivityId_",-1);
		cdt.add("CampusActivityId="+CampusActivityId);
    	if("1".equals(qval.trim())){//报名管理
    		
    	}
		if("2".equals(qval.trim())){//成绩管理
    		cdt.add("checkflag=1");
    	}
		if("3".equals(qval.trim())){//荣誉管理
			CampusActivity ca = new CampusActivity();
			if(CampusActivityId!=-1&&ca.getById(CampusActivityId)!=null){
				ca = ca.getById(CampusActivityId);
				cdt.add("FinalRounds="+ca.getTotalRounds());
			}
    		
    	}
    }
    List QueryValues = new ArrayList();
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
    CampusParticipate pv = new CampusParticipate();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    String flag = ParamUtils.getParameter(request,"_flag_","");
    if("1".equals(flag)){
    	request.setAttribute("fields", ListFields1);
    }
    if("2".equals(flag)){
    	request.setAttribute("fields", ListFields2);
    }
    if("3".equals(flag)){
    	request.setAttribute("fields", ListFields3);
    }
    request.setAttribute("classname", "CampusParticipate");
    request.setAttribute("describe", "校园文化活动报名-学生素质拓展培养认证单");
}
private void writeExcel(HttpServletRequest request, String filename,String idlist) {


    UserInfo userInfo = Tool.getUserInfo(request);
    CampusParticipate pv = new CampusParticipate();
    Map indexMap = new HashMap();
    try {
        WorkbookSettings ws = new WorkbookSettings();
        ws.setLocale(new Locale("zh", "CN"));
        WritableWorkbook workbook = Workbook.createWorkbook(new File(filename), ws);
        WritableSheet s1 = workbook.createSheet("Sheet1", 0);
        for(int i = 0 ;i < AllFields.length; i ++){
        	indexMap.put(AllFields[i], i);
        }
        for (int k = 0; k < ListFieldsPrint.length; k ++) {
            Label lr = new Label(k, 0, DicValues[(Integer)indexMap.get(ListFieldsPrint[k])][1]);
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
            cdt.add("CheckFlag=1");
            if(!idlist.equals("all"))
            cdt.add("id in (" + idlist + ")");
            cdt.add("limit " + pos + ",100");
            for (Iterator rit = getListRows(request, pv, cdt).iterator(); rit.hasNext(); i ++) {
                List row = (List)rit.next();
                int j = 0;
                for (int k = 0; k < ListFieldsPrint.length; k ++) {
                	
                	Label lr = new Label(j, i, (String)row.get((Integer)indexMap.get(ListFieldsPrint[k])));
                    s1.addCell(lr);
                    j++;
                }
            }
        }
        //{"OrgId","DeptId" ,"Grade", "Major","Name", "CnName", "IDNum", "Roles","IsEnable"};
       // s1.setColumnView(0,0);
        s1.setColumnView(0,25);
        s1.setColumnView(1,25);
        s1.setColumnView(2,15);
        s1.setColumnView(3,10);
        s1.setColumnView(4,25);
        s1.setColumnView(5,15);
        workbook.write();
        workbook.close();
    }
    catch (IOException e) {
    }
    catch (WriteException e) {
    }finally{
    	indexMap.clear();
    }
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    CampusParticipate pv = new CampusParticipate();
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
private void setForm(javax.servlet.http.HttpServletRequest request, CampusParticipate form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "CampusParticipate");
    request.setAttribute("describe", "校园文化活动报名-学生素质拓展培养认证单");
}
private List mkRtn(String cmd, String forward, CampusParticipate form)
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
    CampusParticipate form = getByParameterDb(request);
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
   /*  if (cmd.equals("excel"))
    {
        String filename = HeadConst.root_file_path + "/upload/temp/" + userInfo.getName() + ".xls";
        writeExcel(request, filename);
        return mkRtn(cmd, "excel", form);
    } */
    if (cmd.equals("excel"))
    {
    	String idlist = ParamUtils.getParameter(request, "idlist", "-1");
        String filename = HeadConst.root_file_path + "/main/upload/" + userInfo.getName() + ".xls";
        writeExcel(request, filename,"all");
        return mkRtn(cmd, "excel", form);
    }
    if (cmd.equals("excelselect"))
    {
    	String idlist = ParamUtils.getParameter(request, "idlist", "-1");
        String filename = HeadConst.root_file_path + "/main/upload/" + userInfo.getName() + ".xls";
        writeExcel(request, filename,idlist);
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
    if (cmd.equals("auditsbaoming"))
    {
        String idlist = ParamUtils.getParameter(request, "idlist", "-1");
        int CheckFlag = ParamUtils.getIntParameter(request,"CheckFlag",-1);
        CampusParticipate cp = new CampusParticipate();
        List cdt = new ArrayList();
        cdt.add("id in (" + idlist + ")");
        cp.setCheckFlag(CheckFlag);
        cp.updateByCondition(cdt);
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("auditspass"))
    {
        String idlist = ParamUtils.getParameter(request, "idlist", "-1");
        int FinalRounds = ParamUtils.getIntParameter(request,"FinalRounds",-1);
        CampusParticipate cp = new CampusParticipate();
        List cdt = new ArrayList();
        cdt.add("id in (" + idlist + ")");
        cp.setFinalRounds(FinalRounds);
        cp.updateByCondition(cdt);
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
        form.insert();
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("update"))
    {
        form.update();
        return mkRtn("list", "list", form);
    }
    request.setAttribute("msg", "未规定的cmd:" + cmd);
    return mkRtn("list", "failure", form);
}
%>
<%
response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
log.debug("CampusParticipateAction");
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
forwardMap.put("list", "CampusParticipateAction.jsp");
forwardMap.put("failure", "CampusParticipateForm.jsp");
forwardMap.put("success", "CampusParticipateList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "CampusParticipateForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
String tmp = ParamUtils.getParameter(request,"cmd","");
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='CampusParticipateAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else if(tmp.equals("HonorOptions")){
	int HonorType = ParamUtils.getIntParameter(request,"HonorType",-1);
	int ActivityId = ParamUtils.getIntParameter(request,"ActivityId",-1);
	CampusParticipate cp = new CampusParticipate();
	List cdt1 = new ArrayList();
	List list1 = new ArrayList();
	Map<String,String> honorMap = new HashMap<String,String> (); 
	cdt1.add("CampusActivityId="+ActivityId);
	cdt1.add("1=1 order by id desc");
	list1 = cp.query(cdt1);
	if(list1.size()>0){
		for(int i=0;i<list1.size();i++){
			cp = (CampusParticipate)list1.get(i);
			honorMap.put(cp.getId()+"_"+cp.getHonor(),cp.getHonor());
		}
	}
	Honor v = new Honor();
	List list = new ArrayList();
	List cdt = new ArrayList();
	cdt.add("HonorType="+HonorType);
	cdt.add("ActivityId="+ActivityId);
	list = v.query(cdt);
	List sbList = new ArrayList();
	if(list.size()>0){
		for(int m=0;m<list1.size();m++) {
			StringBuffer sb = new StringBuffer();
			sb.append("<option value='-1'></option>");
			CampusParticipate cap = new CampusParticipate();
			cap = (CampusParticipate)list1.get(m);
		for(int i=0;i<list.size();i++){
			v = (Honor)list.get(i);
			if(honorMap.get(cap.getId()+"_"+v.getId())!=null) {
				sb.append("<option value='"+v.getId()+"' selected='selected'>"+v.getHonorName()+"</option>");
			} else {
				sb.append("<option value='"+v.getId()+"'>"+v.getHonorName()+"</option>");
			} 
			
		}
			sbList.add(sb.toString());
	}
	}
	honorMap.clear();
	JSONArray jsonObject = JSONArray.fromObject(sbList);
	out.println(jsonObject.toString());
	jsonObject.clear();
	return;
}else if ("audithonor".equals(tmp)) {
	String val = ParamUtils.getParameter(request,"val","-1");
	String ids = ParamUtils.getParameter(request,"ids","-1");
	String valArr[] = val.split(",");
	String idsArr[] = ids.split(",");
	List cdt = new ArrayList();
	List list = new ArrayList();
	Map<String,Integer>honorNumMap = new HashMap<String,Integer>();//奖项表奖项对应数量
	Map<String,Integer>honorTmpNumMap = new HashMap<String,Integer>();//统计前台奖项数量
	Map<String,Integer>honorActivityNumMap = new HashMap<String,Integer>();//统计活动已分配奖项数量
	Honor h = new Honor();
	cdt.add("id in("+val+")");
	list = h.query(cdt);
	for (int i=0;i<list.size();i++) {
		h = (Honor)list.get(i);
		honorNumMap.put(h.getId()+"",h.getIsEnable());
	}
	for(int i=0;i<valArr.length;i++) {
		if(honorTmpNumMap.get(valArr[i])==null){
			honorTmpNumMap.put(valArr[i],1);
		}else{
			honorTmpNumMap.put(valArr[i],honorTmpNumMap.get(valArr[i])+1);
		}
	}
	
	CampusParticipate cap = new CampusParticipate();
	List capList = new ArrayList();
	List capcdt = new ArrayList();
	capcdt.add("honor in("+ids+")");
	capList = cap.query(cdt);
	if (capList.size()>0) {
		for (int i=0; i<capList.size(); i++) {
			cap = (CampusParticipate)capList.get(i);
			if (honorActivityNumMap.get(cap.getHonor())==null) {
				honorActivityNumMap.put(cap.getHonor(),1);
			} else {
				honorActivityNumMap.put(cap.getHonor(),honorActivityNumMap.get(cap.getHonor())+1);
			}
		}
	}
	
	for(int i=0;i<valArr.length;i++) {
		if (honorActivityNumMap.get(valArr[i])==null) {
			honorActivityNumMap.put(valArr[i],0);
		}
		if (!"-1".equals(valArr[i])) {
			if (honorTmpNumMap.get(valArr[i])+honorActivityNumMap.get(valArr[i])>honorNumMap.get(valArr[i])) {
				out.print("{\"msg\":\"no\"}");
				return;
			} else {
				CampusParticipate cp = new CampusParticipate();
				cp = cp.getById(Tool.StrToInt(idsArr[i]));
				cp.setHonor(valArr[i]);
				cp.update();
			}
		} else {
			CampusParticipate cp = new CampusParticipate();
			cp = cp.getById(Tool.StrToInt(idsArr[i]));
			cp.setHonor(valArr[i]);
			cp.update();
		}
	}
	
	honorNumMap.clear();
	honorTmpNumMap.clear();
	honorActivityNumMap.clear();
	out.println("{\"msg\":\"ok\"}");
	return;
}else if(forwardKey.equals("excel")){
	out.clear();
	out  =  pageContext.pushBody();
	response.setContentType("applicationnd.ms-excel");
	response.sendRedirect(HeadConst.apache_url + "/main/upload/"+userInfo.getName()+".xls");
}else{
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
