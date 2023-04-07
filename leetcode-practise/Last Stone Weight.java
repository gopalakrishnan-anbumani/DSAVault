//1046. Last Stone Weight
//https://leetcode.com/problems/last-stone-weight/description/
//NeetCode - Heap / PQ


class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int stone : stones){
            pq.add(stone);
        }
        while(!pq.isEmpty()){
            int x = pq.poll();
            if(pq.isEmpty()){
                return x;
            }
            int y = pq.poll();
            int newStone = Math.abs(x - y);
            if(newStone > 0){
                pq.add(newStone);
            }
        }
        return 0;
    }
}
