public class PQ {

    private City[] heap;
    private int count;
    private int[] Id = new int[999];

    private static final int Default_Capacity = 4;
    private static final int Autogrow_Size = 4;

    public PQ() {
        this.heap = new City[Default_Capacity + 1];
        this.count = 0;
    }
    public PQ(int capacity) {
        this.heap = new City[2*capacity];
        this.count = 0;
    }

    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return count;
    }

    public void insert(City item) {
        if (count == heap.length - 1) {
            resize();
        }
        heap[++count] = item;
        Id[item.getID()] = count;
        swim(count);
    }

    public City max() {
        if (isEmpty()) {
            return null;
        }
        return heap[1];
    }

    public City min(){
        City min=heap[count];
        int i = count-1;
        while (2*i>count){
            if (heap[i].compareTo(min)<0){
                min=heap[i];
            }
            i--;
        }
        return min;
    }

    public City getMax() {
        if (isEmpty()) {
            return null;
        }
        City root = heap[1];
        Id[root.getID()] = 0;
        heap[1] = heap[count];
        count--;
        sink(1);
        return root;
    }

    public City remove(int id) {
        if (isEmpty()) {
            return null;
        }
        int position = Id[id];
        City item = heap[position];
        swap(position,count);
        Id[heap[count].getID()]=0;
        count--;
        sink(position);
        swim(position);
        return item;

    }

    public void resize() {
        City[] newHeap = new City[heap.length + Autogrow_Size];
        for (int i = 0; i <= count; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }

    public void swim(int position){
        if (position == 1) {
            return;
        }
        int parent = position / 2;

        while (position != 1 && (heap[position].compareTo(heap[parent]) > 0)) {
            swap(position, parent);
            position = parent;
            parent = position / 2;
        }
    }

    public void sink(int position){
        int left = 2 * position;
        int right = left + 1;
        if (left > count)
            return;

        while (left <= count) {
            int max = left;
            if (right <= count) {
                if (heap[left].compareTo(heap[right]) < 0)
                    max = right;
            }
            if (heap[position].compareTo(heap[max]) > 0)
                return;
            else {
                swap(position, max);
                position = max;
                left = position * 2;
                right = left + 1;
            }
        }
    }

    private void swap(int i, int j) {
        City tmp1 = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp1;

        int tmp2 = Id[heap[i].getID()];
        Id[heap[i].getID()]=Id[heap[j].getID()];
        Id[heap[j].getID()]=tmp2;

    }

}
