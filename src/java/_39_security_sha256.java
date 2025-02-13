import java.util.*;
import java.security.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class Solution {
    private static MessageDigest _md = null;    
    static {
        try {
            _md = MessageDigest.getInstance("SHA-256");
        } catch(NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }    
    public static String getSHA256(String s) {
        byte[] hashBytes = _md.digest(s.getBytes());
        StringBuilder hexStr = new StringBuilder();
        for(byte b : hashBytes) {
            hexStr.append(String.format("%02x",b));
        }        
        return hexStr.toString();
    }    
    public static void main(String[] args) {
        try(Scanner scan = new Scanner(System.in)) {
            String sha256 = getSHA256(scan.nextLine());
            System.out.println(sha256);
        }
    }
}