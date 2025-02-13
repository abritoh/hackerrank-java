import java.util.Scanner;
import java.lang.StringBuilder;
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
public class _05_for_num_mult {

    private static void solution() {
        try( BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)) ) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());
            for(int i=1; i<=10; i++) {
                int r = n * i;
                System.out.printf("%d x %d = %d\n", n, i, r );
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        solution();
    }
}

