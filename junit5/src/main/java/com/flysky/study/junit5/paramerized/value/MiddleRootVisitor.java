package com.flysky.study.junit5.paramerized.value;

public class MiddleRootVisitor<T> implements Visitor<T> {
    @Override
    public String visit(TreeNode<T> root) {
        if(root == null){
            return "";
        }
        return visit(root.getLeftChild()) + root.getValue() + visit(root.getRightChild());
    }
}
