//268. Missing Number
//https://leetcode.com/problems/missing-number/description/
//MissingNumbers

//Cyclic Sort Algorithm
public class MissingNumbers {

    /**
     * Using Cyclic Sorting
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i < n){
            int num = nums[i];
            if(num < n && i != num){
                int temp = nums[num];
                nums[num] = num;
                nums[i] = temp;
                continue;
            }
            i++;
        }
        int j=0;
        for(j=0;j<n;j++){
            if(j != nums[j]){
                return j;
            }
        }
        return j;
    }


    /**
     * Using sum of natural nums
     * @param nums
     * @return
     */
    public int missingNumberUsingSum(int[] nums) {
        int n=nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int total = (n*(n+1))/2;
        return total-sum;
    }
}