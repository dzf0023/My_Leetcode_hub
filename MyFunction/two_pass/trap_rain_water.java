class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        int[] left_most = new int[n];
        int[] right_most = new int[n];
        
        left_most[0] = height[0];
        right_most[n-1] = height[n-1];
        
        for(int i = 1; i < n; i++){
            left_most[i] = Math.max(left_most[i-1], height[i]);
        }
        
        for(int i = n-2; i>= 0; i--){
            right_most[i] = Math.max(right_most[i+1], height[i]);
        }
        
        int res = 0;
        
        for(int i = 0; i < n;i++){
            res += Math.min(left_most[i], right_most[i]) - height[i];
        }
        
        return res;
    }
}
