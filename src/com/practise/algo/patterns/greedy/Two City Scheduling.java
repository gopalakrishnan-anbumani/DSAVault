//1029. Two City Scheduling
//https://leetcode.com/problems/two-city-scheduling/description/
//Eduactive - LeetCode


class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return ((a[0]-a[1]) - (b[0]-b[1])); 
            }
        });
        int result = 0;
        for(int i=0; i < costs.length; i++){
            //System.out.println(Arrays.toString(cost));
            if(i < (costs.length/2)){
                result += costs[i][0];
            } else {
                result += costs[i][1];
            }
        }
        return result;
    }
}