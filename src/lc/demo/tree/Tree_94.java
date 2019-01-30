package lc.demo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Tree_94</p>
 * Copyright @ 2019 Shanghai hailang Co. Ltd.
 * All right reserved.
 *
 * @author songyanfei
 * @date 2019年01月22日
 */
public class Tree_94 {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> x = middle(root);
        x.forEach((temp) -> System.out.print(temp + "; "));
        return x;
    }

    ArrayList<Integer> rel = new ArrayList<Integer>();

    public List<Integer> middle(TreeNode root) {

        if (root == null) {
            return rel;
        }

        middle(root.left);
        rel.add(root.val);
        middle(root.right);

        return rel;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        new Tree_94().inorderTraversal(root);

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
