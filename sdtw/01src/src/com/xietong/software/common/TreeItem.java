package com.xietong.software.common;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.util.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import org.apache.commons.logging.*;

public class TreeItem {
    private static Log log = LogFactory.getLog(TreeItem.class);

    public class OrderItem implements Comparator {
        protected int id = -1;
        public int getId() { return id; }
        public void setId(int aId) { id = aId; }
        protected int orders = 0;
        public String getOrders() { return "" + orders; }
        public void setOrders(String aOrders) {
            int otmp = 0;
            for (int i = 0; i < aOrders.length(); i += 12) {
                if ( aOrders.length() > (i + 12)) {
                    otmp = StrTool.toInt(aOrders.substring(i, i + 12));
                } else {
                    otmp = StrTool.toInt(aOrders.substring(i));
                }
                orders += otmp;
            }
        }

        public OrderItem(int id, String orders) {
            setId(id);
            setOrders(orders);
        }

        public boolean equals(Object obj) {
            return (hashCode() == obj.hashCode());
        }

        public int compare(Object o1, Object o2) {
            return (o1.hashCode() - o2.hashCode());
        }
        public int hashCode() {
            return orders;
        }
    }
    public class OrderArray {
        protected List array = new ArrayList();

        public List getArray() {
            return array;
        }

        public void add(OrderItem oi) {
            array.add(oi);
        }

        public void sort() {
            OrderItem oi = new OrderItem(0, "-1");
            Collections.sort(array, oi);
        }

        public void remove(OrderItem oi) {
            array.remove(oi);
        }

        public void clear() {
            array.clear();
        }

    }
    protected Map submap = new HashMap();
    protected OrderArray orderArray = new OrderArray();

    protected int id = -1;
    public int getId() { return id; }
    public void setId(int aId) { id = aId; }
    protected int pid = 0;
    public int getPid() { return pid; }
    public void setPid(int aPid) { pid = aPid; }
    protected String code = "";
    public String getCode() { return code; }
    public void setCode(String aCode) { code = aCode; }
    protected String pcode = "";
    public String getPcode() { return pcode; }
    public void setPcode(String aPcode) { pcode = aPcode; }
    protected String name = "root";
    public String getName() { return name; }
    public void setName(String aName) { name = aName; }
    protected String orders = "";
    public String getOrders() { return orders; }
    public void setOrders(String aOrders) { orders = aOrders; }
    protected String url = "";
    public String getUrl() { return url; }
    public void setUrl(String aUrl) { url = aUrl; }
    protected int checked = 0;
    public int getChecked() { return checked; }
    public void setChecked(int aChecked) { checked = aChecked; }
    protected int sort = 0;
    public int getSort() { return sort; }
    public void setSort(int aSort) { sort = aSort; }
    protected int level = 0;
    public int getLevel() { return level; }
    public void setLevel(int aLevel) { level = aLevel; }
    protected String className = "";
    public String getClassName() { return className; }
    public void setClassName(String aClassName) { className = aClassName; }
    protected boolean leaf = true;
    public boolean isLeaf() { return leaf; }

    public void put(int id, TreeItem ti) {
        submap.put("" + id, ti);
        orderArray.add(new OrderItem(id, ti.getOrders()));
        if (leaf && (submap.size() > 0)) {
            leaf = false;
        }
    }

    public TreeItem get(int id) {
        return (TreeItem)submap.get("" + id);
    }

    public Set keySet() {
        return submap.keySet();
    }

    public Collection values() {
        List rtn = new ArrayList();
        orderArray.sort();
        List array = orderArray.getArray();
        for (Iterator it=array.iterator(); it.hasNext(); ) {
            OrderItem oi = (OrderItem)it.next();
            rtn.add(get(oi.getId()));
        }
        return rtn;
    }

    public boolean equals(Object obj) {
        return (hashCode() == obj.hashCode());
    }

