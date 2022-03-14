
public interface StackInterface<T>
{
    public class FullStackException extends Exception{
        public FullStackException(String errorMessage) {
            super(errorMessage);
        }
    }

    public void push(T a) throws FullStackException;

    public class EmptyStackException extends Exception{
        public EmptyStackException(String errorMessage) { super(errorMessage); }
    }
    public T pop() throws EmptyStackException;

    public T peek();


}
