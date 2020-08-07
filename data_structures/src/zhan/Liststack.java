package zhan;

//定义链表节点
public class Liststack {
	int num;
	Liststack next; // 表示链表的下一个节点

	public Liststack(int num) {
		this.num = num;
	}

	public String toString() {
		return "Liststack [num=" + num + "]";
	}
}
//定义栈
class Stack1 {
	int max; // 栈的最大容量
	int i = 0; // 标志此时元素在栈中的位置
 
	public Stack1(int max) {
		this.max = max;
	}

	Liststack head = new Liststack(0); // 链表的头节点

	public void add(Liststack l) {
		Liststack temp = head; // 定义临时变量指向头节点
		if (i == max) {
			System.out.println("栈已经满了");
			return;
		}
		while (true) {
			if (temp.next == null) { // 遍历到链表最后
				break;
			}
			temp = temp.next; // 后移
		}
		i++;
		temp.next = l;
	}

	public void pop() {
		Liststack temp = head;
		if (temp == null) {
			System.out.println("栈已经空了！");
			return;
		}
		while (true) {
			if (temp.next.next == null) { // 已经遍历到链表的最后；
				break;
			}
			temp = temp.next;
		}
		System.out.println(temp.next + "已出栈");
		temp.next = null;
	}

	public void show() {
		Liststack temp = head.next;
		if (temp == null) {
			System.out.println("栈已经空了!");
			return;
		}
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}
}
