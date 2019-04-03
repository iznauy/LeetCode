package data;

/**
 * Created on 12/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class AvlTree {

    private AvlTreeNode root;

    public boolean contains(int val) {
        return contains(root, val);
    }

    public boolean insert(int val) {
        if (contains(val))
            return false;
        root = insert(root, val);
        return false;
    }

    private boolean contains(AvlTreeNode node, int val) {
        if (node == null)
            return false;
        if (node.val < val)
            return contains(node.right, val);
        else if (node.val > val)
            return contains(node.left, val);
        else
            return true;
    }

    private AvlTreeNode insert(AvlTreeNode node, int val) {
        if (node == null)
            return new AvlTreeNode(val);
        if (node.val < val)
            node.right = insert(node.right, val);
        else if (node.val > val)
            node.left = insert(node.left, val);

        return balance(node); // 对树进行平衡，并且重新设置高度等等
    }

    private AvlTreeNode balance(AvlTreeNode node) {
        if (node == null)
            return null;
        if (height(node.left) - height(node.right) >= 2) { // 左边的树比右边高2了
            if (height(node.left.left) > height(node.left.right))
                node = rotateWithLeftTree(node);
            else
                node = doubleRotateWithLeftTree(node);
        } else if (height(node.right) - height(node.left) >= 2) {
            if (height(node.right.right) >= height(node.right.left))
                node = rotateWithRightTree(node);
            else
                node = doubleRotateWithRightTree(node);
        }
        return node;
    }

    private AvlTreeNode rotateWithLeftTree(AvlTreeNode node) {
        AvlTreeNode newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;
        return newRoot;
    }

    private AvlTreeNode doubleRotateWithLeftTree(AvlTreeNode node) {
        node.left = rotateWithRightTree(node.left);
        return rotateWithLeftTree(node);
    }

    private AvlTreeNode rotateWithRightTree(AvlTreeNode node) {
        AvlTreeNode newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;
        return newRoot;
    }

    private AvlTreeNode doubleRotateWithRightTree(AvlTreeNode node) {
        node.right = rotateWithLeftTree(node.right);
        return rotateWithRightTree(node);
    }

    private int height(AvlTreeNode node) {
        if (node == null)
            return 0;
        else
            return node.height;
    }

}
