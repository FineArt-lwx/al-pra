package com.lwx.al.rbtree;

public class RBTree<K, V> {

    public static final boolean RED = true;

    public static final boolean BLACK = false;

    private RBNode root = null;

    class RBNode {

        private RBNode parent;

        private RBNode left;

        private RBNode right;

        private boolean color;

        K key;

        V value;

    }


}
