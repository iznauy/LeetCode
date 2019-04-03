package tx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on 18/03/2019.
 * Description:
 *
 * @author iznauy
 */

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int x) { val = x; }
}

public class RightElements {

    public List<Integer> printRightElements(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<TreeNode> nodes = new LinkedList<>();
        List<Integer> results = new ArrayList<>();
        nodes.add(root);
        nodes.add(null);
        while (nodes.size() >= 2) {
            TreeNode pre = nodes.remove(0);
            TreeNode curr = nodes.remove(0);
            while (curr != null) {
                if (pre.left != null)
                    nodes.add(pre.left);
                if (pre.right != null)
                    nodes.add(pre.right);
                pre = curr;
                curr = nodes.remove(0);
            }
            if (pre.left != null)
                nodes.add(pre.left);
            if (pre.right != null)
                nodes.add(pre.right);
            nodes.add(null);
            results.add(pre.val);
        }
        return results;
    }

    public static void main(String[] args) {
        RightElements elements = new RightElements();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node4.left = node6;
        node4.right = node7;
        node3.left = node5;
        node2.left = node4;
        node1.left = node2;
        node1.right = node3;
        List<Integer> results = elements.printRightElements(node1);
        for (int i: results) {
            System.out.println(i);
        }
    }

}
