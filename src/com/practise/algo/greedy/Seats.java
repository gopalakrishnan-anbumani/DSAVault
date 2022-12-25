//https://www.interviewbit.com/problems/seats/
public class Seats {
    public int seats(String A) {
        int res = 0;
        char[] aa = A.toCharArray();
        ArrayList<Integer> crossIndex = new ArrayList();
        int index = 0;
        for(char a : aa) {
            if(a == 'x'){
                crossIndex.add(index);
            }
            index++;
        }
        int N = crossIndex.size();
        if(N==0) return 0;
        int[] moves = new int[N];
        for(int i=0;i<N;i++){
            moves[i] = crossIndex.get(i) - i;
        }
        
        int median = moves[(N-1) / 2];
        int total = 0;
        int mod = 10000003;
        for(int m : moves) {
            total = (total % mod + ( Math.abs(m - median) % mod)) % mod;
            
        }
        
        return total % mod;
        
        
    }
}

// FreeCodeCamp - greedy algorithm 
