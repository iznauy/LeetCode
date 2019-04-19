import java.util.HashMap;
import java.util.Map;

/**
 * Created on 18/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P337 {


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int rob(TreeNode root) {
        return rob(root, true);
    }

    private Map<TreeNode, Integer> canCache = new HashMap<>();

    private Map<TreeNode, Integer> cannotCache = new HashMap<>();


    private int rob(TreeNode root, boolean can) {
        if (root == null)
            return 0;

        // search from cache
        int result;
        if (can)
            result = canCache.getOrDefault(root, -1);
        else
            result = cannotCache.getOrDefault(root, -1);
        if (result != -1)
            return result;

        // don't rob root
        int nonRobRoot = rob(root.left, true) + rob(root.right, true);
        if (!can) {
            cannotCache.put(root, nonRobRoot);
            return nonRobRoot;
        }
        // rob root
        int robRoot = root.val + rob(root.left, false) + rob(root.right, false);
        result =  Math.max(nonRobRoot, robRoot);
        canCache.put(root, result);
        return result;
    }

}

class P337Another {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static final int[] empty = new int[] {0, 0};

    public int rob(TreeNode root) {
        int[] arr = solve(root);
        return Math.max(arr[0], arr[1]);
    }

    private int[] solve(TreeNode root) {
        if (root == null)
            return empty;
        int[] left = solve(root.left), right = solve(root.right); // arr[0] 表示抢了子节点的根节点，arr[1]表示没抢子节点的根节点
        int nonRobRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // 表示没有抢当前节点，子节点随便抢
        int robRoot = root.val + left[1] + right[1];
        return new int[] {robRoot, nonRobRoot};
    }

}
