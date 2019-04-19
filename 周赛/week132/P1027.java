package week132;

/**
 * Created on 19/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P1027 {

    private static final int BASE = 10000;

    public int longestArithSeqLength(int[] A) {
        int length = A.length;
        int longestLength = 1;
        int[][] matrix = new int[length][20002];
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j]; // 差
                matrix[i][BASE + diff] = Math.max(matrix[i][BASE + diff], matrix[j][BASE + diff] + 1);
                if (matrix[i][BASE + diff] > longestLength)
                    longestLength = matrix[i][BASE + diff];
            }
        }
        return longestLength + 1;
    }

}
