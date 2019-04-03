package all.unknown;

/**
 * Created on 10/03/2019.
 * Description:
 *
 * @author iznauy
 */
class Solution {

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int repeatNumber(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == i + 1)
                continue;
            if (array[i] == array[array[i] - 1])
                return array[i];
            swap(array, i, array[i] - 1);
            i--;
        }
        return -1;
    }

}
