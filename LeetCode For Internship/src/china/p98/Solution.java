package china.p98;

/**
 * Created on 20/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class Solution {

    private boolean isValidBST(TreeNode root, long max, long min) {
        return root == null || root.val < max && root.val > min &&
                isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    }

    public boolean isValidBST(TreeNode root) {
        return root == null || isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}