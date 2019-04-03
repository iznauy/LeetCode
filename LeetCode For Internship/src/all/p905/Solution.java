package all.p905;

/**
 * Created on 10/03/2019.
 * Description:
 *
 * @author iznauy
 */
class Solution {

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public int[] sortArrayByParity(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            int curr = A[left];
            if ((curr & 1) == 1) {
                swap(A, left, right);
                right--;
            } else
                left++;
        }
        return A;
    }

}
