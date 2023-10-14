package algorithm.leetcode.slidewindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Q_3
 * @Package: algorithm.leetcode.slidewindow
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/22 11:47
 * @Version: 1.0
 */
public class Q_3 {

    /**
     * @Title: 双指针滑动窗口，右指针先动，然后左指针追赶
     * @Description:
     */
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int res = 0;
            Set<Character> set = new HashSet();
//            for (int i = 0; i < s.length(); i++) {
//                set.clear();
//                set.add(s.charAt(i));
//                for (int j = i + 1; j < s.length(); j++) {
//                   if(!set.contains(s.charAt(j))){
//                       set.add(s.charAt(j));
//                   }else{
//                       break;
//                   }
//                }
//                res = Math.max(res, set.size());
//            }

            int left = 0, right = 0;
            while(right < s.length()){
                if(!set.contains(s.charAt(right))){
                    set.add(s.charAt(right));
                    right++;
                }else{
                    set.remove(s.charAt(left));
                    left++;
                }
                res = Math.max(res, right - left);
            }
            return res;
        }

    }

    public static void main(String[] args) {
        String s = "dvdf";
        Solution solution = new Solution();

        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
