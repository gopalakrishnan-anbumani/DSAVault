//767. Reorganize String
//https://leetcode.com/problems/reorganize-string/description/
//Eduactive - Pattern - Top K Element

class ReorganizeString {
    public String reorganizeString(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        for(char ch : s.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch,0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((i1, i2) -> (i2.getValue() - i1.getValue()));
        pq.addAll(hm.entrySet());

        Map.Entry<Character, Integer> previous = null;
        Character lastInserted = null;
        StringBuilder str = new StringBuilder();
        while(!pq.isEmpty() || previous != null){
            if(pq.isEmpty() && previous.getKey() == lastInserted){
                return "";
            }
            Map.Entry<Character, Integer> charSet = pq.poll();
            int count = charSet.getValue() - 1;
            str.append(charSet.getKey());
            lastInserted = charSet.getKey();
            if(previous != null){
                pq.add(previous);
                previous = null;
            }
            if(count != 0){
                previous = Map.entry(charSet.getKey(), count);
            }
        }
        return str.toString();

    }
}
