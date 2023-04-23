class Process {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Produce method...");
            wait();
            System.out.println("Again! Produce method...");
        }
    }
    public void consume() throws InterruptedException {
        Thread.sleep(1000);
        synchronized (this) {
            System.out.println("Consume method...");
            notify();
            // System.out.println("Resumed.");
            Thread.sleep(5000);
        }
    }
}

public class App5 {
    public static void main(String[] args) {
        Process process = new Process();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
