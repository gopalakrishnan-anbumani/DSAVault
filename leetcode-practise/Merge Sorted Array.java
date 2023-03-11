//88. Merge Sorted Array
//https://leetcode.com/problems/merge-sorted-array/description/
//Leetcode 75


//My Solution
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        while(i < n && j < m){
            if(nums2[i] <= nums1[j]){
                moveElements(nums1, j, m);
                nums1[j] = nums2[i];
                i++;
                m++;
            } else {
                j++;
            }
        }
        while(i < n){
            nums1[m++] = nums2[i++]; 
        }
    }
    public void moveElements(int[] nums, int start, int end){
        while(end > start){
            nums[end] = nums[--end];
        }
    }
}
