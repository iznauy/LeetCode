package china.p33;

/**
 * Created on 17/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class Solution {
    // 实际上这种算法会遍历2次数组，不过也是log n级别的。还有一种更加简便的方法：
    // 不断将数组二分，如果
    public int search(int[] nums, int target) {
        if (nums.length < 10) { // 很短的情况下我直接遍历就可以了
            for (int i = 0; i < nums.length; i++)
                if (nums[i] == target)
                    return i;
            return -1;
        }
        int left = 1, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] - nums[mid - 1] <= 0)
                break;
            else if (nums[mid] >= nums[left])
                left = mid + 1;
            else
                right = mid - 1;
        }
        if (target >= nums[0])
            return binarySearch(nums, 0, mid, target);
        else
            return binarySearch(nums, mid, nums.length, target);
    }

    // 只需要搜索一遍数组
    // 每次分成两部分。
    // 判断那一部分有序，那一部分无序。
    // 然后根据范围选择取哪一边
    public int anotherSearch(int[] nums, int target) {
        if (nums.length < 10) { // 很短的情况下我直接遍历就可以了
            for (int i = 0; i < nums.length; i++)
                if (nums[i] == target)
                    return i;
            return -1;
        }
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            // take apart into [left..mid], [mid+1..right]
            // which make sure that each part contains at least one element
            if (nums[left] <= nums[mid]){ // 左边是有序的
                if (nums[left] <= target && nums[mid] >= target) // 只可能在有序区域
                    return binarySearch(nums, left, mid + 1, target);
                else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid + 1] <= target && nums[right] >= target)
                    return binarySearch(nums, mid + 1, right + 1, target);
                else {
                    right = mid;
                }
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int from, int to, int target) { // include from, exclude to
        int left = from, right = to - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}