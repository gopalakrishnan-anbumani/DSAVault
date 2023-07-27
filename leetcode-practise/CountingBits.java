//338. CountingBits
//https://leetcode.com/problems/counting-bits/description/
//CountingBits

class CountingBits {
    public int[] countBits(int n) {
        int dp[] = new int[n+1];
        if(n>=0){
            dp[0]=0;
        }
        if(n>=1){
            dp[1]=1;
        }
        int expected = 2;
        int idx = 0;
        for(int i=2;i<=n;i++){
            dp[i] = 1+dp[idx];
            if(dp[i]==expected){
                idx=0;
                expected+=1;
            } else {
                idx++;
            }
        }
        return dp;
    }
}