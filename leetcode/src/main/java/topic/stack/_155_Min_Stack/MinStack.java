package topic.stack._155_Min_Stack;

import java.util.Stack;

class MinStack {
    private final Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println("Minimum element: " + minStack.getMin());  // Returns -3

        minStack.pop();

        System.out.println("Top element: " + minStack.top());          // Returns 0
        System.out.println("Minimum element: " + minStack.getMin());  // Returns -2
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new int[]{x, x});
        } else {
            int currentMin = stack.peek()[1];
            stack.push(new int[]{x, Math.min(x, currentMin)});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
