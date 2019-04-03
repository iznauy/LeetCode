package tx;

/**
 * Created on 13/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class KProblem {

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private int partition(int[] array, int from, int to) { // include from, not include to
        if (from >= to)
            return from;
        int left = from, right = to - 1;
        int pivot = array[left];
        while (left != right) {
            while (array[right] < pivot && right > left)
                right--;
            if (left == right)
                break;
            swap(array, left, right);
            left++;
            while (array[left] >= pivot && left < right)
                left++;
            if (left == right)
                break;
            swap(array, left, right);
            right--;
        }
        return left;
    }

    public int findK(int k, int[] array) {
        if (k > array.length)
            throw new IllegalArgumentException();
        int from = 0, to = array.length;
        int part;
        while (true) {
            part = partition(array, from, to);
            System.out.println(part);
            int num = part - from + 1;
            if (num == k)
                break;
            else if (num > k) {
                to = part; // not include
            } else {
                from = part + 1;
                k -= num;
            }
        }
        return array[part];
    }

    public static void main(String[] args) {
        KProblem problem = new KProblem();
        int[] array = {3,2,3,1,2,4,5,5,6};
        System.out.println(problem.findK(4, array));
    }

}
