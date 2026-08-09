class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(res, board, 0, n);

        return res;
    }

    private void backtrack(
            List<List<String>> res,
            char[][] board,
            int row,
            int n) {

        if (row == n) {
            res.add(addBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {

            if (isValid(board, row, col, n)) {

                board[row][col] = 'Q';

                backtrack(res, board, row + 1, n);

                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(
            char[][] board,
            int row,
            int col,
            int n) {

        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> addBoard(char[][] board) {

        List<String> list = new ArrayList<>();

        for (char[] row : board) {
            list.add(new String(row));
        }

        return list;
        
    }
}
