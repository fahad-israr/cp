/*
Pattern:
for n = 5 we get :

1	
1	1	
1	2	1	
1	3	3	1	
1	4	6	4	1	

Hint : nC(r+1) = nCr*((n-r)/(r+1))

Also Available on Leetcode : https://leetcode.com/problems/pascals-triangle/

*/

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        for(int i = 0;i<n;i++){
            int iCj = 1 ; //nCr
            System.out.print(iCj+"\t");
            for(int j = 1; j<=i;j++){
                int r = j-1;
                iCj = iCj*(i-r)/(r+1);
                System.out.print(iCj+"\t");
            }
            System.out.println();
        }

    }
}
