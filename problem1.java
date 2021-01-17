import java.util.*;

public class problem1{
    public static void main(String[] args){
        int t,r,g,b,w;
        Scanner sc = new Scanner(System.in);
        t=sc.nextInt();
      
        while(t-->0){
            r=sc.nextInt();
            g=sc.nextInt();
            b=sc.nextInt();
            w=sc.nextInt();
            if(r==0&&g==0&&b==0&&w==0){System.out.println("Yes");continue;}
            if(r==0&&g==0&&b==0){System.out.println("Yes");continue;}
            if((r==0&&g==0)||(g==0&&b==0)||(r==0&&b==0)){
                if((r%2==0&&r!=0)||(g%2==0&&g!=0)||(b%2==0&&b!=0)||(w%2==0&&w!=0))System.out.println("Yes");
                else System.out.println("No");
                }
            if()
            int odd=0;
            if(r%2==1)odd++;
            if(g%2==1)odd++;
            if(b%2==1)odd++;
            if(w%2==1)odd++;
            if(odd==2)System.out.println("No");
            else System.out.println("Yes");

        }
    }
}