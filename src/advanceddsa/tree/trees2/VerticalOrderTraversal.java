package advanceddsa.tree.trees2;

import advanceddsa.tree.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.
 * <p>
 * <p>
 * NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 0 <= number of nodes <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only arument is a pointer to the root node of binary tree, A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a 2D array denoting the vertical order traversal of tree as shown.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * 6
 * /   \
 * 3     7
 * / \     \
 * 2   5     9
 * Input 2:
 * <p>
 * 1
 * /   \
 * 3     7
 * /       \
 * 2         9
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [
 * [2],
 * [3],
 * [6, 5],
 * [7],
 * [9]
 * ]
 * Output 2:
 * <p>
 * [
 * [2],
 * [3],
 * [1],
 * [7],
 * [9]
 * ]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * First row represent the vertical line 1 and so on.
 */
public class VerticalOrderTraversal {

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
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
        for (int i = minValue; i <= maxValue; i++) {
            result.add(map.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode9 = new TreeNode(9);
        treeNode6.left = treeNode3;
        treeNode6.right = treeNode7;
        treeNode3.left = treeNode2;
        treeNode3.right = treeNode5;
        treeNode7.right = treeNode9;
        System.out.println(verticalOrderTraversal(treeNode6));
    }

    static class Pair {
        int verticalLevel;
        TreeNode node;

        Pair(int verticalLevel, TreeNode node) {
            this.verticalLevel = verticalLevel;
            this.node = node;
        }
    }
}
