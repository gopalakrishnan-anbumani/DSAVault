//93. Restore IP Addresses
//https://leetcode.com/problems/restore-ip-addresses/description/


class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        ipRec(s, "",0, 0, res);
        return res;
    }

    public String ipRec(String s, String ip, int index, int dot, List<String> res){
        if(dot==3){
            String lastRemaing = s.substring(index);
            //System.out.println("last" + lastRemaing);
            if(isValid(lastRemaing)){
                return ip+lastRemaing;
            }
            return null;
        }
        if(index+1 < s.length()){
            String firstDot = s.substring(index, index+1);
            //System.out.println(firstDot);
            String res1 = ipRec(s, ip+firstDot+".", index+1, dot+1, res);
            if(res1 != null) res.add(res1);
        }

        //System.out.println("ff "+res1);
        if(index+2 < s.length()){
            String secondDot = s.substring(index, index+2);
            if(isValid(secondDot)){
                String res2 = ipRec(s, ip+secondDot+".", index+2, dot+1, res);
                if(res2 != null) res.add(res2);
            }

        }

        if(index+3 < s.length()){
            String thirdDot = s.substring(index, index+3);
            if(isValid(thirdDot)){
                String res3 = ipRec(s, ip+thirdDot+".", index+3, dot+1, res);
                if(res3 != null) res.add(res3); 
            }
                 
        }
        
        return null;
    }
    public boolean isValid(String s){
        int len = s.length();
        if(len > 3){
            return false;
        }
        if(len > 1 && s.charAt(0) == '0'){
                return false;
        }
        if(len == 3){
            int ip = Integer.parseInt(s);
            if(ip > 255 ){
                return false;
            }
        }
        return true;
    }
}
