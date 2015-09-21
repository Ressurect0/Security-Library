/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf.commonpoint;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author Sanjeet Singh R
 */
public class HashPassword {
    
    final static int SALT_SIZE=64;
    final static int ITERATION_COUNT=10000;
    final static int KEYLENGTH=64;
    
    public static byte[] getHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        byte[] hash=null;
        byte[] salt = new byte[SALT_SIZE];
        SecureRandom random=new SecureRandom();
        random.nextBytes(salt);
        
        SecretKeyFactory secretKeyFactory=SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        PBEKeySpec pbeKeySpec=new PBEKeySpec(password.toCharArray(), salt, ITERATION_COUNT, KEYLENGTH);
        hash=secretKeyFactory.generateSecret(pbeKeySpec).getEncoded();
        return hash;        
    }
    
}
