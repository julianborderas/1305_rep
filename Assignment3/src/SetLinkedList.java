public class SetLinkedList {

    int size = 0;
    Node head;

    boolean contains(int a) {
        Node h = head;
        while(h != null){
            if(h.data == a)
                return true;
            h = h.next;
        }
        return false;
    }

    boolean isEmpty(){
        return size == 0;
    }


    void add(int a){
        Node aNode = new Node();
        aNode.data = a;
        if(!contains(a)){
            aNode.next = head;
            head = aNode;
            size++;
        }
    }

    void remove(int a) {
        if(contains(a)){
            Node h = head;
            Node prev = h;
            while(h != null){
                if(a == h.data)
                    break;
                prev = h;
                h = h.next;
            }
            prev.next = h.next;
            size--;
        }
    }

    int getSize(){
        return size;
    }

    Integer[] toArray(){
        Integer[]diff_arr = new Integer[size];
        Node h = head;
        int count = 0;
        while(h != null) {
            diff_arr[count++] = h.data;
            h = h.next;
        }
        return  diff_arr;
    }

    static SetLinkedList intersection(SetLinkedList setA, SetLinkedList setB) {
        SetLinkedList inter = new SetLinkedList();
        Integer[] setA_newarray = setA.toArray();
        for(int i = 0 ;  i < setA_newarray.length ; i++){
            if(setB.contains(setA_newarray[i]))
                inter.add(setA_newarray[i]);
        }
        return inter;
    }

    public static void main(String[] args) {
        SetLinkedList setA = new SetLinkedList();

        setA.add(4);
        setA.add(20);
        setA.add(7);
        setA.add(32);
        setA.add(10);
        setA.add(15);

        SetLinkedList setB = new SetLinkedList();

        setB.add(3);
        setB.add(23);
        setB.add(20);
        setB.add(9);
        setB.add(15);

        SetLinkedList intSet = intersection(setA,setB);

        intSet.getSize();


    }
}
