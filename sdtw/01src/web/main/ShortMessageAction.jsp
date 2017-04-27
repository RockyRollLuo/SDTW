<%@ page language="java" %>
<%--站内信--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%!
private static Log log = LogFactory.getLog(ShortMessage.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "SendDate", "Subject", "MsgGrade", "SendId", "ReceiveIds", "IfSee", "Receipt", "CollectDate", "SaveDate", "SmsStyle", "AttachIds", "RemUrl", "RemindSys", "IsEnable", "RemindType","shoujian"};
private String[] DicKeys = {"Id", "SendDate", "Subject", "MsgGrade", "SendId", "ReceiveIds", "IfSee", "Receipt", "CollectDate", "SaveDate", "SmsStyle", "AttachIds", "RemUrl", "RemindSys", "IsEnable", "RemindType"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"date", "短消息发送时间", "0", "text", ""}, {"string", "短消息标题", "500", "text", ""}, {"int", "短消息级别", "0", "MsgGrade", ""}, {"int", "发送人", "0", "UserName", ""}, {"string", "接收人", "500", "text", ""}, {"int", "是否查看", "0", "YesNo", ""}, {"int", "是否回执", "0", "YesNo", ""}, {"date", "短消息收藏时间", "0", "text", ""}, {"date", "短消息保存时间", "0", "text", ""}, {"int", "短消息级别", "0", "MsgProp", ""}, {"string", "相关附件ids", "200", "text", ""}, {"string", "跳转地址", "200", "text", ""}, {"string", "RemindSys", "20", "RemindSys", ""}, {"int", "是否可用", "0", "YesNo", ""}, {"string", "提醒方式", "20", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "SendDate", "Subject", "MsgGrade", "SendId", "ReceiveIds", "IfSee", "Receipt", "CollectDate", "SaveDate", "SmsStyle", "AttachIds", "RemUrl", "RemindSys", "IsEnable", "RemindType"};
private String[] caogaoListFields = {"Subject","SaveDate",  "MsgGrade",  "ReceiveIds"};
private String[] fajianListFields = {"Subject","SendDate",  "ReceiveIds", "MsgGrade"};
private String[] shoujianListFields = {"Subject","SendDate", "SendId", "MsgGrade",  "IfSee"};
private String[] ListFields = {"Subject","SendDate",  "MsgGrade",  "ReceiveIds"};
private String[] FormFields = {"Content", "SendDate", "Subject", "MsgGrade", "SendId", "ReceiveIds", "IfSee", "Receipt", "CollectDate", "SaveDate", "SmsStyle", "AttachIds", "RemUrl", "RemindSys", "IsEnable"};
private String[] QueryFields = {"SendDate", "Subject", "MsgGrade", "SendId", "IfSee", "Receipt", "CollectDate", "SaveDate"};
private String[] HideFields = {"Id"};

