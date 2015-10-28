/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf.commonpoint;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;

/**
 *
 * @author Sanjeet Singh R
 */
public class HTMLSanitizer {
    public static String sanitize(String untrustedHTML)
    {
        PolicyFactory policy=Sanitizers.FORMATTING.and(Sanitizers.LINKS);
        String safeHTML=policy.sanitize(untrustedHTML);
        return safeHTML;
    }
    
}
