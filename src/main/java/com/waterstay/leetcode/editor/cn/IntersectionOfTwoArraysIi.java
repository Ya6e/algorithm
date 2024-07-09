/**
 * 350.两个数组的交集 II
 */

package com.waterstay.leetcode.editor.cn;

import java.util.Arrays;

public class IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArraysIi().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 哈希表
         */
        public int[] intersect(int[] nums1, int[] nums2) {
            int[] hashTable = new int[1001];
            int[] result = new int[1000];
            int len = 0;
            for (int i = 0; i < nums1.length; i++) {
                hashTable[nums1[i]]++;
            }
            for (int i = 0; i < nums2.length; i++) {
                if (hashTable[nums2[i]]-- > 0) {
                    result[len++] = nums2[i];
                }
            }
            return Arrays.copyOf(result, len);
        }

        /**
         * 双指针二分查找
         */
        public int[] intersect1(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int[] result = new int[1000];
            int len = 0;
            int i = 0, j = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    i = binarySearch(nums1, i, nums1.length, nums2[j]);
                } else if (nums1[i] > nums2[j]) {
                    j = binarySearch(nums2, j, nums2.length, nums1[i]);
                } else {
                    result[len++] = nums1[i];
                    i++;
                    j++;
                }
            }
            return Arrays.copyOf(result, len);
        }

        public static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
            int lo = fromIndex;
            int hi = toIndex - 1;
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
    }
// leetcode submit region end(Prohibit modification and deletion)

}