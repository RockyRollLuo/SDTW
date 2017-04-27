package com.xietong.software.common;

import java.io.*;
import java.util.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

import com.xietong.software.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpTool {
    private static Log log = LogFactory.getLog(HttpTool.class);
    private HttpTool() {
    }

    public static Map getParameters(HttpServletRequest request, String[] excludeKeys)
    {
    	return getParameters(request, excludeKeys,true);
    }
    
    public static Map getParameters(HttpServletRequest request, String[] excludeKeys,boolean hasAllForms)
    {
        java.util.Enumeration keys = request.getParameterNames();
        Map rtn = new HashMap();
        Arrays.sort(excludeKeys);
        for (; keys.hasMoreElements(); ) {
            String name = (String)keys.nextElement();
            if (Arrays.binarySearch(excludeKeys, name) >= 0 || (name.startsWith("_") && name.endsWith("_")))
                continue;
            String value = request.getParameter(name);
            if(name.equals("orderfield") || name.equals("ordertype")){
            	rtn.put(name, value);
            }else if(hasAllForms){
            	rtn.put(name, value);
            }
        }
        return rtn;
    }

    public static Map getQueryParameters(HttpServletRequest request)
    {
        java.util.Enumeration keys = request.getParameterNames();
        Map rtn = new HashMap();
        for (; keys.hasMoreElements(); ) {
            String name = (String)keys.nextElement();
            if (name.startsWith("_") && name.endsWith("_")) {
            	String value ="";
            	if(request.getParameter(name).trim().length()>0)
            		value = urlEncode(request.getParameter(name));//?
                if (value.length() > 0) {
                    rtn.put(name, value);
                }
            }
        }
        return rtn;
    }

    public static void saveParameters(HttpServletRequest request, String key, String[] excludeKeys)
    {
        if (key == null || key.length() == 0) {
            log.debug("key is null");
        }
        Map saveVals = getParameters(request, excludeKeys);
        request.setAttribute(key, saveVals);
        saveVals = getQueryParameters(request);
        request.setAttribute(key + "Query", saveVals);
    }
    
    public static void saveParameters(HttpServletRequest request, String key, String[] excludeKeys,boolean hasAllForms)
    {
        if (key == null || key.length() == 0) {
            log.debug("key is null");
        }
        Map saveVals = getParameters(request, excludeKeys, hasAllForms);
        request.setAttribute(key, saveVals);
        saveVals = getQueryParameters(request);
        request.setAttribute(key + "Query", saveVals);
    }

    public static void saveParameters(HttpServletRequest request, String key)
    {
        saveParameters(request, key, new String[]{});
    }

    public static Map getSavedMap(HttpServletRequest request, String key)
    {
        Map rtn = new HashMap();
        String keys[] = new String[]{key, key + "Query"};
        for (int i = 0; i < keys.length; i ++) {
            Map extparaMap = (Map)request.getAttribute(keys[i]);
            rtn.putAll(extparaMap);
        }
        return rtn;
    }

    public static List getSavedUrl(HttpServletRequest request, String key)
    {
        List rtn = new ArrayList();
        String keys[] = new String[]{key, key + "Query"};
        for (int i = 0; i < keys.length; i ++) {
            Map extparaMap = (Map)request.getAttribute(keys[i]);
            rtn.addAll(getUrl(extparaMap));
        }
        return rtn;
    }

    public static List getUrl(Map extparaMap)
    {
        List urls = new ArrayList();
        if (!extparaMap.isEmpty()) {
            for (Iterator it = extparaMap.entrySet().iterator(); it.hasNext();) {
                Map.Entry item = (Map.Entry)it.next();
                urls.add((String)item.getKey() + "=" + (String)item.getValue());
            }
        }
        return urls;
    }

    public static List getSavedUrlForm(HttpServletRequest request, String key)
    {
        List rtn = new ArrayList();
        String keys[] = new String[]{key, key + "Query"};
        for (int i = 0; i < keys.length; i ++) {
            List urls = new ArrayList();
            List forms = new ArrayList();
            Map extparaMap = (Map)request.getAttribute(keys[i]);
            if (!extparaMap.isEmpty()) {
                for (Iterator it = extparaMap.entrySet().iterator(); it.hasNext();) {
                    Map.Entry item = (Map.Entry)it.next();
                    forms.add("<input type=\"hidden\" name=\"" + (String)item.getKey() + "\" value=\"" + (String)item.getValue() + "\">\n");
                    urls.add((String)item.getKey() + "=" + (String)item.getValue());
                }
            }
            rtn.add(urls);
            rtn.add(forms);
        }
        return rtn;
    }

    public static String getServerPath(HttpServletRequest request)
    {
        String fullpath = request.getRequestURL().toString();
        String contextpath = request.getContextPath();
        String serverpath = fullpath.substring(0, fullpath.indexOf(contextpath));
        return serverpath + contextpath;
    }

    public static Map getOptions(HttpServletRequest request)
    {
        Enumeration names = request.getAttributeNames();
        Map rtn = new HashMap();
        for (;names.hasMoreElements();) {
            String key = (String)names.nextElement();
            if (key.endsWith("options")) {
                rtn.put(key, (List)request.getAttribute(key));
            }
        }
        return rtn;
    }

    public static String getString(Map extparaMap, String paramName, String defaultValue ) {
        String temp = (String)extparaMap.get(paramName);
        if( temp != null ) {
            return temp;
        } else {
            return defaultValue;
        }
    }

    public static int getInt(Map extparaMap, String paramName, int defaultValue ) {
        String temp = (String)extparaMap.get(paramName);
        if( temp != null && !temp.equals("") ) {
            return StrTool.toInt(temp);
        } else {
            return defaultValue;
        }
    }
    public static String urlEncode(String urlpar){
    	return URLEncoder.encode(urlpar).replaceAll("%","XX");
    }
    public static String urlDecode(String urlpar){
    	return URLDecoder.decode(urlpar.replaceAll("XX","%"));
    }

}
