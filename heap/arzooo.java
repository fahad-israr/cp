// ARray 
// Number 
// Start and End index
// key

// 1 2 3 4 5 6 
// 0 1 2 3 4 5
// 1 , 4 , n=2
// i = 0 , j = n-1 i<=j

import java.io.*;
class arzooo{
  public static void main(String... args)throws IOException{
    BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(obj.readLine()); //Array Size
    int a[] = new int[n];
    String[]inp = obj.readLine().split(" ");
    
    for(int i=0;i<n;i++){
      a[i] = Integer.parseInt(inp[i]);
    }

    int start = Integer.parseInt(obj.readLine());
    int end = Integer.parseInt(obj.readLine());
    int key  = Integer.parseInt(obj.readLine());

    for(int i = start+1; i < end ; i+=key){
      //if(i == a.length-key)continue;
      if(i+key > end)continue; 
      else
      reverse(a,i,i+key-1);
    }

    for(int i:a){
      System.out.print(i+" ");
    }
    //------INPUT ENDS HERE----
  }//--- main ends

  static void reverse(int[]a,int start,int end){
    if(end == a.length) end -- ;
    
    for(int i = start, j = end;i<=j;i++){
      int temp = a[i];
      a[i] = a[j];
      a[j--] = temp;
    }

  }// reverse(args..) ends here
}