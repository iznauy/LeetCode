import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created on 19/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P179 {

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "0";
        String[] numStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            numStrings[i] = String.valueOf(nums[i]);
        Arrays.sort(numStrings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int ptr1 = 0, ptr2 = 0;
                while (ptr1 < o1.length() && ptr2 < o2.length()) {
                    if (o1.charAt(ptr1) < o2.charAt(ptr2))
                        return -1;
                    else if (o1.charAt(ptr1) > o2.charAt(ptr2))
                        return 1;
                    ptr1++;
                    ptr2++;
                }
                if (ptr1 == o1.length() && ptr2 == o2.length())
                    return 0;
                else if (ptr1 == o1.length()) {
                    return compare(o1, o2.substring(ptr2));
                } else {
                    return compare(o1.substring(ptr1), o2);
                }
            }
        });
        if (numStrings[numStrings.length - 1].equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = numStrings.length - 1; i >= 0; i--)
            sb.append(numStrings[i]);
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] array = new int[]{ 98,9,97,8,84,8483,8484848,7,77 };
        P179 p179 = new P179();
        System.out.println(p179.largestNumber(array));
    }

}

/**
 * 别人的思路，非常简洁
 */
class AnotherP179 {

    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num: nums)
            list.add(Integer.toString(num));
        list.sort((o1, o2) -> {
            String c1 = o1 + o2;
            String c2 = o2 + o1; // 加起来就保证了一样长，同时，两个加起来哪个在前面，也自然就能推出哪个应该排在前面（实证！）
            return c2.compareTo(c1); // 这边之所以是c2.compareTo(c1)，其实是在进行倒序排序
        });
        return (list.isEmpty() || "0".equals(list.get(0))) ? "0" : String.join(""), list
    }

}
