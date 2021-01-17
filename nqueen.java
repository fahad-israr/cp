import java.util.*;
import java.lang.*;
import java.io.*;
public class nqueen
 {	
	static ArrayList<ArrayList<Integer>> res;
	public static void main (String[] args)throws IOException
	 {
	 	BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(obj.readLine());
		while(t-->0){
		  int n=Integer.parseInt(obj.readLine());
		  res=new ArrayList<>();
		  int [][]board=new int[n][n];
		  solve(n,0,board);
		  if(res.size()==0)System.out.println("-1");
		  else
		  printResult(res);
		}
	 }//---------main ends here-------

	static void solve(int n,int col,int [][]board){
		if(col==n){addToResult(board,n); return;}
		for(int i=0;i<n;i++){
			int[][]myboard=cpy(board,n);
			if(safe(n,col,i,board)){myboard[i][col]=1;solve(n,col+1,myboard);}
		}
	}
	static int[][]cpy(int[][]a,int n){
		int[][]b=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			b[i][j]=a[i][j];
		return b;
	}
	static boolean safe(int n,int col,int row,int [][]board){
			//Check Row on left
			for(int i=0;i<col;i++)
			if(board[row][i]==1)return false;
			//Check upper left diagonal
			for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
				if(board[i][j]==1)return false;
			}
			//Check lower left diagonal
			for(int i=row+1,j=col-1;i<n&&j>=0;i++,j--)
				if(board[i][j]==1)return false;

			return true;//default case
	}
	static void addToResult(int[][]board,int n){
		ArrayList<Integer> temp=new ArrayList<>();
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			if(board[j][i]==1)temp.add(j+1);
		res.add(temp);
	}
	static void printResult(ArrayList<ArrayList<Integer>> arr){
		for(ArrayList<Integer> a:arr){
			System.out.print("[");
			for(int i:a){
				System.out.print(i+" ");
			}
			System.out.print("] ");
		}
		System.out.println();
	}

}