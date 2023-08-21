//210. Course Schedule II
//https://leetcode.com/problems/course-schedule-ii/description/


import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer> list = new ArrayList<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();

        for(int[] pre : prerequisites){
            int parent = pre[1];
            int child = pre[0];

            List<Integer> childList = graph.getOrDefault(parent, new ArrayList<>());
            childList.add(child);
            graph.put(parent, childList);

            graph.put(child, graph.getOrDefault(child, new ArrayList<>()));

            inDegree.put(parent, inDegree.getOrDefault(parent,0));
            inDegree.put(child, inDegree.getOrDefault(child,0) + 1);
        }
        if(graph.isEmpty()){
            int[] res = new int[numCourses];
            for(int i=0;i<numCourses;i++){
                res[i]=i;
            }
            return res;
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
            for(int i=0;i<graph.get(parent).size(); i++){
                int child = graph.get(parent).get(i);
                inDegree.put(child, inDegree.get(child)-1);
                if(inDegree.get(child) == 0){
                    queue.add(child);
                }
            }
        }

        if(list.size() != graph.size()){
            return new int[0];
        }
        int[] result = new int[numCourses];
        int idx = 0;
        for(int i=0;i<numCourses;i++){
            if(!list.contains(i)){
                result[idx++] = i;
            }
        }
        for(int i=0;i<list.size();i++){
            result[idx++] = list.get(i);
        }
        return result;
    }
}