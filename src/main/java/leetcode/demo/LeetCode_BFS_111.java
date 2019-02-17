package leetcode.demo;

import leetcode.demo.tree.TreeNode;

import java.util.*;

/**
 * <p>LeetCode_BFS_102</p>
 * Copyright @ 2019 Shanghai hailang Co. Ltd.
 * All right reserved.
 *
 * @author songyanfei
 * @date 2019年01月25日
 * <p>
 * <p>
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 *
 * breadth first search
 */
public class LeetCode_BFS_111 extends TreeNode {

    /**
     * 最小深度：层级中不存在左右节点的就是最小深度节点
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        List<TreeNode> temp = new ArrayList<>();
        temp.add(root);
        return levelNode(1, temp);
    }


    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        List<TreeNode> temp = new ArrayList<>();
        temp.add(root);
        return levelNode(1, temp);
    }

    private int levelNode(int currentLevel, List<TreeNode> nextLevel) {
        if (nextLevel == null || nextLevel.isEmpty()) {
            return currentLevel;
        }

        ArrayList<TreeNode> next = new ArrayList<>();
        for (TreeNode node : nextLevel) {
            if (node.left == null && node.right == null) {
                System.out.println("最小路径节点：" + node.val);
                return currentLevel;
            }

            if (node.left != null) {
                next.add(node.left);
            }
            if (node.right != null) {
                next.add(node.right);
            }
        }
        return levelNode(currentLevel + 1, next);
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(5);
        root.right.left.right = new TreeNode(6);

        int rel = new LeetCode_BFS_111().minDepth(root);
        System.out.println(rel);
    }
}
