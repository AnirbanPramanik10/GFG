//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine().trim());
			int [][] colors = new int[N][3];
			for(int i = 0; i < N; i++) {
				String [] str = br.readLine().trim().split(" ");
				colors[i][0] = Integer.parseInt(str[0]);
				colors[i][1] = Integer.parseInt(str[1]);
				colors[i][2] = Integer.parseInt(str[2]);
			}
			Solution obj = new Solution();
			out.println(obj.minCost(colors, N));
		}
		out.close();
	}
}

// } Driver Code Ends



//User function Template for Java

class Solution{
	int minCost(int [][] colors, int n){
        
        int p=0;
        int b=0;
        int y=0;
        
        for(int i=0;i<n;i++){
            int np = colors[i][0] + Math.min(b,y);
            int nb = colors[i][1] + Math.min(p,y);
            int ny = colors[i][2] + Math.min(p,b);
            
            p = np;b=nb;y=ny;
        }
        
        return Math.min(p,Math.min(b,y));
    }
}