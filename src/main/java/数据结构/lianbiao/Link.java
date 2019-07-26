package 数据结构.lianbiao;

/**
 * @Auther: shenguang
 * @Date: 2018/10/25 19:00
 * @Description: 节点
 */
public class Link {
	public String key;
	public String value;
	public Link next ;

	public Link(String key, String value) {
		this.key = key;
		this.value = value;
	}
	public void display(){
		System.out.println("Link{" +
		                   "key='" + key + '\'' +
		                   ", value='" + value + '\'' +
		                   '}');
	}
	@Override
	public String toString() {
		return "Link{" +
		       "key='" + key + '\'' +
		       ", value='" + value + '\'' +
		       ", next=" + next +
		       '}';
	}
}
