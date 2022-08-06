package com.flysky.study.junit5.paramerized.value;

public class FirstRootVisitor<T> implements Visitor<T> {
    @Override
    public String visit(TreeNode<T> root) {
        if(root == null){
            return "";
        }
        return root.getValue() + visit(root.getLeftChild()) + visit(root.getRightChild());
    }
}
