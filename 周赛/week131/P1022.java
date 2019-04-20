package week131;

import java.math.BigInteger;

/**
 * Created on 20/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P1022 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

    private BigInteger result = BigInteger.ZERO;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, BigInteger.ZERO); // dfs
        // 取模
        return result.mod(new BigInteger("1000000007")).intValue();
    }

    private void dfs(TreeNode node, BigInteger culVal) {
        culVal = culVal.shiftLeft(1);
        if (node.val == 1)
            culVal = culVal.add(BigInteger.ONE);
        if (node.left != null)
            dfs(node.left, culVal);
        if (node.right != null)
            dfs(node.right, culVal);
        if (node.left == null && node.right == null)
            result = result.add(culVal);
    }

}
