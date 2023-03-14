package com.lwx.al.linkedlist;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MockStackAndQueue {

    private static class Node<T> {
        public T value;
        public Node<T> last;
        public Node<T> next;

        public Node(T data) {
            value = data;
        }
    }

    public static class Deque<T> {
        public Node<T> head;
        public Node<T> tail;

        public void addFromHead(T value) {
            Node<T> node = new Node<>(value);
            if (isEmpty()) {
                head = node;
                tail = head;
                return;
            }
            node.next = head;
            head.last = node;
            head = node;
        }

        public void addFromTail(T value) {
            Node<T> node = new Node<>(value);
            if (head == null) {
                head = node;
                tail = head;
                return;
            }
            tail.next = node;
            node.last = tail;
            tail = node;
        }

        public T popFromHead() {
            if (isEmpty()) {
                return null;
            }
            Node<T> node = head;

            if (head == tail) {
                head = null;
                tail = null;
                return node.value;
            }
            head = head.next;
            head.last = null;
            return node.value;
        }

        public T popFromTail() {
            if (isEmpty()) {
                return null;
            }
            Node<T> node = tail;
            if (tail == head) {
                head = null;
                tail = null;
                return node.value;
            }
            tail = tail.last;
            tail.next = null;
            return node.value;
        }

        public boolean isEmpty() {
            return head == null;
        }

    }

    public static class MyStack<T> {
        private final Deque<T> queue;

        public MyStack() {
            queue = new Deque<T>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public T pop() {
            return queue.popFromHead();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

    }

    public static class MyQueue<T> {
        private Deque<T> queue;

        public MyQueue() {
            queue = new Deque<T>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public T poll() {
            return queue.popFromTail();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

    }

    public static boolean isEqual(Integer o1, Integer o2) {
        if (o1 == null && o2 != null) {
            return false;
        }
        if (o1 != null && o2 == null) {
            return false;
        }
        if (o1 == null && o2 == null) {
            return true;
        }
        return o1.equals(o2);
    }

    public static void main(String[] args) {
        int oneTestDataNum = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            MyStack<Integer> myStack = new MyStack<>();
            MyQueue<Integer> myQueue = new MyQueue<>();
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < oneTestDataNum; j++) {
                int nums = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myStack.push(nums);
                    stack.push(nums);
                } else {
                    if (Math.random() < 0.5) {
                        myStack.push(nums);
                        stack.push(nums);
                    } else {
                        if (!isEqual(myStack.pop(), stack.pop())) {
                            System.out.println("oops!");
                        }
                    }
                }
                int numq = (int) (Math.random() * value);
                if (queue.isEmpty()) {
                    myQueue.push(numq);
                    queue.offer(numq);
                } else {
                    if (Math.random() < 0.5) {
                        myQueue.push(numq);
                        queue.offer(numq);
                    } else {
                        if (!isEqual(myQueue.poll(), queue.poll())) {
                            System.out.println("oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }

}
