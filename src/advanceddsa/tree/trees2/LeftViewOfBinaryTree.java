package advanceddsa.tree.trees2;

import advanceddsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Description
 * Given a binary tree of integers. Return an array of integers representing the left view of the Binary tree.
 * <p>
 * Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side
 * <p>
 * NOTE: The value comes first in the array which have lower level.
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
 * First and only argument is a root node of the binary tree, A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer array denoting the left view of the Binary tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * 1
 * /   \
 * 2    3
 * / \  / \
 * 4   5 6  7
 * /
 * 8
 * Input 2:
 * <p>
 * 1
 * /  \
 * 2    3
 * \
 * 4
 * \
 * 5
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [1, 2, 4, 8]
 * Output 2:
 * <p>
 * [1, 2, 4, 5]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The Left view of the binary tree is returned.
 */
public class LeftViewOfBinaryTree {

    public static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> output = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, A));
        int l = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.peek();
            if (pair != null) {
                int level = pair.verticalLevel;
                TreeNode node = pair.node;
                if (node != null) {
                    if (node.left != null) {
                        queue.offer(new Pair(level + 1, node.left));
                    }
                    if (node.right != null) {
                        queue.offer(new Pair(level + 1, node.right));
                    }
                    if (level == l) {
                        output.add(node.val);
                        l++;
                    }
                }
            }
            queue.remove();
        }
        return output;
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
