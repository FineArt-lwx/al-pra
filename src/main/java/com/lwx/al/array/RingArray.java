package com.lwx.al.array;

public class RingArray {


    //数组实现队列
    static class MyQueue {

        int[] array;

        int size;

        int limit;

        int head;

        int tail;

        public MyQueue(int limit) {
            array = new int[limit];
            size = 0;
            this.limit = limit;
            head = 0;
            tail = 0;
        }

        public void add(int value) {
            if (isFull()) {
                throw new IllegalStateException();
            }
            int addIndex = nextIndex(tail);
            array[addIndex] = value;
            size++;
            tail = addIndex;

        }

        public int poll() {
            if (isEmpty()) {
                throw new IllegalStateException();
            }
            int value = array[head];
            size--;
            head = nextIndex(head);
            return value;
        }

        private boolean isFull() {
            return size == limit;
        }

        private boolean isEmpty() {
            return size == 0;
        }

        private int nextIndex(int index) {
            //            return index == limit - 1 ? 0 : index + 1;
            return (index + 1) % limit;
        }
    }
}
