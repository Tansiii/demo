package MultiThreading.Deadlock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

 class worker implements Runnable
{
    String name ;
    ReentrantLock reentrantLock;

    worker(ReentrantLock reentrantLock , String name)
    {
        this.name = name;
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {

        boolean done =false;
        {
            while(!done)
            {
               boolean ans =  reentrantLock.tryLock();
               if(ans)
               {
                   try {
                       Date d = new Date();
                       SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
                       System.out.println("task name = " + name + "outer lock acquired at " + s.format(d) +
                               "performimg outer lock");
                       Thread.sleep(1500);
                       //second lock
                       reentrantLock.lock();
                       try
                       {
                            d = new Date();
                            s = new SimpleDateFormat("hh:mm:ss");
                           System.out.println("task name = " + name + "inner lock acquired at " + s.format(d) +
                                   "performimg inner lock");
                           Thread.sleep(1500);
                       }
                       catch(InterruptedException e)
                       {
                           e.printStackTrace();
                       }
                       finally
                       {
                           System.out.println("task name" + name+ "releasing inner lock");
                           reentrantLock.unlock();
                       }
                       System.out.println("Lock Hold Count =" + reentrantLock.getHoldCount());
                       done = true;
                   }
                   catch(InterruptedException e)
                   {
                       e.printStackTrace();
                   }
                   finally
                   {
                       System.out.println("task name = "+name+"Releasing outer lock");
                       reentrantLock.unlock();
                       System.out.println("Lock Hold Count =" + reentrantLock.getHoldCount());
                   }

               }
               else
               {
                   System.out.println("task name"+ name +"waiting for lock");
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
        }

    }
}

public class LockExample {
     public static void main (String args[])
     {
         ReentrantLock r1 = new ReentrantLock();
         ExecutorService executorService = Executors.newFixedThreadPool(5);
         Runnable runnable1 = new worker(r1, "job1");
         Runnable runnable2 = new worker(r1, "job2");
         Runnable runnable3 = new worker(r1, "job3");
         Runnable runnable4 = new worker(r1, "job4");
         Runnable runnable5 = new worker(r1, "job5");
         executorService.execute(runnable1);
         executorService.execute(runnable2);
         executorService.execute(runnable3);
         executorService.execute(runnable4);
         executorService.execute(runnable5);
         executorService.shutdown();

     }
}