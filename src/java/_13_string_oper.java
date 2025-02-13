import java.io.*;
import java.util.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class Solution {

    public static void main(String[] args) {
        try( Scanner scan = new Scanner(System.in) ) {
            String A = scan.nextLine();
            String B = scan.nextLine();
            int sumLength = A.length() + B.length();
            String isAGtB = A.toUpperCase().charAt(0) > B.toUpperCase().charAt(0) ? "Yes" : "No"; 
            String titleA = String.valueOf(A.toUpperCase().charAt(0)) + A.substring(1);
            String titleB = String.valueOf(B.toUpperCase().charAt(0)) + B.substring(1);
            System.out.printf("%d\n%s\n%s %s", sumLength, isAGtB, titleA, titleB);
        }
    }
}