//https://leetcode.com/problems/course-schedule/description/
//207. Course Schedule


import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> list = new ArrayList<>();

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();

        for(int[] prerequisite : prerequisites){
            int parent = prerequisite[1];
            int child = prerequisite[0];
            List<Integer> childInserted = graph.getOrDefault(parent, new ArrayList<>());
            childInserted.add(child);
            graph.put(parent, childInserted);
            graph.put(child, graph.getOrDefault(child, new ArrayList<>()));

            inDegree.put(parent, inDegree.getOrDefault(parent,0));
            inDegree.put(child, inDegree.getOrDefault(child,0) + 1);
        }

        if(graph.isEmpty()){
            return true;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(Integer vertex : inDegree.keySet()){
            if(inDegree.get(vertex) == 0){
                queue.add(vertex);
            }
        }
        while(!queue.isEmpty()){
            int parent = queue.poll();
            list.add(parent);

            for(int i=0; i<graph.get(parent).size(); i++){
                int child = graph.get(parent).get(i);
                inDegree.put(child, inDegree.get(child)-1);
                if(inDegree.get(child) == 0){
                    queue.add(child);
                }
            }

        }

        if(list.size() != graph.size()){
            return false;
        }
        return true;
    }
}
