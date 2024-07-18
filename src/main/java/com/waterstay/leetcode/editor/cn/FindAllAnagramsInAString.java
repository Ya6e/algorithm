/**
 * 438.找到字符串中所有字母异位词
 */

package com.waterstay.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 滑动窗口
         */
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            int[] h = new int[26];
            for (char c : p.toCharArray()) {
                h[c - 'a']++;
            }
            char[] ch = s.toCharArray();
            int left = 0, right = 0, pLen = p.length(), sLen = s.length();
            while (right < sLen) {
                int i = ch[right++] - 'a';
                if (--h[i] < 0) {
                    while (h[i] < 0) {
                        h[ch[left++] - 'a']++;
                    }
                }
                if (right - left == pLen) {
                    ans.add(left);
                }
            }
            return ans;
        }

        /**
         * 暴力解法
         */
        public List<Integer> findAnagrams1(String s, String p) {
            char[] pch = p.toCharArray();
            Arrays.sort(pch);
            int pLen = p.length();
            int sLen = s.length();
            int n = sLen - pLen + 1;
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] sch = s.substring(i, i + pLen).toCharArray();
                Arrays.sort(sch);
                if (Arrays.equals(pch, sch)) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}