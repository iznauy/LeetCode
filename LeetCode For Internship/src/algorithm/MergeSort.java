package algorithm;

import java.util.Arrays;

/**
 * Created on 15/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class MergeSort {

    private static void mergeSort(int[] fromArray, int[] toArray, int fromIndex, int length) {
        int i = fromIndex, j = fromIndex + length, k = fromIndex;
        int seg1 = Math.min(fromIndex + length, fromArray.length);
        int seg2 = Math.min(fromIndex + length * 2, fromArray.length);
        while (i < seg1 && j < seg2) {
            if (fromArray[i] <= fromArray[j])
                toArray[k++] = fromArray[i++];
            else
                toArray[k++] = fromArray[j++];
        }
        if (i == seg1) {
            for (; j < seg2; j++)
                toArray[k++] = fromArray[j];
        } else {
            for (; i < seg1; i++)
                toArray[k++] = fromArray[i];
        }

    }

    public static void mergeSort(int[] array) {
        int[] tempArray = new int[array.length];
        boolean raw = true;
        for (int i = 1; i < array.length; i *= 2) {
            for (int j = 0; j < array.length; j += 2 * i) {
                if (raw)
                    mergeSort(array, tempArray, j, i);
                else
                    mergeSort(tempArray, array, j, i);
            }
            raw = !raw;
        }
        if (!raw)
            System.arraycopy(tempArray, 0, array, 0, array.length);
    }

    public static void main(String[] args) {
        int[] array = {11, 11, -3, -4, 7, -4, 22, 15, 13};
        mergeSort(array);
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }

}
