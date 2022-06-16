class 139Word Break {
    
    TrieNode root;
    
    private void insert(String word){
        TrieNode node = root;
        
        for(char c: word.toCharArray()){
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();
        
        for(String word: wordDict){
            insert(word);
        }
        int[] memo = new int[s.length()+1];
        return dfs(s, 0, memo);
    }
    
    
    private boolean dfs(String s, int idx, int[] memo){
        if(memo[idx] == 1) return false;
        
        if(idx == s.length()){
            return true;
        }
        TrieNode node = root;
        for(int i = idx; i < s.length(); i++){
            if(node.children[s.charAt(i) - 'a'] != null){
                node = node.children[s.charAt(i) - 'a'];
                if(node.isEnd == true && dfs(s, i+1, memo)){
                    System.out.println(s.substring(0, i+1));
                    return true;
                }
            }else{
                break;
            }
            
        }
        memo[idx] = 1;
        return false;
    }
}




class TrieNode{
    
    TrieNode[] children;
    boolean isEnd;
    
    public TrieNode(){
        children = new TrieNode[26];
        isEnd = false;
    }
    
}