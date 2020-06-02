package MultiThreading.Deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Employee
{
    String name ;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class ReadWrite implements Runnable
{
    private Employee employee;
    boolean readwrite;
    String name ;
    ReadWrite(boolean readwrite , Employee e , String name)
    {
        this.readwrite = readwrite;
        this.employee = e;
        this.name = name;

    }
    @Override
    public void run() {
        if(readwrite)
        {
            writeResource(employee ,name);
        }
        else
            {
            readResource(employee);
        }

    }


    private static ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.WriteLock wlock = rwlock.writeLock();
    private static ReentrantReadWriteLock.ReadLock rlock = rwlock.readLock();

    public void readResource(Employee employee)
    {
        rlock.lock();
        try
        {

            System.out.println("Inside Read lock"  + employee.getName());
            Thread.sleep(1500);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally {
            rlock.unlock();
        }
    }

    public void writeResource(Employee employee ,String name)
    {
        wlock.lock();
        try
        {
            employee.setName(name);
            System.out.println("Inside Write lock" +name);
            Thread.sleep(1500);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally {
            wlock.unlock();
        }
    }
}

public class ReadWriteLockExample {

    public static void main(String args[])
    {
        boolean readwriteVal = true;
       /* ReadWrite.Employee employee = new ReadWrite().new Employee();
        Thread t3 = new Thread(()-> new ReadWrite().writeResource(employee , Thread.currentThread().getName()));
        t3.start();
        Thread t4 = new Thread(()-> new ReadWrite().writeResource(employee , Thread.currentThread().getName()));
        t4.start();
        Thread t1 = new Thread(()-> new ReadWrite().readResource(employee ,));
        t1.start();
        Thread t2 = new Thread(()-> new ReadWrite().readResource(employee));
        t2.start();*/

        ReentrantLock r1 = new ReentrantLock();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable runnable1 = new ReadWrite(true ,new Employee(),Thread.currentThread().getName());
        Runnable runnable2 = new ReadWrite(true ,new Employee(),Thread.currentThread().getName());
        Runnable runnable3 = new ReadWrite(false,new Employee(),Thread.currentThread().getName());
        Runnable runnable4 = new ReadWrite(false ,new Employee(),Thread.currentThread().getName());
        Runnable runnable5 = new ReadWrite(false ,new Employee(),Thread.currentThread().getName());
        executorService.execute(runnable1);
        executorService.execute(runnable2);
        executorService.execute(runnable3);
        executorService.execute(runnable4);
        executorService.execute(runnable5);
        executorService.shutdown();

    }
}


