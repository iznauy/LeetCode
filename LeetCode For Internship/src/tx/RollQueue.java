package tx;

/**
 * Created on 13/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class RollQueue {

    public int solution(int x, int y) {
        if (x == 0 && y == 0)
            return 1;
        int corner = Math.max(Math.abs(x), Math.abs(y));
        int base = ((corner << 1) + 1) * ((corner << 1) + 1);
        if (y == -corner)
            return base + (x - corner);
        else if (x == -corner)
            return base - 2 * corner - (y + corner);
        else if (y == corner)
            return base - 4 * corner - (x + corner);
        else
            return base - 6 * corner + (y - corner);
    }

    public static void main(String[] args) {
        RollQueue queue = new RollQueue();
        for (int i = -5; i <= 5; i++) {
            for (int j = -5; j <= 5; j++) {
                System.out.print(queue.solution(j, i) + " ");
            }
            System.out.println();
        }
        System.out.println(queue.solution(1, 1));
    }

}
