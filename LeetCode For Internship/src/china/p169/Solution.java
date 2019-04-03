package china.p169;

/**
 * Created on 15/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class Solution {

    public int majorityElement(int[] nums) {
        int counter = 1;
        int majority = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majority)
                counter++;
            else {
                counter--;
                if (counter == 0) {
                    counter = 1;
                    majority = nums[i];
                }
            }
        }
        return majority;
    }
}