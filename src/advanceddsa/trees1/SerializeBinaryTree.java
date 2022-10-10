package advanceddsa.trees1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Description
 * Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.
 * <p>
 * Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.
 * <p>
 * NOTE:
 * <p>
 * In the array, the NULL/None child is denoted by -1.
 * For more clarification check the Example Input.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= number of nodes <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * Only argument is a A denoting the root node of a Binary Tree.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer array denoting the Level Order Traversal of the given Binary Tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * 1
 * /   \
 * 2     3
 * / \
 * 4   5
 * Input 2:
 * <p>
 * 1
 * /   \
 * 2     3
 * / \     \
 * 4   5     6
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
 * Output 2:
 * <p>
 * [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5 , -1, -1, -1, -1, -1, -1].
 * Since 3, 4 and 5 each has both NULL child we had represented that using -1.
 * Explanation 2:
 * <p>
 * The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1].
 * Since 3 has left child as NULL while 4 and 5 each has both NULL child.
 */
public class SerializeBinaryTree {

    /**
     * traverse as level order, if we find null child. put it in
     * this queue. while deque, if null found, append -1 to the output.
     *
     * @param A - root node
     * @return - list containing serialized integer.
     */
    public static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> output = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.remove();
                if (head == null) {
                    output.add(-1);
                } else {
                    output.add(head.val);
                    queue.offer(head.left);
                    queue.offer(head.right);
                }
            }
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
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;
        System.out.println(solve(treeNode));
    }
}
