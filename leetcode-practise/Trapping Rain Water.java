//42. Trapping Rain Water
//https://leetcode.com/problems/trapping-rain-water/

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        
        int[] lHeights = new int[n];
        lHeights[0] = height[0];
        for(int i=1; i<n;i++){
            lHeights[i] = Math.max(lHeights[i-1], height[i]);
        }

        int[] rHeights = new int[n];
        rHeights[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            rHeights[i] = Math.max(rHeights[i+1], height[i]);
        }

        for(int i=1;i<n-1;i++){
            int min = Math.min(lHeights[i],rHeights[i]);
            res = res + min - height[i];
        }
        return res;
    }
}
