package warmup;


import java.util.Stack;

public class TwoStackQueue<E> {

    private final Stack<E> inbox = new Stack<>();
    private final Stack<E> outbox = new Stack<>();


    public void queue(E item) {
        inbox.push(item);
    }

    public E dequeue() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }

        return outbox.pop();
    }
}

