class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            isEnd = false;
            children = new TrieNode[26];
            }    
        }

    TrieNode root; 
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b)->Integer.compare(a.length(), b.length()));
        root = new TrieNode();
        List<String> rets = new ArrayList<>();    
        for(String word: words){
            if(!word.equals("") && check(word)){
                rets.add(word);
            }
            insert(word);
        }
        return rets; 
    }
    
    private boolean check(String word){
        int n = word.length();
        int[] visited = new int[n];
        return dfs(word, 0, visited);
    }
    
    private boolean dfs(String word, int cur, int[] visited){
        if(cur == word.length() ) return true;
        if(visited[cur] == 1) return false;
        TrieNode node = root;
        
        for(int i = cur; i < word.length(); i++){
            if(node.children[word.charAt(i) - 'a'] != null){
                node = node.children[word.charAt(i) - 'a'];
                if(node.isEnd == true && dfs(word, i+1, visited)){
                    return true;
                }
            }else{
                break;
            }
        }
        visited[cur] = 1;
        return false;
    }
    
    public void insert(String word){
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c =word.charAt(i);
            if(cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }    
}



