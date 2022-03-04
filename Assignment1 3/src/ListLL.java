import java.util.LinkedList;
import java.util.List;
public class ListLL<T> implements ListInterface<T> {
    NodeGeneric<T> first;
    NodeGeneric<T> last;
    int size = 0;

    public void add(T a) throws FullListException{
        NodeGeneric<T> new_node = new NodeGeneric<>();
        new_node.data = a;
        new_node.next = null;

        if(size == 0) {
            first = new_node;
            last = new_node;
        }
        else {
            last.next = new_node;
            last = new_node;
        }
        size++;
    }
    public void addto(int position, T a) {
        NodeGeneric<T> new_node = new NodeGeneric<>();
        new_node.data = a;
        new_node.next = null;

        NodeGeneric<T> x = first.next;
        NodeGeneric<T> y = first;

        while(position - 2 > 0 ){
            y = x;
            x = y.next;
            position--;
        }
        new_node.next = x;
        y.next = new_node;

        size++;
    }



    public T remove (int position) {
        first = first.next;
        size--;
        return null;
    }

    public T get(int position){
        NodeGeneric<T> iterator = new NodeGeneric<>();
        iterator = first;
        while(position > 0) {
            position--;
        }
        return iterator.data;
    }
    public int get_size() {return size; }

    public static void main(String[] args) {
        try {
            ListInterface<Integer> obj = new ListLL<Integer>();
            obj.add(5);
            obj.add(4);
            obj.add(3);
            obj.add(2);
            obj.add(1);
            obj.remove(3);
            System.out.println(obj.get_size());
        } catch (ListInterface.FullListException e) {
            System.out.println(e.getMessage());
        } catch (ListInterface.EmptyListException obj){
            System.out.println(obj.getMessage());
        }


    }

}
