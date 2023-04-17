//55. Jump Game
//https://leetcode.com/problems/jump-game/description/
//Eduactive - Pattern - Greedy

class Solution {
    //My Solution
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int i = 0;
        if(n<=1) return true;
        while(i<n){
            int jump = nums[i];
            int k=-1;
            if(jump == 0) return false;
            int maxIndex = i; 
            if(i+jump >= n-1) return true;
            while(jump > 0 && jump+i < n){
                if(k < i+jump+nums[i+jump]){
                    k = i+jump+nums[i+jump];
                    maxIndex = jump;
                }
                jump--;
            }
            i = i + maxIndex;
            if(i >= n) return true;
        }
        return true;
    }
}