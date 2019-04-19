import java.util.Arrays;

/**
 * Created on 16/04/2019.
 * Description: 这题就是暴力搜索，不过很奇怪的是不剪枝比剪枝快一百倍。。
 *
 * @author iznauy
 */
public class P698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length <= k)
            return false;
        int sum = 0;
        for (int num: nums)
            sum += num;
        if (sum % k != 0)
            return false;
        Arrays.sort(nums);
        sum /= k;
        boolean[] used = new boolean[nums.length];
        return canPartitionKSubsets(nums, used, k, sum, 0, 0);
    }

    private boolean canPartitionKSubsets(int[] nums, boolean[] used, int k, int target, int curSum, int begin) {
        if (k == 1)
            return true;
        if (curSum == target)
            return canPartitionKSubsets(nums, used, k - 1, target, 0, 0);

        for (int i = begin; i < nums.length; i++) {
            if (!used[i]) {
                if (nums[i] > target - curSum)
                    break;
                used[i] = true;
                if (canPartitionKSubsets(nums, used, k, target, curSum + nums[i], i + 1))
                    return true;
                used[i] = false;
            }
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
