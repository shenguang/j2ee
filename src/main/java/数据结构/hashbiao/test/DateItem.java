package 数据结构.hashbiao.test;

/**
 * @className DateItem
 * @Description
 * @Date 2019/7/10 11:40
 * @Author shenguang
 * @Version 1.0
 **/
public class DateItem<T> {
    public int key;
    public T value;

    public DateItem(int key, T value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DateItem{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
