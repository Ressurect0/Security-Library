/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf.commonpoint;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sanjeet Singh R
 */
public class CPValidate {
    private static int CPValidate(String rawText, String type)
    {
        int statusCode;
        /* 0-Bad Input
           1-Valid
           2-Invalid type */ 
        Matcher matcher;
        Pattern pattern = null;
        switch(type)
        {
            case "username": pattern=Pattern.compile("^[a-zA-Z0-9-_]{6,15}$");break;
            case "person-name": pattern=Pattern.compile("^[a-zA-Z]+(([',.- ][a-zA-Z ])?[a-zA-Z]*)*$");break;
            case "email" : pattern=Pattern.compile("^[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@"
                +"[a-zA-Z0-9-]+(\\.[a-zA-Z0-9]+)*(\\.[a-zA-z]{2,})$");break;
            case "password": pattern=Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A_Z]).{4,8}$");break;
            case "phone-number":pattern=Pattern.compile("^[0-9]{10}$");break;
            //Jeff Ichnowski(author of the OWASP Java Encoder Project) alternate Code ?
            case "URL": pattern=Pattern.compile("^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$");
            default: break;
        }
        if(pattern!=null)
        {
            matcher=pattern.matcher(rawText);
            if(matcher.matches())
                statusCode=1;
            else statusCode=0;
        }
        else statusCode=2;
        return statusCode;
    }
    
}
