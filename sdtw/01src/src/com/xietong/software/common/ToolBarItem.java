package com.xietong.software.common;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.util.*;

public class ToolBarItem {
    private boolean enable = true;
    private int width = 60;
    private String href = "#";
    private String title = "请放一个解释";
    private String imgSrc = "edit.gif";
    private String caption = "标题";
    
    public ToolBarItem(int width, String href, String imgSrc, String caption, String describ) {
        this.width = width;
        this.href = href;
        this.imgSrc = imgSrc;
        this.caption = caption;
        this.title = describ;
    }
    public void setEnable(boolean data) {
        enable = data;
    }
    public boolean getEnable() {
        return enable;
    }
    public void setWidth(int data) {
        width = data;
    }
    public int getWidth() {
        return width;
    }
    public void setHref(String data) {
        href = data;
    }
    public String getHref() {
        return href;
    }
    public void setTitle(String data) {
        title = data;
    }
    public String getTitle() {
        return title;
    }
    public void setImgSrc(String data) {
        imgSrc = data;
    }
    public String getImgSrc() {
        return imgSrc;
    }
    public void setCaption(String data) {
        caption = data;
    }
    public String getCaption() {
        return caption;
    }
}
