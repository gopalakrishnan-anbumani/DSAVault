class CountElementOccurance {
    //Did BS in sorted array to find element. Then did normal search
    public int[] searchRange(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[2];
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target){
                
                int s = mid -1;
                while(s >=0  && nums[s] == target){
                    s--;
                }
                s+=1;
                int e = mid + 1;    
                while(e < nums.length && nums[e] == target){
                    e++;
                }
                e-=1;
                return new int[]{s,e};
                
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return new int[]{-1,-1};
        
    }
}


Question:

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.
