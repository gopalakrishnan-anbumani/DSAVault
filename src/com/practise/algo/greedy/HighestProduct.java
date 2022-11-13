//Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
//https://leetcode.com/problems/maximum-product-of-three-numbers/

class HighestProduct {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int h3 = nums[n-1] * nums[n-2] * nums[n-3];
        int l2h1 = nums[0] * nums[1] * nums[n-1];
        return Math.max(h3, l2h1);
    }
}


/* FreeCodeCamp - Greedy Algorithm Series */
