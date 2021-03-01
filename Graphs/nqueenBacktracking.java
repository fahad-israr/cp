import java.util.*;
class nqueenBacktracking{
  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-->0){

      int n = sc.nextInt();
      boolean a[][] = new boolean[n][n];
    
      /*for(int j=0;j<n;j++)
            {
              for(int k=0;k<n;k++)
              System.out.print(a[j][k]+" ");
              System.out.println();
            }*/

      for(int i=0;i<n;i++){
        //System.out.println("-------------------i= "+ i);
        a[i][0] = true;
        if(nqueen(a,1,n))
        {
          for(int j=0;j<n;j++)
            {
              for(int k=0;k<n;k++)
              System.out.print((a[j][k]?"q":"o")+" ");
              System.out.println();
            }
          /*int[]res=arrSolve(a,n);
          for(int j=0;j<n;j++){
            System.out.print(res[j]+" ");
            
          }
          System.out.println();*/
        }
        a[i][0] = false;
      }
    }//--tc loop
  }//--main()

  static boolean nqueen(boolean a[][],int c,int n){
    //System.out.println(c);
    if(c==n) return false ;
    for(int i=0;i<n;i++){
      a[i][c] = true;
      if(c==n-1 && isValid(a,n,c,i)) return true;
      if(isValid(a,n,c,i) && nqueen(a,c+1,n) ) return true;
      //System.out.println("Is Valid: "+isValid(a,n,c,i));
      a[i][c] = false;
    }
    return false;
  }
  static boolean isValid(boolean a[][],int n,int c , int r){
    // Difference of |r-c| is constant on left diagonal(main).
    // Sum of r+c is constant on right diagonal(secondary).
   // System.out.println("r = " + r + " c = "+c);
    int d = (r - c) ;
    int sum = r + c ;
    for(int i=0 ; i < n ; i++){
      for(int j=0 ; j<c ; j++){
        if(i==r && a[i][j]) return false; // Check the row
        //System.out.println("L1 ");
        if((i-j) == d && a[i][j])return false; // Check the left diagonal
        if(i+j == sum && a[i][j]) return false; // Check the right diagonal
      }
    }
   // System.out.println("Hurrrah");
    return true;
  }//---isValid()

  static int[] arrSolve(boolean a[][] , int n){
    int res[]=new int[n];
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++)
      if(a[i][j]) res[j] = i;
    }
    return res;
  }
}//---class