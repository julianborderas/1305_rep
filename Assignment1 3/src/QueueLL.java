import java.util.LinkedList;
import java.util.Queue;
public class QueueLL<T> implements QueueInterface<T> {

    NodeGeneric<T> front;
    NodeGeneric<T> back;
    int size;

    public void insert(T a) throws FullQueueException{
        if (size == 5)
            throw new QueueInterface.FullQueueException("PushingIntoFullStackException");
        NodeGeneric<T> new_node = new NodeGeneric<T>();
        new_node.data = a;

        if ( front == null && back == null ) {
            front =  new_node;
            back =  new_node;
        }
        else{
            back.next = new_node;
            back = new_node;
        }
        size++;
    }


    public T remove() throws EmptyQueueException {
        if (size == 0)
            throw new EmptyQueueException("EmptyQueueException");
        front = front.next;
        back.next = front;
        size--;
        return null;
    }



    public T peek() {
        return front.data;
    }

    public static void main(String[] args) {
        try {
            QueueInterface<Integer> obj = new QueueLL<Integer>();
            obj.insert(1);
            obj.insert(5);
            obj.insert(8);
            obj.insert(1);
            obj.insert(5);
            obj.insert(8);
            obj.insert(1);

            obj.remove();
        } catch (QueueInterface.FullQueueException e) {
            System.out.println(e.getMessage());
        } catch (QueueInterface.EmptyQueueException e) {
            System.out.println(e.getMessage());
        }
    }

}
