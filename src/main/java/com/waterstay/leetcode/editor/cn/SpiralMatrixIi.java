/**
 * 59.螺旋矩阵 II
 */

package com.waterstay.leetcode.editor.cn;

public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int count = 1;
            int[][] matrix = new int[n][n];
            int left = 0, right = n - 1, up = 0, down = n - 1;
            while (true) {
                for (int i = left; i <= right; i++)
                    matrix[up][i] = count++;
                if (++up > down)
                    break;
                for (int i = up; i <= down; i++)
                    matrix[i][right] = count++;
                if (--right < left)
                    break;
                for (int i = right; i >= left; i--)
                    matrix[down][i] = count++;
                if (--down < up)
                    break;
                for (int i = down; i >= up; i--)
                    matrix[i][left] = count++;
                if (++left > right)
                    break;
            }
            return matrix;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}