  /**
    160.相交链表
  */
  
  package com.waterstay.leetcode.editor.cn;

  import com.waterstay.leetcode.editor.cn.datastruct.ListNode;

  import java.util.HashSet;

  public class IntersectionOfTwoLinkedLists{
      public static void main(String[] args) {
           Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * 哈希表
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 计数齐平
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        int la = 0, lb = 0;
        while (a != null) {
            la++;
            a = a.next;
        }
        while (b != null) {
            lb++;
            b = b.next;
        }
        a = headA;
        b = headB;
        if (la < lb) {
            a = headB;
            b = headA;
        }
        int dif = Math.abs(la - lb);
        for (int i = 0; i < dif; i++) {
            a = a.next;
        }
        while (a != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }

    /**
     * 双指针
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }