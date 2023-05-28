//26. Remove Duplicates from Sorted Array
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        
        for(int i=1;i<nums.length;i++){
            if(nums[i] != nums[k-1]){
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
