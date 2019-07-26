package 算法;

public class ListNode {
    int val;
    ListNode next =null;

    ListNode(int x) {
        val = x;
    }
    public ListNode add(int val){
        ListNode temp = this;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next=new ListNode(val);
        return  this;
    }
    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}