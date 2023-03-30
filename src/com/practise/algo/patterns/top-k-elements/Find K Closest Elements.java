//658. Find K Closest Elements
//https://leetcode.com/problems/find-k-closest-elements/description/
//Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new ElementComparator());
        for(int a : arr){
            int[] diff = new int[2];
            diff[0] = a;
            diff[1] = Math.abs(a - x);
            pq.add(diff);
        }
        List<Integer> res = new ArrayList<>();
        int count=0;
        while(count < k){
            res.add(pq.poll()[0]);
            count++;
        }
        Collections.sort(res);
        return res;
    }

    public class ElementComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b){
            if(a[1] - b[1] != 0){
                return a[1] - b[1];
            } else {
                if(a[0] < b[0]){
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    } 
}
