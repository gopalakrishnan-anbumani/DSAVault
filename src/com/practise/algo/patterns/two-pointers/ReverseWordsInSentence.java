//Eduactive Two Pointer Pattern
//LeetCode - https://leetcode.com/problems/reverse-words-in-a-string/description/
class ReverseWordsInSentence {
    public String reverseWords(String sentence) {
                String str = "";
        for(int i=sentence.length()-1;i>=0;i--){
            str+=sentence.charAt(i);
        }
        String ans = "";
        int start = -1;
        int end = 0;
        boolean count = false;
        while(end < str.length()){
            char c = str.charAt(end);
            if(end == str.length()-1){
                int i = end;
                while(start < i){
                        if(str.charAt(i) != ' '){
                            ans+=str.charAt(i);
                        }
                        i--;
                }
                end++;
            }else if (c == ' '){
                if(!count){
                    end++;
                    start++;
                } else {
                    int i = end-1;
                    while(start < i){
                        ans+=str.charAt(i);
                        i--;
                    }
                    ans += ' ';
                    count = false;
                    start=end;
                    end++;
                }
            } else {
                count = true;
                end++;
            }
        }
        return ans.charAt(ans.length()-1) == ' ' ? ans.substring(0,ans.length()-1) : ans;
    }
}
