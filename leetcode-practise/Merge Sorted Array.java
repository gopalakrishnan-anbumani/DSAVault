//88. Merge Sorted Array
//https://leetcode.com/problems/merge-sorted-array/description/
//Eduactive - Patterns - K way Merge

//Solution in Eduactive
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = m-1;
        int n2 = n-1;
        int p = m+n-1;
        while(n2 >= 0){
            if(n1 >= 0 && nums1[n1] > nums2[n2]){ 
                nums1[p] = nums1[n1];
                n1--;
            } else {
                nums1[p] = nums2[n2];
                n2--;
            } 
            p--;
        }
    }
}

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
