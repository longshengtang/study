package com.flysky.study.junit5.paramerized.value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 广度优先
 */
public class BreadthFirstVisitor<T> implements Visitor<T> {
    @Override
    public String visit(TreeNode<T> root) {
        if (root == null) {
            return "";
        }

        return levelVisit(Collections.singletonList(root));
    }

    private String levelVisit(List<TreeNode<T>> sameLevels) {
        if (sameLevels.isEmpty()) {//递归的出口
            return "";
        }

        StringBuilder result = new StringBuilder("");

        List<TreeNode<T>> sames = new ArrayList<>();
        for (TreeNode<T> sameLave : sameLevels) {
            result.append(sameLave.getValue());
            sames.addAll(getNotNullChildren(sameLave));
        }
        return result.append(levelVisit(sames)).toString();
    }

    private List<TreeNode<T>> getNotNullChildren(TreeNode<T> tree) {
        List<TreeNode<T>> sameLaves = new ArrayList<>();
        if (tree.getLeftChild() != null) {
            sameLaves.add(tree.getLeftChild());
        }
        if (tree.getRightChild() != null) {
            sameLaves.add(tree.getRightChild());
        }
        return sameLaves;
    }
}
