class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                DFS(isConnected, vis, i, n);
            }
        }

        return count;
    }

    void DFS(int[][] isConnected, boolean[] vis, int node, int n) {
        if (!vis[node]) {

            vis[node] = true;
            for (int j = 0; j < n; j++) {
                if (isConnected[node][j] == 1 && !vis[j]) {
                    DFS(isConnected, vis, j, n);
                }
            }
        }
    }
}