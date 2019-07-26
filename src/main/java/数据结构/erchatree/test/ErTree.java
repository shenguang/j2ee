package 数据结构.erchatree.test;

/**
 * @className ErTree
 * @Description
 * @Date 2019/7/15 14:14
 * @Author shenguang
 * @Version 1.0
 **/
public class ErTree<T> {
    private ErNode<T> root;

    public ErTree(ErNode<T> root) {
        this.root = root;
    }

    public ErNode<T> get(int iNode) {
        ErNode<T> tErNode = find(iNode, root);
        if(iNode!=tErNode.getiNode()){
            return null;
        }
        return tErNode;
    }

    public void insert(ErNode<T> erNode){
        ErNode<T> tErNode = find(erNode.getiNode(), root);
        if(erNode.iNode == tErNode.getiNode()){
            tErNode.setVaule(erNode.getVaule());
            return;
        }
        if(erNode.iNode>tErNode.getiNode()){
            tErNode.setRightNode(erNode);
            return;
        }
        if(erNode.iNode<tErNode.getiNode()){
            tErNode.setLeftNode(erNode);
            return;
        }
    }




    public ErNode<T> find(int iNode,ErNode<T> erNode){
        int rNode = erNode.iNode;
        if(rNode==iNode){
            return erNode;
        }
        if(rNode<iNode){
            if( null == erNode.getLeftNode()){
                return erNode.getLeftNode();
            }
            return find(iNode,erNode.getLeftNode());
        }
        if(rNode>iNode){
            if( null==erNode.getRightNode()){
                return erNode.getRightNode();
            }
            return find(iNode,erNode.getRightNode());
        }
        return null;
    }


}
