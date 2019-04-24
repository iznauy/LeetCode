package week133;

import java.util.*;

/**
 * Created on 24/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P1030 {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] array = new int[R * C][2];
        final int r = r0, c = c0;
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++) {
                array[i * C + j][0] = i;
                array[i * C + j][1] = j;
            }
        Arrays.sort(array, Comparator.comparingInt(o -> Math.abs(o[0] - r) + Math.abs(Math.abs(o[1] - c))));
        return array;
    }

}
