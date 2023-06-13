//300. Longest Increasing Subsequence
//https://leetcode.com/problems/longest-increasing-subsequence/description/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tt = new int[nums.length];
        Arrays.fill(tt,1);
        for(int i=0;i<nums.length;i++){
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    tt[i] = Math.max(1+tt[j], tt[i]);
                }
            }
        }
        int max = 1;
        for(int m : tt){
            max = Math.max(max, m);
        }
        return max;
    }
}
