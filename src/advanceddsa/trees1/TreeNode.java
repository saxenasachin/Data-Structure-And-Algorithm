package advanceddsa.trees1;

public class TreeNode extends Node<Integer> {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        super(x);
        val = x;
        left = null;
        right = null;
    }
}
