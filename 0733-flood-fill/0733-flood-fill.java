class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;

        boolean[][] vis = new boolean[m][n];
        for (boolean[] x : vis) {
            Arrays.fill(x, false);
        }

        BFS(image, sr, sc, vis, color, image[sr][sc], m, n);

        return image;
    }

    private void BFS(int[][] image, int sr, int sc, boolean[][] vis, int targetColor, int val, int m, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sr, sc });

        while (!q.isEmpty()) {
            int row = q.peek()[0];
            int col = q.peek()[1];
            vis[row][col] = true;
            image[row][col] = targetColor;
            q.poll();

            int[] drow = { -1, 1, 0, 0 };
            int[] dcol = { 0, 0, 1, -1 };

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && image[nrow][ncol] == val
                        && !vis[nrow][ncol]) {
                    image[nrow][ncol] = targetColor;
                    q.add(new int[] { nrow, ncol });
                }
            }
        }
    }
}