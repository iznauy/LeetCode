package china.p199;

import java.util.LinkedList;
import java.util.List;

/**
 * Created on 20/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class Solution {

    private List<Integer> results = new LinkedList<>();

    public List<Integer> rightSideView(TreeNode root) {
        rightSideView(root, 1);
        return results;
    }

    private void rightSideView(TreeNode root, int level) {
        if (root != null) {
            if (results.size() < level)
                results.add(root.val);
            level++;
            rightSideView(root.right, level);
            rightSideView(root.left, level);
        }
    }



}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}