import java.util.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class Solution {
    
    private static List<String> getArrayFromStr(String str) {
        str = str.toUpperCase();
        List<String> result = new ArrayList<>();
        for(int i=0; i<str.length(); i++) {
            result.add( String.valueOf( str.charAt(i) ) );
        }
        return result;
    }

    private static boolean isAnagram(String a, String b) {
        List<String> lsta = getArrayFromStr(a);
        List<String> lstb = getArrayFromStr(b);
        
        Collections.sort(lsta);
        Collections.sort(lstb);
        
        if (lsta.size() != lstb.size()) return false;
        return lsta.equals(lstb);
    }

  public static void main(String[] args) {    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}

