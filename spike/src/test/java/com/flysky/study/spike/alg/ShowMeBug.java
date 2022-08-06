package com.flysky.study.spike.alg;


import org.junit.Test;

public class ShowMeBug {

    @Test
    public void test() {
        Node nxt = new Node(6, null);

        Node node = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, nxt)))));

        Node head = solution(node);

        System.out.println("head = " + head);

        System.out.println("nxt = " + nxt);
    }


    public Node ReverseList(Node head) {
        //pre指针：用来指向反转后的节点，初始化为null
        Node pre = null;
        //当前节点指针
        Node cur = head;
        //循环迭代
        while (cur != null) {
            //current_next 节点，永远指向当前节点cur的下一个节点
            Node current_next = cur.next;
            //反转的关键：当前的节点指向其前一个节点(注意这不是双向链表，没有前驱指针)
            cur.next = pre;
            //更新pre
            pre = cur;
            //更新当前节点指针
            cur = current_next;
        }
        //为什么返回pre？因为pre是反转之后的头节点
        return pre;
    }

    public Node solution(Node head) {
        // 在这⾥写代码
        return rec(head, head.next, null);
    }

    public Node rec(Node current, Node nxt, Node pre) {
        if (current == null) {
            return null;
        }
        Node next = new Node(current.next.data, current.next.next);//保存当前next
        //交换
        current.next.next = current;//当前next作为当前的头部
        current.next = pre;//当前next指向前一个

        return rec(next, next.next, current);
    }

    public class Node {
        public int data;
        public Node next;

        public Node(int data, Node nxt) {
            this.data = data;
            this.next = nxt;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }


}
