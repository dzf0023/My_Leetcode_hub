class Solution {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0},{1, 0}};
    public boolean exist(char[][] board, String word) {
        char[] wordArray = word.toCharArray();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(isValid(board, wordArray, i , j , 0)){
                    return true;
                }
            }
        }
        return false;
        
    }
    
    private boolean isValid(char[][] board, char[] word, int i, int j, int index){
        if(index == word.length) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '*' || board[i][j] != word[index]) return false;
        
        boolean res = false;
        char c = board[i][j];
        board[i][j] = '*';
        for(int[] dir : dirs){
            int newRow = dir[0] + i;
            int newCol = dir[1] + j;
            res = (isValid(board, word, newRow, newCol, index+1));
            if(res) return true;
            
        }
        board[i][j] = c;
        return false;
    }
}