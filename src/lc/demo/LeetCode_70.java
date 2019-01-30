package lc.demo;

import lc.demo.tree.TreeNode;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 */
public class LeetCode_70 extends TreeNode {


    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }

        int[] cache = new int[n];
        cache[0] = 1;
        cache[1] = 2;
        for (int i = 2; i < n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n - 1];
    }

    public long climbStairs_3(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        Long[] cache = new Long[3];
        cache[0] = 1L;
        cache[1] = 2L;

        for (int i = 2; i < n; i++) {
            cache[2] = cache[1] + cache[0];

            cache[0]=cache[1];
            cache[1]=cache[2];
        }
        return cache[1];
    }

    public int climbStairs_2(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }

        int one_step_before = 2;
        int two_step_before = 1;
        int result = 0;
        for (int i = 2; i < n; i++) {
            result = one_step_before + two_step_before;
            two_step_before = one_step_before;
            one_step_before = result;
        }
        return result;
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        int target = 10;
        LeetCode_70 test = new LeetCode_70();
        int rel2 = test.climbStairs_2(target);
        System.out.println(rel2);
        Long rel = test.climbStairs_3(target);
        System.out.println(rel);
    }
}
