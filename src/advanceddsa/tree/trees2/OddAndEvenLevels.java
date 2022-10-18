package advanceddsa.tree.trees2;

import advanceddsa.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Description
 * Given a binary tree of integers. Find the difference between the sum of nodes at odd level and sum of nodes at even level.
 * <p>
 * NOTE: Consider the level of root node as 1.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 100000
 * <p>
 * 0 <= node values <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is a root node of the binary tree, A
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the difference between the sum of nodes at odd level and sum of nodes at even level.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * 1
 * /   \
 * 2     3
 * / \   / \
 * 4   5 6   7
 * /
 * 8
 * Input 2:
 * <p>
 * 1
 * / \
 * 2   10
 * \
 * 4
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 10
 * Output 2:
 * <p>
 * -7
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Sum of nodes at odd level = 23
 * Sum of nodes at even level = 13
 * Explanation 2:
 * <p>
 * Sum of nodes at odd level = 5
 * Sum of nodes at even level = 12
 */
public class OddAndEvenLevels {

    public static int solve(TreeNode A) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(1, A));
        int sumOfEvenLevel = 0;
        int sumOfOddLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                if (pair != null) {
                    TreeNode node = pair.node;
                    int level = pair.verticalLevel;
                    if (level % 2 == 0) {
                        sumOfEvenLevel += node.val;
                    } else {
                        sumOfOddLevel += node.val;
                    }
                    if (node.left != null) {
                        queue.offer(new Pair(level + 1, node.left));
                    }
                    if (node.right != null) {
                        queue.offer(new Pair(level + 1, node.right));
                    }
                }
            }
        }
        return sumOfOddLevel - sumOfEvenLevel;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode4.left = treeNode8;
        System.out.println(solve(treeNode));
    }
}
