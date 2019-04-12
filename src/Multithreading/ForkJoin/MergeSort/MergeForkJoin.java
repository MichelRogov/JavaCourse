package Multithreading.ForkJoin.MergeSort;

import java.util.concurrent.RecursiveAction;

public class MergeForkJoin extends RecursiveAction {
    Comparable[] array;
    Comparable[] aux;
    int low;
    int high;

    public MergeForkJoin(Comparable[] array, int low, int high) {
        this.array = array;
        this.aux = new Comparable[array.length];
        this.low = low;
        this.high = high;
    }

    @Override
    protected void compute() {
        if (low >= high) return;
        int mid = low + (high-low)/2;
        MergeForkJoin left = new MergeForkJoin(array, low, mid);
        MergeForkJoin right = new MergeForkJoin(array, mid+1, high);
        invokeAll(left, right);
        merge(this.array, this.aux, this.low, mid, this.high);
    }


    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        // merge back to array[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
    }

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
