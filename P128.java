import java.util.*;

/**
 * Created on 18/04/2019.
 * Description: 实际上是一个 O(nlogn) 算法，效率很糟糕
 *
 * @author iznauy
 */
public class P128 {

    private static class Range {
        int from;
        int to;
        Range(int from, int to) {
            this.from = from;
            this.to = to;
        }
        int length() {
            return to - from;
        }

        static Comparator<Range> comparator = Comparator.comparingInt(o -> o.from);
    }

    public int longestConsecutive(int[] nums) {
        List<Range> ranges = longestConsecutive(nums, 0, nums.length);
        int maxSize = 0;
        for (Range range: ranges) {
            if (range.length() > maxSize)
                maxSize = range.length();
        }
        return maxSize;
    }

    // include from, not include to
    public List<Range> longestConsecutive(int[] nums, int from, int to) {
        if (from >= to)
            return Collections.emptyList();
        if (from == to - 1) {
            List<Range> ranges = new ArrayList<>();
            ranges.add(new Range(nums[from], nums[from] + 1));
            return ranges;
        }
        int mid = (from + to) / 2;
        List<Range> leftRanges = longestConsecutive(nums, from, mid);
        List<Range> rightRanges = longestConsecutive(nums, mid, to);

        // how to merge two ranges?
        leftRanges.sort(Range.comparator);
        rightRanges.sort(Range.comparator);
        List<Range> ranges = new ArrayList<>();

        // double pointer
        int p1 = 0, p2 = 0;
        while (p1 < leftRanges.size() && p2 < rightRanges.size()) {
            Range range1 = leftRanges.get(p1);
            Range range2 = rightRanges.get(p2);
            if (range1.from <= range2.from && range1.to >= range2.from && range1.to <= range2.to) {
                range1.to = range2.to;
                p2++;
            } else if (range2.from <= range1.from && range2.to >= range1.from && range2.to <= range1.to) {
                range2.to = range1.to;
                p1++;
            } else {
                if (range1.from < range2.from) {
                    ranges.add(range1);
                    p1++;
                } else {
                    ranges.add(range2);
                    p2++;
                }
            }
        }
        for (int i = p1; i < leftRanges.size(); i++)
            ranges.add(leftRanges.get(i));
        for (int j = p2; j < rightRanges.size(); j++)
            ranges.add(rightRanges.get(j));

        List<Range> resultList = new ArrayList<>();
        for (Range range: ranges) {
            if (resultList.isEmpty())
                resultList.add(range);
            else {
                Range last = resultList.get(resultList.size() - 1);
                if (last.to >= range.from)
                    last.to = Math.max(last.to, range.to);
                else
                    resultList.add(range);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 100, 4, 200, 1, 3, 2 , 5};
        P128 p128 = new P128();
        System.out.println(p128.longestConsecutive(arr));
    }

}

/**
 * 遇到线性时候，要考虑动态规划/贪心/集合/Hash表
 */
class P128Another {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int num: nums) {
            if (!map.containsKey(num)) {

                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int length = left + right + 1;

                map.put(num - left, length);
                map.put(num + right, length);
                map.put(num, length);

                if (length > maxLength)
                    maxLength = length;
            }
        }
        return maxLength;
    }

}
