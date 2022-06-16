class Solution {
    private class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        public String word = null;
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        // Build Trie
        TrieNode root = new TrieNode();
        for (String word: wordDict) {
            TrieNode tmp = root;
            for (int i=0; i<word.length(); ++i) {
                char c = word.charAt(i);
                if (tmp.children.containsKey(c)) {
                    tmp = tmp.children.get(c);
                } else {
                    TrieNode newNode = new TrieNode(); 
                    tmp.children.put(c, newNode);
                    tmp = newNode;
                }
            }
            tmp.word = word;
        }
        
        // Parse String
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        parseString(s, sb, result, root);
        
        return result;
    }
    
    private void parseString(String s, StringBuilder sb, List<String> result, TrieNode root) {
        if (s.equals("")) {
            result.add(sb.substring(0, sb.length()-1));
            return;
        }
        
        TrieNode tmp = root;
        for (int i=0; i<s.length(); ++i) {
            char c = s.charAt(i);
            if (tmp.children.containsKey(c)) {
                tmp = tmp.children.get(c);
                if (tmp.word != null) {
                    sb.append(tmp.word + " ");
                    parseString(s.substring(i+1), sb, result, root);
                    sb.delete(sb.length()-tmp.word.length()-1, sb.length());
                }
            } else {
                return;
            }
        }
    } 
}