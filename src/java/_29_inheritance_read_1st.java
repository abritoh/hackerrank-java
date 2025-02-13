import java.io.*;
import java.util.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
class Arithmetic { 
    public int add(int a, int b) { 
        return a + b;
    } 
}
class Adder extends Arithmetic {}

//-- so the purpose of this code is to validate: 
//--    1. how well the instructions are followed
//--    2. attention to the requirements
//--    3. to avoid making assumptions when coding
//--    4. to read the problem 1st instead of coding directly
public class Solution { 
    public static void main(String[] args) { 
        Adder adder = new Adder();
        System.out.println("My superclass is: " + adder.getClass().getSuperclass().getSimpleName());
        System.out.println("42 13 " + adder.add(20, 0));
    } 
}