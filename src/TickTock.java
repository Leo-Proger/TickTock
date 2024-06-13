public class TickTock {
    public synchronized void tick(boolean isEnd) {
        if (isEnd) {
            notify();
            return;
        }
        System.out.print("Tick ");
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized void tock(boolean isEnd) {
        if (isEnd) {
            notify();
            return;
        }
        System.out.println("Tock");
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
