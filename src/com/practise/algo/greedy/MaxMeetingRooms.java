//https://www.interviewbit.com/problems/meeting-rooms/

public class MaxMeetingRooms {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		for(ArrayList<Integer> a : A) {
			ArrayList<Integer> starting = new ArrayList<Integer>();
			starting.add(a.get(0));
			starting.add(1);
			arr.add(starting);
			
			ArrayList<Integer> ending = new ArrayList<Integer>();
			ending.add(a.get(1));
			ending.add(-1);
			arr.add(ending);
		}
		
		
		//System.out.println(arr.toString());
        Collections.sort(arr, new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            	if(o1.get(0).compareTo(o2.get(0)) == 0) {
            		return o1.get(1).compareTo(o2.get(1));	
            	} else {
            		return o1.get(0).compareTo(o2.get(0));	
            	}
            } 
        });
        
        int max = 0;
        int current = 0;
        for(ArrayList<Integer> a : arr) {
        	int status = a.get(1);
        	current += status;
        	if(max < current) {
        		max = current;
        	}
        }
        
        return max;
        
        
    }
}



//FreeCodeCamp - Greedy Algorithms

