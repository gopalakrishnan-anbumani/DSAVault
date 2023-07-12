//115. Distinct Subsequences
//https://leetcode.com/problems/distinct-subsequences/

//NeetCode
class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int[] arr : dp){
            arr[arr.length-1] = 1;
        }

        for(int i = s.length()-1; i>=0; i--){
            for(int j = t.length()-1; j>=0; j--){
                int sum = dp[i+1][j];
                if(s.charAt(i) == t.charAt(j)){
                    sum+= dp[i+1][j+1];
                }
                dp[i][j] = sum;
            }
        }
        return dp[0][0];
    }
}

//NeetCode. Same as my solution.
class Solution {
    int[][] dp = null;
    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return rec(0, s, 0, t);
    }
    public int rec(int i, String s, int j, String t){
        if(j >= t.length()){
            return 1;
        }
        if(i >= s.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int res = 0;
        if(s.charAt(i) == t.charAt(j)){
            res = rec(i+1, s, j+1, t);
        }
        res += rec(i+1, s, j, t);
        dp[i][j] = res;
        return dp[i][j];
    }
}

//My Solution. Time Limit Exceeded for some cases.
class Solution {
    HashMap<String,Integer> hm = new HashMap<>();
    public int numDistinct(String s, String t) {
        return rec(s,t);
    }
    public int rec(String s, String t){
        if(t.isEmpty()){
            return 1;
        }
        if(s.isEmpty()){
            return 0;
        }
        if(hm.containsKey(s+":"+t)){
            return hm.get(s+":"+t);
        }
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == t.charAt(0)){
                res += rec(s.substring(i+1), t.substring(1));
            }
        }
        hm.put(s+":"+t, res);
        return hm.get(s+":"+t);
    }
}