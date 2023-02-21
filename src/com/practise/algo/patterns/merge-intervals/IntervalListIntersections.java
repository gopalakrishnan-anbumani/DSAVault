//https://leetcode.com/problems/interval-list-intersections/description/
//Eduactive - pattern Coding - Merge Intervals

class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i = 0; 
        int j = 0;
        while(i < firstList.length && j < secondList.length){
            if(firstList[i][1] < secondList[j][0]){
                i++;
            } else if(secondList[j][1] < firstList[i][0]){
                j++;
            } else {
                result.add(new int[]{Math.max(firstList[i][0], secondList[j][0]), Math.min(firstList[i][1], secondList[j][1])});
                if(firstList[i][1] < secondList[j][1]){
                    i++;
                } else {
                    j++;
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }
    
    //1st Solved. Not optimized.
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        Map<int[],List<int[]>> map = new HashMap<>();
        for(int i=0;i<firstList.length;i++){
            List<int[]> list = new ArrayList<>();
            for(int j=0;j<secondList.length;j++){
                int firstStart = firstList[i][0];
                int firstEnd = firstList[i][1];
                int secondStart = secondList[j][0];
                int secondEnd = secondList[j][1];
               
                if((firstStart >= secondStart && firstStart <= secondEnd)
                    || (firstStart <= secondEnd && firstEnd > secondEnd)
                    || (firstStart < secondStart && firstEnd >= secondStart)){
                        list.add(secondList[j]);
                } else if((secondStart >= firstStart && secondEnd <= firstEnd) 
                    || (secondStart <= firstEnd && secondEnd > firstEnd) 
                    || (secondStart < firstStart && secondEnd >= firstStart)){
                        list.add(secondList[j]);
                }
            }
            if(!list.isEmpty()){
                map.put(firstList[i], list);
            }
        }
        List<int[]> result = new ArrayList<>();
        for(int i=0;i<firstList.length;i++){
            if(map.containsKey(firstList[i])){
                List<int[]> list = map.get(firstList[i]);
                for(int[] interval : list){
                    result.add(new int[]{Math.max(firstList[i][0], interval[0]), Math.min(firstList[i][1], interval[1])});
                }
            }
            
        }

        return result.toArray(new int[result.size()][]);
    }
}
