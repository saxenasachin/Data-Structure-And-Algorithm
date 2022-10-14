package advanceddsa.trees1;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Description
 * Given preorder and inorder traversal of a tree, construct the binary tree.
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
 * First argument is an integer array A denoting the preorder traversal of the tree.
 * <p>
 * Second argument is an integer array B denoting the inorder traversal of the tree.
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
 * A = [1, 2, 3]
 * B = [2, 1, 3]
 * Input 2:
 * <p>
 * A = [1, 6, 2, 3]
 * B = [6, 1, 3, 2]
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
public class BinaryTreeFromInorderAndPreorder {

    public static TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {

        if (inorder.size() == 0) return null;

        int rootValue = preorder.get(0);
        int rootIndex = inorder.indexOf(rootValue);

        List<Integer> leftNodes = inorder.subList(0, rootIndex);
        List<Integer> rightNodes = inorder.subList(rootIndex + 1, inorder.size());

        TreeNode rootNode = new TreeNode(rootValue);

        rootNode.left = buildTree(new ArrayList<>(preorder.subList(1, leftNodes.size() + 1)), new ArrayList<>(leftNodes));
        rootNode.right = buildTree(new ArrayList<>(preorder.subList(leftNodes.size() + 1, preorder.size())), new ArrayList<>(rightNodes));

        return rootNode;
    }

    public static void main(String[] args) {
        int[] A = {1, 6, 2, 3};
        int[] B = {6, 1, 3, 2};

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
