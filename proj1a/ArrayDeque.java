public class ArrayDeque<T> {
    private int size;
    private int MAXSIZE = 8;
    private int front;
    private int rear;
    private T[] items;
    private int REACTOR = 10;


    /** initialize array*/
    public ArrayDeque() {
        items = (T[]) new Object[MAXSIZE];
        size = 0;
        front = MAXSIZE / 2;
        rear = MAXSIZE / 2 + 1;
    }

    /** add first element */
    public void addFirst(T item) {

        if (size > MAXSIZE) {
            T[] a = (T[]) new Object[MAXSIZE + REACTOR];
            System.arraycopy(items, 0, a, 0, front + 1);
            System.arraycopy(items, rear, a, size, size - rear);
            items = a;
            rear = size;
            MAXSIZE = MAXSIZE + REACTOR;
        }
        items[front] = item;
        front = (MAXSIZE + front - 1) % MAXSIZE;
        size = size + 1;
    }

    public void addLast(T item) {
        if (size > MAXSIZE) {
            T[] a = (T[]) new Object[MAXSIZE + REACTOR];
            System.arraycopy(items, 0, a, 0, size);
            items = a;
            MAXSIZE = MAXSIZE + REACTOR;
        }
        items[rear] = item;
        rear = (MAXSIZE + rear + 1) % MAXSIZE;
        size = size + 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                System.out.print(items[(i + front + 1) % MAXSIZE] + " ");
            }
            System.out.println();
        }
    }

    /*remove element from front*/
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T value = items[(front + 1 + MAXSIZE) % MAXSIZE];
        front = (front + 1 + MAXSIZE) % MAXSIZE;
        size = size - 1;
        return value;

    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T value = items[(rear - 1 + MAXSIZE) % MAXSIZE];
        rear = (rear + 1 + MAXSIZE) % MAXSIZE;
        size = size - 1;
        return value;
    }

    public T get(int index) {

        if (index > items.length || index < 0) {
            return null;
        }
        if (size > 0) {
            return items[(index + front + 1) % MAXSIZE];
        }
        return null;
    }
}
