package data;

/**
 * Created on 12/03/2019.
 * Description:
 *
 * @author iznauy
 */
class AvlTreeNode {

    int val;

    AvlTreeNode left;

    AvlTreeNode right;

    int height;

    AvlTreeNode(int val) {
        this(val, null, null, 1);
    }

    AvlTreeNode(int val, AvlTreeNode left, AvlTreeNode right, int height) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.height = height;
    }
}
