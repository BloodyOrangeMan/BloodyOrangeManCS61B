public class LinkedListDeque<T> {
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

    public void addFirst(T x) {
        this.sentinel.next.prev = new typeNode(x, this.sentinel, this.sentinel.next);
        this.sentinel.next = this.sentinel.next.prev;
        this.size++;
    }

    public void addLast(T x) {
        this.sentinel.prev.next = new typeNode(x, this.sentinel.prev,this.sentinel);
        this.sentinel.prev = this.sentinel.prev.next;
        this.size++;
    }

    public boolean isEmpty() {

        return this.sentinel.next == this.sentinel.prev;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        typeNode p = this.sentinel.next;
        while(p != this.sentinel) {
            System.out.println(p.item);
            p = p.next;
        }
    }

    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        } else {
            this.sentinel.next = this.sentinel.next.next;
            this.sentinel.next.prev = this.sentinel;
            return this.sentinel.next.item;
        }
    }

    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        } else {
            this.sentinel.prev = this.sentinel.prev.prev;
            this.sentinel.prev.next = this.sentinel;
            return this.sentinel.prev.item;
        }
    }

}
