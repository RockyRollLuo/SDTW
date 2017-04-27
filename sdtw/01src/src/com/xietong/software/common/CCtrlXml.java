// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   CCtrlXml.java

package com.xietong.software.common;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class CCtrlXml
{

    public CCtrlXml()
    {
    }

    public void lwrite(String filepath, String curnode, String content)
        throws IOException, SAXException, ParserConfigurationException, TransformerException
    {
        DocumentBuilderFactory factory2 = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder2 = factory2.newDocumentBuilder();
        Document doc2 = builder2.parse(filepath);
        doc2.normalize();
        Element node = doc2.createElement(curnode);
        org.w3c.dom.Text textseg2 = doc2.createTextNode("/<" + content);
        node.appendChild(textseg2);
        doc2.getDocumentElement().appendChild(node);
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        Properties properties = transformer.getOutputProperties();
        properties.setProperty("encoding", "GB2312");
        transformer.setOutputProperties(properties);
        DOMSource source = new DOMSource(doc2);
        StreamResult result = new StreamResult(new File(filepath));
        transformer.transform(source, result);
    }

    public String lwrite(String filepath, String curnode, String content, String rootcontent)
    {
        rootcontent = rootcontent + "\n" + "<" + curnode + ">" + content + "</" + curnode + ">";
        return rootcontent;
    }
}
