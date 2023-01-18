//Eduactive - Two Pointers Problem

import java.util.*;
public class SumOfThree{
   public static boolean findSumOfThree(int[] nums, int target) {
      Arrays.sort(nums);
      for(int i=0;i<nums.length;i++){
         int low = i+1;
         int high = nums.length-1;
         while(low<high){
            int sum = nums[i] + nums[low] + nums[high];
            if(sum == target){
               return true;
            } else if (sum < target) {
               low++;
            } else {
               high--;
            }
         }
      }
      
      return false;
   }
