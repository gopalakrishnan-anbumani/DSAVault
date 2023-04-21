//1353. Maximum Number of Events That Can Be Attended
//https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/
//

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[1] != b[1]){
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });
        for(int[] event : events){
        System.out.println(Arrays.toString(event));
        }
        int result = 0;
        int lastDay = -1;
        for(int[] event : events){
            int eventStart = event[0];
            int eventEnd = event[1];
            for(int i = eventStart; i <= eventEnd ; i++){
                if(i > lastDay){
                    result += 1;
                    lastDay = i;
                    break;
                }
            }
        }
        return result;
    }
}
