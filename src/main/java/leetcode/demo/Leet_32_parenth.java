package leetcode.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Leet_32_parenth</p>
 * Copyright @ 2019 Shanghai hailang Co. Ltd.
 * All right reserved.
 *
 * @author songyanfei
 * @date 2019年02月14日
 */
public class Leet_32_parenth {

    public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }

        Map<String, String> map = new HashMap<>();
        map.put(")", "(");

        ArrayList list = new ArrayList();
        int p = 0;
        int result = 0;
        while (p < s.length()) {
            String c = String.valueOf(s.charAt(p));
            if (map.keySet().contains(String.valueOf(c))) {
                if (!list.isEmpty()
                        && list.get(list.size() - 1).equals(map.get(String.valueOf(c)))) {
                    list.remove(list.size() - 1);
                } else {
                    list.add(c);
                }
            } else {
                list.add(c);
            }
            result = Math.max(result, (p +1) - list.size());
            p++;
        }

        return result;
    }

    public static void main(String[] args) {
        String x = "()(()";
        Leet_32_parenth test = new Leet_32_parenth();
        int rel = test.longestValidParentheses(x);

        System.out.println(rel);
    }
}
