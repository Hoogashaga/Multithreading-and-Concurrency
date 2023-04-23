class Worker implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

public class App3 {
    public static void main(String[] args) {
        // System.out.println(Thread.currentThread().getName());
        // Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        // System.out.println(Thread.currentThread().getPriority());


        Thread t1 = new Thread(new Worker());
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        System.out.println("This is main thread");
    }
}
