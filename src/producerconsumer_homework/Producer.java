package producerconsumer_homework;

public class Producer implements Runnable {

    public static final int NUM_OF_ITERATIONS = 100;
    private SyncStack syncStack;
    private int number;

    public Producer(SyncStack syncStack, int number) {
        this.syncStack = syncStack;
        this.number = number;
    }

    @Override
    public void run() {
        char c;
        for (int i = 0; i < NUM_OF_ITERATIONS; i++) {
            c = (char) (Math.random() * 26 + 'A');
            syncStack.push(c);
            System.out.println("Producer " + number + " " + c +
                    ",  buffer size: " + syncStack.getBuffer().size());
            if (syncStack.getBuffer().size() == syncStack.getBuffer().capacity()) {
                System.out.println("Producer " + number + " is waiting...");
            }
            try {
                Thread.sleep((int) (Math.random() * 300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}