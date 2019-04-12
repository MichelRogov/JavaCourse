package Multithreading.ForkJoin.MergeSort;


import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class MergeForkJoinApp{

    public static void main(String[] args) {
        String[] a = "S O R T E X A M P L E".split(" ");
        MergeForkJoin mergeForkJoin = new MergeForkJoin(a, 0, a.length -1);
        sort(mergeForkJoin);
        System.out.println(Arrays.toString(mergeForkJoin.array));
    }


    public static void sort(MergeForkJoin mergeForkJoin) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(mergeForkJoin);
    }

}
