// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class AlienDictionary {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution T = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = T.findOrder(words,n,k);
		    System.out.println(order.length()==0?"Not possible":order);
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return 1;
                        else
                            return 0;
                    }
                
                    if(index1 < index2)
                        return 1;
                    else
                        return 0;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

/*
dict : array of strings denoting the words in alien langauge
N : Size of the dictionary
K : Number of characters
*/

/*
-------------------------------------------------------
Example:
Input:
2
5 4
baa abcd abca cab cad
3 3
caa aaa aab

Output:
1
1
-------------------------------------------------------
Explanation:
-----------
Test Case 1:
--------------
--------------
Input:  Dict[ ] = { "baa", "abcd", "abca", "cab", "cad" }, k = 4
Output: Function returns "bdac"
Here order of characters is 'b', 'd', 'a', 'c'
Note that words are sorted and in the given language "baa"
comes before "abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders.
-------------------------------------------------------
Test Case 2:
--------------
--------------
Input: Dict[] = { "caa", "aaa", "aab" }, k = 3
Output: Function returns "cab"
-------------------------------------------------------
*/

class Solution
{   

    public String findOrder(String [] dict, int N, int K)
    {	
			if(dict == null || dict.length == 0||(!isValid(dict))) {
			//System.out.println("Not possible");
			return "";
			}

			/*if (!isValid(dict)) {
					return "";
			}*/
			//boolean adj[][]=new boolean[K][K]
			HashMap<Character,HashSet<Character>> adj= new HashMap<>();
			HashSet<Character> included = new HashSet<>();
			for(int i=0;i<dict.length-1;i++){
				for(int j=0;j<Math.min(dict[i].length(),dict[i+1].length());j++){
					if(dict[i].charAt(j)!= dict[i+1].charAt(j)){
						if(adj.containsKey(dict[i].charAt(j)))
							adj.get(dict[i].charAt(j)).add(dict[i+1].charAt(j));
						else
							{
								HashSet<Character> tmp = new HashSet<>();
								tmp.add(dict[i+1].charAt(j));
								adj.put(dict[i].charAt(j),tmp);
							}
							included.add(dict[i+1].charAt(j));
							included.add(dict[i].charAt(j));
							break;
					}
				}//---for(int j) ends
			}//---for(int i) ends
			//System.out.println(adj);
			//StringBuilder sb = new StringBuilder();
			if(included.size()==0)return "";
			HashSet<Character> processed = new HashSet<>();
			HashSet<Character> all = new HashSet<>();
			for(int i=0;i<dict.length;i++){
				for(char ch:dict[i].toCharArray()){
					all.add(ch);
					if(!included.contains(ch))
						processed.add(ch);
						
				}
			}
			ArrayList<Character> res = topologicalSort(adj,N,K);
			for(char ch:processed){
				boolean b=true;
				for(int i=0;i<res.size();i++)
				if(ch<res.get(i)){res.add(i,ch);b=false;break;}
				if(b)res.add(ch);
			}
			String finalOrder = listToStr(res,"");
			String calc = finalOrder.length()<all.size()?"":finalOrder;
      //System.out.println(calc);
			return calc;
    }
		//------------TOPOLOGICAL SORT BEGINS---------------------
		private ArrayList<Character> topologicalSort(HashMap<Character,HashSet<Character>> adj,int N,int K){
			HashMap<Character,Integer> in_degree = new HashMap<>();
			for(char ch:adj.keySet()){
				if(!in_degree.containsKey(ch))in_degree.put(ch,0);
				for(char c:adj.get(ch)){
					if(in_degree.containsKey(c))
						in_degree.put(c,in_degree.get(c)+1);
					else
						in_degree.put(c,1);
				}
			}
			//System.out.println(in_degree);
			Queue<Character> q = new LinkedList<Character>();

			for(char ch:in_degree.keySet())
				if(in_degree.get(ch) == 0) q.add(ch);
			
			ArrayList<Character> res = new ArrayList<Character>();  
			Set<Character> visited = new HashSet<Character>();

			while(!q.isEmpty()){
				
				char ch=q.poll();
				res.add(ch);
				visited.add(ch);
				//System.out.println(adj.get(ch));
				if(adj.get(ch)!=null)
				for(char c:adj.get(ch)){
					in_degree.put(c,in_degree.get(c)-1);
					if(in_degree.get(c) == 0 && (!visited.contains(c))) q.add(c);
				}//---for
			}	//---while
			return res;
		}//---fx() ends

		//-----------------LIST to String--------------------------

		private String listToStr(ArrayList<Character> al,String separator){
			StringBuilder sb=new StringBuilder();
			for(char s:al )
			{
				sb.append(s);
				if(separator!="")sb.append(separator);
			}
			return sb.toString();
		}
		//------------IS VALID----------------------
		private boolean isValid(String[] words) {
    for (int i = words.length - 1; i > 0; i--) {
        for (int j = i - 1; j >=0; j--) {
            if (words[j].startsWith(words[i])) {
                return false;
            }
        }
    }
    
    return true;
}
}