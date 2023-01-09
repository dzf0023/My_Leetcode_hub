class Node{
    
    // public char c;
    public boolean isEndWord;
    public Node[] children;
    
    // public Node(){}
    public Node(){
        // this.c = c;
        isEndWord = false;
        children = new Node[26];
    }
}
class Trie {
    
    private Node root;
    
    public Trie() {
       root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(char c: word.toCharArray()){
            if(node.children[c - 'a'] == null){
                node.children[c-'a'] = new Node();
            }
            node = node.children[c-'a'];
        }
        node.isEndWord = true;
    }
    
    public boolean search(String word) {
        Node node = root;
        for(char c: word.toCharArray()){
            if(node.children[c - 'a'] == null){
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isEndWord;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(char c: prefix.toCharArray()){
            if(node.children[c - 'a'] == null){
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }
}


============================
    // ake "apple" as an example, we will insert add "apple{apple", "pple{apple", "ple{apple", "le{apple", "e{apple", "{apple" into the Trie Tree.
// If the query is: prefix = "app", suffix = "le", we can find it by querying our trie for
// "le { app".
// 在每一个node地方加上idx， 因为有重复，会返回最大的，所以可以一直更新

class WordFilter {
    TrieNode root = new TrieNode();
    
    void buildTree(TrieNode root, String S, int id){
        TrieNode node = root;
        for(char c: S.toCharArray()){
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
            node.ids.add(id);
        }
    }
    
    public WordFilter(String[] words) {
        TrieNode node = root;
        
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            String rWord = "";
            
            for(int j = 0; j < word.length(); j++){
                rWord = word.substring(word.length() - j - 1);
                buildTree(node, rWord + "{" + word, i);
            }
            buildTree(node, "{" + word, i);
        }
    }
    
    public int f(String pref, String suff) {
        // String newSuff = reverse(suff);
        String S = suff + "{" + pref;
        TrieNode node = root;
        for(char c: S.toCharArray()){
            if(node.children[c - 'a'] == null){
                return -1;
            }else{
                node = node.children[c - 'a'];
            }
        }
        return node.ids.get(node.ids.size() - 1);
    }
}


class TrieNode{
    
    TrieNode[] children;
    List<Integer> ids;
    public TrieNode(){
        children  = new TrieNode[27];
        ids = new ArrayList<>();
    }
    
}
    =================================


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


============ first way, use TrieNode[] array , second use hashmap==================
  class TrieNode {
    public Map<Character, TrieNode> children = new HashMap<>();
    
    // you might need some extra values according to different cases
};

/** Usage:
 *  Initialization: TrieNode root = new TrieNode();
 *  Return a specific child node with char c: root.children.get(c)
 */  
    
    
    
  class WordFilter {
    TrieNode trie;
    public WordFilter(String[] words) {
        trie = new TrieNode();
        int wt = 0;
        for (String word: words) {
            TrieNode cur = trie;
            cur.weight = wt;
            int L = word.length();
            char[] chars = word.toCharArray();
            for (int i = 0; i < L; ++i) {

                TrieNode tmp = cur;
                for (int j = i; j < L; ++j) {
                    int code = (chars[j] - '`') * 27;
                    if (tmp.children.get(code) == null)
                        tmp.children.put(code, new TrieNode());
                    tmp = tmp.children.get(code);
                    tmp.weight = wt;
                }

                tmp = cur;
                for (int k = L - 1 - i; k >= 0; --k) {
                    int code = (chars[k] - '`');
                    if (tmp.children.get(code) == null)
                        tmp.children.put(code, new TrieNode());
                    tmp = tmp.children.get(code);
                    tmp.weight = wt;
                }

                int code = (chars[i] - '`') * 27 + (chars[L - 1 - i] - '`');
                if (cur.children.get(code) == null)
                    cur.children.put(code, new TrieNode());
                cur = cur.children.get(code);
                cur.weight = wt;

            }
            wt++;
        }
    }

    public int f(String prefix, String suffix) {
        TrieNode cur = trie;
        int i = 0, j = suffix.length() - 1;
        while (i < prefix.length() || j >= 0) {
            char c1 = i < prefix.length() ? prefix.charAt(i) : '`';
            char c2 = j >= 0 ? suffix.charAt(j) : '`';
            int code = (c1 - '`') * 27 + (c2 - '`');
            cur = cur.children.get(code);
            if (cur == null) return -1;
            i++; j--;
        }
        return cur.weight;
    }
}

class TrieNode {
    Map<Integer, TrieNode> children;
    int weight;
    public TrieNode() {
        children = new HashMap();
        weight = 0;
    }
}
  
