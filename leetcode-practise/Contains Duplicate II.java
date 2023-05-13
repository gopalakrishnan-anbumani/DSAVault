//219. Contains Duplicate II
//https://leetcode.com/problems/contains-duplicate-ii/
//


class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<=k && i< nums.length; i++){
            if(set.contains(nums[i])){
                System.gc();
                return true;
            }    
            set.add(nums[i]);
        }
        int start=0;
        for(int i=k+1; i< nums.length; i++){
            set.remove(nums[start]);
            if(set.contains(nums[i])){
                System.gc();
                return true;
            }    
            set.add(nums[i]);
            start++;
        }
        System.gc();
        return false;

    }
}