    public void remove(int id) {
        orderArray.remove(new OrderItem(id, get(id).getOrders()));
        submap.remove("" + id);
        if (!leaf && (submap.size() == 0)) {
            leaf = true;
        }
    }

    public void clear() {
        submap.clear();
        orderArray.clear();
        leaf = true;
    }

    public int hashCode() {
        return id;
    }

    public String toJavascript() {
        StringBuffer str = new StringBuffer();
        if (leaf) {
            str.append("['" + name + "']\n");
        } else {
            str.append("['" + name + "',0,\n");
        }
        Collection sub = values();
        Iterator it = sub.iterator();
        while (it.hasNext()) {
            TreeItem ti = (TreeItem)it.next();
            if (it.hasNext()) {
                str.append(ti.toJavascript() + ",");
            } else {
                str.append(ti.toJavascript());
            }
        }
        if (!leaf) {
            str.append("]\n");
        }
        return str.toString();
    }

    //if url is null, src attribute will not set
    public String toXLoadTreeAttribute(String url, String treeName, String jsfunc) {
        StringBuffer str = new StringBuffer();
        str.append("text=\"" + name + "\" ");
        //if (leaf) {
        if (url != null) {
            str.append("src=\"" + HtmlUtils.htmlSpecialChars(url + id) + "\" ");
        }
        //}
        str.append("action=\"javascript:" + jsfunc + "(" + treeName + ".getSelected());\" ");
        str.append("data=\"" + HtmlUtils.htmlSpecialChars(toXtreeData()) + "\"");
        return str.toString();
    }
    
    public String toXLoadTreeAttribute(String url, String treeName, String jsfunc,int cocur) {
        StringBuffer str = new StringBuffer();
        str.append("text=\"" + name + "\" ");
        //if (leaf) {
        if (url != null) {
            str.append("src=\"" + HtmlUtils.htmlSpecialChars(url + id) + "\" ");
        }
        //}
        str.append("action=\"javascript:" + jsfunc + "(webFXTreeHandler.selected,"+cocur+");\" ");
        str.append("data=\"" + HtmlUtils.htmlSpecialChars(toXtreeData()) + "\"");
        return str.toString();
    }

    public String toXLoadTree(String url, String treeName, String jsfunc) {
        return "<tree " + toXLoadTreeAttribute(url, treeName, jsfunc) + " />\n";
    }

    public String toXLoadTreeCheckBox(String url, String checked_ids) {
        StringBuffer str = new StringBuffer();
        if (StrTool.inList(checked_ids, "" + id, ",")) {
            checked = 1;
        } else {
            checked = 0;
        }
        if (leaf) {
            str.append("<tree text=\"" + code + ":" + name + "\" action=\"javascript:void(0);\" data=\"" + HtmlUtils.htmlSpecialChars(toXtreeData()) + "\" type=\"1\" checked=\"" + checked + "\" />\n");
        } else {
            str.append("<tree text=\"" + code + ":" + name + "\" src=\"" + url + id + "\" action=\"javascript:void(0);\" data=\"" + HtmlUtils.htmlSpecialChars(toXtreeData()) + "\" type=\"1\" checked=\"" + checked + "\" />\n");
        }
        /*
        Collection sub = values();
        Iterator it = sub.iterator();
        while (it.hasNext()) {
            TreeItem ti = (TreeItem)it.next();
            str.append(ti.toXLoadTreeCheckBox());
        }
        if (!leaf) {
            str.append("</tree>\n");
        }
        */
        return str.toString();
    }

    public String toXtreeData() {
        StringBuffer str = new StringBuffer();
        str.append("[{type:'" + className + "',");
        str.append("id:'" + id + "',");
        str.append("pid:'" + pid + "',");
        str.append("code:'" + code + "',");
        str.append("pcode:'" + pcode + "',");
        str.append("name:'" + name + "',");
        str.append("sort:'" + sort + "',");
        str.append("level:'" + level + "',");
        str.append("url:'" + url + "',");
        str.append("checked:'" + checked + "'}]");
        return str.toString();
    }

}
