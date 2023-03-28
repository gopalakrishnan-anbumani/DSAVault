//983. Minimum Cost For Tickets
//https://leetcode.com/problems/minimum-cost-for-tickets/description/
//LeetCode Daily Challenge - 28/3/2023

class Solution {
    HashMap<Integer, List<Integer>> hm = new HashMap<>();
    public int mincostTickets(int[] days, int[] costs) {
        int noOfDays = days[days.length - 1];
        int dp[] = new int[noOfDays+1];
        Set<Integer> set = new HashSet<>();
        for(int day : days){
            set.add(day);
        }
        int day1Pass = costs[0];
        int day7Pass = costs[1];
        int day30Pass = costs[2];
        
        for(int i=1; i<=noOfDays;i++){
            if(set.contains(i)){
                int Day1 = day1Pass + dp[i-1];
                int Day7 = day7Pass + (i-7 < 0 ? dp[0] : dp[i-7]);
                int Day30 = day30Pass + (i-30 < 0 ? dp[0] : dp[i-30]);
                dp[i] = Math.min(Math.min(Day1, Day7), Day30);
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[noOfDays];
    }
}
