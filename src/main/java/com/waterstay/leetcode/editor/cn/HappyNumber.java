/**
 * 202.快乐数
 */

package com.waterstay.leetcode.editor.cn;

public class HappyNumber {
    public static void main(String[] args) {
        Solution solution = new HappyNumber().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 快慢指针
         */
        public boolean isHappy(int n) {
            int fast = n, slow = n;
            while (true) {
                fast = nextNum(nextNum(fast));
                slow = nextNum(slow);
                if (fast == slow) {
                    break;
                }
            }
            return fast == 1;
        }

        public int nextNum(int n) {
            int sum = 0;
            while (n > 0) {
                int x = n % 10;
                sum += x * x;
                n /= 10;
            }
            return sum;
        }

        /**
         * 哈希表
         */
        public int[] hashTable = new int[800];
        public boolean isHappy1(int n) {
            while (true) {
                int sum = 0;
                while (n != 0) {
                    int x = n % 10;
                    sum += x * x;
                    n /= 10;
                }
                if (sum == 1) {
                    return true;
                }
                if (hashTable[sum] == 1) {
                    return false;
                }
                hashTable[sum] = 1;
                n = sum;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}