package others;

/**
 * Created on 26/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P35 {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = left + 1;
            else
                right = right - 1;
        }
        return left;
    }

}
