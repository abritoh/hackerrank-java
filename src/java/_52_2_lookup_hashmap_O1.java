import java.util.*;
import java.util.stream.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
class Person {
    private int phone;
    private String name;
    public Person(int phone, String name) { 
        this.phone=phone; this.name=name; 
    }
    public int getPhone() { return phone; };
    public void setPhone(int phone) { this.phone = phone; };
    
    public String getName() { return this.name; };
    public void setName(String name) { this.name = name; };
}

public class Solution {    
    private static final String NOT_FOUND = "Not found";
	public static void main(String []argh) {
		try(Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            in.nextLine();
            
            //-- phone-book entries
            List<Person> phoneBook = new ArrayList<>();
            for(int i=0; i<n; i++) {
                String name = in.nextLine();
                int phone = in.nextInt();
                in.nextLine();
                phoneBook.add(new Person(phone, name));
            }
            
            //-- query-entries
            List<String> names = new ArrayList<>();
            while(in.hasNext()) {
                String name = in.nextLine();
                names.add(name);
            }
            
            Map<String, Integer> phoneMap = new HashMap<>();
            for(Person p : phoneBook) {
                phoneMap.put(p.getName(), p.getPhone());
            }
            
            //-- exec queries using the map
            for(String name : names) {
                //-- HasMaps lookup time is O(1)
                Integer phone = phoneMap.get(name);                
                if( phone != null ) {                    
                    System.out.printf("%s=%s\n", name, phone);
                } else {
                    System.out.println(NOT_FOUND);
                }
            }
        }
	}
}

