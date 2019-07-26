package 数据结构.erchatree.test;

/**
 * @className ErNode
 * @Description
 * @Date 2019/7/15 14:11
 * @Author shenguang
 * @Version 1.0
 **/
public class ErNode<T> {
    public int iNode;
    public T vaule;
    public ErNode<T> leftNode;
    public ErNode<T> rightNode;

    public ErNode(int iNode, T vaule) {
        this.iNode = iNode;
        this.vaule = vaule;
    }



    public int getiNode() {
        return iNode;
    }

    public void setiNode(int iNode) {
        this.iNode = iNode;
    }

    public T getVaule() {
        return vaule;
    }

    public void setVaule(T vaule) {
        this.vaule = vaule;
    }

    public ErNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(ErNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public ErNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(ErNode<T> rightNode) {
        this.rightNode = rightNode;
    }
    @Override
    public String toString() {
        return "ErNode{" +
                "iNode=" + iNode +
                ", vaule=" + vaule +
                '}';
    }
}
