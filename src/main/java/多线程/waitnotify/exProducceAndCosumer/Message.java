package 多线程.waitnotify.exProducceAndCosumer;

/**
 * @className Message
 * @Description
 * @Date 2019/8/16 10:17
 * @Author shenguang
 * @Version 1.0
 **/
public class Message {
    private String content;
    private String who;

    public Message(String content, String who) {
        this.content = content;
        this.who = who;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", who='" + who + '\'' +
                '}';
    }
}
