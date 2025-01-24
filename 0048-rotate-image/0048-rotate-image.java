class Solution {
    public void rotate(int[][] matrix) {
        int row = 0, col = 0;
        int i = row;

        // taking transpose
        for (row = 0; row < matrix.length; row++) {
            for (i = row; i < matrix.length; i++) {
                swap(matrix, i,col, row,i);
            }
            col++;
        }

        // rotating about the centre column
        int s = 0, e = matrix.length-1;

        while (s <= e) {
            for (i = 0; i < matrix.length; i++) {
                swap(matrix, i,s, i,e);
            }
            s++;
            e--;
        }
    }

    void swap (int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }
}