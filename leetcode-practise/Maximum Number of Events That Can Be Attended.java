//1353. Maximum Number of Events That Can Be Attended
//https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/
//

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });
        //for(int[] event : events){
            //System.out.println(Arrays.toString(event));
        //}
        int result = 0;
        int j = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1;i<100001;i++){
            while(!pq.isEmpty() && pq.peek() < i){
                pq.poll();
            }
            for(; j < events.length && events[j][0]==i; j++){
                pq.offer(events[j][1]);
            }
            if(!pq.isEmpty()){
                pq.poll();
                result++;
            }
        }
        return result;
    }
}
