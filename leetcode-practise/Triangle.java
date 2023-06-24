//120. Triangle
//https://leetcode.com/problems/triangle/description/


class Solution {
    //NeetCode Solution
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()+1];

        for(int r=triangle.size()-1; r>=0; r--){
            for(int i=0; i<=r; i++){
                dp[i] = triangle.get(r).get(i) + Math.min(dp[i] , dp[i+1]); 
            }
        }

        return dp[0];
    }
}

//My Solution using DP with S.P -> O(n*n) & T.P -> O(n^2)
class Solution1 {
    List<List<Integer>> list = null;
    int[][] dp = null;
    public int minimumTotal(List<List<Integer>> triangle) {
        dp = new int[triangle.size()][triangle.size()];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        list = triangle;
        return rec(0,0);
    }
    public int rec(int row, int index){
        if(row == list.size()-1){
            dp[row][index] = list.get(row).get(index);
            return dp[row][index];
        }
        if(dp[row][index] != -1){
            return dp[row][index]; 
        }
        dp[row][index] = Math.min(rec(row+1, index), rec(row+1, index+1)) + list.get(row).get(index);
        return dp[row][index];
        
    }
}