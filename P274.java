import java.util.Arrays;

/**
 * Created on 18/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P274 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] < citations.length - i) {
                return citations.length - i + 1;
            }

        }
        return citations.length;
    }

}
