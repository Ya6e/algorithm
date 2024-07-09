  /**
    454.四数相加 II
  */
  
  package com.waterstay.leetcode.editor.cn;

  import java.util.HashMap;
  import java.util.Map;

  public class FourSumIi{
      public static void main(String[] args) {
           Solution solution = new FourSumIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map1 = new HashMap<>(nums1.length * nums2.length);
        int ans = 0;
        for (int x : nums1) {
            for (int y : nums2) {
                int key = x + y;
                map1.put(key, map1.getOrDefault(key, 0) + 1);
            }
        }
        for (int x : nums3) {
            for (int y : nums4) {
                int key = -x - y;
                ans += map1.getOrDefault(key, 0);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }