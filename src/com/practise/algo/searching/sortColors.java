//https://leetcode.com/problems/sort-colors/
class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length -1;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            } else if(nums[mid] == 1){
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }
    
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    //try with for loop
    public void sortColors1(int[] nums) {
        int l = 0;
        int h = nums.length -1;
        for(int i=0;i<=h;i++){
            if(nums[i] == 0){
                swap(nums, l, i);
                l++;
            } 
            if(nums[i] == 2){
                swap(nums, i, h);
                --h;
                i--;
            }
        }
    }
}


//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

//You must solve this problem without using the library's sort function.
