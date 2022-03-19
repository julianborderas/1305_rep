public class Node_H<K,V> {

    K key;
    V value;
    final int hashCode;

    Node_H<K, V> next;

    public Node_H(K key, V value, int hashCode)
    {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }



}
