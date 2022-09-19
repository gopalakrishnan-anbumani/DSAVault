class RotatedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        return find(nums, target, 0, nums.length - 1);
    }
    
    public int find(int[] nums, int target, int L, int R){
        int mid = (L + R) / 2;
        System.out.println(L + " " + R);
        if(nums[mid] == target){
            return mid;
        }
        if(L > R || L < 0 || R < 0){
            return -1;
        }
        if(nums[L] == target){
            return L;
        }
        if(nums[R] == target){
            return R;
        }
        // Any of the one side will be sorted
        if(nums[L] < nums[mid]) { // check left sorted.
            if(nums[mid] > target && nums[L] <= target){  // if N within range, then it should be in lefe side
                return find(nums, target, L, mid-1);
            } else {
                return find(nums, target, mid + 1, R);      // if it is not inside sorted array, then search in another half
            }
        } else if(nums[mid] < nums[R]){
            if(nums[mid] < target && nums[R] >= target){    // above same logic
                return find(nums, target, mid + 1, R);
            } else {
                return find(nums, target, L, mid-1);
            }
        }
        return -1;
    }
}
