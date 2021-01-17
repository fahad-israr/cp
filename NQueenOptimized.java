import java.util.*;
import java.lang.*;
import java.io.*;
public class NQueenOptimized
 {	
	static ArrayList<ArrayList<Integer>> res;

 
	public static void main (String[] args)throws IOException
	 {
	 	BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(obj.readLine());
		while(t-->0){
		  int n=Integer.parseInt(obj.readLine());
            HashSet<Integer> ld; //Left diagonals on Which we have kept queen
            HashSet<Integer> rd; //Right Diagonal on Which we have kept queen
            HashSet<Integer> r; //Row on Which we have kept queen
            /*
            for 4 by 4 chess board: 

            Left diagonal:
            left diagonal (0,0) (1,1) (2,2).... difference=0-0=1-1=2-2=0
            left diagonal (1,0) (2,1) (3,2)... difference=1 
            for other left diagonal difference of i-j=constant
            -----
            Right Diagonal 
            right diagonal: (0,3) (1,2) (2,1) ...sum=3
            right diagonal: () ...for other right diagonal sum of i+j=constant
            */        
            res=new ArrayList<>();
            ld=new HashSet<Integer>();
            rd=new HashSet<Integer>();
            r=new HashSet<Integer>();
		    //int [][]board=new int[n][n];
            for(int i=0;i<n;i++){
				System.out.println();
                ld.add(i);
                rd.add(i);
                r.add(i);
                int []board=new int[n];
                board[0]=i;
                solve(n,1,ld,rd,r,board);
				for(int k=0;k<n;k++)
					System.out.print(board[k]+" ");
				ld.remove(i);
				rd.remove(i);
				r.remove(i);
            }
		    /*if(res.size()==0)System.out.println("-1");
		    else*/
		    printResult(res);
		}
	 }//---------main ends here-------

	static boolean solve(int n,int col,HashSet<Integer> ld,HashSet<Integer> rd,HashSet<Integer> r,int[]board){
		if(col>=n){addToResult(board,n); return true;}
		for(int i:board)System.out.print(i+"-");
		for(int i=0;i<n;i++){
			System.out.println(safe(n,col,i,ld,rd,r));
			if(safe(n,col,i,ld,rd,r))
            {   ld.add(i-col);
                rd.add(i+col);
                r.add(i);
                board[col]=i; 
                if(solve(n,col+1,ld,rd,r,board))return true;
                ld.remove(i-col);
                rd.remove(i+col);
                r.remove(i);
                board[col]=0;
				return false;
            }
			return true;
		}
		return true;
	}
	/*static int[][]cpy(int[][]a,int n){
		int[][]b=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			b[i][j]=a[i][j];
		return b;
	}*/
	static boolean safe(int n,int col,int i,HashSet<Integer> ld,HashSet<Integer> rd,HashSet<Integer> r){
			if(ld.contains(i-col)||rd.contains(i+col)||r.contains(i))
                return false;
            return true;
	}
	
	static void addToResult(int[]board,int n){
		ArrayList<Integer> temp=new ArrayList<>();
		for(int i=0;i<n;i++)
			temp.add(board[i]);
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