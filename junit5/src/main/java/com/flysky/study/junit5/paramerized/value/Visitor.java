package com.flysky.study.junit5.paramerized.value;

public interface Visitor<T> {
    String visit(TreeNode<T> root);
}
