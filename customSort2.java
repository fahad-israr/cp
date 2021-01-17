// Java program to demonstrate working of Comparator
// interface
import java.util.*;
import java.lang.*;
import java.io.*;

// A class to represent a student.
class Student implements Comparable<Student>
{
	int rollno;
	String name, address;

	// Constructor
	public Student(int rollno, String name,
							String address)
	{
		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}

	// Used to print student details in main()
	public String toString()
	{
		return this.rollno + " " + this.name +
						" " + this.address;
	}

	//----Compare method
	//--- (Object this).compareTo(Object a)
  @Override
  public int compareTo(Student a)
	{
		return this.rollno - a.rollno;
	}

}


// Driver class
class customSort2
{
	public static void main (String[] args)
	{
		ArrayList<Student> ar = new ArrayList<Student>();
		ar.add(new Student(111, "bbbb", "london"));
		ar.add(new Student(131, "aaaa", "nyc"));
		ar.add(new Student(121, "cccc", "jaipur"));

		System.out.println("Unsorted:");
		for (int i=0; i<ar.size(); i++)
			System.out.println(ar.get(i));

		Collections.sort(ar);

		System.out.println("\nSorted by Roll No: ");
		for (int i=0; i<ar.size(); i++)
			System.out.println(ar.get(i));

	
	}
}
