package topic.queue._225_Implement_Stack_using_Queues;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack2 {
    Queue<Integer> q;

    public MyStack2() {
        q = new LinkedList<>();
    }

    public static void main(String[] args) {
        MyStack2 obj = new MyStack2();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }

    public void push(int x) {
        q.offer(x);
        int size = q.size();
        while (size > 1) {
            q.offer(q.poll());
            size--;
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */