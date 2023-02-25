package creational.singleton;

public class Client {
    public static void main(String[] args) {
        Thread ta = new Thread(new ThreadA());
        Thread tb = new Thread(new ThreadB());
        ta.start();
        tb.start();
    }

    static class ThreadA implements Runnable {

        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("A");
            System.out.println(singleton.value);
        }
    }

    static class ThreadB implements Runnable {

        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("B");
            System.out.println(singleton.value);
        }
    }
}
