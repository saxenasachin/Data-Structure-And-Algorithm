package advanceddsa.trees1;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Problem Description
 * Given a binary tree, return the preorder traversal of its nodes values.
 * <p>
 * NOTE: Using recursion is not allowed.
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
 * Return an integer array denoting the preorder traversal of the given binary tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 1
 * \
 * 2
 * /
 * 3
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
 * [1, 2, 3]
 * Output 2:
 * <p>
 * [1, 6, 2, 3]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The Preoder Traversal of the given tree is [1, 2, 3].
 * Explanation 2:
 * <p>
 * The Preoder Traversal of the given tree is [1, 6, 2, 3].
 */
public class PreorderTraversal {

    public static ArrayList<Integer> preorderTraversal(advanceddsa.trees1.TreeNode A) {
        ArrayList<Integer> output = new ArrayList<>();
        Stack<advanceddsa.trees1.TreeNode> stack = new Stack<>();
        stack.push(A);
        while (!stack.isEmpty()) {
            advanceddsa.trees1.TreeNode node = stack.pop();
            output.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        advanceddsa.trees1.TreeNode treeNode = new advanceddsa.trees1.TreeNode(1);
        advanceddsa.trees1.TreeNode leftOf1 = new advanceddsa.trees1.TreeNode(6);
        advanceddsa.trees1.TreeNode rightOf1 = new advanceddsa.trees1.TreeNode(2);
        advanceddsa.trees1.TreeNode leftOf2 = new TreeNode(3);
        treeNode.left = leftOf1;
        treeNode.right = rightOf1;
        rightOf1.left = leftOf2;
        System.out.println(preorderTraversal(treeNode));
    }
}
