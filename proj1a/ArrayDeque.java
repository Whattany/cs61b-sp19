public class ArrayDeque<T> {
    private int size;
    private int MAXSIZE = 8;
    private int front;
    private int rear;
    private T[] items;
    private final double FACTOR = 0.25;


    /** initialize array*/
    public ArrayDeque() {
        items = (T[]) new Object[MAXSIZE];
        size = 0;
        front = MAXSIZE / 2;
        rear = MAXSIZE / 2 + 1;
    }

    private void resizelarger(int length) {
        T[] a = (T[]) new Object[length];
        System.arraycopy(items, rear, a, length - size + rear, size - rear);
        System.arraycopy(items, 0, a, 0, (front + 1) % MAXSIZE);
        items = a;
        front = length - size + rear - 1;
        MAXSIZE = length;
    }
    private void resizesmaller(int length) {
        T[] b = (T[]) new Object[length];
        if (front >= rear) {
            System.arraycopy(items, 0, b, 0, rear);
            System.arraycopy(items, (front + 1 + MAXSIZE) % MAXSIZE,
                    b, length - (MAXSIZE - front - 1), MAXSIZE - front - 1);
            front = length - (MAXSIZE - front);
        } else {
            System.arraycopy(items, front + 1, b, 0, rear - front - 1);
            front = length - 1;
            rear = rear - front;
        }
        items = b;
        MAXSIZE = length;

        // null null 1 2 3 4 8 null null
    }


    /** add first element */
    public  void addFirst(T item) {
        // resize larger
        if (size >= MAXSIZE) {
            resizelarger(MAXSIZE * 2);
        }
        items[front] = item;
        front = (MAXSIZE + front - 1) % MAXSIZE;
        size = size + 1;
    }

    public void addLast(T item) {
        if (size >= MAXSIZE) {
            resizelarger(MAXSIZE * 2);
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
        items[(front + 1 + MAXSIZE) % MAXSIZE] = null;
        front = (front + 1 + MAXSIZE) % MAXSIZE;
        size = size - 1;
        if (MAXSIZE >= 16 && (((double) size) / MAXSIZE) < FACTOR) {
            resizesmaller(MAXSIZE / 2);
        }
        return value;

    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T value = items[(rear - 1 + MAXSIZE) % MAXSIZE];
        items[(rear - 1 + MAXSIZE) % MAXSIZE] = null;
        rear = (rear - 1 + MAXSIZE) % MAXSIZE;
        size = size - 1;
        if (MAXSIZE >= 16 && (((double) size) / MAXSIZE) < FACTOR) {
            resizesmaller(MAXSIZE / 2);
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
