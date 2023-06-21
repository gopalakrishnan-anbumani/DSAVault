//https://leetcode.com/problems/delete-and-earn/description/
//740. Delete and Earn


class Solution {
    
    public int deleteAndEarn(int[] nums) {
        return del(nums);
    }
    public int del(int[] nums){
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num : nums){
            if(!list.contains(num)){
                list.add(num);
            }
            hm.put(num, hm.getOrDefault(num,0)+1);
        }
        Collections.sort(list);
        int[] dp = new int[list.size()];
        dp[0] = list.get(0) * hm.get(list.get(0));
        for(int i=1; i<list.size(); i++){
            int num = list.get(i);
            if(num-1 ==list.get(i-1)){ //plus one num
                int cSum = num * hm.get(num);
                int prev = i-2 >= 0 ? dp[i-2] : 0;
                dp[i]=Math.max(dp[i-1], cSum+prev);
            } else {
                dp[i]=dp[i-1]+(num * hm.get(num));
            }
        }
        return dp[list.size()-1];
    }
}