private ShortMessage getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    ShortMessage v = new ShortMessage();
    Map UserCnamesmap=CEditConst.getUserCnNameMap(userInfo);
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramSendDate(request, "SendDate");
        v.paramSubject(request, "Subject");
        v.paramMsgGrade(request, "MsgGrade");
        v.paramSendId(request, "SendId");
        v.paramReceiveIds(request, "ReceiveIds");
        v.paramIfSee(request, "IfSee");
        v.paramReceipt(request, "Receipt");
        v.paramCollectDate(request, "CollectDate");
        v.paramSaveDate(request, "SaveDate");
        v.paramSmsStyle(request, "SmsStyle");
        v.paramAttachIds(request, "AttachIds");
        v.paramRemUrl(request, "RemUrl");
        v.paramRemindSys(request, "RemindSys");
        v.paramIsEnable(request, "IsEnable");
        v.paramRemindType(request, "RemindType");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setSendDate(ParamUtils.getDateTimeParameter(request, "SendDate", java.sql.Date.valueOf("0001-01-01")));
        v.setSubject(ParamUtils.getParameter(request, "Subject", ""));
        v.setMsgGrade(ParamUtils.getIntParameter(request, "MsgGrade", -1));
        v.setSendId(ParamUtils.getIntParameter(request, "SendId", -1));
        v.setReceiveIds(ParamUtils.getParameter(request, "ReceiveIds", ""));
        v.setIfSee(ParamUtils.getIntParameter(request, "IfSee", -1));
        v.setReceipt(ParamUtils.getIntParameter(request, "Receipt", -1));
        v.setCollectDate(ParamUtils.getDateTimeParameter(request, "CollectDate", java.sql.Date.valueOf("0001-01-01")));
        v.setSaveDate(ParamUtils.getDateTimeParameter(request, "SaveDate", java.sql.Date.valueOf("0001-01-01")));
        v.setSmsStyle(ParamUtils.getIntParameter(request, "SmsStyle", -1));
        v.setAttachIds(ParamUtils.getParameter(request, "AttachIds", ""));
        v.setRemUrl(ParamUtils.getParameter(request, "RemUrl", ""));
        v.setRemindSys(ParamUtils.getParameter(request, "RemindSys", ""));
        v.setIsEnable(ParamUtils.getIntParameter(request, "IsEnable", -1));
        v.setRemindType(ParamUtils.getParameter(request, "RemindType", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, ShortMessage pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map MsgGrademap = CEditConst.getMsgGradeMap(userInfo);
    Map MsgPropmap = CEditConst.getMsgPropMap(userInfo);
    Map YesNomap = CEditConst.getYesNoMap(userInfo);
    Map UserNamemap = CEditConst.getUserNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        ShortMessage v = (ShortMessage)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.stringOfDate(v.getSendDate()));
        row.add(Tool.jsSpecialChars(v.getSubject()));
        row.add((String)MsgGrademap.get("" + v.getMsgGrade()));
        row.add((String)UserNamemap.get("" + v.getSendId()));
      //  row.add(Tool.jsSpecialChars(v.getReceiveIds()));
        row.add((String)UserNamemap.get("" + v.getReceiveIds()));
        row.add((String)YesNomap.get("" + v.getIfSee()));
        row.add((String)YesNomap.get("" + v.getReceipt()));
        row.add(Tool.stringOfDate(v.getCollectDate()));
        row.add(Tool.stringOfDate(v.getSaveDate()));
        row.add((String)MsgPropmap.get("" + v.getSmsStyle()));
        row.add(Tool.jsSpecialChars(v.getAttachIds()));
        row.add(Tool.jsSpecialChars(v.getRemUrl()));
        row.add((String)YesNomap.get("" + v.getIsEnable()));
        row.add(Tool.jsSpecialChars(v.getRemindType()));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, ShortMessage pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, ShortMessage pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    BaseUserCode user = new BaseUserCode();
	 user=userInfo.getUserCode();
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
 
    qval = ParamUtils.getParameter(request, "_SendDate_", "");
    System.out.println(qval+"...............");
    QueryValues.add(qval);
    
    if (qval.trim().length() > 0&& !qval.equals("-1")) {
    	
    	String start = qval + " 00:00:00";
    	String end = qval + "23:59:59";
        cdt.add("senddate>='" + start + "'");
        cdt.add("senddate<='" + end + "'");
        
    }
    qval = ParamUtils.getParameter(request, "_Subject_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0&& !qval.equals("-1")) {
        cdt.add("subject like '%" + qval + "%'");
    }
    qval = ParamUtils.getParameter(request, "_MsgGrade_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0&& !qval.equals("-1")) {
        cdt.add("msggrade=" + qval);
    }
    String shoujian= ParamUtils.getParameter(request, "_shoujian_","");
    if(shoujian.equals("1")){
    	cdt.add("receiveids="+user.getCode());
    	
    	qval = ParamUtils.getParameter(request, "_SendId_", "");
        QueryValues.add(qval);
        
        if (qval.trim().length() > 0&& !qval.equals("-1")) {
        	System.out.println("wozaizheli");
            cdt.add("sendid=" + qval);
           
        }
    }
    if(shoujian.equals("2")){
    	cdt.add("sendid="+user.getCode());
    	
    	qval = ParamUtils.getParameter(request, "_receiveids_", "");
        QueryValues.add(qval);
        
        if (qval.trim().length() > 0&& !qval.equals("-1")) {
        	System.out.println("wozaizheli");
            cdt.add("receiveids=" + qval);
          
        }
    }
    if(shoujian.equals("3")){
    	cdt.add("sendid="+user.getCode());
    	cdt.add("smsstyle=2") ;
    	qval = ParamUtils.getParameter(request, "_receiveids_", "");
        QueryValues.add(qval);
        
        if (qval.trim().length() > 0&& !qval.equals("-1")) {
        	System.out.println("wozaizheli");
            cdt.add("receiveids=" + qval);
          
        }
    }
    if(shoujian.equals("")){
    	qval = ParamUtils.getParameter(request, "_receiveids_", "");
        QueryValues.add(qval);
        
        if (qval.trim().length() > 0&& !qval.equals("-1")) {
        	System.out.println("wozaizheli");
            cdt.add("receiveids=" + qval);}
        
        	qval = ParamUtils.getParameter(request, "_SendId_", "");
            QueryValues.add(qval);
            
            if (qval.trim().length() > 0&& !qval.equals("-1")) {
            	System.out.println("wozaizheli");
                cdt.add("sendid=" + qval);
              
            }
    }
    
    qval = ParamUtils.getParameter(request, "_IfSee_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0&& !qval.equals("-1")) {
        cdt.add("ifsee=" + qval);
    }
    qval = ParamUtils.getParameter(request, "_Receipt_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0&& !qval.equals("-1")) {
        cdt.add("receipt=" + qval);
    }
    qval = ParamUtils.getParameter(request, "_CollectDate_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0&& !qval.equals("-1")) {
        cdt.add("collectdate='" + qval + "'");
    }
    qval = ParamUtils.getParameter(request, "_SaveDate_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0&& !qval.equals("-1")) {
       
        String start = qval + " 00:00:00";
    	String end = qval + "23:59:59";
        cdt.add("savedate>='" + start + "'");
        cdt.add("savedate<='" + end + "'");
    }
    qval = ParamUtils.getParameter(request, "_SmsStyle_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0&& !qval.equals("-1")) {
        cdt.add("smsstyle=" + qval);
    }
    qval = ParamUtils.getParameter(request, "_RemUrl_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0&& !qval.equals("-1")) {
        cdt.add("remurl like '%" + qval + "%'");
    }
    qval = ParamUtils.getParameter(request, "_RemindSys_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0&& !qval.equals("-1")) {
        cdt.add("remindsys like '%" + qval + "%'");
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
    request.setAttribute("MsgGradeoptions", CEditConst.getMsgGradeOptions(userInfo, "-1"));
    request.setAttribute("MsgPropoptions", CEditConst.getMsgPropOptions(userInfo, "-1"));
    request.setAttribute("YesNooptions", CEditConst.getYesNoOptions(userInfo, "-1"));
    request.setAttribute("UserNameoptions", CEditConst.getUserNameOptions(userInfo, "-1"));
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
    ShortMessage pv = new ShortMessage();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    //request.setAttribute("fanhui", "");
    String shoujian= ParamUtils.getParameter(request, "shoujian","");
    System.out.println(shoujian+"1111111111111111111111111shoujian");
   //request.setAttribute("shoujian", shoujian);
    if(shoujian.equals("1")){
    	 request.setAttribute("fields", shoujianListFields);
    	 request.setAttribute("describe", "收的消息");
    	 request.setAttribute("fanhui", "ShortMessageAction.jsp?shoujian=1&_SmsStyle=1");
    }
    if(shoujian.equals("2")){
   	 request.setAttribute("fields", fajianListFields);
   	 request.setAttribute("fanhui", "ShortMessageAction.jsp?shoujian=2&_SmsStyle=1");
   }
    if(shoujian.equals("3")){
   	 request.setAttribute("fields", caogaoListFields);
   	 request.setAttribute("fanhui", "ShortMessageAction.jsp?shoujian=3&_SmsStyle=2");
   }
    request.setAttribute("classname", "ShortMessage");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    ShortMessage pv = new ShortMessage();
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
private void setForm(javax.servlet.http.HttpServletRequest request, ShortMessage form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("MsgGradeoptions", CEditConst.getMsgGradeOptions(userInfo, "-1"));
    request.setAttribute("MsgPropoptions", CEditConst.getMsgPropOptions(userInfo, "-1"));
    request.setAttribute("YesNooptions", CEditConst.getYesNoOptions(userInfo, "-1"));
    request.setAttribute("UserNameoptions", CEditConst.getUserNameOptions(userInfo, "-1"));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "ShortMessage");
    request.setAttribute("describe", "站内信");
    String shoujian= ParamUtils.getParameter(request, "shoujian","");

 System.out.println(shoujian+"1111111111111111111111111shoujian");
 request.setAttribute("shoujian", shoujian);
    if(shoujian.equals("1")){
    	 request.setAttribute("fields", shoujianListFields);
    	 request.setAttribute("describe", "收的消息");
    	 request.setAttribute("fanhui", "ShortMessageAction.jsp?shoujian=1&_SmsStyle=1");
    }
    if(shoujian.equals("2")){
   	 request.setAttribute("fields", fajianListFields);
   	 request.setAttribute("fanhui", "ShortMessageAction.jsp?shoujian=2&_SmsStyle=1");
   }
    if(shoujian.equals("3")){
   	 request.setAttribute("fields", caogaoListFields);
   	 request.setAttribute("fanhui", "ShortMessageAction.jsp?shoujian=3&_SmsStyle=2");
   }
}
private List mkRtn(String cmd, String forward, ShortMessage form)
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
    ShortMessage form = getByParameterDb(request);
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
    	System.out.println("jin;laile ma111");
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
    if (cmd.equals("delete1"))
    {
        String idlist = ParamUtils.getParameter(request, "idlist", "-1");
        List cdt = new ArrayList();
        cdt.add("id in (" + idlist + ")");
        form.deleteByCondition(cdt);
        return mkRtn("list", "list1", form);
    }
    if (cmd.equals("save"))
    	
    {   
    	
    	System.out.println("jin;laile ma");
    	System.out.println(form.getReceiveIds()+"aaaaaaaaaaaaa");
    	 String[] arr = Tool.split(",", form.getReceiveIds());
    	System.out.println(arr+"'''''''''''''''''''''''''''");
    	 for(int i=0;i<arr.length;i++){
    		System.out.println(arr[i]+"'''''''''''''''''''''''''''");
    		 form.setReceiveIds(arr[i]);
    		 form.insert();
    	 }
    	
        
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
log.debug("ShortMessageAction");
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
forwardMap.put("list1", "sitemsg-list.jsp");
forwardMap.put("login", "logon.jsp");
forwardMap.put("sendsave", "ShortMessageAction.jsp");
forwardMap.put("list2", "ShortMessageAction.jsp?shoujian=2&_SmsStyle_=1");
forwardMap.put("failure", "ShortMessageForm.jsp");
forwardMap.put("success", "ShortMessageList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "ShortMessageForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
  String  shoujian=ParamUtils.getParameter(request, "shoujian","");
    out.println("<script>window.location='ShortMessageAction.jsp?shoujian=2&_SmsStyle_=1&cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}
%>
