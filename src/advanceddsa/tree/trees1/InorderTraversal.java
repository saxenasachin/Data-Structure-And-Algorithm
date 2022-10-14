package advanceddsa.tree.trees1;

import advanceddsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Problem Description
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
 * Return an integer array denoting the inorder traversal of the given binary tree.
 * <p>
 * <p>
 * <p>
 * Example Input
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
 * [1, 3, 2]
 * Output 2:
 * <p>
 * [6, 1, 3, 2]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The Inorder Traversal of the given tree is [1, 3, 2].
 * Explanation 2:
 * <p>
 * The Inorder Traversal of the given tree is [6, 1, 3, 2].
 */
public class InorderTraversal {

    public static ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> output = new ArrayList<>();
        if (A == null) return output;
        Stack<TreeNode> stack = new Stack<>();
        while (A != null || !stack.isEmpty()) {
            if (A != null) {
                stack.push(A);
                A = A.left;
            } else {
                A = stack.pop();
                output.add(A.val);
                A = A.right;
            }
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
        System.out.println(inorderTraversal(treeNode));
    }
}
