//238. Product of Array Except Self
//https://leetcode.com/problems/product-of-array-except-self/description/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] postfix = new int[n];
        int preVal = 1;
        for(int i=0;i<n;i++){
            preVal = preVal * nums[i];
            prefix[i] = preVal;
        }
        int postVal = 1;
        for(int i=n-1;i>=0;i--){
            postVal = postVal * nums[i];
            postfix[i] = postVal;
        }
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            int prev = i-1 < 0 ? 1 : prefix[i-1];
            int post = i+1 >= n ? 1 : postfix[i+1];
            result[i] = prev*post;
        }
        return result;
    }
}
