package top.iznauy;

/**
 * Created on 25/01/2019.
 * Description:
 *
 * @author iznauy
 */
public class Solution12 {
    public String intToRoman(int num) {
        char[] table1 = new char[] {'M', 'C', 'X', 'I'};
        char[] table2 = new char[] {' ', 'D', 'L', 'V'};

        StringBuilder resultBuilder = new StringBuilder();
        String strNum = Integer.toString(num);
        while (strNum.length() < 4)
            strNum = '0' + strNum;
        for (int i = 0; i < 4; i++) {
            int m = strNum.charAt(i) - '0';
            if (m == 9)
                resultBuilder.append(table1[i]).append(table1[i - 1]);
            else if (m == 4)
                resultBuilder.append(table1[i]).append(table2[i]);
            else {
                if (m > 4) {
                    m -= 5;
                    resultBuilder.append(table2[i]);
                }
                for (int j = 0; j < m; j++)
                    resultBuilder.append(table1[i]);
            }

        }
        return resultBuilder.toString();
    }

    public static void main(String... args) {
        Solution12 s = new Solution12();
        System.out.println(s.intToRoman(1994));
    }
}
