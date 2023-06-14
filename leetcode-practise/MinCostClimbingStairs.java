//746. Min Cost Climbing Stairs
//https://leetcode.com/problems/min-cost-climbing-stairs/description/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] step = new int[cost.length];
        step[0]=cost[0];
        step[1]=cost[1];
        for(int i=2;i<cost.length;i++){
            step[i]=cost[i]+Math.min(step[i-1], step[i-2]);
        }
        return Math.min(step[cost.length-1],step[cost.length-2]);
    }
}
