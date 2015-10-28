/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf.commonpoint.cputility;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Sanjeet Singh R
 */
public class XMLParser {
    
    public static int getNodeLength(String uri, String node) throws SAXException, IOException, ParserConfigurationException
    {
        String nodeValue=null;
        DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
        Document document=documentBuilder.parse(uri);
        
        Element rootElement=document.getDocumentElement();
        NodeList nodeList=rootElement.getElementsByTagName(node);
        return nodeList.getLength();
    }
    
    public static String getNodeValue(String uri, String node) throws ParserConfigurationException, SAXException, IOException
    {
        String nodeValue=null;
        DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
        Document document=documentBuilder.parse(uri);
        
        Element rootElement=document.getDocumentElement();
        NodeList nodeList=rootElement.getElementsByTagName(node);
        
        Element sampleElement=(Element)nodeList.item(0);
        return(sampleElement.getFirstChild().getNodeValue());

    }
    public static String[] getNodeValues(String uri, String node) throws ParserConfigurationException, SAXException, IOException
    {
        String nodeValue=null;
        DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
        Document document=documentBuilder.parse(uri);
        
        Element rootElement=document.getDocumentElement();
        NodeList nodeList=rootElement.getElementsByTagName(node);
        Element sampleElement;
        
        
        String[] elementValues=new String[nodeList.getLength()];
        for(int i=0;i<nodeList.getLength();i++)
        {
            sampleElement=(Element)nodeList.item(i);
            elementValues[i]=sampleElement.getFirstChild().getNodeValue();
        }
        
        return(elementValues);

    }
}
