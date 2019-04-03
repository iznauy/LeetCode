package data;

/**
 * Created on 20/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class Heap {

    // 建立最小堆
    // 假设两颗子树都是最小堆
    private void innerBuildHeap(int[] array, int root, int size) {
        int left = root * 2 + 1, right = root * 2 + 2;
        while ((left < size && array[root] > array[left]) || (right < size && array[root] > array[right])) {
            int temp = array[root];
            if (right < size && array[left] > array[right]) {
                array[root] = array[right];
                array[right] = temp;
                root = right;
            } else {
                array[root] = array[left];
                array[left] = temp;
                root = left;
            }
            left = root * 2 + 1;
            right = root * 2 + 2;
        }
    }

    private void buildHeap(int[] array) {
        for (int i = (array.length + 1) / 2; i >= 0; i--)
            innerBuildHeap(array, i, array.length);
    }

    private void sort(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            innerBuildHeap(array, 0, i);
        }
    }

    private void negative(int[] array) {
        for (int i = 0; i < array.length; i++)
            array[i] = - array[i];
    }

    public void heapSort(int[] array) {
        if (array == null || array.length <= 1)
            return;
        negative(array);
        buildHeap(array);
        sort(array);
        negative(array);
    }

    public static void main(String[] args) {
        int[] array = { 3, 1, 2, -2, 22, 8 };
        Heap heap = new Heap();
        heap.heapSort(array);
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    }

}
