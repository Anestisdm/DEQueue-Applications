public class HeapSort {

    private City list [];
    private int N = City.getCount();

    public HeapSort(City array[]){
        this.list=array;
    }

    public void sort(){
        for (int k = N/2; k >= 1; k--)
            sink(k, N);
        while (N > 1) {
            swap(1, N);
            sink(1, --N);
        }
    }

    private void sink(int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+1)>0) j++;
            if (!(less(k, j)>0)) break;
            swap(k, j); k = j; }
    }
    private int less(int i, int j) {
        return list[i].compareTo(list[j]); }

    private void swap(int i, int j) {
        City tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }

}



