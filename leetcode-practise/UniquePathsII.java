//https://leetcode.com/problems/unique-paths-ii/description/
//63. Unique Paths II

class Solution {

    //NeetCode
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[] dp = new int[n];
        dp[n-1]=1;
        for(int r=m-1;r>=0;r--){
            for(int c=n-1;c>=0;c--){
                if(grid[r][c]==1){
                    dp[c]=0;
                } else if(c+1 < n){
                    dp[c] = dp[c] + dp[c+1];
                }
            }
        }
        return dp[0];
    }


    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0]==1) return 0;
        if (obstacleGrid[m-1][n-1]==1) return 0;
        int[][] dp = new int[m][n];
        dp[0][0]=1;
        for(int i=1;i<m;i++){
            if(obstacleGrid[i][0]==1){
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i-1][0];
            }
        }
        for(int i=1;i<n;i++){
            if(obstacleGrid[0][i]==1){
                dp[0][i] = 0;
            } else {
                dp[0][i] = dp[0][i-1];
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j] = 0; 
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]; 
                }
            }   
        }
        return dp[m-1][n-1];
    }

}
