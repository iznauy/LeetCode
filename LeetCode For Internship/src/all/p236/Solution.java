package all.p236;

/**
 * Created on 10/03/2019.
 * Description:
 *
 * @author iznauy
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    enum Pair {
        NEITHER,
        LEFT,
        RIGHT,
        ALL
    }

    private TreeNode result = null;

    private Pair myImpl(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return Pair.NEITHER;
        Pair left = myImpl(root.left, p, q);
        Pair right = myImpl(root.right, p, q);
        if (result != null)
            return Pair.ALL;
        if ((left == Pair.LEFT && right == Pair.RIGHT) || (left == Pair.RIGHT && right == Pair.LEFT)
                || ((left == Pair.LEFT || right == Pair.LEFT) && root.val == q.val)
                || ((left == Pair.RIGHT) || right == Pair.RIGHT) && root.val == p.val) {
            result = root;
            return Pair.ALL;
        }
        if (left == Pair.LEFT || right == Pair.LEFT || root.val == p.val)
            return Pair.LEFT;
        if (left == Pair.RIGHT || right == Pair.RIGHT || root.val == q.val)
            return Pair.RIGHT;
        return Pair.NEITHER;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        myImpl(root,p, q);
        return result;
    }

}

class Solution2 {

    private TreeNode ans;

    public Solution2() {
        // Variable to store LCA node.
        this.ans = null;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }
}
