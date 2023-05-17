//1337. The K Weakest Rows in a Matrix
//https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/description/

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0] );
        int m = mat.length;
        for(int i=0;i<m;i++){
            int count = 0;
            for(int sol : mat[i]){
                if(sol == 1){
                    count++;
                } else {
                    break;
                }
            }
            pq.add(new int[]{count, i});
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = pq.poll()[1];
        }
        return res;
    }
}
