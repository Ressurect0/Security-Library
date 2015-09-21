/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf.commonpoint;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sanjeet Singh R
 */
public class CPSession {
    
    /**
     * 
     * @param inactiveInterval - To be specified in Hours for the anonymous session. 
     */
    private static void anonymoizeSession(HttpServletRequest request, int inactiveInterval)
    {
        HttpSession session=request.getSession(false);
        if(session==null)
        {
            session.invalidate();
            session=request.getSession();
        }
        session.setMaxInactiveInterval(inactiveInterval*60*60);
    }
    
    private static byte[] loginUser(String username, String password, HttpServletResponse response) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        secureRequest(response);
        return HashPassword.getHash(password);
                
    }
    private static void secureRequest(HttpServletResponse response )
    {
        /**
         * For using the preload, submit your site to https://hstspreload.appspot.com/ .
         * Note the various requirements for doing so.
         */
        /**
         * max-age=90 Days(7776000 seconds)
         */
        response.setHeader("Strict-Transport-Security", "max-age=7776000;includeSubdomains");
        /**
         * ClickJacking Protection. deny- no rendering within a frame.
         * Meta-tags that attempt to apply the X-Frame-Options directive DO NOT WORK. 
         * For example, <meta http-equiv="X-Frame-Options" content="deny">) will not work. 
         * You must apply the X-FRAME-OPTIONS directive as HTTP Response Header
         */
        response.setHeader("X-Frame-Options","deny");
        /**
         * Cross Site Scripting(XSS) Protection.
         * Note: Stops only some forms of XSS.
         */
        response.setHeader("X-XSS-Protection","1;mode=block");
    }
    
}
