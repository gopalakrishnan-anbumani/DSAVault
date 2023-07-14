//646. Maximum Length of Pair Chain
//https://leetcode.com/problems/maximum-length-of-pair-chain/description/

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> a[1] - b[1]);
        int res = 0;
        int last = Integer.MIN_VALUE;
        for(int[] pair: pairs){
            if(last < pair[0]){
                res++;
                last = pair[1];
            }
        }
        return res;
    }
}