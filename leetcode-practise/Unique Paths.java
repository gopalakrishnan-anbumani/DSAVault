//62. Unique Paths
//https://leetcode.com/problems/unique-paths/description/

class Solution {
    int[][] memo=null;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        int res = rec(m,n,0,0);
        //Print array
        for(int[] mm : memo){
            System.out.println(Arrays.toString(mm));
        }
        return res;
    }

    //Top Down - Using Iterative
    public int topDown(int m, int n){
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        for(int i=0;i<n;i++){
            dp[0][i] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1]; 
            }
        }
        return dp[m-1][n-1];
    }
  
    //Bottom-Up DP - Memo
    public int rec(int m, int n, int r, int c){
        if(r == m-1 && c == n-1){
            return 1;
        }
        if(r>=m || c>=n){
            return 0;
        }
        if(memo[r][c] > 0){
            return memo[r][c];
        }
        memo[r][c] = rec(m,n,r+1,c)+rec(m,n,r,c+1);
        return memo[r][c];
    }
}
