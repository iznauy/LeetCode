package china.p11;

/**
 * Created on 14/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int current = (right - left) * Math.min(height[right], height[left]);
            max = Math.max(current, max);
            if (height[right] >= height[left]) {
                int i = left + 1;
                while (height[i] < height[left])
                    i++;
                left = i;
            } else {
                int j = right - 1;
                while (height[j] < height[right])
                    j--;
                right = j;
            }
        }
        return max;
    }
}
