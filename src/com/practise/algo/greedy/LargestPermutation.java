//https://www.interviewbit.com/problems/largest-permutation/
//Given an integer array A of size N consisting of unique integers from 1 to N. You can swap any two integers atmost B times.
//Return the largest lexicographical value array that can be created by executing atmost B swaps.

public class LargestPermutation {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        int max = N;
        
        Map<Integer, Integer> map = new HashMap(); //Num <> Index
        for(int i=0;i < N; i++){
            map.put(A.get(Integer.valueOf(i)), Integer.valueOf(i));
        }
        int i = 0;
        while(B > 0 && i < N){
            int j = map.get(Integer.valueOf(max)); //4
            if(A.get(i) == N-i){
                --max;
                i++;
                continue;
            }
            if(i != j){
                --B;
                map.put(A.get(j), i);    // 5->4  3->0
                map.put(A.get(i), j);
                int temp = A.get(i);
                A.set(i, A.get(j));
                A.set(j, temp);		//swap 0 <> 4
            } 

            --max;
            i++;
        }
        return A;
    }
}


/*FreeCodeCamp - Greedy Algorithm*/
//Ref: https://www.geeksforgeeks.org/largest-permutation-k-swaps/
