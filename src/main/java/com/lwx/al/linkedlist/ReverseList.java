package com.lwx.al.linkedlist;

public class ReverseList {

    public static Node reverse(Node head) {
        Node cur = head;
        Node pre = null;
        while (cur != null) {
            Node next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static DoubleNode reverseDouble(DoubleNode head) {
        DoubleNode cur = head;
        DoubleNode curPre = null;
        while (cur != null) {
            DoubleNode next = cur.getNext();
            DoubleNode pre = cur.getPre();
            cur.setNext(pre);
            cur.setPre(next);
            curPre = cur;
            cur = next;
        }
        return curPre;
    }
}
