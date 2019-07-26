package 数据结构.lianbiao.test;

/**
 * @className Node
 * @Description
 * @Date 2019/7/10 9:27
 * @Author shenguang
 * @Version 1.0
 **/
public class Node<K,V> {
    public K key;
    public V value;
    public Node next = null;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }


    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
