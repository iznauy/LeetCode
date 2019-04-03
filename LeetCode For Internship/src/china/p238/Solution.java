package china.p238;

/**
 * Created on 14/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] results = new int[nums.length];
        results[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            results[i] = results[i - 1] * nums[i];
        }
        int val = 1;
        for (int i = nums.length - 1; i >= 0; i++) {
            results[i] *= val;
            val *= nums[i];
        }
        return results;
    }
}
