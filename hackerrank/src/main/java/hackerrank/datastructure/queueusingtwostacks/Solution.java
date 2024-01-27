package hackerrank.datastructure.queueusingtwostacks;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();

        MyQueue<Integer> myQueue = new MyQueue<>();

        for (int i = 0; i < queries; i++) {
            int queryType = scanner.nextInt();
            switch (queryType) {
                case 1:
                    int value = scanner.nextInt();
                    myQueue.enqueue(value);
                    break;
                case 2:
                    myQueue.dequeue();
                    break;
                case 3:
                    System.out.println(myQueue.peek());
                    break;
            }
        }

        scanner.close();
    }

    static class MyQueue<T> {

        Stack<T> enqueueStack = new Stack<>();
        Stack<T> dequeueStack = new Stack<>();

        void enqueue(T t) {
            enqueueStack.push(t);
        }

        T dequeue() {
            if (dequeueStack.isEmpty()) {
                while (!enqueueStack.isEmpty()) {
                    dequeueStack.push(enqueueStack.pop());
                }
            }
            if (!dequeueStack.isEmpty()) {
                return dequeueStack.pop();
            }
            return null;
        }

        T peek() {
            if (dequeueStack.isEmpty()) {
                while (!enqueueStack.isEmpty()) {
                    dequeueStack.push(enqueueStack.pop());
                }
            }
            if (!dequeueStack.isEmpty()) {
                return dequeueStack.peek();
            }
            return null;
        }
    }
}