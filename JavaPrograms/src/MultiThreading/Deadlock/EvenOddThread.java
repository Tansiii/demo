package MultiThreading.Deadlock;

import java.lang.Runnable;

public class EvenOddThread {

    private static int counter;
    private static Object obj = new Object();

static class Task implements Runnable
{
    public void run()
    {
        synchronized (obj)
        {
            while(counter<25)
            {
                if(counter%2==0 && Thread.currentThread().getName().equals("Thread_0"))
                {
                    System.out.println("Printing="+counter+ " by Thread " + Thread.currentThread().getName());
                    counter++;
                    obj.notifyAll();
                }
                else if (counter%2==1 && Thread.currentThread().getName().equals("Thread_1"))
                {
                    System.out.println("Printing="+counter+ " by Thread " + Thread.currentThread().getName());
                    counter++;
                    obj.notifyAll();
                }
                else
                {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                         e.printStackTrace();
                    }
                }
            }
        }
    }
}

public static void main (String args[])
    {
        Thread t1 = new Thread(new Task() , "Thread_0");
        Thread t2 = new Thread(new Task() , "Thread_1");
        t1.start();
        t2.start();
    }
}
