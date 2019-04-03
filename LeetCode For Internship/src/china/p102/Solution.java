package china.p102;

import java.util.*;

/**
 * Created on 20/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<List<Integer>> resultLists = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        List<Integer> levels = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        nodes.add(root);
        levels.add(1);
        for (int i = 0; i < nodes.size(); i++) {
            TreeNode node = nodes.get(i);
            int level = levels.get(i);

            if (node.left != null) {
                nodes.add(node.left);
                levels.add(level + 1);
            }
            if (node.right != null) {
                nodes.add(node.right);
                levels.add(level + 1);
            }

            if (resultLists.size() < level)
                resultLists.add(new ArrayList<>());

            resultLists.get(level).add(node.val);
        }
        return resultLists;
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int x) { val = x; }
}