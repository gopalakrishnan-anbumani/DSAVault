//1143. Longest Common Subsequence
//https://leetcode.com/problems/longest-common-subsequence/description/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int t1 = text1.length();
        int t2 = text2.length();
        int[][] dp = new int[t1+1][t2+1];
        for(int i=t1-1; i>=0; i--){
            for(int j=t2-1; j>=0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}