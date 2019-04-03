package china.p46;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on 14/03/2019.
 * Description:
 *
 * @author iznauy
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> unUsed = new HashSet<>();
        for (int num: nums)
            unUsed.add(num);
        List<List<Integer>> results = new ArrayList<>();
        addPermutation(unUsed, results, new ArrayList<>(nums.length));
        return results;
    }

    private void addPermutation(Set<Integer> unUsed, List<List<Integer>> results, List<Integer> currentList) {
        if (unUsed.size() == 0)
            results.add(new ArrayList<>(currentList));
        else {
            Set<Integer> tempSet = new HashSet<>(unUsed);
            for (int val: unUsed) {
                currentList.add(val);
                tempSet.remove(val);
                addPermutation(tempSet, results, currentList);
                currentList.remove(currentList.size() - 1);
                tempSet.add(val);
            }
        }
    }

}