class Solution {
    public boolean exist(char[][] board, String word) {int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (search(board, word, row, col, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word, int row, int col, int index, boolean[][] visited) {

        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length ||
            visited[row][col] ||
            board[row][col] != word.charAt(index)) {

            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        visited[row][col] = true;

        boolean found =
                search(board, word, row - 1, col, index + 1, visited) || 
                search(board, word, row + 1, col, index + 1, visited) || 
                search(board, word, row, col - 1, index + 1, visited) || 
                search(board, word, row, col + 1, index + 1, visited);    

        visited[row][col] = false;

        return found;
        
    }
}
