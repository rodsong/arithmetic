package lc.demo;

import lc.demo.tree.TreeNode;
import lc.demo.tree.Tree_94;

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
 */
public class LeetCode_BFS_102 extends TreeNode {

    /**
     * 分层遍历二叉树节点
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // 层级节点队列
        Deque<TreeNode> queue = new ArrayDeque();
        queue.add(root);

        // 已访问节点, 如果是图需要添加已访问节点控制
        Set<TreeNode> visited = new HashSet<>();
        visited.add(root);

        while (queue.size() > 0) {
            // 当前层次节点
            int current_nodes = queue.size();
            List<Integer> current_level = new ArrayList<>();
            // 处理当前层
            for (int i = 0; i < current_nodes; i++) {
                TreeNode node = queue.pollFirst();
                current_level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(current_level);
        }

        return result;
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

        List<List<Integer>> rel = new LeetCode_BFS_102().levelOrder(root);

        rel.forEach((nodes) -> {
            System.out.println(Arrays.toString(nodes.toArray()));
        });
    }
}
