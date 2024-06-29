/**
 * 24.两两交换链表中的节点
 */

package com.waterstay.leetcode.editor.cn;

import com.waterstay.leetcode.editor.cn.datastruct.ListNode;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
    }
    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        /**
         * 递归
         * @param head
         * @return
         */
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = head.next;
            head.next = swapPairs(newHead.next);
            newHead.next = head;
            return newHead;

        }

        /**
         * 迭代2
         * @param head
         * @return
         */
        public ListNode swapPairs2(ListNode head) {
            ListNode dummyNode = new ListNode(0, head);
            ListNode pre = dummyNode, cur = head;
            while (cur != null && cur.next != null) {
                pre.next = cur.next;
                cur.next = cur.next.next;
                pre.next.next = cur;
                pre = cur;
                cur = cur.next;
            }
            return dummyNode.next;
        }

        /**
         * 迭代1
         * @param head
         * @return
         */
        public ListNode swapPairs1(ListNode head) {
            ListNode dummyNode = new ListNode();
            ListNode pre = dummyNode, cur = head;
            while (cur != null) {
                if (cur.next == null) {
                    pre.next = cur;
                    pre = cur;
                    cur = cur.next;
                } else {
                    pre.next = cur.next;
                    ListNode temp = cur.next.next;
                    cur.next.next = cur;
                    cur.next = null;
                    pre = cur;
                    cur = temp;
                }
            }
            return dummyNode.next;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}