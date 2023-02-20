package deadlock;

public class DeadlockSolved {

    public static void main(String ar[]) {
        DeadlockSolved test = new DeadlockSolved();

        final String a = "resource1";
        final String b = "resource2";

        // Thread-1
        Runnable b1 = new Runnable() {
            public void run() {
                synchronized (b) {
                    try {
                        /* Adding delay so that both threads can start trying to lock resources */
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // Thread-1 have resource1 but need resource2 also
                    synchronized (a) {
                        System.out.println("In block 1");
                    }
                }
            }
        };

        // Thread-2
        Runnable b2 = new Runnable() {
            public void run() {
                synchronized (b) {
                    // Thread-2 have resource2 but need resource1 also
                    synchronized (a) {
                        System.out.println("In block 2");
                    }
                }
            }
        };


        new Thread(b1).start();
        new Thread(b2).start();
    }
}