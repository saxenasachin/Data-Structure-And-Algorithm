package advanceddsa.tree.trees2;

import advanceddsa.tree.TreeNode;

class Pair {
    int verticalLevel;
    TreeNode node;

    Pair(int verticalLevel, TreeNode node) {
        this.verticalLevel = verticalLevel;
        this.node = node;
    }
}