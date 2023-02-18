//https://leetcode.com/problems/merge-intervals/description/
//Eduactive - Patterns Coding - Merge Intervals

class MergeIntervals {
    //LeetCode - Accepted. Solved by 1st try.
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n <= 1){
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int preStart = intervals[0][0];
        int preEnd = intervals[0][1];
        for(int i=1;i<n;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(preEnd < start){
                List interval = new ArrayList<>();
                interval.add(preStart);
                interval.add(preEnd);
                result.add(interval);
                preStart = start;
                preEnd = end;
            } else if(preEnd >= start && preEnd <= end){
                preEnd = end;
            }
        }
        List interval = new ArrayList<>();
        interval.add(preStart);
        interval.add(preEnd);
        result.add(interval);
        int[][] aa = new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            aa[i][0] = result.get(i).get(0);
            aa[i][1] = result.get(i).get(1);
        }
        return aa;
    }
    
    //Modified above solution in better way (Reference)
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(result.isEmpty()) {
                result.add(intervals[i]); 
                continue;
            }

            int[] interval = result.get(result.size()-1);
            if(interval[1] >= intervals[i][0]){
                interval[1] =  Math.max(intervals[i][1], interval[1]);
            } else {
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
