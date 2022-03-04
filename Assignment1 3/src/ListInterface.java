
public interface ListInterface <T> {

    public class FullListException extends Exception{
        public FullListException(String errorMessage) {
            super(errorMessage);
        }
    }

    public void add(T a) throws ListInterface.FullListException;

    public class EmptyListException extends Exception{
        public EmptyListException(String errorMessage) { super(errorMessage); }
    }
    public T remove( int position) throws ListInterface.EmptyListException;

    public T get(int position);

    public void addto(int num , T a) throws ListInterface.FullListException;

    public int get_size() throws ListInterface.EmptyListException;

}
