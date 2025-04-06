class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for (boolean[] x : vis) {
            Arrays.fill(x, false);
        }

        // boolean vis matrix is ready now

        int count = 0; // no. of islands

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1' && !vis[i][j]) {
                    count++;
                    BFS(grid, vis, i, j, m, n);
                }

            }
        }

        return count;
    }

    private void BFS(char[][] grid, boolean[][] vis, int i, int j, int m, int n) {
        vis[i][j] = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { i, j });

        while (!q.isEmpty()) {
            int row = q.peek()[0];
            int col = q.peek()[1];
            q.poll();

            int[] dRow = { -1, 1, 0, 0 };
            int[] dCol = { 0, 0, -1, 1 };

            for (int d = 0; d < 4; d++) {
                int nrow = row + dRow[d];
                int ncol = col + dCol[d];

                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
                        && !vis[nrow][ncol] && grid[nrow][ncol] == '1') {
                    vis[nrow][ncol] = true;
                    q.add(new int[] { nrow, ncol });
                }
            }
        }
    }
}