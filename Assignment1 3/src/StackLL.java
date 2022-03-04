import java.util.EmptyStackException;
public class StackLL<T> implements StackInterface<T> {

    NodeGeneric<T> top;


    int size = 0;

    StackLL() {
        top = null;
    }


    public void push(T a) throws FullStackException {
        if (size == 5)
            throw new FullStackException("PushingIntoFullStackException");

        NodeGeneric<T> temp = new NodeGeneric<T>();
        temp.data = a;
        temp.next = null;


        if (top == null) {
            top = temp;
        } else {
            temp.next = top;
            top = temp;
        }
        size++;
    }


    public T pop() throws EmptyStackException {
        if (size == 0)
            throw new EmptyStackException("EmptyStackException");
        T temp = (T) top.data;
        top = top.next;
        size--;
        return temp;
    }

    public T peek() {
        return (T) top.data;
    }


    public static void main(String[] args) {
        try {
            StackInterface<Integer> object_stack = new StackLL<Integer>();
            object_stack.push(5);
            object_stack.push(4);
            object_stack.push(3);
            object_stack.push(2);
            object_stack.push(1);
            object_stack.pop();
            System.out.println(object_stack.peek());
        } catch (FullStackException e) {
            System.out.println(e.getMessage());
        } catch (EmptyStackException e) {
            System.out.println(e.getMessage());
        }
    }
}
