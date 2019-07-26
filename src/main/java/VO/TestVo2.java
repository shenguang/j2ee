package VO;

/**
 * @Auther: shenguang
 * @Date: 2018/9/30 10:20
 * @Description:
 */
public class TestVo2 {

	String name;
	String pass;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "TestVo{" +
		       "name='" + name + '\'' +
		       ", pass='" + pass + '\'' +
		       '}';
	}
}
