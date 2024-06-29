/**
 * 707.设计链表
 */

package com.waterstay.leetcode.editor.cn;

public class DesignLinkedList {
    public static void main(String[] args) {

    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 单链表
     */
    class MyLinkedList {
        int size;
        ListNode head, tail;

        private class ListNode {
            int val;
            ListNode next;

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }

            ListNode() {
            }
        }

        public MyLinkedList() {
            size = 0;
            head = new ListNode();
            tail = head;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode cur = head;
            while (index-- >= 0) {
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            ListNode node = new ListNode(val, head.next);
            head.next = node;
            size++;
            if (node.next == null) {
                tail = node;
            }
        }

        public void addAtTail(int val) {
            ListNode node = new ListNode(val, null);
            tail.next = node;
            size++;
            tail = node;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }
            ListNode cur = head;
            while (index-- > 0) {
                cur = cur.next;
            }
            ListNode node = new ListNode(val, cur.next);
            cur.next = node;
            size++;
            if (node.next == null) {
                tail = node;
            }
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            ListNode pre = head;
            while (index-- > 0) {
                pre = pre.next;
            }
            pre.next = pre.next.next;
            size--;
            if (pre.next == null) {
                tail = pre;
            }
        }
    }

    /**
     * 双链表
     */
    class MyLinkedList2 {
        int size;
        ListNode head, tail;

        private class ListNode {
            int val;
            ListNode pre, next;

            ListNode(int val, ListNode pre, ListNode next) {
                this.val = val;
                this.pre = pre;
                this.next = next;
            }

            ListNode() {
            }
        }

        public MyLinkedList2() {
            size = 0;
            head = new ListNode();
            tail = new ListNode();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode cur = getListNode(index);
            return cur.val;
        }

        private ListNode getListNode(int index) {
            ListNode cur;
            if (index > (size >> 1)) {
                cur = tail;
                for (int i = size; i > index; i--) {
                    cur = cur.pre;
                }
            } else {
                cur = head;
                for (int i = 0; i <= index; i++) {
                    cur = cur.next;
                }
            }
            return cur;
        }

        public void addAtHead(int val) {
            ListNode node = new ListNode(val, head, head.next);
            head.next.pre = node;
            head.next = node;
            size++;
        }

        public void addAtTail(int val) {
            ListNode node = new ListNode(val, tail.pre, tail);
            tail.pre.next = node;
            tail.pre = node;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }
            ListNode cur = getListNode(index - 1);
            ListNode node = new ListNode(val, cur, cur.next);
            cur.next.pre = node;
            cur.next = node;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            ListNode cur = getListNode(index);
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
            size--;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// leetcode submit region end(Prohibit modification and deletion)

}