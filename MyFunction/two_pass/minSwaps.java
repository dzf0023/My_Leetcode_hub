class Solution {
    public int minSwaps(String s) {
        int n = s.length();
        int ones = 0, zero = 0;
        for(char c : s.toCharArray()){
            if(c == '1')
                ++ones;
            else
                ++zero;
        }
        
        if(Math.abs(ones-zero) > 1)
            return -1;
        
        if(ones > zero)
            return helper(s, '1');
        else if(zero > ones)
            return helper(s, '0');
        
        return Math.min(helper(s, '1'), helper(s, '0'));
    }
    
    private int helper(String s, char c){
        int swaps = 0;
        for(char ch : s.toCharArray()){
            if(ch != c){
                ++swaps;
            }
            c ^= 1;
        }
        
        return swaps/2;
    }
}
