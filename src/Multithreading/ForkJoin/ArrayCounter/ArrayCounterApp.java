package Multithreading.ForkJoin.ArrayCounter;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ArrayCounterApp {

    static final int SIZE = 10000000;
    static int[] array = randomArray();

    public static void main(String[] args) {
        ArrayCounter arrayCounter = new ArrayCounter(array, 0, SIZE);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Integer sum = forkJoinPool.invoke(arrayCounter);

        System.out.println(" Number of even numbers: " + sum);
    }

    private static int[] randomArray() {
        int[] array = new int[SIZE];
        Random random = new Random();

        for (int i = 0; i < SIZE; i++){
            array[i] = random.nextInt(100);
        }

        return array;
    }
}
