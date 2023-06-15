//198. House Robber
//https://leetcode.com/problems/house-robber/description


class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[] rob = new int[n];
        for(int i=0;i<n;i++){
            int max = 0;
            if(i-2>=0){
                max = Math.max(max, rob[i-2]);
            }
            if(i-3>=0){
                max = Math.max(max, rob[i-3]);
            }
            rob[i]= nums[i]+max;
        }
        return Math.max(rob[n-1], rob[n-2]);
    }
}
