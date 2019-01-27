package top.iznauy;

import java.util.Arrays;

/**
 * Created on 27/01/2019.
 * Description: O(n^2)的复杂度
 *
 * @author iznauy
 */
public class Solution31 {

    public void nextPermutation(int[] nums) {
        int fromIndex = nums.length - 1;
        while (fromIndex > 0 && nums[fromIndex] <= nums[fromIndex - 1])
            fromIndex--; // 还处在不断攀升状态
        if (fromIndex != 0) {
            int index;
            for (index = nums.length - 1; nums[index] <= nums[fromIndex - 1]; index--);

            int temp = nums[fromIndex - 1]; // swap
            nums[fromIndex - 1] = nums[index];
            nums[index] = temp;
        }
        Arrays.sort(nums, fromIndex, nums.length);

    }

    public static void main(String... args) {
        int[] array = new int[] { 7, 6, 5, 4, 3, 2, 1 };
        Solution31 solution31 = new Solution31();
        solution31.nextPermutation(array);
        for (int num: array) {
            System.out
                    .print(num);
            System.out.print(' ');
        }
    }

}

class AnotherSolution31 {

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutation(int[] nums) {
        int fromIndex = nums.length - 1;
        while (fromIndex > 0 && nums[fromIndex] <= nums[fromIndex - 1])
            fromIndex--;
        if (fromIndex != 0) {
            int index;
            for (index = nums.length - 1; nums[index] <= nums[fromIndex - 1]; index--);
            swap(nums, index, fromIndex - 1);
        }
        for (int i = 0; i < (nums.length - fromIndex) / 2; i++)
            swap(nums, i + fromIndex, nums.length - i - 1);

    }

    public static void main(String... args) {
        int[] array = new int[] { 1,2,3 };
        AnotherSolution31 solution31 = new AnotherSolution31();
        solution31.nextPermutation(array);
        for (int num: array) {
            System.out
                    .print(num);
            System.out.print(' ');
        }
    }

}
