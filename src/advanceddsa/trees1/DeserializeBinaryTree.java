package advanceddsa.trees1;

import java.util.*;

/**
 * Problem Description
 * You are given an integer array A denoting the Level Order Traversal of the Binary Tree.
 * <p>
 * You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.
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
 * -1 <= A[i] <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * Only argument is an integer array A denoting the Level Order Traversal of the Binary Tree.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the root node of the Binary Tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
 * Input 2:
 * <p>
 * A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * /   \
 * 2     3
 * / \
 * 4   5
 * Output 2:
 * <p>
 * 1
 * /   \
 * 2     3
 * / \ .   \
 * 4   5 .   6
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 * Since 3, 4 and 5 each has both NULL child we had represented that using -1.
 * Explanation 2:
 * <p>
 * Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 * Since 3 has left child as NULL while 4 and 5 each has both NULL child.
 */
public class DeserializeBinaryTree {

    public static TreeNode solve(ArrayList<Integer> A) {
        if (A.size() == 0) return null;
        TreeNode rootNode = new TreeNode(A.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(rootNode);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode == null) {
                continue;
            }
            int leftNodeValue = A.get(i);
            int rightNodeValue = A.get(i + 1);
            i += 2;
            if (leftNodeValue == -1) {
                currentNode.left = null;
            } else {
                currentNode.left = new TreeNode(leftNodeValue);
            }
            if (rightNodeValue == -1) {
                currentNode.right = null;
            } else {
                currentNode.right = new TreeNode(rightNodeValue);
            }

            queue.offer(currentNode.left);
            queue.offer(currentNode.right);
        }
        return rootNode;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1};
        ArrayList<Integer> input = new ArrayList<>();
        for (int a : A) {
            input.add(a);
        }
        BTreePrinter.printNode(solve(input));
    }
}
