package 多线程.MyThreadLocal.threadLocalPratten;

/**
 * @className Context
 * @Description
 * @Date 2019/8/15 15:45
 * @Author shenguang
 * @Version 1.0
 **/
public class Context {
    private String name;
    private String cardId;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }

    @Override
    public String toString() {
        return "Context{" +
                "name='" + name + '\'' +
                ", cardId='" + cardId + '\'' +
                '}';
    }
}
