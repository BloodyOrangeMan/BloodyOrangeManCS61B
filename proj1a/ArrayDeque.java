public class ArrayDeque<T> {
    private T[] item;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {
        this.item =(T[]) new Object[8];
        this.size = 0;
        this.nextFirst = 0;
        this.nextLast = 1;
    }

    public ArrayDeque(ArrayDeque other) {
        this.item = (T[]) new Object[other.item.length];
        System.arraycopy(other.item, 0, this.item, 0, other.item.length);
        this.size = other.size;
        this.nextLast = other.nextLast;
        this.nextFirst = other.nextFirst;
    }


    public void addFirst(T x) {
        if (size == item.length) {
            resize(size * 2);
        }
        item[this.nextFirst] = x;
        this.nextFirst = Math.floorMod(this.nextFirst - 1, item.length);
        this.size++;
    }

    public void addLast(T x) {
        if (size == item.length) {
            resize(size * 2);
        }
        item[this.nextLast] = x;
        this.nextLast = Math.floorMod(this.nextLast + 1, item.length);
        this.size++;
    }

    public void resize(int RFACTOR) {
        T[] a =(T[]) new Object[RFACTOR];
        System.arraycopy(this.item, 0, a, 0,this.size);
        item = a;
        this.nextLast = size;
        this.nextFirst = item.length - 1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        int j = Math.floorMod(this.nextFirst + 1, item.length);
        for(int i = 0; i < this.size ;i++) {
            System.out.print(item[j] + " ");
            j = Math.floorMod(j + 1, item.length);
        }
    }

    public T removeFirst() {
        this.nextFirst = Math.floorMod(this.nextFirst + 1, item.length);
        this.size--;
        return item[this.nextFirst];
    }

    public T removeLast() {
        this.nextLast = Math.floorMod(this.nextLast - 1, item.length);
        this.size--;
        return item[this.nextLast];
    }

    public T get(int index) {
        return item[Math.floorMod(this.nextFirst + 1 + index, item.length)];
    }

}
