// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   HtmlTool.java

package com.xietong.software.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.xietong.software.util.OptionBean;
import com.xietong.software.util.Tool;

// Referenced classes of package com.xietong.software.common:
//            HeadConst

public class HtmlTool
{

    private HtmlTool() {
    }

    public static String getIframeContent(HttpServletRequest request, String content) {
        StringBuffer rtn = new StringBuffer();
        rtn.append("<html><head><META HTTP-EQUIV='Content-Type' CONTENT='text/html; charset=utf-8'>");
        rtn.append("<link rel='STYLESHEET' type='text/css' href='" + HeadConst.apache_url + "/images/" + Tool.getUserInfo(request).getSkinId() + "/web_oa.css'>");
        rtn.append("</head><body>" + content.replaceAll("\"", "'") + "</body></html>");
        return rtn.toString();
    }

    public static String msgBox(HttpServletRequest request, String back_info)
    {
        return msgBox(request, back_info, "-1", "");
    }

    public static String msgBox(HttpServletRequest request, String back_info, String back_url, String next_url)
    {
    	StringBuffer str = new StringBuffer();
    	UserInfo userInfo = Tool.getUserInfo(request);
    	String skin = userInfo == null ? HeadConst.SkinId : userInfo.getSkinId();
    	str.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
        str.append("<link rel='STYLESHEET' type='text/css' href='" + HeadConst.apache_url + "/main/images/skin/" + skin + "/css.css'>");
    	str.append("<div class=\"window_msg\">\n");
    	str.append("	<div class=\"windownei\">\n");
    	str.append("		<div class=\"window001\">提示信息</div>\n");
    	str.append("			 <div class=\"window002\">" + back_info + "</div>\n");
    	str.append("			 <div class=\"window003\">");
    	str.append("			<table width=\"80%\" border=\"0\" align=\"center\">\n");
    	str.append("				<tr>\n");
    	if(back_url.equals("-1"))
    		str.append("				<td align=\"center\"><div class=\"anniu8035\"><a href=\"javascript:history.go(-1)\">返回</a></div></td>\n");
    	else if(back_url.equals("-2"))
    		str.append("				<td align=\"center\"><div class=\"anniu8035\"><a href=\"javascript:window.close()\">关闭</a></div></td>\n");
    	else{
    		str.append("				<td align=\"center\"><div class=\"anniu8035\"><a href=\"" + back_url + "\">返回</a></div></td>\n");
    	}
    	if(next_url.length() > 0)
    		str.append("				<td align=\"center\"><div class=\"anniu8035\"><a href=\"" + next_url + "\">继续</a></div></td>\n");
    	str.append("			</div>\n");
    	return str.toString();
    }

    public static String renderJsMap(Map map)
    {
        List rtn = new ArrayList();
        for(Iterator it = map.keySet().iterator(); it.hasNext(); ) {
            String key = (String)it.next();
            rtn.add("\"" + key + "\":\"" + (String)map.get(key) + "\"");
        }
        return "{" + Tool.join(",", rtn) + "}";
    }

    public static String renderJsMap(List list)
    {
        List rtn = new ArrayList();
        for (Iterator it = list.iterator(); it.hasNext();) {
            OptionBean ob = (OptionBean)it.next();
            rtn.add("\"" + ob.getValue() + "\":\"" + ob.getLabel() + "\"");
        }
        return "{" + Tool.join(",", rtn) + "}";
    }

    public static String renderJsArray(Map map)
    {
        List rtn = new ArrayList();
        for(Iterator it = map.keySet().iterator(); it.hasNext(); ) {
            String key = (String)it.next();
            rtn.add("[\"" + key + "\",\"" + (String)map.get(key) + "\"]");
        }
        return "[" + Tool.join(",", rtn) + "]";
    }

    public static String renderJsArray(List list)
    {
        List rtn = new ArrayList();
        for (Iterator it = list.iterator(); it.hasNext();) {
            OptionBean ob = (OptionBean)it.next();
            rtn.add("[\"" + ob.getValue() + "\",\"" + ob.getLabel() + "\"]");
        }
        return "[" + Tool.join(",", rtn) + "]";
    }

	public static String renderJsArray(Set list)
    {
        List rtn = new ArrayList();
        for (Iterator it = list.iterator(); it.hasNext();) {
            OptionBean ob = (OptionBean)it.next();
            rtn.add("[\"" + ob.getValue() + "\",\"" + ob.getLabel() + "\"]");
        }
        return "[" + Tool.join(",", rtn) + "]";
    }

