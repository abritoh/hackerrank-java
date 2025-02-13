import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class Solution {
    private static MessageDigest _md = null;    
    static {
        try {
            _md = MessageDigest.getInstance("MD5");
        } catch(NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }    
    public static String getMD5(String s) {
        _md.update(s.getBytes());
        byte[] hashBytes = _md.digest();
        StringBuilder hexStr = new StringBuilder();
        for(byte b : hashBytes) {
            hexStr.append(String.format("%02x",b));
        }        
        return hexStr.toString();
    }    
    public static void main(String[] args) {
                try(Scanner scan = new Scanner(System.in)) {
            String md5 = getMD5(scan.nextLine());
            System.out.println(md5);
        }
    }
}