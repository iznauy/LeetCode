package aim_at_offer;

/**
 * Created on 20/03/2019.
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

public class P37 {

    static class Pair {
        TreeNode node;
        int pos; // 下个树开始位置
        Pair(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }

    private void serialize(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("$,");
            return;
        }
        builder.append(root.val).append(',');
        serialize(root.left, builder);
        serialize(root.right, builder);
    }

    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();
    }

    public TreeNode deserialize(String string) {
        String[] nodes = string.split(",");
        return deserialize(nodes, 0).node;
    }

    private Pair deserialize(String[] nodes, int from) {
        if (nodes[from].equals("$"))
            return new Pair(null, from + 1);
        TreeNode root = new TreeNode(Integer.valueOf(nodes[from]));
        Pair leftPair = deserialize(nodes, from + 1);
        root.left = leftPair.node;
        Pair rightPair = deserialize(nodes, leftPair.pos);
        root.right = rightPair.node;
        return new Pair(root, rightPair.pos);
    }

}
