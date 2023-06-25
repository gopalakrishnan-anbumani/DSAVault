//931. Minimum Falling Path Sum
//https://leetcode.com/problems/minimum-falling-path-sum/description/

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for(int i=1;i<n;i++){
            for(int j=0; j<n; j++){
                int min = Integer.MAX_VALUE;
                if(j!=0){
                    min = Math.min(matrix[i-1][j-1], min);
                }
                if(j!=n-1){
                    min = Math.min(matrix[i-1][j+1], min);
                }
                min = Math.min(matrix[i-1][j], min);
                matrix[i][j] += min;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            res = Math.min(res, matrix[n-1][i]);
        }
        return res;
    }
}