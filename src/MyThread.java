public class MyThread implements Runnable {
    Thread thread;
    TickTock tickTock;

    private MyThread(String name, TickTock tickTock) {
        thread = new Thread(this, name);
        this.tickTock = tickTock;
    }

    public static MyThread createAndStart(String name, TickTock tickTock) {
        MyThread myThread = new MyThread(name, tickTock);
        myThread.thread.start();
        return myThread;
    }

    public void run() {
        int count = 3;
        try {
            if (thread.getName().equals("Tick")) {
                for (int i = 0; i < count; i++) {
                    tickTock.tick(false);
                    Thread.sleep(1000);
                }
                tickTock.tick(true);
            } else {
                for (int i = 0; i < count; i++) {
                    Thread.sleep(1000);
                    tickTock.tock(false);
                }
                tickTock.tock(true);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
