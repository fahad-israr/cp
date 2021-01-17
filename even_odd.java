
import java.io.*; 
import java.util.*;
public class even_odd { 


  	static long c=0;
  
   static int fact(int n)
 {
 int i,f=1;
     for(i=1;i<=n;i++)
     {
         f=f*i;
     } 
     return f;
 }
 static void CombinationRepetitionUtil(int chosen[], int arr[], 
            int index, int r, int start, int end) { 

        if (index == r) { 
            int a=0;
            HashSet<Integer> set = new HashSet<Integer>(); 
            
            for (int i = 0; i < r; i++) { 
  
                a+=arr[chosen[i]];
                set.add(arr[chosen[i]]);
            } 
        
            if(a%2==0){ c+=fact(set.size());} 
            
            return; 
        } 
  
    
 
        for (int i = start; i <= end; i++) { 
            chosen[index] = i; 
            CombinationRepetitionUtil(chosen, arr, index + 1, 
                    r, i, end); 
        } 
        return; 
    } 
  

    static void CombinationRepetition(int arr[], int n, int r) { 
 
        int chosen[] = new int[r + 1]; 
  
       
        CombinationRepetitionUtil(chosen, arr, 0, r, 0, n - 1); 
    } 

	public static void main (String[] args) { 
      Scanner sc=new Scanner(System.in);
      int l,h,k;
      l=sc.nextInt();
      h=sc.nextInt();
      k=sc.nextInt();
      int n = h-l+1; 
      int arr[]=new int[n];
      for(int i=0;i<n;i++)
        arr[i]=l++;

		int r = k; 
		
	CombinationRepetition(arr, n, r); 

		c=Math.round(c%(Math.pow(10,9)+7));
      	System.out.print(c);
	} 
} 

