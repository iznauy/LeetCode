import java.util.*;

/**
 * Created on 18/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P30 {

    public List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words[0].length();
        TreeMap<Integer, Integer> indexMap = new TreeMap<>();
        for (int i = 0; i < words.length; i++) {
            int index = 0;
            while (true) {
                index = s.indexOf(words[i], index);
                if (index == -1)
                    break;
                indexMap.put(index, i);
                index += wordLength;
            }
        }

        List<Integer> resultList = new ArrayList<>();
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>();

        int[] marked = new int[words.length];
        for (int i = 0; i < marked.length; i++)
            marked[i] = -1;

        int expectNextIndex = -1, beginIndex = -1;
        int count = 0;
        for (Map.Entry<Integer, Integer> entry: indexMap.entrySet()) {

            int index = entry.getKey();
            if (expectNextIndex == -1) {
                expectNextIndex = index + wordLength;
                beginIndex = index;
            }
            else if (expectNextIndex != index) {
                // 清空 marked 标记，重新计数
                for (int i = 0; i < marked.length; i++)
                    marked[i] = -1;
                expectNextIndex = index + wordLength;
            }
            int markedIndex = entry.getValue();
            if (marked[markedIndex] != -1) {
                // 已经被占用了
                int toIndex = marked[markedIndex];
                int fromIndex = entryList.size() - count;
                for (int i = fromIndex; i <= toIndex; i++) {
                    count--;
                    marked[entryList.get(i).getValue()] = -1; // 清理掉
                }
            }
            marked[markedIndex] = entryList.size();
            // add to entry List
            entryList.add(entry);
            count++;

            if (count == words.length) {
                resultList.add(beginIndex);
                beginIndex = expectNextIndex = -1;
                count = 0;
                for (int i = 0; i < marked.length; i++)
                    marked[i] = -1;
            }
        }
        return resultList;
    }

}
