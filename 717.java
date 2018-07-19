import java.util.Arrays;

/**
 * Created on 2018/7/19.
 * Description:
 *
 * @author iznauy
 */
public class Solution {

    public boolean isOneBitCharacter(int[] bits) {
        boolean in = false;
        for (int i = 0; i < bits.length - 1; i++)
            if (in)
                in = false;
            else if (bits[i] == 1)
                in = true;
        return !in;
    }

}
