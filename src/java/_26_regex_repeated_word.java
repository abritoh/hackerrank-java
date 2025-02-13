import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
//-- The code is correct, review your tests or 
//-- provide detail about what the test-expects.
//-- ArBR | 202501-30
public class DuplicateWords_template_java7 {
    public static void main(String[] args) {
        String regex = "\\b(\\w+)(\\s+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());
        while (numSentences-- > 0) {
            String input = in.nextLine();
            Matcher m = p.matcher(input);
            while (m.find()) {
                input = input.replaceAll(m.group(), m.group(1));
            }
            System.out.println(input);
        }
        in.close();
    }
}

//-- The code is correct, review your tests or 
//-- provide detail about what the test-expects.
//-- ArBR | 202501-30
public class DuplicateWords {
    public static void main(String[] args) {
        String regex = "\\b(\\w+)(\\s+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        try(Scanner in = new Scanner(System.in)) {
            int numSentences = Integer.parseInt(in.nextLine());
            while (numSentences-- > 0) {
                String input = in.nextLine();
                Matcher m = p.matcher(input);
                if (!input.isEmpty()) {
                    input = p.matcher(input).replaceAll("$1");
                    System.out.println(input);
                }
            }
        }
    }
}

//-- this version passess completelly all test-cases
//-- just modifying two lines
public class DuplicateWords {

    public static void main(String[] args) {

        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+"; //--line-1
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());
        
        while (numSentences-- > 0) {
            String input = in.nextLine();
            
            Matcher m = p.matcher(input);
            
            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group(), m.group(1)); //--line-2
            }
            
            // Prints the modified sentence.
            System.out.println(input);
        }
        
        in.close();
    }
}

