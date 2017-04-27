/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-19 01:57:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main.club;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.sdtw.club.ClubUtil;
import com.xietong.software.base.Power;
import com.xietong.software.sdtw.*;
import com.xietong.software.sdtw.db.*;
import com.xietong.software.util.*;
import com.xietong.software.common.*;
import org.apache.commons.logging.*;
import java.io.*;
import java.util.*;
import jxl.*;
import jxl.write.*;
import java.math.BigDecimal;

public final class ClubModifyTeacherAction_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


private static Log log = LogFactory.getLog(ClubModifyTeacher.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "ClubId", "ClubName", "ClubType", "ClubAcademy", "ClubAcadeMyNew", "CommentXy", "CheckFlag", "ApplyDate", "AddPerson", "AddTime", "ModiPerson", "ModiTime"};
private String[] DicKeys = {"Id", "ClubId", "ClubName", "ClubType", "ClubAcademy", "ClubAcadeMyNew", "CommentXy", "CheckFlag", "ApplyDate", "AddPerson", "AddTime", "ModiPerson", "ModiTime"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"string", "登录账号", "45", "hidden", ""}, {"string", "社团名称", "45", "hidden", ""}, {"string", "社团类别", "45", "ClubTypeName", ""}, {"string", "原指导教师", "45", "AcademyName", ""}, {"string", "新指导教师", "45", "AcademyName", ""}, {"string", "原指导单位意见", "500", "hidden", ""}, {"string", "审核状态", "45", "hidden", ""}, {"date", "申请时间", "0", "hidden", ""}, {"string", "申请人", "50", "hidden", ""}, {"date", "添加时间", "0", "hidden", ""}, {"string", "修改人", "50", "hidden", ""}, {"date", "修改时间", "0", "text", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "ClubId", "ClubName", "ClubType", "ClubAcademy", "ClubAcadeMyNew", "CommentXy", "CheckFlag", "ApplyDate", "AddPerson", "AddTime", "ModiPerson", "ModiTime"};
private String[] ListFields = {"ClubName","ClubId","ClubType", "ClubAcademy", "ClubAcadeMyNew", "CheckFlag"};
private String[] FormFields = {"ClubName", "ClubType", "ClubAcademy", "ClubAcadeMyNew", "CommentXy", "AddPerson", "ModiPerson", "ModiTime"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private ClubModifyTeacher getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    ClubModifyTeacher v = new ClubModifyTeacher();
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
private List getListRows(javax.servlet.http.HttpServletRequest request, ClubModifyTeacher pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map AcademyNamemap = CEditConst.getAcademyNameMap(userInfo);
    Map ClubTypeNamemap = CEditConst.getClubTypeNameMap(userInfo);
    //Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);
    Map ClubNameMap = CEditConst.getClubNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    Set idsList = new HashSet();
    for (Iterator it = vs.iterator(); it.hasNext();) {
        ClubModifyTeacher v = (ClubModifyTeacher)it.next();
        idsList.add(v.getClubAcademy());
        idsList.add(v.getClubAcadeMyNew());
    }
    List l = new ArrayList(idsList);
    ClubTeacher t = new ClubTeacher();
    List cdt1 = new ArrayList();
    cdt1.add("id in("+Tool.join(",",l)+")");
  	Map clubteacherMap = XtUtil.getBeanMapByCdt(cdt1,ClubTeacher.class);
    for (Iterator it = vs.iterator(); it.hasNext();) {
        ClubModifyTeacher v = (ClubModifyTeacher)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add(Tool.jsSpecialChars(v.getClubId()));
        row.add((String)ClubNameMap.get(v.getClubName()));
        row.add((String)ClubTypeNamemap.get("" + v.getClubType()));
     	
        ClubTeacher ct = new ClubTeacher();
        ct = (ClubTeacher)clubteacherMap.get(v.getClubAcademy());
        row.add(ct.getTeaName());
        ct = (ClubTeacher)clubteacherMap.get(v.getClubAcadeMyNew());
        row.add(ct.getTeaName());
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
        }else {
        	flag = "";
        }
        //row.add(Tool.jsSpecialChars(v.getCheckFlag()));
        row.add(flag);
        row.add(Tool.stringOfDate(v.getApplyDate()));
        row.add(Tool.jsSpecialChars(v.getAddPerson()));
        row.add(Tool.stringOfDate(v.getAddTime()));
        row.add(Tool.jsSpecialChars(v.getModiPerson()));
        row.add(Tool.stringOfDate(v.getModiTime()));
        rows.add(row);
    }
    clubteacherMap.clear();
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, ClubModifyTeacher pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, ClubModifyTeacher pv, boolean isAll)
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
   		//cdt.add("ClubId in( select name from base_usercode where DeptId="+userInfo.getUserCode().getDeptId()+")");
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
    ClubModifyTeacher pv = new ClubModifyTeacher();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "ClubModifyTeacher");
    request.setAttribute("describe", "社团变更指导教师");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    ClubModifyTeacher pv = new ClubModifyTeacher();
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
private void setForm(javax.servlet.http.HttpServletRequest request, ClubModifyTeacher form)
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
    request.setAttribute("classname", "ClubModifyTeacher");
    request.setAttribute("describe", "社团变更指导教师");
}
private List mkRtn(String cmd, String forward, ClubModifyTeacher form)
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
    ClubModifyTeacher form = getByParameterDb(request);
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
    	ClubUtil util = new ClubUtil();
    	ClubTeacher c = new ClubTeacher();
    	c = util.saveNewTeacher(request);
    	String checkFlag = ParamUtils.getParameter(request,"CheckFlag","");
    	if("0".equals(checkFlag)){
    		form.setApplyDate(new Date());
    	}
    	form.setClubAcadeMyNew(c.getId()+"");
    	form.setAddTime(new Date());
    	form.setAddPerson(userInfo.getId()+"");
        form.insert();
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("update"))
    {
    	form.update();
    	String checkFlag = ParamUtils.getParameter(request,"CheckFlag","");
    	int ClubAcademy = ParamUtils.getIntParameter(request,"ClubAcademy",-1);//原指导教师Id
		int ClubAcadeMyNew = ParamUtils.getIntParameter(request,"ClubAcadeMyNew",-1);//新指导教师Id
		if (userInfo.hasFunPower(Power.UserAdminPower)) {//学院审核
			if ("1".equals(checkFlag)) {
				ClubTeacher c = new ClubTeacher();
				c = c.getById(ClubAcademy);
				c.setCheckFlag(0);
				c.setStopDate(new Date());
				c.update();
				c= c.getById(ClubAcadeMyNew);
				c.setCheckFlag(1);
				c.setStartDate(new Date());
				c.update();
			}
		}
        return mkRtn("list", "list", form);
    }
    request.setAttribute("msg", "未规定的cmd:" + cmd);
    return mkRtn("list", "failure", form);
}

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
log.debug("ClubModifyTeacherAction");
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
forwardMap.put("list", "ClubModifyTeacherAction.jsp");
forwardMap.put("failure", "ClubModifyTeacherForm.jsp");
forwardMap.put("success", "ClubModifyTeacherList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "ClubModifyTeacherForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='ClubModifyTeacherAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}

      out.write('\r');
      out.write('\n');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}