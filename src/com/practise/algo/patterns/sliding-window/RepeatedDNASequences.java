//https://leetcode.com/problems/repeated-dna-sequences/description/
//Eduactive - Pattern - Sliding window

class RepeatedDNASequences {
  
    //Solved using the Hash map. 
    public List<String> findRepeatedDnaSequences(String s) {
          List<String> result = new ArrayList<>();
          int k = 10;
          int n1 = s.length();
          if(s.length() <= k){
              return result;
          }
          int s1 = 0;
          HashMap<String, Integer> hm = new HashMap();
          while(s1+k <= n1){
              if(hm.containsKey(s.substring(s1,s1+k)) && !result.contains(s.substring(s1,s1+k))){
                  result.add(s.substring(s1,s1+k));
              } else {
                  hm.put(s.substring(s1,s1+k), 1);
              }
              s1++;
          }

          return result;
      }
    }
  
    //My solution. LeetCode passed 30 test cases out of 31. Got Time Exceeded issue for last test case
    public List<String> findRepeatedDnaSequences1(String s) {
        List<String> result = new ArrayList<>();
        int k = 10;
        int n1 = s.length();
        if(s.length() <= k){
            return result;
        }
        int s1 = 0;
        while(s1+k < n1){
            int s2 = s1+1;
            while(s2+k-1 < n1){
                int tempS1 = s1;
                int tempE1 = s1+k-1;
                int tempS2 = s2;
                int tempE2 = s2+k-1;
                while(tempS1 <= tempE1 && tempS2 <= tempE2){
                    if(s.charAt(tempS1) == s.charAt(tempS2) && s.charAt(tempE1) == s.charAt(tempE2)){
                        tempS1++; tempE1--;
                        tempS2++; tempE2--;
                    } else {
                        break;
                    }
                }
                if(tempS1 > tempE1 && !result.contains(s.substring(s1, s1+10))){
                    result.add(s.substring(s1, s1+10));
                }
                s2++;
            }
            s1++;
        }
        return result;
    }

  //Used substring for checking. Still failed for large data. LeetCode passed 30 test cases out of 31. Got Time Exceeded issue for last test case
    public List<String> findRepeatedDnaSequences2(String s) {
        List<String> result = new ArrayList<>();
        int k = 10;
        int n1 = s.length();
        if(s.length() <= k){
            return result;
        }
        int s1 = 0;
        while(s1+k < n1){
            int s2 = s1+1;
            while(s2+k-1 < n1){
                int tempS1 = s1;
                int tempE1 = s1+k;
                int tempS2 = s2;
                int tempE2 = s2+k;
                if(s.substring(tempS1,tempE1).equals(s.substring(tempS2,tempE2)) && !result.contains(s.substring(tempS1,tempE1))){
                    result.add(s.substring(tempS1,tempE1));
                }
                s2++;
            }
            s1++;
        }
        return result;
    }
}
