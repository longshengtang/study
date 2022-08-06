package com.flysky.study.junit5.paramerized.value;

import java.util.HashMap;
import java.util.Map;

public class TreeNode<T> {

    public TreeNode(T value) {
        this(value, null, null);
    }

    public TreeNode(T value, TreeNode<T> leftChild, TreeNode<T> rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public static <T> TreeNode<T> buildTree(T value, T leftChildValue, T rightChildValue) {
        return buildTree(value, creatNodeOrNull(leftChildValue), creatNodeOrNull(rightChildValue));
    }

    public static <T> TreeNode<T> buildTree(T value, TreeNode<T> leftChild, TreeNode<T> rightChild) {
        return new TreeNode<>(value, leftChild, rightChild);
    }

    private static <T> TreeNode<T> creatNodeOrNull(T nodeValue) {
        return nodeValue == null ? null : new TreeNode<>(nodeValue);
    }

    public static <T> TreeNode<T> newNodes(T[] nodeValues) {
        if (nodeValues == null || nodeValues.length == 0) {
            return null;
        }

        Map<T, TreeNode<T>> treeNodes = new HashMap<>();
        for (int i = 0; i < nodeValues.length; i++) {
            T key = nodeValues[i];
            treeNodes.put(key, new TreeNode<>(key));
        }

        int lastParentNodeIndex = nodeValues.length / 2 - 1;
        for (int i = 0; i <= lastParentNodeIndex; i++) {
            TreeNode<T> parent = treeNodes.get(nodeValues[i]);
            parent.leftChild = treeNodes.get(nodeValues[2 * i + 1]);//所有父节点都有左子节点

            //为了效率，可以把最后一个节点移动到外面判定。但此处为了简洁，就放在for内部
            if (i < lastParentNodeIndex || nodeValues.length % 2 != 0) {//除最后一个父节点之外，或者最后一个节点并且总节点个数为奇数个，则都有右子节点
                parent.rightChild = treeNodes.get(nodeValues[2 * i + 2]);
            }
        }

        return treeNodes.get(nodeValues[0]);
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }

    private final T value;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

}
