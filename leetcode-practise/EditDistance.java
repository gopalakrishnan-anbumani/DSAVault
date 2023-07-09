//72. Edit Distance
//https://leetcode.com/problems/edit-distance/description/

class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1+1][n2+1];

        for(int i=0;i<=n1;i++){
            dp[i][n2] = n1 - i;
        }
        for(int i=0;i<=n2;i++){
            dp[n1][i] = n2 - i;
        }

        for(int i=n1-1;i>=0; i--){
            for(int j=n2-1;j>=0;j--){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]));
                }
            }
        }
        return dp[0][0];
    }

}