class BC3 {
    public int calculate(String s) {
        if(s == null) return 0;
        
        Deque<Character> q = new ArrayDeque<>();
        // char[] ss = s.toCharArray();
        // System.out.println(Arrays.toString(ss)); 
        for(char c: s.toCharArray()){
            q.add(c);
        }
        q.add('+');
        System.out.println(q); 
        return cal(q);
    }
    
    private int cal(Deque<Character> q){
        char sign = '+';
        int num = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        while(!q.isEmpty()){
            char c = q.poll();
            // if(c == ' ') continue;
            System.out.println(c);
            
            if(Character.isDigit(c)){
                num = 10 * num + c - '0';
            }else if( c == '('){
                num = cal(q);
            }else{
                if(sign == '+'){
                    stack.push(num);
                }else if(sign == '-'){
                    stack.push( -num);
                }else if(sign == '*'){
                    stack.push(stack.pop() * num);
                }else if(sign == '/'){
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = c;
                if(c == ')'){
                    break;
                }
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
        
    }
}





