import java.util.*;
import java.text.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class _09_number_format {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double pay = scanner.nextDouble();
        scanner.close();
        
        NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat india = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);
                
        System.out.println("US: " + us.format(pay) );
        System.out.println("India: " + india.format(pay) );
        System.out.println("China: " + china.format(pay) );
        System.out.println("France: " + france.format(pay) );
    }
}