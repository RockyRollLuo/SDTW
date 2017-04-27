
/**
 *  ParamUtils.java
 */

package com.xietong.software.util;

import javax.servlet.http.*;

import java.lang.reflect.*;
import java.math.BigDecimal;
import java.util.*;
import java.beans.*;

import com.xietong.software.common.HttpTool;

/**
 *  This class assists skin writers in getting parameters.
 */
public class ParamUtils {

    /**
     *  Gets a parameter as a string.
     *  @param request The HttpServletRequest object, known as "request" in a
     *  JSP page.
     *  @param paramName The name of the parameter you want to get
     *  @return The value of the parameter or null if the parameter was not
     *  found or if the parameter is a zero-length string.
     */
    public static String getParameter( HttpServletRequest request, String paramName ) {
        return getParameter( request, paramName, false );
    }

    /**
     *  Gets a parameter as a string.
     *  @param request The HttpServletRequest object, known as "request" in a
     *  JSP page.
     *  @param paramName The name of the parameter you want to get
     *  @param emptyStringsOK Return the parameter values even if it is an empty string.
     *  @return The value of the parameter or null if the parameter was not
     *  found.
     */
    public static String getParameter( HttpServletRequest request, String paramName, boolean emptyStringsOK ) {
        String temp = request.getParameter(paramName);
        if( temp != null ) {
            if( temp.equals("") && !emptyStringsOK ) {
                return null;
            } else {
                //return StringUtils.stringFromCh(temp);
                return temp;
            }
        } else {
            return null;
        }
    }

    public static String getParameter( HttpServletRequest request, String paramName, String defaultValue ) {
    	String temp = request.getParameter(paramName);
    	if(!request.getMethod().equalsIgnoreCase("post") && temp != null){
    		temp = HttpTool.urlDecode(temp);
    	}
        if( temp != null ) {
            //return StringUtils.stringFromCh(temp);
            return temp;
        } else {
            return defaultValue;
        }
    }