    public static String toJsArray(String[] arr)
    {
        if (arr.length == 0) {
            return "[]";
        } else {
            return "[\"" + Tool.join("\",\"", arr) + "\"]";
        }
    }

    public static String renderJsMapArray(Map map)
    {
        List rtn = new ArrayList();
        for(Iterator it = map.keySet().iterator(); it.hasNext(); ) {
            String key = (String)it.next();
            rtn.add("\"" + key + "\":" + renderJsArray((List)map.get(key)) + "");
        }
        return "{" + Tool.join(",", rtn) + "}";
    }

    public static String renderJsMapMap(Map map)
    {
        List rtn = new ArrayList();
        for(Iterator it = map.keySet().iterator(); it.hasNext(); ) {
            String key = (String)it.next();
            rtn.add("\"" + key + "\":" + renderJsMap((List)map.get(key)) + "");
        }
        return "{" + Tool.join(",", rtn) + "}";
    }

    public static String renderRadio(Map map, String currkey, String name, String defaultkey)
    {
        StringBuffer rtn = new StringBuffer();
        if(currkey == null || currkey.equals(""))
            currkey = defaultkey;
        String key;
        for(Iterator it = map.keySet().iterator(); it.hasNext(); rtn.append(">" + (String)map.get(key) + "&nbsp;\n"))
        {
            key = (String)it.next();
            rtn.append("<input type=\"radio\" name=\"" + name + "\" value=\"" + key + "\"");
            if(currkey.equalsIgnoreCase(key))
                rtn.append(" checked");
        }

        return rtn.toString();
    }

    public static String renderRadio(List list, String currkey, String name, String defaultkey)
    {
        StringBuffer rtn = new StringBuffer();
        if(currkey == null || currkey.equals(""))
            currkey = defaultkey;
        OptionBean ob;
        for(Iterator it = list.iterator(); it.hasNext(); rtn.append(">" + ob.getLabel() + "&nbsp;\n"))
        {
            ob = (OptionBean)it.next();
            rtn.append("<input type=\"radio\" name=\"" + name + "\" value=\"" + ob.getValue() + "\"");
            if(currkey.equalsIgnoreCase(ob.getValue()))
                rtn.append(" checked");
        }

        return rtn.toString();
    }

    public static String renderSelect(Map map, String currkey, String name, String defaultkey)
    {
        return renderSelect(map, currkey, name, defaultkey, false);
    }

    public static String renderSelect(Map map, String currkey, String name, String defaultkey, boolean readonly)
    {
        StringBuffer rtn = new StringBuffer();
        if(currkey == null || currkey.equals(""))
            currkey = defaultkey;
        rtn.append("<select name=" + name);
        if (readonly) {
            rtn.append(" readonly");
        }
        rtn.append(">\n");
        String key;
        for(Iterator it = map.keySet().iterator(); it.hasNext(); rtn.append(">" + (String)map.get(key) + "</option>\n"))
        {
            key = (String)it.next();
            rtn.append("<option class=p1 value=\"" + key + "\"");
            if(currkey.equalsIgnoreCase(key))
                rtn.append(" selected");
        }

        rtn.append("</select>&nbsp;\n");
        return rtn.toString();
    }

    public static String renderSelect(List list, String currkey, String name, String defaultkey)
    {
        return renderSelect(list, currkey, name, defaultkey, false);
    }

    public static String renderSelect(List list, String currkey, String name, String defaultkey, boolean readonly)
    {
        StringBuffer rtn = new StringBuffer();
        if (!readonly) {
            rtn.append("<select name=" + name + " id="+name+">\n");
        } else {
            rtn.append("<input type='hidden' name='" + name + "' id='" + name + "'" );
        }
        rtn.append(renderSelectOption(list, currkey, defaultkey, readonly));
        if (!readonly) {
            rtn.append("</select>&nbsp;\n");
        }
        return rtn.toString();
    }
    
    public static String renderSelect(List list, String currkey, String name, String defaultkey, boolean readonly,String function)
    {
        StringBuffer rtn = new StringBuffer();
        if (!readonly) {
            rtn.append("<select name=" + name + " id="+name+"");
            if (!function.equals("")) {
            	rtn.append(" "+function);
            }
            rtn.append(">\n");
        } else {
            rtn.append("<input type='hidden' name='" + name + "' id='" + name + "'" );
        }
        rtn.append(renderSelectOption(list, currkey, defaultkey, readonly));
        if (!readonly) {
            rtn.append("</select>&nbsp;\n");
        }
        return rtn.toString();
    }
    
