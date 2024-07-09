/**
 * 1.两数之和
 */

package com.waterstay.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    return new int[]{map.get(nums[i]), i};
                }
                map.put(target - nums[i], i);
            }
            return null;
        }

        /**
         * 暴力解法
         */
        public int[] twoSum1(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[0];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}