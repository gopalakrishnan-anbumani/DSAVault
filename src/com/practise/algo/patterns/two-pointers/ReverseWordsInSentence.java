//Eduactive Two Pointer Pattern
//LeetCode - https://leetcode.com/problems/reverse-words-in-a-string/description/

//Mine
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

//After Enhancement
class Solution {
    public String reverseWords(String sentence) {
        sentence = trimSpaces(sentence);
        int n = sentence.length();
        StringBuilder str = new StringBuilder();
        int start = n-1;
        int end = n;
        while(end > 0){
            while(start >= 0 && sentence.charAt(start) != ' '){
                start--;
            }
            int i = start+1;
            while(i < end){                
                str.append(sentence.charAt(i));
                i++;
            }
            str.append(' ');
            end = start;
            start--;
        }
        return str.toString().substring(0, str.length()-1);
    }

    public String trimSpaces(String sentence){

        int i = 0;
        int n = sentence.length();
        StringBuilder str = new StringBuilder();
        while(i<n){
            while(i<n && sentence.charAt(i) == ' ')  i++;
            while(i<n && sentence.charAt(i) != ' ') str.append(sentence.charAt(i++));
            while(i<n && sentence.charAt(i) == ' ')  i++;
            if(i < n) str.append(' ');
        }
        return str.toString();
    }
}
