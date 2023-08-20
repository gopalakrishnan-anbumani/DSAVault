import java.util.*;

public class CompilationOrder {
    public static void main(String[] args) {

    }

    /*
    * [B,A][C,A][D,A]
    * */
    public static List<Character> findCompilationOrder(ArrayList<ArrayList<Character>> dependencies) {
        List<Character> listOrder = new ArrayList<>();

        HashMap<Character, List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();

        for(ArrayList<Character> depend : dependencies){
            graph.put(depend.get(0), new ArrayList<>());
            graph.put(depend.get(1), new ArrayList<>());

            inDegree.put(depend.get(0), 0);
            inDegree.put(depend.get(1), 0);
        }

        for(ArrayList<Character> depend : dependencies){
            Character parent = depend.get(1);
            Character child = depend.get(0);

            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child)+1);
        }
        Queue<Character> queue = new LinkedList<>();
        for(Character vertex : inDegree.keySet()){
            if(inDegree.get(vertex) == 0){
                queue.add(vertex);
            }
        }
        while(!queue.isEmpty()){
            Character vertex = queue.poll();
            listOrder.add(vertex);
            for (int i=0; i<graph.get(vertex).size();i++){
                Character child = graph.get(vertex).get(i);
                inDegree.put(child, inDegree.get(child)-1);
                if(inDegree.get(child) == 0){
                    queue.add(child);
                }
            }
        }
        if(listOrder.size() != graph.size()){
            return new ArrayList<>();
        }


        return listOrder;
    }
}
