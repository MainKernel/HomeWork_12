import java.util.concurrent.*;


public class Task_1 {
    public static void main(String[] args) {
        RunnableTimer timer = new RunnableTimer();
        Thread t1 = new Thread(timer::secondTimer);
        Thread t2 = new Thread(timer::fiveSecondsTimer);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleAtFixedRate(t2, 5, 5, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(t1, 0, 1, TimeUnit.SECONDS);
    }
}

class RunnableTimer {
    public volatile long time = 0;
    private final long start = System.currentTimeMillis();

    public void secondTimer() {
        time = Math.round((System.currentTimeMillis() - start) / 1000F);
        if (time % 5 != 0) {
            System.out.println(time + " seconds passed");
        }
    }

    public void fiveSecondsTimer() {
        System.out.println("5 second passed....");
    }
}

