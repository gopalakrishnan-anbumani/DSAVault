//https://leetcode.com/problems/minimum-size-subarray-sum/description/
//Eduactive - Patterns - Sliding Window

class MinSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int sum = 0;
        while(r<n){
            sum += nums[r];
            while(sum >= target){
                min = Math.min(min, r-l+1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