    /**
     *  Gets a parameter as a boolean.
     *  @param request The HttpServletRequest object, known as "request" in a
     *  JSP page.
     *  @param paramName The name of the parameter you want to get
     *  @return True if the value of the parameter was "true", false otherwise.
     */
    public static boolean getBooleanParameter( HttpServletRequest request, String paramName ) {
        String temp = request.getParameter(paramName);
        if( temp != null && temp.equals("true") ) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *  Gets a parameter as a int.
     *  @param request The HttpServletRequest object, known as "request" in a
     *  JSP page.
     *  @param paramName The name of the parameter you want to get
     *  @return The int value of the parameter specified or the default value if
     *  the parameter is not found.
     */
    public static int getIntParameter( HttpServletRequest request, String paramName, int defaultNum ) {
        String temp = request.getParameter(paramName);
        if( temp != null && !temp.equals("") ) {
            int num = defaultNum;
            try {
                num = Integer.parseInt(temp);
            } catch( Exception ignored ) {}
            return num;
        } else {
            return defaultNum;
        }
    }
    
    
    public static BigDecimal getBigDecimalParameter( HttpServletRequest request, String paramName, BigDecimal defaultNum ) {
        String temp = request.getParameter(paramName);
        if( temp != null && !temp.equals("") ) {
        	BigDecimal num = defaultNum;
            try {
                num = new BigDecimal(temp);
            } catch( Exception ignored ) {}
            return num;
        } else {
            return defaultNum;
        }
    }

    public static long getLongParameter( HttpServletRequest request, String paramName, long defaultNum ) {
        String temp = request.getParameter(paramName);
        if( temp != null && !temp.equals("") ) {
            long num = defaultNum;
            try {
                num = Long.parseLong(temp);
            } catch( Exception ignored ) {}
            return num;
        } else {
            return defaultNum;
        }
    }

    public static Date getDateTimeParameter(HttpServletRequest request, String paramName, Date defaultDateTime ) {
        String temp = request.getParameter(paramName);
        if( temp != null && !temp.equals("") ) {
            Date rtn = defaultDateTime;
            try {
            	if(temp.indexOf(":")<0)
            		temp += " 00:00:00";
                rtn = Tool.stringToDateTime(temp);
            } catch( Exception ignored ) {}
            return rtn;
        } else {
            return defaultDateTime;
        }
    }
	public static Date getDateParameter(HttpServletRequest request, String paramName, Date defaultDateTime ) {
        String temp = request.getParameter(paramName);
        if( temp != null && !temp.equals("") ) {
            Date rtn = defaultDateTime;
            try {
                rtn = Tool.stringToDate(temp);
            } catch( Exception ignored ) {}
            return rtn;
        } else {
            return defaultDateTime;
        }
    }

    public static Date getDateTimeParameter(HttpServletRequest request, String paramName) {
        String temp = request.getParameter(paramName);
        if( temp != null && !temp.equals("") ) {
            Date rtn = new Date();
            try {
                rtn = Tool.stringToDateTime(temp);
            } catch( Exception ignored ) {}
            return rtn;
        } else {
            return new Date();
        }
    }

    /**
     *  Gets a checkbox parameter value as a boolean.
     *  @param request The HttpServletRequest object, known as "request" in a
     *  JSP page.
     *  @param paramName The name of the parameter you want to get
     *  @return True if the value of the checkbox is "on", false otherwise.
     */
    public static boolean getCheckboxParameter( HttpServletRequest request, String paramName ) {
        String temp = request.getParameter(paramName);
        if( temp != null && temp.equals("on") ) {
            return true;
        } else {
            return false;
        }
    }

    public static double getDoubleParameter( HttpServletRequest request, String paramName, double defaultNum ) {
        String temp = request.getParameter(paramName);
        if( temp != null && !temp.equals("") ) {
            double num = defaultNum;
            try {
                num = Double.parseDouble(temp);
            } catch( Exception ignored ) {}
            return num;
        } else {
            return defaultNum;
        }
    }

    /**
     *  Gets a parameter as a string.
     *  @param request The HttpServletRequest object, known as "request" in a
     *  JSP page.
     *  @param attribName The name of the parameter you want to get
     *  @return The value of the parameter or null if the parameter was not
     *  found or if the parameter is a zero-length string.
     */
    public static String getAttribute( HttpServletRequest request, String attribName ) {
        return getAttribute( request, attribName, false );
    }

    /**
     *  Gets a parameter as a string.
     *  @param request The HttpServletRequest object, known as "request" in a
     *  JSP page.
     *  @param attribName The name of the parameter you want to get
     *  @param emptyStringsOK Return the parameter values even if it is an empty string.
     *  @return The value of the parameter or null if the parameter was not
     *  found.
     */
    public static String getAttribute( HttpServletRequest request, String attribName, boolean emptyStringsOK ) {
        String temp = (String)request.getAttribute(attribName);
        if( temp != null ) {
            if( temp.equals("") && !emptyStringsOK ) {
                return null;
            } else {
                return temp;
            }
        } else {
            return null;
        }
    }

    public static String getAttribute( HttpServletRequest request, String attribName, String defaultValue ) {
        String temp = (String)request.getAttribute(attribName);
        if( temp != null ) {
            //return StringUtils.stringFromCh(temp);
            return temp;
        } else {
            return defaultValue;
        }
    }

    /**
     *  Gets an attribute as a boolean.
     *  @param request The HttpServletRequest object, known as "request" in a
     *  JSP page.
     *  @param attribName The name of the attribute you want to get
     *  @return True if the value of the attribute is "true", false otherwise.
     */
    public static boolean getBooleanAttribute( HttpServletRequest request, String attribName ) {
        String temp = (String)request.getAttribute(attribName);
        if( temp != null && temp.equals("true") ) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *  Gets an attribute as a int.
     *  @param request The HttpServletRequest object, known as "request" in a
     *  JSP page.
     *  @param attribName The name of the attribute you want to get
     *  @return The int value of the attribute or the default value if the attribute is not
     *  found or is a zero length string.
     */
    public static int getIntAttribute( HttpServletRequest request, String attribName, int defaultNum ) {
        String temp = (String)request.getAttribute(attribName);
        if( temp != null && !temp.equals("") ) {
            int num = defaultNum;
            try {
                num = Integer.parseInt(temp);
            } catch( Exception ignored ) {}
            return num;
        } else {
            return defaultNum;
        }
    }

    public static long getIntAttribute( HttpServletRequest request, String attribName, long defaultNum ) {
        String temp = (String)request.getAttribute(attribName);
        if( temp != null && !temp.equals("") ) {
            long num = defaultNum;
            try {
                num = Long.parseLong(temp);
            } catch( Exception ignored ) {}
            return num;
        } else {
            return defaultNum;
        }
    }

    public static String[] getArrayParameter( HttpServletRequest request, String paramName ) {
        String[] temp = request.getParameterValues(paramName);
        if (temp == null)
            temp = new String[0];
        return temp;
    }
}
