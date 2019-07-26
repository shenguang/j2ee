package 数据结构.lianbiao;

/**
 * @Auther: shenguang
 * @Date: 2018/10/25 18:58
 * @Description:
 */
public class LinkList {
	private Link frist;

	public Link addFrist(String key, String value) {
		Link link = new Link(key, value);
		link.next = frist;
		frist = link;
		return link;
	}

	public Link deleteFrist() throws Exception {
		if (isEmpty()) {
			throw new Exception("该链表已经为空，删除失败！");
		}
		Link temp = frist.next;
		frist = temp;
		return temp;
	}

	public String get(String key) {
		Link current = frist;
		while (!key.equals(current.key)) {
			if (null == current.next) {
				return null;
			} else {
				current = current.next;
			}
		}
		return current.value;
	}

	public void delete(String key) {
		Link current = frist;
		Link pervious = frist;
		while (!key.equals(current.key)) {
			if (null == current.next) {
				return;
			} else {
				pervious = current;
				current = current.next;
			}
		}
		if (current == frist) {
			frist = frist.next;
		} else {
			pervious.next = current.next;
		}
	}

	public void displayList() {
		System.out.println("from frist --> list");
		Link current = frist;
		while (null != current) {
			current.display();
			current = current.next;
		}
	}

	public boolean isEmpty() {
		return (frist == null);
	}

}
