//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
         boolean[] visited = new boolean[V];
        int lastVisited = 0; // Initialize the last visited vertex to 0 (can be any vertex)

        // Perform DFS to find the last visited vertex in the DFS traversal
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFS(i, adj, visited);
                lastVisited = i;
            }
        }

        // Reset the visited array for a new traversal
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        // Perform DFS from the last visited vertex to check if it's a mother vertex
        DFS(lastVisited, adj, visited);

        // Check if the lastVisited vertex is indeed a mother vertex
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                return -1; // The lastVisited vertex doesn't reach all other vertices
            }
        }

        return lastVisited; // The lastVisited vertex is a mother vertex
    }

    // Recursive DFS function
    private void DFS(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[v] = true;
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                DFS(neighbor, adj, visited);
            }
        }
    }
}