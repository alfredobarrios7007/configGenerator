/**
 * 
 */
package com.koatchy.configGenerator.tools;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author alfredo.barrios
 *
 */
public class EncryptUtil {

	  // Secret key
	  private static SecretKeySpec SecretKey;
	  private static byte[] key;  
	    
	  public static void secretKey(String myKey){
	     if(myKey.length()==15)
	     {
	    	 myKey = myKey.substring(9, 14) + "SM" + myKey.substring(3, 5);
	     }
	     MessageDigest sha = null;
	     try {
	         key = myKey.getBytes("UTF-8");
	         sha = MessageDigest.getInstance("SHA-1");
	         key = sha.digest(key);
	         key = Arrays.copyOf(key, 16); 
	         SecretKey = new SecretKeySpec(key, "AES");
	     } 
	     catch (NoSuchAlgorithmException e) {
	         e.printStackTrace();
	     } 
	     catch (UnsupportedEncodingException e) {
	         e.printStackTrace();
	     }
	  }
	  

	  /**
	   * Encodes with AES "AES/CBC/PKCS5PADDING" algoritm. Generates the IV vector randomly and includes
	   * it inside the encrypted message. To get keyspec of proper length (256 bit) it is used hashing
	   * algorithm against string key, that can be of any length.
	   *
	   * @param key A secret key used to encode/decode
	   * @param toEncrypt string we are going to encrypt
	   * @return encrypted string.
	   */
	  public static String encode(String secretKey, String strToEncrypt) {
		  try
	      {
			  secretKey(secretKey);
			  Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	          cipher.init(Cipher.ENCRYPT_MODE, SecretKey);
	          return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
	      } 
	      catch (Exception e) 
	      {
	          System.out.println("Error while encrypting: " + e.toString());
	      }
	      return null;
	   }

	  /**
	   * Decodes with AES "AES/CBC/PKCS5PADDING" algoritm As encrypted string contains both encrypted
	   * bytes and initVector, firstly algoritm splits this values.
	   *
	   * @param key A secret key used to encode/decode
	   * @param toDecrypt - a string that was encrypted.
	   * @return decrypted String
	   */
	  public static String decode(String secretKey, String strToDecrypt) {
	      try
	      {
			  secretKey(secretKey);
	          Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
	          cipher.init(Cipher.DECRYPT_MODE, SecretKey);
	          return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
	      } 
	      catch (Exception e) 
	      {
	          System.out.println("Error while decrypting: " + e.toString());
	      }
	      return null;
	   }
	}