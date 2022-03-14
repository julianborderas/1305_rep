import java.util.LinkedList;
import java.util.Queue;
public interface QueueInterface <T>{

    public class FullQueueException extends Exception{
        public FullQueueException(String errorMessage) {
            super(errorMessage);
        }
    }

    public void insert(T a) throws QueueInterface.FullQueueException;

    public class EmptyQueueException extends Exception{
        public EmptyQueueException(String errorMessage) { super(errorMessage); }
    }
    public T remove() throws QueueInterface.EmptyQueueException;

    public T peek();
}
