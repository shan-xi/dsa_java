package implement_queue_using_stacks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyQueueTest {
    @Test
    public void test_case1_success() {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int p1 = obj.peek();
        Assertions.assertEquals(1, p1);
        int p2 = obj.pop();
        Assertions.assertEquals(1, p2);
        boolean p3 = obj.empty();
        Assertions.assertFalse(p3);
    }
    @Test
    public void test_case2_success() {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        Assertions.assertEquals(1, obj.pop());
        obj.push(5);
        Assertions.assertEquals(2, obj.pop());
        Assertions.assertEquals(3, obj.pop());
        Assertions.assertEquals(4, obj.pop());
        Assertions.assertEquals(5, obj.pop());
    }
}

