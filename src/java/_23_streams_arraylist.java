import java.util.*;
import java.util.stream.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class Solution {

    private static void executeQuery(
        ArrayList<ArrayList<Integer>> arrayN, 
        ArrayList<ArrayList<Integer>> arrayQ) {
        
        for(ArrayList<Integer> listq : arrayQ) {
            try {
                int line = listq.get(0);
                int index = listq.get(1);
                //-- get the line-n and from that line 
                //-- retrieves the element at specified index
                int data = arrayN.get(line-1).get(index);
                System.out.println(data);
            } catch(Exception ex) {
                System.out.println("ERROR!");
            }
        }
    }   
    
    public static void main(String[] args) {
        
        try(Scanner scan = new Scanner(System.in)){
            int n = scan.nextInt();
            scan.nextLine();
            
            ArrayList<ArrayList<Integer>> arrayN = new ArrayList<>();
            for(int i=1; i<=n; i++) {
                String line = scan.nextLine();
                ArrayList<Integer> lineArray = Arrays.stream(line.split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(ArrayList::new));
                arrayN.add(lineArray);
            }
            
            int q = scan.nextInt();
            scan.nextLine();
            
            ArrayList<ArrayList<Integer>> arrayQ = new ArrayList<>();
            for(int k=1; k<=q; k++) {
                String line = scan.nextLine();
                ArrayList<Integer> lineArray = Arrays.stream(line.split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(ArrayList::new));
                arrayQ.add(lineArray);                
            }
            
            executeQuery(arrayN, arrayQ);
        }
    }
}
