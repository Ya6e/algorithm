/**
 * 2710.移除字符串中的尾随零
 */

package com.waterstay.leetcode.editor.cn;

public class RemoveTrailingZerosFromAString {
    public static void main(String[] args) {
        Solution solution = new RemoveTrailingZerosFromAString().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * replaceAll
         * @param num
         * @return
         */
        public String removeTrailingZeros(String num) {
            return num.replaceAll("0+$", "");
        }

        /**
         * substring
         * @param num
         * @return
         */
        public String removeTrailingZeros2(String num) {
            int len = num.length() - 1;
            while (len > 0 && num.charAt(len) == '0') {
                len--;
            }
            return num.substring(0, len + 1);
        }

        /**
         * toCharArray
         * @param num
         * @return
         */
        public String removeTrailingZeros1(String num) {
            char[] chars = num.toCharArray();
            int count = 0;
            for (int i = chars.length - 1; i > 0; i--) {
                if (chars[i] == '0') {
                    count++;
                } else {
                    break;
                }
            }
            return new String(chars, 0, chars.length - count);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}