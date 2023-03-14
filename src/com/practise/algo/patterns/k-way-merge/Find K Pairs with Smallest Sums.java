//373. Find K Pairs with Smallest Sums
//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
//Eduactive - Patterns - k Way Merge

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b) -> (a.get(0) + a.get(1)) - (b.get(0) + b.get(1)));
        for(int i = 0; i < nums1.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums1[i]);
            list.add(nums2[0]);
            list.add(0);
            pq.add(list);
        }
        int count = 0;
        while(!pq.isEmpty() && count < k){
            List<Integer> num = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(num.get(0));
            list.add(num.get(1));
            res.add(list);
            int num2 = num.get(2);

            List<Integer> list1 = new ArrayList<>();
            if(num2+1 < nums2.length){
                list1.add(num.get(0));
                list1.add(nums2[num2+1]);
                list1.add(num2+1);
                pq.add(list1);
            }
            count++;
        }


return res;


    }
}
