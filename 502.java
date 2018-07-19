import java.util.Arrays;

/**
 * Created on 2018/7/18.
 * Description:
 *
 * @author iznauy
 */
public class Solution {

    public int[][] updateMatrix(int[][] matrix) {
        int MAX = 2000000;
        int sizeX = matrix.length;
        int sizeY = matrix[0].length;
        int[][] result = new int[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++)
            for (int j = 0; j < sizeY; j++)
                if (matrix[i][j] == 0)
                    result[i][j] = 0;
                else {
                    result[i][j] = MAX;
                    if (j > 0)
                        result[i][j] = result[i][j - 1] + 1;
                    if (i > 0)
                        result[i][j] = Math.min(result[i - 1][j] + 1, result[i][j]);
                }

        for (int i = sizeX - 1; i >= 0; i--)
            for (int j = sizeY - 1; j >= 0; j--)
                if (matrix[i][j] != 0) {
                    if (i < sizeX - 1)
                        result[i][j] = Math.min(result[i][j], 1 + result[i + 1][j]);
                    if (j < sizeY - 1)
                        result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);
                }

        for (int i = 0; i < sizeX; i++)
            for (int j = sizeY - 1; j >= 0; j--)
                if (matrix[i][j] != 0) {
                    if (i > 0)
                        matrix[i][j] = Math.min(result[i][j], 1 + result[i - 1][j]);
                    if (j < sizeY - 1)
                        matrix[i][j] = Math.min(result[i][j], 1 + result[i][j + 1]);
                }


        for (int i = sizeX - 1; i >= 0; i--)
            for (int j = 0; j < sizeY - 1; j++)
                if (matrix[i][j] != 0) {
                    if (i < sizeX - 1)
                        result[i][j] = Math.min(result[i][j], 1 + result[i + 1][j]);
                    if (j > 0)
                        matrix[i][j] = Math.min(result[i][j], 1 + result[i][j - 1]);
                }

        return result;
    }

}
