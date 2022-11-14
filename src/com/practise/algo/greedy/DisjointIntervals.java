//https://www.interviewbit.com/problems/disjoint-intervals/
//Given a set of N intervals denoted by 2D array A of size N x 2, the task is to find the length of maximal set of mutually disjoint intervals.
//Two intervals [x, y] & [p, q] are said to be disjoint if they do not have any point in common.

public class DisjointIntervals {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        
        Collections.sort(A, new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(1).compareTo(o2.get(1));
            } 
        });
        
        int prev_s = A.get(0).get(0);
        int prev_e = A.get(0).get(1);
        int count = 1;
        
        for(ArrayList<Integer> a : A){
            if(prev_e >= a.get(0)){
                continue;
            } else {
                prev_s = a.get(0);
                prev_e = a.get(1);
                count++;
            }
        }
        
        return count;
    }
}


// FreeCodeCamp - Greedy Algorithm
//https://www.youtube.com/watch?v=bC7o8P_Ste4&t=536s
