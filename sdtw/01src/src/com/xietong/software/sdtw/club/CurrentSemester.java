package com.xietong.software.sdtw.club;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentSemester {

	
	public static String getSchoolYear(Date strDate){
		String timestr = "",currentyear="",currentmonth="",firstyear="",lastyear="",schoolyear="";
		//Date strDate = new Date();  
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    
	    timestr=sdf.format(strDate);
	    currentyear=timestr.substring(0,4);
	    currentmonth=timestr.substring(5,7);
	    int currentmontINT=Integer.parseInt(currentmonth);
	    int currentyearINT=Integer.parseInt(currentyear);
	    if(currentmontINT<8){ 
	    	firstyear=""+(currentyearINT-1);
	    	lastyear=currentyear;
	    	schoolyear=firstyear+"~"+lastyear;
	    }else if(currentmontINT>=8){
	    	firstyear=currentyear;
	    	lastyear=""+(currentyearINT+1);
	    	schoolyear=firstyear+"~"+lastyear;
	    }
	    return schoolyear;
	}

	public static String getSemester(Date strDate){
		String timestr = "",currentyear="",currentmonth="",firstyear="",lastyear="",semester="";
		//Date strDate = new Date();  
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    timestr=sdf.format(strDate);
	    currentyear=timestr.substring(0,4);
	    currentmonth=timestr.substring(5,7);
	    int currentmontINT=Integer.parseInt(currentmonth);
	    int currentyearINT=Integer.parseInt(currentyear);
	    
	    if(currentmontINT<8&&currentmontINT>=2){ 
	    	firstyear=""+(currentyearINT-1);
	    	lastyear=currentyear;
	    	semester=firstyear+"~"+lastyear+"第二学期";
	    }else if(currentmontINT>=8){
	    	firstyear=currentyear;
	    	lastyear=""+(currentyearINT+1);
	    	semester=firstyear+"~"+lastyear+"第一学期";
	    }else if(currentmontINT==1){
	    	firstyear=""+(currentyearINT-1);
	    	lastyear=currentyear;
	    	semester=firstyear+"~"+lastyear+"第一学期";
	    }
	    return semester;
		
	}
}
