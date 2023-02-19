//
//Eduactive - Pattern Coding - Merge Intervals

class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        
        //add the intervals starting before the new Intervals
        int i=0;
        while(i < n && intervals[i][0] <= newInterval[0]){
            result.add(intervals[i]);
            i++;
        }
        //Add new interval. If last interval overlapping change the end to max value. otherwise add the new interval
        if(!result.isEmpty() && result.get(result.size()-1)[1] >= newInterval[0] ){
            result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1], newInterval[1]);
        } else {
            result.add(newInterval);
        }
        //Add the intervals to existing result. Merge the intervals if it's overlapping.
        while(i<n){
            if(result.get(result.size()-1)[1] >= intervals[i][0]){
                result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1], intervals[i][1]);
            } else {
                result.add(intervals[i]);
            }
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
}
