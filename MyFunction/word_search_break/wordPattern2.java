class Solution {
    Map<Character, String>  map1 = new HashMap<>();
    Map<String, Character>  map2 = new HashMap<>();
    public boolean wordPatternMatch(String pattern, String s) {
        
        return backtrack(0, 0, pattern, s);
            
    }
    public boolean backtrack(int idxP, int idxS, String pattern, String s){
        if(idxP == pattern.length() && idxS == s.length()) return true;
        if(idxP == pattern.length() || idxS == s.length()) return false;
  
        
        if(map1.containsKey(pattern.charAt(idxP))){
            String tempS = map1.get(pattern.charAt(idxP));
            if(idxS + tempS.length() > s.length()) return false;
            
            if(!s.substring(idxS, idxS+ tempS.length()).equals(tempS)) return false;
            else{
                return backtrack(idxP + 1, idxS + tempS.length(), pattern, s);
            }
        }else{
            for(int i = idxS; i < s.length(); i++){
                String tempss = s.substring(idxS, i + 1);
                if(map2.containsKey(tempss)) continue;
                
                map1.put(pattern.charAt(idxP), tempss);
                map2.put(tempss, pattern.charAt(idxP));
                if(backtrack(idxP+1, idxS + tempss.length(), pattern, s)) return true;
                
                map1.remove(pattern.charAt(idxP));
                map2.remove(tempss);
                
            }
            return false;
        }
    }
}