import java.util.EmptyStackException;
import java.util.ArrayList;
import java.util.List;

public class ListArr<T> implements ListInterface<T> {
    T[] arr;
    int size = 0;

    public ListArr() {
        arr = (T[]) new String[10];
    }

    public void addto(int position, T a) throws FullListException {
        if (size == 5) {
            throw new FullListException("FullListException");
        }
        if (position < size) {
            for (int i = size; i >= position; i--) {
                arr[i + 1] = arr[i];
            }
        }
        arr[position] = a;
        size++;
    }

    public void add(T a) throws FullListException {
        arr[size + 1] = a;
        size++;
    }

    public T remove(int position) throws EmptyListException {
        if (size == 0) {
            throw new EmptyListException("EmptyListException");
        }
        if (position < size) {
            for (int i = position; i < size; i++) {
                arr[i] = arr[i + 1];
            }
        }
        size--;
        return null;
    }

    public T get(int position) {
        return arr[position];
    }


    public int get_size() {
        return size;
    }

    public static void main(String[] args) {
        try {
            ListInterface<String> obj = new ListArr<String>();
            obj.add("Who");
            obj.add("Let");
            obj.add("The");
            obj.add("Dogs");
            obj.add("Out");
            obj.addto(3, "I");
            for (int i = 1; i <= obj.get_size(); i++) {
                System.out.println(obj.get(i));
            }
        } catch (ListInterface.FullListException e) {
            System.out.println(e.getMessage());
        } catch (ListInterface.EmptyListException obj) {
            System.out.println(obj.getMessage());
        }

    }
}
