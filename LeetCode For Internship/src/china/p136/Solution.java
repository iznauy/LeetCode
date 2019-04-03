package china.p136;

/**
 * Created on 15/03/2019.
 * Description:
 *
 * @author iznauy
 */
class Solution {
    public int singleNumber(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }
}
