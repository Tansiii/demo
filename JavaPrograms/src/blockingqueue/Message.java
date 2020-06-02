package blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Message {

    private String msg;
    public Message(String msg)
    {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static void main(String args[])
    {
        BlockingQueue<Message> abq = new ArrayBlockingQueue(10);
        new Thread(new Producer(abq)).start();
        new Thread(new Consumer(abq)).start();
    }
}
