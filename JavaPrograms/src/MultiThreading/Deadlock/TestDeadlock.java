package MultiThreading.Deadlock;

public class TestDeadlock {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main (String args[])
    {
        new Thread(new ThreadDemo1()).start();
        new Thread(new ThreadDemo2()).start();
    }

    private static class ThreadDemo1 implements  Runnable
    {

        @Override
        public void run() {
            synchronized (lock1)
            {
                System.out.println("Thread1 holding lock1");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread1 waiting for lock 2");
                synchronized (lock2)
                {
                    System.out.println("Thread1 holding lock1 and lock2");

                }
            }
        }
    }

    private static class ThreadDemo2 implements  Runnable
    {
        @Override
        public void run() {
            synchronized (lock2)
            {
                System.out.println("Thread2 holding lock1");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread 2 waithing for lock2");
                synchronized (lock1)
                {
                    System.out.println("thread2 holding lock 1 and 2");
                }

            }

        }
    }
}
