package advanceddsa.tree.trees2;

import advanceddsa.tree.TreeNode;

import java.util.*;

/**
 * Problem Description
 * Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.
 * <p>
 * The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.
 * <p>
 * Return the nodes in any order.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 100000
 * <p>
 * 0 <= node values <= 10^9
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is head of the binary tree A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an array, representing the top view of the binary tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
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
 * [1, 2, 4, 8, 3, 7]
 * Output 2:
 * <p>
 * [1, 2, 3]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Top view is described.
 * Explanation 2:
 * <p>
 * Top view is described.
 */
public class TopViewOfBinaryTree {

    public static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        queue.offer(new Pair(0, A));
        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            int level = currentPair.verticalLevel;
            TreeNode node = currentPair.node;
            if (map.containsKey(level)) {
                map.get(level).add(node.val);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(node.val);
                map.put(level, list);
            }
            minValue = Math.min(minValue, level);
            maxValue = Math.max(maxValue, level);

            if (node.left != null) {
                queue.offer(new Pair(level - 1, node.left));
            }
            if (node.right != null) {
                queue.offer(new Pair(level + 1, node.right));
            }
        }
        for (int i = 0; i >= minValue; i--) {
            result.add(map.get(i).get(0));
        }
        for (int i = 1; i <= maxValue; i++) {
            result.add(map.get(i).get(0));
        }
        return result;
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
