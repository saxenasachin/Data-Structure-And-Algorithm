package advanceddsa.tree.trees1;

import advanceddsa.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Description
 * Given the inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * NOTE: You may assume that duplicates do not exist in the tree.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= number of nodes <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A denoting the inorder traversal of the tree.
 * <p>
 * Second argument is an integer array B denoting the postorder traversal of the tree.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the root node of the binary tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [2, 1, 3]
 * B = [2, 3, 1]
 * Input 2:
 * <p>
 * A = [6, 1, 3, 2]
 * B = [6, 3, 2, 1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * / \
 * 2   3
 * Output 2:
 * <p>
 * 1
 * / \
 * 6   2
 * /
 * 3
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Create the binary tree and return the root node of the tree.
 */
public class BinaryTreeFromInorderAndPostorder {

    public static TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {

        if (inorder.size() == 0) return null;

        int rootValue = postorder.get(postorder.size() - 1);
        int rootNodeIndex = inorder.indexOf(rootValue);

        TreeNode rootNode = new TreeNode(rootValue);
        List<Integer> leftNodes = inorder.subList(0, rootNodeIndex);
        List<Integer> rightNodes = inorder.subList(rootNodeIndex + 1, inorder.size());

        rootNode.left = buildTree(new ArrayList<>(leftNodes), new ArrayList<>(postorder.subList(0, leftNodes.size())));
        rootNode.right = buildTree(new ArrayList<>(rightNodes), new ArrayList<>(postorder.subList(leftNodes.size(), postorder.size() - 1)));

        return rootNode;
    }

    public static void main(String[] args) {
        int[] A = {6, 1, 3, 2};
        int[] B = {6, 3, 2, 1};

        ArrayList<Integer> listA = new ArrayList<>();
        for (int a : A) {
            listA.add(a);
        }

        ArrayList<Integer> listB = new ArrayList<>();
        for (int a : B) {
            listB.add(a);
        }

        TreeNode rootNode = buildTree(listA, listB);
        if (rootNode != null) {
            System.out.println(rootNode.val);
            System.out.println(rootNode.left.val);
            System.out.println(rootNode.right.val);
        }
    }
}
