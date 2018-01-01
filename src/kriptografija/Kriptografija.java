package kriptografija;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Kriptografija {
    
    private static String getHashValue(String message, String algorithm) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] sha256 = md.digest(message.getBytes());
            byte[] base64 = Base64.getEncoder().encode(sha256);
            return new String(base64);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Kriptografija.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static String getSHA256(String message) { return getHashValue(message, "SHA-256"); }
    public static String getSHA1(String message)   { return getHashValue(message, "SHA-1");   }
    public static String getMD5(String message)    { return getHashValue(message, "MD5");     }
    
}
