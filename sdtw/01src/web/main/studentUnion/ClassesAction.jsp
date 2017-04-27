<%@ page language="java" %>
<%--�꼶--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%@page import="com.xietong.software.base.Power"%>

<%!
private static Log log = LogFactory.getLog(Classes.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "Academy", "Name", "Gid", "OpName", "Beizhu", "IsEnable","banzhang","tuanzhishu","qitabanwei"};
private String[] DicKeys = {"Id", "Academy", "Name", "Gid", "OpName", "Beizhu", "IsEnable","banzhang","tuanzhishu","qitabanwei"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"int", "学院", "0", "AcademyName", ""}, {"string", "班级名", "50", "text", ""}, {"int", "年级", "0", "GradeName", ""}, {"int", "校区", "0", "text", ""}, {"string","备注", "0", "text", ""}, {"int", "�Ƿ����", "0", "YesNo", ""},{"int", "班长", "0", "text", ""}, {"int", "团支书", "0", "text", ""}, {"string","其他班委", "0", "text", ""},};
private String KeyField = "Id";
private String[] AllFields = {"Id", "Academy", "Name", "Gid", "OpName", "Beizhu", "banzhang","tuanzhishu","qitabanwei"};
private String[] ListFields = {"Name", "banzhang","tuanzhishu","qitabanwei"};
private String[] FormFields = {"Academy", "Name", "Gid", "OpName", "Beizhu", "IsEnable"};
private String[] QueryFields = {"Name"};
private String[] HideFields = {"Id"};
private Classes getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    Classes v = new Classes();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramAcademy(request, "Academy");
        v.paramName(request, "Name");
        v.paramGid(request, "Gid");
        v.paramOpName(request, "OpName");
        v.paramBeizhu(request, "Beizhu");
        v.paramIsEnable(request, "IsEnable");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setAcademy(ParamUtils.getIntParameter(request, "Academy", -1));
        v.setName(ParamUtils.getParameter(request, "Name", ""));
        v.setGid(ParamUtils.getIntParameter(request, "Gid", -1));
        v.setOpName(ParamUtils.getIntParameter(request, "OpName", -1));
        v.setBeizhu(ParamUtils.getParameter(request, "Beizhu", ""));
        v.setIsEnable(ParamUtils.getIntParameter(request, "IsEnable", -1));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, Classes pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map GradeNamemap = CEditConst.getGradeNameMap(userInfo);
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    Map YesNomap = CEditConst.getYesNoMap(userInfo);
    Map orgnamemap=CEditConst.getOrgNameMap(userInfo);
    		
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        Classes v = (Classes)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add((String)AcademyNamemap.get("" + v.getAcademy()));
        row.add(Tool.jsSpecialChars(v.getName()));
        row.add((String)GradeNamemap.get("" + v.getGid()));
        row.add(orgnamemap.get(v.getOpName()+""));
        row.add(Tool.jsSpecialChars(v.getBeizhu()));
       List banzhang=new ArrayList();
       List   tuanzhishu=new ArrayList();
        List  banwei=new ArrayList();
       List cdt1= new ArrayList();
       List list1= new ArrayList();
       StudentClassDuty scd= new  StudentClassDuty();
       cdt1.add("classname="+v.getId());
       BaseUserCode user= new BaseUserCode ();
       list1=scd.query(cdt1);
       if(list1.size()>0){
    	   for(int  i=0;i<list1.size();i++){
    		   scd=(StudentClassDuty)list1.get(i);
    		   if(scd.getDuty().equals("班长")){
    			   banzhang.add(user.getById(Integer.parseInt(scd.getSno())).getCnName());
    		   }
    		   if(scd.getDuty().equals("团支书")){
    			   tuanzhishu.add(user.getById(Integer.parseInt(scd.getSno())).getCnName());
    		   }
    		   if(scd.getDuty().equals("班委")){
    			   banwei.add(user.getById(Integer.parseInt(scd.getSno())).getCnName());
    		   }
    	   }
       }
       if(banzhang.size()>0){
        row.add((String)banzhang.get(0));
       }else{
    	   row.add("");  
       }
       if(tuanzhishu.size()>0){
           row.add((String)tuanzhishu.get(0));
          }else{
       	   row.add("");  
          }
       if(banwei.size()>0){
    	   String sbanwei=Tool.join(",", banwei);
    	   row.add(sbanwei);  
       }else{
    	   row.add(""); 
       }
        
    
        
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, Classes pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, Classes pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
BaseUserCode user=userInfo.getUserCode();
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
   if(userInfo.hasFunPower(Power.UserAdminPower)){
	   cdt.add("academy ="+user.getDeptId());
   }
    qval = ParamUtils.getParameter(request, "_academy_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("academy ="+qval);
    }
    qval = ParamUtils.getParameter(request, "_Name_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("name like '%" + qval + "%'");
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
    Classes pv = new Classes();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "Classes");
    request.setAttribute("describe", "�꼶");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    Classes pv = new Classes();
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
private void setForm(javax.servlet.http.HttpServletRequest request, Classes form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("GradeNameoptions", CEditConst.getGradeNameOptions(userInfo, "-1"));
    request.setAttribute("AcademyNameoptions", CEditConst.getAcademyNameOptions(userInfo, "-1"));
    request.setAttribute("YesNooptions", CEditConst.getYesNoOptions(userInfo, "-1"));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "Classes");
    request.setAttribute("describe", "�꼶");
}
private List mkRtn(String cmd, String forward, Classes form)
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
    Classes form = getByParameterDb(request);
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
        form.insert();
   
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("update"))
    {
        
        StudentClassDuty scd= new  StudentClassDuty();
        String banzhang=ParamUtils.getParameter(request, "banzhang", "-1");
        String tuanzhishu=ParamUtils.getParameter(request, "tuanzhishu", "-1");
        String banwei1=ParamUtils.getParameter(request, "banwei1", "-1");
        String banwei2=ParamUtils.getParameter(request, "banwei2", "-1");
        String banwei3=ParamUtils.getParameter(request, "banwei3", "-1");
        String banwei4=ParamUtils.getParameter(request, "banwei4", "-1");
        String banwei5=ParamUtils.getParameter(request, "banwei5", "-1");
        String banwei6=ParamUtils.getParameter(request, "banwei6", "-1");
        if(banzhang!="-1"){
        	scd.setSno( banzhang);
        	scd.setClassname(form.getId()+"" );
        	scd.setDuty("班长");
        	scd.insert();
        }
        if(tuanzhishu!="-1"){
        	scd.setSno( tuanzhishu);
        	scd.setClassname(form.getId()+"" );
        	scd.setDuty("团支书");
        	scd.insert();
        }
        if(banwei1!="-1"){
        	scd.setSno(banwei1);
        	scd.setClassname(form.getId()+"" );
        	scd.setDuty("班委");
        	scd.insert();
        }
        if(banwei2!="-1"){
        	scd.setSno( banwei2);
        	scd.setClassname(form.getId()+"" );
        	scd.setDuty("班委");
        	scd.insert();
        }
        if(banwei3!="-1"){
        	scd.setSno( banwei3);
        	scd.setClassname(form.getId()+"" );
        	scd.setDuty("班委");
        	scd.insert();
        }
        if(banwei4!="-1"){
        	scd.setSno( banwei4);
        	scd.setClassname(form.getId()+"" );
        	scd.setDuty("班委");
        	scd.insert();
        }
        if(banwei5!="-1"){
        	scd.setSno( banwei5);
        	scd.setClassname(form.getId()+"" );
        	scd.setDuty("班委");
        	scd.insert();
        }
        if(banwei6!="-1"){
        	scd.setSno( banwei6);
        	scd.setClassname(form.getId()+"" );
        	scd.setDuty("班委");
        	scd.insert();
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
log.debug("ClassesAction");
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
forwardMap.put("list", "ClassesAction.jsp");
forwardMap.put("failure", "ClassesForm.jsp");
forwardMap.put("success", "ClassesList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "ClassesForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='ClassesAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
