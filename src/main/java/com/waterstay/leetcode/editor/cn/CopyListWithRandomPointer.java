/**
 * 138.随机链表的复制
 */

package com.waterstay.leetcode.editor.cn;

import java.util.HashMap;

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Solution solution = new CopyListWithRandomPointer().new Solution();
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    // leetcode submit region begin(Prohibit modification and deletion)


    class Solution {

        /**
         * 拼接 + 拆分
         */
        public Node copyRandomList1(Node head) {
            if (head == null) {
                return null;
            }
            Node cur = head;
            while (cur != null) {
                Node node = new Node(cur.val);
                node.next = cur.next;
                cur.next = node;
                cur = node.next;
            }
            cur = head;
            while (cur != null) {
                if (cur.random != null) {
                    cur.next.random = cur.random.next;
                }
                cur = cur.next.next;
            }
            Node dummy = new Node(0);
            Node p = dummy;
            cur = head;
            while (cur != null) {
                p.next = cur.next;
                p = p.next;
                cur.next = p.next;
                cur = cur.next;
            }
            return dummy.next;
        }

        /**
         * 递归 + 哈希表
         */
        public HashMap<Node, Node> memo = new HashMap<>();

        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Node newNode = new Node(head.val);
            memo.put(head, newNode);
            newNode.next = copyRandomList(head.next);
            if (head.random != null) {
                newNode.random = memo.get(head.random);
            }
            return newNode;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}