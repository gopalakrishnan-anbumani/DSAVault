//973. K Closest Points to Origin
//https://leetcode.com/problems/k-closest-points-to-origin/description/
//Eduactive - Patterns - 23-03-2023


//Priority Queue
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

//Modified Bianry Search
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        if(arr.length == k){
            for(int a : arr){
                list.add(a);
            }
            return list;
        }
        int left = bst(arr, x) - 1;
        int right = left + 1;
        while(right - left - 1< k){
            if(left == -1){
                right++;
                continue;
            }
            if(right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)){
                left -= 1;
            } else {
                right += 1;
            }
        }
        for(int i=left+1; i < right ; i++){
            list.add(arr[i]);
        }
        return list;
    }

    public int bst(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == x){
                return mid;
            } else if(arr[mid] < x){
                low = mid + 1;
            } else{
                high = mid-1;
            }
        }
        return low;
    }
    
}
