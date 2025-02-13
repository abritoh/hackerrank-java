import java.io.*;
import java.util.*;
import java.util.regex.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
//-- The username can only contain alphanumeric characters and underscores (_). 
//-- Alphanumeric characters describe the character set consisting of lowercase characters , uppercase characters , and digits .
//-- The first character of the username must be an alphabetic character, i.e., either lowercase character  or uppercase character .
public class Solution {
    public static final String VALID="Valid", INVALID="Invalid";
    public static void main(String[] args) {
        String regex = "^[a-zA-Z]{1}\\w{7,29}$";
        Pattern pattern = Pattern.compile(regex);
        try(Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            scan.nextLine();
            while(n-- > 0) {
                String username = scan.nextLine();
                Matcher matcher = pattern.matcher(username);
                System.out.println(matcher.matches() ? VALID : INVALID);
            }            
        }
    }
}
