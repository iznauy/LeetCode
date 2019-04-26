package others;

/**
 * Created on 26/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index - 1])
                nums[index++] = nums[i];
        }
        return index;
    }

}
