package tx;

/**
 * Created on 13/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class Others {

    // 判断一个数字是否恰好是2的某次方
    public static boolean is2k(int value) {
        return value > 0 && ((value & value - 1) == 0);
    }

}
