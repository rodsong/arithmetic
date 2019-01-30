package lc.demo;

import lc.demo.tree.TreeNode;
import leetcode.pojo.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class LeetCode_120 extends TreeNode {


    public int minimumTotal(List<List<Integer>> triangle) {

        int total_level = triangle.size();
        for (int i = total_level - 2; i >= 0; i--) {
            System.out.println("i:"+i);
            List<Integer> temp_list = triangle.get(i);

            for (int j = 0; j < temp_list.size(); j++) {
                List<Integer> level = triangle.get(i + 1);
                temp_list.set(j, temp_list.get(j) + Math.min(level.get(j), level.get(j + 1)));
            }

        }
        return triangle.get(0).get(0);
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));

        LeetCode_120 leetCode_120 = new LeetCode_120();
        System.out.println( leetCode_120.minimumTotal(triangle));
    }
}
