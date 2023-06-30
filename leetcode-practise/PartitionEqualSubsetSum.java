//416. Partition Equal Subset Sum
//https://leetcode.com/problems/partition-equal-subset-sum/description/

class Solution {
    //NeetCode Solution
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum%2 == 1){
            return false;
        }
        sum=sum/2;

        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        for(int num : nums){
            Set<Integer> nextDP = new HashSet<>();
            for(Integer add : dp){
                int total = add + num;
                if(total == sum){
                    return true;
                }
                nextDP.add(add+num);
                nextDP.add(add);
            }
            dp = nextDP;
        }
        return false;
    }
}
