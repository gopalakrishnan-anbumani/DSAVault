//516. Longest Palindromic Subsequence
//https://leetcode.com/problems/longest-palindromic-subsequence/description/

class Solution {
    public int longestPalindromeSubseq(String s) {
        String rs = new StringBuffer(s).reverse().toString();

        int[][] dp = new int[s.length()+1][s.length()+1];

        for(int i=s.length()-1; i>=0; i--){
            for(int j=s.length()-1; j>=0; j--){

                if(s.charAt(i) == rs.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}