import java.io.*;
import java.lang.reflect.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
class Add {
    public void add(int... nums) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sb.append(nums[i]);
            sb.append(
                (i < nums.length - 1) ? "+" : "=".concat(String.valueOf(sum)));
        }
        System.out.println(sb.toString());
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
            int n6 = Integer.parseInt(br.readLine());

            Add ob = new Add();
            ob.add(n1, n2);
            ob.add(n1, n2, n3);
            ob.add(n1, n2, n3, n4, n5);
            ob.add(n1, n2, n3, n4, n5, n6);

            Method[] methods = Add.class.getDeclaredMethods();
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
            e.printStackTrace();
        }
    }
}
