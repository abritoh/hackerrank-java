import java.util.Scanner;
import java.lang.StringBuilder;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class _04_printf_format {
    
    private static String rightPadString(String str, int maxLength, String padChar) {
        StringBuilder result = new StringBuilder(str);
        for(int i=0; i < (maxLength - str.length()); i++ ) {
            result.append( padChar.charAt(0) );
        }
        return result.toString();
    }

    private static String leftpadString(String str, int maxLength, String padChar) {
        StringBuilder result = new StringBuilder();
        for(int i=0; i < (maxLength - str.length()); i++ ) {
            result.append( padChar.charAt(0) );
        }
        result.append(str);
        return result.toString();
    }

    private static void solution1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for(int i=0; i<3; i++) {
            
            String s1 = sc.next();
            int n = sc.nextInt();
            
            s1 = rightPadString(s1, 15, " ");
            String s2 = leftpadString(String.valueOf(n), 3, "0");
            
            System.out.printf("%s%s\n", s1, s2);
        }
        
        System.out.println("================================");
        sc.close();
    }
    
    private static void solution2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for(int i=0; i<3; i++) {
            
            String s1 = sc.next();
            int n = sc.nextInt();
            //-- --------------------------------------------------
            //-- %-15s:
            //-- s: format for a string.
            //-- -: left-justifies the string.
            //-- 15: ensures the string is at least 15 characters wide.
            //--     if the string is shorter than 15 characters, it will be padded with spaces on the right.
            //-- %03d:
            //-- d: format for an integer.
            //-- 03: ensures the integer is at least 3 digits wide, padded with zeros on the left if necessary.
            //-- --------------------------------------------------
            System.out.printf("%-15s%03d\n", s1, n);
        }
        System.out.println("================================");
        sc.close();
    }

    public static void main(String[] args) {
        solution1();
        //--solution2();
    }
}



