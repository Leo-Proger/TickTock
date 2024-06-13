public class Main {
    public static void main(String[] args) {
        TickTock tickTock = new TickTock();

        MyThread thread1 = MyThread.createAndStart("Tick", tickTock);
        MyThread thread2 = MyThread.createAndStart("Tock", tickTock);

        try {
            thread1.thread.join();
            thread2.thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
