/**
 * 383.赎金信
 */

package com.waterstay.leetcode.editor.cn;

import java.util.Arrays;

public class RansomNote {
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 排序双指针二分查找
         */
        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote == null || ransomNote.isEmpty()) {
                return true;
            }
            if (magazine == null || magazine.length() < ransomNote.length()) {
                return false;
            }
            char[] rch = ransomNote.toCharArray();
            char[] mch = magazine.toCharArray();
            Arrays.sort(rch);
            Arrays.sort(mch);
            int j = 0;
            char last = 'A';
            for (int i = 0; i < rch.length; i++) {
                if (rch[i] == last) {
                    if (++j == mch.length || mch[j] != rch[i]) {
                        return false;
                    }
                } else {
                    j = binarySearch(mch, j, mch.length - 1, rch[i]);
                    if (j >= mch.length || mch[j] != rch[i]) {
                        return false;
                    }
                }
                last = rch[i];
            }
            return true;
        }

        public int binarySearch(char[] a, int lo, int hi, char key) {
            while (lo <= hi) {
                int mi = (lo + hi) >>> 1;
                if (a[mi] < key) {
                    lo = mi + 1;
                } else {
                    hi = mi - 1;
                }
            }
            return lo;
        }

        /**
         * 哈希表
         */
        public boolean canConstruct1(String ransomNote, String magazine) {
            int[] h = new int[26];
            for (char c : magazine.toCharArray()) {
                h[c - 'a']++;
            }
            for (char c : ransomNote.toCharArray()) {
                if (--h[c - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}