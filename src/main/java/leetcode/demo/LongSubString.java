package leetcode.demo;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>LongSubString</p>
 * Copyright @ 2019 Shanghai hailang Co. Ltd.
 * All right reserved.
 *
 * @author songyanfei
 * @date 2019年02月13日
 */
public class LongSubString {
    public int longSubString(String s) {

        if (s == null || s.length() <= 1) {
            return s == null ? 0 : s.length();
        }

        Set<Character> set = new HashSet<>();
        int result = 0, left = 0, right = 0;
        while ( right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            } else { // 左边指针先后直到重复元素的位置
                set.remove(s.charAt(left));
                left++;
            }
            result = Math.max(result, right - left);
        }
        return result;
    }

    public static void main(String[] args) {
        LongSubString test = new LongSubString();
        String s = "abcdefg";
        System.out.println(test.longSubString(s));
    }
}
