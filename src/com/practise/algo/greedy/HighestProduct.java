//Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
//https://leetcode.com/problems/maximum-product-of-three-numbers/

class HighestProduct {
    //Took 95ms
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int h3 = nums[n-1] * nums[n-2] * nums[n-3];
        int l2h1 = nums[0] * nums[1] * nums[n-1];
        return Math.max(h3, l2h1);
    }
    //Took 6ms *Best Solution*
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int n : nums){
            if(n >= max1){
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if(n >= max2){
                max3 = max2;
                max2 = n;
            } else if(n > max3) {
                max3 = n;
            }
            
            if(n <= min1){
                min2 = min1;
                min1 = n;
            } else if(n < min2){
                min2 = n;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
        
    }
    
}


/* FreeCodeCamp - Greedy Algorithm Series */
