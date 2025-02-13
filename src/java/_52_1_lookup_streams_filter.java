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

//-- this solution solves the problem but requires optimization
//-- Your code did not execute within the time limits. Please optimize your code. 
//-- For more information on execution time limits, refer to the environment page
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
            
            //-- exec queries
            for(String x : names) {
                Optional<Person> personExists = phoneBook.stream()
                    .filter(p -> p.getName().equals(x)).findFirst();
                if( personExists.isPresent() ) {
                    Person p = personExists.get();
                    System.out.printf("%s=%s\n", p.getName(), p.getPhone());
                } else {
                    System.out.println(NOT_FOUND);
                }
            }        
        }
	}
}

