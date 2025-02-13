import java.io.*;
import java.math.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class Solution {
    private static final String PRIME = "prime", NOT_PRIME = "not prime";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));
        String n = bufferedReader.readLine();
        try {
            BigInteger number = new BigInteger(n);
            System.out.println(number.isProbablePrime(1) ? PRIME : NOT_PRIME);
        } catch (NumberFormatException ex) {
            System.out.println(NOT_PRIME);
        }
        bufferedReader.close();
    }
}
