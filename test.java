import java.lang.*;
import java.io.*;
class test
 {  
    static int dp[][];
     static int max=-1;
	public static void main (String[] args)throws IOException
	 {      
	     
	     BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
	     int t=Integer.parseInt(obj.readLine());
	     while(t-->0){
	         StringTokenizer st=new StringTokenizer(obj.readLine());
	         int n=Integer.parseInt(st.nextToken());
	         int m=Integer.parseInt(st.nextToken());
	         String a=obj.readLine();
	         String b=obj.readLine();
	         dp=new int[n+1][m+1];
	         for(int i=0;i<=n;i++)
	         for(int j=0;j<=m;j++)
            if(i==0||j==0)dp[i][j]=0;
            else
	        dp[i][j]=-1;
	         max=-1;
	         System.out.println(lcs(a,b,n,m));
	         
	     }
	     
	 //code
	 }
	
	 static int lcs(String a,String b,int n,int m){
	     
	     if(dp[n][m]!=-1)return dp[n][m];
	    
	     if(n==0||m==0)return dp[n][m]=0;
	     
	     
	     if(a.charAt(n-1)==b.charAt(m-1))
	     {
	        int res=0;int i=n-1,j=m-1;
	        while((i>=0&&j>=0)&&a.charAt(i)==b.charAt(j)){
	            res++;
	            if(i==0||j==0)return dp[n][m] = Math.max(res,max);
	            i--;j--;
	        }
	        max=Math.max(res,max);
	        
	        return dp[n][m]=Math.max(max,Math.max(lcs(a,b,n-res,m),lcs(a,b,n,m-res)));
	         
	     }
	     
	     return dp[n][m]=Math.max(lcs(a,b,n-1,m),lcs(a,b,n,m-1));
	     
	     
	     
	 }
}