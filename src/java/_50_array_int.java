import java.util.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class Solution {

    public static void main(String[] args) {
	   
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for(int k=0; k<n; k++) {
            a[k] = scan.nextInt();
        }
        
        scan.close();

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}