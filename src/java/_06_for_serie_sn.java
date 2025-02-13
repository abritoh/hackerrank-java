import java.util.*;
import java.io.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class _06_for_serie_sn {

    private static void printSerie(int a, int b, int n) {
        int sn = 0;
        for(int k=1; k<=n; k++) {
            sn = a;
            for(int i=1; i<=k; i++) {
                sn = sn + (int)Math.pow(2, (i-1) ) * b;
            }            
            System.out.printf("%d", sn);
            if(k < n) System.out.printf(" ");
        }
        System.out.printf("\n");
    }
    
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            if ( !(0<=a && a<=50) && !(0<=b && b<=50) ) {
                System.out.println("Unsatisfied condition: (0 <= a,b <=50)");
                break;
            }
            
            if ( !(1<=n && n <=15) ) {
                System.out.println("Unsatisfied condition: (1 <= n <=15)");
                break;
            }
            //         5  3  5
            printSerie(a, b, n);
        }
        in.close();
    }
}

