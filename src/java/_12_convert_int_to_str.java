import java.io.*;
import java.util.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class _12_convert_int_to_str {

    public static void main(String[] args) {
        
        try(Scanner scan = new Scanner(System.in)) {
            
            int n = scan.nextInt();
            
            String s = String.valueOf(n);
            
            if(n>=-100 && n<=100) {
                System.out.println("Good job");
            } else {
                System.out.println("Wrong answer");    
            }
            
        } catch(Exception ex) {
            System.out.println("Wrong answer");
        }
        
    }
}