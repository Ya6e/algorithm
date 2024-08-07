/**
 * 242.有效的字母异位词
 */

package com.waterstay.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 如果输入字符串包含 unicode 字符，直接使用HashMap即可
     */
    class Solution {
        public boolean isAnagram5(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] hashTable = new int[128];
            for (int i = 0; i < s.length(); i++) {
                hashTable[s.charAt(i)]++;
            }
            for (int i = 0; i < t.length(); i++) {
                if (--hashTable[t.charAt(i)] < 0) {
                    return false;
                }
            }
            return true;
        }

        public boolean isAnagram1(String s, String t) {
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();
            Arrays.sort(sChars);
            Arrays.sort(tChars);
            return Arrays.equals(sChars, tChars);
        }

        public boolean isAnagram2(String s, String t) {
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : s.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            for (char ch : t.toCharArray()) {
                Integer count = map.get(ch);
                if (count == null) {
                    return false;
                } else if (count > 1) {
                    map.put(ch, count - 1);
                } else {
                    map.remove(ch);
                }
            }
            return map.isEmpty();
        }

        public boolean isAnagram(String s, String t) {
            int[] sCounts = new int[26];
            int[] tCounts = new int[26];
            for (char ch : s.toCharArray()) {
                sCounts[ch - 'a']++;
            }
            for (char ch : t.toCharArray()) {
                tCounts[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (sCounts[i] != tCounts[i]) {
                    return false;
                }
            }
            return true;
        }

        public boolean isAnagram3(String s, String t) {
            int[] counts = new int[26];
            t.chars().forEach(tc -> counts[tc - 'a']++);
            s.chars().forEach(cs -> counts[cs - 'a']--);
            return Arrays.stream(counts).allMatch(c -> c == 0);
        }

        public boolean isAnagram4(String s, String t) {
            return Arrays.equals(s.chars().sorted().toArray(), t.chars().sorted().toArray());
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}