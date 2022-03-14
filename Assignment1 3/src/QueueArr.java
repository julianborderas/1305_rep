import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class QueueArr<T> implements QueueInterface<T> {
    T [] arr;
    int size = 0;

    public QueueArr(){
        arr = (T[]) new Object[100];
    }
    int num = 0;
    int front = 0;


    public T peek() {
        return arr[front];
    }

    public void insert(T a) throws FullQueueException {
        if (size == 5)
            throw new QueueInterface.FullQueueException("PushingIntoFullStackException");
        arr[(front + num) % arr.length] = a;
        num = num + 1;
        size++;
    }

    public T remove() throws EmptyQueueException {
        if (size == 0)
            throw new EmptyQueueException("EmptyQueueException");
        front = (front + 1) % arr.length;
        num = num - 1;
        size--;
        return null;
    }

    public static void main(String[] args) {

        try {
            QueueInterface<Object> obj = new QueueArr<Object>();
            obj.insert(5);
            obj.insert(4);
            obj.insert(3);
            obj.insert(2);
            obj.insert(1);
            obj.remove();
            System.out.println(obj.peek());
        } catch (QueueInterface.FullQueueException e) {
            System.out.println(e.getMessage());
        } catch (QueueInterface.EmptyQueueException obj){
            System.out.println(obj.getMessage());
        }

    }

}
