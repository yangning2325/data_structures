package hashtable;

public class Link {
	private Empy head;
	
	public void add(Empy empy) {
		//添加第一个员工
		if (head==null) {
			head=empy;
			return;
		}
		//不是第一个则需要辅助指针定位到最后；
		Empy temp=head;
		while (true) {
			if (temp.next==null) {//表明到最后
				break;
			}
			temp=temp.next;//后移
		}
		//退出时直接将emp，加入链表
		temp.next=empy;
	}
	public void list(int no) {
		if (head==null) {
			System.out.println("第"+(no+1)+"条链表为空");
			return;
		}
		System.out.print("第"+(no+1)+"链表信息为");
		Empy temp=head;
		while (true) {
			System.out.printf("---> id=%d  name=%s\t",temp.id,temp.name);
			if (temp.next==null) {
				break;
			}
			temp=temp.next;
		}
		System.out.println();
	}
	//根据id查找
	public Empy findbyId(int id) {
		if (head==null) {
			System.out.println("链表为空");
			return null;
		}
		Empy temp=head;
		while (true) {
			if (temp.id==id) {//找到
				break; //这时temp就是要找的员工
			}
			//退出
			if (temp.next==null) {
				temp=null;
				break;
			}
			temp=temp.next;
		}
		return temp;
	}
}
