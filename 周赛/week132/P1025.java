package week132;

/**
 * Created on 19/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P1025 {

    public boolean divisorGame(int N) {
        boolean[] winArray = new boolean[N + 1];
        winArray[1] = false;
        for (int i = 2; i <= N; i++) {
            if (!winArray[i - 1]) {
                winArray[i] = true;
            } else {
                for (int j = 2; j * j <= i; j++) {
                    if (N % j == 0) {
                        int factor1 = j, factor2 = N / j;
                        if (!winArray[N - factor1] || !winArray[N - factor2]) {
                            winArray[i] = true;
                            break;
                        }
                    }
                }
                winArray[i] = false;
            }
        }
        return winArray[N];
    }

}
