package Cryptography;

import java.security.KeyStore.SecretKeyEntry;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;


public class MacSimple {

    public static void main(String[] args) throws Exception {

        // Generate secret key for HMAC-MD5
        //KeyGenerator kg = KeyGenerator.getInstance("HmacMD5");
        //SecretKey sk = kg.generateKey(); //random key always

    	SecretKeySpec key = new SecretKeySpec("mykey".getBytes(), "HmacMD5");
    	
        // Get instance of Mac object implementing HMAC-MD5, and
        // initialize it with the above secret key
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(key);
        byte[] result = mac.doFinal("Hi There".getBytes());
        System.out.println(DatatypeConverter.printBase64Binary(result));
        
    }
}
