package others;

/**
 * Created on 26/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P27 {

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

}
