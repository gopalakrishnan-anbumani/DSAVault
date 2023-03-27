//64. Minimum Path Sum
//https://leetcode.com/problems/minimum-path-sum/description/
//Leetcode - Daily Challenge - 27-03-2023
//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
//Note: You can only move either down or right at any point in time.


class Solution {
    public int minPathSum(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];
        res[0][0] = grid[0][0];
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 1; i< row; i++){
            res[i][0] = res[i-1][0] + grid[i][0];
        }
        for(int i=1; i < col; i++){
            res[0][i] = res[0][i-1] + grid[0][i];
        }
        for(int i=1; i < row; i++){
            for(int j=1; j < col; j++){
                res[i][j] = Math.min(res[i][j-1], res[i-1][j]) + grid[i][j];
            }
        }
        return res[grid.length-1][grid[0].length-1];
    }
}
