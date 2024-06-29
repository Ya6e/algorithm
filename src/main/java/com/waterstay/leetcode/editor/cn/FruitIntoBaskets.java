  /**
    904.水果成篮
  */
  
  package com.waterstay.leetcode.editor.cn;
  public class FruitIntoBaskets{
      public static void main(String[] args) {
           Solution solution = new FruitIntoBaskets().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) {
            return 0;
        }
        int basket1 = fruits[0];
        int basket2 = fruits[0];
        int left = 0;
        int result = -1;
        for (int right = 1; right < fruits.length; right++) {
            if (fruits[right] != basket1 && fruits[right] != basket2) {
                result = Math.max(result, right - left);
                basket2 = fruits[right];
                left = right - 1;
                basket1 = fruits[left];
                while (left > 0 && fruits[left - 1] == basket1) {
                    left--;
                }
            }
        }
        return Math.max(result, fruits.length - left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }