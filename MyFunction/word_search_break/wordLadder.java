class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        int step = 1;
        
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size() > endSet.size()){
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            
            Set<String> temp = new HashSet<>();
            
            for(String str: beginSet){
                char[] chs = str.toCharArray();
                for(int i = 0; i < chs.length; i++){
                    // char old = chs[i];
                    for(char s = 'a'; s<='z'; s++){
                        char old = chs[i];
                        if(s != old) chs[i] = s;
                        String target = String.valueOf(chs);
                        if(endSet.contains(target)) return step + 1;

                        if(!visited.contains(target) && wordSet.contains(target)){
                            visited.add(target);
                            temp.add(target);
                        }
                        chs[i] = old;
                    }
            
                }
            }
            step++;
            beginSet = temp;
            
        }
        return 0;
        
        
    }
}