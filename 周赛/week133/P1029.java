package week133;

import java.util.Arrays;
import java.util.Comparator;


/**
 * Created on 21/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P1029 {

    public int twoCitySchedCost(int[][] costs) {
        int[] array = new int[costs.length];
        int sum = 0;
        for (int i = 0; i < costs.length; i++) {
            array[i] = costs[i][0] - costs[i][1];
            sum += costs[i][1];
        }
        Arrays.sort(array);
        for (int i = 0; i < costs.length / 2; i++)
            sum += array[i];
        return sum;
    }

    public static void main(String[] args) {
        P1029 p = new P1029();
    }

}
