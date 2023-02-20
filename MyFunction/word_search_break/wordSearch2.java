class Solution {
     // 用trie把list建立起来，然后两头一起dfs， 从board每一个点开始找，看是否能在trie中找到
    TrieNode root;
    
    void insert(String word){
        TrieNode node = root;
        for(char c: word.toCharArray()){
            
            if(node.child[c - 'a'] == null){
                node.child[c - 'a'] = new TrieNode();
            }
            node = node.child[c - 'a'];
        }
        node.isEnd = true;

    }
    
    List<String> res;
    Set<String> set;
    int m, n;
    int[][] visited;
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        res = new ArrayList<>();
        set = new HashSet<>();
        for(String word: words){
            insert(word);
        }
        
        m = board.length;
        n = board[0].length;
        visited = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                TrieNode node = root;
                StringBuilder sb = new StringBuilder();
                visited[i][j] = 1;
                dfs(board, i, j, node, sb);
                visited[i][j] = 0;
                
            }
        }
        for(String s: set){
            res.add(s);
        }
        return res;
        
    }
    
    void dfs(char[][] board, int i, int j, TrieNode node, StringBuilder cur){
        char c = board[i][j];
        if(node.child[c - 'a'] == null) return;
        node = node.child[c - 'a'];
        cur.append(c);
        
        if(node.isEnd == true){
            set.add(cur.toString());
        }

        for(int[] dir: dirs){
            int newI = dir[0] + i;
            int newJ = dir[1] + j;
            if(newI < 0 || newI >= m || newJ < 0 || newJ >= n || visited[newI][newJ] == 1){
                continue;
            }
            visited[newI][newJ] = 1;
            dfs(board, newI, newJ, node, cur);
            visited[newI][newJ] = 0;
        }
        
        cur.deleteCharAt(cur.length() - 1);
    }
}


class TrieNode{
    TrieNode[] child;
    boolean isEnd;

    public TrieNode(){
        this.child = new TrieNode[26];
        this.isEnd = false;

    }
}
===========================above是跟新的guan hui feng的版本============


class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }
    
    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res){
        char c = board[i][j];
        if(c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if(p.word != null){
            res.add(p.word);
            p.word = null;
        }
        
        board[i][j] = '#';
        if(i > 0) dfs(board, i-1, j, p, res);
        if(j > 0) dfs(board, i, j-1, p, res);
        if(i < board.length - 1) dfs(board, i + 1, j , p , res);
        if(j < board[0].length - 1) dfs(board, i, j+1, p, res);
        board[i][j] = c;
    }
    
    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String w: words){
            TrieNode p = root;
            for(char c: w.toCharArray()){
                int i = c - 'a';
                if(p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }
    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
