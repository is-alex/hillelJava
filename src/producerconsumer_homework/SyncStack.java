package producerconsumer_homework;

import java.util.Vector;


public class SyncStack {

    private Vector buffer = new Vector(400, 200);

    public Vector getBuffer() {
        return buffer;
    }

    public synchronized void push(char c) {

        while (buffer.size() == buffer.capacity()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        buffer.addElement(c);
        this.notifyAll();
    }

    public synchronized char pop() {
        while (buffer.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        return (char) (buffer.remove(buffer.size() - 1));
    }

}