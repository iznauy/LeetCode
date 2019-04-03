package data;

/**
 * Created on 15/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class LRUCache {

    private static class Node {
        int key;
        int value;
        Node nextNode; // 这两个都是双向链表中的东西
        Node prevNode;
        Node nextInChain; // 在访问链表的指针
        Node prevInChain;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        Node(int key, int value, Node nextNode, Node prevNode, Node nextInChain, Node prevInChain) {
            this.key = key;
            this.value = value;
            this.nextNode = nextNode;
            this.prevNode = prevNode;
            this.nextInChain = nextInChain;
            this.prevInChain = prevInChain;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private Node head;

    private Node[] array;

    private int capacity;

    private int currentSize;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;

        array = new Node[capacity];
        for (int i = 0; i < capacity; i++)
            array[i] = new Node();

        this.head = new Node(-1, 0);
        this.head.prevNode = this.head;
        this.head.nextNode = this.head;
    }

    public int get(int key) {
        Node resultNode = findNode(key);
        return resultNode == null ? -1 : resultNode.value;
    }

    private Node findNode(int key) {
        int index = key % capacity;
        Node chainHeader = array[index];
        Node result = null;
        while (chainHeader.nextInChain != null) {
            chainHeader = chainHeader.nextInChain;
            if (chainHeader.key == key) {
                // 调整顺序
                result = chainHeader;

                // 从当前位置删除节点
                Node prev = chainHeader.prevNode;
                Node next = chainHeader.nextNode;
                prev.nextNode = chainHeader.nextNode;
                next.prevNode = chainHeader.prevNode;

                // 在head之后新加节点
                Node originalFirstNode = head.nextNode;
                originalFirstNode.prevNode = chainHeader;
                chainHeader.nextNode = originalFirstNode;
                head.nextNode = chainHeader;
                chainHeader.prevNode = head;
            }
        }
        return result;
    }

    private void deleteOldestNode() {
        Node targetNode = head.prevNode;

        // 从大链接中删除
        Node prev = targetNode.prevNode;
        Node next = targetNode.nextNode;
        prev.nextNode = next;
        next.prevNode = prev;

        // 从哈希的链表中删除
        Node nextInChain = targetNode.nextInChain;
        Node prevInChain = targetNode.prevInChain;
        prevInChain.nextInChain = nextInChain;
        if (nextInChain != null)
            nextInChain.prevInChain = prevInChain;
    }

    public void put(int key, int value) {
        Node possibleNode = findNode(key);
        if (possibleNode == null) { // 插入一个新的node
            if (currentSize == capacity) {
                // 已经满了，需要淘汰最长时间没有访问的数据
                deleteOldestNode();
                currentSize--;
            }
            currentSize++;
            Node newNode = new Node(key, value);

            // 插入到大链接中
            Node prev = head;
            Node next = head.nextNode;
            newNode.prevNode = prev;
            prev.nextNode = newNode;
            next.prevNode = newNode;
            newNode.nextNode = next;

            // 插入到哈希的链表中
            int index = key % capacity;
            Node chainHeader = array[index];
            Node previousFirstNode = chainHeader.nextInChain;
            newNode.nextInChain = previousFirstNode;
            newNode.prevInChain = chainHeader;
            chainHeader.nextInChain = newNode;
            if (previousFirstNode != null)
                previousFirstNode.prevInChain = newNode;


        } else { // 插入一个已有node，只需要对数据进行更新即可
            possibleNode.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));






    }

}
