import java.io.*;
import java.util.*;
import java.util.InputMismatchException;
import java.lang.ArithmeticException;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class Solution {
    private final static PrintStream out = System.out;
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in) ) {
            try {
                int x = in.nextInt();
                int y = in.nextInt();
                int z = x / y;
                out.println(z);
            } catch(InputMismatchException ex1) {
                out.println("java.util.InputMismatchException");
            } catch(ArithmeticException ex2) {
                out.println("java.lang.ArithmeticException: / by zero");
            }
        }
    }
}
