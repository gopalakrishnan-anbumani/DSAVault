//221. Maximal Square
//https://leetcode.com/problems/maximal-square/description/


class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m][n];
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(matrix[r][c] == '1'){
                    dp[r][c] = 1;
                    max=1;
                }
            }
        }
        for(int r=1; r<m; r++){
            for(int c=1; c<n; c++){
                if(dp[r][c]==1){
                    int sq = 1 + Math.min(Math.min(dp[r][c-1], dp[r-1][c-1]), dp[r-1][c]);
                    dp[r][c] = sq;
                    max = Math.max(max, sq);
                }
            }
        }
        return max*max;
    }


}