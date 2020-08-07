package hashtable;

public class Hashtable {
private Link[] links;
private int size;
public Hashtable(int size) {
	this.size=size;
	links=new Link[size];
	//初始化每个链表；
	for (int i = 0; i < size; i++) {
		links[i]=new Link();
	}
}
//添加成员
public void add(Empy empy) {
	int empynum=hashfun(empy.id);
	//将empy添加到对应的链表
	links[empynum].add(empy);
}
//遍历所有链表
public void list() {
	for (int i = 0; i < size; i++) {
		links[i].list(i);
	}
}
//编写哈希函数
public int hashfun(int id) {
	return id%size;
}

//查找员工
public void findbyd( int id) {
	int empynum=hashfun(id);
	Empy empy=links[empynum].findbyId(id);
	if (empy!=null) {//找到
		System.out.printf("在第%d条链表找到员工id=%d\n",(empynum+1),id);
	}else {
		System.out.println("没有找到");
	}
}
}
