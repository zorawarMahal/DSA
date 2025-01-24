class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];

        return queens(board, 0);
    }

    List<List<String>> queens (boolean[][] board, int row){
        if (row == board.length) {
            return boardConfig(board);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int col = 0; col < board[0].length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                ans.addAll(queens(board, row+1));  // if it is safe to enter till last row then we are returning the board config here
                board[row][col] = false;     // reverting changes made to the board for other configs
            }
        }

        return ans;
    }

    boolean isSafe(boolean[][] board, int row, int col) {

        // checking for column
        for (int i = row; i >= 0; i--) {
            if (board[i][col]) {
                return false;
            }
        }

        // checking left diagonali
        int i = row;
        int j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j]) {
                return false;
            }
            i--;
            j--;
        }

        // checking for right diagonal
        i = row;
        j = col;
        while (i >= 0 && j <= board[0].length-1) {
            if (board[i][j]) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    List<List<String>> boardConfig (boolean[][] board) {
        List<List<String>> list = new ArrayList<>();
        List<String> config = new ArrayList<>();

        for (boolean[] arr : board) {
            StringBuilder sb = new StringBuilder();
            for (boolean ele : arr) {
                if (ele) {
                    sb.append("Q");
                }
                else {
                    sb.append(".");
                }
            }
            config.add(sb.toString());
        }

        list.add(config);
        return list;
    }
}