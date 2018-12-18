package Multithreading.ForkJoin.MergeSort;

import java.util.concurrent.RecursiveAction;

public class MergeForkJoin extends RecursiveAction {
    Comparable[] a;
    Comparable[] aux;
    int low;
    int high;

    public MergeForkJoin(Comparable[] a, int low, int high) {
        this.a = a;
        this.aux = new Comparable[a.length];
        this.low = low;
        this.high = high;
    }

    @Override
    protected void compute() {
        if (low >= high) return;
        int mid = low + (high-low)/2;
        MergeForkJoin left = new MergeForkJoin(a, low, mid);
        MergeForkJoin right = new MergeForkJoin(a, mid+1, high);
        invokeAll(left, right);
        merge(this.a, this.aux, this.low, mid, this.high);
    }


    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        // merge back to a[]
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
