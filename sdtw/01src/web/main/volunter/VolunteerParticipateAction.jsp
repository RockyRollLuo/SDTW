<%@page import="java.util.regex.Pattern"%>
<%@page import="java.util.regex.Matcher"%>
<%@page import="org.omg.CORBA.Request"%>
<%@ page language="java" %>
<%--志愿活动报名表-学生素质拓展培养认证单-志愿活动--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!



%>
<%!
public List getOptions(){
	List list = new ArrayList();
	OptionBean ob=new OptionBean("优秀","0");
	OptionBean ob1=new OptionBean("良好","1");
	OptionBean ob2=new OptionBean("一般","2");
	list.add(ob);
	list.add(ob1);
	list.add(ob2);
	
	
	return list;
}


%>
<%!
private static Log log = LogFactory.getLog(VolunteerParticipate.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "ActivityId", "Sno", "HonourName", "CheckFlag", "Evaluation", "Servicelenth", "Apptime", "Addfilelist","Sname"};
private String[] DicKeys = {"Id", "ActivityId", "Sno", "HonourName", "CheckFlag", "Evaluation", "Servicelenth", "Apptime", "Addfilelist","Sname"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"String", "志愿活动名称", "0", "VolunActivityName", ""}, {"string", "学生学号", "20", "text", ""}, {"string", "荣誉名称", "45", "text", ""}, {"int", "审核标志", "0", "text", ""}, {"string", "考核等级", "20", "EvaluationType", ""}, {"int", "服务时长", "0", "text", ""}, {"date", "申请时间", "0", "hidden", ""}, {"string", "个人陈述", "500", "hidden", ""},{"string", "学生姓名", "20", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "ActivityId", "Sno", "HonourName", "CheckFlag", "Evaluation", "Servicelenth", "Apptime", "Addfilelist","Sname"};
private String[] ListFields = { "Sno","Sname","ActivityId", "CheckFlag","Evaluation",  "HonourName","Servicelenth"};
private String[] ListFields1 = { "Sno","Sname", "ActivityId","CheckFlag","Evaluation",   "HonourName","Servicelenth"};
private String[] ListFieldsPrint = { "ActivityId","Sno","Sname","Addfilelist"};
private String[] FormFields = {"ActivityId", "Sno", "HonourName", "CheckFlag", "Evaluation", "Servicelenth","Sname"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private VolunteerParticipate getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    VolunteerParticipate v = new VolunteerParticipate();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramActivityId(request, "ActivityId");
        v.paramSno(request, "Sno");
        v.paramHonourName(request, "HonourName");
        v.paramCheckFlag(request, "CheckFlag");
        v.paramEvaluation(request, "Evaluation");
        v.paramServicelenth(request, "Servicelenth");
        v.paramApptime(request, "Apptime");
        v.paramAddfilelist(request, "Addfilelist");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setActivityId(ParamUtils.getIntParameter(request, "ActivityId", -1));
        v.setSno(ParamUtils.getParameter(request, "Sno", ""));
        v.setHonourName(ParamUtils.getParameter(request, "HonourName", ""));
        v.setCheckFlag(ParamUtils.getIntParameter(request, "CheckFlag", -1));
        v.setEvaluation(ParamUtils.getParameter(request, "Evaluation", ""));
        v.setServicelenth(ParamUtils.getIntParameter(request, "Servicelenth", -1));
        v.setApptime(ParamUtils.getDateTimeParameter(request, "Apptime", java.sql.Date.valueOf("0001-01-01")));
        v.setAddfilelist(ParamUtils.getParameter(request, "Addfilelist", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, VolunteerParticipate pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map VolunActivityNamemap = CEditConst.getVolunActivityNameMap(userInfo);
    Map EvaluationTypemap = CEditConst.getEvaluationTypeMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    Honor honor= new Honor();
	List list2=new ArrayList();
	List cdt2= new ArrayList();
	String projectid = ParamUtils.getParameter(request, "_ActivityId_", "");
	cdt2.add("activityid="+projectid);

	list2=honor.query(cdt2);
	Map rongyumap = new HashMap();
	if(list2.size()>0){
		
		for(int i=0;i<list2.size();i++){
			honor=(Honor)list2.get(i);
			rongyumap.put(honor.getId()+"", honor.getHonorName());
			
		}
	}
	System.out.println(rongyumap);
BaseUserCode  user= new BaseUserCode ();
Map usermap= new HashMap();
List cdt3=  new ArrayList();
List list3=  new ArrayList();
cdt3.add("roles=3");
list3=user.query(cdt3);
if(list3.size()>0){
	for(int i=0;i<list3.size();i++){
		user= (BaseUserCode)list3.get(i);
		usermap.put(user.getName(), user.getCnName() );
	}
}
	//System.out.println(rongyumap);
	String ids = XtUtil.getColValusByList(vs,"Sno" ,VolunteerParticipate.class);
	List cdt1 = new ArrayList();
	cdt1.add("name in("+XtUtil.getIdsStr(ids)+")");
	Map map = XtUtil. getColValuMapByCdt(cdt1, "CnName","Name",BaseUserCode.class);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        VolunteerParticipate v = (VolunteerParticipate)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add((String)VolunActivityNamemap.get("" + v.getActivityId()));
       
        row.add("<a href='BaseUserCodeAction.jsp?cmd=modify1&sno="+Tool.jsSpecialChars(v.getSno())+"&_apid_="+v.getId()+"'>"+(String)usermap.get(v.getSno())+"</a>");
        System.out.println(v.getHonourName());
        row.add(rongyumap.get(v.getHonourName()));
        row.add(v.getCheckFlag()==-1?"未审核":(v.getCheckFlag()==1?"审核通过":"<font color='red'>审核未通过<font>"));
        row.add(v.getEvaluation());
        row.add("" + v.getServicelenth());
        row.add(Tool.stringOfDate(v.getApptime()));
        row.add(Tool.jsSpecialChars(v.getAddfilelist()));
        row.add((String)map.get(v.getSno()));
        rows.add(row);
    }
    map.clear();
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, VolunteerParticipate pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, VolunteerParticipate pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    qval = ParamUtils.getParameter(request, "_ActivityId_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0&& !qval.equals("-1")) {
        cdt.add("activityId=" + qval);
    }
    qval = ParamUtils.getParameter(request, "_CheckFlag_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0&& !qval.equals("-1")) {
        cdt.add("checkflag=" + qval);
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
request.setAttribute("hidefields", HideFields);

}


private void setList(javax.servlet.http.HttpServletRequest request, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    VolunteerParticipate pv = new VolunteerParticipate();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
   String check= ParamUtils.getParameter(request, "CheckFlag", "");
   request.setAttribute("CheckFlags", check);
    if(check.equals("1")){
    	 request.setAttribute("fields", ListFields1);	
    }else{
    request.setAttribute("fields", ListFields);}
    request.setAttribute("classname", "VolunteerParticipate");
    request.setAttribute("describe", "志愿活动报名表-学生素质拓展培养认证单-志愿活动");
    //request.setAttribute("ActivityId", ParamUtils.getParameter(request, "ActivityId", ""));
}
private void writeExcel(HttpServletRequest request, String filename,String idlist) {


    UserInfo userInfo = Tool.getUserInfo(request);
    VolunteerParticipate pv = new VolunteerParticipate();
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
                	String str = (String)row.get((Integer)indexMap.get(ListFieldsPrint[k]));
                	 Pattern p = Pattern.compile("<a[^>]*>([^<]*)</a>"); 
                     Matcher m = p.matcher(str); 
                     while(m.find()) { 
                         //System.out.println(m.group(1));
                         str = m.group(1);
                     }
                	Label lr = new Label(j, i, str);
                	
                    s1.addCell(lr);
                    j++;
                }
            }
        }
        //{"OrgId","DeptId" ,"Grade", "Major","Name", "CnName", "IDNum", "Roles","IsEnable"};
       // s1.setColumnView(0,0);
        s1.setColumnView(0,25);
        s1.setColumnView(3,45);
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
    VolunteerParticipate pv = new VolunteerParticipate();
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
private void setForm(javax.servlet.http.HttpServletRequest request, VolunteerParticipate form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("VolunActivityNameoptions", CEditConst.getVolunActivityNameOptions(userInfo, "-1"));
    request.setAttribute("EvaluationTypeoptions", CEditConst.getEvaluationTypeOptions(userInfo, ""));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "VolunteerParticipate");
    request.setAttribute("describe", "志愿活动报名表-学生素质拓展培养认证单-志愿活动");
    request.setAttribute("_ActivityId_", ParamUtils.getParameter(request, "_ActivityId_", ""));
    
}
private List mkRtn(String cmd, String forward, VolunteerParticipate form)
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
    VolunteerParticipate form = getByParameterDb(request);
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
    /* if (cmd.equals("excel"))
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
    if (cmd.equals("modify1"))
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
        form.setCheckFlag(1);
        form.update();
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("modifylist"))
    {
        String idlist = ParamUtils.getParameter(request, "idlist", "-1");
        List cdt = new ArrayList();
        System.out.println(idlist );
        cdt.add("id in (" + idlist + ")");
        VolunteerParticipate vp=new VolunteerParticipate();
      
        vp.setCheckFlag(1);
        vp.updateByCondition(cdt);
        ShortMessage sm= new ShortMessage();
        String[] huodongid=idlist.split(",");
        System.out.println(huodongid[0]);
        List xuehao = new ArrayList();
      List list=  vp.query(cdt);
      int subject=0;
      String shijian= "";
      String dizhi="";
      if(list.size()>0){
    	  for(int i=0;i<list.size();i++){
    		  vp=(VolunteerParticipate)list.get(i);
    		  subject=vp.getActivityId();
    		  
    		  xuehao.add("'"+vp.getSno()+"'");
    	  }
      }
      String ssubject=(String)CEditConst.getVolunActivityNameMap(userInfo).get(subject+"");
     VolunteerActivity va= new VolunteerActivity();
    va= va.getById(subject);
    shijian =Tool.stringOfDate(va.getStarttime())+"~"+Tool.stringOfDate(va.getEndtime());
    dizhi=va.getActivityPlace();
      List list2= new ArrayList();
      System.out.println(xuehao);
      String sxuehao= Tool.join(",",xuehao);
      System.out.println(sxuehao);
        BaseUserCode student= new BaseUserCode();
        cdt.clear();
        cdt.add("name in ("+sxuehao+")");
        List shoujianren= new ArrayList();
        list2=student.query(cdt);
        if(list2.size()>0){
        	for(int i=0;i<list2.size();i++){
        		student = ( BaseUserCode)list2.get(i);
        		shoujianren.add(student.getId());
        	}
        }
        System.out.println(shoujianren);
     if(shoujianren.size()>0){
    	   for(int i=0;i<shoujianren.size();i++){
    		   sm.setSubject(ssubject+"审核通知");
    		   sm.setSendId(userInfo.getId());
           	sm.setReceiveIds(shoujianren.get(i)+""); 
           	sm.setSmsStyle(1);
           	sm.setSendDate(new Date());
           	sm.setRemUrl("您申请参加的"+ssubject+"审核通过，请于"+shijian+"在"+dizhi+"准时参加");
           	sm.insert();
    	   }
       } 
        
        System.out.println("AAAAAAAAAAAAAAA");
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("modifylist1"))
    {
        String idlist = ParamUtils.getParameter(request, "idlist", "-1");
        List cdt = new ArrayList();
        cdt.add("id in (" + idlist + ")");
        VolunteerParticipate vp=new VolunteerParticipate();
        vp.setCheckFlag(2);
        vp.updateByCondition(cdt);
        ShortMessage sm= new ShortMessage();
        String[] huodongid=idlist.split(",");
        System.out.println(huodongid[0]);
        List xuehao = new ArrayList();
      List list=  vp.query(cdt);
      int subject=0;
      if(list.size()>0){
    	  for(int i=0;i<list.size();i++){
    		  vp=(VolunteerParticipate)list.get(i);
    		  subject=vp.getActivityId();
    		  xuehao.add("'"+vp.getSno()+"'");
    	  }
      }
      String ssubject=(String)CEditConst.getVolunActivityNameMap(userInfo).get(subject+"");
      List list2= new ArrayList();
      System.out.println(xuehao);
      String sxuehao= Tool.join(",",xuehao);
      System.out.println(sxuehao);
        BaseUserCode student= new BaseUserCode();
        cdt.clear();
        cdt.add("name in ("+sxuehao+")");
        List shoujianren= new ArrayList();
        list2=student.query(cdt);
        if(list2.size()>0){
        	for(int i=0;i<list2.size();i++){
        		student = ( BaseUserCode)list2.get(i);
        		shoujianren.add(student.getId());
        	}
        }
        System.out.println(shoujianren);
     if(shoujianren.size()>0){
    	   for(int i=0;i<shoujianren.size();i++){
    		   sm.setSubject(ssubject+"审核通知");
    		   sm.setSendId(userInfo.getId());
           	sm.setReceiveIds(shoujianren.get(i)+""); 
           	sm.setSmsStyle(1);
           	sm.setSendDate(new Date());
           	sm.setRemUrl("您申请参加的"+ssubject+"审核没有通过");
           	sm.insert();
    	   }
       } 
        
        System.out.println("AAAAAAAAAAAAAAA");
        System.out.println("AAAAAAAAAAAAAAA");
        
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("save"))
    {
        form.insert();
        return mkRtn("list", "list1", form);
    }
    if (cmd.equals("update"))
    {
        form.update();
        return mkRtn("list", "list1", form);
    }
    request.setAttribute("msg", "未规定的cmd:" + cmd);
    return mkRtn("list", "failure", form);
}
%>
<%
response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
log.debug("VolunteerParticipateAction");
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
forwardMap.put("list", "VolunteerParticipateAction.jsp");
forwardMap.put("list1", "VolunteerActivityAction.jsp");
forwardMap.put("failure", "VolunteerParticipateForm.jsp");
forwardMap.put("success", "VolunteerParticipateList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "VolunteerParticipateForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    System.out.println("zuixinwangzhi"+url);
    out.println("<script>window.location='VolunteerParticipateAction.jsp?cmd="+cmd+"&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
} else if(forwardKey.equals("excel")){
	out.clear();
	out  =  pageContext.pushBody();
	response.setContentType("applicationnd.ms-excel");
	response.sendRedirect(HeadConst.apache_url + "/main/upload/"+userInfo.getName()+".xls");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
