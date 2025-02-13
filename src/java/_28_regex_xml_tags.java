import java.io.*;
import java.util.*;
import java.util.regex.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class Solution {
    private static final String NONE = "None";
    public static void main(String[] args) {
        //-- regex explanation:
        //--    < : opening-symbol
        //--    ([^>]+) : group for tag-name (all symbols except ">")
        //--    > : closing-tag
        //--    ([^<]*) : group for content inside the tag any-character(*, except "<")
        //--    </ : closing-tag-symbols
        //--    \\1: backreference to the 1st-group (tag-name)
        //--    > : closing-symbol for the closing-tag
        String regex = "<([^>]+)>([^<]*)</\\1>";
        Pattern pattern = Pattern.compile(regex);
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            scan.nextLine();
            while (n -- > 0) {
                boolean found = false;
                String line = scan.nextLine();
                if (line != null && !line.trim().isEmpty()) {
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        String content = matcher.group(2).trim();
                        if (!content.isEmpty()) {
                            found = true;
                            System.out.println(content);
                        }
                    }
                }
                if (!found) {
                    System.out.println(NONE);
                }
            }
        }
    }
}