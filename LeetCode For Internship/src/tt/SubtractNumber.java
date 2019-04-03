package tt;

/**
 * Created on 20/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class SubtractNumber {

    // include from, not include to
    private int getMax(String number, int from, int to) {
        int max = from;
        for (int i = from + 1; i < to; i++)
            if (number.charAt(max) < number.charAt(i))
                max = i;
        return max;
    }

    public String subtractKNumber(String number, int k) {
        if (number.length() <= k)
            return "0";
        StringBuilder resultBuilder = new StringBuilder();
        int from = 0;
        while (k > 0) {
            int index = getMax(number, from, from + k + 1);
            resultBuilder.append(number.charAt(index));
            k -= (index - from);
            from = index + 1;
        }
        resultBuilder.append(number.substring(from));
        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        SubtractNumber subtractNumber = new SubtractNumber();
        String number = "89472138";
        System.out.println(subtractNumber.subtractKNumber(number, 5));
    }

}
