package leetcode.demo;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * <p>LongSubString</p>
 * Copyright @ 2019 Shanghai hailang Co. Ltd.
 * All right reserved.
 *
 * @author songyanfei
 * @date 2019年02月13日
 */
public class LongSubString2 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) {
            return s.length();
        }

        int result = 0;
        int l = 0;
        int r = 0;
        Set<Character> set = new HashSet<>();
        while (r < s.length()) {
            char c = s.charAt(r);
            if (set.contains(c)) {
                if (set.size() > result) {
                    result = set.size();
                }

                set.remove(s.charAt(l++));
            } else {
                set.add(c);
                r++;
            }
        }

        return result > set.size() ? result : set.size();
    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();

        queue.offer(5);
        queue.offer(1);
        queue.offer(8);
        queue.offer(20);
        queue.offer(0);

        System.out.println(queue.poll());
    }
}
