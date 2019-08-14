public class Solution1 implements Solution {
    @Override
    public int[][] generateMatrix(int n) {

        int[][] result = new int[n][n];

        int i = 0, num = 1;
        while (n > 0) {
            num = putToMatrix(result, i, n, num);
            i++;
            n -= 2;
        }

        return result;
    }

    private int putToMatrix(int[][] matrix, int rc, int rc_left, int num_start) {
        int i = rc, j = rc;
        matrix[i][j] = num_start++;
        if (rc_left > 1) {
            int k = 1;
            while (k < rc_left-1) {
                matrix[i][j+k] = num_start++;
                k++;
            }
            if (k == rc_left-1) {
                j += k;
            }
        }

        if (rc_left > 1) {
            matrix[i][j] = num_start++;
            int k = 1;
            while (k < rc_left-1) {
                matrix[i+k][j] = num_start++;
                k++;
            }
            if (k == rc_left-1) {
                i += k;
            }
        }

        if (i != rc) {
            matrix[i][j] = num_start++;
            int k = 1;
            while (k < rc_left-1) {
                matrix[i][j-k] = num_start++;
                k++;
            }
            if (k == rc_left-1) {
                j -= k;
            }

            matrix[i][j] = num_start++;
            k = 1;
            while (k < rc_left-1) {
                matrix[i-k][j] = num_start++;
                k++;
            }
        }
        return num_start;
    }
}
