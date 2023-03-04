//LeetCode - https://leetcode.com/problems/find-median-from-data-stream/description/
//Eduactive - Patterns
class FindMedianFromDataStream {
    PriorityQueue<Integer> leftMax;
    PriorityQueue<Integer> rightMin;
    int size;
    public MedianFinder() {
        leftMax = new PriorityQueue<>(Collections.reverseOrder());
        rightMin = new PriorityQueue<>();
        size=0;
    }
    
    public void addNum(int num) {
        int futureSize = size + 1;
        while(size < futureSize){
            if(leftMax.size() > rightMin.size()) {
                //Insert In Right
                if(leftMax.isEmpty() || num >= leftMax.peek()){
                    rightMin.add(num);
                    size+=1;
                } else {
                    int element = leftMax.poll();
                    rightMin.add(element);
                }
            } else {
                //Insert In Left
                if(rightMin.isEmpty() || num <= rightMin.peek()){
                    leftMax.add(num);
                    size+=1;
                } else {
                    int element = rightMin.poll();
                    leftMax.add(element);
                }
            }
        }
    }
    
    public double findMedian() {
        if(size % 2 == 0){
            int add = leftMax.peek() + rightMin.peek();
            return (double) add/2;
        } else {
            return (double) leftMax.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
