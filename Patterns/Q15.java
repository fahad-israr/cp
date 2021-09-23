/*
Print Following Pattern.
For n = 5, we get this :

		1			
	2	3	2		
3	4	5	4	3	
	2	3	2		
		1	
    
    
*/

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        int max = 1;
        int sp = n-1;
        for(int i = 1;i<=n;i++){
            int numbers = n-sp ; //numbers = total - spaces
            int startValue = max - ((numbers-1)/2);
            
            for(int j = 1;j<=(sp/2);j++){
                System.out.print("\t");
               
            }
            
            for(int j = startValue;j<=max;j++){
                 System.out.print(j+"\t");
            }
            
            for(int j=max-1;j>=startValue;j--){
                 System.out.print(j+"\t");
            }
            
            for(int j = 1;j<=(sp/2);j++){
                System.out.print("\t");
               
            }
            
            if(i<=n/2){
                sp -= 2;
                max += 2;
            }else{
                sp += 2;
                max -= 2;
            }
            
             System.out.println();
            
        }

    }
}
