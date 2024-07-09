/**
 * 494.目标和
 */

package com.waterstay.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * DP
         */
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            sum -= Math.abs(target);
            if (sum < 0 || (sum & 1) == 1) {
                return 0;
            }
            sum >>>= 1;
            int[] dp = new int[sum + 1];
            dp[0] = 1;
            for (int num : nums) {
                for (int i = sum; i >= num; i--) {
                    dp[i] += dp[i - num];
                }
            }
            return dp[sum];
        }

        /**
         * 翻译成递推
         */
        public int findTargetSumWays3(int[] nums, int target) {
            int s = 0;
            for (int x : nums) {
                s += x;
            }
            s -= Math.abs(target);
            if (s < 0 || s % 2 == 1) {
                return 0;
            }
            int m = s / 2; // 背包容量

            int n = nums.length;
            int[][] f = new int[n + 1][m + 1];
            f[0][0] = 1;
            for (int i = 0; i < n; i++) {
                for (int c = 0; c <= m; c++) {
                    if (c < nums[i]) {
                        f[i + 1][c] = f[i][c];
                    } else {
                        f[i + 1][c] = f[i][c] + f[i][c - nums[i]];
                    }
                }
            }
            return f[n][m];
        }


        /**
         * 递归搜索 + 保存计算结果 = 记忆化搜索
         * 选取合适的背包容量
         */
        int[] nums;
        int[][] m;
        public int findTargetSumWays2(int[] nums, int target) {
            int s = 0;
            for (int x : nums) {
                s += x;
            }
            s -= Math.abs(target);
            if (s < 0 || (s & 1) == 1) {
                return 0;
            }
            int n = s >>> 1; // 背包容量
            m = new int[nums.length][n + 1];
            this.nums = nums;
            for (int[] row : m) {
                Arrays.fill(row, -1); // -1 表示没有计算过
            }
            return dfs(nums.length - 1, n);
        }

        private int dfs(int i, int n) {
            if (i < 0) {
                return n == 0 ? 1 : 0;
            }
            if (m[i][n] != -1) { // 之前计算过
                return m[i][n];
            }
            if (n < nums[i]) {
                return dfs(i - 1, n); // 只能不选
            }
            return m[i][n] = dfs(i - 1, n) + dfs(i - 1, n - nums[i]); // 不选 + 选
        }

        /**
         * DFS记忆化搜索
         */
        public HashMap<String, Integer> memo = new HashMap<>();
        public int findTargetSumWays1(int[] nums, int target) {
            return findTargetSumWays(nums, target, nums.length - 1);
        }

        public int findTargetSumWays(int[] nums, int target, int index) {
            if (index == 0) {
                if (Math.abs(target) == nums[index]) {
                    return target == 0 ? 2 : 1;
                }
                return 0;
            }
            String key = target + "," + index;
            if (!memo.containsKey(key)) {
                int ways = findTargetSumWays(nums, target - nums[index], index - 1) +
                        findTargetSumWays(nums, target + nums[index], index - 1);
                memo.put(key, ways);
            }
            return memo.get(key);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}