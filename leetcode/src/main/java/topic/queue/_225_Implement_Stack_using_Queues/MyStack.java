package topic.queue._225_Implement_Stack_using_Queues;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }

    public void push(int x) {
        q1.offer(x);
    }

    public int pop() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int result = q1.poll();
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
        return result;
    }

    public int top() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int result = q1.poll();
        q2.offer(result);
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
        return result;
    }

    public boolean empty() {
        return q1.isEmpty();
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