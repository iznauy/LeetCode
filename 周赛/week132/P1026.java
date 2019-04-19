package week132;

/**
 * Created on 19/04/2019.
 * Description:
 *
 * @author iznauy
 */

public class P1026 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return 0;
        return minMax(root)[2];
    }

    // 返回是一个长度为3的数组，min，max，maxDiff
    private int[] minMax(TreeNode root) {
        int[] arr = new int[3];
        arr[0] = arr[1] = root.val;
        arr[2] = 0;
        if (root.left != null) {
            int[] leftArr = minMax(root.left);
            arr[0] = Math.min(arr[0], leftArr[0]);
            arr[1] = Math.max(arr[1], leftArr[1]);
            int maxDiff = Math.max(Math.abs(root.val - arr[0]), Math.abs(root.val - arr[1]));
            arr[2] = Math.max(maxDiff, leftArr[2]);
        }
        if (root.right != null) {
            int[] rightArr = minMax(root.right);
            arr[0] = Math.min(arr[0], rightArr[0]);
            arr[1] = Math.max(arr[1], rightArr[1]);
            int maxDiff = Math.max(Math.abs(root.val - arr[0]), Math.abs(root.val - arr[1]));
            arr[2] = Math.max(arr[2], Math.max(maxDiff, rightArr[2]));
        }
        return arr;
    }

}
