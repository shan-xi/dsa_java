package deadlock;

public class ThreadJoinExample {
    public static void main(String[] args) throws InterruptedException {
        Object resource1 = new Object();
        Object resource2 = new Object();
        Thread t1 = new Thread(new Task1("task1", resource1, resource2));
        Thread t2 = new Thread(new Task2("task2", resource1, resource2));

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        System.out.println("All tasks completed. -> main thread should execute this line at the end");
    }
}

class Task1 implements Runnable {

    private final String name;
    Object resource1;
    Object resource2;

    public Task1(String name, Object resource1, Object resource2) {
        this.name = name;
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        System.out.println("start: " + name);
        try {
            System.out.println(Thread.currentThread().getName() + " is attempting lock: " + resource1);
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " get lock: " + resource1);
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " is attempting lock: " + resource2);
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " get lock: " + resource2);
                    System.out.println(Thread.currentThread().getName() + " release lock: " + resource2);
                }
                System.out.println(Thread.currentThread().getName() + " release lock: " + resource1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " completed");
    }
}

class Task2 implements Runnable {

    private final String name;
    Object resource1;
    Object resource2;

    public Task2(String name, Object resource1, Object resource2) {
        this.name = name;
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        System.out.println("start: " + name);
        try {
            System.out.println(Thread.currentThread().getName() + " is attempting lock: " + resource2);
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + " get lock: " + resource2);
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " is attempting lock: " + resource1);
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " get lock: " + resource1);
                    System.out.println(Thread.currentThread().getName() + " release lock: " + resource1);
                }
                System.out.println(Thread.currentThread().getName() + " release lock: " + resource2);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " completed");
    }
}
