//347. Top K Frequent Elements
//https://leetcode.com/problems/top-k-frequent-elements/description/
//Eduactive - Top K Element

class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        Map<Integer, Integer> hm = new HashMap<>();
        for(int num : nums){
            int count = hm.getOrDefault(num, 0) + 1;
            hm.put(num, count);
        }
        pq.addAll(hm.entrySet());
        int[] res = new int[k];
        int count = 0;
        while(count < k){
            res[count++] = pq.poll().getKey();
        }
        return res;
    }
}
