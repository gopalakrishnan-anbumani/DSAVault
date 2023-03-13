//Kth Smallest Number in M Sorted Lists
//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
//LeetCode same like. It's Eduactive problem - In Eduactive given the list which only rows sorted. 
//Eduactive - Patterns - K way Merge

class FindSmallestNumber {
  public static int kSmallestNumber(List<List<Integer>> lists, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<lists.size();i++){
            int col = lists.get(i).size();
            for(int j=0;j<col;j++){
                pq.add(lists.get(i).get(j));
            }
        }
        int count = 0;
        int res = 0;
        while(!pq.isEmpty() && count < k){
            res = pq.poll();
            count++;
        }
        return res;
  }
}
