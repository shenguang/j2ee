package 数据结构.hashbiao.test;

/**
 * @className HashForm
 * @Description
 * @Date 2019/7/10 11:36
 * @Author shenguang
 * @Version 1.0
 **/
public class HashForm<T> {
    private DateItem<T>[] dateItems;
    private int size;
    private int itemNum = 0;

    public HashForm(int size){
        this.size = size;
        dateItems = new DateItem[size];
    }
    public HashForm(){
        this.size = 6;
        dateItems = new DateItem[size];
    }
    public void insert(DateItem<T> dateItem){
        if(isFull()){
            extendSize();
        }
        int hashKey = hashFunction(dateItem.getKey());
        while (null!=dateItems[hashKey]){
            if(dateItems[hashKey].getKey()==dateItem.getKey()){
                break;
            }
            hashKey++;
            hashKey =hashFunction(hashKey);
        }
        if(null == dateItems[hashKey] || dateItems[hashKey].getKey()!=dateItem.getKey()){
            itemNum++;
        }
        dateItems[hashKey]=dateItem;
    }
    public T get(int key){
        int hashkey = hashFunction(key);
        while (dateItems[hashkey].getKey()!=key){
            hashkey++;
            hashkey = hashFunction(hashkey);
        }
        return dateItems[hashkey].getValue();
    }

    public void delete(int key){
        int hashkey = hashFunction(key);
        while (dateItems[hashkey].getKey()!=key){
            hashkey++;
            hashkey = hashFunction(hashkey);
        }
        dateItems[hashkey]=null;
    }


    private void extendSize(){
        this.size = this.size*2;
        DateItem<T>[] oldDateItems = dateItems;
        dateItems = new DateItem[size];
        for(int i=0 ;i<oldDateItems.length;i++){
            insert(oldDateItems[i]);;
        }
    }

    private int hashFunction(int key){
        return  key%=size;
    }


    public boolean isFull(){
        if(itemNum == size){
            return true;
        }
        return false;
    }
    public boolean isEmpty(){
        if(itemNum == 0 || dateItems.length<=0){
            return true;
        }
        return false;
    }
    public void display(){
        for (int i = 0 ;i<size;i++){
            System.out.println(dateItems[i]);
        }
    }

    public static void main(String[] args) {
        HashForm<String> hashForm  = new HashForm<>();
        DateItem<String> dateItem1 = new DateItem<>(1,"shenguang1");
        DateItem<String> dateItem2 = new DateItem<>(9,"shenguang2");
        DateItem<String> dateItem3 = new DateItem<>(10,"shenguang3");
        DateItem<String> dateItem4 = new DateItem<>(11,"shenguang4");
        DateItem<String> dateItem5 = new DateItem<>(3,"shenguang5");
        DateItem<String> dateItem6 = new DateItem<>(12,"shenguang6");
        DateItem<String> dateItem7 = new DateItem<>(13,"shenguang7");
        hashForm.insert(dateItem1);
        hashForm.insert(dateItem2);
        hashForm.insert(dateItem3);
        hashForm.insert(dateItem4);
        hashForm.insert(dateItem5);
        hashForm.insert(dateItem6);
        hashForm.insert(dateItem7);

        System.out.println(hashForm.get(10));
        hashForm.delete(10);

        hashForm.display();
    }


}
