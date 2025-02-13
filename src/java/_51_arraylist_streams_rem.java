import java.util.*;
import java.util.stream.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
//-- ------------------------------------------------------------------------------------------------------
// Stream operations in Java:
// - `anyMatch`: Returns a boolean if any element matches a condition.
//      boolean exists = phoneBook.stream().anyMatch(p -> p.getName().equals("John"));
// - `allMatch`: Returns a boolean if all elements match a condition.
//      boolean allAdults = phoneBook.stream().allMatch(p -> p.getAge() >= 18);
// - `noneMatch`: Returns a boolean if no elements match a condition.
//      boolean noChildren = phoneBook.stream().noneMatch(p -> p.getAge() < 18);
// - `findFirst`: Returns an Optional<T> for the first matching element.
//      Optional<Person> person = phoneBook.stream().filter(p -> p.getName().equals("John")).findFirst();
// - `collect(Collectors.toList())`: Collects elements into a List.
//      List<Person> allPeople = phoneBook.stream().collect(Collectors.toList());
// - `reduce`: Aggregates stream elements into a single value.
//      int totalAge = phoneBook.stream().mapToInt(Person::getAge).reduce(0, Integer::sum);
// - `map`: Transforms each element in the stream.
//      List<String> names = phoneBook.stream().map(Person::getName).collect(Collectors.toList());
// - `mapToInt`, `mapToDouble`, `mapToLong`: Specialized map for primitive types (e.g., int, double, long).
//      int totalAge = phoneBook.stream().mapToInt(Person::getAge).sum();
//-- ------------------------------------------------------------------------------------------------------
public class Solution {

    public static void main(String[] args) {
        try(Scanner scan = new Scanner(System.in)) {
            
            int n = scan.nextInt();
            scan.nextLine();
            String strNums = scan.nextLine();
            int q = scan.nextInt();
            scan.nextLine();
            
            List<Integer> lstAllNums = Arrays.stream(strNums.split("\\s+"))
                    .map(S -> Integer.parseInt(S)).collect(Collectors.<Integer>toList());
            
            List<String> lstCommands = new ArrayList<>();
            List<List<Integer>> lstAllParams = new ArrayList<>();
            while(q-- > 0) {
                String cmd = scan.nextLine();
                String params = scan.nextLine();
                
                lstCommands.add(cmd);
                List<Integer> lstIntParams = Arrays.stream(params.split("\\s+"))
                    .map(S -> Integer.parseInt(S)).collect(Collectors.<Integer>toList());
                lstAllParams.add(lstIntParams);
            }
            
            for(int z=0; z<lstCommands.size(); z++) {
                String cmd = lstCommands.get(z);
                List<Integer> lstIntParams = lstAllParams.get(z);
                
                //-- System.out.printf("Cmd=%s, params=%s\n", cmd, lstIntParams.toString());
                if(cmd.equals("Insert")) {
                    lstAllNums.add(lstIntParams.get(0), lstIntParams.get(1));
                }
                else if(cmd.equals("Delete")) {
                    //-- lstAllNums.remove(lstIntParams.get(0));
                    int removeIndex = lstIntParams.get(0), currIndex=0;
                    ListIterator<Integer> iterator = lstAllNums.listIterator();
                    while(iterator.hasNext()) {
                        iterator.next(); 
                        if(currIndex==removeIndex) { iterator.remove(); break; };
                        currIndex++;
                    }
                }
            }
            String result = lstAllNums.stream()
                .map(I->String.valueOf(I)).collect(Collectors.joining(" "));
            System.out.println(result);
        }
    }
}
