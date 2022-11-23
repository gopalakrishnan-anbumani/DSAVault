//https://www.interviewbit.com/problems/assign-mice-to-holes/

public class AssignMiceToHoles {
    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        
        Collections.sort(A);
        Collections.sort(B);
        
        int ans = 0;
        for(int i=0; i < A.size(); i++){
            int move = Math.abs(A.get(i) - B.get(i));
            ans = Math.max(ans, move);
        }
        return ans;
    }
}


//FreeCodeCamp - YT - [Greedy Algorithms]
