package com.xietong.software.common;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.util.*;

public class ToolBar {
    private String skinid = "set1";

    private String idname = "editbar";
    private String tdclass = "coolButton";
    private String align = "center";
    private String valign = "middle";
    private String aclass = "p1";
    private String type = "send";
    private int imgborder = 0;
    private String imgbase = HeadConst.root_url_path + "/images/" + skinid + "/" + type;
    private String imgalign = "absmiddle";
    private List itemList = new ArrayList();
    
    public ToolBar() {
    }

    public void setItems(ToolBarItem[] data) {
        itemList = new ArrayList(Arrays.asList(data));
    }
    public void addItem(ToolBarItem data) {
        itemList.add(data);
    }
    public void setType(String type) {
        this.type = type;
        this.imgbase = HeadConst.root_url_path + "/images/" + skinid + "/" + type;
    }
    public void setSkinId(String skinid) {
        this.skinid = skinid;
        this.imgbase = HeadConst.root_url_path + "/images/" + skinid + "/" + type;
    }
    public void setIdname(String idname) {
        this.idname = idname;
    }

    public String render()
    {
        StringBuffer rtn = new StringBuffer();
        rtn.append("<table id='" + idname + "' cellspacing='0' cellpadding='0' width='100%' class=p5 ><tr nowrap>");
        for (Iterator it=itemList.iterator(); it.hasNext(); ) {
            ToolBarItem item = (ToolBarItem)it.next();
            if (item.getEnable()) {
                rtn.append("<td class='" + tdclass + "' align='" + align + "' valign='" + valign + "' nowrap  width='" + item.getWidth() + "'><a class=" + aclass + " href='" + item.getHref() + "' title='" + item.getTitle() + "'><img border='" + imgborder + "' src='" + imgbase + "/" + item.getImgSrc() + "' align='" + imgalign + "' width='23' height='23'>&nbsp;" + item.getCaption() + "</a></td>");
                //rtn.append("<td style='width: 6'><span class='separator'></span></td>");
            }
        }
        rtn.append("<td width='100%' valign='top'></td></tr></table>");
        return rtn.toString();
    }
}
