//673. Number of Longest Increasing Subsequence
//https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/



//My Solution. Have to optimize it or Format it
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int[] count = new int[nums.length];
        count[0] = 1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);

        for(int i=1;i<nums.length;i++){
            pq.clear();
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    int len = 1+dp[j];
                    dp[i] = Math.max(dp[i], len);
                    if(pq.isEmpty()){
                        int[] c = new int[]{len, count[j]};
                        pq.add(c);
                    } else {
                        int[] c = pq.poll();
                        if(c[0] == len){
                            pq.add(new int[]{len, c[1]+count[j]});
                        } else if(c[0] < len){
                            pq.add(new int[]{len, count[j]});
                        } else {
                            pq.add(new int[]{c[0], c[1]});
                        }
                    }
                }
            }
            count[i] = !pq.isEmpty() ? pq.poll()[1] : 1;
        }
        pq.clear();
        pq.add(new int[]{dp[0], count[0]});
        for(int i=1;i<nums.length;i++){
            int[] c = pq.poll();
            if(c[0] == dp[i]){
                pq.add(new int[]{c[0], c[1]+count[i]});
            } else if(c[0] < dp[i]){
                pq.add(new int[]{dp[i], count[i]});
            } else {
                pq.add(new int[]{c[0], c[1]});
            }
        }

        return pq.poll()[1];
    }
}