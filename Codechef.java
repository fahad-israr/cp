/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
//import java.io.*;
import java.util.*;
public class Codechef
{
	public static void main(String[] args) {
		//BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    int k=sc.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)a[i]=sc.nextInt();
		    int res=0;
		    for(int i=0;i<n;i++){
		       if(a[i]>k)continue;
		        int s=a[i];
		        a[i++]=0;
		        while(s<=k){s+=a[i];a[i++]=0;if(i==n){res++;break;}}
		        if(i==n)break;
		        res++;
		    }
		    System.out.println(res==0?-1:res);
		    
		}//Testcases
	}
}
