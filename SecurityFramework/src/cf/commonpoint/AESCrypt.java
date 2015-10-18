/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf.commonpoint;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author Sanjeet Singh R
 */
/*
This class is responsible for encrypting and Decrypting textual data with an AES algorithm (64 bits).
*/
public class AESCrypt {
    
    public SecretKey secretKey;
    public byte[] cipherText;
    public String decryptedText;
    
    public AESCrypt(String plainText) throws BadPaddingException, InvalidKeyException, IllegalBlockSizeException, NoSuchAlgorithmException, NoSuchPaddingException
    {
        createSecretKey();   
        encrypt(plainText);
    }
    
    public byte[] createSecretKey() throws NoSuchAlgorithmException
    {
        KeyGenerator keyGenerator= KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        secretKey=keyGenerator.generateKey();
        return secretKey.getEncoded();
    }
    
    public byte[] encrypt(String plainText) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {
        if(secretKey==null)
            createSecretKey();
        
        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        cipherText=cipher.doFinal(plainText.getBytes());
        return cipherText;
    }
    
    public String decrypt(byte[] cipherText) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {
        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE,secretKey);
        decryptedText=new String(cipher.doFinal(cipherText));
        return decryptedText;
        
    }
    
    
}
