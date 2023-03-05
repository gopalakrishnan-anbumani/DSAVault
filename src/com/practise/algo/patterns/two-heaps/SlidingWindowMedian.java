//https://leetcode.com/problems/sliding-window-median/description/
//Eduactive - Patterns

class SlidingWindowMedian {
    PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();
    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> result = new ArrayList<>();
        for(int i=0;i<k;i++){
            addNum(nums[i]);
        }
        result.add(findMedian());
        for(int i=k;i<nums.length;i++){
            int removeIndex = i-k;
            if(!leftMaxHeap.remove(nums[removeIndex])){
                rightMinHeap.remove(nums[removeIndex]);
            }
            addNum(nums[i]);
            result.add(findMedian());
        }
        return result.stream().mapToDouble(Double::doubleValue).toArray();
    }
    public void addNum(int num){
        if(leftMaxHeap.isEmpty() || leftMaxHeap.peek() >= num){
            leftMaxHeap.add(num);
        } else {
            rightMinHeap.add(num);
        }

        if(leftMaxHeap.size() > rightMinHeap.size()+1){
            rightMinHeap.add(leftMaxHeap.poll());
        } else if(rightMinHeap.size() > leftMaxHeap.size()){
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }
    public double findMedian(){
        if(leftMaxHeap.size() > rightMinHeap.size()){
            return leftMaxHeap.peek()/1.0;
        } else {
            return (leftMaxHeap.peek()/2.0 + rightMinHeap.peek()/2.0);
        }
    }
}
