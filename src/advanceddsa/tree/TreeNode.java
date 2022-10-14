package advanceddsa.tree;

public class TreeNode extends Node<Integer> {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        super(x);
        val = x;
        left = null;
        right = null;
    }
}
