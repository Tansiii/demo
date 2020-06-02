package blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<Message> bq ;

    public Producer(BlockingQueue<Message> bq)
    {
        this.bq = bq;
    }

    @Override
    public void run() {
            for(int i=0 ; i<100 ; i++)
            {
                Message m = new Message(""+i);
                try {
                    Thread.sleep(i);
                    bq.put(m);
                    System.out.println("Producing Thread " + m.getMsg());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message m1 = new Message("exit");
            try {
            bq.put(m1);
            }
            catch (InterruptedException e) {
            e.printStackTrace();
            }
    }
}
