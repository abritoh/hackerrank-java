import java.util.Scanner;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class Solution {

    public static void main(String[] args) {
        
        try(Scanner scan = new Scanner(System.in)) {
            int i = scan.nextInt();
            double d = scan.nextDouble();
            
            //-- skips the empty-cr-line due to prevous non-string input
            scan.nextLine(); 
            String s = scan.nextLine();

            System.out.println("String: " + s);
            System.out.println("Double: " + d);
            System.out.println("Int: " + i);
        }
    }
}
