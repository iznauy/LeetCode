package week131;

import java.util.*;

/**
 * Created on 22/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P1024 {

    public int videoStitching(int[][] clips, int T) {
        Map<Integer, Integer> beginToEndMap = new HashMap<>();
        int max = -1;
        for (int[] clip: clips) {
            if (clip[1] > max)
                max = clip[1];
            int value = beginToEndMap.getOrDefault(clip[0], -1);
            if (clip[1] > value)
                beginToEndMap.put(clip[0], clip[1]);
        }
        if (max < T)
            return -1;
        int count = 1, curr = 0;
        max = beginToEndMap.getOrDefault(0, -1);
        if (max == -1)
            return -1;
        while (max < T) {
            int tempMax = -1;
            for (int i = curr + 1; i <= max; i++) {
                int val = beginToEndMap.getOrDefault(i, -1);
                if (val > tempMax)
                    tempMax = val;
            }
            if (tempMax <= max)
                return -1;
            curr = max;
            max = tempMax;
            count++;
        }
        return count;
    }

}
