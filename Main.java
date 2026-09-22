public class Main {
    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1("MyFirstThread");
        thread1.start();

        Thread thread2 = new Thread(new MyThread2(), "MySecondThread");
        thread2.start();
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
