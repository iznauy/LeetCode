package all.p96;

/**
 * Created on 14/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class Solution {

    public int numTrees(int n) {
        int[] array = new int[n + 1];
        array[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++)
                array[i] += array[j] * array[i - j - 1];
        }
        return array[n];
    }

}
