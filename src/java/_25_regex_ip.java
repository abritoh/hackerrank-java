import java.io.*;
import java.util.*;
import java.util.regex.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
class MyRegex {
    //-- IP address is a string in the form "A.B.C.D", 
    //-- where the value of A, B, C, and D may range from 0 to 255. 
    //-- Leading zeros are allowed.
    //-- The length of A, B, C, or D can't be greater than 3.    
    //-- REGEX-PATTERN: 
    //--    0{0,2}[0-9]: Matches numbers from 0 to 9 with up to 2 leading zeros (e.g., 0, 00, 000).
    //--    0?[0-9]{2}: Matches numbers from 0 to 99 with an optional leading zero (e.g., 01, 12, 99).
    //--    1[0-9]{2}: Matches numbers from 100 to 199.
    //--    2[0-4][0-9]: Matches numbers from 200 to 249.
    //--    25[0-5]: Matches numbers from 250 to 255.
    //--    (\\.(0{0,2}[0-9]|0?[0-9]{2}|1[0-9]{2}|2[0-4][0-9]|25[0-5])){3}: Matches a dot followed by a number (0-255), repeated exactly 3 times.
    //--    ^ and $: Ensure the entire string is matched, not just a substring.
    private String regexIP = "^(0{0,2}[0-9]|0?[0-9]{2}|1[0-9]{2}|2[0-4][0-9]|25[0-5])(\\.(0{0,2}[0-9]|0?[0-9]{2}|1[0-9]{2}|2[0-4][0-9]|25[0-5])){3}$";
    private Pattern patternIP = null;
    
    public MyRegex() {
        patternIP = Pattern.compile(regexIP);
     }
    
    public boolean validateIP(String ip) {
        Matcher matcher = patternIP.matcher(ip);
        return matcher.matches();
    }
}

public class Solution {
    public static void main(String[] args) {
        MyRegex myregex = new MyRegex();
        try(Scanner scan = new Scanner(System.in)) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                System.out.println(myregex.validateIP(line));
            }
        }
    }
}
