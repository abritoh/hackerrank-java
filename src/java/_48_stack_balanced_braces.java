import java.util.*;
import java.util.Stack;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
class Solution {
    //-- uses a stack-DS: Last In, First out (LIFO)
    //-- push any opening-brace (ob) to the stack
    //-- if a closing brace-found (cb) 
    //-- pops the last opening-brace from the stack
    //-- this last-ob must match the cb 
    //-- if not match return false (not-balanced)
    //-- continue until stack empty or no more matchs found
    //-- the final stack must be empty if input-line is balanced
    private static boolean isBalanced(String line) {
        
        char[] array = line.toCharArray();
        Stack<String> stack = new Stack<String>();
        
        for(char symbol: array) {
            String CB = String.valueOf(symbol);
            //-- if opening-brace push to stack
            if ("{[(".contains(CB)) stack.push(CB);
            else if ("}])".contains(CB)) {
                //-- unbalanced closing-brace
                if(stack.isEmpty()) return false;
                String lastOB = stack.pop();
                //-- check if the current Closing-Brace symbol
                //-- matchs with the last Opening-Brace in the stack
                if(lastOB.equals("{") && !CB.equals("}")) return false;
                if(lastOB.equals("[") && !CB.equals("]")) return false;
                if(lastOB.equals("(") && !CB.equals(")")) return false;                
            }
        }
        //-- when no more symbols to process, 
        //-- the stack must be empty to be balanced
        return stack.empty();
    }
    
    public static void main(String []argh) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (sc.hasNext()) {
            String input = sc.next();
            list.add(input);
        }
        for(String input : list) {
            System.out.println(isBalanced(input));
        }
    }
}
