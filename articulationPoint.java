// A Java program to find articulation points in an undirected articulationPoint 
import java.io.*; 
import java.util.*; 
import java.util.LinkedList; 

// This class represents an undirected  using adjacency list 
// representation 
class articulationPoint 
{ 
	private int V; // No. of vertices 

	// Array of lists for Adjacency List Representation 
	private LinkedList<Integer> adj[]; 
	int time = 0; 
	static final int NIL = -1; 

	// Constructor 
	articulationPoint(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	//Function to add an edge into the  
	void addEdge(int v, int w) 
	{ 
		adj[v].add(w); // Add w to v's list. 
		adj[w].add(v); //Add v to w's list 
	} 

	// A recursive function that find articulation points using DFS 
	// u --> The vertex to be visited next 
	// visited[] --> keeps tract of visited vertices 
	// disc[] --> Stores discovery times of visited vertices 
	// parent[] --> Stores parent vertices in DFS tree 
	// ap[] --> Store articulation points 

  //====== Complete this function for Practice ========
	void APUtil(int u, boolean visited[], int disc[], 
				int low[], int parent[], boolean ap[]) 
	{
    disc[u] = low[u]  = ++time;
    int children = 0;
    for(int i:adj[u]){
      if(!visited[i]){
        children++;
        //Agar visited nhi hai to jhol ho skta hai...
        parent[i] = u;
        APUtil(i,visited,disc,low,parent,ap);
        low[u] = Math.min(low[u],low[i]);

        // Agar root node hai to
        if((children >= 2) && parent[u] == -1) ap[u] = true;

        // Agar root node nahi hai to
        if(parent[u] !=-1 && disc[u]<=low[i]) ap[u] = true;
      }
      else
      {
       if(i!=parent[u]) low[u] = Math.min(low[u],low[i]); 
      }
    }

	} 

	// The function to do DFS traversal. It uses recursive function APUtil() 
	void AP() 
	{ 
		// Mark all the vertices as not visited 
		boolean visited[] = new boolean[V]; 
		int disc[] = new int[V]; 
		int low[] = new int[V]; 
		int parent[] = new int[V]; 
		boolean ap[] = new boolean[V]; // To store articulation points 

		// Initialize parent and visited, and ap(articulation point) 
		// arrays 
		for (int i = 0; i < V; i++) 
		{ 
			parent[i] = NIL; 
			visited[i] = false; 
			ap[i] = false; 
		} 

		// Call the recursive helper function to find articulation 
		// points in DFS tree rooted with vertex 'i' 
		for (int i = 0; i < V; i++) 
			if (visited[i] == false) 
				APUtil(i, visited, disc, low, parent, ap); 

		// Now ap[] contains articulation points, print them 
		for (int i = 0; i < V; i++) 
			if (ap[i] == true) 
				System.out.print(i+" "); 
	} 

	// Driver method 
	public static void main(String args[]) 
	{ 
		// Create s given in above diagrams 
		System.out.println("Articulation points in first  "); 
		articulationPoint g1 = new articulationPoint(5); 
		g1.addEdge(1, 0); 
		g1.addEdge(0, 2); 
		g1.addEdge(2, 1); 
		g1.addEdge(0, 3); 
		g1.addEdge(3, 4); 
		g1.AP(); 
		System.out.println(); 

		System.out.println("Articulation points in Second "); 
		articulationPoint g2 = new articulationPoint(4); 
		g2.addEdge(0, 1); 
		g2.addEdge(1, 2); 
		g2.addEdge(2, 3); 
		g2.AP(); 
		System.out.println(); 

		System.out.println("Articulation points in Third articulationPoint "); 
		articulationPoint g3 = new articulationPoint(7); 
		g3.addEdge(0, 1); 
		g3.addEdge(1, 2); 
		g3.addEdge(2, 0); 
		g3.addEdge(1, 3); 
		g3.addEdge(1, 4); 
		g3.addEdge(1, 6); 
		g3.addEdge(3, 5); 
		g3.addEdge(4, 5); 
		g3.AP(); 
	} 
} 
// This code is contributed by Aakash Hasija 
