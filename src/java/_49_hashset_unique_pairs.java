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
public class _49_hashset_unique_pairs {

    public static void main(String[] args) {
        try(Scanner s = new Scanner(new File("__data/_49_01.txt"))) {
            Scanner s = new Scanner(System.in);
            int t = s.nextInt();
            String [] pair_left = new String[t];
            String [] pair_right = new String[t];
            
            for (int i = 0; i < t; i++) {
                pair_left[i] = s.next();
                pair_right[i] = s.next();
            }

            //-- Write your code here
            Set<Set<String>> uniquePairs = new HashSet<>();
            for(int i=0; i < t; i++) {
                String left = pair_left[i];
                String right = pair_right[i];
                
                Set<String> pair = new HashSet<>();
                pair.add(left);
                pair.add(right);
                
                uniquePairs.add(pair);
                System.out.println(uniquePairs.size());
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}