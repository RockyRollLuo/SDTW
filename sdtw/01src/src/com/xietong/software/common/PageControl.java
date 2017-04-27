package com.xietong.software.common;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;

public class PageControl {
    private int pagesize = 8; //每页8条
    private int total_recorder = 0;
    private int shownum = 20;
    private int offset = 0;
    private int firstpage = 0;
    private int lastpage = 0;
    private int priorpage = 0;
    private int nextpage = 0;
    private int total_page = 0;
    private int currpage = 0;
    public int getOffset() {
        return offset;
    }
    public int getShownum() {
        return shownum;
    }
    public int getCurrPage() {
        return currpage;
    }
    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }
    public int getPagesize() {
        return pagesize;
    }
    public int getTotal_recorder() {
		return total_recorder;
	}
	public void setTotal_recorder(int total_recorder) {
		this.total_recorder = total_recorder;
	}
    public PageControl(int total_recorder, int currpage, int pagesize)
    {
        this.total_recorder = total_recorder;
        currpage = (currpage < 1) ? 1 : currpage;
        this.currpage = currpage;
        this.pagesize = pagesize;
        if(total_recorder > 0) { //有记录
            //计算要显示的变量
            total_page = (int)Math.ceil((double)total_recorder / (double)pagesize);
            if( currpage > total_page)
                currpage = total_page;
            firstpage = 1;
            lastpage = total_page;
            if (currpage > firstpage) {
                priorpage = currpage - 1;
            } else {
                priorpage = 1;
            }
            if (currpage < lastpage) {
                nextpage = currpage + 1;
            } else {
                nextpage = lastpage;
            }
            offset = pagesize * (currpage - 1);
            if(currpage >= lastpage) {
                shownum = total_recorder - offset;
            } else {
                shownum = pagesize;
            }
        }
    }
    
    /**
     * 重新计算分页信息
     */
    public void resetPage(){
    	if(total_recorder > 0) { //有记录
            //计算要显示的变量
            total_page = (int)Math.ceil((double)total_recorder / (double)pagesize);
            if( currpage > total_page)
                currpage = total_page;
            firstpage = 1;
            lastpage = total_page;
            if (currpage > firstpage) {
                priorpage = currpage - 1;
            } else {
                priorpage = 1;
            }
            if (currpage < lastpage) {
                nextpage = currpage + 1;
            } else {
                nextpage = lastpage;
            }
            offset = pagesize * (currpage - 1);
            if(currpage >= lastpage) {
                shownum = total_recorder - offset;
            } else {
                shownum = pagesize;
            }
        }
    }
    
    private String[] pageArray(int totalpage, int currpage, int dispsize)
    {
        //计算要显示的变量
        if (totalpage <= dispsize) {
            String[] rtn = new String[totalpage];
            for (int i = 0; i < rtn.length; i ++) {
                rtn[i] = "" + (i + 1);
            }
            return rtn;
        } else {
            int num = (int)Math.round((double)currpage / (double)dispsize);
            String[] rtn = new String[dispsize];
            for (int i = 0; i < rtn.length; i ++) {
                rtn[i] = "" + ((num * dispsize) + i + 1);
                System.out.println("rtn[" + i + "] = " + rtn[i]);
            }
            return rtn;
        }
    }
    //显示表格内容
    public void printControl(JspWriter out, String url, String desc) throws IOException {
        out.print(getControl(url, desc));
    }
    //获得表格内容
    public String getControl(String url, String desc) {
        //翻页控制 开始
        StringBuffer str = new StringBuffer();
        if(currpage > lastpage) {
            currpage = lastpage;
        }
        if (url.indexOf("?") >= 0) {
            url = url + "&";
        } else {
            url = url + "?";
        }
        str.append("<div id=nav1><ul>");
        if (desc.length() > 0)
            str.append("<li>" + desc + "</li>");
        str.append("<li><span id='pageinfo'>(第" + currpage + "页&nbsp;共" + total_page + "页)</span></li>");
        if ( currpage > firstpage) {
            str.append("<li><a href='" + url + "page=" + firstpage + "'>首页</a></li>");
            str.append("<li><a href='" + url + "page=" + priorpage + "'>上页</a></li>");
        } else {
            str.append("<li><b>首页</b>");
            str.append("<li>上页");
        }
        str.append("<li><input id=\"changepageinput\" size=\"2\" value=\"" + currpage + "\" onchange=\"javascript:cmd_change_page('" + url + "page=', " + currpage + ", " + lastpage + ");\">");
        str.append("<a href=\"#\" onclick=\"javascript:cmd_change_page('" + url + "page=', " + currpage + ", " + lastpage + ");\">跳转</a></li>");
        if (currpage < lastpage) {
           str.append("<li><a href='" + url + "page=" + nextpage + "'>下页</a></li>");
            str.append("<li><a href='" + url + "page=" + lastpage + "'>尾页</a></li>");
        } else {
            str.append("<li>下页</li>");
            str.append("<li><b>尾页</b></li>");
        }
        str.append("<li><span id='pageinfo'>(共" + total_recorder + "条)</span></li>");
        str.append("</ul></div>\n");
        return str.toString();
    }
    public String getControl(String url,String skinId,String desc) {
    	//翻页控制 开始
    	StringBuffer str = new StringBuffer();
    	if(currpage > lastpage) {
    		currpage = lastpage;
    	}
    	if (url.indexOf("?") >= 0) {
    		url = url + "&";
    	} else {
    		url = url + "?";
    	}
    	str.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
    	str.append("<tr>");
    	str.append("<td width=\"15\" height=\"29\"><img src=\"main/images/skin/"+skinId+"/tab/tab_20.gif\" width=\"15\" height=\"29\" /></td>");
    	str.append("<td background=\"main/images/skin/"+skinId+"/tab/tab_21.gif\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
    	str.append("<tr>");
    	str.append("<td width=\"25%\" height=\"29\" nowrap=\"nowrap\"><span class=\"STYLE1\">共"+total_recorder+"条纪录，当前第"+currpage+"/"+total_page+"页，每页"+shownum+"条纪录</span></td>");
    	str.append("<td width=\"75%\" valign=\"top\" class=\"STYLE1\"><div align=\"right\">");
    	str.append("<table width=\"352\" height=\"20\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
    	str.append("<tr>");
    	str.append("<td width=\"62\" height=\"22\" valign=\"middle\"><div align=\"right\"><a href='" + url + "page=" + firstpage + "'><img src=\"main/images/skin/"+skinId+"/tab/first.gif\" width=\"37\" height=\"15\" /></a></div></td>");
    	str.append("<td width=\"50\" height=\"22\" valign=\"middle\"><div align=\"right\"><a href='" + url + "page=" + priorpage + "'><img src=\"main/images/skin/"+skinId+"/tab/back.gif\" width=\"43\" height=\"15\" /></a></div></td>");
    	str.append("<td width=\"54\" height=\"22\" valign=\"middle\"><div align=\"right\"><a href='" + url + "page=" + nextpage + "'><img src=\"main/images/skin/"+skinId+"/tab/next.gif\" width=\"43\" height=\"15\" /></a></div></td>");
    	str.append("<td width=\"49\" height=\"22\" valign=\"middle\"><div align=\"right\"><a href=javascript:page('"+url+"',"+lastpage+")><img src=\"main/images/skin/"+skinId+"/tab/last.gif\" width=\"37\" height=\"15\" /></a></div></td>");
    	str.append("<td width=\"59\" height=\"22\" valign=\"middle\"><div align=\"right\" class=\"STYLE1\">转到第</div></td>");
    	str.append("<td width=\"25\" height=\"22\" valign=\"middle\"><span class=\"STYLE7\">");
    	str.append("<input name=\"changepageinput\" id=\"changepageinput\" type=\"text\" class=\"STYLE1\" style=\"height:10px; width:25px;\" size=\"5\" />");
    	str.append("</span></td>");
    	str.append("<td width=\"23\" height=\"22\" valign=\"middle\" class=\"STYLE1\">页</td>");
    	str.append("<td width=\"30\" height=\"22\" valign=\"middle\"><a href=\"#\" onclick=\"javascript:cmd_change_page('" + url + "page=', " + currpage + ", " + lastpage + ");\"><img src=\"main/images/skin/"+skinId+"/tab/go.gif\" width=\"37\" height=\"15\" /></a></td>");
    	str.append("</tr>");
    	str.append(" </table>");
    	str.append("</div></td>");
    	str.append(" </tr>");
    	str.append(" </table></td>");
    	str.append("<td width=\"14\"><img src=\"main/images/skin/"+skinId+"/tab/tab_22.gif\" width=\"14\" height=\"29\" /></td>");
    	str.append("</tr>");
    	str.append(" </table>");
   
    	return str.toString();
    }
    //弹出页保存复选框用
    public String getControlShow(String url, String desc) {
        //翻页控制 开始
        StringBuffer str = new StringBuffer();
        if(currpage > lastpage) {
            currpage = lastpage;
        }
        if (url.indexOf("?") >= 0) {
            url = url + "&";
        } else {
            url = url + "?";
        }
        str.append("<div id=nav1><ul>");
        if (desc.length() > 0)
            str.append("<li>" + desc + "</li>");
        str.append("<li><span id='pageinfo'>(第" + currpage + "页&nbsp;共" + total_page + "页)</span></li>");
        if ( currpage > firstpage) {
            //str.append("<li><a href='" + url + "page=" + firstpage + "'>首页</a></li>");
            str.append("<li><a href=javascript:page('"+url+"',"+firstpage+")>首页</a></li>");
            //str.append("<li><a href='" + url + "page=" + priorpage + "'>上页</a></li>");
            str.append("<li><a href=javascript:page('"+url+"',"+priorpage+",this.value"+")>上页</a></li>");
        } else {
            str.append("<li><b>首页</b>");
            str.append("<li>上页");
        }
        str.append("<li><input id=\"changepageinput\" size=\"2\" value=\"" + currpage + "\" onchange=\"javascript:cmd_change_page('" + url + "page=', " + currpage + ", " + lastpage + ");\">");
        str.append("<a href=\"#\" onclick=\"javascript:cmd_change_page('" + url + "page=', " + currpage + ", " + lastpage + ");\">跳转</a></li>");
        if (currpage < lastpage) {
           // str.append("<li><a href='" + url + "page=" + nextpage + "'>下页</a></li>");
           str.append("<li><a href=javascript:page('"+url+"',"+nextpage+")>下页</a></li>");
            //str.append("<li><a href='" + url + "page=" + lastpage + "'>尾页</a></li>");
            str.append("<li><a href=javascript:page('"+url+"',"+lastpage+")>尾页</a></li>");
        } else {
            str.append("<li>下页</li>");
            str.append("<li><b>尾页</b></li>");
        }
        str.append("<li><span id='pageinfo'>(共" + total_recorder + "条)</span></li>");
        str.append("</ul></div>\n");
        return str.toString();
    }
    
    public String getControl_win8(String url, String path) {
        
        //翻页控制 开始
          StringBuffer str = new StringBuffer();
          if(currpage > lastpage) {
              currpage = lastpage;
          }
          if (url.indexOf("?") >= 0) {
              url = url + "&";
          } else {
              url = url + "?";
          }
          str.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
          str.append("	<tr>");
          str.append("		<td style='height:31px;' bgcolor=\"#3992d0\">");
          str.append("			<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
          str.append("				<tr>");
          str.append("					<td width=\"1%\" >&nbsp;</td>");
          str.append("					<td width=\"40%\" style='color:#ffffff;' >页次：" + currpage + "/" + total_page + "页 &nbsp;每页显示：" + pagesize + "条 &nbsp;总记录数：" + total_recorder + "条</td>");
          str.append("					<td>&nbsp;</td>");
          str.append("					<td width=\"10\"><a href='" + url + "page=" + priorpage + "'><img src=\""+path+"/pageleft.gif\" border=\"0\" width=\"16\" height=\"15\"></td>");
          str.append("					<td width=\"6%\"><div align=\"center\" style='color:#ffffff;'>第"+currpage+"页</div></td>");
          str.append("					<td width=\"10\"><a href='" + url + "page=" + nextpage + "'><img src=\""+path+"/pageright.gif\" border=\"0\" width=\"16\" height=\"15\"></a></td>");
          str.append("					<td width=\"1%\">&nbsp;</td>");
          str.append("					<td width=\"4%\" align=\"right\" style='color:#ffffff;'>转到:</td>");
          str.append("					<td width=\"4%\" align=\"left\">");
          str.append("						<input id=\"changepageinput\" size=\"2\" value=\"" + currpage + "\" onchange=\"javascript:cmd_change_page('" + url + "page=', " + currpage + ", " + lastpage + ");\">");
          str.append("					</td>");
          str.append("					<td width=\"4%\"><input type=\"button\"style=\"text-align: center; vertical-align: middle;background-color:#ffffff;\" value=\"Go\" onclick=\"javascript:cmd_change_page('" + url + "page=', " + currpage + ", " + lastpage + ");\" name=\"goBtn\"></td>");
          str.append("				</tr>");
          str.append("			</table>");
          str.append("		</td>");
          str.append("	</tr>");
          str.append("</table>");
          return str.toString();
      }
    
    public String getControl_win8_(String url, String path) {
        
        //翻页控制 开始
          StringBuffer str = new StringBuffer();
          if(currpage > lastpage) {
              currpage = lastpage;
          }
          if (url.indexOf("?") >= 0) {
              url = url + "&";
          } else {
              url = url + "?";
          }
          str.append("<table width=\"89%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"margin: 0 auto;\">");
          str.append("	<tr>");
          str.append("		<td style='height:31px;' bgcolor=\"#dcdcdc\">");
          str.append("			<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
          str.append("				<tr>");
          str.append("					<td width=\"1%\" >&nbsp;</td>");
          str.append("					<td width=\"40%\" style='color:#000000;font-size: 12px;' >页次：" + currpage + "/" + total_page + "页 &nbsp;每页显示：" + pagesize + "条 &nbsp;总记录数：" + total_recorder + "条</td>");
          str.append("					<td>&nbsp;</td>");
          str.append("					<td width=\"10\"><a href='" + url + "page=" + priorpage + "'><img src=\""+path+"/pageleft.gif\" border=\"0\" width=\"16\" height=\"15\"></td>");
          str.append("					<td width=\"6%\"><div align=\"center\" style='color:#000000;font-size: 12px;'>第"+currpage+"页</div></td>");
          str.append("					<td width=\"10\"><a href='" + url + "page=" + nextpage + "'><img src=\""+path+"/pageright.gif\" border=\"0\" width=\"16\" height=\"15\"></a></td>");
          str.append("					<td width=\"1%\">&nbsp;</td>");
          str.append("					<td width=\"4%\" align=\"right\" style='color:#000000;font-size: 12px;'>转到:</td>");
          str.append("					<td width=\"4%\" align=\"left\">");
          str.append("						<input id=\"changepageinput\" size=\"2\" value=\"" + currpage + "\" onchange=\"javascript:cmd_change_page('" + url + "page=', " + currpage + ", " + lastpage + ");\">");
          str.append("					</td>");
          str.append("					<td width=\"4%\"><input type=\"button\"style=\"text-align: center; vertical-align: middle;background-color:#ffffff;\" value=\"Go\" onclick=\"javascript:cmd_change_page('" + url + "page=', " + currpage + ", " + lastpage + ");\" name=\"goBtn\"></td>");
          str.append("				</tr>");
          str.append("			</table>");
          str.append("		</td>");
          str.append("	</tr>");
          str.append("</table>");
          return str.toString();
      }
    
      public String getControl_win8_2(String url, String path) {
          
          //翻页控制 开始
            StringBuffer str = new StringBuffer();
            if(currpage > lastpage) {
                currpage = lastpage;
            }
            if (url.indexOf("?") >= 0) {
                url = url + "&";
            } else {
                url = url + "?";
            }
            str.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
            str.append("	<tr>");
            str.append("		<td style='height:31px;' bgcolor=\"#3992d0\">");
            str.append("			<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
            str.append("				<tr>");
            str.append("					<td width=\"10\"><a href='" + url + "page=" + priorpage + "'><img src=\""+path+"/pageleft.gif\" border=\"0\" width=\"16\" height=\"15\"></td>");
            str.append("					<td width=\"26%\"><div align=\"center\" style='color:#ffffff;'>" + currpage + "/" + total_page + "</div></td>");
            str.append("					<td width=\"10\"><a href='" + url + "page=" + nextpage + "'><img src=\""+path+"/pageright.gif\" border=\"0\" width=\"16\" height=\"15\"></a></td>");
            str.append("					<td width=\"1%\">&nbsp;</td>");
            str.append("					<td width=\"24%\" align=\"right\" style='color:#ffffff;'>转:</td>");
            str.append("					<td width=\"4%\" align=\"left\">");
            str.append("						<input id=\"changepageinput\" size=\"2\" value=\"" + currpage + "\" onchange=\"javascript:cmd_change_page('" + url + "page=', " + currpage + ", " + lastpage + ");\">");
            str.append("					</td>");
            str.append("					<td width=\"4%\"><input type=\"button\" style=\"text-align: center; vertical-align: middle;background-color:#ffffff;\" value=\"Go\" onclick=\"javascript:cmd_change_page('" + url + "page=', " + currpage + ", " + lastpage + ");\" name=\"goBtn\"></td>");
            str.append("				</tr>");
            str.append("			</table>");
            str.append("		</td>");
            str.append("	</tr>");
            str.append("</table>");
            return str.toString();
        }
      
      public String getControl_win8simple(String url, String path) {
          
          //翻页控制 开始
            StringBuffer str = new StringBuffer();
            if(currpage > lastpage) {
                currpage = lastpage;
            }
            if (url.indexOf("?") >= 0) {
                url = url + "&";
            } else {
                url = url + "?";
            }
            str.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
            str.append("	<tr>");
            str.append("		<td style='height:31px;' bgcolor=\"#3992d0\">");
            str.append("			<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
            str.append("				<tr>");
            str.append("					<td width=\"1%\" >&nbsp;</td>");
            str.append("					<td width=\"50%\" style='color:#ffffff;' >页次：" + currpage + "/" + total_page + "页 &nbsp;每页显示：" + pagesize + "条 &nbsp;总记录数：" + total_recorder + "条</td>");
            str.append("					<td>&nbsp;</td>");
            str.append("					<td width=\"10\"><a href='" + url + "page=" + priorpage + "'><img src=\""+path+"/pageleft.gif\" border=\"0\" width=\"16\" height=\"15\"></td>");
            str.append("					<td width=\"6%\"><div align=\"center\" style='color:#ffffff;'>第"+currpage+"页</div></td>");
            str.append("					<td width=\"10\"><a href='" + url + "page=" + nextpage + "'><img src=\""+path+"/pageright.gif\" border=\"0\" width=\"16\" height=\"15\"></a></td>");
            str.append("					<td width=\"1%\">&nbsp;</td>");
            str.append("					<td width=\"5%\" align=\"right\" style='color:#ffffff;'>转到:</td>");
            str.append("					<td width=\"4%\" align=\"left\">");
            str.append("						<input id=\"changepageinput\" size=\"2\" value=\"" + currpage + "\" onchange=\"javascript:cmd_change_page('" + url + "page=', " + currpage + ", " + lastpage + ");\">");
            str.append("					</td>");
            str.append("					<td width=\"4%\"><input style=\"text-align: center; vertical-align: middle;background-color:#ffffff;\" type=\"button\" value=\"Go\" onclick=\"javascript:cmd_change_page('" + url + "page=', " + currpage + ", " + lastpage + ");\" name=\"goBtn\"></td>");
            str.append("				</tr>");
            str.append("			</table>");
            str.append("		</td>");
            str.append("	</tr>");
            str.append("</table>");
            return str.toString();
        }
    
  //新oa用
    public String getControl1(String url, String path) {
        //翻页控制 开始
        StringBuffer str = new StringBuffer();
        if(currpage > lastpage) {
            currpage = lastpage;
        }
        if (url.indexOf("?") >= 0) {
            url = url + "&";
        } else {
            url = url + "?";
        }
        str.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
        str.append("	<tr>");
        str.append("		<td height=\"39\" background=\""+path+"/xxybgbgb.gif\">");
        str.append("			<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
        str.append("				<tr>");
        str.append("					<td width=\"1%\" >&nbsp;</td>");
        str.append("					<td width=\"40%\" >页次：" + currpage + "/" + total_page + "页 &nbsp;每页显示：" + pagesize + "条 &nbsp;总记录数：" + total_recorder + "条</td>");
        str.append("					<td>&nbsp;</td>");
        str.append("					<td width=\"10\"><a href='" + url + "page=" + priorpage + "'><img src=\""+path+"/pageleft.gif\" border=\"0\" width=\"16\" height=\"15\"></td>");
        str.append("					<td width=\"6%\"><div align=\"center\">第"+currpage+"页</div></td>");
        str.append("					<td width=\"10\"><a href='" + url + "page=" + nextpage + "'><img src=\""+path+"/pageright.gif\" border=\"0\" width=\"16\" height=\"15\"></a></td>");
        str.append("					<td width=\"1%\">&nbsp;</td>");
        str.append("					<td width=\"4%\" align=\"right\">转到:</td>");
        str.append("					<td width=\"4%\" align=\"left\">");
        str.append("						<input id=\"changepageinput\" size=\"2\" value=\"" + currpage + "\" onchange=\"javascript:cmd_change_page('" + url + "page=', " + currpage + ", " + lastpage + ");\">");
        str.append("					</td>");
        str.append("					<td width=\"4%\"><input style=\"text-align: center; vertical-align: middle;background-color:#ffffff;\" type=\"button\" value=\"Go\" onclick=\"javascript:cmd_change_page('" + url + "page=', " + currpage + ", " + lastpage + ");\" name=\"goBtn\"></td>");
        str.append("				</tr>");
        str.append("			</table>");
        str.append("		</td>");
        str.append("	</tr>");
        str.append("</table>");
        return str.toString();
    }
    
    public String getControl2(String url, String path, String type) {
        //翻页控制 开始
        StringBuffer str = new StringBuffer();
        if(currpage > lastpage) {
            currpage = lastpage;
        }
        if (url.indexOf("?") >= 0) {
            url = url + "&";
        } else {
            url = url + "?";
        }
        str.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
        str.append("	<tr>");
        str.append("		<td height=\"39\" background=\""+path+"/xxybgbgb.gif\">");
        str.append("			<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
        str.append("				<tr>");
        str.append("					<td width=\"1%\" >&nbsp;</td>");
        str.append("					<td width=\"40%\" >页次：" + currpage + "/" + total_page + "页 &nbsp;每页显示：" + pagesize + "条 &nbsp;总记录数：" + total_recorder + "条</td>");
        str.append("					<td>&nbsp;</td>");
        str.append("					<td width=\"10\"><a href='" + url + "page=" + priorpage + "&type="+type+"'><img src=\""+path+"/pageleft.gif\" border=\"0\" width=\"16\" height=\"15\"></td>");
        str.append("					<td width=\"6%\"><div align=\"center\">第"+currpage+"页</div></td>");
        str.append("					<td width=\"10\"><a href='" + url + "page=" + nextpage + "&type="+type+"'><img src=\""+path+"/pageright.gif\" border=\"0\" width=\"16\" height=\"15\"></a></td>");
        str.append("					<td width=\"1%\">&nbsp;</td>");
        str.append("					<td width=\"4%\" align=\"right\">转到:</td>");
        str.append("					<td width=\"4%\" align=\"left\">");
        str.append("						<input id=\"changepageinput\" size=\"2\" value=\"" + currpage + "\" onchange=\"javascript:cmd_change_page('" + url + "page=', " + currpage + ", " + lastpage + ", '"+ type+"');\">");
        str.append("					</td>");
        str.append("					<td width=\"4%\"><input style=\"text-align: center; vertical-align: middle;background-color:#ffffff;\" type=\"button\" value=\"Go\" onclick=\"javascript:cmd_change_page('" + url + "page=', " + currpage + ", " + lastpage + ", '"+ type+"');\" name=\"goBtn\"></td>");
        str.append("				</tr>");
        str.append("			</table>");
        str.append("		</td>");
        str.append("	</tr>");
        str.append("</table>");
        return str.toString();
    }
    
    
    public String getControlSimple(String url, String path) {
        //翻页控制 开始
        StringBuffer str = new StringBuffer();
        if(currpage > lastpage) {
            currpage = lastpage;
        }
        if (url.indexOf("?") >= 0) {
            url = url + "&";
        } else {
            url = url + "?";
        }
        str.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
        str.append("	<tr>");
        str.append("		<td height=\"39\" background=\""+path+"/xxybgbgb.gif\">");
        str.append("			<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
        str.append("				<tr>");
        str.append("					<td width=\"1%\" >&nbsp;</td>");
        str.append("					<td width=\"70%\" >" + currpage + "/" + total_page + "页 &nbsp;每页显示：" + pagesize + "条 &nbsp;共：" + total_recorder + "条</td>");
        str.append("					<td width=\"10\"><a href='" + url + "page=" + priorpage + "'><img src=\""+path+"/pageleft.gif\" border=\"0\" width=\"16\" height=\"15\"></td>");
        str.append("					<td width=\"12%\"><div align=\"center\">第"+currpage+"页</div></td>");
        str.append("					<td width=\"10\"><a href='" + url + "page=" + nextpage + "'><img src=\""+path+"/pageright.gif\" border=\"0\" width=\"16\" height=\"15\"></a></td>");
        str.append("				</tr>");
        str.append("			</table>");
        str.append("		</td>");
        str.append("	</tr>");
        str.append("</table>");
        return str.toString();
    }
    
   
}
