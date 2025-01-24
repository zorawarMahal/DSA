class Solution {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return queens(board, 0);
    }

    int queens(boolean[][] board, int row) {
        if (row == board.length) {
            return 1;
        }

        int count = 0;

        // placing the queen and checking for every row and column
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row + 1); // adding the count if the below function calls
                board[row][col] = false; // backtracking to the original setting of the maze as we want to check other
                                         // combinations with the queen sitting in other columns of the top row
            }
        }

        return count; // returning the count obtained upto each function call from the below calls;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // col check
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // left diagonal check
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j]) {
                return false;
            }
            i--;
            j--;
        }

        i = row - 1;
        j = col + 1;
        while (i >= 0 && j <= board[0].length - 1) {
            if (board[i][j]) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }
}