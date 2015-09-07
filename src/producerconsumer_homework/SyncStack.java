package producerconsumer_homework;

import java.util.Vector;


public class SyncStack {
    private Vector buffer = new Vector(400, 200);

    public synchronized void push(char c) {
        buffer.addElement(c);
        this.notify();
        //TODO doesn't wait if produced too much
    }

    public synchronized char pop() {
        while (buffer.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return (char) (buffer.remove(buffer.size() - 1));
    }
}