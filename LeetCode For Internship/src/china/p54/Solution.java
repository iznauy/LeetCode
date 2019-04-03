package china.p54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created on 14/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return Collections.emptyList();
        List<Integer> resultList = new ArrayList<>();
        int left = 0, top = 0, right = matrix[0].length - 1, down = matrix.length - 1;

        while (left <= right && top <= down) {
            if (left != right && top != down) { // 还是一个矩形的时候
                for (int i = left; i < right; i++)
                    resultList.add(matrix[top][i]);
                for (int i = top; i < down; i++)
                    resultList.add(matrix[i][right]);
                for (int i = right; i > left; i--)
                    resultList.add(matrix[down][i]);
                for (int i = down; i > top; i--)
                    resultList.add(matrix[i][left]);
                left++;
                right--;
                top++;
                down--;
            } else if (left == right) {
                for (int i = top; i <= down; i++)
                    resultList.add(matrix[i][left]);
                break;
            } else {
                for (int i = left; i <= right; i++)
                    resultList.add(matrix[top][i]);
                break;
            }
        }

        return resultList;
    }

}
