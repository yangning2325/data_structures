package danxainglianbiao;

public class Main {

	public static void main(String[] args) {
		//先创建节点；
		Hero h1=new Hero(1,"宋江" , "及时雨");
		Hero h2=new Hero(2,"卢俊义" , "玉麒麟");
		Hero h3=new Hero(3,"吴用" ,"智多星" );
		Hero h4=new Hero(4,"林冲" , "豹子头");
		//创建链表
		List list=new List();
		//加入
//		list.add(h1);
//		list.add(h2);
//		list.add(h3);
//		list.add(h4);
		list.add2(h2);
		list.add2(h4);
		list.add2(h1);
		list.add2(h3);
		list.list();
		System.out.println("这是修改后的链表~~~");
		Hero h=new Hero(3,"小吴" ,"智多星~~~" );
		list.updata(h);
		list.list();
//		System.out.println("这是删除后的链表~~~~");
		list.del(1);
		list.del(2);
		list.del(3);
		list.del(4);
		list.list();
		list.find(3);
		list.num(list.head);
	}

}
