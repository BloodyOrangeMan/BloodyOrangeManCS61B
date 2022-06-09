public class LinkedListDeque<T> implements Deque<T>{
    private typeNode sentinel;
    private int size;
    public class typeNode {
        public typeNode prev;
        public T item;
        public typeNode next;

        public typeNode() {
            this.item = null;
            this.next = null;
            this.prev = null;
        }
        public typeNode(T x, typeNode _prev, typeNode _next) {
            this.item = x;
            this.prev = _prev;
            this.next = _next;
        }
    }

    public LinkedListDeque() {
        this.sentinel = new typeNode();
        this.sentinel.next = this.sentinel;
        this.sentinel.prev = this.sentinel;
        this.size = 0;
    }

    public LinkedListDeque(T x) {
        this.sentinel = new typeNode();
        this.sentinel.next = new typeNode(x,sentinel,sentinel);
        this.sentinel.prev = this.sentinel.next;
        this.size = 1;
    }

    public LinkedListDeque(LinkedListDeque other) {
        this.sentinel = new typeNode();
        this.sentinel.next = this.sentinel;
        this.sentinel.prev = this.sentinel;
        for (int i = 0; i < other.size; i++ ) {
            this.addLast((T) other.get(i));
        }
    }

    @Override
    public void addFirst(T x) {
        this.sentinel.next.prev = new typeNode(x, this.sentinel, this.sentinel.next);
        this.sentinel.next = this.sentinel.next.prev;
        this.size++;
    }

    @Override
    public void addLast(T x) {
        this.sentinel.prev.next = new typeNode(x, this.sentinel.prev,this.sentinel);
        this.sentinel.prev = this.sentinel.prev.next;
        this.size++;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void printDeque() {
        typeNode p = this.sentinel.next;
        while(p != this.sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    @Override
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        } else {
            typeNode tmp = this.sentinel.next;
            this.sentinel.next = this.sentinel.next.next;
            this.sentinel.next.prev = this.sentinel;
            this.size--;
            return tmp.item;
        }
    }

    @Override
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        } else {
            typeNode tmp = this.sentinel.prev;
            this.sentinel.prev = this.sentinel.prev.prev;
            this.sentinel.prev.next = this.sentinel;
            this.size--;
            return tmp.item;
        }
    }

    @Override
    public T get(int index) {
        if (this.isEmpty() || index > (this.size - 1)) {
            return null;
        } else {
            typeNode p = this.sentinel.next;
            for(int i = 0; i < index ; i++) {
                p = p.next;
            }
            return p.item;
        }
    }

    public T getRecursive(int index, typeNode p) {
        if (index == 0) {
            return p.item;
        } else {
            index--;
            return getRecursive(index, p.next);
        }
    }

    public T getRecursive(int index) {
        if (this.isEmpty() || index > (this.size - 1)) {
            return null;
        } else {
            return getRecursive(index, this.sentinel.next);
        }
    }


}
