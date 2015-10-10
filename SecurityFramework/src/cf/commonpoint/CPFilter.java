/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf.commonpoint;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sanjeet Singh R
 */
public class CPFilter {
    private static void redirect(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
        String serverName=request.getServerName();
        String requestURI=request.getRequestURI();
        response.sendRedirect("https://"+serverName+requestURI);
    }
    
}
