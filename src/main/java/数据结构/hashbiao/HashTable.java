package 数据结构.hashbiao;

/**
 * 线性探测的hash表
 * @Auther: shenguang
 * @Date: 2018/11/21 15:29
 * @Description:
 */
public class HashTable {
	private DataItem[] hashArray;
	private int arraySize;
	private int itemNum;
	private DataItem nonItem;//用于删除项

	public HashTable() {
		arraySize=6;
		itemNum=0;
		hashArray= new DataItem[arraySize];
		nonItem = new DataItem(-1,null);
	}
	public boolean isFull(){
		return itemNum==arraySize;
	}
	public boolean isEmpty(){
		return itemNum==0;
	}
	public void displayTable(){
		System.out.println("table:");
		for(int j=0;j<arraySize;j++){
			if(null!=hashArray[j]){
				System.out.println("display:==>"+hashArray[j]);
			}
		}
	}
	public int hashFunction(int key){
		return key % arraySize;
	}
	public void insert(DataItem dataItem){
		if(isFull()){
			System.out.println("表满了,需要扩展");
			extendHashTable();
		}
		int key = dataItem.getKey();
		int hashkey = hashFunction(key);
		while (null!=hashArray[hashkey] && hashArray[hashkey].getKey()!=-1){
			if(hashArray[hashkey].getKey()==key){
				break;
			}
			hashkey++;
			hashkey %= arraySize;
		}
		hashArray[hashkey]=dataItem;
		itemNum++;
	}
	public void extendHashTable(){
		int num = arraySize;
		itemNum=0;
		arraySize *=2;
		DataItem[] oldHashArray = hashArray;
		hashArray = new DataItem[arraySize];
		for (int i=0;i<num;i++){
			insert(oldHashArray[i]);
		}
	}
	public void delete(int key){
		if (isEmpty()){
			System.out.println("表为空，删除无效");
			return;
		}
		int hashkey = hashFunction(key);
		while(null != hashArray[hashkey] && hashArray[hashkey].getKey() != -1 && hashArray[hashkey].getKey()!=key){
			hashkey++;
			hashkey %= arraySize;
		}
		if(null==hashArray[hashkey]){
			System.out.println("该项不存在");
			return;
		}
		hashArray[hashkey]=null;
		itemNum--;
	}
	public DataItem get(int key){
		int hashkey = hashFunction(key);
		while (null!=hashArray[hashkey]){
			if(hashArray[hashkey].getKey()==key){
				return hashArray[hashkey];
			}
			hashkey++;
			hashkey %= arraySize;
		}
		return  null;
	}

	public static void main(String[] args) {
		HashTable hashTable = new HashTable();
		DataItem dataItem1 = new DataItem(1,"frist");
		DataItem dataItem2 = new DataItem(2,"two");
		DataItem dataItem3 = new DataItem(3,"three");
		DataItem dataItem4 = new DataItem(4,"four");
		DataItem dataItem5 = new DataItem(5,"five");
		DataItem dataItem6 = new DataItem(6,"six");
		DataItem dataItem7 = new DataItem(7,"seven");

		hashTable.insert(dataItem1);
		hashTable.insert(dataItem2);
		hashTable.insert(dataItem3);
		hashTable.insert(dataItem4);
		hashTable.insert(dataItem5);
		hashTable.insert(dataItem6);
		hashTable.insert(dataItem7);
		hashTable.displayTable();
		System.out.println(hashTable.get(1));
		System.out.println(hashTable.get(7));
	}
}
class DataItem{
	int key;
	String vule;

	public DataItem(int key, String vule) {
		this.key = key;
		this.vule = vule;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getVule() {
		return vule;
	}

	public void setVule(String vule) {
		this.vule = vule;
	}

	@Override
	public String toString() {
		return "DataItem{" +
		       "key=" + key +
		       ", vule='" + vule + '\'' +
		       '}';
	}
}