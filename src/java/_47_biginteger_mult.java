import java.io.*;
import java.util.*;
import java.math.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class Solution {    
    private static final PrintStream out = System.out;
    public static void main(String[] args) {        
        try(Scanner scan = new Scanner(System.in)){
            BigInteger a = scan.nextBigInteger();
            BigInteger b = scan.nextBigInteger();
            
            out.printf("%d\n", a.add(b));
            out.printf("%d\n", a.multiply(b));
        }
    }
}