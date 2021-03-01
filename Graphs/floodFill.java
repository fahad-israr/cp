import java.util.*;
import java.lang.*;
import java.io.*;
public class floodFill
 {
	static  class cell{
		int x,y;
		cell(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main (String[] args)throws IOException
	 {
	  BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
	  int t=Integer.parseInt(obj.readLine());
	  while(t-->0){
		  String[]in=obj.readLine().split(" ");
		  int n=Integer.parseInt(in[0]);
		  int m=Integer.parseInt(in[1]);
		  int matrix[][]=new int[n][m];
		  String[]inp=obj.readLine().split(" ");
		  int p=0;
		  for(int i=0;i<n;i++)
		  	for(int j=0;j<m;j++)
			  if(p<(m*n))
			  matrix[i][j]=Integer.parseInt(inp[p++]);
		//Matrix fill ends here

		  inp=obj.readLine().split(" ");
		  int x=Integer.parseInt(inp[0]);
	  	  int y=Integer.parseInt(inp[1]);
		  int k=Integer.parseInt(inp[2]);	

		  bfs(matrix,n,m,x,y,k);
		for(int i=0;i<n;i++)
			{for(int j=0;j<m;j++)
			System.out.print(matrix[i][j]+" ");
			//System.out.println();
			}
		System.out.println();
		  
	  }//testcases
	 }//-------main ends
	 static void bfs(int[][]matrix,int n,int m,int x,int y,int k){
		 int v=matrix[x][y];
		 boolean visited[][]=new boolean[n][m];
		 Queue<cell> q=new LinkedList<cell>();
		 q.add(new cell(x,y));
		 visited[x][y]=true;
		 while(!q.isEmpty()){
			 cell temp=q.remove();
			 int xnow=temp.x;
			 int ynow=temp.y;
			 matrix[xnow][ynow]=k;
			 if(xnow+1<n&&(!visited[xnow+1][ynow])&&matrix[xnow+1][ynow]==v){visited[xnow+1][ynow]=true;q.add(new cell(xnow+1,ynow));}
			 if(xnow-1>=0&&(!visited[xnow-1][ynow])&&matrix[xnow-1][ynow]==v){visited[xnow-1][ynow]=true;q.add(new cell(xnow-1,ynow));}
			 if(ynow-1>=0&&(!visited[xnow][ynow-1])&&matrix[xnow][ynow-1]==v){visited[xnow][ynow-1]=true;q.add(new cell(xnow,ynow-1));}
			 if(ynow+1<m&&(!visited[xnow][ynow+1])&&matrix[xnow][ynow+1]==v){visited[xnow][ynow+1]=true;q.add(new cell(xnow,ynow+1));}
		 }
	 }//------bfs ends
}

/*---------- For Testing ---------
INPUT:
----------------------------------
3
3 4
0 1 1 0 1 1 1 1 0 1 2 3
0 1 5
2 2
1 1 1 1
0 1 8
4 4 
1 2 3 4 1 2 3 4 1 2 3 4 1 3 2 4
0 2 9
----------------------------------
Expected OUTPUT:
----------------------------------
0 5 5 0 5 5 5 5 0 5 2 3
8 8 8 8
1 2 9 4 1 2 9 4 1 2 9 4 1 3 2 4
----------------------------------
*/