package tt;

/**
 * Created on 27/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class ReverseNumber {

    public static void main(String[] args) {
        ReverseNumber rm = new ReverseNumber();
        rm.solve();
    }

    public void solve() {
        for (int i = 0; i < 10000; i++) {
            String number = String.valueOf(i);
            String reverseNumber = new StringBuilder(number).reverse().toString();
            if (number.equals(reverseNumber))
                System.out.println(i);
        }
    }

}
