
//45. Jump Game II
//https://leetcode.com/problems/jump-game-ii/description/
public class JumpGameII {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        return rec(0, nums, dp);
    }

    public int rec(int idx, int[] nums, int[] dp){
        if(idx >= nums.length-1){
            return 0;
        }
        if(dp[idx]!=0){
            return dp[idx];
        }
        int jump = nums[idx];
        int min = 10000;
        for(int i=1; i<=jump; i++){
            min = Math.min(min, 1 + rec(idx+i, nums, dp));
        }
        return dp[idx] = min;
    }
}
