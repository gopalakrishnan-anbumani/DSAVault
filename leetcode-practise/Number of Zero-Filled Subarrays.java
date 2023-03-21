//2348. Number of Zero-Filled Subarrays
//https://leetcode.com/problems/number-of-zero-filled-subarrays/description/
//LeetCode - Daily Challenge - 21-03-2023
//Explaination - https://www.youtube.com/watch?v=G-EWVGCcL_w

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                count+=1;
                res+=count;
            } else {
                count = 0;
            }
        }
        return res;
    }
}
