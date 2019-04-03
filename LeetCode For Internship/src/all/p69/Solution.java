package all.p69;

/**
 * Created on 13/03/2019.
 * Description: 很多时候求函数值的问题都可以转化为2分查找
 *
 * @author iznauy
 */
public class Solution {

    public int mySqrt(int x) {
        if (x < 1)
            return 0;
        int left = 1, right = x;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid == x / mid && x % mid == 0)
                return mid;
            else if (mid <= x / mid) {
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return left - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mySqrt(2));
    }

}
