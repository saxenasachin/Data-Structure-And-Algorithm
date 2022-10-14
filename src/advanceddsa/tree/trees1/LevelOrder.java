package advanceddsa.tree.trees1;

import advanceddsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Description
 * Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= number of nodes <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is root node of the binary tree, A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Input 2:
 * <p>
 * 1
 * / \
 * 6   2
 * /
 * 3
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [
 * [3],
 * [9, 20],
 * [15, 7]
 * ]
 * Output 2:
 * <p>
 * [
 * [1]
 * [6, 2]
 * [3]
 * ]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Return the 2D array. Each row denotes the traversal of each level.
 */
public class LevelOrder {

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            output.add(list);
        }
        return output;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode leftOf1 = new TreeNode(6);
        TreeNode rightOf1 = new TreeNode(2);
        TreeNode leftOf2 = new TreeNode(3);
        treeNode.left = leftOf1;
        treeNode.right = rightOf1;
        rightOf1.left = leftOf2;
        System.out.println(levelOrder(treeNode));
    }
}
