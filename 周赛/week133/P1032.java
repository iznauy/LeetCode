package week133;

import java.util.*;

/**
 * Created on 25/04/2019.
 * Description: 构造字典树
 *
 * @author iznauy
 */
public class P1032 {


    private static class TrieNode {
        boolean end;
        char value = '\0';
        TrieNode[] children = new TrieNode[26];
        TrieNode(boolean end) {
            this.end = end;
        }
        TrieNode(boolean end, char value) {
            this.end = end;
            this.value = value;
        }
    }

    private TrieNode root;

    private String s;

    public P1032(String[] words) {
        this.root = new TrieNode(false);
        for (String word: words) {
            word = new StringBuilder(word).reverse().toString();
            TrieNode currNode = this.root;
            for (char c: word.toCharArray()) {
                int value = c - 'a';
                if (currNode.children[value] == null)
                    currNode.children[value] = new TrieNode(false, c);
                currNode = currNode.children[value];
            }
            currNode.end = true;
        }
    }

    public boolean query(char letter) {
        s += letter;
        char[] str = s.toCharArray();
        TrieNode curr = this.root;
        for (int i = str.length - 1; i >= 0; i--) {
            int value = str[i] - 'a';
            if (curr.children[value] == null)
                return false;
            curr = curr.children[value];
            if (curr.end)
                return true;
        }
        return false;
    }

}
