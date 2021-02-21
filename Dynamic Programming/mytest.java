// Java program to find number of ways to color 
// a 3 x n grid using 4 colors such that no two 
// adjacent have same color. 
public class mytest { 
	public static int solve(int A) { 
		long color3 = 24; // When we to fill single column 
		long color2 = 12; 
		long temp = 0; 
		for (int i = 2; i <= A; i++)		 
		{ 
			 temp = color3; 
			color3 = (11 * color3 + 10 * color2 ) % 1000000007; 
			color2 = ( 5 * temp + 7 * color2 ) % 1000000007; 
		} 
		long num = (color3 + color2) % 1000000007; 
		return (int)num; 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		int num1 = 4; 
		System.out.println(solve(num1)); 

		int num2 = 2; 
		System.out.println(solve(num2)); 

		int num3 = 500; 
		System.out.println(solve(num3)); 

		int num4 = 10000; 
		System.out.println(solve(num4)); 
	} 
} 
