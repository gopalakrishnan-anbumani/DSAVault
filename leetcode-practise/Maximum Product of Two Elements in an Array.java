//1464. Maximum Product of Two Elements in an Array
//https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/description/

class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a);
        for(int n :nums){
            pq.add(n-1);
        }
        return pq.poll()*pq.poll();
    }
}
