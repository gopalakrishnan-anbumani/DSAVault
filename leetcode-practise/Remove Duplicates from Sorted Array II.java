//80. Remove Duplicates from Sorted Array II
//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/

class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int prevNumber=nums[0];
        int count=1;
        for(int i=1; i < nums.length; i++){
            if(prevNumber == nums[i]){
                count++;
            } else {
                prevNumber = nums[i];
                count = 1;
            }
            if(count<=2){
                nums[k++] = nums[i];
            }
        }
        System.gc();
        return k;
    }
}
