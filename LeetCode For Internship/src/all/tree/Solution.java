package all.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created on 12/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class Solution {

    private void preOrderTraversal(TreeNode root, List<Integer> result) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node == null)
                continue;
            result.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
    }

    private void inOrderTraversal(TreeNode root, List<Integer> result) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.empty() || node != null) {
            if (node == null) {
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            } else {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }

    private void postOrderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            TreeNode node;
            stack1.push(root);
            while (!stack1.empty()) {
                node = stack1.pop();
                stack2.push(node);
                // 先访问的先放进去，栈1后弹出来，所以栈2先弹出来
                if (node.left != null)
                    stack1.push(node.left);
                if (node.right != null)
                    stack1.push(node.right);
            }
            while (!stack2.empty()) {
                result.add(stack2.pop().val);
            }
        }
    }

    static class Pair {

        enum State {
            LEFT,
            RIGHT,
            FINISH
        }

        State state;

        TreeNode node;

        Pair(State state, TreeNode node) {
            this.state = state;
            this.node = node;
        }
    }

    private void postOrderTraversal2(TreeNode root, List<Integer> result) {
        Stack<Pair> stack = new Stack<>();
        Pair pair = new Pair(Pair.State.LEFT, root);
        stack.push(pair);
        while (!stack.empty()) {
            pair = stack.pop();
            if (pair.state == Pair.State.LEFT) {
                stack.push(new Pair(Pair.State.RIGHT, pair.node));
                if (pair.node.left != null)
                    stack.push(new Pair(Pair.State.LEFT, pair.node.left));
            } else if (pair.state == Pair.State.RIGHT) {
                stack.push(new Pair(Pair.State.FINISH, pair.node));
                if (pair.node.right != null)
                    stack.push(new Pair(Pair.State.LEFT, pair.node.right));
            } else if (pair.state == Pair.State.FINISH) {
                result.add(pair.node.val);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node1.left = node2;
        node1.right = node3;
        List<Integer> result = new ArrayList<>();
        solution.postOrderTraversal2(node1, result);
        for (int val: result) {
            System.out.println(val);
        }
    }



}
