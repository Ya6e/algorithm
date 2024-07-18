/**
 * 76.最小覆盖子串
 */

package com.waterstay.leetcode.editor.cn;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 滑动窗口
         */
        public String minWindow(String s, String t) {
            // 使用数组代替哈希表记录子串t中各字符的出现次数（待覆盖的个数）
            int[] cnt = new int[128];
            for (int i = 0; i < t.length(); i++) {
                cnt[t.charAt(i)]++;
            }
            // cntT记录字串t中未被覆盖的字符的个数
            int l = 0, r = 0, ansL = 0, ansR = 0, ans = Integer.MAX_VALUE, cntT = t.length();
            // 滑动窗口，l、r为窗口的左右端
            while (r < s.length()) {
                // 当t中出现的字符还未被覆盖时，判断后r已+1，因此可以将r的右边界视作开区间，ansL，ansR为[)，刚好作为substring的参数
                if (cnt[s.charAt(r++)]-- > 0) {
                    // 则在cnt中其值大于0，此时则t中未被覆盖的字符的个数-1
                    cntT--;
                }
                // t中所有字符都被覆盖
                while (cntT == 0) {
                    // 更新最短字符串的左右端
                    if (r - l < ans) {
                        ansL = l;
                        ansR = r;
                        ans = ansR - ansL;
                    }
                    // 移动窗口左端，缩小字符串长度
                    if (cnt[s.charAt(l++)]++ == 0) {
                        // 如果该字符待覆盖个数刚好为0（窗口中对该字符持有的个数刚好为t中该字符个数）
                        // t中不包含的字符在cnt中初始值则0，进入窗口后则小于0
                        // 则t中未被覆盖的字符的个数+1，从覆盖到未覆盖状态也可直接置为1
                        cntT++;
                    }
                }
            }
            return ans == Integer.MAX_VALUE ? "" : s.substring(ansL, ansR);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}