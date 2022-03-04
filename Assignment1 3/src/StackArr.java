import java.util.EmptyStackException;
public class StackArr<T> implements StackInterface<T> {
    T [] arr;

    public StackArr(){
        arr = (T[]) new Object[100];
    }
    int top = -1;
    int size = 0;

    public void push( T a ) throws FullStackException {
        if (size == 5)
            throw new FullStackException("FullStackException");
        top++;
        arr[top] = a;
        size++;
    }
    public T pop() throws EmptyStackException{
        if(size == 0)
            throw new EmptyStackException("EmptyStackException");
        T temp = arr[top];
        top--;
        size--;
        return temp;
    }
    public T peek() {return arr[top];}

    public static void main(String[] args){
        try {
            StackArr<Object> object_stack = new StackArr<Object>();
            object_stack.push(5);
            object_stack.push(4);
            object_stack.push(3);
            object_stack.push(2);
            object_stack.push(2);
            object_stack.pop();
            System.out.println(object_stack.peek());
        } catch (FullStackException e) {
            System.out.println(e.getMessage());
        } catch (EmptyStackException obj){
            System.out.println(obj.getMessage());
        }

    }
}
