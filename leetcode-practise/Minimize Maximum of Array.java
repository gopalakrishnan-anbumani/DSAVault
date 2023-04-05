//2439. Minimize Maximum of Array
//https://leetcode.com/problems/minimize-maximum-of-array/description/
//LeetCode - Daily Challenge - 05-04-2023
//Explaination - NeetCode

class Solution {
    public int minimizeArrayValue(int[] nums) {
        long result = nums[0];
        long total = nums[0];
        for(int i=1;i<nums.length;i++){
            total += nums[i];
            result = Math.max(result, (long)Math.ceil((double)(total)/(double)(i+1)));
        }
        return (int)result;
    }
}
