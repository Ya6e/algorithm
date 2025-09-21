/**
 * 541.反转字符串 II
 */

package com.waterstay.leetcode.editor.cn;

public class ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 双指针
         */
        public String reverseStr(String s, int k) {
            char[] a = s.toCharArray();
            int n = a.length;
            for (int i = 0; i < n; i += 2 * k) {
                int l = i;
                int r = Math.min(l + k - 1, n - 1);
                while (l < r) {
                    char temp = a[l];
                    a[l++] = a[r];
                    a[r--] = temp;
                }
            }
            return new String(a);
        }

        /**
         * StringBuffer reverse
         */
        public String reverseStr2(String s, int k) {
            StringBuilder res = new StringBuilder();
            int length = s.length();
            int start = 0;
            while (start < length) {
                // 找到k处和2k处
                StringBuilder temp = new StringBuilder();
                // 与length进行判断，如果大于length了，那就将其置为length
                int firstK = Math.min(start + k, length);
                int secondK = Math.min(start + (2 * k), length);

                //无论start所处位置，至少会反转一次
                temp.append(s, start, firstK);
                res.append(temp.reverse());

                // 如果firstK到secondK之间有元素，这些元素直接放入res里即可。
                if (firstK < secondK) { //此时剩余长度一定大于k。
                    res.append(s, firstK, secondK);
                }
                start += (2 * k);
            }
            return res.toString();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}