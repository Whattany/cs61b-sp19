public class ArrayDeque<T> {
    private int MAXSIZE = 8;
    private int RFACTOR = 2;
    private int front;
    private int rear;
    private int size;
    private T[] items;
    private double factor = 0.25;
    public ArrayDeque() {
        items = (T[]) new Object[MAXSIZE];
        front = 0;
        rear = 0;
        size = 0;
    }
    private void resize(int cap) {
        T[] a = (T[]) new Object[cap];
        int p = (front + 1 + MAXSIZE) % MAXSIZE;
        for (int i = 0; i < size; i++) {
            a[i] = items[p];
            p = (p + 1 + MAXSIZE) % MAXSIZE;
        }
        items = a;
        front = a.length - 1;
        rear = size - 1;
    }
    public void addFirst(T item) {
        if (size >= MAXSIZE) {
            resize(MAXSIZE * RFACTOR);
            MAXSIZE = MAXSIZE * RFACTOR;
        }
        items[front] = item;
        front = (front - 1 + MAXSIZE) % MAXSIZE;
        size = size + 1;
    }
    public void addLast(T item) {
        if (size >= MAXSIZE) {
            resize(MAXSIZE * RFACTOR);
            MAXSIZE = MAXSIZE * RFACTOR;
        }
        rear = (rear + 1 + MAXSIZE) % MAXSIZE;
        items[rear] = item;
        size = size + 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        int index = (front + 1 + MAXSIZE) % MAXSIZE;
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                System.out.print(items[index]);
            } else {
                index = (index + 1 + MAXSIZE) % MAXSIZE;
                System.out.print(" " + items[index]);
            }
        }
    }
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if ((((double) size) / MAXSIZE) < factor) {
            resize(MAXSIZE / RFACTOR);
            MAXSIZE = MAXSIZE / RFACTOR;
        }
        front = (front + 1 + MAXSIZE) % MAXSIZE;
        T retItem = items[front];
        items[front] = null;
        size = size - 1;
        return retItem;
    }
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if ((((double) size) / MAXSIZE) < factor) {
            resize(MAXSIZE / RFACTOR);
            MAXSIZE = MAXSIZE / RFACTOR;
        }
        T retItem = items[rear];
        items[rear] = null;
        size = size - 1;
        rear = (rear - 1 + MAXSIZE) % MAXSIZE;
        return retItem;
    }
    public T get(int index) {
        if (index > size - 1) {
            return null;
        } else {
            int p = front;
            for (int i = 0; i <= index; i++) {
                p = (p + 1 + MAXSIZE) % MAXSIZE;
            }
            return items[p];
        }
    }
}
