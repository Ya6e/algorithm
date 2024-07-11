/**
 * 15.三数之和
 */

package com.waterstay.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 双指针
         */
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            // 双指针需要数组有序
            Arrays.sort(nums);
            int n = nums.length;
            // 第一个元素
            for (int i = 0; i < n - 2; ++i) {
                int a = nums[i];
                if (i > 0 && a == nums[i - 1])
                    continue; // 第一个元素去重
                if (a + nums[i + 1] + nums[i + 2] > 0)
                    break;
                if (a + nums[n - 2] + nums[n - 1] < 0)
                    continue;
                int left = i + 1, right = n - 1;
                while (left < right) {
                    int sum = a + nums[left] + nums[right];
                    if (sum > 0) {
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        ans.add(List.of(a, nums[left], nums[right]));
                        while (left < right && nums[left] == nums[++left]) ;
                        while (left < right && nums[right] == nums[--right]) ;
                    }
                }
            }
            return ans;
        }

        /**
         * 哈希表去重
         */
        public List<List<Integer>> threeSum1(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                // 如果第一个元素大于零，不可能凑成三元组
                if (nums[i] > 0) {
                    return result;
                }
                // 三元组元素a去重
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                HashSet<Integer> set = new HashSet<>();
                for (int j = i + 1; j < nums.length; j++) {
                    // 三元组元素b去重
                    if (j > i + 2 && nums[j] == nums[j - 1] && nums[j - 1] == nums[j - 2]) {
                        continue;
                    }
                    int c = -nums[i] - nums[j];
                    if (set.contains(c)) {
                        result.add(Arrays.asList(nums[i], nums[j], c));
                        set.remove(c); // 三元组元素c去重
                    } else {
                        set.add(nums[j]);
                    }
                }
            }
            return result;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}