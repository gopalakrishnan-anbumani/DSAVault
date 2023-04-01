//540. Single Element in a Sorted Array
//https://leetcode.com/problems/single-element-in-a-sorted-array/description/
//Eduactive - Patterns - Modified Binary Search

class SingleElementSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = low + (high-low)/2;
            if(mid % 2 == 1) mid--;
            if(nums[mid] == nums[mid+1]){
                low = mid + 2;
            } else {
                high = mid-1;
            }
        }
        return nums[low];
    }
}

