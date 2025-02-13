# Java Challenge-14

Given a string, , and two indices,  and , print a substring consisting of all characters in the inclusive range from  to . You'll find the String class' substring method helpful in completing this challenge.

Input Format

The first line contains a single string denoting .
The second line contains two space-separated integers denoting the respective values of  and .

Constraints

String  consists of English alphabetic letters (i.e., ) only.
Output Format

Print the substring in the inclusive range from  to .

Sample Input

Helloworld
3 7
Sample Output

lowo
Explanation

In the diagram below, the substring is highlighted in green:

substring.png

Language
Java 7
More
1234567891011121319181415161720
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            String S = in.next();
            int start = in.nextInt();
            int end = in.nextInt();
            
            String sbs = S.substring(start, end);
            
            System.out.println(sbs);
        }
    }
}
Line: 1 Col: 1

Test against custom input
Java
You have earned 5.00 points!
You are now 22 points away from the 4th star for your java badge.
69%128/150
Congratulations
You solved this challenge. Would you like to challenge your friends?Share on FacebookShare on TwitterShare on LinkedIn

Test case 0

Test case 1

Test case 2

Test case 3

Test case 4

Test case 5
Compiler Message
Success
Input (stdin)
Helloworld
3 7
Expected Output
lowo

## Documentation
- https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#substring-int-int-

``` java
substring
public String substring(int beginIndex,
                        int endIndex)
Returns a string that is a substring of this string. The substring begins at the specified beginIndex and extends to the character at index endIndex - 1. Thus the length of the substring is endIndex-beginIndex.
Examples:

 "hamburger".substring(4, 8) returns "urge"
 "smiles".substring(1, 5) returns "mile"
 
Parameters:
beginIndex - the beginning index, inclusive.
endIndex - the ending index, exclusive.
Returns:
the specified substring.
Throws:
Ind
```
