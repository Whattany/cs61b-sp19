public class ArrayDeque<T> {
    private int size;
    private int MAXSIZE = 8;
    private int front;
    private int rear;
    private T[] items;
    private final int REACTOR = 10;
    private final double RATE = 0.5;


    /** initialize array*/
    public ArrayDeque() {
        items = (T[]) new Object[MAXSIZE];
        size = 0;
        front = MAXSIZE / 2;
        rear = MAXSIZE / 2 + 1;
    }

    /** add first element */
    public  void addFirst(T item) {

        if (size >= MAXSIZE) {
            T[] a = (T[]) new Object[MAXSIZE + REACTOR];
            System.arraycopy(items, rear, a, REACTOR + rear, size - rear);
            System.arraycopy(items, 0, a, 0, front + 1);
            items = a;
            front = REACTOR + rear - 1;
            MAXSIZE = MAXSIZE + REACTOR;
        }
        items[front] = item;
        front = (MAXSIZE + front - 1) % MAXSIZE;
        size = size + 1;
    }

    public void addLast(T item) {
        if (size >= MAXSIZE) {
            T[] a = (T[]) new Object[MAXSIZE + REACTOR];
            System.arraycopy(items, rear, a, REACTOR + rear, size - rear);
            System.arraycopy(items, 0, a, 0, front + 1);
            items = a;
            front = REACTOR + rear - 1;
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
        if (size >= 16 && (((float) size) / MAXSIZE) < 0.25) {
            int newmax = (int) (MAXSIZE * RATE);
            T[] b = (T[]) new Object[newmax];
            if (front >= rear) {
                System.arraycopy(items, 0, b, 0, rear);
                System.arraycopy(items, (front + 1 + MAXSIZE) % MAXSIZE,
                        b, newmax - (MAXSIZE - front - 1), MAXSIZE - front - 1);
                items = b;
                front = newmax - (MAXSIZE - front);
            } else {
                System.arraycopy(items, 0, b, 0, rear - front - 1);
                items = b;
                front = newmax - 1;
                rear = rear - front;
            }
            MAXSIZE = newmax;
        }
        return value;

    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T value = items[(rear - 1 + MAXSIZE) % MAXSIZE];
        rear = (rear - 1 + MAXSIZE) % MAXSIZE;
        size = size - 1;
        if (size >= 16 && (((float) size) / MAXSIZE) < 0.25) {
            int newmax = (int) (MAXSIZE * RATE);
            T[] b = (T[]) new Object[newmax];
            if (front >= rear) {
                System.arraycopy(items, 0, b, 0, rear);
                System.arraycopy(items, (front + 1 + MAXSIZE) % MAXSIZE,
                        b, newmax - (MAXSIZE - front - 1), MAXSIZE - front - 1);
                items = b;
                front = newmax - (MAXSIZE - front);
            } else {
                System.arraycopy(items, 0, b, 0, rear - front - 1);
                items = b;
                front = newmax - 1;
                rear = rear - front;
            }
            MAXSIZE = newmax;
        }
        return value;
    }

    public T get(int index) {

        if (index >= size || index < 0) {
            return null;
        } else {
            return items[(index + front + 1) % MAXSIZE];
        }
    }
}
