package Multithreading.VolatileSources;

public class VolatileSources extends Thread {
    private volatile boolean running = true;

    public void run() {
        while (running) {
            System.out.println("Running");
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread stopped");
    }

    public void shutDown() {
        running = false;
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {
        VolatileSources vl = new VolatileSources();
        vl.start();

        Thread.sleep(3000);
        System.out.println("Going to set the stop flag to true");
        vl.shutDown();
    }
}
