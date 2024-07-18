/**
 * 49.字母异位词分组
 */

package com.waterstay.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        solution.groupAnagrams(new String[]{"a"});
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 哈希表
     */
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] a = str.toCharArray();
                Arrays.sort(a);
                map.computeIfAbsent(new String(a), key -> new ArrayList<>()).add(str);
            }
            Collection<List<String>> values = map.values();
            return new ArrayList<>(map.values());
        }
    }

    /**
     * Stream流
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(s -> s.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString())).values());
    }

// leetcode submit region end(Prohibit modification and deletion)

}