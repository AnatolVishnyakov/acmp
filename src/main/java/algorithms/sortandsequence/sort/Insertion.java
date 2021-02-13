package algorithms.sortandsequence.sort;

class Insertion extends AbstractSort {
    public void sort(Comparable[] a) {
        int n = a.length;
        show(a);
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
            System.out.print(i + " ");
            show(a);
        }
    }
}
