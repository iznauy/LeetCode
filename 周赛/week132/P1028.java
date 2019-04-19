package week132;

import java.util.Stack;

/**
 * Created on 19/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P1028 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "TreeNode " + val;
        }
    }

    public TreeNode recoverFromPreorder(String S) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode result = null;
        char[] array = S.toCharArray();
        int i = 0;
        while (i < S.length()) {
            int level = 0;
            while (array[i + level] == '-')
                level++;
            i += level;
            int num;
            StringBuilder sb = new StringBuilder();
            while (i < S.length() && array[i] != '-') {
                sb.append(array[i]);
                i++;
            }
            num = Integer.valueOf(sb.toString());
            TreeNode newNode = new TreeNode(num);

            while (stack.size() > level)
                stack.pop();

            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek();
                if (parent.left == null)
                    parent.left = newNode;
                else
                    parent.right = newNode;
            } else
                result = newNode;
            stack.push(newNode);
        }
        return result;
    }

    public static void main(String[] args) {
        P1028 problem = new P1028();
        String s = "1-2--3--4-5--6--7";
        System.out.println(problem.recoverFromPreorder(s));
    }


}
