package all.p94;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created on 12/03/2019.
 * Description:
 *
 * @author iznauy
 */
class Solution {

    private void inOrderTraversal(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        inOrderTraversal(root.left, result);
        result.add(root.val);
        inOrderTraversal(root.right, result);
    }

    static class Pair {
        TreeNode node;
        boolean left;
        Pair(TreeNode node, boolean left) {
            this.node = node;
            this.left = left;
        }
    }

    private void inOrderTraversalNonRecursive(TreeNode root, List<Integer> result) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, true));
        while (!stack.empty()) {
            Pair pair = stack.pop();
            TreeNode pointer = pair.node;
            if (pointer == null)
                continue;
            if (pair.left) {
                while (pointer.left != null) {
                    stack.push(new Pair(pointer, false));
                    pointer = pointer.left;
                }
            }
            result.add(pointer.val);
            stack.push(new Pair(pointer.right, true));
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        inOrderTraversalNonRecursive(root, result);
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
