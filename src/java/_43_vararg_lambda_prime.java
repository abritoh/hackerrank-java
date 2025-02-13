import java.io.*;
import java.lang.reflect.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.function.*;
import java.util.regex.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
class Prime {
    public void checkPrime(int... nums) {
        StringBuilder sb = new StringBuilder();
        Predicate<Integer> isPrime = x -> {
            if (x <= 1) return false;
            for (int i=2; i<=Math.sqrt(x); i++) if (x%i == 0) return false;
            return true;
        };
        for (int n : nums) if (isPrime.test(n)) sb.append(n).append(" ");
        System.out.println( (sb.length() > 0) ? sb.toString().trim() : "");
    }
}

public class Solution {

    public static void main(String[] args) {
        try {
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());

            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);

            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (int i = 0; i < methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload = true;
                    break;
                }
                set.add(methods[i].getName());
            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
