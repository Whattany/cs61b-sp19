public class LinkedListDeque<T> {
    private LinkedNode sentinel;
    private int size;
    private class LinkedNode {
        private LinkedNode prev;
        private T item;
        private LinkedNode next;
        LinkedNode(LinkedNode p, T i, LinkedNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }
    public LinkedListDeque() {
        sentinel = new LinkedNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
    public void addFirst(T item) {
        LinkedNode i = new LinkedNode(null, item, null);
        i.next = sentinel.next;
        i.prev = sentinel;
        sentinel.next.prev = i;
        sentinel.next = i;
        size = size + 1;
        if (size == 1) {
            sentinel.prev = i;
        }
    }
    public void addLast(T item) {
        LinkedNode i = new LinkedNode(null, item, null);
        i.prev = sentinel.prev;
        i.next = sentinel;
        sentinel.prev.next = i;
        sentinel.prev = i;
        size = size + 1;
    }
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        LinkedNode p = sentinel.next;
        for (; p != sentinel; p = p.next) {
            if (p == sentinel.next) {
                System.out.print(p.item);
            } else {
                System.out.print(" " + p.item);
            }
        }
    }
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T returnItem = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size = size - 1;
        return returnItem;
    }
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T returnItem = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size = size - 1;
        return returnItem;
    }
    public T get(int index) {
        LinkedNode p = sentinel.next;
        int i = 0;
        for (; p != sentinel; p = p.next) {
            if (i == index - 1) {
                return p.item;
            }
        }
        return null;
    }
    public T getRecursive(int index) {
        if (index > size) {
            return null;
        }
        LinkedNode p = sentinel.next;
        return helpRecursive(index, 0, p);

    }
    private T helpRecursive(int index, int i, LinkedNode p) {
        if (i == index - 1) {
            return p.item;
        } else {
            return helpRecursive(index, i + 1, p.next);
        }
    }
}
