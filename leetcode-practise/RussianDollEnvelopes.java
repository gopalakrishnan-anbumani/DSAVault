//354. Russian Doll Envelopes
//https://leetcode.com/problems/russian-doll-envelopes/description/


class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
        //System.out.println(Arrays.deepToString(envelopes));
        int n = envelopes.length;
        List<Integer> list = new ArrayList<>();
        int max = 1;
        for(int i=0;i<n;i++){
            int idx = binarySearch(list, envelopes[i][1]);
            if(idx == -1){
                list.add(envelopes[i][1]);
            } else {
                list.set(idx, envelopes[i][1]);
            }
        }
        return list.size();
    }
    public int binarySearch(List<Integer> list, int num){
        int s = 0;
        int e = list.size()-1;
        int res = -1;
        while(s<=e){
            int mid = (s+e)/2;
            if(list.get(mid) >= num){
                res = mid;
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
        return res;
    }
}