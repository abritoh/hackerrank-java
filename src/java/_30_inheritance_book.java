import java.io.*;
import java.util.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
abstract class Book {
    protected String title;
    public abstract void setTitle(String s);
    public String getTitle(){
        return title;
    }
}

class TerrorBook extends Book {
    public void setTitle(String s) {
        this.title = s;
    }
}

public class Solution {
    public static void main(String[] args) {        
        Book book = new TerrorBook();
        try(Scanner scan = new Scanner(System.in)) {
            String title = scan.nextLine();
            book.setTitle(title);
            System.out.println("The title is: " + book.getTitle());            
        }
    }
}