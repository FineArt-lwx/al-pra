package com.lwx.al.linkedlist;

import com.google.common.base.Preconditions;

public class DeleteSpecify {

    public static Node delete(Node head, int target) {
        Node cur = head;
        while (cur != null) {
            if (cur.getValue() != target) {
                break;
            }
            cur = cur.getNext();
        }

        Node newHead = cur;
        Node pre = null;
        //走到这里第一个节点肯定不会是target
        while (cur != null) {
            if (cur.getValue() == target) {
                Preconditions.checkNotNull(pre);
                pre.setNext(cur.getNext());
            } else {
                pre = cur;
            }
            cur = cur.getNext();

        }
        return newHead;

    }
}
