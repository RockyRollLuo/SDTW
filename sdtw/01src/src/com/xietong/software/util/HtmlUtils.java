// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   HtmlUtils.java

package com.xietong.software.util;

import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlUtils
{

    private static HashMap m_hmClasses;

    public HtmlUtils()
    {
    }

    public static String htmlSpecialChars(String sHtml)
    {
        if(sHtml == null)
            return sHtml;
        StringBuffer sOutput = new StringBuffer(sHtml);
        for(int nCharPtr = 0; nCharPtr < sOutput.length();)
            if(sOutput.charAt(nCharPtr) == '&')
            {
                sOutput.replace(nCharPtr, nCharPtr + 1, "&amp;");
                nCharPtr += 5;
            } else
            if(sOutput.charAt(nCharPtr) == '"')
            {
                sOutput.replace(nCharPtr, nCharPtr + 1, "&quot;");
                nCharPtr += 6;
            } else
            if(sOutput.charAt(nCharPtr) == '\'')
            {
                sOutput.replace(nCharPtr, nCharPtr + 1, "&#039;");
                nCharPtr += 6;
            } else
            if(sOutput.charAt(nCharPtr) == '<')
            {
                sOutput.replace(nCharPtr, nCharPtr + 1, "&lt;");
                nCharPtr += 4;
            } else
            if(sOutput.charAt(nCharPtr) == '>')
            {
                sOutput.replace(nCharPtr, nCharPtr + 1, "&gt;");
                nCharPtr += 4;
            } else
            {
                nCharPtr++;
            }

        return sOutput.toString();
    }

    public static Method identifyMethod(Class objClass, String sMethod)
        throws ClassNotFoundException, NoSuchMethodException, SecurityException
    {
        Method objMethod = null;
        if(sMethod != null && sMethod.trim().length() > 0)
        {
            int nOpeningParenthesis = sMethod.indexOf('(');
            int nClosingParenthesis = sMethod.indexOf(')');
            if(nOpeningParenthesis >= 0)
            {
                String sMethodName = sMethod.substring(0, nOpeningParenthesis);
                if(nClosingParenthesis > nOpeningParenthesis)
                {
                    Class aobjParamList[] = parseParamList(sMethod.substring(nOpeningParenthesis + 1, nClosingParenthesis));
                    objMethod = objClass.getMethod(sMethodName, aobjParamList);
                } else
                {
                    throw new NoSuchMethodException("Invalid method signature, closing parenthesis not found after opening parenthesis.");
                }
            } else
            {
                throw new NoSuchMethodException("Invalid method signature, opening parenthesis not found.");
            }
        } else
        {
            throw new NoSuchMethodException("The method signature cannot be null.");
        }
        return objMethod;
    }

    private static Class[] parseParamList(String sParamList)
        throws ClassNotFoundException
    {
        ArrayList alClasses = new ArrayList();
        if(sParamList == null || sParamList.trim().length() == 0)
            return castObjectsToClasses(alClasses.toArray());
        Class objClass;
        for(StringTokenizer objStrTokenizer = new StringTokenizer(sParamList, ","); objStrTokenizer.hasMoreTokens(); alClasses.add(objClass))
        {
            String sClassName = objStrTokenizer.nextToken().trim();
            objClass = null;
            objClass = (Class)m_hmClasses.get(sClassName);
            if(objClass == null)
            {
                String sFormattedClassName = sClassName;
                if(sClassName.indexOf('.') == -1)
                    sFormattedClassName = "java.lang" + sClassName;
                if(sFormattedClassName.indexOf("[]") >= 0)
                    sFormattedClassName = "[L" + sFormattedClassName.substring(0, sFormattedClassName.indexOf("[]")) + ";";
                objClass = Class.forName(sFormattedClassName);
            }
        }

        return castObjectsToClasses(alClasses.toArray());
    }

    private static Class[] castObjectsToClasses(Object aobjObjects[])
    {
        Class aobjClasses[] = new Class[aobjObjects.length];
        for(int i = 0; i < aobjObjects.length; i++)
            aobjClasses[i] = (Class)aobjObjects[i];

        return aobjClasses;
    }

    public static Object convertFromString(Class objClass, String sValue)
        throws NumberFormatException, ClassNotFoundException
    {
        Object objConversion = null;
        if(Byte.TYPE.isAssignableFrom(objClass) || Class.forName("java.lang.Byte").isAssignableFrom(objClass))
            objConversion = Byte.valueOf(sValue);
        else
        if(Short.TYPE.isAssignableFrom(objClass) || Class.forName("java.lang.Short").isAssignableFrom(objClass))
            objConversion = Short.valueOf(sValue);
        else
        if(Integer.TYPE.isAssignableFrom(objClass) || Class.forName("java.lang.Integer").isAssignableFrom(objClass))
            objConversion = Integer.valueOf(sValue);
        else
        if(Long.TYPE.isAssignableFrom(objClass) || Class.forName("java.lang.Long").isAssignableFrom(objClass))
            objConversion = Long.valueOf(sValue);
        else
        if(Float.TYPE.isAssignableFrom(objClass) || Class.forName("java.lang.Float").isAssignableFrom(objClass))
            objConversion = Float.valueOf(sValue);
        else
        if(Double.TYPE.isAssignableFrom(objClass) || Class.forName("java.lang.Double").isAssignableFrom(objClass))
            objConversion = Double.valueOf(sValue);
        else
        if(Character.TYPE.isAssignableFrom(objClass) || Class.forName("java.lang.Character").isAssignableFrom(objClass))
            objConversion = new Character(sValue.charAt(0));
        else
        if(Boolean.TYPE.isAssignableFrom(objClass) || Class.forName("java.lang.Boolean").isAssignableFrom(objClass))
            objConversion = Boolean.valueOf(sValue);
        return objConversion;
    }

    public static Object convertFromStrings(Class objClass, String asValue[])
        throws NumberFormatException, ClassNotFoundException
    {
        Object objConversion = null;
        if(Class.forName("[B").isAssignableFrom(objClass) || Class.forName("[Ljava.lang.Byte;").isAssignableFrom(objClass))
        {
            Byte abConversion[] = new Byte[asValue.length];
            for(int i = 0; i < asValue.length; i++)
                abConversion[i] = Byte.valueOf(asValue[i]);

            objConversion = abConversion;
        } else
        if(Class.forName("[S").isAssignableFrom(objClass) || Class.forName("[Ljava.lang.Short;").isAssignableFrom(objClass))
        {
            Short asConversion[] = new Short[asValue.length];
            for(int i = 0; i < asValue.length; i++)
                asConversion[i] = Short.valueOf(asValue[i]);

            objConversion = asConversion;
        } else
        if(Class.forName("[I").isAssignableFrom(objClass) || Class.forName("[Ljava.lang.Integer;").isAssignableFrom(objClass))
        {
            Integer anConversion[] = new Integer[asValue.length];
            for(int i = 0; i < asValue.length; i++)
                anConversion[i] = Integer.valueOf(asValue[i]);

            objConversion = anConversion;
        } else
        if(Class.forName("[J").isAssignableFrom(objClass) || Class.forName("[Ljava.lang.Long;").isAssignableFrom(objClass))
        {
            Long alConversion[] = new Long[asValue.length];
            for(int i = 0; i < asValue.length; i++)
                alConversion[i] = Long.valueOf(asValue[i]);

            objConversion = alConversion;
        } else
        if(Class.forName("[F").isAssignableFrom(objClass) || Class.forName("[Ljava.lang.Float;").isAssignableFrom(objClass))
        {
            Float afConversion[] = new Float[asValue.length];
            for(int i = 0; i < asValue.length; i++)
                afConversion[i] = Float.valueOf(asValue[i]);

            objConversion = afConversion;
        } else
        if(Class.forName("[D").isAssignableFrom(objClass) || Class.forName("[Ljava.lang.Double;").isAssignableFrom(objClass))
        {
            Double adConversion[] = new Double[asValue.length];
            for(int i = 0; i < asValue.length; i++)
                adConversion[i] = Double.valueOf(asValue[i]);

            objConversion = adConversion;
        } else
        if(Class.forName("[C").isAssignableFrom(objClass) || Class.forName("[Ljava.lang.Character;").isAssignableFrom(objClass))
        {
            Character acConversion[] = new Character[asValue.length];
            for(int i = 0; i < asValue.length; i++)
                acConversion[i] = new Character(asValue[i].charAt(0));

            objConversion = acConversion;
        } else
        if(Class.forName("[Z").isAssignableFrom(objClass) || Class.forName("[Ljava.lang.Boolean;").isAssignableFrom(objClass))
        {
            Boolean abConversion[] = new Boolean[asValue.length];
            for(int i = 0; i < asValue.length; i++)
                abConversion[i] = Boolean.valueOf(asValue[i]);

            objConversion = abConversion;
        }
        return objConversion;
    }

    static 
    {
        m_hmClasses = new HashMap();
        m_hmClasses.put("byte", Byte.TYPE);
        m_hmClasses.put("short", Short.TYPE);
        m_hmClasses.put("int", Integer.TYPE);
        m_hmClasses.put("long", Long.TYPE);
        m_hmClasses.put("float", Float.TYPE);
        m_hmClasses.put("double", Double.TYPE);
        m_hmClasses.put("char", Character.TYPE);
        m_hmClasses.put("boolean", Boolean.TYPE);
        try
        {
            m_hmClasses.put("byte[]", Class.forName("[B"));
            m_hmClasses.put("short[]", Class.forName("[S"));
            m_hmClasses.put("int[]", Class.forName("[I"));
            m_hmClasses.put("long[]", Class.forName("[J"));
            m_hmClasses.put("float[]", Class.forName("[F"));
            m_hmClasses.put("double[]", Class.forName("[D"));
            m_hmClasses.put("char[]", Class.forName("[C"));
            m_hmClasses.put("boolean[]", Class.forName("[Z"));
            m_hmClasses.put("String[]", Class.forName("[Ljava.lang.String;"));
            m_hmClasses.put("String", Class.forName("java.lang.String"));
        }
        catch(ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }
    }
    public static String Html2Text(String inputString) {
		String htmlStr = inputString; //含html标签的字符串
		
		htmlStr = htmlStr.replaceAll("<br />", "\n");
		htmlStr = htmlStr.replaceAll("<br >", "\n");
		htmlStr = htmlStr.replaceAll("<br/>", "\n");
		htmlStr = htmlStr.replaceAll("<br>", "\n");
		htmlStr = htmlStr.replaceAll("&nbsp;", " ");
		htmlStr = htmlStr.replace("<p>", "\n");
		htmlStr = htmlStr.replace("</p>", "\n");
    	
        String textStr ="";
        Pattern p_script;
     	Matcher m_script;
     	Pattern p_style;
     	Matcher m_style;
     	Pattern p_html;
      	Matcher m_html;
      	try {
      		String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script> }
      		String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style> }
      		String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式
     
      		p_script = Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
      		m_script = p_script.matcher(htmlStr);
      		htmlStr = m_script.replaceAll(""); //过滤script标签

      		p_style = Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
      		m_style = p_style.matcher(htmlStr);
      		htmlStr = m_style.replaceAll(""); //过滤style标签
     
      		p_html = Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
      		m_html = p_html.matcher(htmlStr);
      		htmlStr = m_html.replaceAll(""); //过滤html标签
     
      		/*htmlStr = htmlStr.replace("&nbsp;", "");//过滤空格
      		textStr = htmlStr;*/
      	}catch(Exception e) {
      		System.err.println("Html2Text: " + e.getMessage());
	    }
      	return htmlStr;//返回文本字符串
	}  
}
