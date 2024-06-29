/**
 * 203.移除链表元素
 */

package com.waterstay.leetcode.editor.cn;

import com.waterstay.leetcode.editor.cn.datastruct.ListNode;


public class RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        /**
         * 递归
         * @param head
         * @param val
         * @return
         */
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return head;
            }
            head.next = removeElements(head.next, val);
            return head.val == val ? head.next : head;
        }

        /**
         * 哨兵头节点
         * @param head
         * @param val
         * @return
         */
        public ListNode removeElements2(ListNode head, int val) {
            ListNode dummyNode = new ListNode(-1, head);
            ListNode cur = dummyNode;
            while (cur.next != null) {
                if (cur.next.val == val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            return dummyNode.next;
        }

        /**
         * 额外头处理
         * @param head
         * @param val
         * @return
         */
        public ListNode removeElements3(ListNode head, int val) {
            while (head != null && head.val == val) {
                head = head.next;
            }
            if (head == null) {
                return head;
            }
            ListNode cur = head;
            while (cur.next != null) {
                if (cur.next.val == val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            return head;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}