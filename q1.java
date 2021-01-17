import java.util.*;

public class q1{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int j=1;j<=t;j++){
            int n=sc.nextInt();
            int a[]=new int[n];
            int max=0;
            for(int i=0;i<n;i++)a[i]=sc.nextInt();
            for(int i=0;i<n-1;i++){
                int c=0;
                while(Math.abs(a[i]-a[i+1])==2)
                c++;
                max=Math.max(max,c);
                
            }
            System.out.println("Case #"+j+":"+ max);
            
        }
    }
}