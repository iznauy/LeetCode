package data;

/**
 * Created on 12/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class BinarySearchTree {

    private BinaryTreeNode root;

    public boolean contains(int val) {
        return contains(root, val);
    }

    public boolean insert(int val) {
        if (contains(val))
            return false;
        root = insert(root, val);
        return true;
    }

    public boolean delete(int val) {
        if (!contains(val))
            return false;
        root = delete(root, val);
        return true;
    }

    private boolean contains(BinaryTreeNode node, int val) {
        if (node == null)
            return false;
        if (node.val == val)
            return true;
        else if (node.val < val)
            return contains(node.right, val);
        else
            return contains(node.left, val);
    }

    private BinaryTreeNode insert(BinaryTreeNode node, int val) {
        if (node == null)
            return new BinaryTreeNode(val);
        if (node.val > val)
            node.left = insert(node.left, val);
        else if (node.val < val)
            node.right = insert(node.right, val);
        return null;
    }

    private BinaryTreeNode delete(BinaryTreeNode node, int val) {
        if (node.val < val)
            node.right = delete(node.right, val);
        else if (node.val > val)
            node.right = delete(node.left, val);
        else {
            if (node.left == null && node.right == null)
                node = null;
            else if (node.left != null && node.right == null)
                node = node.left;
            else if (node.left == null && node.right != null)
                node = node.right;
            else {
                int rightMin = findMin(node.right); // 找出右边最小节点
                node.val = rightMin;
                node.right = delete(node.right, rightMin);
            }
        }
        return node;
    }

    private int findMin(BinaryTreeNode node) {
        if (node == null)
            return 0;
        while (node.left != null)
            node = node.left;
        return node.val;
    }

}
