//712. Minimum ASCII Delete Sum for Two Strings
//https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/

//DP
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=s1.length()-1; i>=0;i--){
            dp[i][s2.length()] = dp[i+1][s2.length()] + s1.charAt(i);
        }
        for(int i=s2.length()-1; i>=0;i--){
            dp[s1.length()][i] = dp[s1.length()][i+1] + s2.charAt(i);
        }

        for(int i=s1.length()-1; i>=0;i--){
            for(int j=s2.length()-1; j>=0;j--){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                } else {
                    int d1 = s1.charAt(i);
                    int d2 = s2.charAt(j);
                    int xy = d1 + d2 + dp[i+1][j+1];
                    int x = d1 + dp[i+1][j];
                    int y = d2 + dp[i][j+1];
                    dp[i][j] = Math.min(xy, Math.min(x,y));
                }
            }
        }
        return dp[0][0];
    }
}


//Used DP with memozation. Failed for large set of input
class Solution {
    HashMap<String,Integer> hm = new HashMap<>();
    public int minimumDeleteSum(String s1, String s2) {
        int res =  rec(0, s1, 0, s2, 0);
        return res;
    }
    public int rec(int i, String s1, int j, String s2, int sum){
        if(hm.containsKey(s1+":"+s2)){
            return hm.get(s1+":"+s2);
        }
        if(s1.equals(s2)){
            return sum;
        }
        if(s1.isEmpty() && s2.isEmpty()){
            return sum;
        } else if(s1.isEmpty() || i>=s1.length()){
            char ch2 = s2.charAt(j);
            int d2 = ch2;
            String newS2 = new StringBuilder(s2).deleteCharAt(j).toString();
            return rec(i, s1, j, newS2, sum+d2);
        } else if(s2.isEmpty() || j>=s2.length()){
            char ch1 = s1.charAt(i);
            int d2 = ch1;
            String newS1 = new StringBuilder(s1).deleteCharAt(i).toString();
            return rec(i, newS1, j, s2, sum+d2);
        }
        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(j);
        if(ch1 == ch2){
            int res = rec(i+1, s1, j+1, s2, sum);
            hm.put(s1+":"+s2, res);
        } else {
            int d1 = ch1;
            int d2 = ch2;
            String newS1 = new StringBuilder(s1).deleteCharAt(i).toString();
            String newS2 = new StringBuilder(s2).deleteCharAt(j).toString();
            
            //delete both char
            int min1 = rec(i, newS1, j, newS2, sum+d1+d2);
            //delete s1 char
            int min2 = rec(i, newS1, j, s2, sum+d1);
            //delete s2 char
            int min3 = rec(i, s1, j, newS2, sum+d2);
            int res = Math.min(min1, Math.min(min2, min3));
            hm.put(s1+":"+s2, res);
        }
        return hm.get(s1+":"+s2);
    }
}