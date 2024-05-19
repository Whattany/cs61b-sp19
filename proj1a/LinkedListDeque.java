public class LinkedListDeque<T> {
    private class LinkedNode {
        private LinkedNode prev;
        private T item;
        private LinkedNode next;

        public LinkedNode(LinkedNode p, T i, LinkedNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }
    private  LinkedNode sentinel;
    private int size;

    
    public LinkedListDeque() {
        sentinel = new LinkedNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
    public void addFirst(T item) {
        LinkedNode x = new LinkedNode(sentinel, item, sentinel.next);
        sentinel.next.prev = x;
        sentinel.next = x;
        size = size + 1;

    }

    public void addLast(T item) {
        LinkedNode x = new LinkedNode(sentinel.prev, item, sentinel);
        sentinel.prev.next = x;
        sentinel.prev = x;
        size = size + 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        LinkedNode ptr = sentinel.next;

        while (ptr != sentinel) {
            System.out.print(sentinel.item);
            System.out.print(' ');
            ptr = ptr.next;
        }
        System.out.println();

    }
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        LinkedNode temp = sentinel.next;
        T value = temp.item;
        temp.next.prev = sentinel;
        sentinel.next = temp.next;
        size = size - 1;
        return value;
    }
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        LinkedNode temp = sentinel.prev;
        T value = temp.item;
        temp.prev.next = temp.next;
        sentinel.prev = temp.prev;
        size = size - 1;
        return value;

    }
    public T get(int index) {
        LinkedNode ptr = sentinel.next;

        for (int i = 0; ptr != sentinel; i++) {
            if (i == index) {
                return ptr.item;
            }
        }
        return null;

    }

    public T getRecursive(int index) {
        LinkedNode ptr = sentinel.next;

        if (index >= size || index < 0) {
            return null;
        } else {
            return getRecursiveHelper(ptr, index, 0);
        }
    }

    private T getRecursiveHelper(LinkedNode ptr, int index, int n) {

        if (n == index) {
            return ptr.item;
        }
        return getRecursiveHelper(ptr.next, index, n + 1);
    }
}
