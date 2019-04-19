/**
 * Created on 19/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int top = 0, down = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (top <= down && left <= right) {
            int pivot = matrix[down][left];
            if (pivot == target)
                return true;
            else if (pivot < target)
                left++;
            else
                down--;
        }
        return false;
    }

}
