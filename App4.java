// import java.time.Clock;

public class App4 {
    
    public static int counter1 = 0;
    public static int counter2 = 0;

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    // we can use synchronized keyword to make sure that only one thread can access the method at a time
    // App4 object has a single lock, this is why the methods can not be executed at the same time
    public static synchronized void increment1() {
        // class level lock
        synchronized(lock1) {
            counter1++;
        }
    }
    public static synchronized void increment2() {
        synchronized(lock2) {
            counter2++;
        }
    }

    public static void process() {
    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i=0; i<100;i++) {
                increment1();;
            }
        }
    });

    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i=0; i<100;i++) {
                increment2();
            }
        }
    });

    t1.start();
    t2.start();

    
    try {
        t1.join();
        t2.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("The counter1 is: +" + counter1);
    System.out.println("The counter2 is: +" + counter2);
    }

    public static void main(String[] args) {
        // Thread t1 = new Thread(new Runner());
        // t1.start();
        // System.out.println("This is main thread");
        process();
    }
}
