package com.bbva.pibee.rest.util;

import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import com.bbva.pibee.aop.LogNetCashMovil;
public class EncryptAesCMC {
	private final String secretKey = "1111111111111111";
	private String encryptedString = "";

   


    public String encrypt(String idCuenta) throws Exception {
    	 try {
    	        MessageDigest md = MessageDigest.getInstance("MD5");
    	        byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
    	        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
    	        SecretKey key = new SecretKeySpec(keyBytes, "DESede");
    	        Cipher cipher = Cipher.getInstance("DESede");
    	        cipher.init(Cipher.ENCRYPT_MODE, key);
    	        byte[] plainTextBytes = idCuenta.getBytes("utf-8");
    	        byte[] buf = cipher.doFinal(plainTextBytes);
    	        encryptedString=DatatypeConverter.printHexBinary(buf);
    	    } catch (Exception ex) {
    	    	LogNetCashMovil.logErrorPibee("Error al encriptar id cuenta "+idCuenta);
    	    }
    	    return encryptedString;
    }

    public  String decrypt(String idCuenta) throws Exception {
    	try {
    		byte[] message=DatatypeConverter.parseHexBinary(idCuenta);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);
            byte[] plainText = decipher.doFinal(message);
            encryptedString = new String(plainText, "UTF-8");

        } catch (Exception ex) {
        	LogNetCashMovil.logErrorPibee("Error al decrypt id cuenta "+idCuenta);
        }
        return encryptedString;
    }
    
    
   

 
}
