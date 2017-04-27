package com.xietong.software.common;

import java.util.ArrayList;
import java.util.List;

import com.xietong.software.util.OptionBean;

public class GetYearMonth {
	
	//获取年度
	public List  getYear(){
		 List options = new ArrayList();
		 int year=2014;
		 options.add(new OptionBean("" , ""));
		 for(int i=0;i<=11;i++){
			 options.add(new OptionBean(""+(year+i) , ""+(year+i)));
		 }
		 return options;
	}
	//获取月份
	public List getMonth(){
		List options = new ArrayList();
		 int month=1;
		 options.add(new OptionBean("" , ""));
		 for(int i=0;i<12;i++){
			 options.add(new OptionBean(""+(month+i) , ""+(month+i)));
		 }
		 return options;
		
	}
}
