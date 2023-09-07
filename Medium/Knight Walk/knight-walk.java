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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends



class Solution
{
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
         if(KnightPos[0] == TargetPos[0] && KnightPos[1] == TargetPos[1])return 0;
        int[][] dirs = {{-2,-1},{-2,1},{-1,2},{-1,-2},{1,-2},{1,2},{2,-1},{2,1}};
        int [][]vis = new int[N+1][N+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{KnightPos[0], KnightPos[1], 0});
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size-- >0){
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                int step = cur[2];
                
                for(int dir[] : dirs){
                    int nr = x+dir[0];
                    int nc = y+dir[1];
                    
                    if(nr>0 && nc>0 && nr<=N && nc<=N && vis[nr][nc]==0){
                        queue.add(new int[]{nr, nc, step+1});
                        vis[nr][nc] = 1;
                        if(nr == TargetPos[0] && nc == TargetPos[1]){
                            return step+1;
                        }
                    }
                }
            }
        }
        return -1;
    }
}