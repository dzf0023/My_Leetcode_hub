class BC2 {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        
        int len = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        int curNum = 0;
        char operation = '+';
        
        for(int i = 0; i < len; i++){
            char curChar= s.charAt(i);
            if(Character.isDigit(curChar)){
                curNum = (curNum * 10) + (curChar - '0');
            }
            
            if((!Character.isDigit(curChar) && ' ' != curChar) || i == len - 1){
                if(operation == '-'){
                    stack.addFirst(-curNum);
                }else if(operation == '+'){
                    stack.addFirst(curNum);
                }else if(operation == '*'){
                    stack.addFirst(stack.pollFirst() * curNum);
                }else if(operation == '/'){
                    stack.addFirst(stack.pollFirst() / curNum);
                }
                operation = curChar;
                curNum = 0;
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pollFirst();
        }
        return res;
    }
}