import java.util.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
public class Main {
   //-- The function modifies the default iteration behavior 
   //-- to fetch only specific items that fulfill a certain criteria
   //--     The function iterates through the ArrayList 
   //--     and stop when it encounters the first String element. 
   //--     It then returns an Iterator positioned at that point, 
   //--     allowing further iteration over the remaining elements in the list.
   static Iterator getCustomIterator(ArrayList mylist) {
      Iterator it = mylist.iterator();
      while(it.hasNext()) {
         Object element = it.next();
         //-- The instanceof operator in Java is primarily used with objects 
         //-- (reference types), not primitive types. Its main purpose is to check 
         //-- whether an object is an instance of a particular class or implements a certain interface.
         if(element instanceof String) break;
		}
      return it;
   }

   //-- Both an Iterator in Java and a Cursor in SQL help you traverse through elements one-by-one:
   //--     - Iterator is used for traversing elements in collections in Java (like ArrayList, HashSet, etc.).
   //--     - Cursor is used for traversing rows in SQL result sets.
   //-- However, the key difference lies in their respective contexts:   
   //--     - An Iterator works with Java's in-memory collections.
   //--     - A Cursor works with rows in a database result set.
   @SuppressWarnings({ "unchecked" })
   public static void main(String []args) {
      //-- In Java, a non-generic ArrayList can only store reference types, not primitive data types
      //-- It creates a raw ArrayList that can hold any reference type (i.e., objects). 
      //-- However, you cannot directly store primitive types (like int, char, double, etc.) in the ArrayList. 
      //-- Java autoboxes the primitive types into their corresponding wrapper classes 
      //-- (such as Integer, Character, Double, etc.)
      ArrayList mylist = new ArrayList();
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int m = sc.nextInt();
      for(int i = 0;i<n;i++){
         mylist.add(sc.nextInt());
      }
      
      mylist.add("###");
      for(int i=0; i<m; i++) {
         mylist.add(sc.next());
      }
      
      Iterator it = getCustomIterator(mylist);
      while(it.hasNext()) {
         Object element = it.next();
         System.out.println((String)element);
      }
   }
}
