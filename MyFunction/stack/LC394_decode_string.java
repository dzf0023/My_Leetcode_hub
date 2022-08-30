// LC 394

class Solution {
    public String decodeString(String s) {
        Deque<Integer> num_stack = new ArrayDeque<>();
        Deque<StringBuilder> str_stack = new ArrayDeque<>();
        
        StringBuilder cur = new StringBuilder();
        
        int k = 0;
        
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                k = k * 10 + c - '0';
            }else if(c == '['){
                num_stack.addFirst(k);
                str_stack.addFirst(cur);
                cur = new StringBuilder();
                k = 0;
            }else if(c == ']'){
                StringBuilder decodedStr = str_stack.pollFirst();
                int time = num_stack.pollFirst();
                for(int i = 0; i <time; i++){
                    decodedStr.append(cur);
                }
                cur = decodedStr;
            }else{
                cur.append(c);
            }
        }
        return cur.toString();
    }
}
