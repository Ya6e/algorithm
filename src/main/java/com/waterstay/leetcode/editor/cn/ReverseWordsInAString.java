/**
 * 151.反转字符串中的单词
 */

package com.waterstay.leetcode.editor.cn;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAString().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            StringBuilder ans = new StringBuilder();
            char[] a = s.toCharArray();
            for (int i = a.length - 1; i >= 0; i--) {
                if (a[i] != ' ') {
                    int end = i;
                    while (i > 0 && a[i - 1] != ' ') --i;
                    ans.append(a, i, end - i + 1).append(' ');
                }
            }
            ans.deleteCharAt(ans.length() - 1);
            return ans.toString();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}