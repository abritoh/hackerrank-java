import java.io.*;
import java.util.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class Solution {

    public static void main(String[] args) {
        try(Scanner scan = new Scanner(System.in)) {
            String str = scan.nextLine();
            if( str.length() >=1 && str.length() <= 4 * Math.pow(10, 5) ) {
                String[] tokens = str.split("[^A-Za-z]+");                
                List<String> listTokens = new ArrayList<String>();
                for(String token : tokens) {
                    token = token.trim();
                    if (!token.isEmpty()) {
                        listTokens.add(token);
                    }
                }
                
                System.out.println(listTokens.size());
                for(String t : listTokens) {
                    System.out.println( t );    
                }                
            }
        }        
    }
}
