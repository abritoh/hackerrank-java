import java.util.*;

/*
 * My solutions for the Hackerrank Java Challenges
 * Author: arcebrito@gmail.com | 2025-FEB
 * Hackerrank: https://www.hackerrank.com/profile/arcbrth
 */
class Student {
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0) {
            
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
        
        //-- Uses Collections.sort(collectionDS, comparatorImp)
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                //--if gcpa is the same compare using fname
                if( a.getCgpa()==b.getCgpa() ) {
                    //--if fname is the same compare using id
                    if( a.getFname().equals(b.getFname()) ) {
                        //-- compares to sort ASC by ID
                        return a.getId() - b.getId();
                    }
                    //-- compares to sort ASC by FNAME
                    return a.getFname().compareTo(b.getFname());
                }
                //-- by default compare by cgpa
                int result = a.getCgpa() < b.getCgpa() ? -1 :
                             a.getCgpa() > b.getCgpa() ?  1 : 
                             0;
                //-- invert the result to sort DESC by CGPA
                return result * -1 ;
            }
        });
      
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}
