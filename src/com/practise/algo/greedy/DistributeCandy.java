//https://www.interviewbit.com/problems/distribute-candy/

public class DistributeCandy {
    public int candy(ArrayList<Integer> A) {
        int len = A.size();
        int[] arr = new int[len];
        Arrays.fill(arr, 1);
        ArrayList<ArrayList<Integer>> data = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<len;i++){
            ArrayList<Integer> d = new ArrayList<Integer>();
            d.add(A.get(i));
            d.add(i);
            data.add(d);
        }
        Collections.sort(data, new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2){
                if(o1.get(0).compareTo(o2.get(0)) == 0) {
            		return o1.get(1).compareTo(o2.get(1));	
            	} else {
            		return o1.get(0).compareTo(o2.get(0));	
            	}
            }
        });
        for(ArrayList<Integer> a : data){
            int index = a.get(1);
            
            if(index > 0 && A.get(index) > A.get(index-1)){
                arr[index] = Math.max(arr[index], arr[index-1]+1);
            }
            
            if(index < len-1 && A.get(index) > A.get(index+1)){
                arr[index] = Math.max(arr[index], arr[index+1]+1);
            }
        }
        int result = 0;
        for(int can : arr){
            result += can;
        }
      	
        return result;
    }
}

//FreeCodeCamp - Greedy Algorithm

