import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
//-- odd=impar, even=par
public class _03_if_weird {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();
        boolean is_even = (n%2) == 0;
        
        //--n is even
        if(is_even) {
            if (n>=2 && n<=5 ) {
                System.out.println("Not Weird");    
            } else if (n>=6 && n<=20 ) {
                System.out.println("Weird");
            } else if (n > 20 ) {
                System.out.println("Not Weird");
            } else {
                System.out.println("ZERO");
            }
        }
        //-- n is odd 
        else {
            System.out.println("Weird");
        }
    }
}
