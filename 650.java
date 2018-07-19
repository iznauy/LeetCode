import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 2018/7/19.
 * Description:
 *
 * @author iznauy
 */
public class Solution {

    private int[][] boards;

    public int MAX = 10000; // 没有探索过或者不可达记为MAX


    private void fillUp(int n) {
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                if (i == j) {
                    for (int k = 1; k < j; k++)
                        boards[i][j] = Math.min(boards[i][k] + 1, boards[i][j]);
                } else {
                    boards[i][j] = boards[i - j][j] == MAX ? MAX : boards[i - j][j] + 1;
                }
            }
        }
    }

    public int minSteps(int n) {
        if (n == 1)
            return 0;
        boards = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++)
            for (int j = 0; j < n + 1; j++)
                boards[i][j] = MAX;
        boards[1][0] = 0;
        boards[1][1] = 1;
        fillUp(n);
        System.out.println(Arrays.deepToString(boards));
        return boards[n][n] - 1;
    }

}

class StandardSolution { // 标准答案，实质上转化为了整数分解，太6了！

    public int minSteps(int n) {
        int ans = 0, d = 2;
        while (n > 1) {
            while (n % d == 0) {
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }
}
