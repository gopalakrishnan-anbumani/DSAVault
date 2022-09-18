public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> hm = new HashMap();
        
        for(int i=0; i< strs.length; i++)
        {
            String str = strs[i];
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);
            String s = new String(chArr);
            
            if(hm.containsKey(s)){
                
                hm.get(s).add(str);
                
            } else {
                List<String> l = new ArrayList<String>();
                l.add(str);
                hm.put(s, l);
            }
            
        }   
        
        List<List<String>> result = new ArrayList();
        for(String s : hm.keySet()){
            result.add(hm.get(s));
        }
        return result;
    }
}
