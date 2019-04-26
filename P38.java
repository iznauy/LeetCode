package others;

/**
 * Created on 26/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P38 {

    public String countAndSay(int n) {
        String[] results = new String[n + 1];
        results[1] = "1";
        for (int i = 2; i < n + 1; i++) {
            StringBuilder resultBuilder = new StringBuilder(results[i - 1].length() * 2);
            int currValue = 0, count = 0;
            for (int j = 0; j < results[i - 1].length(); j++) {
                int value = results[i - 1].charAt(j) - '0';
                if (currValue == 0)
                    currValue = value;
                if (currValue != value) {
                    resultBuilder.append(count).append(currValue);
                    currValue = value;
                    count = 0;
                }
                count++;
            }
            resultBuilder.append(count).append(currValue);
            results[i] = resultBuilder.toString();
        }
        return results[n];
    }

}
