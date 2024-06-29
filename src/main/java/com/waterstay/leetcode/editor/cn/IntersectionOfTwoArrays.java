/**
 * 349.两个数组的交集
 */

package com.waterstay.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        int[] intersection = solution.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        System.out.println("Arrays.toString(intersection) = " + Arrays.toString(intersection));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 排序、双指针、二分查找
         * @param nums1
         * @param nums2
         * @return
         */
        public int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int[] result = new int[1000];
            int len = 0;
            int i = 0, j = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    i = binarySearch(nums1, i, nums1.length, nums2[j]);
                    if (nums1[i - 1] == nums2[j]) {
                        result[len++] = nums2[j];
                    }
                } else if (nums1[i] > nums2[j]) {
                    j = binarySearch(nums2, j, nums2.length,nums1[i]);
                    if (nums2[j - 1] == nums1[i]) {
                        result[len++] = nums1[i];
                    }
                } else {
                    result[len++] = nums1[i];
                    i = binarySearch(nums1, i, nums1.length, nums1[i]);
                }
            }
            return Arrays.copyOf(result, len);
        }

        private static int binarySearch(int[] a, int fromIndex, int toIndex,
                                         int key) {
            int low = fromIndex;
            int high = toIndex - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = a[mid];

                if (midVal > key)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            return low;
        }

        /**
         * HashTable optimized
         * @param nums1
         * @param nums2
         * @return
         */
        public int[] intersection1(int[] nums1, int[] nums2) {
            int[] hashTable = new int[1001];
            int[] result = new int[1000];
            int len = 0;
            for (int i = 0; i < nums1.length; i++) {
                hashTable[nums1[i]]++;
            }
            for (int i = 0; i < nums2.length; i++) {
                if (hashTable[nums2[i]] > 0) {
                    hashTable[nums2[i]] = 0;
                    result[len++] = nums2[i];
                }
            }
            return Arrays.copyOf(result, len);
        }

        /**
         * HashTable
         * @param nums1
         * @param nums2
         * @return
         */
        public int[] intersection2(int[] nums1, int[] nums2) {
            int[] hashTable = new int[1001];
            ArrayList<Integer> dupList = new ArrayList<>(1000);
            for (int i = 0; i < nums1.length; i++) {
                hashTable[nums1[i]]++;
            }
            for (int i = 0; i < nums2.length; i++) {
                if (hashTable[nums2[i]] > 0) {
                    hashTable[nums2[i]] = 0;
                    dupList.add(nums2[i]);
                }
            }
            return dupList.stream().mapToInt(Integer::intValue).toArray();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}