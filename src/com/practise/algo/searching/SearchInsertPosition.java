class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while(start <= end) {
            mid = (start + end) / 2;
            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if(nums[mid] < target) {
            return mid+1;
        } else {
            return mid;
        }
    }
}


//https://leetcode.com/problems/search-insert-position/
//Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

//You must write an algorithm with O(log n) runtime complexity.

//Eduactive - Seraching
