package others;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 25/04/2019.
 * Description:
 *
 * @author iznauy
 */
public class P10 {

    private static class Node {
        boolean end = false;
        Edge repeat;
        Edge next = null;
    }

    private static class Edge {
        char c = 0;
        Node node;
        Edge(char c, Node node) { this.c = c; this.node = node; }
    }

    public boolean isMatch(String s, String p) {
        if (p.length() == 0)
            return s.length() == 0;
        Node root = new Node();
        Node end;

        // 构造 NFS
        Node curr = root;
        char[] patArray = p.toCharArray();
        for (int i = 0; i < patArray.length; i++) {
            if (i + 1 < patArray.length && patArray[i + 1] == '*') { // 鬼畜重复
                Node repeatNode = new Node();
                Node nextNode = new Node();
                curr.next = new Edge((char)0, repeatNode);
                repeatNode.next = new Edge((char)0, nextNode);
                repeatNode.repeat = new Edge(patArray[i], repeatNode);
                curr = nextNode;
                i++;
            } else {
                Node nextNode = new Node();
                curr.next = new Edge(patArray[i], nextNode);
                curr = nextNode;
            }
        }
        curr.end = true;
        end = curr;

        // 使用目标串遍历
        Set<Node> nodes = new HashSet<>();
        nodes.add(root);
        closure(nodes);
        for (char c: s.toCharArray()) {
            nodes = go(nodes, c);
            closure(nodes);
        }
        return nodes.contains(end);
    }

    private Set<Node> go(Set<Node> roots, char c) {
        Set<Node> results = new HashSet<>();
        for (Node node: roots) {
            if (node.repeat != null && (node.repeat.c == c || node.repeat.c == '.'))
                results.add(node);
            else if (node.next != null && (node.next.c == c || node.next.c == '.'))
                results.add(node.next.node);
        }
        return results;
    }

    private void closure(Set<Node> roots) {
        if (roots.isEmpty())
            return;
        Set<Node> newRoots = new HashSet<>();
        for (Node node: roots) {
            while (node.next != null && node.next.c == 0) {
                node = node.next.node;
                newRoots.add(node);
            }
        }
        roots.addAll(newRoots);
    }

}
