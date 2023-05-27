//27. Remove Element
//https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&id=top-interview-150

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        int start = 0;
        int end = nums.length-1;
        while(start <=  end){
            if(nums[start] != val){
                start++;
                k++;
            } else if(nums[start] == val){
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
                end--;
            }
        }
        return k;
    }
}
