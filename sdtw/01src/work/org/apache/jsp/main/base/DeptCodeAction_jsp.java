/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-03-31 07:36:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main.base;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.sdtw.db.BaseDeptCode;
import com.xietong.software.util.*;
import com.xietong.software.common.*;
import org.apache.commons.logging.*;
import java.io.*;
import java.util.*;
import jxl.*;
import jxl.write.*;

public final class DeptCodeAction_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


private static Log log = LogFactory.getLog(BaseDeptCode.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "OrgId", "Pid", "Name", "Leaders", "Style", "Code", "Orderby", "ReptDept", "Address", "PostCode", "Tel", "Fax", "Email", "Remark", "Enable"};
private String[] DicKeys = {"Id", "OrgId", "Pid", "Name", "Leaders", "Style", "Code", "Orderby", "ReptDept", "Address", "PostCode", "Tel", "Fax", "Email", "Remark", "Enable"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"int", "所属单位", "0", "OrgName", ""}, {"int", "上级部门", "0", "DeptName", ""}, {"string", "部门名称", "200", "text", ""}, {"string", "部门领导", "100", "text", ""}, {"string", "部门类型", "1", "text", ""}, {"string", "部门编码", "50", "text", ""}, {"int", "排序", "0", "text", ""}, {"string", "上级主管部门", "50", "hidden", ""}, {"string", "部门地址", "200", "hidden", ""}, {"string", "邮政编码", "50", "hidden", ""}, {"string", "部门电话", "50", "text", ""}, {"string", "传真号码", "50", "hidden", ""}, {"string", "部门邮箱", "50", "text", ""}, {"string", "备注", "255", "hidden", ""}, {"int", "Enable", "0", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "OrgId", "Pid", "Name", "Leaders", "Style", "Code", "Orderby", "ReptDept", "Address", "PostCode", "Tel", "Fax", "Email", "Remark", "Enable"};
private String[] ListFields = {"OrgId", "Pid", "Name",  "Code", "Orderby"};
private String[] FormFields = {"OrgId", "Pid", "Name", "Leaders", "Style", "Code", "Orderby", "ReptDept", "Address", "PostCode", "Tel", "Fax", "Email", "Remaik"};
private String[] QueryFields = {"OrgId", "Pid", "Name", "Code", "Tel", "Email"};
private String[] HideFields = {"Id"};
private BaseDeptCode getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    BaseDeptCode v = new BaseDeptCode();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramOrgId(request, "OrgId");
        v.paramPid(request, "Pid");
        v.paramName(request, "Name");
        v.paramLeaders(request, "Leaders");
        v.paramStyle(request, "Style");
        v.paramCode(request, "Code");
        v.paramOrderby(request, "Orderby");
        v.paramReptDept(request, "ReptDept");
        v.paramAddress(request, "Address");
        v.paramPostCode(request, "PostCode");
        v.paramTel(request, "Tel");
        v.paramFax(request, "Fax");
        v.paramEmail(request, "Email");
        v.paramRemark(request, "Remark");
        v.paramEnable(request, "Enable");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setOrgId(ParamUtils.getIntParameter(request, "OrgId", -1));
        v.setPid(ParamUtils.getIntParameter(request, "Pid", -1));
        v.setName(ParamUtils.getParameter(request, "Name", ""));
        v.setLeaders(ParamUtils.getParameter(request, "Leaders", ""));
        v.setStyle(ParamUtils.getParameter(request, "Style", ""));
        v.setCode(ParamUtils.getParameter(request, "Code", "Dept"+v.getNextSn()));
        v.setOrderby(ParamUtils.getIntParameter(request, "Orderby", -1));
        v.setReptDept(ParamUtils.getParameter(request, "ReptDept", ""));
        v.setAddress(ParamUtils.getParameter(request, "Address", ""));
        v.setPostCode(ParamUtils.getParameter(request, "PostCode", ""));
        v.setTel(ParamUtils.getParameter(request, "Tel", ""));
        v.setFax(ParamUtils.getParameter(request, "Fax", ""));
        v.setEmail(ParamUtils.getParameter(request, "Email", ""));
        v.setRemark(ParamUtils.getParameter(request, "Remark", ""));
        v.setEnable(ParamUtils.getIntParameter(request, "Enable", 1));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, BaseDeptCode pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    Map OrgNamemap = CEditConst.getOrgNameMap(userInfo);
    Map DeptNamemap = CEditConst.getDeptNameMap(userInfo);
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    for (Iterator it = vs.iterator(); it.hasNext();) {
    	BaseDeptCode v = (BaseDeptCode)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add((String)OrgNamemap.get("" + v.getOrgId()));
        row.add((String)DeptNamemap.get("" + v.getPid()));
        row.add(Tool.jsSpecialChars(v.getName()));
        row.add(Tool.jsSpecialChars(v.getLeaders()));
        row.add(Tool.jsSpecialChars(v.getStyle()));
        row.add(Tool.jsSpecialChars(v.getCode()));
        row.add("" + v.getOrderby());
        row.add(Tool.jsSpecialChars(v.getReptDept()));
        row.add(Tool.jsSpecialChars(v.getAddress()));
        row.add(Tool.jsSpecialChars(v.getPostCode()));
        row.add(Tool.jsSpecialChars(v.getTel()));
        row.add(Tool.jsSpecialChars(v.getFax()));
        row.add(Tool.jsSpecialChars(v.getEmail()));
        row.add(Tool.jsSpecialChars(v.getRemark()));
        row.add("" + v.getEnable());
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, BaseDeptCode pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, BaseDeptCode pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "asc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    qval = ParamUtils.getParameter(request, "_OrgId_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0 && !qval.equals("-1")) {
        cdt.add("orgid=" + qval);
    }
    qval = ParamUtils.getParameter(request, "_Pid_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0 && !qval.equals("-1")) {
        cdt.add("pid=" + qval);
    }
    qval = ParamUtils.getParameter(request, "_Name_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("name like '%" + qval + "%'");
    }
    qval = ParamUtils.getParameter(request, "_Code_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("code like '%" + qval + "%'");
    }
    qval = ParamUtils.getParameter(request, "_Tel_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("tel like '%" + qval + "%'");
    }
    qval = ParamUtils.getParameter(request, "_Email_", "");
    QueryValues.add(qval);
    if (qval.trim().length() > 0) {
        cdt.add("email like '%" + qval + "%'");
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
    request.setAttribute("OrgNameoptions", CEditConst.getOrgNameOptions(userInfo, "-1"));
    request.setAttribute("DeptNameoptions", CEditConst.getDeptNameOptions(userInfo, "-1"));
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
    BaseDeptCode pv = new BaseDeptCode();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "DeptCode");
    request.setAttribute("describe", "部门");
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    BaseDeptCode pv = new BaseDeptCode();
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
private void setForm(javax.servlet.http.HttpServletRequest request, BaseDeptCode form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    List cdt = new ArrayList();
    cdt.add("pid=-1");
    cdt.add("id<>"+form.getId());
    request.setAttribute("YesNooptions", CEditConst.getYesNoOptions(userInfo, "-1"));
    request.setAttribute("OrgNameoptions", CEditConst.getOrgNameOptions(userInfo, "-1"));
    request.setAttribute("DeptNameoptions", COptionConst.getDeptNameOptions(userInfo,"-1",cdt));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "DeptCode");
    request.setAttribute("describe", "部门");
}
/*
 * 校验提交保存数据的重复性问题
 * 如果有重复数据，返回true, 否则返回false
 */
