//703. Kth Largest Element in a Stream
//https://leetcode.com/problems/kth-largest-element-in-a-stream/description/

class KthLargest {
    int k;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums){
            maxHeap.add(num);
        }
        int count = 0;
        while(count < k && !maxHeap.isEmpty()){
            minHeap.add(maxHeap.poll());
            count++;
        }
        while(count < k){
            minHeap.add(Integer.MIN_VALUE);
            count++;
        }
    }
    
    public int add(int val) {
        int kValue = minHeap.isEmpty() ? Integer.MIN_VALUE : minHeap.peek();
        if(kValue > val){
            return kValue;
        } else {
            minHeap.poll();
            minHeap.add(val);
            return minHeap.peek();
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
