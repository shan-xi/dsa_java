import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        int result = q1.remove();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return result;
    }

    void push(int x) {
        q1.add(x);
    }

    boolean isEmpty() {
        return q1.isEmpty();
    }

    int top() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        while(q1.size()>1){
            q2.add(q1.remove());
        }
        return q1.peek();
    }

    public static void main(String[] args) {
        StackUsingTwoQueues s = new StackUsingTwoQueues();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        int p = s.top();
        if(p != 4){
            throw new RuntimeException("!= 4");
        }
        int r = s.pop();
        if(r != 4){
            throw new RuntimeException("!= 4");
        }
    }
}
