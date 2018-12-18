package Multithreading.ForkJoin.ArrayCounter;

import java.util.concurrent.RecursiveTask;

public class ArrayCounter extends RecursiveTask<Integer> {

    int[] array;
    int threshold = 100000;
    int start;
    int end;

    public ArrayCounter(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start < threshold) {
            return computeDirectly();
        } else {
            int middle = start + (end - start) / 2;

            ArrayCounter left = new ArrayCounter(array, start, middle);
            ArrayCounter right = new ArrayCounter(array, middle + 1, end);

            invokeAll(left, right);

            return left.join() + right.join();
        }
    }

    private Integer computeDirectly() {
        Integer count = 0;

        for (int i = start; i < end; i++) {
            if(array[i] % 2  == 0) {
                count ++;
            }
        }

        return count;
    }


}
