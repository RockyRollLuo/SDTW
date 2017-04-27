package com.xietong.software.common;

public class GetStyle {
	public static String getText(){
		String tmp="";	
		if(false){
			tmp =" contentEditable=false oncontextmenu='return false' onselectstart='return false' ondragstart='return false' onmouseover=\"self.status='#';return true \"";	
		}
		return tmp;
	}
	
}


