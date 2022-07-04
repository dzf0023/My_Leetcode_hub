class Solution {
    public int[] findOrder(int numCour, int[][] preReq) {
        int[] res = new int[numCour];
        if(numCour == 0) return  res;
        
        if(preReq == null || preReq.length == 0){
            for(int i = 0; i < numCour; i++){
                res[i] = i;
            }
            return res;
        }
        
        
        int[] inDegree = new int[numCour];
        Deque<Integer> q = new ArrayDeque<>();
        for(int[] pre: preReq){
            inDegree[pre[0]] += 1;
        }
        
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                q.addFirst(i);
            }
        }
        
        if(q.size() == 0) return new int[0];
        
        int idx = 0;
        while(!q.isEmpty()){
            int cur = q.pollLast();
            res[idx] = cur;
            idx++;
            for(int[] pre: preReq){
                if(pre[1] == cur){
                    inDegree[pre[0]]--;
                    if(inDegree[pre[0]] == 0) {
                        q.addFirst(pre[0]);
                    }
                }
            }
        }
        
        
        for(int in: inDegree){
            if(in != 0) return new int[0];
        }
        return res;
    }
}
