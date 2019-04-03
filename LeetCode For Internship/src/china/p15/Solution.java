package china.p15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 14/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= nums.length - 3; i++) {
            while (i > 0 && i < nums.length && nums[i] == nums[i - 1]) // skip duplicate
                i++;
            if (i > nums.length - 3)
                break;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums[i]);
                    pair.add(nums[j]);
                    pair.add(nums[k]);
                    result.add(pair);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (k > j && nums[k] == nums[k + 1])
                        k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                } else {
                    k--;
                    while (k > j && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }
        return result;
    }

}
