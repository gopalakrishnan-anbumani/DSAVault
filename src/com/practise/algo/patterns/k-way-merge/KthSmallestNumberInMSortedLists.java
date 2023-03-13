//Kth Smallest Number in M Sorted Lists
//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
//LeetCode same like. It's Eduactive problem - In Eduactive given the list which only rows sorted. 
//Eduactive - Patterns - K way Merge

class FindSmallestNumber {
  
  //This solution put all the values in priority Queue. From Queue, get the kth element. Added Optimized Solution below
  public static int kSmallestNumber1(List<List<Integer>> lists, int k) {
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
  
  
  //Using K way merge. Insert only 1st element from all the array.
  public static int kSmallestNumber(List<List<Integer>> lists, int k) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
	        for(int i=0;i<lists.size();i++){
	            pq.add(new int[] {lists.get(i).get(0), i, 0});
	        }
	        int count = 0;
	        int[] res = null;
	        while(!pq.isEmpty() && count < k){
	            res = pq.poll();
	            count++;
	            int row = res[1];
	            int index = res[2];
	            if(lists.get(row).size() > index+1) {
	            	pq.add(new int[] {lists.get(row).get(index+1), row, index+1});
	            }
	        }
	        return res == null ? 0 : res[0];
  }

}
