import java.io.*;
import java.util.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class Solution {
    
    private static boolean palindrome (String str) {
        if( str == null) return false;
        int len = str.length();
        if(len==0) return true;
        
        int middle = (len/2);
        for(int i=0, j=len-1; i<=middle; i++, j--) {
            if ( !Character.isLetter(str.charAt(i) ) ) return false;
            if ( (str.charAt(i) != str.charAt(j)) ) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)) {
            String A = sc.next();        
            System.out.println(palindrome (A) ? "Yes" : "No");
        }
    }
}