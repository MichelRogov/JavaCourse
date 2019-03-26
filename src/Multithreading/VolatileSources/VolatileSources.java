package Multithreading.VolatileSources;

public class VolatileSources extends Thread {
    private VolatileData data;

    public VolatileSources(VolatileData data) {
        this.data = data;
    }

    public void run() {
        while (data.isRunning()) {
            System.out.println("Running");
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread " + Thread.currentThread().getId() + " stopped");
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {
        VolatileData data = new VolatileData();
        VolatileSources t = new VolatileSources(data);
        VolatileSources t2 = new VolatileSources(data);
        VolatileSources t3 = new VolatileSources(data);

        t.start();
        t2.start();
        t3.start();

        Thread.sleep(3000);
        System.out.println("Going to set the stop flag to true");
        data.shutDown();
    }
}

class VolatileData {
    private volatile boolean running = true;

    public boolean isRunning() {
        return running;
    }

    public void shutDown() {
        running = false;
    }
}