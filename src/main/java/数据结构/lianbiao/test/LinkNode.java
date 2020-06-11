package 数据结构.lianbiao.test;

/**
 * @className LinkNode
 * @Description
 * @Date 2019/7/10 9:47
 * @Author shenguang
 * @Version 1.0
 **/
public class LinkNode<K, V> {
    public Node<K, V> frist = null;

    public Node<K, V> getFrist() {
        return frist;
    }

    public void setFrist(Node<K, V> frist) {
        this.frist = frist;
    }

    public Node<K, V> getEnd(Node<K, V> frist) {
        if (isEmpty()) {
            return null;
        }
        if (null == frist.next) {
            return frist;
        }
        return getEnd(frist.next);

    }

    public void insertFrist(Node<K, V> node) {
        if (isEmpty()) {
            setFrist(node);
            return;
        }
        node.next = this.frist;
        this.frist = node;
    }

    public void insertLast(Node<K, V> node) {
        if (isEmpty()) {
            setFrist(node);
            return;
        }
        getEnd(frist).next = node;
    }

    public void delete(K key) {
        if (isEmpty()) {
            System.out.println("LinkNode is Null;");
        }

        Node<K, V> node = frist;

        Node<K, V> pre = frist;

        while (null !=node && !key.equals(node.key)) {
            pre = node;
            node = node.next;
        }
        if (null == node) {
            System.out.println("LinkNode not fund key : " + key);
            return;
        }
        if (node == frist) {
            this.frist = frist.next;
            return;
        } else {
            pre.next = node.next;
            return;
        }


    }


    public boolean isEmpty() {
        if (null == getFrist()) {
            return true;
        }
        return false;
    }

    public void displayAll() {
        if (isEmpty()) {
            System.out.println("LinkNode is Null;");
        }
        Node<K, V> node = frist;
        while (null != node) {
            System.out.println(node);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkNode<String, String> linkNode = new LinkNode<>();
        linkNode.insertLast(new Node<>("name", "张山"));
        linkNode.insertLast(new Node<>("name", "里斯"));
        linkNode.insertLast(new Node<>("name", "王五"));
        linkNode.insertLast(new Node<>("name", "赵六"));
        Node<String, String> node = new Node<>("name", "田七");
        linkNode.insertLast(node);
        linkNode.insertLast(new Node<>("name", "小八"));
        linkNode.insertLast(new Node<>("name", "小九"));
        Node<String, String> stringStringNode = new Node<>("name", "小时");
        stringStringNode.setNext(node);
        linkNode.insertLast(stringStringNode);
        Node<String, String> slow = linkNode.getFrist();
        Node<String, String> fast = linkNode.getFrist();

        for (;;){
            Node next = slow.getNext();
            Node next1 = fast.getNext().getNext();
            slow = next;
            fast = next1;
            if(slow==fast){
                System.out.println(next);
                break;
            }
        }


    }

}
