import java.util.*;
import java.io.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class _07_int_primitives {

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
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        for(int i=0;i<t;i++)
        {
            try {
                long x = sc.nextLong();

                System.out.println(x + " can be fitted in:");

                if(x>= -128    &&   x <= 127) System.out.println("* byte");
                if(x>= -32768  &&   x <= 32767) System.out.println("* short");
                if(x>= -1*Math.pow(2,31)   &&   x <= (Math.pow(2,31)-1) ) System.out.println("* int");
                if(x>= -1*Math.pow(2,63)   &&   x <= (Math.pow(2,63)-1) ) System.out.println("* long"); 
            }
            catch(Exception e) {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }
        }
        sc.close();
    }
}

