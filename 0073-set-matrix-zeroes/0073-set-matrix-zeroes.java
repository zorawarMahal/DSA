class Solution {
    public void setZeroes(int[][] matrix) {
        int[] colRecord = new int[matrix[0].length];
        int[] rowRecord = new int[matrix.length];

        Arrays.fill(colRecord, 1);
        Arrays.fill(rowRecord, 1);

        for (int i=0; i < matrix.length; i++) {
            for (int j=0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    colRecord[j] = 0;
                    rowRecord[i] = 0;
                }
            }
        }

        for (int i=0; i < matrix.length; i++) {
            for (int j=0; j < matrix[0].length; j++) {
                if (colRecord[j] == 0) {
                    colZero(j, matrix);
                }
                if (rowRecord[i] == 0) {
                    rowZero(i, matrix);
                }
            }
        }
    }

    static void colZero(int j, int[][] matrix) {
        for (int i=0; i< matrix.length; i++) {
            matrix[i][j] = 0;
        }
    }
    static void rowZero(int i, int[][] matrix) {
        for (int j=0; j< matrix[0].length; j++) {
            matrix[i][j] = 0;
        }
    }
}