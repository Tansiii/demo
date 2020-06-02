package blockingqueue;
// BlockingQueue implementation
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueue {

    private List queue = new LinkedList<String>();
    private int limit = 10;

    public BlockingQueue(int limit)
    {
        this.limit = limit;
    }

    public synchronized  void enqueue(String item)
    {
        while(this.queue.size() == limit)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(this.queue.size() == 0)
        {
            notifyAll();
        }
        System.out.println("Producing item = "+ item);
        this.queue.add(item);
    }

    public synchronized String dequeue()
    {
        while(queue.size()==0)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(queue.size() == limit)
        {
            notifyAll();
        }
        System.out.println("consuming item = "+ queue.get(0));
        return (String) this.queue.remove(0);

    }


}
