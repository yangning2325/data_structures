package duilie;

public class Ways {
	private int max;
	private int rear;
	private int front;
	private int[] arre;
	//创建队列构造器；
	public Ways(int maxsize) {
		
		max = maxsize;	//队列最大容量；
		rear = -1;				//列头；
		front = -1;			//列尾；
		arre =new int[max]; 	//用数组模拟队列；
	}
	//判断队列是否已满；
	public boolean full() {
		return rear==max-1;
	}
	//判断队列是否为空；
	public boolean empty() {
		return rear==front;
	}
	//往队列加数据；
	public void add(int n) {
		if (full()) {
			System.out.println("队列已满！！");
			return;
		}
		rear++;
		arre[rear]=n;
	}
	//取队列
	public int get() {
		if (empty()) {
			throw new RuntimeException("队列早已经空了！！！");
		}
		front++;
		return arre[front];
	}
	//显示队列的所有数据；
	public void show() {
		if (empty()) {
			System.out.println("亲，队列是空队列！");
			return;
		}
		for (int i = 0; i < arre.length; i++) {
			System.out.printf("arre[%d]=%d\n",i,arre[i]);
		}
	}
	//显示队列的头数据；
	public int head() {
		if (empty()) {
			throw new RuntimeException("队列早已经空了！！！");
		}
		return arre[front+1];
	}
}








