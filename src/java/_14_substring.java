import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class Solution {

    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            String S = in.next();
            int start = in.nextInt();
            int end = in.nextInt();
            
            //-- the substring begins at the specified beginIndex 
            //-- and extends to the character at index endIndex - 1
            String sbs = S.substring(start, end);
            
            System.out.println(sbs);
        }
    }
}