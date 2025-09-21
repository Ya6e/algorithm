  /**
    28.找出字符串中第一个匹配项的下标
  */
  
  package com.waterstay.leetcode.editor.cn;
  public class FindTheIndexOfTheFirstOccurrenceInAString{
      public static void main(String[] args) {
           Solution solution = new FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }