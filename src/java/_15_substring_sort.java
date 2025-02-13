import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        
        int[] intArray = s.chars().map(c -> (char)c).toArray();
        List<String> listSubs = new ArrayList<String>();

        //--welcometojava 3
        //--0123456789012 13 : 13-3 = 10
        //--01234567890xx
        for(int i=0; i <= intArray.length-k; i++ ) {
            String sub = s.substring(i, i+k); //-- last-substring: 10 al (10+3-1): 10,11,12
            listSubs.add(sub);
        }

        Collections.sort(listSubs);
        String smallest = listSubs.get(0);
        String largest = listSubs.get(listSubs.size()-1);
        
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();      
        System.out.println(getSmallestAndLargest(s, k));
    }
}