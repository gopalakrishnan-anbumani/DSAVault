//211. Design Add and Search Words Data Structure
//https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
//LeetCode Daily Challenge - 19-03-2023

class WordDictionary {
    TrieNode root = null;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode ptr = root;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i) - 'a';
            if(ptr.childNode[index] == null)
                ptr.childNode[index] = new TrieNode();
            ptr = ptr.childNode[index];
        }
        ptr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        //return dfs(0, word, root);
        return dfs1(word, 0, root);
    }

    public boolean dfs(int index, String word,TrieNode node) {
        if(index == word.length()) return node.isEndOfWord;
        TrieNode ptr = node;
        if(word.charAt(index) == '.'){
            for(int j=0;j<26;j++){
                if(ptr.childNode[j] != null && dfs(index+1, word, ptr.childNode[j])) {
                    return true;
                }
            }
        } else {
            int ii = word.charAt(index) - 'a';
            if(ptr.childNode[ii] == null)
                return false;
            return dfs(index+1, word, ptr.childNode[ii]);
        }
        
    
        return ptr.isEndOfWord;
    }
     private boolean dfs1(String word, int s, TrieNode node) {
    if (s == word.length())
      return node.isEndOfWord;
    if (word.charAt(s) != '.') {
      TrieNode next = node.childNode[word.charAt(s) - 'a'];
      return next == null ? false : dfs1(word, s + 1, next);
    }

    // Word.charAt(s) == '.' -> search all 26 children
    for (int i = 0; i < 26; ++i)
      if (node.childNode[i] != null && dfs1(word, s + 1, node.childNode[i]))
        return true;

    return false;
  }
}

class TrieNode {

    TrieNode[] childNode = new TrieNode[26];
    boolean isEndOfWord;

    public TrieNode (){
        isEndOfWord = false;
        for(int i=0;i<26;i++){
            childNode[i] = null;
        }
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
