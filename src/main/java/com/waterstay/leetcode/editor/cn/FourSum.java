/**
 * 18.四数之和
 */

package com.waterstay.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        List<List<Integer>> lists = solution.fourSum(new int[]{0, 0, 0, -1000000000, -1000000000, -1000000000, -1000000000}, -1000000000);
        System.out.println(lists);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            int n = nums.length;
            for (int a = 0; a < n - 3; a++) { // 枚举第一个数
                long x = nums[a]; // 使用 long 避免溢出
                if (a > 0 && x == nums[a - 1]) continue; // 跳过重复数字
                if (x + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) break; // 优化一
                if (x + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) continue; // 优化二
                for (int b = a + 1; b < n - 2; b++) { // 枚举第二个数
                    long y = nums[b];
                    if (b > a + 1 && y == nums[b - 1]) continue; // 跳过重复数字
                    if (x + y + nums[b + 1] + nums[b + 2] > target) break; // 优化一
                    if (x + y + nums[n - 2] + nums[n - 1] < target) continue; // 优化二
                    int left = b + 1, right = n - 1;
                    while (left < right) { // 双指针枚举第三个数和第四个数
                        long s = x + y + nums[left] + nums[right]; // 四数之和
                        if (s > target) right--;
                        else if (s < target) left++;
                        else { // s == target
                            ans.add(List.of((int) x, (int) y, nums[left], nums[right]));
                            while (left < right && nums[left] == nums[++left]);
                            while (left < right && nums[right] == nums[--right]);
                        }
                    }
                }
            }
            return ans;
        }

    }
// leetcode submit region end(Prohibit modification and deletion)

}