import java.util.HashMap;
import java.util.HashSet;

//403. Frog Jump
//https://leetcode.com/problems/frog-jump/description/
//
class FrogJump {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        for(int stone : stones){
            hm.put(stone, new HashSet<Integer>());
        }
        hm.get(stones[0]).add(1);
        int last= stones[stones.length-1];
        for(int i=0; i<stones.length; i++){
            int currentStone = stones[i];
            HashSet<Integer> jumps = hm.get(currentStone);
            for(int jump : jumps){
                int pos = currentStone + jump;
                if(pos == last){
                    return true;
                }
                if(hm.containsKey(pos)){
                    if(jump -1 > 0){
                        hm.get(pos).add(jump-1);
                    }
                    hm.get(pos).add(jump);
                    hm.get(pos).add(jump+1);
                }
            }
        }
        return false;
    }
}