
import java.util.ArrayList;
import java.util.Objects;


class HashMap<K, V> {

    private ArrayList<Node_H<K, V> > HashArray;


    private int hashCapacity;


    private int size;

    public HashMap()
    {
        HashArray = new ArrayList<>();
        hashCapacity = 10;
        size = 0;

        for (int i = 0; i < hashCapacity; i++)
            HashArray.add(null);
    }

    private final int hashCode (K key) {

        return Objects.hashCode(key);

    }

    private int getCell(K key)
    {
        int hashCode = hashCode(key);
        int index = hashCode % hashCapacity;
        index = index < 0 ? index * -1 : index;
        return index;
    }

    public int size() {

        return size;

    }
    public boolean isEmpty() {

        return size() == 0;

    }


    public V remove(K key)
    {
        int bucketIndex = getCell(key);
        int hashCode = hashCode(key);
        Node_H<K, V> head = HashArray.get(bucketIndex);

        Node_H<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key) && hashCode == head.hashCode)
                break;

            prev = head;
            head = head.next;
        }

        if (head == null)
            return null;

        size--;

        if (prev != null)
            prev.next = head.next;
        else
            HashArray.set(bucketIndex, head.next);

        return head.value;
    }

    public V get(K key)
    {
        int bucketIndex = getCell(key);
        int hashCode = hashCode(key);

        Node_H<K, V> head = HashArray.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode)
                return head.value;
            head = head.next;
        }

        return null;
    }

    public void add(K key, V value)
    {
        int bucketIndex = getCell(key);
        int hashCode = hashCode(key);
        Node_H<K, V> head = HashArray.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode) {
                head.value = value;
                return;
            }
            head = head.next;

        }

        size++;
        head = HashArray.get(bucketIndex);
        Node_H<K, V> newNode = new Node_H<K, V>(key, value, hashCode);
        newNode.next = head;
        HashArray.set(bucketIndex, newNode);

        if ((1.0 * size) / hashCapacity >= 0.7) {
            ArrayList<Node_H<K, V> > temp = HashArray;
            HashArray = new ArrayList<>();
            hashCapacity = 2 * hashCapacity;
            size = 0;
            for (int i = 0; i < hashCapacity; i++)
                HashArray.add(null);

            for (Node_H<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        HashMap<String, Integer> map = new HashMap<>();
        map.add("why", 99);
        map.add("inside", 33);
        map.add("five", 23);
        map.add("twenty", 44);
        map.add("emblem", 56);
        map.add("collision", 43);
        map.add("why though", 19);
        System.out.println(map.size());
        System.out.println(map.remove("why"));
        System.out.println(map.get("why though"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
}
