package blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private BlockingQueue bq;

    public Consumer(BlockingQueue bq)
    {
        this.bq=bq;
    }
    @Override
    public void run() {
        try{
            Message msg;
            //consuming messages until exit message is received
            while((msg = (Message) bq.take()).getMsg() !="exit"){
                Thread.sleep(10);
                System.out.println("Consumed "+msg.getMsg());
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
