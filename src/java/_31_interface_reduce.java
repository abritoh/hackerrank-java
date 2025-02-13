import java.io.*;
import java.util.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
interface AdvancedArithmetic {
    int divisor_sum(int n);
}

class MyCalculator implements AdvancedArithmetic {
    public MyCalculator() {
        System.out.println("I implemented: " + AdvancedArithmetic.class.getSimpleName() );
    }    
    public int divisor_sum(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i=1; i<=n; i++){
            if( (n%i) == 0) {
                divisors.add(i);
            }
        }
        return divisors.stream().reduce(0, (x, y) -> x + y);
    }
}

public class Solution {
    public static void main(String[] args) {
        AdvancedArithmetic notSuch = new MyCalculator();
        try(Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();
            System.out.println(notSuch.divisor_sum(n));
        }
    }
}