/**
 * Created on 16/04/2019.
 * Description: 背包问题，要专门写一篇博客
 *
 * @author iznauy
 */
public class P416 {

    public boolean canPartition(int[] nums) {
        if (nums.length == 1)
            return false;
        int sum = 0;
        for (int num: nums)
            sum += num;
        if ((sum & 1) == 1)
            return false;
        sum = (sum >> 1);
        boolean[] array = new boolean[sum + 1];
        array[0] = true;
        for (int i = 0; i < nums.length; i++)
            for (int j = sum - 1; j > 0; j--)
                if (nums[i] <= j)
                    array[j] = array[j] || array[j - nums[i]];
        return array[sum];
    }


    public static void main(String[] args) {
        P416 p416 = new P416();
        System.out.println(p416.canPartition(new int[]{1, 11, 5, 5}));
    }

}
