//11. Container With Most Water
//https://leetcode.com/problems/container-with-most-water/description/
//NeetCode - 2Pointers

class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int result = 0;
        while(l < r){
            result = Math.max(result, (r-l)*Math.min(height[l], height[r]));
            if(height[l] > height[r]){
                r--;
            } else {
                l++;
            }
        }
        return result;
    }
}
