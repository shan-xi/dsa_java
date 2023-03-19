package deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutorServiceDemo {
    private static int sharedRes = 0;
    private final ReentrantLock mutex = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int total = 100;
        for (int i = 0; i < total; i++) {
            executorService.submit(()->{
                new ExecutorServiceDemo().executeTask();
            });
        }
        executorService.shutdown();
        System.out.println("ExecutorService->isShutdown: " + executorService.isShutdown());
        boolean isTerminate = executorService.awaitTermination(100, TimeUnit.SECONDS);
        if (isTerminate)
            System.out.println("ExecutorService->isTerminated: " + executorService.isTerminated());
        if (total != sharedRes) {
            System.out.println("race condition occurs");
        } else {
            System.out.println("final result is " + sharedRes);
        }
    }

    public void executeTask() {
        try {
            mutex.tryLock(5, TimeUnit.SECONDS);
            System.out.println("thread: " + Thread.currentThread().getName());
            sharedRes++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mutex.unlock();
        }
    }
}
