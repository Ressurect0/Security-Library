/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf.commonpoint;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cf.commonpoint.cputility.XMLParser;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Sanjeet Singh R
 */
public class CPFilter {
    private static void redirect(String indicator,HttpServletRequest request,HttpServletResponse response) throws IOException, ParserConfigurationException, SAXException
    {
        switch(indicator)
        {
            case "https":   
                            String serverName=request.getServerName();
                            String requestURI=request.getRequestURI();
                            response.sendRedirect("https://"+serverName+requestURI);
            case "login":
                            String uri="C:\\Security-Framework\\SecurityFramework\\src\\cf\\commonpoint\\config\\cpconfig.xml";
                            String node="login-page";
                            String redirectURI=XMLParser.getNodeValue(uri, node);
                            response.sendRedirect(redirectURI);
                
        }
        
    }
    
}
