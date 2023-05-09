//473. Matchsticks to Square
//https://leetcode.com/problems/matchsticks-to-square/description/
//Tired solution is added

class Solution {
    int size = 0;
    int side[] = new int[4];
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length < 4){
            return false;
        }
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for(int match : matchsticks){
            sum+=match;
            list.add(match);
        }
        if(sum%4!=0){
            return false;
        }
        size = sum/4;
        Collections.sort(list, Collections.reverseOrder());
        return rec(list, 0);
    }
    public boolean rec(List<Integer> sticks, int index){
        if(index == sticks.size()){
            return true;
        }
        for(int i=0;i<4;i++){
            if(side[i]+sticks.get(index) <= size){
                side[i] += sticks.get(index);
                if(rec(sticks, index+1)){
                    return true;
                }
                side[i] -= sticks.get(index);
            }
        }
        return false;
    }
}


//Tried with few test cases passed. most tc failed.
class Solution1 {
    int size = 0;
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length < 4){
            return false;
        }
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for(int match : matchsticks){
            sum+=match;
            list.add(match);
        }
        if(sum%4!=0){
            return false;
        }
        size = sum/4;
        Collections.sort(list);
        return rec(list, 0, 0);
    }
    public boolean rec(List<Integer> sticks, int side, int count){
        System.out.println(sticks+ "  " + side +" " + count);
        if(count==4 && sticks.isEmpty()){
            //System.out.println("1");
            return true;
        }
        if(sticks.isEmpty() && count != 4){
            System.out.println("2 "+ count);
            return false;
        }
        if(sticks.get(sticks.size()-1) + side == size){
            sticks.remove(sticks.size()-1);
            return rec(sticks, 0, count+1);
        }
        for(int i=sticks.size()-1; i >=0 ; i--){
            int temp = sticks.get(i);
            if(side+temp <= size){
                sticks.remove(i);
                boolean res = rec(sticks, side+temp, count);
                if(res){
                    return true;
                } else {
                    sticks.add(temp);
                }
            }
        }
        System.out.println("4");
        return false;
    }
}
