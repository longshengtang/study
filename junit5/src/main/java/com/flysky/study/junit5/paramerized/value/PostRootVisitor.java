package com.flysky.study.junit5.paramerized.value;

public class PostRootVisitor<T> implements Visitor<T> {
    @Override
    public String visit(TreeNode<T> root) {
        if (root == null) {
            return "";
        }
        return visit(root.getLeftChild()) + visit(root.getRightChild()) + root.getValue();
    }
}
