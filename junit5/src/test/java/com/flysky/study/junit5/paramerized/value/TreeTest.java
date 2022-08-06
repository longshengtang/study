package com.flysky.study.junit5.paramerized.value;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import static com.flysky.study.junit5.paramerized.value.TreeNode.buildTree;
import static com.flysky.study.junit5.paramerized.value.TreeNode.newNodes;
import static org.assertj.core.api.Assertions.assertThat;

public class TreeTest {

    @Test
    public void construct_bi_tree() {
        TreeNode<String> root = buildTree("A", "B", "C");

        assertThat(root.getValue()).isEqualTo("A");
        assertThat(root.getLeftChild().getValue()).isEqualTo("B");
        assertThat(root.getRightChild().getValue()).isEqualTo("C");

        root = buildTree("A"
                , buildTree("B"
                        , buildTree("D", "H", "I")
                        , buildTree("E", "J", "K")
                )
                , buildTree("C"
                        , buildTree("F", "L", "M")
                        , buildTree("G", "N", null)
                )

        );

        assertThat(root.getLeftChild()//B
                .getLeftChild()//D
                .getLeftChild()//H
                .getValue()
        ).isEqualTo("H");

        assertThat(root.getRightChild()//C
                .getRightChild()//G
                .getLeftChild()//N
                .getValue()
        ).isEqualTo("N");

        TreeNode<String> root2 = getStringTreeNode(nodeSrc);
        assertThat(root.getValue()).isEqualTo(root2.getValue());


        String r1 = JSONObject.toJSONString(root);
        System.out.println(r1);
        System.out.println("-------------");
        String r2 = JSONObject.toJSONString(root2);
        System.out.println(r2);
        assertThat(r1).isEqualTo(r2);

    }

    private TreeNode<String> getStringTreeNode(String nodes) {
//        String[] nodeValues = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N"};
//        String[] nodeValues={"A"};
//        String[] nodeValues={"A","B"};
//        String[] nodeValues={"A","B","C"};
//        String[] nodeValues = {"A", "B", "C", "D"};
        TreeNode<String> root2 = newNodes(nodes.split(""));
        return root2;
    }

    @Test
    public void first_root_traverse() {
        //深度优先：先根遍历
        Visitor<String> visitor = new FirstRootVisitor<>();
        assertThat(visitor.visit(getStringTreeNode(nodeSrc))).isEqualTo("ABDHIEJKCFLMGN");
    }

    @Test
    public void middle_root_traverse() {
        //深度优先：中根遍历
        Visitor<String> visitor = new MiddleRootVisitor<>();
        assertThat(visitor.visit(getStringTreeNode(nodeSrc))).isEqualTo("HDIBJEKALFMCNG");
    }

    @Test
    public void post_root_traverse() {
        //深度优先：后根遍历
        Visitor<String> visitor = new PostRootVisitor<>();
        assertThat(visitor.visit(getStringTreeNode(nodeSrc))).isEqualTo("HIDJKEBLMFNGCA");
    }

    @Test
    public void breadth_traverse() {
        //广度优先遍历
        Visitor<String> visitor = new BreadthFirstVisitor<>();
        assertThat(visitor.visit(getStringTreeNode(nodeSrc))).isEqualTo(nodeSrc);
    }


    private String nodeSrc = "ABCDEFGHIJKLMN";


}
