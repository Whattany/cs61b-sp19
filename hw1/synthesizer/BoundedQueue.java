package synthesizer;
import java.util.Iterator;
public interface BoundedQueue<T> extends Iterable<T> {
    int capacity();
    int fillCount();
    void enqueue(T x);
    T dequeue();
    T peek();

    default boolean isEmpty() {
        return fillCount() == 0;
    }
    default boolean isFull() {
        return capacity() == fillCount();
    }
    Iterator<T> iterator();
}
