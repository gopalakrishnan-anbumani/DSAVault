//https://www.interviewbit.com/problems/gas-station/

public class GasStation {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        
        List<Integer> gasFill = new ArrayList<>();
        for(Integer a : A){
            gasFill.add(a);
        }
        for(Integer a : A){
            gasFill.add(a);
        }
        
        List<Integer> cost = new ArrayList<>();
        for(Integer b : B){
            cost.add(b);
        }
        for(Integer b : B){
            cost.add(b);
        }
        int N = A.size();
        int start = 0;
        int carFuel = 0;
        for(int i=0; i < gasFill.size(); i++){
            
            if(i == start+N){
                return start;
            }

            carFuel += gasFill.get(i);
            carFuel -= cost.get(i);
            
            if(carFuel < 0){
                start = i+1;
                carFuel = 0;
            }
            
        }
        
        return -1;
        
        
    }
}

//Youtube Greedy Algorithm - https://www.youtube.com/watch?v=bC7o8P_Ste4&t=536s
