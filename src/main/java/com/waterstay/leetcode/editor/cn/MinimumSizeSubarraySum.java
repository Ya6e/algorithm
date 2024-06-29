  /**
    209.长度最小的子数组
  */
  
  package com.waterstay.leetcode.editor.cn;
  public class MinimumSizeSubarraySum{
      public static void main(String[] args) {
          Solution solution = new MinimumSizeSubarraySum().new Solution();
          int result = solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
          System.out.println("result = " + result);
      }

      // leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public int minSubArrayLen(int target, int[] nums) {
              int result = Integer.MAX_VALUE;
              for (int i = 1; i < nums.length; i++) {
                  nums[i] += nums[i - 1];
              }
              for (int i = nums.length - 1; i >= 0; i--) {
                  if (nums[i] < target) {
                      break;
                  }
                  int dif = nums[i] - target;
                  int lo = 0;
                  int hi = i - 1;
                  while (lo <= hi) {
                      int mi = lo + ((hi - lo) >> 1);
                      if (nums[mi] > dif) {
                          hi = mi - 1;
                      } else {
                          lo = mi + 1;
                      }
                  }
                  result = Math.min(result, i - hi);
              }
              return result == Integer.MAX_VALUE ? 0 : result;
          }

          public int minSubArrayLen2(int target, int[] nums) {
              int left = 0;
              int sum = 0;
              int result = Integer.MAX_VALUE;
              for (int right = 0; right < nums.length; right++) {
                  sum += nums[right];
                  while (sum >= target) {
                      result = Math.min(result, right - left + 1);
                      sum -= nums[left++];
                  }
              }
              return result == Integer.MAX_VALUE ? 0 : result;
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }