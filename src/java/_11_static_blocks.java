import java.io.*;
import java.util.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class _11_static_blocks {
    
    private static int B, H, C;
    
    static {
        B=0;
        H=0;
        C=0;
    }

    public static void main(String[] args) throws Exception {
        
        Scanner scan = new Scanner(System.in);
        
        B = scan.nextInt();
        H = scan.nextInt();
        scan.close();
        
        if( B<=0 || H<=0 ) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        } else {        
            C = B * H;
            System.out.printf("%d", C);
        }
    }
}