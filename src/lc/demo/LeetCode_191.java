package lc.demo;

import lc.demo.tree.TreeNode;

/**
 * 数字有多少个1
 */
public class LeetCode_191 extends TreeNode {

    /**
     * 数字有多少个1
     *
     * @param target
     * @return
     */

    public int count1(int target) {

        int count = 0;
        if (target == 0) {
            return count;
        }
        while (target != 0) {
            count++;
            target = target & (target - 1);
        }
        return count;
    }


    public int method_2(int target) {

        int count = 0;
        if (target == 0) {
            return count;
        }

        String x=  Integer.toBinaryString(target);
        System.out.println(x);

        return 0;
    }


    /**
     * 测试
     */
    public static void main(String[] args) {
        int target =-8;
        LeetCode_191 test = new LeetCode_191();
        int rel = test.count1(target);
        System.out.println(rel);

        test.method_2(target);
    }
}
