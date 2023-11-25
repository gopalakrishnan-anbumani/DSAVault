//https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/description/
//1685. Sum of Absolute Differences in a Sorted Array
public class SumOfAbsoluteDifferencesInASortedArray {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] res = new int[nums.length];
        int[] pre = new int[nums.length];
        int[] suf = new int[nums.length];
        pre[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pre[i] = pre[i-1] + nums[i];
        }
        suf[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            suf[i] = suf[i+1] + nums[i];
        }

        for(int i=0;i<nums.length;i++){
            int preSum = pre[i] - nums[i];
            preSum = (nums[i]*i) - preSum;

            int sufSum = suf[i] - nums[i];
            sufSum = sufSum - (nums[i]*(nums.length-1-i));

            res[i] = preSum+sufSum;

        }
        return res;
    }
}
