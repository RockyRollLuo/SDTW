package com.xietong.software.base;

import java.util.ArrayList;
import java.util.List;

import com.xietong.software.common.HeadConst;
import com.xietong.software.common.UserInfo;
import com.xietong.software.sdtw.db.BaseMoudle;

public class CNavTree {
	
	public String getMenu(int pid,int MoudleGrade,UserInfo userInfo){
		List cdt = new ArrayList();
		cdt.add("pid="+pid);
		cdt.add("MoudleGrade="+MoudleGrade);
		cdt.add("isenable=1");
		cdt.add("moudletype=0");
		cdt.add("order by ordernum asc");
		BaseMoudle v = new BaseMoudle();
		StringBuffer sb = new StringBuffer();
		String re = "";
		List<BaseMoudle> list = v.query(cdt);
		for(int i=0;i<list.size();i++){
			BaseMoudle  item = list.get(i);
			if(userInfo==null)
				return "";
			if(!userInfo.hasMoudlePower(item.getCode()))
			{
				continue;
			}
			
			String href = "";
			if(item.getToUrl().indexOf("http")==0)
				href = item.getToUrl();
			else {
				href = HeadConst.apache_url+"/"+item.getToUrl();
			}
			if(item.getIsDept()==1&&!userInfo.getName().equals("admin")){
				href = HeadConst.apache_url+"/"+item.getToUrl();
				if(href.indexOf("?")>-1){
					href += "&_DeptId_=" + userInfo.getDeptId();
				}else{
					href += "?_DeptId_=" + userInfo.getDeptId();
				}
			}
			boolean has = hasChild(item);
			String aUrl = "<a href=\""+( has? "javascript:void(0);" : href)+"\" " + (has?"":"onclick='curMenu(this)'") + " target=\"mainFrame\">"+item.getName() + "</a>";
			if(href.equals(HeadConst.apache_url+"/")){
				aUrl = "<a href='javascript:void(0);' onclick=showmenu(this);>" + item.getName() + "</a>";
			}
			if(has){//存在子节点时调用
				sb.append("<li onclick=showmenu(this);>" + aUrl + "</li>");
				sb.append( "\n<div class=\"left" + MoudleGrade + "\"  style=\"display:none;\"><ul>\n");
				sb.append( getMenu(item.getId(),item.getMoudleGrade()+1,userInfo));
				sb.append( "\n</ul></div>\n");
			}else
				sb.append("<li>" + aUrl + "</li>");
			//继续展开
		}
		re = sb.toString();
		if(re.length()<50&&!re.equals("#")){
			re = "";
		}
		return re;
	}
	
	public String getMainMenu(UserInfo userInfo ){
		List cdt = new ArrayList();
		cdt.add("pid=-1");
		cdt.add("MoudleGrade=1");
		cdt.add("moudletype=0");
		cdt.add("order by ordernum asc");
		BaseMoudle v = new BaseMoudle();
		StringBuffer sb = new StringBuffer();
		List<BaseMoudle> list = v.query(cdt);
		int num = 0;
		for(int i=0;i<list.size();i++){
			BaseMoudle  item = list.get(i);
			if(!userInfo.hasMoudlePower(item.getCode()))
			{
				continue;
			}
			sb.append("<div class=\"leftan00" + (num++ % 6 + 1) + "\" style=\"CURSOR: pointer\" onclick=showmenu(this);><a href='javascript:void(0);'> " + item.getName() + "</a> </div>");
			if(hasChild(item)){
				sb.append("<div class=\"left1 "+(i == 0 ? "tree_select" : "tree_close")+"\" ><ul>");
				sb.append(getMenu(item.getId(), item.getMoudleGrade()+1, userInfo));
				sb.append("</ul></div>");
			}
		}
		return sb.toString();
	}
	
	public String getMainMenu(UserInfo userInfo ,int num){
		List cdt = new ArrayList();
		cdt.add("pid=-1");
		cdt.add("MoudleGrade=1");
		cdt.add("moudletype=0");
		cdt.add("order by ordernum asc");
		BaseMoudle v = new BaseMoudle();
		StringBuffer sb = new StringBuffer();
		List<BaseMoudle> list = v.query(cdt);
		for(int i=0;i<list.size();i++){
			BaseMoudle  item = list.get(i);
			if(!userInfo.hasMoudlePower(item.getCode()))
			{
				continue;
			}
			sb.append("<div class=\"leftan00" + (num % 6 + 1) + "\" style=\"CURSOR: pointer\" onclick=showmenu(this);><a href='javascript:void(0);'> " + item.getName() + "</a> </div>");
			if(hasChild(item)){
				sb.append("<div class=\"left1 "+(num == 0 ? "tree_select" : "tree_close")+"\" ><ul>");
				sb.append(getMenu(item.getId(), item.getMoudleGrade()+1, userInfo));
				sb.append("</ul></div>");
			}
			num++;
		}
		return sb.toString();
	}
	
	public boolean hasChild(BaseMoudle moudle){
		List cdt = new ArrayList();
		cdt.add("pid="+moudle.getId());
		cdt.add("isenable=1");
		cdt.add("moudletype=0");
		cdt.add("order by ordernum asc");
		BaseMoudle v = new BaseMoudle();
		return v.getCount(cdt)>0;
	}

}
