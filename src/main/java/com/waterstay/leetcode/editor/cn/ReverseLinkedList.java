/**
 * 206.反转链表
 */

package com.waterstay.leetcode.editor.cn;

import com.waterstay.leetcode.editor.cn.datastruct.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
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
         * 带有pre节点的递归
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            return reverseList(null, head);
        }

        public ListNode reverseList(ListNode pre, ListNode cur) {
            if (cur == null) {
                return pre;
            }
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            return reverseList(pre, temp);
        }
        /**
         * 递归
         * @param head
         * @return
         */
        public ListNode reverseListWithRecursion(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = reverseListWithRecursion(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }

        /**
         * dummy前插迭代
         * @param head
         * @return
         */
        public ListNode reverseListWithDummy(ListNode head) {
            ListNode dummy = new ListNode();
            while (head != null) {
                ListNode temp = head.next;
                head.next = dummy.next;
                dummy.next = head;
                head = temp;
            }
            return dummy.next;
        }

        /**
         * 前插迭代，将原本head当作哨兵节点
         * @param head
         * @return
         */
        public ListNode reverseListWithInsert(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode newHead = head, cur;
            while (head.next != null) {
                cur = head.next;
                head.next = cur.next;
                cur.next = newHead;
                newHead = cur;
            }
            return newHead;
        }

        /**
         * 双指针
         * @param head
         * @return
         */
        public ListNode reverseListWithDoublePointer(ListNode head) {
            ListNode pre = null, cur = head;
            while (cur != null) {
                ListNode t = cur.next;
                cur.next = pre;
                pre = cur;
                cur = t;
            }
            return pre;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}