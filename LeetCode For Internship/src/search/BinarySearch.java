package search;

/**
 * Created on 13/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class BinarySearch {

    public int binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (array[mid] == key)
                return mid;
            else if (array[mid] < key)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    public int binarySearchFirstLarger(int[] array, int key) {
        if (array[array.length - 1] < key)
            return -1;
        int left = 0, right = array.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (array[mid] <= key)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    public int binarySearchFirstEqualOrLarger(int[] array, int key) {
        if (array[array.length - 1] < key)
            return -1;
        int left = 0, right = array.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (array[mid] < key)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }


    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();

        int[] array = {0, 1, 2, 2, 2, 2, 2, 7, 11};

        int index = search.binarySearch(array, 2);
        System.out.println(array[index]);

        index = search.binarySearchFirstLarger(array, 1);
        System.out.println(array[index]);

        index = search.binarySearchFirstEqualOrLarger(array, 2);
        System.out.println(index + " = " + array[index]);
    }

}
