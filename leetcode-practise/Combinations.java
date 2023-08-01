//77. Combinations
//https://leetcode.com/problems/combinations/description/


import java.util.ArrayList;
import java.util.List;

class Combinations {
    int n = 0;
    int k = 0;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n1, int k1) {
        n = n1;
        k = k1;
        List<Integer> list = new ArrayList<>();
        bakcTrack(1, 0, list);
        return res;
    }

    public void bakcTrack(int idx, int count, List<Integer> list){

        if(count == k){
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i=idx;i<=n;i++){
            list.add(i);
            bakcTrack(i+1, count+1, list);
            list.remove(list.size()-1);
        }

    }
}