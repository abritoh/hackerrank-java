import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
//-- https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html 
class Student {
    private int id; 
    private String name;
    //-- Cumulative Grade Point Average (CGPA)
    private double cgpa;    
    
    public Student(int id, String name, double cgpa) {
        this.id=id;
        this.name=name;
        this.cgpa=cgpa;        
    }    
    
    public int getID() { return this.id; }
    public String getName() { return this.name; }
    public double getCGPA() { return this.cgpa; }
    
    @Override
    public String toString() {
        return "{ID:"+id + ", Name:"+name + ", CGPA:"+cgpa + "}";
    }
}

class StudentPriorityComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        //-- 1: compare by CGPA DESC
        int cgpaComparison = Double.compare(b.getCGPA(), a.getCGPA());
        if (cgpaComparison != 0) {
            return cgpaComparison;
        }

        //-- 2: if CGPA is the same, compare by name ASC
        int nameComparison = a.getName().compareTo(b.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }

        //-- 3: if both CGPA and name are the same, compare by ID ASC
        return Integer.compare(a.getID(), b.getID());
    }
}


class Priorities {
    
    List<Student> getStudents(List<String> events) {
        
        PriorityQueue<Student> priorityQ = 
            new PriorityQueue<Student>(new StudentPriorityComparator());
            
        for(String event : events) {
            String[] args = event.split("\\s+");
            if(args != null && args.length > 0) {
                String command = args[0];
                if(command.equals("ENTER")) {
                    String name = args[1]; 
                    double cgpa = Double.parseDouble(args[2]);
                    int id = Integer.parseInt(args[3]);
                    priorityQ.add(new Student(id, name, cgpa));
                }
                else if(command.equals("SERVED")) {
                    //-- gets/removes highest-priority item 
                    //-- of the priority-queue
                    priorityQ.poll();
                }            
            }
        }
        List<Student> studentList = new ArrayList<>();
        while (!priorityQ.isEmpty()) {
            studentList.add(priorityQ.poll());
        }
        //-- returns the priority-queue as a List<Student>
        return studentList;
    }
}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}