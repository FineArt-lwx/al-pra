package com.lwx.al.stack;

import java.util.Stack;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

//获得一个栈中的最小值
public class GetMinStack {

    @FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
    public static class MyStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack1() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(int newNum) {
            int min = newNum;
            if (!stackMin.isEmpty()) {
                min = Math.min(getMin(), min);
            }
            stackMin.push(min);
            stackData.push(newNum);

        }

        public int pop() {
            if (stackData.isEmpty()) {
                throw new IllegalStateException();
            }
            stackMin.pop();
            return stackData.pop();
        }

        public int getMin() {
            if (stackData.isEmpty()) {
                throw new IllegalStateException();
            }
            return stackMin.peek();
        }
    }

    @FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
    public static class MyStack2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack2() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(int newNum) {

            if (stackData.isEmpty() || newNum <= getMin()) {
                stackMin.push(newNum);
            }
            stackData.push(newNum);

        }

        public int pop() {
            if (stackData.isEmpty()) {
                throw new IllegalStateException();
            }
            Integer value = stackData.pop();
            if (value == getMin()) {
                stackMin.pop();
            }
            return value;

        }

        public int getMin() {
            if (stackData.isEmpty()) {
                throw new IllegalStateException();
            }
            return stackMin.peek();

        }
    }

    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        stack1.push(3);
        System.out.println(stack1.getMin());
        stack1.push(4);
        System.out.println(stack1.getMin());
        stack1.push(1);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());

        System.out.println("=============");

        MyStack2 stack2 = new MyStack2();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }


}