    public static String renderSelect(List list, String currkey, String name, String defaultkey,  String function)
    {
        StringBuffer rtn = new StringBuffer();
        
        rtn.append("<select name=" + name + " id="+name);
        if (!function.equals("")) {
        	rtn.append(" "+function);
        }
        rtn.append(">\n");
        rtn.append(renderSelectOption(list, currkey, defaultkey));
        
        rtn.append("</select>&nbsp;\n");
        return rtn.toString();
    }
        
    public static String renderSelectOption(List list, String currkey, String defaultkey)
    {
        return renderSelectOption(list, currkey, defaultkey, false);
    }
    public static String renderSelectOption(List list, String currkey, String defaultkey, boolean readonly){
    	return renderSelectOption(list, currkey, defaultkey, readonly, false);
    }
    public static String renderSelectOption(List list, String currkey, String defaultkey, boolean readonly,boolean nottobr)
    {
        //tobr 换行
    	StringBuffer rtn = new StringBuffer();
        if(currkey == null || currkey.equals("") || currkey.equals("-1"))
            currkey = defaultkey;
        boolean isFound = false;
        if (readonly) {
            for(Iterator it = list.iterator(); it.hasNext(); ) {
                OptionBean ob = (OptionBean)it.next();
                if(currkey.equalsIgnoreCase(ob.getValue())) {
                	rtn.append(" value='" + ob.getValue() + "'>" + ob.getLabel() + ((nottobr) ? "" : "\n"));
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                rtn.append(" value='" + currkey + "'>" + ((nottobr) ? "" : "\n"));
            }
        } else {
            for(Iterator it = list.iterator(); it.hasNext(); ) {
                OptionBean ob = (OptionBean)it.next();
                rtn.append("<option class=p1 value=" + ((nottobr) ? "'" : "\"") + ob.getValue() + ((nottobr) ? "'" : "\"") );
                if(currkey.equalsIgnoreCase(ob.getValue()))
                    rtn.append(" selected");
                rtn.append(">" + ob.getLabel() + "</option>" + ((nottobr) ? "" : "\n"));
            }
        }

        return rtn.toString();
    }
    public static String renderMulSelect(List list, String currkey, String name, String defaultkey,  String function)
    {
        StringBuffer rtn = new StringBuffer();
        
        rtn.append("<select  multiple='multiple' name=" + name + " id="+name);
        if (!function.equals("")) {
        	rtn.append(" "+function);
        }
        rtn.append(">\n");
        rtn.append(renderMulSelectOption(list, currkey, defaultkey));
        
        rtn.append("</select>&nbsp;\n");
        return rtn.toString();
    }
    
    public static String renderMulSelectOption(List list, String currkey, String defaultkey)
    {
        return renderMulSelectOption(list, currkey, defaultkey, false);
    }
    public static String renderMulSelectOption(List list, String currkey, String defaultkey, boolean readonly){
    	return renderMulSelectOption(list, currkey, defaultkey, readonly, false);
    }
    
    public static String renderMulSelectOption(List list, String currkey, String defaultkey, boolean readonly,boolean nottobr)
    {
        //tobr 换行
    	StringBuffer rtn = new StringBuffer();
        if(currkey == null || currkey.equals(""))
            currkey = defaultkey;
        boolean isFound = false;
        if (readonly) {
            for(Iterator it = list.iterator(); it.hasNext(); ) {
                OptionBean ob = (OptionBean)it.next();
                if(currkey.equalsIgnoreCase(ob.getValue())) {
                	rtn.append(" value='" + ob.getValue() + "'>" +"<input readonly class='readonly_input' value="+ ob.getLabel()+">" + ((nottobr) ? "" : "\n"));
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                rtn.append(" value='" + currkey + "'>" + ((nottobr) ? "" : "\n"));
            }
        } else {
        	currkey = "," + currkey + ",";
            for(Iterator it = list.iterator(); it.hasNext(); ) {
                OptionBean ob = (OptionBean)it.next();
                rtn.append("<option class=p1 value=" + ((nottobr) ? "'" : "\"") + ob.getValue() + ((nottobr) ? "'" : "\"") );
                if(currkey.indexOf("," + ob.getValue() + ",") > -1)
                    rtn.append(" selected");
                rtn.append(">" + ob.getLabel() + "</option>" + ((nottobr) ? "" : "\n"));
            }
        }

        return rtn.toString();
    }
    public static String renderCheckBox(List list, String currkey, String name, String defaultkey,String function)
    {
        StringBuffer rtn = new StringBuffer();
        if(currkey == null || currkey.equals(""))
            currkey = defaultkey;
        OptionBean ob;
        String func = "";
        if (!function.equals("")) {
func = "onclick=\""+function+";\"";
}
        for(Iterator it = list.iterator(); it.hasNext(); rtn.append(">" + ob.getLabel() + "&nbsp;\n"))
        {
            ob = (OptionBean)it.next();
            
            rtn.append("<input type=\"checkbox\" name=\"" + name + "\" "+func+" value=\"" + ob.getValue() + "\"");
            if((","+currkey+",").indexOf(ob.getValue())>=0)
                rtn.append(" checked");
        }

        return rtn.toString();
    }
    
    public static String renderCheckBox(List list, String currkey, String name, String defaultkey)
    {
        return renderCheckBox(list, currkey, name, defaultkey,"");
    }
    public static String msgJasrp(String s1, String s2)
    {
        StringBuffer str = new StringBuffer();
        str.append("\r\n sug2='" + s1 + "';");
        str.append("\r\n if(typeof(web_oa.document.all['" + s2 + "'])!='undefined')");
        str.append("\r\n    web_oa.document.all['" + s2 + "'].innerHTML=sug2;");
        str.append("\r\n else if(typeof(web_oa.document.all['other_sugs'])!='undefined')");
        str.append("\r\n     {");
        str.append("\r\n if(sug2!='')");
        str.append("\r\nweb_oa.document.all['other_sugs'].innerHTML=web_oa.document.all['other_sugs'].innerHTML+\"<br>\"+sug2;");
        str.append("\r\n     }");
        return str.toString();
    }

    public static String getJsOptions(HttpServletRequest request)
    {
        Map options = HttpTool.getOptions(request);
        List rtn = new ArrayList();
        for (Iterator it = options.keySet().iterator(); it.hasNext();) {
            String key = (String)it.next();
            List items = (List)options.get(key);
            List list = new ArrayList();
            for (Iterator it1 = items.iterator(); it1.hasNext();) {
                OptionBean item = (OptionBean)it1.next();
                list.add("[\"" + item.getLabel() + "\",\"" + item.getValue() + "\"]");
            }
            rtn.add("\"" + key + "\":[" + Tool.join(",", list) + "]");
        }
        return Tool.join(",", rtn);
    }

    public static String getTreeView(TreeItem ti, String treeName, String parent, String jsfunc, int level, boolean isShowLeaf) {
        StringBuffer rtn = new StringBuffer();
        String currlvl = "lvl" + level;
        if (!ti.isLeaf()||isShowLeaf) {
            rtn.append(parent + ".add(" + currlvl + " = new WebFXTreeItem('" + ti.getName() + "', \"javascript:" + jsfunc + "(" + treeName + ".getSelected());\", \"" + ti.toXtreeData() + "\", 0));\n");
        }
        Collection sublist = ti.values();
        Iterator it = sublist.iterator();
        while (it.hasNext()) {
            TreeItem pt = (TreeItem)(it.next());
            rtn.append(getTreeView(pt, treeName, currlvl, jsfunc, level * 10, isShowLeaf));
        }
        return rtn.toString();
    }
    /**
     * add new for menu index
     * @param ti
     * @param treeName
     * @param parent
     * @param jsfunc
     * @param level
     * @param isShowLeaf
     * @return
     */
    public static String getTreeMenu(TreeItem ti, String treeName, String parent, String jsfunc, int level, boolean isShowLeaf) {
        StringBuffer rtn = new StringBuffer();
        String currlvl = "lvl" + level;
        if (ti.isLeaf()) {
            rtn.append(parent + ".add(" + currlvl + " = new WebFXTreeItem(\"" + ti.getName() + "\", \"javascript:" + jsfunc + "('" + ti.getUrl() +"')\"));");
        }else{
        	rtn.append(parent + ".add(" + currlvl + " = new WebFXTreeItem(\"" + ti.getName() + "\", \"\"));");
        }
        Collection sublist = ti.values();
        Iterator it = sublist.iterator();
        while (it.hasNext()) {
            TreeItem pt = (TreeItem)(it.next());
            rtn.append(getTreeMenu(pt, treeName, currlvl, jsfunc, level * 10, isShowLeaf));
        }
        return rtn.toString();
    }
    public static String getTreeView(TreeItem ti, String treeName, String url, String jsfunc) {
            return getTreeView(ti, treeName, url, jsfunc, null, 0, "");
    }
    public static String getTreeView(TreeItem ti, String treeName, String url, String jsfunc, String icon) {
            return getTreeView(ti, treeName, url, jsfunc, icon, 0, "");
    }
    public static String getTreeView(TreeItem ti, String treeName, String url, String jsfunc, String icon, int type, String checkedids) {
        StringBuffer rtn = new StringBuffer();
        rtn.append("<tree " + ti.toXLoadTreeAttribute(url, treeName, jsfunc));
        if (type == 1) {
            rtn.append(" type=\"1\" checked=\"" + ((checkedids.indexOf("," + ti.getId() + ",") == -1)? "0": "1") + "\"");
        }
        if (icon != null) {
            rtn.append(" icon=\"" + icon + "\"");
        }
        rtn.append(">\n");
        Collection sublist = ti.values();
        Iterator it = sublist.iterator();
        while (it.hasNext()) {
            TreeItem pt = (TreeItem)(it.next());
            rtn.append(getTreeView(pt, treeName, url, jsfunc, icon, type, checkedids));
        }
        rtn.append("</tree>\n");
        return rtn.toString();
    }
    
    public static String getTreeView(TreeItem ti, String treeName, String url, String jsfunc, String icon, int type, String checkedids,int cocur) {
        StringBuffer rtn = new StringBuffer();
        rtn.append("<tree " + ti.toXLoadTreeAttribute(url, treeName, jsfunc,cocur));
        if (type == 1) {
            rtn.append(" type=\"1\" checked=\"" + ((checkedids.indexOf("," + ti.getId() + ",") == -1)? "0": "1") + "\"");
        }
        if (icon != null) {
            rtn.append(" icon=\"" + icon + "\"");
        }
        rtn.append(">\n");
        Collection sublist = ti.values();
        Iterator it = sublist.iterator();
        while (it.hasNext()) {
            TreeItem pt = (TreeItem)(it.next());
            rtn.append(getTreeView(pt, treeName, url, jsfunc, icon, type, checkedids));
        }
        rtn.append("</tree>\n");
        return rtn.toString();
    }
    public static String getCheckBoxTree(TreeItem ti, String treeName, String parent, int level) {
        return getCheckBoxTree(ti, treeName, parent, level, "");
    }

    public static String getCheckBoxTree(TreeItem ti, String treeName, String parent, int level, String checkedIds) {
        StringBuffer rtn = new StringBuffer();
        if (StrTool.inList(checkedIds, "" + ti.getId(), ",")) {
            ti.setChecked(1);
        } else {
            ti.setChecked(0);
        }
        String currlvl = "lvl" + level;
        rtn.append(parent + ".add(" + currlvl + " = new WebFXTreeItem('" + ti.getName() + "', \"javascript:void(0);\", \"" + ti.toXtreeData() + "\", 1, " + ti.getChecked() + "));\n");
        Collection sublist = ti.values();
        Iterator it = sublist.iterator();
        while (it.hasNext()) {
            TreeItem pt = (TreeItem)(it.next());
            rtn.append(getCheckBoxTree(pt, treeName, currlvl, level + 1, checkedIds));
        }
        return rtn.toString();
    }
    
    public static String renderInput(String name, int size, String value, String describle, String classid,String onlyread){
    	return renderInput(name, size, value, describle, classid, onlyread, true);
    }
    public static String renderInput(String name,int size, String value, String describle, String classid, String onlyread, boolean showinput){
    	//<input name="Name" size="28" value="<%=v.getName()%>"><%=redStr %>
    	String inputStr = "<input type='hidden' name=\"" + name + "\" id=\""+ name + "\" size=\"" + size + "\"" + " value=\""+value+"\">" + value;
    	String classStr = "";
    	if(!classid.equals("")) classStr = " class=\"" + classid +"\"";
    	if (showinput)
    		inputStr = "<input name=\"" + name + "\" id=\""+ name + "\" size=\"" + size + "\"" + " value=\"" + value + "\""+ classStr + " " + onlyread + ">" + describle; 
    	if (inputStr.length()==0) inputStr = "&nbsp;";
    	return inputStr;
    }
    
    public static String renderInput(String name,int size, String value, String describle, String classid, String onlyread, boolean showinput,String func){
    	//<input name="Name" size="28" value="<%=v.getName()%>"><%=redStr %>
    	String inputStr = "<input type='hidden' name=\"" + name + "\" id=\""+ name + "\" size=\"" + size + "\"" + " value=\""+value+"\">" + value;
    	String classStr = "";
    	if(!classid.equals("")) classStr = " class=\"" + classid +"\"";
    	if (showinput)
    		inputStr = "<input name=\"" + name + "\" id=\""+ name + "\" size=\"" + size + "\"" + " value=\"" + value + "\""+ classStr + " " + onlyread + " " + func + ">" + describle; 
    	if (inputStr.length()==0) inputStr = "&nbsp;";
    	return inputStr;
    }
    
    public static String renderInput(String name,int size, String value, String describle, String classid, String onlyread,String function, boolean showinput){
    	String inputStr = "<input type='hidden' name=\"" + name + "\" id=\""+ name + "\" size=\"" + size + "\"" + " value=\""+value+"\">" + value;
    	String classStr = "";
    	if(!classid.equals("")) classStr = " class=\"" + classid +"\"";
    	if (showinput)
    		inputStr = "<input name=\"" + name + "\" id=\""+ name + "\" size=\"" + size + "\"" + " value=\"" + value + "\""+ classStr + " " + onlyread + " "+function+">" + describle; 
    	if (inputStr.length()==0) inputStr = "&nbsp;";
    	return inputStr;
    }
    
    public static String renderTextarea(String name,int cols, int rows, String value, String describle, String classid, String onlyread, boolean showinput){
    	String inputStr = value;
    	if(!classid.equals("")) classid = "class=\"" + classid +"\"";
    	if (showinput)
    		inputStr = "<textarea name=\"" + name + "\"" + " cols=\"" + cols + "\" rows=\"" + rows + "\""+ classid +" " + onlyread + ">" + value + "</textarea>" + describle; 
    	if (inputStr.length()==0) inputStr = "&nbsp;";
    	return inputStr;
    }
    
    public static String getDeptTreeLi(TreeItem ti, String treeName, int no, String jsfunc, int level, boolean isShowLeaf) {
        StringBuffer rtn = new StringBuffer();
        if (!ti.isLeaf()||isShowLeaf) {
        	if(no==0){
        		rtn.append("\n<ul>");
        		rtn.append("<li class='jstree-closed'><a href=\"basicinfo/UserCodeAction.jsp?_DeptId_="+ti.getId()+"\" target=\"mainFrame\">" + ti.getName()+"</a>");
        	}else{
        		rtn.append("<li><a href=\"basicinfo/UserCodeAction.jsp?_DeptId_="+ti.getId()+"\" target=\"mainFrame\">" + ti.getName()+"</a>");
        	}
            
            
        }
        Collection sublist = ti.values();
        Iterator it = sublist.iterator();
        int i=0,j=0;
        while (it.hasNext()) {
            TreeItem pt = (TreeItem)(it.next());
            rtn.append(getDeptTreeLi(pt, treeName, i++, jsfunc, level * 10, isShowLeaf));
            j++;
        }
        if(!it.hasNext()&& i>0){
    		rtn.append("</ul>\n");
    	}
        rtn.append("</li>\n");
        return rtn.toString();
    }
    
    public static String getSelect(Map map,String name,String val,String function){
    	return getSelect(map, name, val, function, true);
    }
    
    public static String getSelect(Map map,String name,String val,String function,boolean isDefault){
    	StringBuffer rtn=new StringBuffer();
    	rtn.append("<select name=\""+name+"\" id=\""+name+"\" onChange=\""+function+"\">");
    	if(isDefault){
    		rtn.append("<option value=\"-1\"></option>");
    	}
    	for(Iterator it=map.keySet().iterator();it.hasNext();){
    		String key=(String)it.next();
    		if(val.equals(key)){
    			rtn.append("<option selected value=\""+key+"\">"+map.get(key)+"</option>");
    		}else{
    			rtn.append("<option value=\""+key+"\">"+map.get(key)+"</option>");
    		}
    	}
    	rtn.append("</select>");
    	return rtn.toString();
    }
}
