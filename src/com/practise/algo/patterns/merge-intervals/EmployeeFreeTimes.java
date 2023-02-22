//https://leetcode.com/problems/employee-free-time/
//Eduactive - Pattern coding - Merge Intervals

import java.util.*;

class EmployeeFreeTimes {
  
  //My solution. Didn't check in leetcode(bcs of premium content)
  public static List <Interval> employeeFreeTime(ArrayList <ArrayList <Interval>> schedule) {
    List<Interval> merge = new ArrayList<Interval>();
    if(schedule.size() < 1){
      return merge;
    }
    for(Interval firstInterval : schedule.get(0)){
      merge.add(firstInterval);
    }
    for(int j=1; j<schedule.size();j++){
        List<Interval> sch = schedule.get(j);
        for(Interval newInterval :sch){
          List<Interval> newMerge = new ArrayList<Interval>();
          int start = newInterval.getStart();
          int end = newInterval.getEnd();
          int i = 0;
          while(i<merge.size() && merge.get(i).getStart() <= start){
            newMerge.add(merge.get(i++));
          }
          if(!newMerge.isEmpty() && newMerge.get(newMerge.size()-1).getEnd() >= start){
            int updatedEnd = Math.max(newMerge.get(newMerge.size()-1).getEnd(), end);
            newMerge.get(newMerge.size()-1).setEnd(updatedEnd);
          } else {
            newMerge.add(newInterval);
          }
          while(i < merge.size()){
            if(newMerge.get(newMerge.size()-1).getEnd() >= merge.get(i).getStart()){
              int updatedEnd = Math.max(newMerge.get(newMerge.size()-1).getEnd(), merge.get(i).getEnd());
              newMerge.get(newMerge.size()-1).setEnd(updatedEnd);
            } else {
              newMerge.add(merge.get(i));
            }
            i++;
          }
          merge = newMerge;
        }
    }
    List<Interval> ans = new ArrayList<Interval>();
    int start = merge.get(0).getEnd();
        System.out.println(merge);

    for(int i=1;i<merge.size();i++){
      int end = merge.get(i).getStart();
      ans.add(new Interval(start, end));
      start = merge.get(i).getEnd();
    }
    return ans;
  }
}
