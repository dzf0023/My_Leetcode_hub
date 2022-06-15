class BC3_Java_version_of_Guan_version {
    public int calculate(String s) {
        Deque<String> stack = new ArrayDeque<>();
        
        String curStr = "";
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.addLast(curStr);
                curStr = "";
            }else if(s.charAt(i) == ')'){
                int curRes = eval(curStr);
                curStr = stack.pollLast() + Integer.toString(curRes);
            }else{
                curStr += s.charAt(i);
            }
        }
        // System.out.println("cur is " + curStr);
        return eval(curStr);
    }
    
    int eval(String s){
        String S = "+";
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ') continue;
            S += s.charAt(i);
        }
        s = S;
        // System.out.println("inside is " +  s);
        
        char sign = '+';
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        int n = s.length();
        // int count = 0;
        
        for(int i = 0; i < n; i++){
            // System.out.println("iteration i is " + i + ", now nums is : " +nums);
            if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                // count+=1;
                sign = s.charAt(i);
                int j = i+1;
                if(s.charAt(j) == '+' || s.charAt(j) == '-') j++;
                while(j < n && Character.isDigit(s.charAt(j))){
                    j++;
                }
                int num = Integer.parseInt(s.substring(i+1,j));
                if(sign == '+'){
                    nums.addLast(num);
                }else if(sign == '-') {
                    nums.addLast(-num);
                }
                i = j-1;
            }else if(s.charAt(i) == '*' || s.charAt(i) == '/'){
                sign = s.charAt(i);
                int j = i+1;
                if(s.charAt(j) == '+' || s.charAt(j) == '-') j++;
                while(j < n && Character.isDigit(s.charAt(j))){
                    j++;
                }
                int num =  Integer.parseInt(s.substring(i+1,j));
                if(sign == '*'){
                    nums.addLast(nums.pollLast() * num);
                }else if(sign == '/'){
                    nums.addLast(nums.pollLast() / num);
                }
                i = j - 1;
            }
            
        }
        // System.out.println("final nums is:  " +  nums);
        // System.out.println(count);
        int res = 0;
        while(!nums.isEmpty()){
            res += nums.pollLast();
        }
        return res;
    }
}