private boolean isDuplicated(BaseDeptCode form, String cmd)
{
    List cdt = new ArrayList();
    cdt.add("code='" + form.getCode() + "'");
    if(cmd.equals("update")) {
        cdt.add("id<>" + form.getId());
    }
    return (form.getCount(cdt) > 0);
}
private List mkRtn(String cmd, String forward, BaseDeptCode form)
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
    BaseDeptCode form = getByParameterDb(request);
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
        return mkRtn("tree", "tree", form);
    }
    if (cmd.equals("clone"))
    {
        form = form.getById(form.getId());
        setForm(request, form);
        return mkRtn("save", "input", form);
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
        if (isDuplicated(form, cmd)) {
            request.setAttribute("msg", "部门编码重复!");
            setForm(request, form);
            return mkRtn("save", "input", form);
        }
        else {
            form.insert();
            return mkRtn("list", "success", form);
        }
    }
    if (cmd.equals("update"))
    {
        if (isDuplicated(form, cmd)) {
            request.setAttribute("msg", "部门编码重复!");
            setForm(request, form);
            return mkRtn("update", "input", form);
        }
        else {
            form.update();
            setList(request);
            return mkRtn("list", "success", form);
        }
    }
    if (cmd.equals("tree"))
    {
        return mkRtn("tree", "tree", null);
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
      out.write('\r');
      out.write('\n');

response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
log.debug("DeptCodeAction");
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
forwardMap.put("list", "DeptCodeAction.jsp");
forwardMap.put("failure", "DeptCodeForm.jsp");
forwardMap.put("success", "DeptCodeList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "DeptCodeForm.jsp");
forwardMap.put("tree", "DeptCodeTree.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='DeptCodeAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
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
