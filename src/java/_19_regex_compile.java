import java.util.Scanner;
import java.util.regex.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class Solution
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
        int testCases = Integer.parseInt(in.nextLine());
        
		while(testCases > 0) {
            
			String regex = in.nextLine();
            
            try {
          	    Pattern pattern = Pattern.compile(regex);
                System.out.println("Valid");
            } catch(PatternSyntaxException ex) {
                System.out.println("Invalid");
            } 
            testCases--;
		}
	}
}

