/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf.commonpoint;

import cf.commonpoint.cputility.XMLParser;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
/***
 * This is a more Enriched Class that helps in validating URL's (recommended).
 * A simpler implementation prevails in the CPValidate via Regular Expressions.
 */

/**
 *
 * @author Sanjeet Singh R
 */
public class URLValidate {
    private static int validate(String rawURI) throws URISyntaxException
    {
        //NULL
        if(rawURI==null) return 0;
         //URI SYntax Exception
        try
        {   
            URI uri=new URI(rawURI);
        }
        catch(Exception ex)
        {
            return 0;
        }
        URI uri=new URI(rawURI);
        //Relative URI
        if(!uri.isAbsolute())
            return 0;
        //No Javascript URL's
        if(!("http".equals(uri.getScheme())) && !"https".equals(uri.getScheme()))
            return 0;
        //USER Info must not be present
        if(uri.getUserInfo()!=null)
            return 0;
        //Normalize the URI - to get rid of . and .. path components
        uri.normalize();
        
        //Blacklist Validation
        /***
         * The BlacklistedHosts.xml file contains all the Blacklisted hosts.
         * All the URI's containing those Host Names will be prohibited from input by the user.
         */
        String blackuri="C:\\Security-Framework\\SecurityFramework\\src\\cf\\commonpoint\\config\\BlacklistedHosts.xml";
        int length=0;
        String hostname=uri.getHost();
        try {
            length = XMLParser.getNodeLength(blackuri,"hostname");
            String[] blacklistedHosts=XMLParser.getNodeValues(blackuri, "hostname");
            
            for(int i=0;i<length;i++)
            {
                if(hostname==blacklistedHosts[i])
                    return 0;
            }
        } 
        catch (Exception ex) 
        {}

        uri.getHost();
       return 1; 
    }
    
}
