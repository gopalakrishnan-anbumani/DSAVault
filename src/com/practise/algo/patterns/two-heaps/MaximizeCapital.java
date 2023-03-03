//LeetCode - https://leetcode.com/problems/ipo/description/
//Eduactive - Patterns

class MaximizeCapital {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int currentCapital = w;
        
        PriorityQueue<int[]> capitalMinHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int i=0;i<capital.length;i++){
            capitalMinHeap.offer(new int[]{capital[i], i});
        }
        PriorityQueue<int[]> profitMaxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int i = 0;
        while(i < k){
            while(!capitalMinHeap.isEmpty() && capitalMinHeap.peek()[0] <= currentCapital){
                int[] j = capitalMinHeap.poll();
                profitMaxHeap.offer(new int[]{profits[j[1]], j[1]});
            }
            if(profitMaxHeap.isEmpty()){
                break;
            }
            int[] maxProfit = profitMaxHeap.poll();
            currentCapital += maxProfit[0];
            i++;
        }
        return currentCapital;
        
    }
}
