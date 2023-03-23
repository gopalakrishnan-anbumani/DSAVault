//973. K Closest Points to Origin
//https://leetcode.com/problems/k-closest-points-to-origin/description/
//Eduactive - Patterns - 23-03-2023

class KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (((b[0]*b[0])+(b[1]*b[1])) - ((a[0]*a[0])+(a[1]*a[1]))));
        for(int[] point : points){
            pq.add(point);
            while(pq.size() > k){
                pq.poll();
            }
        }
        int count=0;
        int[][] res = new int[k][2];
        while(!pq.isEmpty()){
            res[count] = pq.poll();
            count++;
        }
        return res;
    }
}
