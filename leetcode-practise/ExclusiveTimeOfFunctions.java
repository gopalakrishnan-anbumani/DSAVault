//636. Exclusive Time of Functions
//https://leetcode.com/problems/exclusive-time-of-functions/description/


import java.util.List;
import java.util.Stack;

class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<String> stack = new Stack<>();
        for(String log : logs){
            String[] sLog = log.split(":");
            if(sLog[1].equals("end")){
                String prevLog = stack.pop();
                String[] pLog = prevLog.split(":");

                int id = Integer.parseInt(pLog[0]);
                int startTime = Integer.parseInt(pLog[2]);
                int endTime = Integer.parseInt(sLog[2]);
                int timeTaken = endTime - startTime + 1;
                res[id] += timeTaken;

                if(!stack.isEmpty()){
                    String[] topLog = stack.peek().split(":");
                    int topId = Integer.parseInt(topLog[0]);
                    res[topId] = res[topId] - timeTaken;
                }
            } else {
                stack.push(log);
            }
        }
        return res;
    }
}