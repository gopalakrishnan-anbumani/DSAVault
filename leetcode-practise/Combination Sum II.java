//40. Combination Sum II
//https://leetcode.com/problems/combination-sum-ii/description/
//https://takeuforward.org/data-structure/combination-sum-ii-find-all-unique-combinations/

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int target1;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        target1 = target;
        rec(candidates, new ArrayList<>(), 0, 0);
        return result;
    }
    public void rec(int[] candidates, List<Integer> list, int sum, int index){
        //System.out.println(list + " " + sum);
        if(sum == target1){
            boolean isFound = false;
            //for(List<Integer> res : result){
                //if(res.equals(list)){
                    //isFound = true;
                //}
            //}
            //if(!isFound){
                result.add(new ArrayList<Integer>(list));
            //}
            return;
        }
        if(sum > target1){
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(i > index && candidates[i] == candidates[i-1]) continue;
            sum = sum + candidates[i];
            if(sum > target1){
                break;
            }
            list.add(candidates[i]);
            rec(candidates, list, sum, i+1);
            list.remove(Integer.valueOf(candidates[i]));
            sum = sum - candidates[i];
        }
    }

}
