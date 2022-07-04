#LC 207
  
  class Solution {    
    public boolean canFinish(int numCourses, int[][] prerequisites) {        
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < numCourses; ++i)
            graph.add(new ArrayList<Integer>());
        
        for (int i = 0; i < prerequisites.length; ++i) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];            
            graph.get(course).add(prerequisite);
        }
        
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; ++i)
            if (dfs(i, graph, visited)) return false;
        
        return true;
    }
    
    private boolean dfs(int curr, ArrayList<ArrayList<Integer>> graph, int[] visited) {
        if (visited[curr] == 1) return true;
        if (visited[curr] == 2) return false;
        
        visited[curr] = 1;
                
        for (int next : graph.get(curr))
            if (dfs(next, graph, visited)) return true;
        
        visited[curr] = 2;
        return false;
    }
 
}
