import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1("MyFirstThread");
        thread1.start();

        Thread thread2 = new Thread(new MyThread2(), "MySecondThread");
        thread2.run();

        Thread thread3 = new Thread(() -> {
            Thread current = Thread.currentThread();

            System.out.println("Thread name: " + current.getName());
            System.out.println("Priority: " + current.getPriority());
            System.out.println("Group: " + (current.getThreadGroup().getName()));
        }, "MyThirdThread");
        thread3.start();

        MyThread4 myCallable = new MyThread4();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        Thread thread4 = new Thread(futureTask, "MyFourthThread");
        thread4.start();

        try {
            String result = futureTask.get();
            System.out.println("Thread name: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread mainThread = Thread.currentThread();

        System.out.println("Thread name: " + mainThread.getName());
        System.out.println("Priority: " + mainThread.getPriority());
        System.out.println("Group: " + (mainThread.getThreadGroup().getName()));
    }
}

class MyThread1 extends Thread {
    public MyThread1(String name) {
        super(name);
    }

    public void run() {
        Thread current = Thread.currentThread();

        System.out.println("Thread name: " + current.getName());
        System.out.println("Priority: " + current.getPriority());
        System.out.println("Group: " + (current.getThreadGroup().getName()));
    }
}

class MyThread2 implements Runnable {
    public void run() {
        Thread current = Thread.currentThread();

        System.out.println("Thread name: " + current.getName());
        System.out.println("Priority: " + current.getPriority());
        System.out.println("Group: " + (current.getThreadGroup().getName()));
    }
}

class MyThread4 implements Callable<String> {
    public String call() throws Exception {
        Thread current = Thread.currentThread();

        System.out.println("Priority: " + current.getPriority());
        System.out.println("Group: " + (current.getThreadGroup().getName()));

        return current.getName();
    }
}
