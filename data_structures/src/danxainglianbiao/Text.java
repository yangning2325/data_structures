package danxainglianbiao;

public class Text {

	public static void main(String[] args) {
		Hero h1=new Hero(1,"宋江" , "及时雨");
		Hero h2=new Hero(2,"卢俊义" , "玉麒麟");
		Hero h3=new Hero(3,"吴用" ,"智多星" );
		Hero h4=new Hero(4,"林冲" , "豹子头");
		List list=new List();
		list.add2(h2);
		list.add2(h4);
		list.add2(h1);
		list.add2(h3);
		list.list();
		list.reverprinf(list.head);
		
	}

}
