class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        
        String[] ss = s.split(" ");
        if(pattern.length() != ss.length) return false;
        char[] pChar = pattern.toCharArray();
        for(int i = 0; i < pattern.length(); i++){
            char cur = pChar[i];
            String curS = ss[i];
            if(map.containsKey(cur)){
                if(!map.get(cur).equals(curS)) return false;
            }else{
                map.put(cur, curS);
                
            }
            
            if(map2.containsKey(curS) && !map2.get(curS).equals(cur)) return false;
            else{
                map2.put(curS, cur);
            }
            
            
        }
        
        return true;
    }
}