
import java.util.EmptyStackException;

public class MyStack<T> {

    private static class StackNode<T> {

        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;
    private int capacity;

    public MyStack() {
        capacity = 0;
    }

    void sort(MyStack<Integer> s) {
        MyStack<Integer> r = new MyStack<Integer>();
        while (!s.isEmpty()) {
            /* Insert each element in s in reversed sorted order into r. */
            int tmp = s.pop();
            while (!r.isEmpty() && r.peek() > tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }

        /* Copy the elements from r back into s. */
        while (!r.isEmpty()) {
            s.push(r.pop());
             }
    }

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {

        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
        capacity++;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
