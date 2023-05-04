//42. Trapping Rain Water
//https://leetcode.com/problems/trapping-rain-water/


class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        int l=0;
        int r=0;
        while(l < n){
            while(height[l] == 0){
                l++;
            }
            r=l+1;
            while(r < n && height[r] < height[l]){
                r++;
            }
            
            if(r >= n){
                return res;
            }
            System.out.println("l ="+height[l] + " r= "+height[r]);
            int min = Math.max(height[r],height[l]);
            l++;
            r--;
            while(l <= r){
                res += (min - height[l]);
                l++;
            }
            r=r+2;
            l=r;
            System.out.println("l. ="+l + " r.= "+r);
        }
        return res;
    }
}
