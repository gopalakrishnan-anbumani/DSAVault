//LeetCode - https://leetcode.com/problems/find-right-interval/description/

class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        HashMap<Integer, Integer> hm = new HashMap();
        int max = 0;
        for(int i=0; i < intervals.length; i++){
            int[] interval = intervals[i];
            hm.put(interval[0], i);
            max = Math.max(max, interval[0]);
        }
        int[] result = new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            int[] interval = intervals[i];
            int end = interval[1];
            int index = -1;
            while(end <= max){
                if(hm.containsKey(end)){
                    index = hm.get(end);
                    break;
                }
                end++;
            }
            result[i] = index;
        }
        return result;
    }
}
