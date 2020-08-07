package danxainglianbiao;


//定义一个Hero类，每个Hero对象就是一个节点
public class Hero {
	public int no;
	public String name;
	public String nickname;
	public Hero next;		//指向下一个节点
	
	//构造器
	public Hero(int no, String name, String nickname) {
		super();
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	//重写toString 方法
	public String toString() {
		return "Hero [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
}

	
	
	
	
